package Negocio;

import Controllers.ControladorUnidadFuncional;

import java.util.Date;

public class Facturador {

    public static void crearFactura(int idUF, float gastos_ordinarios, float gastos_extraordinarios, float reservas){
        FacturaUnidadFuncional factura = new FacturaUnidadFuncional(gastos_extraordinarios,gastos_ordinarios,reservas,false, new Date());

        ControladorUnidadFuncional.getInstance().agregarFactura(factura, idUF);
    }

    public static void crearFactura(int idUF, float gastos_ordinarios, float gastos_extraordinarios){
        FacturaUnidadFuncional factura = new FacturaUnidadFuncional(gastos_extraordinarios,gastos_ordinarios,0,false, new Date());

        ControladorUnidadFuncional.getInstance().agregarFactura(factura, idUF);
    }
}
