package Test;

import Controllers.ControladorGasto;
import Negocio.LiquidacionGenerica;

import java.util.ArrayList;

public class TestLiquidacion {

    public static void testing(){

        LiquidacionGenerica liquidacionConsorcio1 = new LiquidacionGenerica() {
            @Override
            public void DivisionExpensas(int idconsorcio, Integer generarReserva, Integer usarReserva) {

            }
        };

        ArrayList<Integer> gastos = liquidacionConsorcio1.calcularGastos(1);

        System.out.println("Suma de los gastos del Consorcio 1: " +
                "\nGastos Ordinarios: " + gastos.get(0)+
                "\nGastos Extraordinarios: " + gastos.get(1)+ "\n");

        ControladorGasto.getInstance().viewGastos(1);

    }
}
