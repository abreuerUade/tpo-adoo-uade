package Adapter;

import Negocio.Notificacion;

public interface IAdapterNotificacionEmail {
    void enviarEmail(Notificacion notificacion);
}
