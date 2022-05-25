package Negocio;


import DTO.ConsorcioDTO;

import java.util.List;

public class Consorcio {


    private int id;
    private String nombre;
    private String contacto;
    private Cuenta cuentaBanco;
    private List<UnidadFuncional> UnidadesFunc;
    private List<Gasto> gastos;
    private List<Usuario> admin;
    private LiquidacionGenerica tipoLiquidacion;

    public Consorcio (ConsorcioDTO consorcioDTO) {

        this.nombre = consorcioDTO.getNombre();
        this.contacto = consorcioDTO.getContacto();
        this.cuentaBanco = consorcioDTO.getCuentaBanco();
        this.UnidadesFunc = consorcioDTO.getUnidadesFunc();
        this.gastos = consorcioDTO.getGastos();
        this.admin = consorcioDTO.getAdmin();
        this.tipoLiquidacion = consorcioDTO.getTipoLiquidacion();
    }

    public ConsorcioDTO consocioToDTO () {
        ConsorcioDTO consorcioDTO = new ConsorcioDTO();
        consorcioDTO.setId(this.id);
        consorcioDTO.setNombre(this.nombre);
        consorcioDTO.setContacto(this.contacto);
        consorcioDTO.setCuentaBanco(this.cuentaBanco);
        consorcioDTO.setUnidadesFunc(this.UnidadesFunc);
        consorcioDTO.setGastos(this.gastos);
        consorcioDTO.setAdmin(this.admin);
        consorcioDTO.setTipoLiquidacion(this.tipoLiquidacion);

        return consorcioDTO;
    }


    public void liquidar(UnidadFuncional unidadFuncional) {

    }

    public void cambiarCriterio (LiquidacionGenerica liquidacionGenerica) {

    }

    public int getId() {
        return id;
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

    public void setCuentaBanco(Cuenta cuantaBanco) {
        this.cuentaBanco = cuantaBanco;
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
}
