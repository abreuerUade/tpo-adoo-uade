package Negocio;

import java.util.List;

public class UnidadFuncional {

    private float superficie;
    private String nroUnidad;
    private List<Personas> propietarios;
    private List<Personas> inquilinos;
    private List<FacturaUnidadFuncional> facturas;

    public void crearFactura (double extraordinario, double ordinario) {

    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public String getNroUnidad() {
        return nroUnidad;
    }

    public void setNroUnidad(String nroUnidad) {
        this.nroUnidad = nroUnidad;
    }

    public List<Personas> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Personas> propietarios) {
        this.propietarios = propietarios;
    }

    public List<Personas> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(List<Personas> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public List<FacturaUnidadFuncional> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaUnidadFuncional> facturas) {
        this.facturas = facturas;
    }
}
