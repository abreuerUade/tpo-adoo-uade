package GUI;

import DTO.ConsorcioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLiquidacion extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;

    private JLabel lblOpciones;
    private JLabel lblLiquidacion;
    // Pago Completo de Gastos
    private JButton btnPCG;
    // Pago Completo con Fondos de Reservas
    private JButton btnPCFR;
    // Pago Completo y Generar Futuros Fondos de Reservas
    private JButton btnPCGFFR;
    private JButton btnAtras;
    private JButton btnSalir;
    private JButton btnNotificar;



    public PanelLiquidacion (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }
    public void armarPanelLiquidacion(ConsorcioDTO consorcioDTO){
        this.removeAll();
        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        btnPCG = new JButton("Pago Completo de Gastos");
        btnPCG.setPreferredSize(new Dimension(180, 40));
        btnPCG.setHorizontalAlignment(0);

        btnPCFR = new JButton("Pago Completo con \n Fondos de Reservas");
        btnPCFR.setPreferredSize(new Dimension(180, 40));
        btnPCFR.setHorizontalAlignment(0);

        btnPCGFFR = new JButton("Pago Completo y Generar \n Futuros Fondos de Reservas");
        btnPCGFFR.setPreferredSize(new Dimension(180, 40));
        btnPCGFFR.setHorizontalAlignment(0);

        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

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

        lblLiquidacion = new JLabel("LIQUIDACIÓN DE EXPENSAS");
        lblLiquidacion.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblLiquidacion.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        panelDe.add(lblLiquidacion, BorderLayout.NORTH);
        panelIz.add(lblOpciones);
        panelIz.add(btnPCG);
        panelIz.add(btnPCFR);
        panelIz.add(btnPCGFFR);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);


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
