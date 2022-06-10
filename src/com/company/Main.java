package com.company;
import Controllers.*;
import Data.Data;
import GUI.MasterFrame;
import Auth.*;
import Negocio.LiquidacionGenerica;

import java.net.Authenticator;

public class Main {

    public static void main(String[] args) {
        // Ingresa datos de prueba.
        Data.load();
        // Inicializar Vistas.
        MasterFrame master = new MasterFrame();
        master.armarMaster();
        master.mostrarPanelInicio();
        master.showFrame();


        // Algunos test
        LiquidacionGenerica liquidacionConsorcio1 = new LiquidacionGenerica() {
            @Override
            public float DivisionExpensas() {
                return 0;
            }
        };
        System.out.println(liquidacionConsorcio1.calcularGastos(1));

        //ControladorGasto.getInstance().verGastos(1);

    }




}
