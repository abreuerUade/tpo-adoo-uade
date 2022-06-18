package GUI;

import Auth.Autenticador;
import Controllers.ControladorPersona;
import Controllers.ControladorUnidadFuncional;
import Controllers.ControladorUsuario;
import DTO.ConsorcioDTO;
import DTO.PersonaDTO;
import DTO.UnidadFuncionalDTO;
import DTO.UsuarioDTO;
import Negocio.ServiciosEnvio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JLabel lblUnidadFuncional;
    private JLabel lblServicioEnvio;
    private JLabel lblCondicion;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtMail;
    private JTextField txtDni;
    private JTextField txtTelefono;
    private JComboBox<String> cmbUnidadFuncional;
    private JComboBox<String> cmbServicioEnvio;
    private JComboBox<String> cmbCondicion;

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
            txtDni.setEnabled(false);
            cmbUnidadFuncional.setEnabled(false);
            lblCondicion.setVisible(false);
            cmbCondicion.setVisible(false);

        }
    }

    public void armarPanelAltaPersonas(ConsorcioDTO consorcioDTO, PersonaDTO personaDTO) {
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
        panelForm.setLayout(new GridLayout(8,2,5,10));
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

        lblTelefono = new JLabel("Teléfono:    ");
        lblTelefono.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblTelefono.setHorizontalAlignment(alignL);

        lblUnidadFuncional = new JLabel("Unidad Funcioanl:    ");
        lblUnidadFuncional.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblUnidadFuncional.setHorizontalAlignment(alignL);

        lblServicioEnvio = new JLabel("Método de notificación:    ");
        lblServicioEnvio.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblServicioEnvio.setHorizontalAlignment(alignL);

        lblCondicion = new JLabel("Condición:    ");
        lblCondicion.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblCondicion.setHorizontalAlignment(alignL);

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

        ArrayList<UnidadFuncionalDTO> unidadesDTO = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO.getId());
        ArrayList<String> ufs = new ArrayList<String>();
        for(UnidadFuncionalDTO u: unidadesDTO){
            ufs.add(u.getNroUnidad().toString());
        }
        cmbUnidadFuncional = new JComboBox<>(ufs.toArray(new String[0]));

        String[] metodos = new String[]{"SMS", "EMAIL", "WHATSAPP"};
        cmbServicioEnvio = new JComboBox<>(metodos);

        String[] condicion = new String[]{"INQUILINO", "PROPIETARIO"};
        cmbCondicion = new JComboBox<>(condicion);

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
        panelForm.add(lblUnidadFuncional);
        panelForm.add(cmbUnidadFuncional);
        panelForm.add(lblServicioEnvio);
        panelForm.add(cmbServicioEnvio);
        panelForm.add(lblCondicion);
        panelForm.add(cmbCondicion);

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

                nuevaPersona.setNombre(txtNombre.getText());
                nuevaPersona.setApellido(txtApellido.getText());
                nuevaPersona.setDni(Integer.parseInt(txtDni.getText()));
                nuevaPersona.setMail(txtMail.getText());
                nuevaPersona.setTelefono(Integer.parseInt(txtTelefono.getText()));
                ServiciosEnvio serviciosEnvio = ServiciosEnvio.SMS;
                nuevaPersona.setServiciosEnvio(serviciosEnvio);
                String condicion = cmbCondicion.getSelectedItem().toString();

                if (personaDTO == null) {
                    Integer uf = Integer.parseInt(cmbUnidadFuncional.getSelectedItem().toString());
                    Integer idUf = ControladorUnidadFuncional.getInstance().getIdFromUf(consorcioDTO.getId(), uf);
                    ControladorPersona.getInstance().crearPersona(nuevaPersona);
                    if (condicion.equals("PROPIETARIO")) {
                        ControladorUnidadFuncional.getInstance().agregarPropietario(nuevaPersona, idUf);
                    } else {
                        ControladorUnidadFuncional.getInstance().agregarInquilino(nuevaPersona, idUf);
                    }
                }else{
                    ControladorPersona.getInstance().modificarPersona(nuevaPersona);
                }
                masterFrame.mostrarPanelPersonas(consorcioDTO);

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
