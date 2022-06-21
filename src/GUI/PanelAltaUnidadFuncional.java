package GUI;

import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;
import DTO.UsuarioDTO;
import Negocio.Persona;
import Negocio.UnidadFuncional;

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
    private JTextField txtUnidad;
    private JTextField txtSup;
    private JPanel panelBotones;
    private JButton btnGuardar;

    private int alignR = JLabel.LEFT;
    private int alignL = JLabel.RIGHT;

    public PanelAltaUnidadFuncional (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void cargarCampos(UnidadFuncionalDTO uf) {
        if(uf != null){
            txtUnidad.setText(uf.getNroUnidad().toString());
            txtSup.setText(String.valueOf(uf.getSuperficie()));


        }
    }

    public void armarPanelAltaUnidadFuncional(ConsorcioDTO consorcioDTO, UnidadFuncionalDTO unidadFuncionalDTO) {
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


        lblAlta = new JLabel("ALTA DE UNIDAD FUNCIONAL");
        lblAlta.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblAlta.setHorizontalAlignment(0);
        lblAlta.setVerticalAlignment(0);

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(2,2,5,40));
        panelForm.setBackground(Style.FONDO);
        panelForm.setBorder(BorderFactory.createEmptyBorder(50, 50, 100, 80));

        lblUnidad = new JLabel("Unidad:   ");
        lblUnidad.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblUnidad.setHorizontalAlignment(alignL);

        lblSuperficie = new JLabel("Superficie:   ");
        lblSuperficie.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblSuperficie.setHorizontalAlignment(alignL);

        txtUnidad = new JTextField();
        txtUnidad.setHorizontalAlignment(alignR);
        txtUnidad.setPreferredSize(new Dimension(200,40));

        txtSup = new JTextField();
        txtSup.setHorizontalAlignment(alignR);

        panelForm.add(lblUnidad);
        panelForm.add(txtUnidad);
        panelForm.add(lblSuperficie);
        panelForm.add(txtSup);

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
                UnidadFuncionalDTO nuevaUf = new UnidadFuncionalDTO();
                nuevaUf.setNroUnidad(Integer.parseInt(txtUnidad.getText()));
                nuevaUf.setSuperficie(Float.parseFloat(txtSup.getText()));
                nuevaUf.setIdconsorcio(consorcioDTO.getId());

                if(unidadFuncionalDTO == null) {

                    int id = ControladorUnidadFuncional.getInstance().getUnidadesFuncionales().size() + 1;
                    nuevaUf.setIdUnidadFuncional(id);

                    ControladorUnidadFuncional.getInstance().crearUnidadFuncional(nuevaUf);
                }else{
                    nuevaUf.setIdUnidadFuncional(unidadFuncionalDTO.getIdUnidadFuncional());
                    ControladorUnidadFuncional.getInstance().editarUnidadFuncional(nuevaUf);
                }
                masterFrame.mostrarPanelUnidadesFuncionales(consorcioDTO);
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
