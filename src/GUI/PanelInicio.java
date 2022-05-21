package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;

public class PanelInicio extends JPanel {

    private JPanel basePanel;
    private MasterFrame masterFrame;
    private JLabel line1;
    private JLabel line2;
    private JLabel line3;
    private JLabel line4;
    private JButton inicioButton;

    public PanelInicio (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelInicio() {

        GridLayout layout = new GridLayout(6, 1);
        layout.setVgap(10);
        basePanel = new JPanel();
        basePanel.setLayout(layout);
        this.add(basePanel);

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

        inicioButton = new JButton("¡EMPECEMOS!");

        basePanel.add(line1);
        basePanel.add(line2);
        basePanel.add(line3);
        basePanel.add(line4);
        basePanel.add(inicioButton);

        inicioButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });
    }


}
