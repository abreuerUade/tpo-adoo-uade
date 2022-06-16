package GUI;

import Controllers.ControladorGasto;
import DTO.ConsorcioDTO;
import DTO.GastoDTO;
import Negocio.Expensas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelAltaGastos extends JPanel {

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
    private JLabel lblMonto;
    private JLabel lblCuotas;
    private JLabel lblPeriodo;
    private JLabel lblTipoExp;
    private JTextField txtNombre;
    private JTextField txtMonto;
    private JTextField txtCuotas;
    private JTextField txtPeriodo;
    private JComboBox<String> txtTipoExp;
    private String[] expensas;
    private JPanel panelBotones;
    private JButton btnGuardar;

    private int alignR = JLabel.LEFT;
    private int alignL = JLabel.RIGHT;

    public PanelAltaGastos (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void cargarCampos(GastoDTO gastoDTO){
        if (gastoDTO != null){
            txtNombre.setText(gastoDTO.getNombre());
            txtMonto.setText(gastoDTO.getMonto().toString());
            txtPeriodo.setText(gastoDTO.getPeriodo().toString());
            txtCuotas.setText(gastoDTO.getCantCuotas().toString());
        }
    }

    public void armarPanelAltaGastos(ConsorcioDTO consorcioDTO, GastoDTO gastoDTO) {
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


        lblAlta = new JLabel("ALTA DE GASTO");
        lblAlta.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblAlta.setHorizontalAlignment(0);
        lblAlta.setVerticalAlignment(0);

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(6,6,5,20));
        panelForm.setBackground(Style.FONDO);

        lblNombre = new JLabel("Nombre:   ");
        lblNombre.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblNombre.setHorizontalAlignment(alignL);

        lblMonto = new JLabel("Monto:   ");
        lblMonto.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblMonto.setHorizontalAlignment(alignL);

        lblCuotas = new JLabel("Cantidad de Cuotas:    ");
        lblCuotas.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblCuotas.setHorizontalAlignment(alignL);

        lblPeriodo = new JLabel("Período:    ");
        lblPeriodo.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblPeriodo.setHorizontalAlignment(alignL);

        lblTipoExp = new JLabel("Tipo de Exensa:   ");
        lblTipoExp.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblTipoExp.setHorizontalAlignment(alignL);

        txtNombre = new JTextField();
        txtMonto = new JTextField();
        txtCuotas = new JTextField();
        txtPeriodo = new JTextField();

        expensas = new String[]{"Ordinarias", "Extraordinarias", "Gastos_Particulares"};
        txtTipoExp = new JComboBox<>(expensas);


        panelForm.add(lblNombre);
        panelForm.add(txtNombre);
        panelForm.add(lblMonto);
        panelForm.add(txtMonto);
        panelForm.add(lblCuotas);
        panelForm.add(txtCuotas);
        panelForm.add(lblPeriodo);
        panelForm.add(txtPeriodo);
        panelForm.add(lblTipoExp);
        panelForm.add(txtTipoExp);

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
                GastoDTO nuevoGasto = new GastoDTO();

                nuevoGasto.setNombre(txtNombre.getText());
                nuevoGasto.setMonto(Integer.parseInt(txtMonto.getText()));
                nuevoGasto.setCantCuotas(Integer.parseInt(txtCuotas.getText()));
                nuevoGasto.setPeriodo(Integer.parseInt(txtPeriodo.getText()));
                nuevoGasto.setTipoExpensas(Expensas.valueOf(txtTipoExp.getSelectedItem().toString().toUpperCase()));
                nuevoGasto.setFechaFact(new Date());

                if(gastoDTO == null){

                    nuevoGasto.setIdconsorcio(consorcioDTO.getId());
                    nuevoGasto.setId(ControladorGasto.getInstance().getGastos().size()+1);
                    System.out.println(ControladorGasto.getInstance().getGastos());
                    ControladorGasto.getInstance().crearGasto(nuevoGasto);
                    System.out.println(ControladorGasto.getInstance().getGastos());
                }else {
                    nuevoGasto.setId(gastoDTO.getId());
                    ControladorGasto.getInstance().modificarGasto(nuevoGasto);
                }
                masterFrame.mostrarPanelGastos(consorcioDTO);
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelGastos(consorcioDTO);
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });

    }
}
