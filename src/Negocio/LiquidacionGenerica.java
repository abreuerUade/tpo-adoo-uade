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
            gastos.add(gastoOrdinario);
            gastos.add(extraordinario);
        }
        return gastos;
    }

    public abstract float DivisionExpensas ();

}
