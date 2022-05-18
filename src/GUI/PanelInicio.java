package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel {

    private MasterFrame masterFrame;
    private JPanel basePanel;
    private JLabel line1;
    private JLabel line2;
    private JLabel line3;
    private JLabel line4;
    private JButton inicio;

    public PanelInicio (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelInicio() {

        this.setLayout(new GridLayout(5,3));


        line1 = new JLabel("Proceso de Desarrollo de Software");
        line1.setFont(new Font("Calibri", Font.BOLD, 18));
        line1.setHorizontalAlignment(0);

        line2 = new JLabel("Administración de Consorcios");
        line2.setFont(new Font("Calibri", Font.PLAIN, 18));
        line2.setHorizontalAlignment(0);

        line3 = new JLabel("TPO - GRUPO 9");
        line3.setHorizontalAlignment(0);
        line3.setFont(new Font("Calibri", Font.PLAIN, 18));

        line4 = new JLabel("UADE");
        line4.setFont(new Font("Calibri", Font.PLAIN, 18));
        line4.setHorizontalAlignment(0);

        inicio = new JButton("¡EMPECEMOS!");

        this.add(line1);
        this.add(line2);
        this.add(line3);
        this.add(line4);
        this.add(inicio);

    }


}
