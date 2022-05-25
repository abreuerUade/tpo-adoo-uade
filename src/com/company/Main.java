package com.company;
import Controllers.*;
import Data.Data;
import GUI.MasterFrame;
import Auth.*;

import java.net.Authenticator;
import java.security.AuthProvider;

public class Main {

    public static void main(String[] args) {
        MasterFrame master = new MasterFrame();
        master.armarMaster();
        master.mostrarPanelInicio();
        master.showFrame();
        Data.load();
        //System.out.println(ControladorUsuario.getInstance().getUsuarios());
        System.out.println(Autenticador.getInstance().autenticar("rr@consorcios.com", 123 ));
    }
}
