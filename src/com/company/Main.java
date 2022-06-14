package com.company;
import Controllers.ControladorConsorcio;
import DTO.ConsorcioDTO;
import Data.Data;
import GUI.MasterFrame;
import Negocio.LiquidacionGenerica;
import Negocio.ServiciosEnvio;
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

        System.out.println(ControladorConsorcio.getInstance().getConsorcioDTO(1).getNombre());
        ConsorcioDTO consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(1);
        consorcioDTO.setNombre("Carlos");
        ControladorConsorcio.getInstance().editarConsorcio(consorcioDTO);
        System.out.println(ControladorConsorcio.getInstance().getConsorcioDTO(1).getNombre());




    }




}
