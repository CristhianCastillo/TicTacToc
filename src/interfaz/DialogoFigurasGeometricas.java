/* *****************************************************************************
 * Class: DialogoFigurasGeometricas.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import controlador.ControladorFiguras;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.figura.FiguraGeometrica;

/**
 * Clase que representa el Dialogo para gestionar las configuraciones de las
 * figuras geometricas de la aplicación.
 * 
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class DialogoFigurasGeometricas extends JDialog implements ActionListener, MouseListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Comando enviado por el boton Agregar figura.
     */
    public static final String AGREGAR_FIGURA = "Agregar figura";
    
    /**
     * Comando enviado por el boton seleccionar figura.
     */
    public static final String SELECCIONAR_FIGURA = "Seleccionar figura";
    
    /**
     * Comando enviado por el boton actualizar figura.
     */
    public static final String ACTUALIZAR_FIGURA = "Actualizar figura";
    
    /**
     * Comando enviado por el boton eliminar figura.
     */
    public static final String ELIMINAR_FIGURA = "Eliminar figura";
    
    /**
     * Titulos de las columnas de la tabla.
     */
    public static final String [] COLUMNAS = {"Nombre figura", "Ruta"};
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    /**
     * Etiqueta nombre de la figura geometrica.
     */
    private JLabel lblNombreFigura;
    
    /**
     * Etiqueta ruta de la imagen de la figura geometrica.
     */
    private JLabel lblRutaFigura;
    
    /**
     * Etiqueta figura geomtrica seleccionada.
     */
    private JLabel lblFiguraSeleccionada;
    
    /**
     * Campo de texto Nombre figura geometrica.
     */
    private JTextField txtNombreFigura;
    
    /**
     * Campo de texto Ruta de la imagen de la figura geometrica.
     */
    private JTextField txtRutaFigura;
    
    /**
     * Campo de texto Figura geometrica seleccionada.
     */
    private JTextField txtFiguraSeleccionada;
    
    /**
     * Boton Agregar figura geometrica.
     */
    private JButton btnAgregarFigura;
    
    /**
     * Boton Seleccionar figura geometrica.
     */
    private JButton btnSeleccionarFigura;
    
    /**
     * Boton Actualizar figura geomtrica.
     */
    private JButton btnActualizarFigura;
    
    /**
     * Boton Eliminar figura geometrica.
     */
    private JButton btnEliminarFigura;
    
    /**
     * Tabla para las figuras geometricas.
     */
    private JTable tabla;
    
    /**
     * Controlador figuras.
     */
    private ControladorFiguras ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye la ventana para mostrar las figuras geomtricas actuales.
     * @param ctrl Controlador figuras.
     */
    public DialogoFigurasGeometricas(ControladorFiguras ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("Configuración figuras geometricas");
        this.setLayout(new BorderLayout());
        
        //Creación componentes.
        lblNombreFigura = new JLabel("Nombre figura: ");
        lblRutaFigura = new JLabel ("Ruta de la imagen: ");
        lblFiguraSeleccionada = new JLabel("Imagen seleccionada: ");
        
        txtNombreFigura = new JTextField();
        txtRutaFigura = new JTextField();
        txtRutaFigura.setEditable(false);
        txtFiguraSeleccionada = new JTextField(25);
        txtFiguraSeleccionada.setEditable(false);
        
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS,0);
        tabla = new JTable(modelo);
        tabla.setColumnSelectionAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setFont(new Font("Arial", Font.BOLD, 12));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener((MouseListener)this);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabla);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        btnAgregarFigura = new JButton("Agregar figura");
        btnAgregarFigura.setActionCommand(AGREGAR_FIGURA);
        btnAgregarFigura.addActionListener((ActionListener)this);
        
        btnSeleccionarFigura = new JButton("Seleccionar imagen");
        btnSeleccionarFigura.setActionCommand(SELECCIONAR_FIGURA);
        btnSeleccionarFigura.addActionListener((ActionListener)this);
        
        btnActualizarFigura = new JButton("Actualizar figura");
        btnActualizarFigura.setActionCommand(ACTUALIZAR_FIGURA);
        btnActualizarFigura.addActionListener((ActionListener)this);
        
        btnEliminarFigura = new JButton("Eliminar figura");
        btnEliminarFigura.setActionCommand(ELIMINAR_FIGURA);
        btnEliminarFigura.addActionListener((ActionListener)this);
        
        JPanel pnlCargarImagen = new JPanel();
        pnlCargarImagen.setLayout(new GridLayout(1,2));
        
        pnlCargarImagen.add(txtRutaFigura);
        pnlCargarImagen.add(btnSeleccionarFigura);
        
        JPanel pnlNorte = new JPanel();
        GroupLayout grupoNorte = new GroupLayout(pnlNorte);
        pnlNorte.setLayout(grupoNorte);
        
        grupoNorte.setAutoCreateContainerGaps(true);
        grupoNorte.setAutoCreateGaps(true);
        
        grupoNorte.setHorizontalGroup(grupoNorte.createSequentialGroup()
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(lblNombreFigura)
                        .addComponent(lblRutaFigura)
                )
                
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(txtNombreFigura)
                        .addComponent(pnlCargarImagen)
                        .addComponent(btnAgregarFigura, GroupLayout.Alignment.TRAILING)
                )
        );
        
        grupoNorte.setVerticalGroup(grupoNorte.createSequentialGroup()
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(lblNombreFigura)
                        .addComponent(txtNombreFigura)
                )
                
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(lblRutaFigura)
                        .addComponent(pnlCargarImagen)
                )
                
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(btnAgregarFigura)
                )
        );
        
        JPanel pnlFiguraSeleccionada = new  JPanel();
        pnlFiguraSeleccionada.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        pnlFiguraSeleccionada.add(lblFiguraSeleccionada);
        pnlFiguraSeleccionada.add(txtFiguraSeleccionada);
        
        JPanel pnlCentro = new JPanel();
        pnlCentro.setBorder(new EmptyBorder(5,5,5,5));
        pnlCentro.setLayout(new BorderLayout());
        
        pnlCentro.add(scroll, BorderLayout.CENTER);
        pnlCentro.add(pnlFiguraSeleccionada, BorderLayout.SOUTH);
        
        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new FlowLayout());
        pnlSur.add(btnActualizarFigura);
        pnlSur.add(btnEliminarFigura);
        
        this.getContentPane().add(pnlNorte, BorderLayout.NORTH);
        this.getContentPane().add(pnlCentro, BorderLayout.CENTER);
        this.getContentPane().add(pnlSur, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(440, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.actualizarListaFigurasGeometricas();
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Limpia los campos de la ventana.
     */
    public void limipiarCampos()
    {
        txtNombreFigura.setText("");
        txtFiguraSeleccionada.setText("");
        txtRutaFigura.setText("");
    }
    
    /**
     * Actualiza la lista de figuras geometricas.
     */
    public void actualizarListaFigurasGeometricas()
    {
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS,0)
        {
             @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        
        try
        {
            ArrayList<FiguraGeometrica> lista = ctrl.obtenerFiguras();
            for(int i = 0; i < lista.size(); i ++)
            {
                String [] figuraGeometrica = new String[2];
                figuraGeometrica[0] = lista.get(i).getNombreFigura();
                figuraGeometrica[1] = lista.get(i).getRuta();
                modelo.addRow(figuraGeometrica);
            }
            tabla.setModel(modelo);
            TableColumnModel columnModel = tabla.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(2);
            columnModel.getColumn(1).setPreferredWidth(120);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Actualizar lista", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo que escucha los eventos generados por los botones.
     * @param e Evento generado por los botones. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
  
        if(comando.equalsIgnoreCase(SELECCIONAR_FIGURA))
        {
            JFileChooser fileChooser = new JFileChooser("./data");
            fileChooser.setDialogTitle("Buscar figura geometrica");
            fileChooser.setMultiSelectionEnabled(false);
            
            int resultado = fileChooser.showOpenDialog(this);
            if(resultado == JFileChooser.APPROVE_OPTION)
            {
                String imagen = fileChooser.getSelectedFile().getAbsolutePath();
                txtRutaFigura.setText(imagen);
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(AGREGAR_FIGURA))
            {
               try
               {
                   String nombreFigura = txtNombreFigura.getText();
                   if(nombreFigura == null)
                       throw new Exception("No se a definido la propiedad Nombre Figura.");
                   if(nombreFigura.trim().equalsIgnoreCase(""))
                       throw new Exception("La propiedad Nombre figura, no puede estar vacia.");
                   String rutaFigura = txtRutaFigura.getText();
                   if(rutaFigura == null)
                       throw new Exception("No se ha definido la propiedad Ruta Figura.");
                   if(rutaFigura.trim().equalsIgnoreCase(""))
                       throw new Exception("La propiedad Ruta figura, no puede estar vacia.");
                   
                   if(ctrl.consultarFigura(nombreFigura)== -1)
                   {
                        ctrl.agregarFigura(nombreFigura, rutaFigura);
                        this.actualizarListaFigurasGeometricas();
                        this.limipiarCampos();
                   }
                   else
                   {
                       txtNombreFigura.requestFocus();
                       throw new Exception("Ya se encuentra registrada una figura con el mismo nombre.");
                   }
               }
               catch(Exception ex)
               {
                  JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar figura", JOptionPane.ERROR_MESSAGE); 
               }
            }
            else
            {
                if(comando.equalsIgnoreCase(ACTUALIZAR_FIGURA))
                {
                    try
                    {
                        String nombreSeleccionado = txtFiguraSeleccionada.getText();
                        if(nombreSeleccionado == null)
                            throw new Exception("No se ha definido la propiedad 'Nombre figura seleccionado'."); 
                        if(nombreSeleccionado.trim().equalsIgnoreCase(""))
                            throw new Exception("Debe seleccionar una figura.");
                        
                        String nuevoNombre = txtNombreFigura.getText();
                        if(nuevoNombre == null)
                            throw new Exception("No se ha definido la propiedad 'Nuevo nombre figura'.");
                        if(nuevoNombre.trim().equalsIgnoreCase(""))
                            throw new Exception("El nuevo nombre de la figura no puede estar vacio.");
                        
                        int index = ctrl.consultarFigura(nombreSeleccionado);
                        if(index != -1)
                        {
                            if(ctrl.consultarFigura(nuevoNombre) == -1)
                            {
                                ctrl.actualizarFigura(index, nuevoNombre);
                                this.actualizarListaFigurasGeometricas();
                                this.limipiarCampos();
                            }
                            else
                                throw new Exception("El nuevo nombre seleccionado ya se encuentra registrado.");
                        }
                        else
                            throw new Exception("No se encuentra el jugador seleccionado.");
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Actualizar figura", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    if(comando.equalsIgnoreCase(ELIMINAR_FIGURA))
                    {
                        try
                        {
                            String nombreFigura = txtFiguraSeleccionada.getText();
                            if(nombreFigura == null)
                                throw new Exception("No se ha definido la figura seleccionada.");
                            if(nombreFigura.trim().equalsIgnoreCase(""))
                                throw new Exception("Debe seleccionar una figura de la lista.");
                            
                            if(JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar la figura seleccionada?", "Eliminar figura", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                            {
                                int index = ctrl.consultarFigura(nombreFigura);
                                if(index != -1)
                                {
                                    ctrl.eliminarFigura(index);
                                    this.actualizarListaFigurasGeometricas();
                                    this.limipiarCampos();
                                }
                                else
                                    throw new Exception("No se encuentra la figura seleccionada para eliminar.");
                            }
                        }
                        catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "Eliminar figura", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        int row = tabla.rowAtPoint(e.getPoint());
        txtFiguraSeleccionada.setText(tabla.getValueAt(row, 0) + "");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
