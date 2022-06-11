package Test;

import Controllers.ControladorGasto;
import DTO.GastoDTO;
import Negocio.Expensas;

import java.util.Date;

public class TestGastos {
    public static void testing(){
        //Reloj
        Date fechaactual = new Date();
        //Expensas
        GastoDTO gasto1 = new GastoDTO();
        gasto1.setId(1);
        gasto1.setMonto(5000);
        gasto1.setNombre("EDESUR");
        gasto1.setFechaFact(fechaactual);
        gasto1.setCantCuotas(2);
        gasto1.setPeriodo(3);
        gasto1.setIdconsorcio(1);
        gasto1.setTipoExpensas(Expensas.ORDINARIAS);

        GastoDTO gasto2 = new GastoDTO();
        gasto2.setId(2);



        ControladorGasto.getInstance().viewGastos(1);
        System.out.println();
        System.out.println();
        System.out.println("TEST PARA MODIFICAR EL GASTO ID 1 Y ELIMINAR EL 2");
        System.out.println();
        System.out.println();
        ControladorGasto.getInstance().modificarGasto(gasto1);
        ControladorGasto.getInstance().eliminarGasto(gasto2);
        ControladorGasto.getInstance().viewGastos(1);


    }

}
