package GUI;

import Auth.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogin extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;
    private JPanel panelForm;
    private JPanel panelBtn;

    private JLabel lblPanel;
    private JLabel lblUser;
    private JLabel lblPass;
    private JLabel lblIntegrantes;
    private JLabel lblMazza;
    private JLabel lblBreuer;
    private JLabel lblBarros;
    private JLabel lblDiaz;
    private JTextField txtUser;
    private JPasswordField passField;
    private JButton btnLogin;

    public PanelLogin (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelLogin() {
        this.removeAll();
        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6,1);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(250,500));
        panelIz.setBackground(Style.GRIS_CLARO);

        panelDe = new JPanel();
        BorderLayout rightLayout = new BorderLayout(30,30);
        panelDe.setLayout(rightLayout);
        panelDe.setPreferredSize(new Dimension(750,500));
        panelDe.setBackground(Style.FONDO);
        panelDe.setBorder(BorderFactory.createEmptyBorder(30, 50, 20, 50));

        panelBtn = new JPanel();
        panelBtn.setBackground(Style.FONDO);
        

        this.add(panelIz, BorderLayout.WEST);
        this.add(panelDe, BorderLayout.CENTER);


        //////////////////////////////////////////////////////////////////

        lblIntegrantes = new JLabel("Integrantes: ");
        lblIntegrantes.setFont(new Font(Style.FONT, Font.BOLD, 18));

        lblBarros = new JLabel("Barros, Matias Andres");
        lblBarros.setFont(new Font(Style.FONT, Font.PLAIN, 16));

        lblBreuer = new JLabel("Breuer, Andres Ivan");
        lblBreuer.setFont(new Font(Style.FONT, Font.PLAIN, 16));

        lblDiaz = new JLabel("Dias Gestner, Federico");
        lblDiaz.setFont(new Font(Style.FONT, Font.PLAIN, 16));

        lblMazza = new JLabel("Mazza, Carlos Ilan");
        lblMazza.setFont(new Font(Style.FONT, Font.PLAIN, 16));

        panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(2,2, 30, 30));
        panelForm.setBackground(Style.FONDO);
        panelForm.setBorder(BorderFactory.createEmptyBorder(50, 50, 100, 80));

        lblPanel = new JLabel("POR FAVOR REGISTRESE:");
        lblPanel.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblPanel.setHorizontalAlignment(0);

        lblUser = new JLabel("Ingrese su mail: ");
        lblUser.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblUser.setHorizontalAlignment(JLabel.RIGHT);

        lblPass = new JLabel("Ingrese su contrase??a: ");
        lblPass.setFont(new Font(Style.FONT, Font.PLAIN, 18));
        lblPass.setHorizontalAlignment(JLabel.RIGHT);

        txtUser = new JTextField();
        txtUser.setPreferredSize(new Dimension(200, 35));
        txtUser.setFont(new Font(Style.FONT, Font.PLAIN, 16));

        passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(200, 35));

        btnLogin = new JButton("ENTRAR");
        btnLogin.setPreferredSize(new Dimension(200, 40));
        btnLogin.setHorizontalAlignment(0);

        panelIz.add(lblIntegrantes);
        panelIz.add(lblBarros);
        panelIz.add(lblBreuer);
        panelIz.add(lblDiaz);
        panelIz.add(lblMazza);
        panelForm.add(lblUser);
        panelForm.add(txtUser);
        panelForm.add(lblPass);
        panelForm.add(passField);
        panelBtn.add(btnLogin);

        panelDe.add(lblPanel, BorderLayout.NORTH);
        panelDe.add(panelForm, BorderLayout.CENTER);
        panelDe.add(panelBtn, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mail = txtUser.getText();
                String pass = String.copyValueOf(passField.getPassword());

                if(Autenticador.getInstance().autenticar(mail, pass)) {
                    masterFrame.setLoggedUser(mail);
                    masterFrame.mostrarPanelPrincipal();
                }
                else {
                    JOptionPane.showMessageDialog(masterFrame,"Ingrese mail y contrase??a v??lidos.");
                }

            }
        });


    }
}


