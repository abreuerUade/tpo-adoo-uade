package Controllers;

import DTO.ConsorcioDTO;
import Negocio.Consorcio;
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
    public ArrayList<ConsorcioDTO> getConsorcios(){
        ArrayList<ConsorcioDTO> lista = new ArrayList<ConsorcioDTO>();
        for (Consorcio c:this.Consorcios) {
            lista.add(c.consocioToDTO());
        }
        return lista;
    }
    private Consorcio getConsorcio(String nombre){
        for (Consorcio c:Consorcios){
            if (c.getNombre().equals(nombre)){
                return c;
            }
        }
        return null;
    }
    public void crearConsorcio (ConsorcioDTO datos){
        if (datos!=null){
            Consorcio consorcioVerificar = getConsorcio(datos.getNombre());
            Consorcio consorcioNew = new Consorcio(datos);
            if (consorcioVerificar == null){
                consorcioNew.setNombre(datos.getNombre());
                consorcioNew.setContacto(datos.getContacto());
                consorcioNew.setCuentaBanco(datos.getCuentaBanco());
                consorcioNew.setAdmin(datos.getAdmin());
                consorcioNew.setGastos(datos.getGastos());
                consorcioNew.setUnidadesFunc(datos.getUnidadesFunc());
                consorcioNew.setTipoLiquidacion(datos.getTipoLiquidacion());
                Consorcios.add(consorcioNew);
            }
        }
    }
    public void editarConsorcio (ConsorcioDTO datos){
        if (datos != null){
            Consorcio consorcioEdit = getConsorcio(datos.getNombre());
            if (consorcioEdit != null){
                consorcioEdit.setNombre(datos.getNombre());
                consorcioEdit.setContacto(datos.getContacto());
                consorcioEdit.setCuentaBanco(datos.getCuentaBanco());
                consorcioEdit.setAdmin(datos.getAdmin());
                consorcioEdit.setGastos(datos.getGastos());
                consorcioEdit.setUnidadesFunc(datos.getUnidadesFunc());
                consorcioEdit.setTipoLiquidacion(datos.getTipoLiquidacion());
                Consorcios.set(Consorcios.indexOf(getConsorcio(datos.getNombre())),consorcioEdit);
            }
        }
    }
    public void eliminarConsorcio (ConsorcioDTO datos){
        if (datos != null){
            Consorcio consorcioRemove = getConsorcio(datos.getNombre());
            if (consorcioRemove != null){
                Consorcios.remove(getConsorcio(datos.getNombre()));
            }
        }
    }

}
