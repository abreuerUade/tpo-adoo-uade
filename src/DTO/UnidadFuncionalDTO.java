package DTO;

import Negocio.FacturaUnidadFuncional;
import Negocio.Persona;

import java.util.List;

public class UnidadFuncionalDTO {
    private float superficie;
    private String nroUnidad;
    private List<Persona> propietarios;
    private List<Persona> inquilinos;
    private List<FacturaUnidadFuncional> facturas;

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
