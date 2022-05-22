package Negocio;

import DTO.UnidadFuncionalDTO;

import java.util.List;

public class UnidadFuncional {

    private float superficie;
    private Integer nroUnidad;
    private List<Persona> propietarios;
    private List<Persona> inquilinos;
    private List<FacturaUnidadFuncional> facturas;

    public UnidadFuncional (UnidadFuncionalDTO unidadFuncionalDTO) {

        this.superficie = unidadFuncionalDTO.getSuperficie();
        this.nroUnidad = unidadFuncionalDTO.getNroUnidad();
        this.propietarios = unidadFuncionalDTO.getPropietarios();
        this.inquilinos = unidadFuncionalDTO.getInquilinos();
        this.facturas = unidadFuncionalDTO.getFacturas();
    }

    public UnidadFuncionalDTO unidadFuncToDTO() {
        UnidadFuncionalDTO unidadFuncionalDTO = new UnidadFuncionalDTO();

        unidadFuncionalDTO.setSuperficie(this.superficie);
        unidadFuncionalDTO.setNroUnidad(this.nroUnidad);
        unidadFuncionalDTO.setPropietarios(this.propietarios);
        unidadFuncionalDTO.setInquilinos(this.inquilinos);
        unidadFuncionalDTO.setFacturas(this.facturas);

        return unidadFuncionalDTO;
    }

    public void crearFactura (double extraordinario, double ordinario) {

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

    public List<Persona> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Persona> propietarios) {
        this.propietarios = propietarios;
    }

    public List<Persona> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(List<Persona> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public List<FacturaUnidadFuncional> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaUnidadFuncional> facturas) {
        this.facturas = facturas;
    }
}
