package DTO;

import Negocio.Expensas;

import java.util.Date;

public class GastoDTO {


    private Integer id;
    private Integer monto;
    private String nombre;
    private Date fechaFact;
    private Integer cantCuotas;
    private Integer periodo;
    private Integer idconsorcio;
    private Expensas tipoExpensas;

    public Integer getIdconsorcio() {
        return idconsorcio;
    }

    public void setIdconsorcio(Integer idconsorcio) {
        this.idconsorcio = idconsorcio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Expensas getTipoExpensas() {
        return tipoExpensas;
    }

    public void setTipoExpensas(Expensas tipoExpensas) {
        this.tipoExpensas = tipoExpensas;
    }
}
