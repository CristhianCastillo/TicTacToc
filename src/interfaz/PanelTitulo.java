/* *****************************************************************************
 * Class: PanelTitulo.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import java.awt.BorderLayout;
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

/**
 * Clase que representa el Panel que contiene la imagen decorativa de la
 * aplicación.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class PanelTitulo extends JPanel {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /**
     * Versión de la aplicación.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante que indica la altura quedebe tener la imagen del titulo.
     */
    public static final int ALTURA = 90;

    /**
     * Constante que indica el ancho que debe tener la imagen del titulo.
     */
    public static final int ANCHO = 100;

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Etiqueta Imagen Decorativa.
     */
    private final JLabel lblImagen;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el panel Titulo.
     *
     * @throws IOException
     */
    public PanelTitulo() throws IOException {
        this.setLayout(new BorderLayout());

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new FlowLayout());

        lblImagen = new JLabel();
        lblImagen.setMaximumSize(new Dimension(100, 50));
        lblImagen.setMinimumSize(new Dimension(100, 50));

        String ruta = "data/TituloTresLineas.png";
        BufferedImage bImgen = ImageIO.read(new File(ruta));
        Image laImagen = bImgen.getScaledInstance((int) (ANCHO * 0.85), (int) (ALTURA * 0.85), Image.SCALE_AREA_AVERAGING);
        ImageIcon imagen = new ImageIcon(laImagen);

        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setIcon(imagen);

        pnlCentro.add(lblImagen);
        this.add(pnlCentro, BorderLayout.CENTER);
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
}
