package Adapter;

import Negocio.Notificacion;

public interface IAdapterNotificacionSMS {
    void enviarSMS(Notificacion notificacion);
}
