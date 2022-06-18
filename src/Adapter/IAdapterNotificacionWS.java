package Adapter;

import Negocio.Comunicacion.Notificacion;

public interface IAdapterNotificacionWS {
    void enviarWhatsapp(Notificacion notificacion);
}
