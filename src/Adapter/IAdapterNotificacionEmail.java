package Adapter;

import Negocio.Comunicacion.Notificacion;

public interface IAdapterNotificacionEmail {
    void enviarEmail(Notificacion notificacion);
}
