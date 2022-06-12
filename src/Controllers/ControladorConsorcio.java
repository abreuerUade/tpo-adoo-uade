package Controllers;

import DTO.ConsorcioDTO;
import DTO.GastoDTO;
import DTO.UnidadFuncionalDTO;
import DTO.UsuarioDTO;
import Negocio.*;
import Negocio.Comunicacion.Notificacion;
import Negocio.Comunicacion.NotificacionSMS;
import Negocio.Comunicacion.NotificacionWS;
import Negocio.Comunicacion.NotificacionesEmail;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
/* NO EXISTE MAS LA LISTA DE GASTOS EN EL CONSORCIO!!!!!!!!


    public void agregarGasto(GastoDTO gasto, int id_consorcio){
        Consorcio consorcio = getConsorcio(id_consorcio);
        if (consorcio != null) {
            ArrayList<Gasto> gastos = consorcio.getGastos();
            Gasto nuevoGasto = new Gasto(gasto);
            gastos.add(nuevoGasto);
            consorcio.setGastos(gastos);
        }
    }

    public void eliminarGasto(GastoDTO gasto, int id_consorcio) {
        if(gasto != null) {
            Consorcio consorcio = getConsorcio(id_consorcio);
            ArrayList<Gasto> gastos = consorcio.getGastos();

            for(Gasto g : gastos) {
                if (gasto.getId() == g.getId()) {
                    gastos.remove(gastos.indexOf(g));
                }
                break;
            }

            consorcio.setGastos(gastos);
        }

    }
*/



    public void agregarUnidadFuncional(UnidadFuncionalDTO uf, int id_consorcio) {
        if(uf != null) {
            Consorcio consorcio = getConsorcio(id_consorcio);
            ArrayList<UnidadFuncional> unidades_funcionales = consorcio.getUnidadesFunc();
            UnidadFuncional nueva_uf = new UnidadFuncional(uf);
            unidades_funcionales.add(nueva_uf);
            consorcio.setUnidadesFunc(unidades_funcionales);
        }
    }

    public void eliminarUnidadFuncional(UnidadFuncionalDTO unidad_funcional, int id_consorcio) {
        if(unidad_funcional!= null) {
            Consorcio consorcio = getConsorcio(id_consorcio);
            ArrayList<UnidadFuncional> unidades_funcionales = consorcio.getUnidadesFunc();
            for(UnidadFuncional uf : unidades_funcionales) {
                if(uf.getNroUnidad() == unidad_funcional.getNroUnidad()) {
                    unidades_funcionales.remove(unidades_funcionales.indexOf(uf));
                }
                break;
            }
            consorcio.setUnidadesFunc(unidades_funcionales);
        }
    }

    public void agregarAdmin (UsuarioDTO admin, int id_consorcio) {
        if (admin != null) {
            Consorcio consorcio = getConsorcio(id_consorcio);
            ArrayList<Usuario> admins = consorcio.getAdmin();
            Usuario nuevo_admin = new Usuario(admin);
            admins.add(nuevo_admin);
            consorcio.setAdmin(admins);
        }
    }

    public void eliminarAdmin(UsuarioDTO admin, int id_consorcio) {
        if (admin != null) {
            Consorcio consorcio = getConsorcio(id_consorcio);
            ArrayList<Usuario> admins = consorcio.getAdmin();

            for (Usuario a : admins){
                if(a.getMail() == admin.getMail()) {
                    admins.remove(admins.indexOf(a));
                }
                break;
            }

            consorcio.setAdmin(admins);
        }
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
                consorcioEdit.setAdmin(datos.getAdmin());
                //consorcioEdit.setGastos(datos.getGastos());
                //consorcioEdit.setUnidadesFunc(datos.getUnidadesFunc());
                //consorcioEdit.setTipoLiquidacion(datos.getTipoLiquidacion());
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
                return c.getCuentaBanco().getSaldo();
            }
        }
        return 0f;
    }

    public void liquidarConsorcio(ConsorcioDTO consorcioDTO){
        //ALgo
        notificarLiquidacion(consorcioDTO);
    }

    public void notificarLiquidacion(ConsorcioDTO consorcioDTO){
        Notificador notificador = new Notificador();
        Notificacion notificacion = new Notificacion();
        for (UnidadFuncionalDTO uf:ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO)){
            ArrayList<Persona> interesados = uf.getInquilinos();
            interesados.addAll(uf.getPropietarios());
            for (Persona interesado:interesados){
                notificacion.setMensaje("mensaje de prueba");
                notificacion.setDestinatario(interesado);
                switch(interesado.getModoDeEnvio()) {
                    case SMS: notificador.setEstrategia(new NotificacionSMS()); break;
                    case WHATSAPP: notificador.setEstrategia(new NotificacionWS()); break;
                    case EMAIL: notificador.setEstrategia(new NotificacionesEmail()); break;
                }
                notificador.enviar(notificacion);
            }
        }
    }

}
