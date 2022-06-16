package com.company;
import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;
import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;
import Data.Data;
import GUI.MasterFrame;
import Negocio.Expensas;
import Negocio.LiquidacionGenerica;
import Negocio.ServiciosEnvio;
import Test.TestAutenticar;
import Test.TestGastos;
import Test.TestUnidadFuncional;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Ingresa datos de prueba.
        Data.load();
        // Inicializar Vistas.
        MasterFrame master = new MasterFrame();
        master.armarMaster();
        master.mostrarPanelInicio();
        master.showFrame();

    }
    
}
