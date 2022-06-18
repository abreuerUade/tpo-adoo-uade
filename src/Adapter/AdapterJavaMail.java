package Adapter;

import Negocio.Comunicacion.Notificacion;

public class AdapterJavaMail implements IAdapterNotificacionEmail{

    @Override
    public void enviarEmail(Notificacion notificacion) {
        System.out.println("Se mando un mail a " + notificacion.getDestinatario().getMail());
    }
}
