package Negocio.Comunicacion;
import Adapter.IAdapterNotificacionSMS;
import interfaces.EstrategiaDeNotificacion;

public class NotificacionSMS implements EstrategiaDeNotificacion {

    private IAdapterNotificacionSMS adapter;

    public NotificacionSMS(IAdapterNotificacionSMS adapter){
        super();
        this.adapter = adapter;
    }
    public void setAdapter(IAdapterNotificacionSMS adapter){
        this.adapter = adapter;
    }
    public void enviar (Notificacion notificacion) {
        this.adapter.enviarSMS(notificacion);
    }
}
