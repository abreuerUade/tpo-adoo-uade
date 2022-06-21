package Adapter;

import Negocio.Notificacion;

public interface IAdapterNotificacionWS {
    void enviarWhatsapp(Notificacion notificacion);
}
