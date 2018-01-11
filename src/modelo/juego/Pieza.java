/* *****************************************************************************
 * Class: Pieza.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package modelo.juego;

/**
 * Clase que representa una pieza del tablero.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class Pieza {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante utilizada para validar la disponibilidad de una pieza.
     */
    public static final int LIBRE = 0;

    /**
     * Constante utilizada para indicar el valor de la posición.
     */
    public static final int X = 1;

    /**
     * Constante utilizada para indicar el valor de la posición.
     */
    public static final int O = 2;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Estado de la pieza.
     */
    private int estado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye una nueva pieza.
     *
     * @param estado
     */
    public Pieza(int estado) {
        this.estado = estado;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    /**
     * Retorna el estado actual de esta pieza.
     *
     * @return Estadp actual de la pieza.
     */
    public int getEstado() {
        return this.estado;
    }

    /**
     * Actualiza el estado de la pieza.
     *
     * @param estado Estado de la pieza. estado == 0 || estado == 1 || estado ==
     * 2.
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
