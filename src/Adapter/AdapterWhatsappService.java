package Adapter;

import Negocio.Comunicacion.Notificacion;

public class AdapterWhatsappService implements IAdapterNotificacionWS{
    @Override
    public void enviarWhatsapp(Notificacion notificacion) {
        System.out.println("Se envio un Whatsapp a:" + notificacion.getDestinatario().getTelefono());
    }
}
