/**
 *
 */
package modelo.jugador;

import modelo.figura.FiguraGeometrica;

/**
 * Clase que representa un jugador.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class Jugador {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Nombre del jugador.
     */
    private String nombre;

    /**
     * Numero de partidas ganadas por el jugador.
     */
    private int partidasGanadas;

    /**
     * Numero de partidas empatadas por el jugador.
     */
    private int partidasEmpatadas;

    /**
     * Numero de partidas perdidas por el jugador.
     */
    private int partidasPerdidas;

    /**
     * Figura seleccionda por el jugador.
     */
    private FiguraGeometrica figura;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye un nuevo jugador.
     *
     * @param pNombre Nombre del jugador. pNombre != null && pNombre != "".
     * @param pPartidasGanadas Partidas ganadas por el jugador. pPartidasGanadas
     * >= 0.
     * @param pPartidasEmpatadas Partidas empatadas por el jugador.
     * pPartidasEmpatadas >= 0.
     * @param pPartidasPerdidas Partidas perdidas por el jugador.
     * pPartidasPerdidas >= 0.
     */
    public Jugador(String pNombre, int pPartidasGanadas, int pPartidasEmpatadas, int pPartidasPerdidas) {
        this.nombre = pNombre;
        this.partidasGanadas = pPartidasGanadas;
        this.partidasEmpatadas = pPartidasEmpatadas;
        this.partidasPerdidas = pPartidasPerdidas;
        this.figura = null;
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Obtiene le nombre del jugador.
     *
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del jugador.
     *
     * @param nombre Nombre del jugador. nombre != null && nombre != "".
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el numero de partidas ganadas por un jugador.
     *
     * @return Numero de partidas ganadas por el jugador.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Actualiza el numero de partidas ganadas por un jugador.
     *
     * @param partidasGanadas Numero de partidasganadas por el jugador.
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Obtiene el numero de partidas empatadas por un jugador.
     *
     * @return Numero de partidas empatadas por un jugador.
     */
    public int getPartidasEmpatadas() {
        return partidasEmpatadas;
    }

    /**
     * Actualiza el numero de partidas empatadas por un jugador.
     *
     * @param partidasEmpatadas Numero de partidas empatadas por un jugador.
     */
    public void setPartidasEmpatadas(int partidasEmpatadas) {
        this.partidasEmpatadas = partidasEmpatadas;
    }

    /**
     * Obtiene el numero de partidas perdidas por un jugador.
     *
     * @return Numero de partidas perdidas por un jugador.
     */
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    /**
     * Actualiza el numero de partidas perdidas por un jugador.
     *
     * @param partidasPerdidas Numero de partidas perdidas por un jugador.
     */
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    /**
     * Obtiene la figura geometrica seleccionada por el jugador para disputar
     * una partida.
     *
     * @return FiguraGeometrica.
     */
    public FiguraGeometrica getFigura() {
        return figura;
    }

    /**
     * Actualiza la figura geometrica seleccionada por un jugador.
     *
     * @param figura Figura geometrica. figura != null.
     */
    public void setFigura(FiguraGeometrica figura) {
        this.figura = figura;
    }

    /**
     * Representacion de un jugador.
     * Metodo sobreEscrito. Se muestra el nombre
     * del jugador. Este sera desplegador en el ComboBox para disputar una
     * partida.
     * @return Nombre del jugador.
     */
    @Override
    public String toString() {
        return this.nombre;
    }

}
