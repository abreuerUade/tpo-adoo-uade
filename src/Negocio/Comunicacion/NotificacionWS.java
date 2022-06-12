package Negocio.Comunicacion;

import interfaces.EstrategiaDeNotificacion;

public class NotificacionWS implements EstrategiaDeNotificacion {

    public void enviar (Notificacion notificacion) {
        System.out.println("Se mando un Whatsapp a "+notificacion.getDestinatario().getTelefono());
    }
}
