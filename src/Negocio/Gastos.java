package Negocio;

import java.util.Date;

public class Gastos {

    private Integer monto;
    private String nombre;
    private Date fechaFact;
    private Integer cantCuotas;
    private Integer periodo;
    private enum Expensas tipoExpensas;

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFact() {
        return fechaFact;
    }

    public void setFechaFact(Date fechaFact) {
        this.fechaFact = fechaFact;
    }

    public Integer getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(Integer cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
