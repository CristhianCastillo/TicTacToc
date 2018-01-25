/* *****************************************************************************
 * Class: ControladorFiguras.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package controlador;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import modelo.figura.FiguraGeometrica;
import modelo.figura.ListaFiguras;

/**
 * Clase que representa el controlador de las Figuras geometricas.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class ControladorFiguras {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Lista de figuras geometricas.
     */
    private final ListaFiguras lista;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye el controlador.
     */
    public ControladorFiguras() {
        lista = new ListaFiguras();
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Importa las figuras geometricas.
     *
     * @param ruta Ruta del archivo de propiedades.
     * @throws Exception
     */
    public void importarFiguras(String ruta) throws Exception {
        try {
            Properties archivo = new Properties();
            try (FileInputStream datos = new FileInputStream(ruta)) 
            {
                archivo.load(datos);
                
                int numeroFiguras = Integer.parseInt(archivo.getProperty("figuras.cantidad"));
                
                if (numeroFiguras <= 0) {
                    throw new Exception("El numero de figuras geometricas debe ser mayor a cero.");
                }
                
                for (int i = 1; i <= numeroFiguras; i++) {
                    String nombre = archivo.getProperty("figura" + i + ".nombre");
                    String rutaFigura = archivo.getProperty("figura" + i + ".ruta");
                    
                    if (nombre == null) {
                        throw new Exception("Falta definir la propiedad figura" + i + ".nombre");
                    }
                    if (rutaFigura == null) {
                        throw new Exception("Falta definir la propiedad figura" + i + ".ruta");
                    }
                    
                    if (nombre.trim().equals("")) {
                        throw new Exception("La propiedad figura" + i + ".nombre no puede estar vacia.");
                    }
                    if (rutaFigura.trim().equals("")) {
                        throw new Exception("La propiedad figura" + i + ".ruta no puede estar vacia.");
                    }
                    
                    FiguraGeometrica figura = new FiguraGeometrica(nombre, rutaFigura);
                    this.lista.agregarFigura(figura);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * Agrega una nueva figura gometrica.
     *
     * @param nombreFigura Nombre de la figura geometrica. nombreFigura != null
     * && nombreFigura != "".
     * @param rutaFigura Ruta de la imagen de la figura. rutaFigura != null &&
     * rutaFigura != "".
     */
    public void agregarFigura(String nombreFigura, String rutaFigura) {
        FiguraGeometrica figura = new FiguraGeometrica(nombreFigura, rutaFigura);
        lista.agregarFigura(figura);
    }

    /**
     * Obtiene la lista de las figuras geometricas.
     *
     * @return Lista de figuras geometricas.
     */
    public ArrayList<FiguraGeometrica> obtenerFiguras() {
        return lista.getFiguras();
    }

    /**
     * Gestiona el proceso de busqueda de una figura geometrica en la lista por
     * nombre.
     *
     * @param nombreFigura Nombre figura geoemtrica. nombreFigura != null &&
     * nombreFigura != "".
     * @return Posición donde se encontro la figura geometrica.
     */
    public int consultarFigura(String nombreFigura) {
        return lista.consultarFigura(nombreFigura);
    }

    /**
     * Gestiona el proceso para actualizar el nombre de una figura geometrica.
     *
     * @param index Indice donde se encuentra la figura seleccionada para
     * actualizar.
     * @param nuevoNombre Nuevo nombre de la figura seleccionada. nuevoNombre !=
     * null && nuevoNombre != "".
     */
    public void actualizarFigura(int index, String nuevoNombre) {
        lista.actualizarNombreFigura(index, nuevoNombre);
    }

    /**
     * Gestiona el proceso para eliminar una figura geometrica.
     *
     * @param index Indice donde se encuentra la figura geometrica a eliminar.
     */
    public void eliminarFigura(int index) {
        lista.eliminarFigura(index);
    }

}
