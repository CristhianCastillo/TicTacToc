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
    
    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Matriz de botones que se mostran el el tablero de juego.
     */
    private final JButton [][] arregloBotones = new JButton[3][3];
    
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

        for(int i = 0; i < arregloBotones.length; i ++)
        {
            for(int j = 0; j < arregloBotones[i].length; j ++)
            {
                JButton btnTemp = new JButton();
                btnTemp.setActionCommand(i + " - " + j);
                btnTemp.addActionListener((ActionListener)this);
                arregloBotones[i][j] = btnTemp;
                this.add(btnTemp);
            }
        }
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
            for(int i = 0; i < arregloBotones.length; i ++)
            {
                for(int j = 0; j < arregloBotones[i].length; j ++)
                {
                    if(arregloBotones[i][j].getActionCommand().equalsIgnoreCase(comando))
                    {
                        if (arregloBotones[i][j].getIcon() != null) {
                        throw new Exception("Esta casilla ya ha sido seleccionada!");
                        }
                        String rutaij = ctrl.obtenerImagen();
                        ImageIcon imageIconij = new ImageIcon(new ImageIcon(rutaij).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                        arregloBotones[i][j].setIcon(imageIconij);
                        ctrl.validarJugada(i, j);
                    }
                }
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
     * Limpia el tableo: Elimina las imagenes de los botones. Los botones quedan
     * bloqueados hasta que se inicie una nueva partida.</p>
     */
    public void reiniciarTablero() {
        for (JButton[] arreglo1 : arregloBotones) {
            for (JButton arreglo11 : arreglo1) {
                arreglo11.setEnabled(false);
                arreglo11.setIcon(null);
            }
        }
    }

    /**
     * Activa el tablero para disputar una nueva partida.
     */
    public void prepararTablero() {
        for (JButton[] arreglo1 : arregloBotones) {
            for (JButton arreglo11 : arreglo1) {
                arreglo11.setEnabled(true);
            }
        }
    }
    
    /**
     * Valida la disponibilidad de una posición en el tablero.
     * @param i Fila seleccionada. i >= 0.
     * @param j Columna seleccionada. j >= 0.
     * @return true: Si la posicion esta disponible. false: Si la
     * posición no esta disponible.
     */
    public boolean validarDisponibilidadPosicion(int i, int j)
    {
        return arregloBotones[i][j].getIcon()== null;
    }
    
    /**
     * Actualiza el icono de un boton seleccionado por el computador.
     * @param i Fila seleccionada.
     * @param j Columna seleccionada.
     */
    public void movimientoMaquina(int i, int j)
    {
        String rutaij = ctrl.obtenerImagen();
        ImageIcon imageIconij = new ImageIcon(new ImageIcon(rutaij).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        arregloBotones[i][j].setIcon(imageIconij);
        ctrl.validarJugada(i, j);
    }
}
