package Adapter;

import Negocio.Comunicacion.Notificacion;

public interface IAdapterNotificacionSMS {
    void enviarSMS(Notificacion notificacion);
}
