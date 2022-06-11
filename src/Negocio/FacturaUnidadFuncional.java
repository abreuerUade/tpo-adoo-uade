package Negocio;

import java.util.Date;

public class FacturaUnidadFuncional {

    private int codigoFactura;
    private float montoExtraordinario;
    private float montoOrdinario;
    private boolean pago;
    private Date fecha;

    public void confirmarPago() {

    }

    public FacturaUnidadFuncional(int codigoFactura, float montoExtraordinario, float montoOrdinario, boolean pago, Date fecha) {
        this.codigoFactura = codigoFactura;
        this.montoExtraordinario = montoExtraordinario;
        this.montoOrdinario = montoOrdinario;
        this.pago = pago;
        this.fecha = fecha;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public float getMontoExtraordinario() {
        return montoExtraordinario;
    }

    public void setMontoExtraordinario(float montoExtraordinario) {
        this.montoExtraordinario = montoExtraordinario;
    }

    public float getMontoOrdinario() {
        return montoOrdinario;
    }

    public void setMontoOrdinario(float montoOrdinario) {
        this.montoOrdinario = montoOrdinario;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
