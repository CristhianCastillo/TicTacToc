/* *****************************************************************************
 * Class: FiguraGeometrica.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package modelo.figura;

/**
 * Clase que representa una figura geometrica.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class FiguraGeometrica {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre de la figura geometrica.
     */
    private String nombreFigura;

    /**
     * Ruta de la imagen que representa la figura.
     */
    private String ruta;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye una figura geometrica.
     *
     * @param pNombreFigura Nombre de la figura. pNombreFigura != null &&
     * pNombreFigura != "".
     * @param pRuta Ruta de imagen de la figura. pRuta != null && pRuta != "".
     */
    public FiguraGeometrica(String pNombreFigura, String pRuta) {
        this.nombreFigura = pNombreFigura;
        this.ruta = pRuta;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    /**
     * Retorna el nombre de la figura.
     *
     * @return Nombre de la figura.
     */
    public String getNombreFigura() {
        return nombreFigura;
    }

    /**
     * Actualiza el nombre de la figura.
     *
     * @param nombreFigura Nombre de la figura.
     */
    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    /**
     * Retorna la ruta de la imagen.
     *
     * @return Ruta de la imagen.
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Actualiza la ruta de la imagen.
     *
     * @param ruta Ruta de la imagen.
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Representacion de una Figura Geometrica.
     * @return Nombre de la figura geometrica.
     */
    @Override
    public String toString() {
        return this.nombreFigura;
    }

}
