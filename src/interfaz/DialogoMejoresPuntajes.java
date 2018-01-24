/* *****************************************************************************
 * Class: DialogoMejoresPuntajes.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.jugador.Jugador;

/**
 * Clase que representa el dialogo de los mejores puntajes de los jugadores.  
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class DialogoMejoresPuntajes extends JDialog
{
    // -------------------------------------------------------------------------
    //  Constants
    // -------------------------------------------------------------------------
    
    /**
     * Constante que representa los encabezados de la tabla.
     */
    public static final String [] COLUMNAS = {"Jugador", "Promedio Juego"};
    
    // -------------------------------------------------------------------------
    //  Attributes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  GUI attributes
    // -------------------------------------------------------------------------

    /**
     * Tabla que muetra los mejores puntajes de los jugadores de la aplicaciòn.
     */
    private final JTable tablaMejoresPuntajes;
    
    // -------------------------------------------------------------------------
    //  Builders
    // -------------------------------------------------------------------------
    
    /**
     * Construye el dialogo Mejores puntajes.
     */
    public DialogoMejoresPuntajes()
    {
        this.setTitle("Mejores Puntajes");
        GroupLayout grupo = new GroupLayout(this.getContentPane());
        this.setLayout(grupo);
        
        //Creación de los componentes.
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        tablaMejoresPuntajes = new JTable(modelo);
        tablaMejoresPuntajes.setColumnSelectionAllowed(false);
        tablaMejoresPuntajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMejoresPuntajes.setFont(new Font("Arial", Font.BOLD, 12));
        tablaMejoresPuntajes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaMejoresPuntajes.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tablaMejoresPuntajes);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(scroll)
                )
        );
        
        //Set Vertical
        grupo.setVerticalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(scroll)
                )
        );
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(440,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }        
        
    // -------------------------------------------------------------------------
    //  Functional methods
    // -------------------------------------------------------------------------
    
    /**
     * Actualiza la tabla de los mejores puntajes del juego.
     * @param listaJugadores Lista con los jugadores ordenados de mayor a menor 
     * promedio obtenido en el juego.
     */
    public void actualizarTabla(ArrayList<Jugador> listaJugadores)
    {
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        for (int i = 0; i < listaJugadores.size(); i ++)
        {
            Jugador jugador = listaJugadores.get(i);
            String [] campos = new String [2];
            campos[0] = jugador.getNombre();
            campos[1] = jugador.getPromedioJugador() + "";
            modelo.addRow(campos);
        }
        tablaMejoresPuntajes.setModel(modelo);
    }
}
