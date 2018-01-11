/* *****************************************************************************
 * Class: PanelJuego.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

/**
 * Clase que representa el tablero de juego.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class PanelJuego extends JPanel implements ActionListener {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // ********************************************
    // Fila 0
    // ********************************************
    /**
     * Versión de la aplicacion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando enviado por el boton el la posicion 0,0.
     */
    public static final String BOTON_0_0 = "0 - 0";

    /**
     * Comando enviado por el boton el la posicion 0,1.
     */
    public static final String BOTON_0_1 = "0 - 1";

    /**
     * Comando enviado por el boton en la posicion 0,2.
     */
    public static final String BOTON_0_2 = "0 - 2";

    // ********************************************
    // Fila 1
    // ********************************************
    /**
     * Comando enviado por el boton en la posicion 1,0.
     */
    public static final String BOTON_1_0 = "1 - 0";

    /**
     * Comando enviado por el boton en la posicion 1,1.
     */
    public static final String BOTON_1_1 = "1 - 1";

    /**
     * Comando enviado por el boton en la posicion 1,2.
     */
    public static final String BOTON_1_2 = "1 - 2";

    // ********************************************
    // Fila 2
    // ********************************************
    /**
     * Comando enviado por el boton en la posicion 2,0.
     */
    public static final String BOTON_2_0 = "2 - 0";

    /**
     * Comando enviado por el boton en la posicion 2,1.
     */
    public static final String BOTON_2_1 = "2 - 1";

    /**
     * Comando enviado por el boton en la posicion 2,2.
     */
    public static final String BOTON_2_2 = "2 - 2";

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Boton 00.
     */
    private final JButton btn00;

    /**
     * Boton 01.
     */
    private final JButton btn01;

    /**
     * Boton 02.
     */
    private final JButton btn02;

    /**
     * Boton 10.
     */
    private final JButton btn10;

    /**
     * Botom 11.
     */
    private final JButton btn11;

    /**
     * Boton 12.
     */
    private final JButton btn12;

    /**
     * Boton 20.
     */
    private final JButton btn20;

    /**
     * Boton 21.
     */
    private final JButton btn21;

    /**
     * Boton 22.
     */
    private final JButton btn22;

    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el tablero de juego.
     *
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelJuego(Controlador ctrl) {
        this.ctrl = ctrl;
        this.setBorder(new EmptyBorder(10, 130, 10, 130));
        this.setLayout(new GridLayout(3, 3, 5, 5));

        //Fila 1.
        btn00 = new JButton();
        btn00.setActionCommand(BOTON_0_0);
        btn00.addActionListener((ActionListener) this);

        btn01 = new JButton();
        btn01.setActionCommand(BOTON_0_1);
        btn01.addActionListener((ActionListener) this);

        btn02 = new JButton();
        btn02.setActionCommand(BOTON_0_2);
        btn02.addActionListener((ActionListener) this);

        //Fila 2.
        btn10 = new JButton();
        btn10.setActionCommand(BOTON_1_0);
        btn10.addActionListener((ActionListener) this);

        btn11 = new JButton();
        btn11.setActionCommand(BOTON_1_1);
        btn11.addActionListener((ActionListener) this);

        btn12 = new JButton();
        btn12.setActionCommand(BOTON_1_2);
        btn12.addActionListener((ActionListener) this);

        //Fila 3.
        btn20 = new JButton();
        btn20.setActionCommand(BOTON_2_0);
        btn20.addActionListener((ActionListener) this);

        btn21 = new JButton();
        btn21.setActionCommand(BOTON_2_1);
        btn21.addActionListener((ActionListener) this);

        btn22 = new JButton();
        btn22.setActionCommand(BOTON_2_2);
        btn22.addActionListener((ActionListener) this);

        this.add(btn00);
        this.add(btn01);
        this.add(btn02);

        this.add(btn10);
        this.add(btn11);
        this.add(btn12);

        this.add(btn20);
        this.add(btn21);
        this.add(btn22);
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Metodo que escucha los eventos generados por los botones.
     *
     * @param e comando generado por le boton. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            switch (comando) {
                // --------------------------
                // Fila 1
                // --------------------------
                case BOTON_0_0:
                    if (btn00.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta00 = ctrl.obtenerImagen();
                    ImageIcon imageIcon00 = new ImageIcon(new ImageIcon(ruta00).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn00.setIcon(imageIcon00);
                    ctrl.validarJugada(0, 0);
                    break;

                case BOTON_0_1:
                    if (btn01.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta01 = ctrl.obtenerImagen();
                    ImageIcon imageIcon01 = new ImageIcon(new ImageIcon(ruta01).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn01.setIcon(imageIcon01);
                    ctrl.validarJugada(0, 1);
                    break;

                case BOTON_0_2:
                    if (btn02.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta02 = ctrl.obtenerImagen();
                    ImageIcon imageIcon02 = new ImageIcon(new ImageIcon(ruta02).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn02.setIcon(imageIcon02);
                    ctrl.validarJugada(0, 2);
                    break;

                // --------------------------
                // Fila 2
                // --------------------------
                case BOTON_1_0:
                    if (btn10.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta10 = ctrl.obtenerImagen();
                    ImageIcon imageIcon10 = new ImageIcon(new ImageIcon(ruta10).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn10.setIcon(imageIcon10);
                    ctrl.validarJugada(1, 0);
                    break;

                case BOTON_1_1:
                    if (btn11.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta11 = ctrl.obtenerImagen();
                    ImageIcon imageIcon11 = new ImageIcon(new ImageIcon(ruta11).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn11.setIcon(imageIcon11);
                    ctrl.validarJugada(1, 1);
                    break;

                case BOTON_1_2:
                    if (btn12.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta12 = ctrl.obtenerImagen();
                    ImageIcon imageIcon12 = new ImageIcon(new ImageIcon(ruta12).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn12.setIcon(imageIcon12);
                    ctrl.validarJugada(1, 2);
                    break;

                // --------------------------
                // Fila 3
                // --------------------------
                case BOTON_2_0:
                    if (btn20.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta20 = ctrl.obtenerImagen();
                    ImageIcon imageIcon20 = new ImageIcon(new ImageIcon(ruta20).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn20.setIcon(imageIcon20);
                    ctrl.validarJugada(2, 0);
                    break;

                case BOTON_2_1:
                    if (btn21.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta21 = ctrl.obtenerImagen();
                    ImageIcon imageIcon21 = new ImageIcon(new ImageIcon(ruta21).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn21.setIcon(imageIcon21);
                    ctrl.validarJugada(2, 1);
                    break;

                case BOTON_2_2:
                    if (btn22.getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                    }
                    String ruta22 = ctrl.obtenerImagen();
                    ImageIcon imageIcon22 = new ImageIcon(new ImageIcon(ruta22).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    btn22.setIcon(imageIcon22);
                    ctrl.validarJugada(2, 2);
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Tres Lineas", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Actualiza el mensaje de salida de una partida.
     *
     * @param mensaje Mensaje de salida.
     */
    public void actualizarGanador(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Tres Lineas", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <p>
     * Limpia el tableo: Elimina las imagenes de los botones Los pones quedan
     * bloqueados hasta que se inicie una nueva partida.</p>
     */
    public void reiniciarTablero() {
        btn00.setEnabled(false);
        btn00.setIcon(null);
        btn01.setEnabled(false);
        btn01.setIcon(null);
        btn02.setEnabled(false);
        btn02.setIcon(null);

        btn10.setEnabled(false);
        btn10.setIcon(null);
        btn11.setEnabled(false);
        btn11.setIcon(null);
        btn12.setEnabled(false);
        btn12.setIcon(null);

        btn20.setEnabled(false);
        btn20.setIcon(null);
        btn21.setEnabled(false);
        btn21.setIcon(null);
        btn22.setEnabled(false);
        btn22.setIcon(null);
    }

    /**
     * Activa el tablero para disputar una nueva partida.
     */
    public void prepararTablero() {
        btn00.setEnabled(true);
        btn01.setEnabled(true);
        btn02.setEnabled(true);
        btn10.setEnabled(true);
        btn11.setEnabled(true);
        btn12.setEnabled(true);
        btn20.setEnabled(true);
        btn21.setEnabled(true);
        btn22.setEnabled(true);
    }
}
