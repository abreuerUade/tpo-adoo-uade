package Controllers;

import Adapter.AdapterJavaMail;
import Adapter.AdapterSMSService;
import Adapter.AdapterWhatsappService;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;
import Negocio.*;
import Negocio.Notificacion;
import Negocio.Comunicacion.NotificacionSMS;
import Negocio.Comunicacion.NotificacionWS;
import Negocio.Comunicacion.NotificacionEmail;
import java.util.ArrayList;


public class ControladorConsorcio {
    private ArrayList<Consorcio> Consorcios = null;
    private static ControladorConsorcio instancia = null;
    private ControladorConsorcio(){Consorcios=new ArrayList<Consorcio>();}
    public static ControladorConsorcio getInstance() {
        if (instancia == null){
            instancia = new ControladorConsorcio();
        }
        return instancia;
    }

    private Consorcio getConsorcio(int id){
        for (Consorcio c:Consorcios){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public ArrayList<ConsorcioDTO> getConsorcios(){
        ArrayList<ConsorcioDTO> lista = new ArrayList<ConsorcioDTO>();
        for (Consorcio c:this.Consorcios) {
            lista.add(c.consocioToDTO());
        }
        return lista;
    }
    public boolean existeConsorcio(Integer idconsorcio){
        for (Consorcio c:this.Consorcios){
            if(c.getId() == idconsorcio){
                return true;
            }
        }
        return false;
    }
    public void crearConsorcio (ConsorcioDTO datos){
        if (datos!=null){
            Consorcio consorcioVerificar = getConsorcio(datos.getId());
            if (consorcioVerificar == null){
                Consorcio consorcioNew = new Consorcio(datos);
                Consorcios.add(consorcioNew);
            }
        }
    }
    public void editarConsorcio (ConsorcioDTO datos){
        if (datos != null){
            Consorcio consorcioEdit = getConsorcio(datos.getId());
            if (consorcioEdit != null){
                int index = Consorcios.indexOf(consorcioEdit);
                consorcioEdit.setNombre(datos.getNombre());
                consorcioEdit.setContacto(datos.getContacto());
                consorcioEdit.setCuentaBanco(datos.getCuentaBanco());
                consorcioEdit.setBarrio(datos.getBarrio());
                consorcioEdit.setTipoLiquidacion(datos.getTipoLiquidacion());
                Consorcios.set(index,consorcioEdit);
            }
        }
    }



    public void eliminarConsorcio (ConsorcioDTO datos){
        if (datos != null){
            Consorcio consorcioRemove = getConsorcio(datos.getId());
            if (consorcioRemove != null){
                Consorcios.remove(getConsorcio(datos.getId()));
            }
        }
    }

    public ConsorcioDTO getConsorcioDTO(int id){
        for (Consorcio c:Consorcios){
            if (c.getId() == id){
                return c.consocioToDTO();
            }
        }
        return null;
    }

    public Float saldoConsorcio(int id){
        for (Consorcio c:Consorcios){
            if (c.getId() == id){
                return c.getCuentaBanco().getSaldo("1A2B3C4F");
            }
        }
        return 0f;
    }

    public void depositarAConsorcio(int idConsorcio, float deposito){
        for(Consorcio c : Consorcios){
            if(c.getId() == idConsorcio){
                c.getCuentaBanco().depositar(deposito);
            }
        }
    }

    public void pagarDesdeConsorcio(int idConsorcio, float pago){
        for(Consorcio c : Consorcios){
            if(c.getId() == idConsorcio){
                c.getCuentaBanco().pagar(pago);
            }
        }
    }

    public void liquidarConsorcio(int idConsorcio, int generarReservas, int usarReservas){
        for(Consorcio c : Consorcios){
            if(c.getId() == idConsorcio){
                c.liquidar(generarReservas, usarReservas);
            }
        }
    }

    public void notificarLiquidacion(int idConsorcio){
        Notificador notificador = new Notificador();
        Notificacion notificacion = new Notificacion();
        for (UnidadFuncionalDTO uf:ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(idConsorcio)){
            ArrayList<Persona> interesados = uf.getInquilinos();
            interesados.addAll(uf.getPropietarios());
            for (Persona interesado:interesados){
                notificacion.setMensaje(ControladorUnidadFuncional.getInstance().printUltimaFacturabyUF(uf.getIdUnidadFuncional()));
                notificacion.setDestinatario(interesado);
                switch(interesado.getModoDeEnvio()) {
                    case SMS: notificador.setEstrategia(new NotificacionSMS(new AdapterSMSService())); break;
                    case WHATSAPP: notificador.setEstrategia(new NotificacionWS(new AdapterWhatsappService())); break;
                    case EMAIL: notificador.setEstrategia(new NotificacionEmail(new AdapterJavaMail())); break;
                }
                notificador.enviar(notificacion);
            }
        }
    }

}
