package Controllers;
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

// falta verificar si la unidad funcional existe.
// estamos agregando una copia de la persona
// no estamos guardando en la lista del controller, por lo tanto no persiste
//tendria que este metodo llamar la controlador de personas y que le pase el objeto real a partir de los datos del dto


    public void agregarInquilino(PersonaDTO inquilino, Integer nro_u) {
        if(inquilino != null) {
            UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
            ArrayList<Persona> inquilinos = unidadFuncional.getInquilinos();
            Persona nuevoInquilino = new Persona(inquilino);

            inquilinos.add(nuevoInquilino);

            unidadFuncional.setInquilinos(inquilinos);

        }


    }

    public void eliminarInquilino(PersonaDTO inquilino, Integer nro_u) {
        if(inquilino != null) {
            UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
            ArrayList<Persona> inquilinos = unidadFuncional.getInquilinos();

            for(Persona i : inquilinos){
                if(inquilino.getDni() == i.getDni()) {
                    inquilinos.remove(inquilinos.indexOf(i));
                }
                break;
            }

            unidadFuncional.setInquilinos(inquilinos);

        }
    }

    public void agregarPropietario(PersonaDTO propietario, Integer nro_u) {
        if(propietario != null) {
            UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
            ArrayList<Persona> propietarios = unidadFuncional.getPropietarios();
            Persona nuevoPropietario = new Persona(propietario);

            propietarios.add(nuevoPropietario);

            unidadFuncional.setInquilinos(propietarios);

        }


    }

    public void eliminarPropietario(PersonaDTO propietario, Integer nro_u) {
        if(propietario != null) {
            UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
            ArrayList<Persona> propietarios = unidadFuncional.getPropietarios();

            for(Persona i : propietarios){
                if(propietario.getDni() == i.getDni()) {
                    propietarios.remove(propietarios.indexOf(i));
                }
                break;
            }

            unidadFuncional.setPropietarios(propietarios);

        }
    }

    public void agregarFactura(FacturaUnidadFuncional factura, Integer nro_u) {
        if(factura != null) {
            UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
            ArrayList<FacturaUnidadFuncional> facturas = unidadFuncional.getFacturas();

            facturas.add(factura);

            unidadFuncional.setFacturas(facturas);
        }

    }

    public void eliminarFactura(FacturaUnidadFuncional factura, Integer nro_u) {
        if(factura != null) {
            UnidadFuncional unidadFuncional = getUnidadFuncional(nro_u);
            ArrayList<FacturaUnidadFuncional> facturas = unidadFuncional.getFacturas();

            for(FacturaUnidadFuncional f : facturas){
                if(f.getCodigoFactura() == factura.getCodigoFactura()) {
                    facturas.remove(facturas.indexOf(f));
                }
                break;
            }

            unidadFuncional.setFacturas(facturas);
        }

    }

}
