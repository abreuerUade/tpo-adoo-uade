package com.company;

import Controllers.ControladorConsorcio;
import Data.Data;
import GUI.MasterFrame;
import Negocio.LiquidacionGenerica;
import Test.TestUnidadFuncional;

public class RunTest {
     public static void main(String[] args) {
          // Ingresa datos de prueba.
          Data.load();

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
          ControladorConsorcio.getInstance().notificarLiquidacion(ControladorConsorcio.getInstance().getConsorcioDTO(1));

     }
}