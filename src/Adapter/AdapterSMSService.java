package Adapter;

import Negocio.Comunicacion.Notificacion;

public class AdapterSMSService implements IAdapterNotificacionSMS{
    @Override
    public void enviarSMS(Notificacion notificacion) {
        System.out.println("Se envio SMS a: " + notificacion.getDestinatario().getTelefono());
    }
}
