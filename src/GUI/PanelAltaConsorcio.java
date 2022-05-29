package GUI;

import Controllers.ControladorConsorcio;
import DTO.ConsorcioDTO;
import Negocio.Cuenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaConsorcio extends JPanel {

    // Panel master
    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;
    // Panel Izquierdo
    private JLabel lblOpciones;
    private JButton btnGastos;
    private JButton btnUnidades;
    private JButton btnModificar;
    private JButton btnAtras;
    private JButton btnSalir;
    // Panel Derecho
    private JLabel lblAlta;
    private JPanel panelForm;
    private JLabel lblDireccion;
    private JLabel lblBarrio;
    private JLabel lblProp;
    private JLabel lblCBU;

    private JTextField txtDireccion;
    private JTextField txtBarrio;
    private JTextField txtProp;
    private JTextField txtCBU;

    private JPanel panelBotones;
    private JButton btnGuardar;

    private int alignR = JLabel.LEFT;
    private int alignL = JLabel.RIGHT;

    public PanelAltaConsorcio (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void cargarCampos(ConsorcioDTO consorcioDTO){
        if(consorcioDTO != null){
            txtDireccion.setText(consorcioDTO.getNombre());
            txtBarrio.setText(consorcioDTO.getBarrio());
            txtProp.setText(consorcioDTO.getCuentaBanco().getPropietario());
            txtCBU.setText(consorcioDTO.getCuentaBanco().getCBU());
        }


    }

    public void armarPanelAltaConsorcio(ConsorcioDTO consorcio) {

        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6, 1);
        leftLayout.setVgap(30);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(200, 500));
        panelIz.setBackground(Style.GRIS_CLARO);

        panelDe = new JPanel();
        BorderLayout rightLayout = new BorderLayout(20, 20);
        panelDe.setLayout(rightLayout);
        panelDe.setPreferredSize(new Dimension(800, 500));
        panelDe.setBackground(Style.FONDO);
        panelDe.setBorder(BorderFactory.createEmptyBorder(30, 50, 20, 50));

        this.add(panelIz, BorderLayout.WEST);
        this.add(panelDe, BorderLayout.CENTER);

        //////////////////////////////////////////////////////////////////


        lblAlta = new JLabel("ALTA DE CONSORCIO");
        lblAlta.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblAlta.setHorizontalAlignment(0);
        lblAlta.setVerticalAlignment(0);

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(5, 5, 5, 20));
        panelForm.setBackground(Style.FONDO);


        lblDireccion = new JLabel("Dirección:   ");
        lblDireccion.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblDireccion.setHorizontalAlignment(alignL);

        lblBarrio = new JLabel("Barrio:   ");
        lblBarrio.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblBarrio.setHorizontalAlignment(alignL);

        lblProp = new JLabel("Propietario de Cuenta:    ");
        lblProp.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblProp.setHorizontalAlignment(alignL);

        lblCBU = new JLabel("CBU:    ");
        lblCBU.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblCBU.setHorizontalAlignment(alignL);

        txtDireccion = new JTextField();
        txtDireccion.setHorizontalAlignment(alignR);
        txtDireccion.setPreferredSize(new Dimension(200, 40));

        txtBarrio = new JTextField();
        txtBarrio.setHorizontalAlignment(alignR);

        txtProp = new JTextField();
        txtProp.setHorizontalAlignment(alignR);

        txtCBU = new JPasswordField();
        txtCBU.setHorizontalAlignment(alignR);


        panelForm.add(lblDireccion);
        panelForm.add(txtDireccion);
        panelForm.add(lblBarrio);
        panelForm.add(txtBarrio);
        panelForm.add(lblProp);
        panelForm.add(txtProp);
        panelForm.add(lblCBU);
        panelForm.add(txtCBU);


        panelBotones = new JPanel();

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setPreferredSize(new Dimension(200, 50));
        panelBotones.add(btnGuardar);
        panelBotones.setBackground(Style.FONDO);


        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnGastos = new JButton("GASTOS");
        btnGastos.setVisible(false);

        btnUnidades = new JButton("UNIDADES FUNCIONALES");
        btnUnidades.setVisible(false);

        btnModificar = new JButton("");
        btnModificar.setPreferredSize(new Dimension(180, 40));
        btnModificar.setHorizontalAlignment(0);
        btnModificar.setVisible(false);

        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

        panelDe.add(lblAlta, BorderLayout.NORTH);
        panelDe.add(panelForm, BorderLayout.CENTER);
        panelDe.add(panelBotones, BorderLayout.SOUTH);
        panelIz.add(lblOpciones);
        panelIz.add(btnGastos);
        panelIz.add(btnUnidades);
        panelIz.add(btnModificar);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);



        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsorcioDTO nuevo = new ConsorcioDTO();

                nuevo.setNombre(txtDireccion.getText());
                nuevo.setBarrio(txtBarrio.getText());
                nuevo.setCuentaBanco(new Cuenta(txtProp.getText(),txtCBU.getText()));

                nuevo.setId((int) ControladorConsorcio.getInstance().getConsorcios().size()+1);


                try{
                    ControladorConsorcio.getInstance().crearConsorcio(nuevo);
                    masterFrame.mostrarPanelPrincipal();
                }
                catch (Error error){
                    JOptionPane.showMessageDialog(masterFrame,"Se ha ha producido un error.");
                }



            }
        });

        btnGastos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(consorcio != null){
                    masterFrame.mostrarPanelGastos();
                }
                else {
                    JOptionPane.showMessageDialog(masterFrame,"Primero debe crear un consorcio.");
                }

            }
        });

        btnUnidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(consorcio != null){
                    masterFrame.mostrarPanelUnidadesFuncionales();
                }
                else {
                    JOptionPane.showMessageDialog(masterFrame,"Primero debe crear un consorcio.");
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
