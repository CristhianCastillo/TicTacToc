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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 * Clase que representa la ventana principal de la aplicación.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class InterfazApp extends JFrame implements WindowListener {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /**
     * Versión de la aplicación.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Ruta del archivo de propiedades de los jugadores.
     */
    public static final String ARCHIVO_JUGADORES = "./data/jugadores.data";
    
    /**
     * Ruta del archivo de propiedades de las figuras.
     */
    public static final String ARCHIVO_FIGURAS = "./data/figuras.data";

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
        this.addWindowListener(this);
        
        try
        {
            ctrl.conectar(pnlInformacion, pnlOpcionesJuego, pnlJuego);
            ctrl.reiniciarJuego();
            ctrlJugadores.importarLista(ARCHIVO_JUGADORES);
            ctrlFigura.importarFiguras(ARCHIVO_FIGURAS);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Cargando propiedades", JOptionPane.ERROR_MESSAGE);
        }   
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

    @Override
    public void windowOpened(WindowEvent e) {}
    
    /**
     * Metodo que se ejecuta cuando se esta cerrando el formulario.
     * <br>
     * Inicializa el proceso de actualizar el archivo de propiedades de los 
     * jugadores e imagenes de la aplicación.
     * <br>
     * @param e Evento generado por la ventana principal de la aplicación. e!= null.
     */
    @Override
    public void windowClosing(WindowEvent e) 
    {
        try {
            ctrlJugadores.actualizarArchivoPropiedades(ARCHIVO_JUGADORES);
            ctrlFigura.actualizarArchivoPropiedades(ARCHIVO_FIGURAS);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Actualizar Jugadores", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}
