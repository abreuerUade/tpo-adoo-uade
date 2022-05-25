package Controllers;
import Negocio.UnidadFuncional;
import DTO.UnidadFuncionalDTO;
import java.util.ArrayList;



public class ControladorUnidadFuncional {
    private ArrayList<UnidadFuncional> UnidadesFuncionales = null;
    // Instaciar una sola vez el controlador (singleton)
    private static ControladorUnidadFuncional instancia = null;
    private ControladorUnidadFuncional() {UnidadesFuncionales = new ArrayList<UnidadFuncional>();}
    public static ControladorUnidadFuncional getInstance() {
        if (instancia == null){
            instancia = new ControladorUnidadFuncional();
        }
        return instancia;
        }
    //Devolver lista de Unidades Funcionales en DTO
    public ArrayList<UnidadFuncionalDTO> getUnidadesFuncionales() {
        ArrayList<UnidadFuncionalDTO> listaUF = new ArrayList<UnidadFuncionalDTO>();
        for (UnidadFuncional uf : this.UnidadesFuncionales) {
            listaUF.add(uf.unidadFuncToDTO());
        }
        return listaUF;
    }
    //Buscar unidad funcional por numero y devolver objeto si existe.
    private UnidadFuncional getUnidadFuncional(Integer NroUnidad) {
        for (UnidadFuncional uf : UnidadesFuncionales) {
            if (uf.getNroUnidad().equals(NroUnidad)){
                return uf;
            }
        }
        return null;
    }

    public void crearUnidadFuncional (UnidadFuncionalDTO datos) {
        if (datos != null) {
            UnidadFuncional ufVerificar = getUnidadFuncional(datos.getNroUnidad());
            if (ufVerificar == null) {
                UnidadFuncional ufNew = new UnidadFuncional(datos);
                UnidadesFuncionales.add(ufNew);
            }
        }
    }

    public void editarUnidadFuncional (UnidadFuncionalDTO datos) {
        if (datos != null) {
            UnidadFuncional ufEdit = getUnidadFuncional(datos.getNroUnidad());
            if (ufEdit != null) {
                int index = UnidadesFuncionales.indexOf(ufEdit);
                ufEdit.setInquilinos(datos.getInquilinos());
                ufEdit.setPropietarios(datos.getPropietarios());
                ufEdit.setSuperficie(datos.getSuperficie());
                UnidadesFuncionales.set(index,ufEdit);
            }
        }
    }

    public void eliminarUnidadFuncional (UnidadFuncionalDTO datos){
        if (datos != null) {
            UnidadFuncional ufRemove = getUnidadFuncional(datos.getNroUnidad());
            if (ufRemove!=null){
                UnidadesFuncionales.remove(getUnidadFuncional(datos.getNroUnidad()));
            }
        }
    }

}
