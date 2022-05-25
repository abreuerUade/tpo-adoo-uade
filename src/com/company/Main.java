package com.company;
import Controllers.*;
import Data.Data;
import GUI.MasterFrame;
import Auth.*;

import java.net.Authenticator;

public class Main {

    public static void main(String[] args) {
        Data.load();

        MasterFrame master = new MasterFrame();
        master.armarMaster();
        master.mostrarPanelInicio();
        master.showFrame();
        //Cargar DATOS
        Data.load();


        //TEST Autenticar -- Verificar
        System.out.println(Autenticador.getInstance().autenticar("rr@consorcios.com", "rr@consorcios.com"));
        Autenticador.getInstance().editarPassword("rr@consorcios.com","123");
        System.out.println(Autenticador.getInstance().autenticar("rr@consorcios.com", "123"));

        System.out.println(Autenticador.getInstance().autenticar("admin@consorcios.com", "admin@consorcios.com"));
        Autenticador.getInstance().eliminarCredencial("admin@consorcios.com");
        System.out.println(Autenticador.getInstance().autenticar("admin@consorcios.com", "admin@consorcios.com"));

        //AuthProvider autenticador = new Autenticador().autenticar();
       // System.out.println(autenticador.autenticar("rr@consorcios.com", 123));
        //System.out.println(Autenticador.getInstance().autenticar("rr@consorcios.com", 123 ));


        // Test usuarios

        System.out.println(ControladorUsuario.getInstance().getUsuarios());

    }




}
