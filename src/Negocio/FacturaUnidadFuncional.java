package Negocio;

import java.util.Date;
import java.util.UUID;

public class FacturaUnidadFuncional {

    private UUID codigoFactura;
    private float montoExtraordinario;
    private float montoOrdinario;
    private float reservas;
    private boolean pago;
    private Date fecha;


    public FacturaUnidadFuncional(float montoExtraordinario, float montoOrdinario, float reservas) {
        this.codigoFactura = UUID.randomUUID();
        this.montoExtraordinario = montoExtraordinario;
        this.montoOrdinario = montoOrdinario;
        this.reservas = reservas;
        this.pago = false;
        this.fecha = new Date();
    }

    public UUID getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(UUID codigoFactura) {
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

    public float getReservas() {
        return reservas;
    }

    public void setReservas(float reservas) {
        this.reservas = reservas;
    }
}
