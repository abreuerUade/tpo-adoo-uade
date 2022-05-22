package com.company;
import Controllers.*;
import Data.Data;
import GUI.MasterFrame;

public class Main {

    public static void main(String[] args) {
        MasterFrame master = new MasterFrame();
        master.armarMaster();
        master.mostrarPanelInicio();
        master.showFrame();
        Data.load();
        System.out.println(ControladorPersona.getInstance().getPersonabyDNI(25634855));

    }


}
