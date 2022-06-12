package Negocio.Comunicacion;

import Negocio.Persona;

public class Notificacion {

    private Persona destinatario;
    private String mensaje;

    public Persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
