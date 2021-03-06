package Controllers;
import DTO.ConsorcioDTO;
import DTO.PersonaDTO;
import GUI.MasterFrame;
import Negocio.Consorcio;
import Negocio.FacturaUnidadFuncional;
import Negocio.Persona;
import Negocio.UnidadFuncional;
import DTO.UnidadFuncionalDTO;
import java.util.ArrayList;
import java.util.UUID;


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
    public UnidadFuncional getUnidadFuncional(Integer IdUnidad) {
        for (UnidadFuncional uf : UnidadesFuncionales) {
            if (uf.getIdUnidadFuncional().equals(IdUnidad)){
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

    public ArrayList<UnidadFuncionalDTO> getUnidadesFuncionalesbyConsorcio(int idConsorcio) {
        ArrayList<UnidadFuncionalDTO> listaUF = new ArrayList<UnidadFuncionalDTO>();
        for (UnidadFuncional uf : UnidadesFuncionales) {
            if (uf.getIdconsorcio() == idConsorcio){
                listaUF.add(uf.unidadFuncToDTO());
            }
        }
        return listaUF;
    }

    public void crearUnidadFuncional (UnidadFuncionalDTO datos) {
        if (datos != null) {
            UnidadFuncional ufVerificar = getUnidadFuncional(datos.getIdUnidadFuncional());
            if (ufVerificar == null) {
                UnidadFuncional ufNew = new UnidadFuncional(datos);
                UnidadesFuncionales.add(ufNew);
            }
        }
    }

    public void editarUnidadFuncional (UnidadFuncionalDTO datos) {
        if (datos != null) {
            UnidadFuncional ufEdit = getUnidadFuncional(datos.getIdUnidadFuncional());
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

    public void agregarInquilino(PersonaDTO inquilino, Integer idUnidad) {
        if(inquilino != null) {
            if (getUnidadFuncional(idUnidad) != null){
                Persona addpersona = ControladorPersona.getInstance().getPersonabyDNI(inquilino.getDni());
                UnidadFuncional UFaddInquilino = getUnidadFuncional(idUnidad);
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

    public Integer getIdFromUf(Integer idConsorcio, Integer nroUnidad){
        Integer idUf = -1;
        if (idConsorcio!=null && nroUnidad != null){
            for(UnidadFuncional u: UnidadesFuncionales){
                if(u.getIdconsorcio() == idConsorcio && u.getNroUnidad() == nroUnidad){
                    idUf = u.getIdUnidadFuncional();
                }
            }
        }
        return idUf;
    }

    public void agregarFactura(FacturaUnidadFuncional factura, Integer idUf) {
        if(factura != null) {
            if (getUnidadFuncional(idUf)!=null) {
                UnidadFuncional UFaddFactura = getUnidadFuncional(idUf);
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

    public ArrayList<FacturaUnidadFuncional> getFacturasbyUf(int idUF) {
        ArrayList<FacturaUnidadFuncional> facturas = new ArrayList<>();
        for(UnidadFuncional u : UnidadesFuncionales){
            if (u.getIdUnidadFuncional() == idUF){
                facturas = u.getFacturas();
            }
        }
        return facturas;
    }

    public FacturaUnidadFuncional getFacturaById(UUID uuid, int idUf){
        ArrayList<FacturaUnidadFuncional> facturas = this.getFacturasbyUf(idUf);
        FacturaUnidadFuncional factura;
        for(FacturaUnidadFuncional f : facturas){
            if (f.getCodigoFactura().equals(uuid)){
                return f;
            }
        }
        return null;
    }

    public ArrayList<PersonaDTO> getPropietarioByUf(UnidadFuncionalDTO unidadFuncionalDTO){
        ArrayList<PersonaDTO> propietarios = new ArrayList<>();

        for (UnidadFuncional u : UnidadesFuncionales){
            if(unidadFuncionalDTO.getIdUnidadFuncional().equals(u.getIdUnidadFuncional())){
                for(Persona p : u.getPropietarios()){
                    propietarios.add(p.personaToDTO());
                }

            }
        }
        return propietarios;
    }

    public ArrayList<PersonaDTO> getInquilinoByUf(UnidadFuncionalDTO unidadFuncionalDTO){
        ArrayList<PersonaDTO> inquilino = new ArrayList<>();

        for (UnidadFuncional u : UnidadesFuncionales){
            if(unidadFuncionalDTO.getIdUnidadFuncional().equals(u.getIdUnidadFuncional())){
                for(Persona p : u.getInquilinos()){
                    inquilino.add(p.personaToDTO());
                }
            }
        }
        return inquilino;
    }


    public float calcularSuperficieTotalbyConsorcio(int idconsorcio) {
        int superficieTotal = 0;
        ArrayList<UnidadFuncionalDTO> listUF = getUnidadesFuncionalesbyConsorcio(idconsorcio);
        for (UnidadFuncionalDTO uf:listUF){
            superficieTotal+=uf.getSuperficie();
        }
        return superficieTotal;
    }

    public String printUltimaFacturabyUF(int idUnidadFuncional){

        String nombre = ControladorUsuario.getInstance().getUsuario(MasterFrame.loggedUserMail).getNombre();
        String apellido = ControladorUsuario.getInstance().getUsuario(MasterFrame.loggedUserMail).getApellido();

        for (UnidadFuncional ufprint:UnidadesFuncionales){
            if(ufprint.getIdUnidadFuncional()==idUnidadFuncional){
                if (!ufprint.getFacturas().isEmpty()){
                    FacturaUnidadFuncional ultimaFactura = ufprint.getFacturas().get(ufprint.getFacturas().size()-1);
                    float total = ultimaFactura.getReservas()+ultimaFactura.getMontoOrdinario()+ultimaFactura.getMontoExtraordinario();
                    return ("\nAdministrador: " + nombre + " " + apellido + "\nFacturacion correspondiente al numero de unidad: " + ufprint.getNroUnidad()) + "\nGastos de expensas del mes: " + ultimaFactura.getFecha().getMonth() + "\nMonto expensas Ordinarias: " + ultimaFactura.getMontoOrdinario() + "\nMonto expensas Extraordinarias: " + ultimaFactura.getMontoExtraordinario() + "\nFondos de Reservas: " + ultimaFactura.getReservas()+"\nTotal: " + total+"\n\n";
                }
            }
        }
        return "No tiene Facturas asignada en este periodo";
    }

    public float totalFacturadoMes(int mes) {
        float total = 0;

        for(UnidadFuncional uf : UnidadesFuncionales) {
            for(FacturaUnidadFuncional f: uf.getFacturas()){
                if(f.getFecha().getMonth() == mes) {
                    float total_fact = f.getReservas() + f.getMontoExtraordinario() + f.getMontoOrdinario();
                    total += total_fact;
                }
            }
        }

        return total;
    }
}
