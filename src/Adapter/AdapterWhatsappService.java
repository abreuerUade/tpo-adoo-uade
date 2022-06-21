package Adapter;

import Negocio.Notificacion;

public class AdapterWhatsappService implements IAdapterNotificacionWS{
    @Override
    public void enviarWhatsapp(Notificacion notificacion) {
        System.out.println("Destinatario: " + notificacion.getDestinatario().getNombre() +" "+ notificacion.getDestinatario().getApellido());
        System.out.println("Se mando un Whatapp a " + notificacion.getDestinatario().getTelefono());
        System.out.println("Resumen de Expensas: " + notificacion.getMensaje());
    }
}
