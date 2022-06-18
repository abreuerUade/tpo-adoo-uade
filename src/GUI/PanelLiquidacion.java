package GUI;

import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;
import Controllers.ControladorUsuario;
import DTO.ConsorcioDTO;
import DTO.UsuarioDTO;
import Negocio.LiquidacionGenerica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLiquidacion extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;
    private JPanel panelForm;
    private JPanel panelBtn;

    private JLabel lblOpciones;
    private JLabel lblLiquidacion;
    private JLabel lblAdmin;
    private JLabel lblLogged;
    private JLabel lblSaldo;
    private JLabel lblSaldoCuenta;
    private JLabel lblTotal;
    private JLabel lblTotalGasto;
    private JLabel lblUsoSaldo;
    private JLabel lblCargaSaldo;
    private JTextField txtUsoSaldo;
    private JTextField txtCargaSaldo;

    // Pago Completo de Gastos
    private JButton btnPCG;
    // Pago Completo con Fondos de Reservas
    private JButton btnPCFR;
    // Pago Completo y Generar Futuros Fondos de Reservas
    private JButton btnPCGFFR;
    private JButton btnAtras;
    private JButton btnSalir;
    private JButton btnLiquidar;
    private JButton btnNotificar;


    public PanelLiquidacion (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }
    public void armarPanelLiquidacion(ConsorcioDTO consorcioDTO){
        this.removeAll();

        UsuarioDTO usuario = ControladorUsuario.getInstance().getUsuario(MasterFrame.loggedUserMail).usuarioToDto();

        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6, 1);
        leftLayout.setVgap(30);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(300, 500));
        panelIz.setBackground(Style.GRIS_CLARO);

        panelDe = new JPanel();
        BorderLayout rightLayout = new BorderLayout(20,20);
        panelDe.setLayout(rightLayout);
        panelDe.setPreferredSize(new Dimension(800, 500));
        panelDe.setBackground(Style.FONDO);
        panelDe.setBorder(BorderFactory.createEmptyBorder(30, 50, 20, 50));

        panelBtn = new JPanel();
        panelBtn.setBackground(Style.FONDO);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(30);
        panelBtn.setLayout(flowLayout);

        this.add(panelIz, BorderLayout.WEST);
        this.add(panelDe, BorderLayout.CENTER);

        //////////////////////////////////////////////////////////////////

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(5,2, 0, 10));
        panelForm.setBackground(Style.FONDO);
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 80));

        lblLiquidacion = new JLabel("LIQUIDACIÓN DE EXPENSAS: \nPago completo de gastos");
        lblLiquidacion.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblLiquidacion.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnPCG = new JButton("Pago Completo de Gastos");
        btnPCG.setPreferredSize(new Dimension(180, 40));
        btnPCG.setHorizontalAlignment(0);

        btnPCFR = new JButton("Pago Completo con Fondos de Reservas");
        btnPCFR.setPreferredSize(new Dimension(180, 40));
        btnPCFR.setHorizontalAlignment(0);

        btnPCGFFR = new JButton("Pago Completo y Generar Fondos de Reservas");
        btnPCGFFR.setPreferredSize(new Dimension(180, 40));
        btnPCGFFR.setHorizontalAlignment(0);

        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

        lblAdmin = new JLabel("Administrador:   ");
        lblAdmin.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblAdmin.setHorizontalAlignment(0);

        String admin = usuario.getNombre() + " " + usuario.getApellido();
        lblLogged = new JLabel(admin);
        lblLogged.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblLogged.setHorizontalAlignment(0);

        lblSaldo = new JLabel("Saldo en Cuenta:   ");
        lblSaldo.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblSaldo.setHorizontalAlignment(0);

        String saldo = ControladorConsorcio.getInstance().saldoConsorcio(consorcioDTO.getId()).toString();
        lblSaldoCuenta = new JLabel("$ " + saldo);
        lblSaldoCuenta.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblSaldoCuenta.setHorizontalAlignment(0);

        lblTotal = new JLabel("Total gastos:   ");
        lblTotal.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblTotal.setHorizontalAlignment(0);

        Integer gasto = ControladorGasto.getInstance().gastosExtraordinariosbyConsorcio(consorcioDTO.getId())
                        + ControladorGasto.getInstance().gastosOrdinariosbyConsorcio(consorcioDTO.getId())
                        ;
        lblTotalGasto = new JLabel("$ " + gasto.toString());
        lblTotalGasto.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblTotalGasto.setHorizontalAlignment(0);

        lblCargaSaldo = new JLabel("Cargar saldo:   ");
        lblCargaSaldo.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblCargaSaldo.setHorizontalAlignment(0);

        lblUsoSaldo = new JLabel("Usar saldo:   ");
        lblUsoSaldo.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblUsoSaldo.setHorizontalAlignment(0);

        txtUsoSaldo = new JTextField();
        txtCargaSaldo = new JTextField();

        btnNotificar = new JButton("NOTIFICAR");
        btnNotificar.setPreferredSize(new Dimension(140, 40));

        btnLiquidar = new JButton("LIQUIDAR");
        btnLiquidar.setPreferredSize(new Dimension(140, 40));

        txtCargaSaldo.setEnabled(false);
        txtUsoSaldo.setEnabled(false);
        lblCargaSaldo.setFont(new Font(Style.FONT, Font.ITALIC, 18));
        lblCargaSaldo.setForeground(Color.GRAY);
        lblUsoSaldo.setFont(new Font(Style.FONT, Font.ITALIC, 18));
        lblUsoSaldo.setForeground(Color.GRAY);

        panelBtn.add(btnNotificar);
        panelBtn.add(btnLiquidar);

        panelForm.add(lblAdmin);
        panelForm.add(lblLogged);
        panelForm.add(lblSaldo);
        panelForm.add(lblSaldoCuenta);
        panelForm.add(lblTotal);
        panelForm.add(lblTotalGasto);
        panelForm.add(lblCargaSaldo);
        panelForm.add(txtCargaSaldo);
        panelForm.add(lblUsoSaldo);
        panelForm.add(txtUsoSaldo);

        panelIz.add(lblOpciones);
        panelIz.add(btnPCG);
        panelIz.add(btnPCFR);
        panelIz.add(btnPCGFFR);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);

        panelDe.add(lblLiquidacion, BorderLayout.NORTH);
        panelDe.add(panelForm, BorderLayout.CENTER);
        panelDe.add(panelBtn, BorderLayout.SOUTH);

        btnPCG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCargaSaldo.setEnabled(false);
                txtUsoSaldo.setEnabled(false);
                lblCargaSaldo.setFont(new Font(Style.FONT, Font.ITALIC, 18));
                lblCargaSaldo.setForeground(Color.GRAY);
                lblUsoSaldo.setFont(new Font(Style.FONT, Font.ITALIC, 18));
                lblUsoSaldo.setForeground(Color.GRAY);
            }
        });

        btnPCFR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            lblLiquidacion.setText("LIQUIDACION DE EXPNSAS: \nPago Completo con Fondos de Reservas");
                txtUsoSaldo.setEnabled(true);
                txtCargaSaldo.setEnabled(false);
                lblCargaSaldo.setFont(new Font(Style.FONT, Font.ITALIC, 18));
                lblCargaSaldo.setForeground(Color.GRAY);
                lblUsoSaldo.setFont(new Font(Style.FONT, Font.BOLD, 18));
                lblUsoSaldo.setForeground(Color.BLACK);
            }
        });

        btnPCGFFR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblLiquidacion.setText("LIQUIDACION DE EXPNSAS: \nPago Completo y Generar Futuros Fondos de Reservas");
                txtCargaSaldo.setEnabled(true);
                txtUsoSaldo.setEnabled(false);
                lblCargaSaldo.setFont(new Font(Style.FONT, Font.BOLD, 18));
                lblCargaSaldo.setForeground(Color.BLACK);
                lblUsoSaldo.setFont(new Font(Style.FONT, Font.ITALIC, 18));
                lblUsoSaldo.setForeground(Color.GRAY);
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

        btnNotificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnLiquidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
