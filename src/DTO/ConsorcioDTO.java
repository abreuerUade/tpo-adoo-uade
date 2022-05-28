package DTO;

import Negocio.*;

import java.util.ArrayList;
import java.util.List;

public class ConsorcioDTO {


    private int id;
    private String nombre;
    private String contacto;
    private Cuenta cuentaBanco;
    private String barrio;
    private List<UnidadFuncional> UnidadesFunc;
    private List<Gasto> gastos;
    private List<Usuario> admin;
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

    public List<UnidadFuncional> getUnidadesFunc() {
        return UnidadesFunc;
    }

    public void setUnidadesFunc(List<UnidadFuncional> unidadesFunc) {
        UnidadesFunc = unidadesFunc;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Usuario> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Usuario> admin) {
        this.admin = admin;
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

    public void addUnidadFuncional(UnidadFuncional unidadFuncional){
        if(this.UnidadesFunc == null){
            this.UnidadesFunc = new ArrayList<UnidadFuncional>();
        }
        this.UnidadesFunc.add(unidadFuncional);
    }

    public void removeUnidadFuncional(UnidadFuncional unidadFuncional){
        this.UnidadesFunc.remove(unidadFuncional);
    }

    public void addGasto(Gasto gasto){
        if(this.gastos == null){
            this.gastos = new ArrayList<Gasto>();
        }
        this.gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto){
        this.gastos.remove(gasto);
    }

    public void addUsuario(Usuario usuario){
        if(this.admin == null){
            this.admin = new ArrayList<Usuario>();
        }
    }

}
