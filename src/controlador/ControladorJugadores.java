/**
 *
 */
package controlador;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import modelo.jugador.Jugador;
import modelo.jugador.ListaJugadores;

/**
 * Clase que representa el Controaldor para los jugadores.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class ControladorJugadores {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Lista de los jugadores.
     */
    private final ListaJugadores jugadores;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el controlador encargado de gestionar los jugadores.
     */
    public ControladorJugadores() {
        jugadores = new ListaJugadores();
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Leer e importa la lista de jugadores.
     *
     * @param ruta Ruta del archivo de propiedades.
     * @throws Exception
     */
    public void importarLista(String ruta) throws Exception {
        try {
            Properties archivo = new Properties();
            FileInputStream datos = new FileInputStream(ruta);
            archivo.load(datos);

            int numeroJugadores = Integer.parseInt(archivo.getProperty("numeroJugadores"));
            if (numeroJugadores < 0) {
                throw new Exception("El numero de jugadores debe ser positivo.");
            }

            for (int i = 1; i <= numeroJugadores; i++) {
                String nombreJugador = archivo.getProperty("jugador" + i + ".nombre");
                String partidasGanadasStr = archivo.getProperty("jugador" + i + ".partidasGanadas");
                String partidasEmpatadasStr = archivo.getProperty("jugador" + i + ".partidasEmpatadas");
                String partidasPerdidasStr = archivo.getProperty("jugador" + i + ".partidasPerdidas");

                if (nombreJugador == null) {
                    throw new Exception("Falta definir la propiedad jugador" + i + ".nombre");
                }
                if (partidasGanadasStr == null) {
                    throw new Exception("Falta definir la propiedad jugador" + i + ".partidasGanadas");
                }
                if (partidasEmpatadasStr == null) {
                    throw new Exception("Falta definir la propiedad jugador" + i + ".partidasEmpatadas");
                }
                if (partidasPerdidasStr == null) {
                    throw new Exception("Falta definir la propiedad jugador" + i + ".partidasPerdidas");
                }

                if (nombreJugador.trim().equalsIgnoreCase("")) {
                    throw new Exception("La propiedad jugador" + i + ".nombre no puede estar vacia.");
                }
                if (partidasGanadasStr.trim().equalsIgnoreCase("")) {
                    throw new Exception("La propiedad jugador" + i + ".partidasGanadas no puede estar vacia.");
                }
                if (partidasEmpatadasStr.trim().equalsIgnoreCase("")) {
                    throw new Exception("La propiedad jugador" + i + ".partidasEmpatadas no puede estar vacia");
                }
                if (partidasPerdidasStr.trim().equalsIgnoreCase("")) {
                    throw new Exception("La propiedad jugador" + i + ".partidasPerdidas no puede estar vacia.");
                }

                int numeroPartidasGanadas = Integer.parseInt(partidasGanadasStr);
                if (numeroPartidasGanadas < 0) {
                    throw new Exception("La propiedad jugador" + i + ".partidasGabadas debe ser un numero positivo.");
                }

                int numeroPartidasEmpatadas = Integer.parseInt(partidasEmpatadasStr);
                if (numeroPartidasEmpatadas < 0) {
                    throw new Exception("La propiedad jugador" + i + ".partidasEmpatadas debe ser un numero positivo.");
                }

                int numeroPartidasPerdidas = Integer.parseInt(partidasPerdidasStr);
                if (numeroPartidasPerdidas < 0) {
                    throw new Exception("La propiedad jugador" + i + ".partidasPerdidas debe ser un numero positivo.");
                }

                Jugador jugador = new Jugador(nombreJugador, numeroPartidasGanadas, numeroPartidasEmpatadas, numeroPartidasEmpatadas);
                this.jugadores.agregarJugador(jugador);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * Obtiene la lista de los jugadores.
     *
     * @return Lista de jugadores.
     */
    public ArrayList<Jugador> obtenerJugadores() {
        return jugadores.getJugadores();
    }
}
