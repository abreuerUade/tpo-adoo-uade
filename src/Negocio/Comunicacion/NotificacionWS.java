package Negocio.Comunicacion;

import Adapter.IAdapterNotificacionWS;
import Negocio.Notificacion;
import interfaces.EstrategiaDeNotificacion;

public class NotificacionWS implements EstrategiaDeNotificacion {

    private IAdapterNotificacionWS adapter;

    public NotificacionWS(IAdapterNotificacionWS adapter){
        super();
        this.adapter = adapter;
    }
    public void setAdapter(IAdapterNotificacionWS adapter){
        this.adapter = adapter;
    }

    public void enviar (Notificacion notificacion) {
        this.adapter.enviarWhatsapp(notificacion);
    }
}
