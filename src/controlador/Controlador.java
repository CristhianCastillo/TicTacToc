/* *****************************************************************************
 * Class: Controlador.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package controlador;

import java.util.LinkedList;
import java.util.Queue;

import interfaz.PanelInformacionJuego;
import interfaz.PanelJuego;
import interfaz.PanelOpcionesJuego;
import modelo.juego.Pieza;
import modelo.juego.Tablero;
import modelo.jugador.Jugador;

/**
 * Clase que representa el Controlador principal del juego.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class Controlador {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Tablero principla del juego.
     */
    private final Tablero tresLineas;

    /**
     * Turno del juego.
     */
    private int turno;

    /**
     * Numero de jugada.
     */
    private int numeroJugada;

    /**
     * Numero de movimientos en el juego.
     */
    private int movimiento;

    /**
     * Numero total de movimientos.
     */
    private int numeroMovimiento;

    /**
     * Jugador con el turno.
     */
    private Jugador jugadorActual;

    /**
     * Alamacena los dos juagadores de la partida.
     */
    private Queue<Jugador> colaDeTurno;

    /**
     * Panel Información Juego.
     */
    private PanelInformacionJuego pnlInformacionJuego;

    /**
     * Panel Opciones juego.
     */
    private PanelOpcionesJuego pnlOpcionesJuego;

    /**
     * Panel Juego.
     */
    private PanelJuego pnlJuego;
    
    /**
     * Dificultad seleccionada por el jugador.
     */
    private int dificultad;
    
    /**
     * Validación si se juega contra la computadora o contra otro jugador.
     */
    private boolean computadora;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el controlador e inicializa el tablero.
     */
    public Controlador() {
        tresLineas = new Tablero();
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Conecta los paneles y el controlador.
     *
     * @param pnlInformacionJuego Panel Información Juego. pnlInformacionJuego
     * != null.
     * @param pnlOpcionesJuego Panel Opciones Juego. pnlOpcionesJuego != null.
     * @param pnlJuego Panel Juego. pnlJuego != null.
     */
    public void conectar(PanelInformacionJuego pnlInformacionJuego, PanelOpcionesJuego pnlOpcionesJuego, PanelJuego pnlJuego) {
        this.pnlInformacionJuego = pnlInformacionJuego;
        this.pnlOpcionesJuego = pnlOpcionesJuego;
        this.pnlJuego = pnlJuego;
    }

    /**
     * Inicializa las variables y contenedores necesarias para la ejecucion de
     * una partida
     *
     * @param jugadorUno Primero jugador. jugadorUno != null.
     * @param jugadorDos Segundo jugador. jugadorDos != null.
     * @throws Exception
     */
    public void iniciarJuego(Jugador jugadorUno, Jugador jugadorDos) throws Exception {
        numeroMovimiento = 0;
        tresLineas.inicializarTablero();
        jugadorActual = null;
        movimiento = 0;
        numeroJugada = 0;
        turno = 0;

        colaDeTurno = new LinkedList<>();

        int aleatorio = (int) (Math.random() * 2 + 1);

        if (aleatorio == 1) {
            colaDeTurno.add(jugadorUno);
            colaDeTurno.add(jugadorDos);
        } else {
            if (aleatorio == 2) {
                colaDeTurno.add(jugadorDos);
                colaDeTurno.add(jugadorUno);
            } else {
                throw new Exception("No se ha podido iniciar el juego.");
            }
        }
        pnlJuego.prepararTablero();
        pnlOpcionesJuego.iniciarJuego();
        cambiarTurno();
    }
    
    /**
     * Inicializa la dificultad seleccionada por el usuario.
     * Indica que la partida se disputara entre un jugador y la computadora.
     * @param dificultad Disficultad seleccionada por el jugador.
     */
    public void prepararJuegoComputadora(int dificultad)
    {
        this.dificultad = dificultad;
        this.computadora = true;
    }
    
    /**
     * Indica que la partida se disputara entre usuarios.
     * La dificultad se cambia a un valor no disponible para seleccionar por
     * parte de un usuario.
     */
    public void prepararJuegoUsuarios()
    {
        this.dificultad = 0;
        this.computadora = false;
    }

    /**
     * Reinicia los componentes de los paneles.
     */
    public void reiniciarJuego() {
        pnlJuego.reiniciarTablero();
        pnlOpcionesJuego.finalizarJuego();
        pnlInformacionJuego.reiniciar();
    }

    /**
     * Obtiene la imagen de la figura correspondiente al jugador que posee el
     * turno.
     *
     * @return Ruta de la imagen.
     */
    public String obtenerImagen() {
        return jugadorActual.getFigura().getRuta();
    }

    /**
     * Gestiona y valida el cambio de turno para el siguiente jugador.
     */
    public void cambiarTurno() {
        jugadorActual = colaDeTurno.poll();
        colaDeTurno.add(jugadorActual);

        switch (turno) {
            case Pieza.LIBRE:
                turno = Pieza.O;
                break;
            case Pieza.O:
                turno = Pieza.X;
                break;
            case Pieza.X:
                turno = Pieza.O;
                break;
            default:
                break;
        }
        pnlInformacionJuego.cambiarTurno(jugadorActual.getFigura().getRuta(), jugadorActual.getNombre());
        if(computadora && jugadorActual.getNombre().equalsIgnoreCase(Jugador.NOMBRE_COMPUTADOR))
            realizarMovimientoMaquina();
    }
    
    /**
     * Valida la dificultad seleccionada por el usuario e implementa el
     * algoritmo necesario para generar un movimiento.
     */
    public void realizarMovimientoMaquina()
    {
        switch(dificultad)
        {
            case 1:
                int fila = (int) (Math.random() * 3 + 0);
                int columna = (int) (Math.random() * 3 + 0);
                while(!pnlJuego.validarDisponibilidadPosicion(fila, columna))
                {
                    fila = (int) (Math.random() * 3 + 0);
                    columna = (int) (Math.random()* 3 + 0);
                }
                pnlJuego.movimientoMaquina(fila, columna);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    /**
     * Valida la jugada realizada por un jugador.
     * <p>
     * Para la validacion de una jugada realizada por un jugador se gestiona
     * mediente coordenadas.</p>
     *
     * @param x Posición en fila.
     * @param y Posición en columnas.
     */
    public void validarJugada(int x, int y) {
        numeroMovimiento++;
        movimiento++;
        if (movimiento == 1) {
            numeroJugada++;
        } else {
            if (movimiento == 2) {
                movimiento = 0;
            }
        }
        tresLineas.actualizarPosicion(x, y, turno);

        if (numeroJugada >= 3) {
            boolean gano = tresLineas.validarGanador(x, y);
            if (gano) {
                //Jugador ganador.
                String jugadorGanador = jugadorActual.getNombre();
                jugadorActual.incrementarPartidasGanadas();
                jugadorActual.actualizarPromedio();
                //Jugador perdedor.
                jugadorActual = colaDeTurno.poll();
                jugadorActual.incrementarPartidasPerdidas();
                jugadorActual.actualizarPromedio();
                pnlJuego.actualizarGanador(jugadorGanador + " ha ganado!");
                reiniciarJuego();
            } else {
                if (numeroMovimiento == 9) {
                    //Jugador con el turno
                    String jugadorUno = jugadorActual.getNombre();
                    jugadorActual.incrementarPartidasEmpatadas();

                    //Jugador en espera
                    jugadorActual = colaDeTurno.poll();
                    String jugadorDos = jugadorActual.getNombre();
                    jugadorActual.incrementarPartidasEmpatadas();

                    pnlJuego.actualizarGanador("Ha sido un empate entre " + jugadorUno + " y " + jugadorDos);
                    reiniciarJuego();
                } else {
                    cambiarTurno();
                }
            }
        } else {
            if (numeroMovimiento == 9) {
                //Jugador con el turno
                String jugadorUno = jugadorActual.getNombre();
                jugadorActual.incrementarPartidasEmpatadas();
                //Jugador en espera
                jugadorActual = colaDeTurno.poll();
                String jugadorDos = jugadorActual.getNombre();
                jugadorActual.incrementarPartidasEmpatadas();
                pnlJuego.actualizarGanador("Ha sido un empate entre " + jugadorUno + " y " + jugadorDos);
                reiniciarJuego();
            } else {
                cambiarTurno();
            }
        }
    }
}
