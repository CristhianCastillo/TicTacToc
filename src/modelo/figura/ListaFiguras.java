/* *****************************************************************************
 * Class: ListaFigura.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
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
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Lista de figuras.
     */
    private final ArrayList<FiguraGeometrica> listaFiguras;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye la lista de figuras.
     */
    public ListaFiguras() {
        listaFiguras = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
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
    
    /**
     * Consulta una figura geometrica por nombre.
     * @param nombreFigura Nombre de la figura geometrica. nombreFigura != null
     * && nombreFigura != "".
     * @return 
     */
    public int consultarFigura(String nombreFigura)
    {
        for(int i = 0; i < listaFiguras.size(); i ++)
        {
            String nombreFiguraTemp = listaFiguras.get(i).getNombreFigura();
            if(nombreFiguraTemp.equalsIgnoreCase(nombreFigura))
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Actualiza el nombre de una figura geometrica de la lista.
     * @param index Indice donde se encuentra la figura seleccionada.
     * @param nuevoNombre Nuevo nombre de la figura. nuevoNombre != null &&
     * nuevoNombre != "".
     */
    public void actualizarNombreFigura(int index, String nuevoNombre)
    {
        listaFiguras.get(index).setNombreFigura(nuevoNombre);
    }
    
    /**
     * Eliminar una figura geometrica de la lista.
     * @param index Posicion donde sen encuentra la figura geometrica.
     */
    public void eliminarFigura(int index)
    {
        listaFiguras.remove(index);
    }
}
