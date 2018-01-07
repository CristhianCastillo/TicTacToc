/**
 *
 */
package modelo.figura;

import java.util.ArrayList;

/**
 * Clase que representa el contenedor de las figuras geometricas.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class ListaFiguras {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Lista de figuras.
     */
    private final ArrayList<FiguraGeometrica> listaFiguras;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye la lista de figuras.
     */
    public ListaFiguras() {
        listaFiguras = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    /**
     * Agrega una figura geometrica a la lista.
     *
     * @param figura Figura Geometrica.
     */
    public void agregarFigura(FiguraGeometrica figura) {
        this.listaFiguras.add(figura);
    }

    /**
     * Retorna la lista de figuras geometricas.
     *
     * @return Lista de figuras geometricas.
     */
    public ArrayList<FiguraGeometrica> getFiguras() {
        return listaFiguras;
    }
}
