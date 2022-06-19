package com.company;
import Data.Data;
import GUI.MasterFrame;


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
