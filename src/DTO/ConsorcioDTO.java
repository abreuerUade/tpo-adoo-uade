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
    //private ArrayList<UnidadFuncional> UnidadesFunc;
    //private ArrayList<Gasto> gastos;
    //private ArrayList<Usuario> admin;
    private LiquidacionGenerica tipoLiquidacion;
    /*
    public ConsorcioDTO(){
        UnidadesFunc = new ArrayList<>();
        //gastos = new ArrayList<>();
        admin = new ArrayList<>();
    }
    */

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
    /*
       public ArrayList<UnidadFuncional> getUnidadesFunc() {
           return UnidadesFunc;
       }

       public void setUnidadesFunc(ArrayList<UnidadFuncional> unidadesFunc) {
           UnidadesFunc = unidadesFunc;
       }


       public ArrayList<Gasto> getGastos() {
           return gastos;
       }

       public void setGastos(ArrayList<Gasto> gastos) {
           this.gastos = gastos;
       }

    public ArrayList<Usuario> getAdmin() {
        return admin;
    }

    public void setAdmin(ArrayList<Usuario> admin) {
        this.admin = admin;
    }
 */
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
    /*
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
         */

    }

