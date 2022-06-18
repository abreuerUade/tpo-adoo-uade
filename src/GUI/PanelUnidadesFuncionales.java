package GUI;

import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;
import Negocio.Persona;
import Negocio.UnidadFuncional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelUnidadesFuncionales extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;

    private JLabel lblOpciones;
    private JLabel lblUsuarios;
    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JButton btnAtras;
    private JButton btnSalir;

    private DefaultTableModel contenidoTabla;
    private JTable tabla;
    private JScrollPane scrollPane;

    public PanelUnidadesFuncionales (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelUnidadesFuncionales(ConsorcioDTO consorcioDTO) {
        this.removeAll();
        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6, 1);
        leftLayout.setVgap(30);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(200, 500));
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

        lblUsuarios = new JLabel("SELECCIONE UNA UNIDAD FUNCIONAL O DE UNA NUEVA DE ALTA");
        lblUsuarios.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblUsuarios.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnAlta = new JButton("ALTA");
        btnBaja = new JButton("BAJA");
        btnModificar = new JButton("MODIFICAR");
        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

        ////////////// Tabla ////////////////

        contenidoTabla = new DefaultTableModel();
        tabla = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(tabla);
        scrollPane.setBounds(0, 0, 550, 370);
        scrollPane.setOpaque(false);

        contenidoTabla.addColumn("UNIDAD");
        contenidoTabla.addColumn("PROPIETARIO");
        contenidoTabla.addColumn("INQUILINO");
        contenidoTabla.addColumn("SUPERFICIE");


        ArrayList <UnidadFuncionalDTO> unidades = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO.getId());

        for (UnidadFuncionalDTO u : unidades){

            Object [] row = new Object[4];

            row[0] = u.getNroUnidad();
            row[1] = u.getPropietarios().size() == 0 ? "" : u.getPropietarios().get(0).getNombre();
            row[2] = u.getInquilinos().size() == 0 ? "" : u.getInquilinos().get(0).getNombre();
            row[3] = u.getSuperficie();

            contenidoTabla.addRow(row);
        }

        panelDe.add(lblUsuarios, BorderLayout.NORTH);
        panelDe.add(scrollPane, BorderLayout.CENTER);
        panelIz.add(lblOpciones);
        panelIz.add(btnAlta);
        panelIz.add(btnBaja);
        panelIz.add(btnModificar);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);

        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelAltaunidadFuncional(consorcioDTO, null);
            }
        });

        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                    int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
                    UnidadFuncionalDTO u = ControladorUnidadFuncional.getInstance().getUnidadFuncional(id).unidadFuncToDTO();
                    ControladorUnidadFuncional.getInstance().eliminarUnidadFuncional(u);
                    masterFrame.mostrarPanelUnidadesFuncionales(consorcioDTO);
                }
                catch (Exception exception){

                }

            }
        });

        btnModificar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                UnidadFuncionalDTO uf;
                int nroUnidad = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
                int idUf = ControladorUnidadFuncional.getInstance().getIdFromUf(consorcioDTO.getId(), nroUnidad);
                uf = ControladorUnidadFuncional.getInstance().getUnidadFuncional(idUf).unidadFuncToDTO();

                masterFrame.mostrarPanelAltaunidadFuncional(consorcioDTO, uf);

            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelPrincipal();
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });

    }
}
