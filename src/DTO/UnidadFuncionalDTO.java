package DTO;

import Negocio.FacturaUnidadFuncional;
import Negocio.Persona;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UnidadFuncionalDTO {
    private Integer idUnidadFuncional;
    private Integer idconsorcio;
    private float superficie;
    private Integer nroUnidad;
    private ArrayList<Persona> propietarios;
    private ArrayList<Persona> inquilinos;
    private ArrayList<FacturaUnidadFuncional> facturas;

    public UnidadFuncionalDTO(){
        propietarios = new ArrayList<>();
        inquilinos = new ArrayList<>();
        facturas = new ArrayList<>();
    }

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
