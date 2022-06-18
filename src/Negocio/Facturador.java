package Negocio;

import Controllers.ControladorUnidadFuncional;

import java.util.Date;

public class Facturador {

    public static void crearFactura(int idUF, float gastos_ordinarios, float gastos_extraordinarios, float reservas){
        FacturaUnidadFuncional factura = new FacturaUnidadFuncional(gastos_extraordinarios,gastos_ordinarios,reservas);

        ControladorUnidadFuncional.getInstance().agregarFactura(factura, idUF);
        System.out.println("Se agrego una nueva factura a la unidad funcional: " + idUF);
    }

    public static void crearFactura(int idUF, float gastos_ordinarios, float gastos_extraordinarios){
        FacturaUnidadFuncional factura = new FacturaUnidadFuncional(gastos_extraordinarios,gastos_ordinarios,0);

        ControladorUnidadFuncional.getInstance().agregarFactura(factura, idUF);
        System.out.println("Se agrego una nueva factura a la unidad funcional: " + idUF);
    }
}
