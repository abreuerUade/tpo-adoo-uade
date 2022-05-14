package Negocio;

import java.util.Date;

public class FacturaUnidadFuncional {

    private float montoExtraordinario;
    private float montoOrdinario;
    private boolean pago;
    private Date fecha;

    public void confirmarPago() {

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
