package Adapter;

import Negocio.Notificacion;

public class AdapterJavaMail implements IAdapterNotificacionEmail{

    @Override
    public void enviarEmail(Notificacion notificacion) {
        System.out.println("Destinatario: " + notificacion.getDestinatario().getNombre() +" "+ notificacion.getDestinatario().getApellido());
        System.out.println("Se mando un mail a " + notificacion.getDestinatario().getMail());
        System.out.println("Resumen de Expensas: " + notificacion.getMensaje());
    }
}
