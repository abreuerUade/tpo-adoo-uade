package Negocio.Comunicacion;

import interfaces.EstrategiaDeNotificacion;

public class NotificacionesEmail implements EstrategiaDeNotificacion {

    public void enviar (Notificacion notificacion) {
        System.out.println("Se mando un email a "+notificacion.getDestinatario().getMail());
    }
}