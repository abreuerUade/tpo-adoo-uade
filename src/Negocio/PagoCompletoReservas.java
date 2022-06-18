package Negocio;

import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;
import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;

import java.util.ArrayList;

public class PagoCompletoReservas extends LiquidacionGenerica{
    //Descontar del total un valor disponible en el salgo y Dividir el resto entre todas las unidades funcionales y generar sus facturas.
    @Override
    public void DivisionExpensas(int idconsorcio, Integer generarReserva, Integer usarReserva) {

        float saldoDisponible = obtenerSaldo(idconsorcio);
        ArrayList<Integer> gastos = this.calcularGastos(idconsorcio);

        if (usarReserva<=saldoDisponible){
            ConsorcioDTO consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(idconsorcio);
            ArrayList<UnidadFuncionalDTO> listUF = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO);
            float superficieTotal = ControladorUnidadFuncional.getInstance().calcularSuperficieTotalbyConsorcio(idconsorcio);
            gastos.set(0, gastos.get(0)-(usarReserva/2));
            gastos.set(1, gastos.get(1)-(usarReserva/2));
            for (UnidadFuncionalDTO uf:listUF){
                float coeficiente = uf.getSuperficie()/superficieTotal;
                float expensaOrdinaria = gastos.get(0)*coeficiente;
                float expensaExtraordinaria = gastos.get(1)*coeficiente;
                Facturador.crearFactura(uf.getIdUnidadFuncional(), expensaOrdinaria, expensaExtraordinaria);;
            }
        }
    }
}