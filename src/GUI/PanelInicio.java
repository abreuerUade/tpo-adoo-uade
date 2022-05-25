package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInicio extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;
    private JPanel panelBtn;

    private JLabel line1;
    private JLabel line2;
    private JLabel line3;
    private JLabel line4;
    private JButton inicioButton;

    public PanelInicio (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelInicio() {

        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6,1);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(200,500));
        panelIz.setBackground(Style.GRIS_CLARO);

        panelDe = new JPanel();
        GridLayout rightLayout = new GridLayout(5,1);
        panelDe.setLayout(rightLayout);
        panelDe.setPreferredSize(new Dimension(800,500));
        panelDe.setBackground(Style.FONDO);

        panelBtn = new JPanel();
        panelBtn.setBackground(Style.FONDO);

        this.add(panelIz, BorderLayout.WEST);
        this.add(panelDe, BorderLayout.CENTER);
        panelDe.add(panelBtn);


        //////////////////////////////////////////////////////////////////

        line1 = new JLabel("Proceso de Desarrollo de Software");
        line1.setFont(new Font(Style.FONT, Font.BOLD, 18));
        line1.setHorizontalAlignment(0);

        line2 = new JLabel("Administración de Consorcios");
        line2.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        line2.setHorizontalAlignment(0);

        line3 = new JLabel("TPO - GRUPO 9");
        line3.setHorizontalAlignment(0);
        line3.setFont(new Font(Style.FONT, Font.PLAIN, 18));

        line4 = new JLabel("UADE");
        line4.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        line4.setHorizontalAlignment(0);

        inicioButton = new JButton("¡EMPECEMOS!");
        inicioButton.setPreferredSize(new Dimension(200, 40));
        inicioButton.setHorizontalAlignment(0);

        panelDe.add(line1);
        panelDe.add(line2);
        panelDe.add(line3);
        panelDe.add(line4);
        panelDe.add(panelBtn);
        panelBtn.add(inicioButton);

        inicioButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });
    }
}


