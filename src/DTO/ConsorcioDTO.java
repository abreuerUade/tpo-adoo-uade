package DTO;

import Negocio.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ConsorcioDTO {


    private int id;
    private String nombre;
    private String contacto;
    private Cuenta cuentaBanco;
    private String barrio;
    private LiquidacionGenerica tipoLiquidacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Cuenta getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(Cuenta cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public LiquidacionGenerica getTipoLiquidacion() {
        return tipoLiquidacion;
    }

    public void setTipoLiquidacion(LiquidacionGenerica tipoLiquidacion) {
        this.tipoLiquidacion = tipoLiquidacion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }


    }

