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
        btnAlta.setPreferredSize(new Dimension(180, 40));
        btnAlta.setHorizontalAlignment(0);

        btnBaja = new JButton("BAJA");
        btnBaja.setPreferredSize(new Dimension(180, 40));
        btnBaja.setHorizontalAlignment(0);

        btnModificar = new JButton("MODIFICAR");
        btnModificar.setPreferredSize(new Dimension(180, 40));
        btnModificar.setHorizontalAlignment(0);

        btnUsuario = new JButton("USUARIOS");
        btnUsuario.setPreferredSize(new Dimension(180, 40));
        btnUsuario.setHorizontalAlignment(0);

        btnSalir = new JButton("SALIR");
        btnSalir.setPreferredSize(new Dimension(180, 40));
        btnSalir.setHorizontalAlignment(0);

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

        panelDe.add(lblConsorcio, BorderLayout.NORTH);
        panelDe.add(scrollPane, BorderLayout.CENTER);
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
        
    }

}
