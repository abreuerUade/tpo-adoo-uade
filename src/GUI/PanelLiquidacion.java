package GUI;

import DTO.ConsorcioDTO;

import javax.swing.*;
import java.awt.*;

public class PanelLiquidacion extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;

    private JLabel lblOpciones;
    private JLabel lblLiquidacion;


    public PanelLiquidacion (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }
    public void armarPanelLiquidacion(ConsorcioDTO consorcioDTO){
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

        lblLiquidacion = new JLabel("LIQUIDACIÓN DE EXPENSAS");
        lblLiquidacion.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblLiquidacion.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        panelDe.add(lblLiquidacion, BorderLayout.NORTH);
        panelIz.add(lblOpciones);

    }

}
