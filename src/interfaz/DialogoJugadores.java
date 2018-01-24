/* *****************************************************************************
 * Class: DialogoJugadores.java 
 * Date: ene 10, 2018 9:38:01 p.m.
 * Copyright 2018 All rights reserved
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - ene 10, 2018 
 * *****************************************************************************
 */
package interfaz;

import controlador.ControladorJugadores;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import modelo.jugador.Jugador;

/**
 * This class represent the Dialog with information about players.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class DialogoJugadores extends JDialog implements ActionListener, MouseListener {
    // -------------------------------------------------------------------------
    // Constants
    // -------------------------------------------------------------------------

    /**
     * Comando enviado por el boton Agregar Jugador.
     */
    public static final String AGREGAR_JUGADOR = "Agregar Jugador";

    /**
     * Comando enviado por el boton Modificar Jugador.
     */
    public static final String MODIFICAR_JUGADOR = "Modificar Jugador";

    /**
     * Comando enviado por el boton Eliminar Jugador.
     */
    public static final String ELIMINAR_JUGADOR = "Eliminar Jugador";

    /**
     * Representa las columnas de la tabla de jugadores.
     */
    public static final String[] COLUMNAS_TABLA = {"Nombre Jugador", "P.G", "P.E", "P.P"};

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Etiqueta nombre del jugador.
     */
    private final JLabel lblNombreJugador;

    /**
     * Etiqueta nombre seleccionado.
     */
    private final JLabel lblSeleccionarNombre;

    /**
     * Campo de texto elemento seleccionado.
     */
    private final JTextField txtNombreSeleccionado;

    /**
     * Campo de texto, nombre del jugador.
     */
    private final JTextField txtNombreJugador;

    /**
     * Tabla de los jugadores.
     */
    private final JTable tabla;

    /**
     * Boton agregar jugador.
     */
    private final JButton btnAgregar;

    /**
     * Boton modificar jugador.
     */
    private final JButton btnModificar;

    /**
     * Boton eliminar jugador.
     */
    private final JButton btnEliminar;

    /**
     * Controlador jugadores.
     */
    private final ControladorJugadores ctrl;

    // -------------------------------------------------------------------------
    // Constructores 
    // -------------------------------------------------------------------------
    /**
     *
     * @param ctrl Controlador jugadores.
     */
    public DialogoJugadores(ControladorJugadores ctrl) {
        this.ctrl = ctrl;
        this.setTitle("Configuración Jugadores");
        this.setLayout(new BorderLayout());

        lblNombreJugador = new JLabel("Nombre jugador: ");
        txtNombreJugador = new JTextField();

        lblSeleccionarNombre = new JLabel("Jugador selecionado: ");
        txtNombreSeleccionado = new JTextField(25);
        txtNombreSeleccionado.setEditable(false);

        tabla = new JTable();
        tabla.setColumnSelectionAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setFont(new Font("Arial", Font.BOLD, 12));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener((MouseListener) this);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabla);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        btnAgregar = new JButton("Agregar Jugador");
        btnAgregar.setActionCommand(AGREGAR_JUGADOR);
        btnAgregar.addActionListener((ActionListener) this);

        btnModificar = new JButton("Actualizar Jugador");
        btnModificar.setActionCommand(MODIFICAR_JUGADOR);
        btnModificar.addActionListener((ActionListener) this);

        btnEliminar = new JButton("Eliminar Jugador");
        btnEliminar.setActionCommand(ELIMINAR_JUGADOR);
        btnEliminar.addActionListener((ActionListener) this);

        JPanel pnlNombreSeleccionado = new JPanel();
        pnlNombreSeleccionado.setLayout(new FlowLayout(FlowLayout.LEADING));

        pnlNombreSeleccionado.add(lblSeleccionarNombre);
        pnlNombreSeleccionado.add(txtNombreSeleccionado);

        JPanel pnlNorte = new JPanel();
        GroupLayout grupoNorte = new GroupLayout(pnlNorte);
        pnlNorte.setLayout(grupoNorte);

        grupoNorte.setAutoCreateContainerGaps(true);
        grupoNorte.setAutoCreateGaps(true);

        //Set Horizontal
        grupoNorte.setHorizontalGroup(grupoNorte.createSequentialGroup()
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(lblNombreJugador)
                )
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(txtNombreJugador)
                        .addComponent(btnAgregar, GroupLayout.Alignment.TRAILING)
                )
        );

        //Set Vertical
        grupoNorte.setVerticalGroup(grupoNorte.createSequentialGroup()
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(lblNombreJugador)
                        .addComponent(txtNombreJugador)
                )
                .addGroup(grupoNorte.createParallelGroup()
                        .addComponent(btnAgregar)
                )
        );

        JPanel pnlCentro = new JPanel();
        pnlCentro.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnlCentro.setLayout(new BorderLayout());

        pnlCentro.add(scroll, BorderLayout.CENTER);
        pnlCentro.add(pnlNombreSeleccionado, BorderLayout.SOUTH);

        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new FlowLayout());

        pnlSur.add(btnModificar);
        pnlSur.add(btnEliminar);

        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(440, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.actualizarListaJugadores();
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Actualiza la tabla de los jugadores actuales en la aplicación.
     */
    public void actualizarListaJugadores() {
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS_TABLA, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ArrayList<Jugador> listaJugadores = ctrl.obtenerJugadores();
            for (int i = 0; i < listaJugadores.size(); i++) {
                Jugador jugadorTemp = listaJugadores.get(i);
                String fila[] = new String[4];
                fila[0] = jugadorTemp.getNombre();
                fila[1] = jugadorTemp.getPartidasGanadas() + "";
                fila[2] = jugadorTemp.getPartidasEmpatadas() + "";
                fila[3] = jugadorTemp.getPartidasPerdidas() + "";
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            TableColumnModel columnModel = tabla.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(5);
            columnModel.getColumn(2).setPreferredWidth(5);
            columnModel.getColumn(3).setPreferredWidth(5);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, ex.getMessage(), "Actualizar lista", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo que escucha los eventos generados por los botones.
     *
     * @param e Evento generado por un boton. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals(AGREGAR_JUGADOR)) {
            try {
                String nombreJugador = txtNombreJugador.getText();
                if (nombreJugador == null) {
                    throw new Exception("No se ha definido la propiedad nombre jugador.");
                }
                if (nombreJugador.trim().equalsIgnoreCase("")) {
                    throw new Exception("El nombre del jugador no puede ser estar vacio.");
                }

                if (ctrl.consultarJugador(nombreJugador) == -1) {
                    ctrl.agregarJugador(nombreJugador);
                    this.actualizarListaJugadores();
                    limpiarCampos();
                } else {
                    txtNombreJugador.requestFocus();
                    throw new Exception("Ya se encuentra registrado un jugador con este nombre.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar Jugador", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (comando.equalsIgnoreCase(MODIFICAR_JUGADOR)) {
                try {
                    String nombreSeleccionado = txtNombreSeleccionado.getText();
                    if (nombreSeleccionado == null) {
                        throw new Exception("No se ha definido un jugador seleccionado.");
                    }
                    if (nombreSeleccionado.trim().equalsIgnoreCase("")) {
                        throw new Exception("Debe seleccionar un jugador.");
                    }

                    String nuevoNombre = txtNombreJugador.getText();
                    if (nuevoNombre == null) {
                        throw new Exception("No se ha definido un nuevo nombre.");
                    }
                    if (nuevoNombre.trim().equalsIgnoreCase("")) {
                        throw new Exception("Debe proporsionar un nuevo nombre.");
                    }

                    int index = ctrl.consultarJugador(nombreSeleccionado);
                    if (index != -1) {
                        if (ctrl.consultarJugador(nuevoNombre) == -1) {
                            ctrl.actualizarJugador(index, nuevoNombre);
                            this.actualizarListaJugadores();
                            this.limpiarCampos();
                        } else {
                            throw new Exception("Este nombre ya se encuentra en la lista.");
                        }
                    } else {
                        throw new Exception("El jugador seleccionado no se encuentra.");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Actualizar Jugador", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (comando.equalsIgnoreCase(ELIMINAR_JUGADOR)) {
                    try {
                        String nombreJugador = txtNombreSeleccionado.getText();
                        if (nombreJugador == null) {
                            throw new Exception("No se ha definido la propiedad jugador seleccionado.");
                        }
                        if (nombreJugador.trim().equalsIgnoreCase("")) {
                            throw new Exception("Debe seleccionar un jugador de la lista.");
                        }

                        if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar este jugador?", "Eliminar Jugador", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            int index = ctrl.consultarJugador(nombreJugador);
                            if (index != -1) {
                                ctrl.eliminarJugador(index);
                                this.actualizarListaJugadores();
                                this.limpiarCampos();
                            } else {
                                throw new Exception("El jugador seleccionado no existe.");
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Eliminar Jugador", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    /**
     * Limpia los campos de la ventana.
     */
    public void limpiarCampos() {
        this.txtNombreJugador.setText("");
        this.txtNombreSeleccionado.setText("");
    }

    /**
     * Metodo que escucha los eventos generados por la tabla al seleccionar una
     * fila con el mouse.
     *
     * @param e Evento generado por la tabla. e != null.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tabla.rowAtPoint(e.getPoint());
        txtNombreSeleccionado.setText(tabla.getValueAt(row, 0) + "");
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
