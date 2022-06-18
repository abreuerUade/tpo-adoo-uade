package GUI;

import Controllers.ControladorUsuario;
import DTO.*;

import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {

    private JFrame frame;
    private PanelInicio panelInicio;
    private PanelLogin panelLogin;
    private PanelPrincipal panelPrincipal;
    private PanelGastos panelGastos;
    private PanelUsuarios panelUsuarios;
    private PanelAltaUsuario panelAltaUsuario;
    private PanelAltaConsorcio panelAltaConsorcio;
    private PanelAltaGastos panelAltaGastos;
    private PanelUnidadesFuncionales panelUnidadesFuncionales;
    private PanelAltaUnidadFuncional panelAltaUnidadFuncional;
    private PanelPersonas panelPersonas;
    private PanelAltaPersonas panelAltaPersonas;
    private PanelLiquidacion panelLiquidacion;
    private PanelFacturas panelFacturas;
    public static String loggedUserMail;


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
        panelPersonas = new PanelPersonas(this);
        panelAltaPersonas = new PanelAltaPersonas(this);
        panelLiquidacion = new PanelLiquidacion(this);
        panelFacturas = new PanelFacturas(this);

    }

    public void setLoggedUser(String user){
        loggedUserMail = user;
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

    public void mostrarPanelGastos(ConsorcioDTO consorcioDTO) {
        frame.getContentPane().removeAll();
        panelGastos.armarPanelGastos(consorcioDTO);
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

    public void mostrarPanelAltaGastos(ConsorcioDTO consorcioDTO, GastoDTO gastoDTO) {
        frame.getContentPane().removeAll();
        panelAltaGastos.armarPanelAltaGastos(consorcioDTO, gastoDTO);
        frame.getContentPane().add(panelAltaGastos);
        panelAltaGastos.cargarCampos(gastoDTO);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void mostrarPanelUnidadesFuncionales(ConsorcioDTO consorcioDTO) {
        frame.getContentPane().removeAll();
        panelUnidadesFuncionales.armarPanelUnidadesFuncionales(consorcioDTO);
        frame.getContentPane().add(panelUnidadesFuncionales);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaunidadFuncional(ConsorcioDTO consorcioDTO, UnidadFuncionalDTO unidadFuncionalDTO) {
        frame.getContentPane().removeAll();
        panelAltaUnidadFuncional.armarPanelAltaUnidadFuncional(consorcioDTO, unidadFuncionalDTO);
        frame.getContentPane().add(panelAltaUnidadFuncional);
        panelAltaUnidadFuncional.cargarCampos(unidadFuncionalDTO);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelPersonas(ConsorcioDTO consorcioDTO) {
        frame.getContentPane().removeAll();
        panelPersonas.armarPanelPersonas(consorcioDTO);
        frame.getContentPane().add(panelPersonas);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelAltaPersonas(ConsorcioDTO consorcioDTO, PersonaDTO personaDTO) {
        frame.getContentPane().removeAll();
        panelAltaPersonas.armarPanelAltaPersonas(consorcioDTO, personaDTO);
        frame.getContentPane().add(panelAltaPersonas);
        panelAltaPersonas.cargarCampos(personaDTO);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void mostrarPanelLiquidacion(ConsorcioDTO consorcioDTO) {
        frame.getContentPane().removeAll();
        panelLiquidacion.armarPanelLiquidacion(consorcioDTO);
        frame.getContentPane().add(panelLiquidacion);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelFacturas(ConsorcioDTO consorcioDTO, UnidadFuncionalDTO unidadFuncionalDTO) {
        frame.getContentPane().removeAll();
        panelFacturas.armarPanelFacturas(consorcioDTO, unidadFuncionalDTO);
        frame.getContentPane().add(panelFacturas);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void showFrame () {
            frame.setVisible(true);
        }


}
