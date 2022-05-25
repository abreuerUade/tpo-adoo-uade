package GUI;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    JFrame frame;
    PanelInicio panelInicio;
    PanelLogin panelLogin;
    PanelPrincipal panelPrincipal;
    PanelGastos panelGastos;
    PanelUsuarios panelUsuarios;
    PanelAltaUsuario panelAltaUsuario;
    PanelAltaConsorcio panelAltaConsorcio;
    PanelAltaGastos panelAltaGastos;
    PanelUnidadesFuncionales panelUnidadesFuncionales;
    PanelAltaUnidadFuncional panelAltaUnidadFuncional;


    public void armarMaster() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 500);
        frame.setLayout(new GridLayout(1,1));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Administrador de Consorcios");

        panelInicio = new PanelInicio(this);
        panelInicio.armarPanelInicio();

        panelLogin = new PanelLogin(this);
        panelLogin.armarPanelLogin();

        panelPrincipal = new PanelPrincipal(this);
        panelPrincipal.armarPanelPrincipal();

        panelGastos = new PanelGastos(this);
        panelGastos.armarPanelGastos();

        panelUsuarios = new PanelUsuarios(this);
        panelUsuarios.armarPanelUsuarios();

        panelAltaUsuario = new PanelAltaUsuario(this);
        panelAltaUsuario.armarPanelAltaUsuario();

        panelAltaConsorcio = new PanelAltaConsorcio(this);
        panelAltaConsorcio.armarPanelAltaConsorcio();

        panelAltaGastos = new PanelAltaGastos(this);
        panelAltaGastos.armarPanelAltaGastos();

        panelUnidadesFuncionales = new PanelUnidadesFuncionales(this);
        panelUnidadesFuncionales.armarPanelUnidadesFuncionales();

        panelAltaUnidadFuncional = new PanelAltaUnidadFuncional(this);
        panelAltaUnidadFuncional.armarPanelAltaUnidadFuncional();

    }

    public void mostrarPanelInicio(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelInicio);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelLogin() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelLogin);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelPrincipal() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelPrincipal);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void mostrarPanelGastos() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelGastos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelUsuarios() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelUsuarios);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaUsuario() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelAltaUsuario);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void mostrarPanelAltaConsorcio() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelAltaConsorcio);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaGastos() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelAltaGastos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelUnidadesFuncionales() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelUnidadesFuncionales);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaunidadFuncional() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelAltaUnidadFuncional);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void showFrame () {
            frame.setVisible(true);
        }


}
