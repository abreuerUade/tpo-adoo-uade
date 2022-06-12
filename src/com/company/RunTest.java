package com.company;

import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;
import Data.Data;
import GUI.MasterFrame;
import Negocio.LiquidacionGenerica;
import Test.TestLiquidacion;
import Test.TestUnidadFuncional;

import java.util.ArrayList;

public class RunTest {
     public static void main(String[] args) {
          // Ingresa datos de prueba.
          Data.load();





          // Algunos test

          //TestAutenticar.testing();
          //TestGastos.testing();
          //TestUnidadFuncional.testing();

          TestLiquidacion.testing();
     }
}