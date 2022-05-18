package Negocio;


import java.util.List;

public class Consorcio {

    private String nombre;
    private String contacto;
    private Cuenta cuentaBanco;
    private List<UnidadFuncional> UnidadesFunc;
    private List<Gasto> gastos;
    private List<Usuario> admin;
    private LiquidacionGenerica tipoLiquidacion;

    Consorcio (String nombre, String contacto, List<UnidadFuncional> UnidadesFunc,Cuenta cuentaBanco,
               List<Gasto> gastos, List<Usuario> admin, LiquidacionGenerica tipoLiquidacion  ){

        this.nombre = nombre;
        this.contacto = contacto;
        this.cuentaBanco = cuentaBanco;
        this.UnidadesFunc = UnidadesFunc;
        this.gastos = gastos;
        this.admin = admin;
        this.tipoLiquidacion = tipoLiquidacion;

    }

    public void liquidar(UnidadFuncional unidadFuncional) {

    }

    public void cambiarCriterio (LiquidacionGenerica liquidacionGenerica) {

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
