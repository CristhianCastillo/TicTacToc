/**
 *
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.figura.FiguraGeometrica;
import modelo.jugador.Jugador;

/**
 * Dialogo para seleccionar e iniciar un nuevo juego.
 *
 * @author Cristhian Eduardo Castillo Erazo.
 *
 */
public class DialogoIniciarJuego extends JDialog implements ActionListener {
    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /**
     * Versión de la aplicación.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando enviado por el boton Iniciar Juego.
     */
    public static final String INCIAR_JUEGO = "Iniciar partida";

    /**
     * Comando enviado por el boton Agregar Jugador.
     */
    public static final String AGREGAR_JUGADOR = "Agregar jugador";

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------
    /**
     * Etiqueta jugador uno.
     */
    private final JLabel lblJugadorUno;

    /**
     * Etiqueta jugador dos.
     */
    private final JLabel lblJugadorDos;

    /**
     * Etiqueta figura uno.
     */
    private final JLabel lblFiguraUno;

    /**
     * Etiqueta figura dos.
     */
    private final JLabel lblFiguraDos;

    /**
     * Etiqueta Nombre de Jugador.
     */
    private final JLabel lblNombreJugador;

    /**
     * ComboBox con los nombres de los jugadores actuales.
     */
    private final JComboBox<String> cbmJugadorUno;

    /**
     * ComboBox con los nombres de los jugadores actuales.
     */
    private final JComboBox<String> cbmJugadorDos;

    /**
     * ComboBox con los nombres de las figuras disponibles.
     */
    private final JComboBox<String> cbmFiguraUno;

    /**
     * ComboBox con los nombres de las figuras disponibles.
     */
    private final JComboBox<String> cbmFiguraDos;

    /**
     * Campo de texto para ingresar el nombre de un nuevo jugador.
     */
    private final JTextField txtNombreJugador;

    /**
     * Boton Inciar Juego.
     */
    private final JButton btnInicarJuego;

    /**
     * Boton Agregar Jugador.
     */
    private final JButton btnAgregarJugador;

