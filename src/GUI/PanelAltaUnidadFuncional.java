package GUI;

import Negocio.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaUnidadFuncional extends JPanel {
    // Panel master
    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;
    // Panel Izquierdo
    private JLabel lblOpciones;
    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JButton btnAtras;
    private JButton btnSalir;
    // Panel Derecho
    private JLabel lblAlta;
    private JPanel panelForm;
    private JLabel lblUnidad;
    private JLabel lblSuperficie;
    private JLabel lblPropietarios;
    private JLabel lblInquilinos;
    private JTextField txtUnidad;
    private JTextField txtSup;
    private JComboBox<String> cmbProp;
    private JComboBox<String> cmbInqui;
    private JPanel panelBotones;
    private JButton btnGuardar;

    private int alignR = JLabel.LEFT;
    private int alignL = JLabel.RIGHT;

    public PanelAltaUnidadFuncional (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelAltaUnidadFuncional() {

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


        lblAlta = new JLabel("ALTA DE UNIDAD FUNCIONAL");
        lblAlta.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblAlta.setHorizontalAlignment(0);
        lblAlta.setVerticalAlignment(0);

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(5,5,5,20));
        panelForm.setBackground(Style.FONDO);

        lblUnidad = new JLabel("Unidad:   ");
        lblUnidad.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblUnidad.setHorizontalAlignment(alignL);

        lblSuperficie = new JLabel("Superficie:   ");
        lblSuperficie.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblSuperficie.setHorizontalAlignment(alignL);

        lblPropietarios = new JLabel("Propietarios:   ");
        lblPropietarios.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblPropietarios.setHorizontalAlignment(alignL);

        lblInquilinos = new JLabel("Inquilinos:    ");
        lblInquilinos.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblInquilinos.setHorizontalAlignment(alignL);

        txtUnidad = new JTextField();
        txtUnidad.setHorizontalAlignment(alignR);
        txtUnidad.setPreferredSize(new Dimension(200,40));

        txtSup = new JTextField();
        txtSup.setHorizontalAlignment(alignR);

        cmbProp = new JComboBox<String>();

        cmbInqui = new JComboBox<String>();

        panelForm.add(lblUnidad);
        panelForm.add(txtUnidad);
        panelForm.add(lblSuperficie);
        panelForm.add(txtSup);
        panelForm.add(lblPropietarios);
        panelForm.add(cmbProp);
        panelForm.add(lblInquilinos);
        panelForm.add(cmbInqui);

        panelBotones = new JPanel();

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setPreferredSize(new Dimension(200,50));
        panelBotones.add(btnGuardar);
        panelBotones.setBackground(Style.FONDO);



        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnAlta = new JButton("PERSONAS");

        btnBaja = new JButton("");
        btnBaja.setVisible(false);

        btnModificar = new JButton("");
        btnModificar.setVisible(false);

        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

        panelDe.add(lblAlta, BorderLayout.NORTH);
        panelDe.add(panelForm, BorderLayout.CENTER);
        panelDe.add(panelBotones, BorderLayout.SOUTH);
        panelIz.add(lblOpciones);
        panelIz.add(btnAlta);
        panelIz.add(btnBaja);
        panelIz.add(btnModificar);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelUnidadesFuncionales();
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });

    }

}
