/* *****************************************************************************
 * Class: InterfazApp.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;
import controlador.ControladorFiguras;
import controlador.ControladorJugadores;

/**
 * Clase que representa la ventana principal de la aplicación.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class InterfazApp extends JFrame {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /**
     * Versión de la aplicación.
     */
    private static final long serialVersionUID = 1L;

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Panel Titulo.
     */
    private final PanelTitulo pnlTitulo;

    /**
     * Panel Información Juego.
     */
    private final PanelInformacionJuego pnlInformacion;

    /**
     * Panel Juego (Tablero).
     */
    private final PanelJuego pnlJuego;

    /**
     * Panel Opciones Juego.
     */
    private final PanelOpcionesJuego pnlOpcionesJuego;

    /**
     * Controlador principla de la aplicaci�n.
     */
    private final Controlador ctrl;

    /**
     * Controlador Figuras Geometricas.
     */
    private final ControladorFiguras ctrlFigura;

    /**
     * Controlador Jugadores.
     */
    private final ControladorJugadores ctrlJugadores;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye la ventana principal de la aplicacion.
     *
     * @throws Exception
     */
    public InterfazApp() throws Exception {
        ctrl = new Controlador();
        ctrlFigura = new ControladorFiguras();
        ctrlJugadores = new ControladorJugadores();
        this.setTitle("Tic-Tac-Toc");
        this.setLayout(new BorderLayout());

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new BorderLayout());

        pnlTitulo = new PanelTitulo();
        pnlInformacion = new PanelInformacionJuego();

        pnlNorte.add(pnlTitulo, BorderLayout.NORTH);
        pnlNorte.add(pnlInformacion, BorderLayout.CENTER);

        pnlJuego = new PanelJuego(ctrl);

        pnlOpcionesJuego = new PanelOpcionesJuego(ctrl, ctrlJugadores, ctrlFigura);

        this.getContentPane().add(pnlNorte, BorderLayout.NORTH);
        this.getContentPane().add(pnlJuego, BorderLayout.CENTER);
        this.getContentPane().add(pnlOpcionesJuego, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(452, 475);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        ctrl.conectar(pnlInformacion, pnlOpcionesJuego, pnlJuego);
        ctrl.reiniciarJuego();
        ctrlJugadores.importarLista("./data/jugadores.data");
        ctrlFigura.importarFiguras("./data/figuras.data");
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Metodo principal de la aplicación.
     *
     * @param args No son necesarios.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        InterfazApp aplicacion = new InterfazApp();
        aplicacion.setVisible(true);
    }
}