    /**
     * Controlador principal de la aplicaci�n.
     */
    private final Controlador ctrl;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------
    /**
     * Construye la ventana que valida los jugadores seleccionados para disputar
     * la partida.
     *
     * @param ctrl Controlador principal de la aplicaci�n.
     * @param jugadoresDisponibles Lista con los juagdores.
     * @param figuras Lista con las figuras disponibles.
     */
    public DialogoIniciarJuego(Controlador ctrl, ArrayList<Jugador> jugadoresDisponibles, ArrayList<FiguraGeometrica> figuras) {
        this.ctrl = ctrl;
        this.setTitle("Iniciar Juego");
        this.setLayout(new BorderLayout());

        // -------------------------------------------------------
        // Panel Norte
        // -------------------------------------------------------
        JPanel pnlNorte = new JPanel();
        pnlNorte.setBorder(new TitledBorder("Seleccionar Jugadores"));
        GroupLayout grupoPnlNorte = new GroupLayout(pnlNorte);
        pnlNorte.setLayout(grupoPnlNorte);

        DefaultComboBoxModel<String> modeloJugadorUno = new DefaultComboBoxModel(jugadoresDisponibles.toArray());
        DefaultComboBoxModel<String> modeloJugadorDos = new DefaultComboBoxModel(jugadoresDisponibles.toArray());

        DefaultComboBoxModel<String> modeloFigurasUno = new DefaultComboBoxModel(figuras.toArray());
        DefaultComboBoxModel<String> modeloFigurasDos = new DefaultComboBoxModel(figuras.toArray());

        //Creacion de los componentes.
        lblJugadorUno = new JLabel("Jugador (1):");
        lblJugadorDos = new JLabel("Jugador (2):");
        cbmJugadorUno = new JComboBox<>(modeloJugadorUno);
        cbmJugadorDos = new JComboBox<>(modeloJugadorDos);

        lblFiguraUno = new JLabel("Figura (1):");
        lblFiguraDos = new JLabel("Figura (2):");
        cbmFiguraUno = new JComboBox<String>(modeloFigurasUno);
        cbmFiguraDos = new JComboBox<String>(modeloFigurasDos);

        btnInicarJuego = new JButton("Iniciar juego");
        btnInicarJuego.setActionCommand(INCIAR_JUEGO);
        btnInicarJuego.addActionListener((ActionListener) this);

        JPanel pnlJugadorUno = new JPanel();
        pnlJugadorUno.setBorder(new TitledBorder("Jugador Uno"));
        GroupLayout grupoJugadorUno = new GroupLayout(pnlJugadorUno);
        pnlJugadorUno.setLayout(grupoJugadorUno);

        grupoJugadorUno.setAutoCreateContainerGaps(true);
        grupoJugadorUno.setAutoCreateGaps(true);

        //Set Horizontal
        grupoJugadorUno.setHorizontalGroup(grupoJugadorUno.createSequentialGroup()
                .addGroup(grupoJugadorUno.createParallelGroup()
                        .addComponent(lblJugadorUno)
                )
                .addGroup(grupoJugadorUno.createParallelGroup()
                        .addComponent(cbmJugadorUno)
                )
                .addGroup(grupoJugadorUno.createParallelGroup()
                        .addComponent(lblFiguraUno)
                )
                .addGroup(grupoJugadorUno.createParallelGroup()
                        .addComponent(cbmFiguraUno)
                )
        );

        //Colocar componentes del mismo tama�o
        grupoJugadorUno.linkSize(SwingConstants.HORIZONTAL, cbmJugadorUno, cbmFiguraUno);

        //Set Vertical
        grupoJugadorUno.setVerticalGroup(grupoJugadorUno.createSequentialGroup()
                .addGroup(grupoJugadorUno.createParallelGroup()
                        .addComponent(lblJugadorUno)
                        .addComponent(cbmJugadorUno)
                        .addComponent(lblFiguraUno)
                        .addComponent(cbmFiguraUno)
                )
        );

        JPanel pnlJugadorDos = new JPanel();
        pnlJugadorDos.setBorder(new TitledBorder("Jugador Dos"));
        GroupLayout grupoJugadorDos = new GroupLayout(pnlJugadorDos);
        pnlJugadorDos.setLayout(grupoJugadorDos);

        grupoJugadorDos.setAutoCreateContainerGaps(true);
        grupoJugadorDos.setAutoCreateGaps(true);

        //Set Horizontal
        grupoJugadorDos.setHorizontalGroup(grupoJugadorDos.createSequentialGroup()
                .addGroup(grupoJugadorDos.createParallelGroup()
                        .addComponent(lblJugadorDos)
                )
                .addGroup(grupoJugadorDos.createParallelGroup()
                        .addComponent(cbmJugadorDos)
                )
                .addGroup(grupoJugadorDos.createParallelGroup()
                        .addComponent(lblFiguraDos)
                )
                .addGroup(grupoJugadorDos.createParallelGroup()
                        .addComponent(cbmFiguraDos)
                )
        );

        grupoJugadorDos.linkSize(SwingConstants.HORIZONTAL, cbmJugadorDos, cbmFiguraDos);

        //Set Vertical
        grupoJugadorDos.setVerticalGroup(grupoJugadorDos.createSequentialGroup()
                .addGroup(grupoJugadorDos.createParallelGroup()
                        .addComponent(lblJugadorDos)
                        .addComponent(cbmJugadorDos)
                        .addComponent(lblFiguraDos)
                        .addComponent(cbmFiguraDos)
                )
        );

        //Set Horizontal
        grupoPnlNorte.setHorizontalGroup(grupoPnlNorte.createSequentialGroup()
                .addGroup(grupoPnlNorte.createParallelGroup()
                        .addComponent(pnlJugadorUno)
                        .addComponent(pnlJugadorDos)
                        .addComponent(btnInicarJuego, GroupLayout.Alignment.TRAILING)
                )
        );

        //Set Vertical
        grupoPnlNorte.setVerticalGroup(grupoPnlNorte.createSequentialGroup()
                .addGroup(grupoPnlNorte.createParallelGroup()
                        .addComponent(pnlJugadorUno)
                )
                .addGroup(grupoPnlNorte.createParallelGroup()
                        .addComponent(pnlJugadorDos)
                )
                .addGap(5, 5, 5)
                .addGroup(grupoPnlNorte.createParallelGroup()
                        .addComponent(btnInicarJuego)
                )
                .addGap(5, 5, 5)
        );

        // -------------------------------------------------------
        // Panel Sur
        // -------------------------------------------------------
        JPanel pnlSur = new JPanel();
        pnlSur.setBorder(new TitledBorder("Ingresar jugador"));
        GroupLayout grupoSur = new GroupLayout(pnlSur);
        pnlSur.setLayout(grupoSur);
        //Creacion componentes.
        lblNombreJugador = new JLabel("Nombre jugador: ");
        txtNombreJugador = new JTextField();
        btnAgregarJugador = new JButton("Agregar Jugador");
        btnAgregarJugador.setActionCommand(AGREGAR_JUGADOR);
        btnAgregarJugador.addActionListener((ActionListener)this);

        grupoSur.setAutoCreateContainerGaps(true);
        grupoSur.setAutoCreateGaps(true);

        //Set Horizontal
        grupoSur.setHorizontalGroup(grupoSur.createSequentialGroup()
                .addGroup(grupoSur.createParallelGroup()
                        .addComponent(lblNombreJugador)
                )
                .addGroup(grupoSur.createParallelGroup()
                        .addComponent(txtNombreJugador)
                        .addComponent(btnAgregarJugador, GroupLayout.Alignment.TRAILING)
                )
        );

        //Set Vertical
        grupoSur.setVerticalGroup(grupoSur.createSequentialGroup()
                .addGroup(grupoSur.createParallelGroup()
                        .addComponent(lblNombreJugador)
                        .addComponent(txtNombreJugador)
                )
                .addGroup(grupoSur.createParallelGroup()
                        .addComponent(btnAgregarJugador, GroupLayout.Alignment.TRAILING)
                )
        );

        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.CENTER);

        this.setSize(485, 340);
    }

    // -------------------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------------------
    /**
     * Escucha los eventos de los botones.
     *
     * @param e Contiene el comando generado por el boton. e != null.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equalsIgnoreCase(INCIAR_JUEGO)) {
            try {
                Jugador jugadorUno = (Jugador) cbmJugadorUno.getSelectedItem();
                Jugador jugadorDos = (Jugador) cbmJugadorDos.getSelectedItem();

                if (jugadorUno.getNombre().equalsIgnoreCase(jugadorDos.getNombre())) {
                    throw new Exception("El nombre del jugador 2 no puede ser el mismo que el del jugador 1.");
                }

                FiguraGeometrica figuraUno = (FiguraGeometrica) cbmFiguraUno.getSelectedItem();
                FiguraGeometrica figuraDos = (FiguraGeometrica) cbmFiguraDos.getSelectedItem();

                if (figuraUno.getNombreFigura().equalsIgnoreCase(figuraDos.getNombreFigura())) {
                    throw new Exception("Las figuras seleccionadas debe ser diferentes.");
                }

                jugadorUno.setFigura(figuraUno);
                jugadorDos.setFigura(figuraDos);

                ctrl.iniciarJuego(jugadorUno, jugadorDos);

                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Iniciar Juego", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
