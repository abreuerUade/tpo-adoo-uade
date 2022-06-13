package Negocio;

import Controllers.ControladorConsorcio;
import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;

import java.util.ArrayList;

public class PagoCompleto extends LiquidacionGenerica{
    //Dividir los gastos entre todas las unidades funcionales y generar sus facturas.
    @Override



    public void DivisionExpensas(int idconsorcio, ArrayList<Integer> gastos) {
        ConsorcioDTO consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(idconsorcio);
        ArrayList<UnidadFuncionalDTO> listUF = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO);
        float superficieTotal = ControladorUnidadFuncional.getInstance().calcularSuperficieTotalbyConsorcio(idconsorcio);

        for (UnidadFuncionalDTO uf:listUF){
            float coeficiente = uf.getSuperficie()/superficieTotal;
            float expensaOrdinaria = gastos.get(0)*coeficiente;
            float expensaExtraordinaria = gastos.get(1)*coeficiente;
            Facturador.crearFactura(uf.getNroUnidad(), expensaOrdinaria, expensaExtraordinaria);
        }
    }
}
