package GUI;

import Auth.Autenticador;
import Controllers.ControladorUsuario;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaPersonas extends JPanel {

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
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblMail;
    private JLabel lblDni;
    private JLabel lblTelefono;
    private JLabel servicioEnvio;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtMail;
    private JTextField txtDni;
    private JTextField txtTelefono;

    private JPanel panelBotones;
    private JButton btnGuardar;

    private int alignR = JLabel.LEFT;
    private int alignL = JLabel.RIGHT;

    public PanelAltaPersonas (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void cargarCampos(PersonaDTO persona) {
        if(persona != null){
            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            txtMail.setText(persona.getMail());
            txtTelefono.setText((String.valueOf(persona.getTelefono())));
            txtDni.setText(String.valueOf(persona.getDni()));
        }
    }

    public void armarPanelAltaPersonas() {
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


        lblAlta = new JLabel("ALTA DE PERSONA");
        lblAlta.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblAlta.setHorizontalAlignment(0);
        lblAlta.setVerticalAlignment(0);

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(6,2,5,20));
        panelForm.setBackground(Style.FONDO);

        lblNombre = new JLabel("Nombre:   ");
        lblNombre.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblNombre.setHorizontalAlignment(alignL);

        lblApellido = new JLabel("Apellido:   ");
        lblApellido.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblApellido.setHorizontalAlignment(alignL);

        lblMail = new JLabel("Mail:   ");
        lblMail.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblMail.setHorizontalAlignment(alignL);

        lblDni = new JLabel("DNI:    ");
        lblDni.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblDni.setHorizontalAlignment(alignL);

        lblTelefono = new JLabel("TELEFONO:    ");
        lblTelefono.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblTelefono.setHorizontalAlignment(alignL);

        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(alignR);

        txtApellido = new JTextField("");
        txtApellido.setHorizontalAlignment(alignR);

        txtMail = new JTextField("");
        txtMail.setHorizontalAlignment(alignR);

        txtDni = new JTextField("");
        txtDni.setHorizontalAlignment(alignR);

        txtTelefono = new JTextField("");
        txtTelefono.setHorizontalAlignment(alignR);

        panelForm.add(lblNombre);
        panelForm.add(txtNombre);
        panelForm.add(lblApellido);
        panelForm.add(txtApellido);
        panelForm.add(lblMail);
        panelForm.add(txtMail);
        panelForm.add(lblDni);
        panelForm.add(txtDni);
        panelForm.add(lblTelefono);
        panelForm.add(txtTelefono);

        panelBotones = new JPanel();

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setPreferredSize(new Dimension(200,50));
        panelBotones.add(btnGuardar);
        panelBotones.setBackground(Style.FONDO);



        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnAlta = new JButton("");
        btnAlta.setVisible(false);

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

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PersonaDTO nuevaPersona = new PersonaDTO();


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
