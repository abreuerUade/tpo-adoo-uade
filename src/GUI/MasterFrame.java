package GUI;

import DTO.ConsorcioDTO;
import DTO.UsuarioDTO;

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
        panelLogin = new PanelLogin(this);
        panelPrincipal = new PanelPrincipal(this);
        panelGastos = new PanelGastos(this);
        panelUsuarios = new PanelUsuarios(this);
        panelAltaUsuario = new PanelAltaUsuario(this);
        panelAltaConsorcio = new PanelAltaConsorcio(this);
        panelAltaGastos = new PanelAltaGastos(this);
        panelUnidadesFuncionales = new PanelUnidadesFuncionales(this);
        panelAltaUnidadFuncional = new PanelAltaUnidadFuncional(this);

    }

    public void mostrarPanelInicio(){
        frame.getContentPane().removeAll();
        panelInicio.armarPanelInicio();
        frame.getContentPane().add(panelInicio);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelLogin() {
        frame.getContentPane().removeAll();
        panelLogin.armarPanelLogin();
        frame.getContentPane().add(panelLogin);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelPrincipal() {
        frame.getContentPane().removeAll();
        panelPrincipal.armarPanelPrincipal();
        frame.getContentPane().add(panelPrincipal);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void mostrarPanelGastos() {
        frame.getContentPane().removeAll();
        panelGastos.armarPanelGastos();
        frame.getContentPane().add(panelGastos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelUsuarios() {
        frame.getContentPane().removeAll();
        panelUsuarios.armarPanelUsuarios();
        frame.getContentPane().add(panelUsuarios);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaUsuario() {
        frame.getContentPane().removeAll();
        panelAltaUsuario.armarPanelAltaUsuario();
        frame.getContentPane().add(panelAltaUsuario);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaUsuario(UsuarioDTO usuario) {
        frame.getContentPane().removeAll();
        panelAltaUsuario.armarPanelAltaUsuario();
        frame.getContentPane().add(panelAltaUsuario);
        panelAltaUsuario.cargarCampos(usuario);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void mostrarPanelAltaConsorcio(ConsorcioDTO consorcio) {
        frame.getContentPane().removeAll();
        panelAltaConsorcio.armarPanelAltaConsorcio(consorcio);
        frame.getContentPane().add(panelAltaConsorcio);
        panelAltaConsorcio.cargarCampos(consorcio);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void mostrarPanelAltaGastos() {
        frame.getContentPane().removeAll();
        panelAltaGastos.armarPanelAltaGastos();
        frame.getContentPane().add(panelAltaGastos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelUnidadesFuncionales() {
        frame.getContentPane().removeAll();
        panelUnidadesFuncionales.armarPanelUnidadesFuncionales();
        frame.getContentPane().add(panelUnidadesFuncionales);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaunidadFuncional() {
        frame.getContentPane().removeAll();
        panelAltaUnidadFuncional.armarPanelAltaUnidadFuncional();
        frame.getContentPane().add(panelAltaUnidadFuncional);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    public void showFrame () {
            frame.setVisible(true);
        }


}