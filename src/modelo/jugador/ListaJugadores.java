/* *****************************************************************************
 * Class: ListaJugadores.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package modelo.jugador;

import java.util.ArrayList;

/**
 * Clase que representa los jugadores disponibles.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class ListaJugadores {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Lista de jugadores.
     */
    private final ArrayList<Jugador> grupoJugadores;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye la lista de jugadores.
     */
    public ListaJugadores() {
        grupoJugadores = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Agrega un nuevo jugador a la lista.
     *
     * @param jugador Jugador para agregar a la lista.
     */
    public void agregarJugador(Jugador jugador) {
        grupoJugadores.add(jugador);
    }

    /**
     * Retorna la lista de jugadores.
     *
     * @return Lista de jugadores.
     */
    public ArrayList<Jugador> getJugadores() {
        return grupoJugadores;
    }
    
    /**
     * Consulta el nombre de un jugador y retorna la posicion donde se
     * encuentra si existe.
     * @param nombreJugador Nombre del jugador. nombreJugador != null &&
     * nombreJugador != "".
     * @return Posición donde se encuentra el jugador.
     */
    public int consultarJugador(String nombreJugador)    
    {
        int posicion = -1;
        for ( int i = 0; i < grupoJugadores.size(); i ++)
        {
            Jugador jugadorTemp = grupoJugadores.get(i);
            if(jugadorTemp.getNombre().equalsIgnoreCase(nombreJugador))
                return i;
        }
        return posicion;
    }
    
    /**
     * Cambia el nombre de un jugador.
     * @param index Posicion donde se encuentra el jugador.
     * @param nombreJugador  Nuevo nombre del jugador. nombreJugador != null && 
     *  nombreJugador != "".
     */
    public void cambiarNombreJugador(int index, String nombreJugador)
    {
        this.grupoJugadores.get(index).setNombre(nombreJugador);
    }
    
    /**
     * Elimina un jugador de la lista.
     * @param index Posicion del jugador en la lista.
     */
    public void eliminarJugador(int index)
    {
        this.grupoJugadores.remove(index);
    }

}
