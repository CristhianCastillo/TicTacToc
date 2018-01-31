/* *****************************************************************************
 * Class: DialogoJuegoMaquina.java
 * Date: 27/01/2018 - 07:33:39 PM
 * Copyright 2018 All rights reserved.
 * 
 * Proyect: TicTacToc
 * Autor: Cristhian Eduardo Castillo Erazo - 27/01/2018 
 * *****************************************************************************
 */

package interfaz;

import controlador.Controlador;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import modelo.figura.FiguraGeometrica;
import modelo.jugador.Jugador;

/**
 * Clase que representa el Dialogo para gestionar el juego contra la maquina.
 * @author Cristhian Eduardo Castillo Erazo
 */
@SuppressWarnings("unchecked")
public class DialogoJuegoMaquina extends JDialog implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constants
    // -------------------------------------------------------------------------
    
    /**
     * Comando enviado por el boton Iniciar Juego.
     */
    public static final String INICIAR_JUEGO = "Iniciar juego";
    
    // -------------------------------------------------------------------------
    //  Attributes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  GUI attributes
    // -------------------------------------------------------------------------

    /**
     * Etiqueta seleccionar jugador.
     */
    private final JLabel lblJugador;
    
    /**
     * Etiqueta seleccionar figura jugador.
     */
    private final JLabel lblFiguraJugador;
    
    /**
     * ComboBox seleccionar juagdor.
     */
    private final JComboBox<String> cbmJugador;
    
    /**
     * ComboBox seleccionar Figura geometrica.
     */
    private final JComboBox<String> cbmFiguras;
    
    /**
     * Agrupa los Radio Buttons.
     */
    private final ButtonGroup grupoRadios;
    
    /**
     * RadioButton dificultad: Facil.
     */
    private final JRadioButton rbtmFacil;
    
    /**
     * RadioButton dificultad: Medio.
     */
    private final JRadioButton rbtmMedio;
    
    /**
     * RadioButton dificultad: Dificil.
     */
    private final JRadioButton rbtmDificil;
    
    /**
     * Boton Iniciar Juego.
     */
    private final JButton btnIniciarJuego;
    
    /**
     * Controlador principal de la aplicación.
     */
    private Controlador ctrl;
    // -------------------------------------------------------------------------
    //  Builders
    // -------------------------------------------------------------------------

    /**
     * Construye el Dialogo Juego Maquina.
     * @param ctrl Controlador principal de la aplicación. ctrl != null.
     * @param jugadores Lista de los jugadores de la aplicación. jugadores != null.
     * @param figuras Lista de los figuras de la aplicación. figura != null.
     */
    public DialogoJuegoMaquina(Controlador ctrl, ArrayList<Jugador> jugadores, ArrayList<FiguraGeometrica> figuras)
    {
        this.ctrl = ctrl;
        this.setTitle("Jugar contra la maquina");
        GroupLayout grupoDialogo = new GroupLayout(this.getContentPane());
        this.setLayout(grupoDialogo);
        
        lblJugador = new JLabel("Jugador: ");
        lblFiguraJugador = new JLabel("Figura: ");
        
        DefaultComboBoxModel<String> modeloJugadores = new DefaultComboBoxModel(jugadores.toArray());
        DefaultComboBoxModel<String> modeloFiguras = new DefaultComboBoxModel(figuras.toArray());
        
        cbmJugador = new JComboBox<>(modeloJugadores);
        cbmJugador.setMaximumSize(new Dimension(DialogoIniciarJuego.HORIZONTAL_SIZE_COMBOBOX, DialogoIniciarJuego.VERTICAL_SIZE_COMBOBOX));
        cbmJugador.setMinimumSize(new Dimension(DialogoIniciarJuego.HORIZONTAL_SIZE_COMBOBOX, DialogoIniciarJuego.VERTICAL_SIZE_COMBOBOX));
        cbmJugador.setMaximumRowCount(DialogoIniciarJuego.ITEMS_MAXIMOS_COMBOBOX);
        
        cbmFiguras = new JComboBox<>(modeloFiguras);
        cbmFiguras.setMaximumSize(new Dimension(DialogoIniciarJuego.HORIZONTAL_SIZE_COMBOBOX, DialogoIniciarJuego.VERTICAL_SIZE_COMBOBOX));
        cbmFiguras.setMinimumSize(new Dimension(DialogoIniciarJuego.HORIZONTAL_SIZE_COMBOBOX, DialogoIniciarJuego.VERTICAL_SIZE_COMBOBOX));
        cbmFiguras.setMaximumRowCount(DialogoIniciarJuego.ITEMS_MAXIMOS_COMBOBOX);
        
        grupoRadios = new ButtonGroup();
        rbtmFacil = new JRadioButton("Facil", true);
        rbtmFacil.setToolTipText("La maquina no valida las jugadas del jugador.");
        rbtmMedio = new JRadioButton("Medio", false);
        rbtmMedio.setToolTipText("La maquina valida las jugadas del jugador.");
        rbtmDificil = new JRadioButton("Dificil", false);
        rbtmDificil.setToolTipText("La maquina valida las jugadas y anticipal las del oponente.");
        grupoRadios.add(rbtmFacil);
        grupoRadios.add(rbtmMedio);
        grupoRadios.add(rbtmDificil);
        
        btnIniciarJuego = new JButton("Iniciar Juego");
        btnIniciarJuego.setActionCommand(INICIAR_JUEGO);
        btnIniciarJuego.addActionListener((ActionListener)this);
        
        // -----------------------------------------------------
        // Panel Jugador
        // -----------------------------------------------------
        
        JPanel pnlJugador = new JPanel();
        pnlJugador.setBorder(new TitledBorder("Seleccionar Jugador"));
        GroupLayout grupoJugador = new GroupLayout(pnlJugador);
        pnlJugador.setLayout(grupoJugador);
        
        grupoJugador.setAutoCreateContainerGaps(true);
        grupoJugador.setAutoCreateGaps(true);
        
        grupoJugador.setHorizontalGroup(grupoJugador.createSequentialGroup()
                .addGroup(grupoJugador.createParallelGroup()
                        .addComponent(lblJugador)
                )
                
                .addGroup(grupoJugador.createParallelGroup()
                        .addComponent(cbmJugador)
                )
                
                .addGroup(grupoJugador.createParallelGroup()
                        .addComponent(lblFiguraJugador)
                )
                
                .addGroup(grupoJugador.createParallelGroup()
                        .addComponent(cbmFiguras)
                )
        );
        
        grupoJugador.setVerticalGroup(grupoJugador.createSequentialGroup()
                .addGroup(grupoJugador.createParallelGroup()
                        .addComponent(lblJugador)
                        .addComponent(cbmJugador)
                        .addComponent(lblFiguraJugador)
                        .addComponent(cbmFiguras)
                )
        );
        
        // -----------------------------------------------------
        // Panel Computadora
        // -----------------------------------------------------
        
        JPanel pnlComputador = new JPanel();
        pnlComputador.setBorder(new TitledBorder("Dificultad"));
        pnlComputador.setLayout(new FlowLayout());
        pnlComputador.add(rbtmFacil);
        pnlComputador.add(rbtmMedio);
        pnlComputador.add(rbtmDificil);
        
        
        grupoDialogo.setAutoCreateContainerGaps(true);
        grupoDialogo.setAutoCreateGaps(true);
        
        grupoDialogo.setHorizontalGroup(grupoDialogo.createSequentialGroup()
                .addGroup(grupoDialogo.createParallelGroup()
                        .addComponent(pnlJugador)
                        .addComponent(pnlComputador)
                        .addComponent(btnIniciarJuego, GroupLayout.Alignment.TRAILING)
                )
        );
        
        grupoDialogo.setVerticalGroup(grupoDialogo.createSequentialGroup()
                .addGroup(grupoDialogo.createParallelGroup()
                        .addComponent(pnlJugador)
                )
                
                .addGroup(grupoDialogo.createParallelGroup()
                        .addComponent(pnlComputador)
                )
                
                .addGroup(grupoDialogo.createParallelGroup()
                        .addComponent(btnIniciarJuego)
                )
        );
        
        this.setSize(470,240);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    // -------------------------------------------------------------------------
    //  Functional methods
    // -------------------------------------------------------------------------
    
    /**
     * Metodo que escucha los eventos generados por los botones.
     * @param e Evento generado por los botones. e != null.
     */
     @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase(INICIAR_JUEGO))
        {
            try
            {
                Jugador jugadorUno = (Jugador) cbmJugador.getSelectedItem();
                Jugador jugadorDos = new Jugador(Jugador.NOMBRE_COMPUTADOR, 0, 0, 0, 0);
                
                if (jugadorUno.getNombre().equalsIgnoreCase(jugadorDos.getNombre())) {
                    throw new Exception("Los jugadores seleccionados deben ser diferentes.");
                }
                
                FiguraGeometrica figuraUno = (FiguraGeometrica) cbmFiguras.getSelectedItem();
                FiguraGeometrica figuraDos = new FiguraGeometrica(FiguraGeometrica.NOMBRE_FIGURA_COMPUTADOR, FiguraGeometrica.RUTA_FIGURA_COMPUTADOR);

                if (figuraUno.getNombreFigura().equalsIgnoreCase(figuraDos.getNombreFigura())) {
                    throw new Exception("Las figuras seleccionadas deben ser diferentes.");
                }

                jugadorUno.setFigura(figuraUno);
                jugadorDos.setFigura(figuraDos);

                ctrl.prepararJuegoComputadora(obtenerDificultad());
                ctrl.iniciarJuego(jugadorUno, jugadorDos);

                this.dispose();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex, "Iniciar juego maquina", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Obtiene la dificultad seleccionada por el jugador.
     * @return Dificultad seleccionada por el jugador:
     * <ul>
     *  <li> 1 = Dificultad Facil: La aplicación no valida ningun movimiento
     * realizado por el usuario.
     *  <li> 2 = Dificultad Medio: La aplicación valida los movimientos que
     * debe realizar para alcanzar la vistoria, pero no valida los movimientos
     * realizados por el usuario.
     * <li> 3 = Dificultad Dificil: La aplicación valida los movimientos que
     * realiza el usuario y calcula los necesarios para alcanzar la victoria.
     * </ul>
     */
    public int obtenerDificultad()
    {
        if(rbtmFacil.isSelected())
            return 1;
        else if(rbtmMedio.isSelected())
            return 2;
        else if(rbtmDificil.isSelected())
            return 3;
        else return 0;
    }
}
