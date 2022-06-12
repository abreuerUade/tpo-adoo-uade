package Negocio.Comunicacion;
import interfaces.EstrategiaDeNotificacion;

public class NotificacionSMS implements EstrategiaDeNotificacion {

    public void enviar (Notificacion notificacion) {
        System.out.println("Se mando un sms a "+notificacion.getDestinatario().getTelefono());
    }
}
