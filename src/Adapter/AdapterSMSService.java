package Adapter;

import Negocio.Notificacion;

public class AdapterSMSService implements IAdapterNotificacionSMS{
    @Override
    public void enviarSMS(Notificacion notificacion) {
        System.out.println("Destinatario: " + notificacion.getDestinatario().getNombre() +" "+ notificacion.getDestinatario().getApellido());
        System.out.println("Se mando un SMS a " + notificacion.getDestinatario().getTelefono());
        System.out.println("Resumen de Expensas: " + notificacion.getMensaje());
    }
}
