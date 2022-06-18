package Negocio;

import Controllers.ControladorConsorcio;
import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;

import java.util.ArrayList;

public class PagoCompleto extends LiquidacionGenerica{
    //Dividir los gastos entre todas las unidades funcionales y generar sus facturas.
    @Override

    public void DivisionExpensas(int idconsorcio, Integer generarReserva, Integer usarReserva) {
        ArrayList<UnidadFuncionalDTO> listUF = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(idconsorcio);
        float superficieTotal = ControladorUnidadFuncional.getInstance().calcularSuperficieTotalbyConsorcio(idconsorcio);
        ArrayList <Integer> gastos = calcularGastos(idconsorcio);
        for (UnidadFuncionalDTO uf:listUF){
            float coeficiente = uf.getSuperficie()/superficieTotal;
            float expensaOrdinaria = gastos.get(0)*coeficiente;
            float expensaExtraordinaria = gastos.get(1)*coeficiente;
            Facturador.crearFactura(uf.getIdUnidadFuncional(), expensaOrdinaria, expensaExtraordinaria);
        }
    }
}
