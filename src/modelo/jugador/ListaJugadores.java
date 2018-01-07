/**
 *
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

}
