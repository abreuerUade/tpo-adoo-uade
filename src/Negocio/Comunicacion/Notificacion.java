package Negocio.Comunicacion;

import Negocio.LiquidacionGenerica;
import Negocio.Persona;

public class Notificacion {

    private Persona destinatario;
    private LiquidacionGenerica mensaje;

    public Persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }

    public LiquidacionGenerica getMensaje() {
        return mensaje;
    }

    public void setMensaje(LiquidacionGenerica mensaje) {
        this.mensaje = mensaje;
    }
}
