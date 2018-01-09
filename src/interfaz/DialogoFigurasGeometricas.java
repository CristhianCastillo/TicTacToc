/**
 * 
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author Cristhian Eduardo Castillo Erazo.
 * Clase que representa el Dialogo para gestionar las configuraciones de las
 * figuras geometricas de la aplicación.
 */
public class DialogoFigurasGeometricas extends JDialog implements ActionListener
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
    
    private JLabel lblNombreFigura;
    private JLabel lblRutaFigura;
    private JLabel lblFiguraSeleccionada;
    
    private JTextField txtNombreFigura;
    private JTextField txtRutaFigura;
    private JTextField txtFiguraSeleccionada;
    
    private JButton btnAgregarFigura;
    private JButton btnSeleccionarFigura;
    private JButton btnActualizarFigura;
    private JButton btnEliminarFigura;
    
    private JTable tabla;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public DialogoFigurasGeometricas()
    {
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
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------

    /**
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
}
