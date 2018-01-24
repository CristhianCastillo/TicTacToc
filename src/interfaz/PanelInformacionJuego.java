/* *****************************************************************************
 * Class: PanelInformacionJuego.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Clase que representa el Panel con la información
 *
 * @author Cristhian Castillo
 *
 */
public class PanelInformacionJuego extends JPanel {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /**
     * Constante que indica la altura maxima de la imagen del turno.
     */
    public static final int ALTURA = 50;

    /**
     * Constante que indica el ancho maximo de la imagen del turno.
     */
    public static final int ANCHO = 50;

    /**
     * Buffer que muestra el estado actual de la aplicación.
     */
    public static final String BUFFER = "Listo para inicar juego!";

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Version de la aplicación.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Etiqueta turno.
     */
    private final JLabel lblTurno;

    /**
     * Etiqueta que representa la imagen del turno.
     */
    private final JLabel lblImagenTurno;

    /**
     * Etiqueta que representa el buffer de salida de la aplicación.
     */
    private final JLabel lblBuffer;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el panel Información Juego.
     *
     * @throws IOException
     */
    public PanelInformacionJuego() throws IOException {
        this.setLayout(new FlowLayout());

        lblTurno = new JLabel("Turno:");
        lblTurno.setHorizontalAlignment(SwingConstants.LEFT);

        String ruta = "data/vacia.jpg";
        BufferedImage bImgen = ImageIO.read(new File(ruta));
        Image laImagen = bImgen.getScaledInstance((int) (ANCHO * 0.85), (int) (ALTURA * 0.85), Image.SCALE_AREA_AVERAGING);
        ImageIcon imagen = new ImageIcon(laImagen);

        lblImagenTurno = new JLabel(imagen);
        lblImagenTurno.setMaximumSize(new Dimension(50, 50));
        lblImagenTurno.setMinimumSize(new Dimension(50, 50));
        lblImagenTurno.setBorder(new LineBorder(Color.BLACK, 1));

        lblBuffer = new JLabel(BUFFER);

        this.add(lblTurno);
        this.add(lblImagenTurno);
        this.add(lblBuffer);
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Actualiza la imagen del turno actual.
     *
     * @param ruta Ruta de la imagen. ruta != null && ruta != "".
     * @param nombreJugador Nombre del jugador con el turno disponible.
     * nombreJugador != null.
     */
    public void cambiarTurno(String ruta, String nombreJugador) {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        lblImagenTurno.setIcon(imageIcon);
        lblBuffer.setText("Juega: " + nombreJugador);
    }

    /**
     * Reinicia los componentes del panel.
     */
    public void reiniciar() {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/vacia.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        lblImagenTurno.setIcon(imageIcon);
        lblBuffer.setText(BUFFER);
    }

}
