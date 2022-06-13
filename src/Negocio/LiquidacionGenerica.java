package Negocio;
import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;

import java.util.ArrayList;
import java.util.Date;

public abstract class LiquidacionGenerica {
    private Consorcio liquidarConsorcio;
    private Date fechaliquidacion;

    public float obtenerSaldo (int idconsorcio) {
        return ControladorConsorcio.getInstance().saldoConsorcio(idconsorcio);
    }

    public ArrayList calcularGastos (int idconsorcio) {
        Integer gastoOrdinario = 0;
        Integer extraordinario = 0;
        ArrayList<Integer> gastos = new ArrayList<Integer>();
        if (ControladorConsorcio.getInstance().existeConsorcio(idconsorcio)){
            gastoOrdinario = ControladorGasto.getInstance().gastosOrdinariosbyConsorcio(idconsorcio);
            extraordinario = ControladorGasto.getInstance().gastosExtraordinariosbyConsorcio(idconsorcio);
            gastos.add(gastoOrdinario); //en el indice 0 los gastos ordinarios
            gastos.add(extraordinario); //en el indice 1 los gastos Extraordinarios
        }
        return gastos;
    }

    public abstract void DivisionExpensas (int idconsorcio, ArrayList<Integer> gastos);

}
