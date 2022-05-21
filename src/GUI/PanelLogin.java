package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JPanel{

    private MasterFrame masterFrame;
    private JPanel basePanel;
    private JLabel panelLabel;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public PanelLogin(MasterFrame masterFrame) {

    }

    public void armarPanelLogin() {

        GridLayout layout = new GridLayout(6, 1);
        layout.setVgap(10);
        basePanel = new JPanel();
        basePanel.setLayout(layout);

        this.add(basePanel);

        panelLabel = new JLabel("POR FAVOR REGISTRESE:");
        panelLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        panelLabel.setHorizontalAlignment(0);

        userLabel = new JLabel("Ingrese su nombre su usuario:");
        userLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        userLabel.setHorizontalAlignment(0);

        passLabel = new JLabel("Ingrese su contraseña");
        passLabel.setHorizontalAlignment(0);
        passLabel.setFont(new Font("Calibri", Font.PLAIN, 18));

        userField = new JTextField("Usuario");
        userField.setFont(new Font("Calibri", Font.PLAIN, 16));
        userField.setHorizontalAlignment(0);

        passField = new JPasswordField();
        passField.setHorizontalAlignment(0);

        loginButton = new JButton("ENTRAR");

        basePanel.add(panelLabel);
        basePanel.add(userLabel);
        basePanel.add(userField);
        basePanel.add(passLabel);
        basePanel.add(passField);
        basePanel.add(loginButton);

    }
}
