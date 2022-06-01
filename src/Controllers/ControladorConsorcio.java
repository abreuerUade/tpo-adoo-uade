package Controllers;

import DTO.ConsorcioDTO;
import DTO.GastoDTO;
import Negocio.Consorcio;
import Negocio.Gasto;

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
    public ArrayList<ConsorcioDTO> getConsorcios(){
        ArrayList<ConsorcioDTO> lista = new ArrayList<ConsorcioDTO>();
        for (Consorcio c:this.Consorcios) {
            lista.add(c.consocioToDTO());
        }
        return lista;
    }
    private Consorcio getConsorcio(int id){
        for (Consorcio c:Consorcios){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public void agregarGasto(GastoDTO gasto, int id){
        Consorcio consorcio = getConsorcio(id);

        ArrayList<Gasto> gastos = consorcio.getGastos();

        Gasto nuevoGasto = new Gasto(gasto);
        gastos.add(nuevoGasto);

        consorcio.setGastos(gastos);

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
                consorcioEdit.setGastos(datos.getGastos());
                consorcioEdit.setUnidadesFunc(datos.getUnidadesFunc());
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

}
