package Negocio.Comunicacion;

import Adapter.IAdapterNotificacionEmail;
import Negocio.Notificacion;
import interfaces.EstrategiaDeNotificacion;

public class NotificacionEmail implements EstrategiaDeNotificacion {
    private IAdapterNotificacionEmail adapter;

    public NotificacionEmail(IAdapterNotificacionEmail adapter){
        super();
        this.adapter = adapter;
    }
    public void setAdapter(IAdapterNotificacionEmail adapter){
        this.adapter = adapter;
    }
    public void enviar (Notificacion notificacion) {
        this.adapter.enviarEmail(notificacion);
    }
}