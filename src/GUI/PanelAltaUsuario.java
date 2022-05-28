package GUI;

import Auth.Autenticador;
import Controllers.ControladorUsuario;
import DTO.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaUsuario extends JPanel {
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
    private JLabel lblContraseña;
    private JLabel lblConfirmarContraseña;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtMail;
    private JPasswordField pssContra;
    private JPasswordField pssConfirm;
    private JPanel panelBotones;
    private JButton btnGuardar;

    private int alignR = JLabel.LEFT;
    private int alignL = JLabel.RIGHT;

    public PanelAltaUsuario (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void cargarCampos(UsuarioDTO usuario) {
        if(usuario != null){
            txtNombre.setText(usuario.getNombre());
            txtApellido.setText(usuario.getApellido());
            txtMail.setText(usuario.getMail());
            txtMail.setEnabled(false);
        }



    }



    public void armarPanelAltaUsuario() {
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


        lblAlta = new JLabel("ALTA DE USUARIO");
        lblAlta.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblAlta.setHorizontalAlignment(0);
        lblAlta.setVerticalAlignment(0);

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(5,5,5,20));
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

        lblContraseña = new JLabel("Contraseña:    ");
        lblContraseña.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblContraseña.setHorizontalAlignment(alignL);

        lblConfirmarContraseña = new JLabel("Confirmar Contraseña:    ");
        lblConfirmarContraseña.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblConfirmarContraseña.setHorizontalAlignment(alignL);

        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(alignR);
        txtNombre.setPreferredSize(new Dimension(200,40));

        txtApellido = new JTextField("");
        txtApellido.setHorizontalAlignment(alignR);

        txtMail = new JTextField("");
        txtMail.setHorizontalAlignment(alignR);

        pssContra = new JPasswordField("");
        pssContra.setHorizontalAlignment(alignR);

        pssConfirm = new JPasswordField("");
        pssConfirm.setHorizontalAlignment(alignR);

        panelForm.add(lblNombre);
        panelForm.add(txtNombre);
        panelForm.add(lblApellido);
        panelForm.add(txtApellido);
        panelForm.add(lblMail);
        panelForm.add(txtMail);
        panelForm.add(lblContraseña);
        panelForm.add(pssContra);
        panelForm.add(lblConfirmarContraseña);
        panelForm.add(pssConfirm);

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

                UsuarioDTO nuevoUsuario = new UsuarioDTO();
                String pass = String.copyValueOf(pssContra.getPassword());
                String confPass = String.copyValueOf(pssConfirm.getPassword());

                if(pass.equals(confPass)) {
                    nuevoUsuario.setNombre(txtNombre.getText());
                    nuevoUsuario.setApellido(txtApellido.getText());
                    nuevoUsuario.setMail(txtMail.getText());


                    if(ControladorUsuario.getInstance().verificarUsuarioBoolean(txtMail.getText())){
                        ControladorUsuario.getInstance().eliminarUsuario(nuevoUsuario);
                    }
                        ControladorUsuario.getInstance().crearUsuario(nuevoUsuario);

                    Autenticador.getInstance().editarPassword(txtMail.getText(), pass);



                    masterFrame.mostrarPanelUsuarios();
                }
                else {
                    JOptionPane.showMessageDialog(masterFrame,"Las contraseñas no coinciden.");
                }


            }
        });

        btnAtras.addActionListener(new ActionListener() {
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
