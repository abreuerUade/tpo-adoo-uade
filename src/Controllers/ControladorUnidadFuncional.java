package Controllers;
import DTO.ConsorcioDTO;
import DTO.PersonaDTO;
import Negocio.FacturaUnidadFuncional;
import Negocio.Persona;
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
    public UnidadFuncional getUnidadFuncional(Integer NroUnidad) {
        for (UnidadFuncional uf : UnidadesFuncionales) {
            if (uf.getNroUnidad().equals(NroUnidad)){
                return uf;
            }
        }
        return null;
    }
    // Pinta en pantalla los datos de la unidad funcional
    public void viewUnidadFuncional (Integer idUnidadFuncional){
        System.out.println(getUnidadFuncional(idUnidadFuncional).getIdUnidadFuncional());
        System.out.println(getUnidadFuncional(idUnidadFuncional).getNroUnidad());
        System.out.println(getUnidadFuncional(idUnidadFuncional).getIdconsorcio());
        System.out.println(getUnidadFuncional(idUnidadFuncional).getSuperficie());
        System.out.println(getUnidadFuncional(idUnidadFuncional).getInquilinos());
        System.out.println(getUnidadFuncional(idUnidadFuncional).getFacturas());
        System.out.println(getUnidadFuncional(idUnidadFuncional).getPropietarios());
    }

    public ArrayList<UnidadFuncionalDTO> getUnidadesFuncionalesbyConsorcio(ConsorcioDTO consorcioDTO) {
        ArrayList<UnidadFuncionalDTO> listaUF = new ArrayList<UnidadFuncionalDTO>();
        for (UnidadFuncional uf : UnidadesFuncionales) {
            if (uf.getIdconsorcio() == consorcioDTO.getId()){
                listaUF.add(uf.unidadFuncToDTO());
            }
        }
        return listaUF;
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
                ufEdit.setIdconsorcio(datos.getIdconsorcio());
                ufEdit.setNroUnidad(datos.getNroUnidad());
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

    public void agregarInquilino(PersonaDTO inquilino, Integer nro_u) {
        if(inquilino != null) {
            if (getUnidadFuncional(nro_u) != null){
                Persona addpersona = ControladorPersona.getInstance().getPersonabyDNI(inquilino.getDni());
                UnidadFuncional UFaddInquilino = getUnidadFuncional(nro_u);
                UFaddInquilino.getInquilinos().add(addpersona);
                editarUnidadFuncional(UFaddInquilino.unidadFuncToDTO());
            }
        }
    }

    public void eliminarInquilino(PersonaDTO inquilino, Integer nro_u) {
       if(inquilino != null){
           if(getUnidadFuncional(nro_u) != null){
                Persona deletePersona = ControladorPersona.getInstance().getPersonabyDNI(inquilino.getDni());
                UnidadFuncional UFdelPersona =  getUnidadFuncional(nro_u);
                UFdelPersona.getInquilinos().remove(deletePersona);
                editarUnidadFuncional(UFdelPersona.unidadFuncToDTO());
           }
       }
    }

    public void agregarPropietario(PersonaDTO propietario, Integer nro_u) {
        if(propietario != null) {
            if (getUnidadFuncional(nro_u) != null){
                Persona addpersona = ControladorPersona.getInstance().getPersonabyDNI(propietario.getDni());
                UnidadFuncional UFaddInquilino = getUnidadFuncional(nro_u);
                UFaddInquilino.getPropietarios().add(addpersona);
                editarUnidadFuncional(UFaddInquilino.unidadFuncToDTO());
            }
        }
    }

    public void eliminarPropietario(PersonaDTO propietario, Integer nro_u) {
        if(propietario != null){
            if(getUnidadFuncional(nro_u) != null){
                Persona deletePersona = ControladorPersona.getInstance().getPersonabyDNI(propietario.getDni());
                UnidadFuncional UFdelPersona =  getUnidadFuncional(nro_u);
                UFdelPersona.getPropietarios().remove(deletePersona);
                editarUnidadFuncional(UFdelPersona.unidadFuncToDTO());
            }
        }
    }

    public void agregarFactura(FacturaUnidadFuncional factura, Integer nro_u) {
        if(factura != null) {
            if (getUnidadFuncional(nro_u)!=null) {
                UnidadFuncional UFaddFactura = getUnidadFuncional(nro_u);
                UFaddFactura.getFacturas().add(factura);
                editarUnidadFuncional(UFaddFactura.unidadFuncToDTO());
            }
        }
    }

    public void eliminarFactura(FacturaUnidadFuncional factura, Integer nro_u) {
        if(factura != null) {
            if (getUnidadFuncional(nro_u)!=null) {
                UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
                ArrayList<FacturaUnidadFuncional> facturas = unidadFuncional.getFacturas();
                for (FacturaUnidadFuncional f : facturas) {
                    if (f.getCodigoFactura() == factura.getCodigoFactura()) {
                        facturas.remove(facturas.indexOf(f));
                    }
                    break;
                }
                unidadFuncional.setFacturas(facturas);
            }
        }
    }
}
