package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {

    private MasterFrame masterFrame;
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
        contenidoTabla.addColumn("ADMINISTRADOR");

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
                masterFrame.mostrarPanelAltaConsorcio();
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
