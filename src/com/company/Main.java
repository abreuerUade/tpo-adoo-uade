package com.company;
import Controllers.*;
import Data.Data;
import GUI.MasterFrame;
import Auth.*;
import Test.*;

import java.net.Authenticator;

public class Main {

    public static void main(String[] args) {
        //Cargar datos - Inicializador
        Data.load();

        MasterFrame master = new MasterFrame();
        master.armarMaster();
        master.mostrarPanelInicio();
        master.showFrame();

        //Testing
        TestAutenticar.testing();

        //Test Usuarios
        System.out.println(ControladorUsuario.getInstance().getUsuarios());

    }




}
