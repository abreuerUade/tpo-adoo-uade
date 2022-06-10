package Negocio;
import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;

import java.util.Date;

public abstract class LiquidacionGenerica {
    private Consorcio liquidarConsorcio;
    private Date fechaliquidacion;

    public float obtenerSaldo (int idconsorcio) {
        return ControladorConsorcio.getInstance().saldoConsorcio(idconsorcio);
    }

    public Integer calcularGastos (int idconsorcio) {
        Integer gasto = 0;
        if (ControladorConsorcio.getInstance().existeConsorcio(idconsorcio)){
            gasto = ControladorGasto.getInstance().gastosbyConsorcio(idconsorcio);
        }
        return gasto;
    }

    public abstract float DivisionExpensas ();

}
