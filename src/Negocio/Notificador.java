package Negocio;

import Negocio.Comunicacion.Notificacion;
import interfaces.EstrategiaDeNotificacion;

public class Notificador {
    private EstrategiaDeNotificacion estrategia;
    public void enviar(Notificacion notificacion) {
        this.estrategia.enviar(notificacion);
    }
    public void setEstrategia(EstrategiaDeNotificacion estrategia) {
        this.estrategia = estrategia;
    }
}
