package GUI;

import Controllers.ControladorConsorcio;
import Controllers.ControladorUsuario;
import DTO.ConsorcioDTO;
import DTO.UsuarioDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {

    private final MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;

    private JLabel lblOpciones;
    private JLabel lblConsorcio;
    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JButton btnUsuario;
    private JButton btnSalir;
    private JButton btnUF;
    private JButton btnPersonas;
    private JButton btnGastos;
    private JButton btnLiquidar;
    private JPanel panelbotones;

    private DefaultTableModel contenidoTabla;
    private JTable tabla;
    private JScrollPane scrollPane;

    public PanelPrincipal (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelPrincipal() {
        this.removeAll();
        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6,1);
        leftLayout.setVgap(30);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(200,500));
        panelIz.setBackground(Style.GRIS_CLARO);

        panelDe = new JPanel();
        BorderLayout rightLayout = new BorderLayout(20,20);
        panelDe.setLayout(rightLayout);
        panelDe.setPreferredSize(new Dimension(800, 500));
        panelDe.setBackground(Style.FONDO);
        panelDe.setBorder(BorderFactory.createEmptyBorder(30, 50, 20, 50));

        this.add(panelIz, BorderLayout.WEST);
        this.add(panelDe, BorderLayout.CENTER);

        //////////////////////////////////////////////////////////////////

        lblConsorcio = new JLabel("SELECCIONE UN CONSORCIO O DE UNO NUEVO DE ALTA");
        lblConsorcio.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblConsorcio.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnAlta = new JButton("ALTA");
        btnBaja = new JButton("BAJA");
        btnModificar = new JButton("MODIFICAR");
        btnUsuario = new JButton("USUARIOS");
        btnSalir = new JButton("SALIR");

        ////////////// Tabla ////////////////

        contenidoTabla = new DefaultTableModel();
        tabla = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(tabla);
        scrollPane.setBounds(0,0,550,370);
        scrollPane.setOpaque(false);

        contenidoTabla.addColumn("ID");
        contenidoTabla.addColumn("DIRECCION");
        contenidoTabla.addColumn("BARRIO");


        ArrayList<ConsorcioDTO> consorcios = ControladorConsorcio.getInstance().getConsorcios();

        for (ConsorcioDTO c : consorcios){

            Object [] row = new Object[3];
            row[0] = c.getId();
            row[1] = c.getNombre();
            row[2] = c.getBarrio();

            contenidoTabla.addRow(row);
        }

        panelbotones = new JPanel();
        panelbotones.setBackground(Style.FONDO);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(30);
        panelbotones.setLayout(flowLayout);


        btnUF = new JButton("UNIDADES FUNC.");
        btnUF.setPreferredSize(new Dimension(140, 40));

        btnPersonas = new JButton("PERSONAS");
        btnPersonas.setPreferredSize(new Dimension(140, 40));

        btnGastos = new JButton("GASTOS");
        btnGastos.setPreferredSize(new Dimension(140, 40));

        btnLiquidar = new JButton("LIQUIDAR");
        btnLiquidar.setPreferredSize(new Dimension(140, 40));
        btnLiquidar.setBackground(Style.ROJO);
        btnLiquidar.setForeground(Style.FONT_WHITE);

        panelbotones.add(btnUF);
        panelbotones.add(btnPersonas);
        panelbotones.add(btnGastos);
        panelbotones.add(btnLiquidar);

        panelDe.add(lblConsorcio, BorderLayout.NORTH);
        panelDe.add(scrollPane, BorderLayout.CENTER);
        panelDe.add(panelbotones, BorderLayout.SOUTH);
        panelIz.add(lblOpciones);
        panelIz.add(btnAlta);
        panelIz.add(btnBaja);
        panelIz.add(btnModificar);
        panelIz.add(btnUsuario);
        panelIz.add(btnSalir);

        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsorcioDTO nuevo = null;

                masterFrame.mostrarPanelAltaConsorcio(nuevo);
            }



        });

        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsorcioDTO consorcioDTO = new ConsorcioDTO();
                consorcioDTO.setId((int) tabla.getValueAt(tabla.getSelectedRow(),0));

                int res = JOptionPane.showOptionDialog(new JFrame(), "Seguro que desea elimiar al consorcio? \n Se perderán todos los datos del mismo","Aviso",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    try {
                        ControladorConsorcio.getInstance().eliminarConsorcio(consorcioDTO);
                        masterFrame.mostrarPanelPrincipal();
                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un usuario.");
                    }
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsorcioDTO c;
                try {
                    int id = (int) tabla.getValueAt(tabla.getSelectedRow(),0);
                    c = ControladorConsorcio.getInstance().getConsorcios().get(id-1);


                    masterFrame.mostrarPanelAltaConsorcio(c);
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un consorcio.");
                }

            }
        });

        btnUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelUsuarios();
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });

        btnUF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelUnidadesFuncionales();
            }
        });

        btnPersonas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsorcioDTO consorcioDTO;


                try{
                    int selected = (int) tabla.getValueAt(tabla.getSelectedRow(),0);
                    consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(selected);
                    masterFrame.mostrarPanelPersonas(consorcioDTO);
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un consorcio.");
                }

            }
        });

        btnGastos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsorcioDTO consorcioDTO;


                try{
                    int selected = (int) tabla.getValueAt(tabla.getSelectedRow(),0);
                    consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(selected);
                    masterFrame.mostrarPanelGastos(consorcioDTO);
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un consorcio.");
                }
            }
        });
        
    }

}
