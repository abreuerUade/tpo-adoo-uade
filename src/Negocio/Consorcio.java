package Negocio;


import Controllers.ControladorGasto;
import DTO.ConsorcioDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Consorcio {

    private int id;
    private String nombre;
    private String contacto;
    private Cuenta cuentaBanco;
    private String barrio;

    private LiquidacionGenerica tipoLiquidacion;

    public Consorcio (ConsorcioDTO consorcioDTO) {
        this.id = consorcioDTO.getId();
        this.nombre = consorcioDTO.getNombre();
        this.contacto = consorcioDTO.getContacto();
        this.cuentaBanco = consorcioDTO.getCuentaBanco();
        this.barrio = consorcioDTO.getBarrio();
        this.tipoLiquidacion = consorcioDTO.getTipoLiquidacion();
    }

    public ConsorcioDTO consocioToDTO () {
        ConsorcioDTO consorcioDTO = new ConsorcioDTO();
        consorcioDTO.setId(this.id);
        consorcioDTO.setNombre(this.nombre);
        consorcioDTO.setBarrio(this.barrio);
        consorcioDTO.setContacto(this.contacto);
        consorcioDTO.setCuentaBanco(this.cuentaBanco);
        consorcioDTO.setTipoLiquidacion(this.tipoLiquidacion);
        return consorcioDTO;
    }


    public void liquidar(int generarReservas, int usarReservas) {
        float saldo = this.tipoLiquidacion.obtenerSaldo(this.id);
        ArrayList<Integer> gastos = this.tipoLiquidacion.calcularGastos(this.id);
        this.tipoLiquidacion.DivisionExpensas(this.id, generarReservas, usarReservas);
        ControladorGasto.getInstance().liquidarGastos(this.id);
    }

    public void cambiarCriterio (LiquidacionGenerica liquidacionGenerica) {
        this.tipoLiquidacion = liquidacionGenerica;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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
}
