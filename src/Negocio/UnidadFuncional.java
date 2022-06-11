package Negocio;

import DTO.PersonaDTO;
import DTO.UnidadFuncionalDTO;
import java.util.ArrayList;

public class UnidadFuncional {

    private Integer idUnidadFuncional;
    private Integer idconsorcio;
    private float superficie;
    private Integer nroUnidad;
    private ArrayList<Persona> propietarios;
    private ArrayList<Persona> inquilinos;
    private ArrayList<FacturaUnidadFuncional> facturas;

    public UnidadFuncional (UnidadFuncionalDTO unidadFuncionalDTO) {
        this.idUnidadFuncional = unidadFuncionalDTO.getIdUnidadFuncional();
        this.idconsorcio = unidadFuncionalDTO.getIdconsorcio();
        this.superficie = unidadFuncionalDTO.getSuperficie();
        this.nroUnidad = unidadFuncionalDTO.getNroUnidad();
        this.propietarios = unidadFuncionalDTO.getPropietarios();
        this.inquilinos = unidadFuncionalDTO.getInquilinos();
        this.facturas = unidadFuncionalDTO.getFacturas();
    }


    public UnidadFuncionalDTO unidadFuncToDTO() {
        UnidadFuncionalDTO unidadFuncionalDTO = new UnidadFuncionalDTO();

        unidadFuncionalDTO.setIdUnidadFuncional(this.idUnidadFuncional);
        unidadFuncionalDTO.setIdconsorcio(this.idconsorcio);
        unidadFuncionalDTO.setSuperficie(this.superficie);
        unidadFuncionalDTO.setNroUnidad(this.nroUnidad);
        unidadFuncionalDTO.setPropietarios(this.propietarios);
        unidadFuncionalDTO.setInquilinos(this.inquilinos);
        unidadFuncionalDTO.setFacturas(this.facturas);

        return unidadFuncionalDTO;
    }
    /*PENSAR ESTO, no deberia estar en el controlador de unidades funcionales?

    public void crearFactura (double extraordinario, double ordinario) {

    }
*/
    public Integer getIdUnidadFuncional() {
        return idUnidadFuncional;
    }

    public void setIdUnidadFuncional(Integer idUnidadFuncional) {
        this.idUnidadFuncional = idUnidadFuncional;
    }

    public Integer getIdconsorcio() {
        return idconsorcio;
    }

    public void setIdconsorcio(Integer idconsorcio) {
        this.idconsorcio = idconsorcio;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public Integer getNroUnidad() {
        return nroUnidad;
    }

    public void setNroUnidad(Integer nroUnidad) {
        this.nroUnidad = nroUnidad;
    }

    public ArrayList<Persona> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(ArrayList<Persona> propietarios) {
        this.propietarios = propietarios;
    }

    public ArrayList<Persona> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(ArrayList<Persona> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public ArrayList<FacturaUnidadFuncional> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<FacturaUnidadFuncional> facturas) {
        this.facturas = facturas;
    }
}
