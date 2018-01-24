/* *****************************************************************************
 * Class: PanelOpcionesJuego.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import controlador.ControladorFiguras;
import controlador.ControladorJugadores;

/**
 * Clase que representa el Panel que muestra las opciones de juego.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class PanelOpcionesJuego extends JPanel implements ActionListener {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /**
     * Version de la aplicación.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando enviado por el boton Nuevo juego.
     */
    public static final String NUEVO_JUEGO = "Nuevo Juego";

    /**
     * Comando enviado por el boton Jugadores.
     */
    public static final String JUGADORES = "Jugadores";
    
    /**
     * Comando enviado por el boton Figuras.
     */
    public static final String FIGURAS_GEOMETRICAS = "Figuras Geometricas";

    /**
     * Comando enviado por el boton Contra Maquina.
     */
    public static final String JUGAR_MAQUINA = "Juegar contra maquina";

    /**
     * Comando enviado por el boton Interconexión.
     */
    public static final String INTERCONEXION = "Juegar interconexion";

    /**
     * Comando enviado por el boton Mejores puntajes.
     */
    public static final String MEJORES_PUNTAJES = "Mejores Puntajes";
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Boton nuevo juego.
     */
    private final JButton btnNuevoJuego;

    /**
     * Boton Jugadores.
     */
    private final JButton btnJugadores;
    
    /**
     * Boton Figuras.
     */
    private final JButton btnFiguras;

    /**
     * Boton Jugar contra maquina.
     */
    private final JButton btnMaquina;

    /**
     * Boton Interconexion.
     */
    private final JButton btnInterconexion;

    /**
     * Boton Mejores Puntajes.
     */
    private final JButton btnMejoresPuntajes;

    /**
     * Controlador de Jugadores.
     */
    private final ControladorJugadores ctrlJugadores;

    /**
     * Controlador de Figuras.
     */
    private final ControladorFiguras ctrlFiguras;

    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el panel Opciones de Juego.
     *
     * @param ctrl Controlador principal de la aplicación.
     * @param ctrlJugadores Controlador Jugadores.
     * @param ctrlFiguras Controlador Figuras geometricas.
     */
    public PanelOpcionesJuego(Controlador ctrl, ControladorJugadores ctrlJugadores, ControladorFiguras ctrlFiguras) {
        this.ctrl = ctrl;
        this.ctrlJugadores = ctrlJugadores;
        this.ctrlFiguras = ctrlFiguras;

        this.setBorder(new TitledBorder("Opciones de juego"));
        GroupLayout grupo = new GroupLayout(this);
        this.setLayout(grupo);

        //Creación de componentes.
        btnNuevoJuego = new JButton("Nuevo juego");
        btnNuevoJuego.setActionCommand(NUEVO_JUEGO);
        btnNuevoJuego.addActionListener((ActionListener) this);

        btnJugadores = new JButton("Jugadores");
        btnJugadores.setActionCommand(JUGADORES);
        btnJugadores.addActionListener((ActionListener) this);
        
        btnFiguras = new JButton("Figuras");
        btnFiguras.setActionCommand(FIGURAS_GEOMETRICAS);
        btnFiguras.addActionListener((ActionListener) this);

        btnMaquina = new JButton("Contra Maquina");
        btnMaquina.setActionCommand(JUGAR_MAQUINA);
        btnMaquina.addActionListener((ActionListener) this);

        btnInterconexion = new JButton("Interconexión");
        btnInterconexion.setActionCommand(INTERCONEXION);
        btnInterconexion.addActionListener((ActionListener) this);

        btnMejoresPuntajes = new JButton("Mejores Puntajes");
        btnMejoresPuntajes.setActionCommand(MEJORES_PUNTAJES);
        btnMejoresPuntajes.addActionListener((ActionListener) this);

        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);

        //Set Horizontal
        grupo.setHorizontalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(btnNuevoJuego)
                        .addComponent(btnInterconexion)
                )
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(btnJugadores)
                        .addComponent(btnMejoresPuntajes)
                )
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(btnFiguras)
                        .addComponent(btnMaquina)
                )
        );

        //Boton del mismo tamanioo.
        grupo.linkSize(SwingConstants.HORIZONTAL, btnNuevoJuego, btnJugadores, btnMaquina, btnInterconexion, btnMejoresPuntajes, btnFiguras);

        //Set Vertical
        grupo.setVerticalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(btnNuevoJuego)
                        .addComponent(btnJugadores)
                        .addComponent(btnFiguras)
                )
                .addGroup(grupo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(btnInterconexion)
                        .addComponent(btnMejoresPuntajes)
                        .addComponent(btnMaquina)
                )
        );
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Metodo que escucha los eventos de los botones.
     *
     * @param e Comando ejecutado por el boton. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals(NUEVO_JUEGO)) {
            DialogoIniciarJuego nuevoJuego = new DialogoIniciarJuego(ctrl, ctrlJugadores.obtenerJugadores(), ctrlFiguras.obtenerFiguras());
            nuevoJuego.setModal(true);
            nuevoJuego.setVisible(true);

        }
        else
        {
            if(comando.equals(JUGADORES))
            {
                DialogoJugadores configuracionJugadores = new DialogoJugadores(ctrlJugadores);
                configuracionJugadores.setModal(true);
                configuracionJugadores.setVisible(true);
            }
            else
            {
                if(comando.equalsIgnoreCase(FIGURAS_GEOMETRICAS))
                {
                    DialogoFigurasGeometricas configuracionFiguras = new DialogoFigurasGeometricas(ctrlFiguras);
                    configuracionFiguras.setModal(true);
                    configuracionFiguras.setVisible(true);
                }
                else
                {
                    if(comando.equalsIgnoreCase(MEJORES_PUNTAJES))
                    {
                        DialogoMejoresPuntajes mejoresJugadores = new DialogoMejoresPuntajes();
                        mejoresJugadores.actualizarTabla(ctrlJugadores.promediarJugadores());
                        mejoresJugadores.setModal(true);
                        mejoresJugadores.setVisible(true);
                    }
                }
            }
        }
    }

    /**
     * Bloquea todos los botones de la interfaz ya que se ha iniciado una nueva
     * partida.
     */
    public void iniciarJuego() {
        btnNuevoJuego.setEnabled(false);
        btnJugadores.setEnabled(false);
        btnFiguras.setEnabled(false);

        btnInterconexion.setEnabled(false);
        btnMejoresPuntajes.setEnabled(false);
        btnMaquina.setEnabled(false);   
    }

    /**
     * Desbloquea todos los botones de la interfaz ya que se ha finalizado una
     * partida.
     */
    public void finalizarJuego() {
        btnNuevoJuego.setEnabled(true);
        btnJugadores.setEnabled(true);
        btnFiguras.setEnabled(true);

        btnInterconexion.setEnabled(true);
        btnMejoresPuntajes.setEnabled(true);
        btnMaquina.setEnabled(true);   
    }
}
