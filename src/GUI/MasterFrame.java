package GUI;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    JFrame frame;
    PanelInicio panelInicio;
    PanelLogin panelLogin;


    public void armarMaster() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);

        frame.setDefaultCloseOperation(3);
        frame.setResizable(true);
        frame.setTitle("Administrador de Consorcios");

        panelInicio = new PanelInicio(this);
        panelInicio.armarPanelInicio();

        panelLogin = new PanelLogin(this);
        panelLogin.armarPanelLogin();



    }

    public void mostrarPanelInicio(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelInicio);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void mostrarPanelLogin(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelLogin);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void showFrame (){
        frame.setVisible(true);
    }


}
