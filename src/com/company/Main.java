package com.company;
import Data.Data;
import GUI.MasterFrame;
import Negocio.LiquidacionGenerica;
import Test.TestAutenticar;
import Test.TestGastos;
import Test.TestUnidadFuncional;

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
        System.out.println("Suma de los gastos del Consorcio 1: " + liquidacionConsorcio1.calcularGastos(1));

        //TestAutenticar.testing();
        //TestGastos.testing();


        TestUnidadFuncional.testing();


    }




}
