package GUI;

import Controllers.ControladorConsorcio;
import Controllers.ControladorPersona;
import Controllers.ControladorUsuario;
import DTO.ConsorcioDTO;
import DTO.PersonaDTO;
import DTO.UnidadFuncionalDTO;
import DTO.UsuarioDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPersonas extends JPanel {

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

    public PanelPersonas (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelPersonas(ConsorcioDTO consorcioDTO) {
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

        lblUsuarios = new JLabel("SELECCIONE UN USUARIO O DE UNO NUEVO DE ALTA");
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

        contenidoTabla.addColumn("NOMBRE");
        contenidoTabla.addColumn("APELLIDO");
        contenidoTabla.addColumn("DNI");
        contenidoTabla.addColumn("TELÉFONO");
        contenidoTabla.addColumn("EMAIL");
        contenidoTabla.addColumn("UNIDAD");
        contenidoTabla.addColumn("RELACIÓN");
        /*
        ArrayList<PersonaDTO> personaDTO;

        System.out.println(ControladorUsuario.getInstance().getUsuarios());
        for (UsuarioDTO u : usuarios){

            Object [] row = new Object[7];
            row[0] = u.getNombre();
            row[1] = u.getApellido();
            row[2] = u.getMail();

            contenidoTabla.addRow(row);
        }
        */


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
                masterFrame.mostrarPanelAltaUsuario();
            }
        });

        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setNombre((String) tabla.getValueAt(tabla.getSelectedRow(),0));
                usuarioDTO.setApellido((String) tabla.getValueAt(tabla.getSelectedRow(),1));
                usuarioDTO.setMail((String) tabla.getValueAt(tabla.getSelectedRow(),2));

                int res = JOptionPane.showOptionDialog(new JFrame(), "Seguro que desea elimiar al usuario?","Aviso",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    try {
                        ControladorUsuario.getInstance().eliminarUsuario(usuarioDTO);
                        masterFrame.mostrarPanelUsuarios();
                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un usuario.");
                    }
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                try {
                    usuarioDTO.setNombre((String) tabla.getValueAt(tabla.getSelectedRow(),0));
                    usuarioDTO.setApellido((String) tabla.getValueAt(tabla.getSelectedRow(),1));
                    usuarioDTO.setMail((String) tabla.getValueAt(tabla.getSelectedRow(),2));

                    masterFrame.mostrarPanelAltaUsuario(usuarioDTO);

                    //ControladorUsuario.getInstance().eliminarUsuario(usuarioDTO);

                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un usuario.");
                }


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
