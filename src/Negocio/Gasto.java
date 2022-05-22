package Negocio;

import DTO.GastoDTO;

import java.util.Date;

public class Gasto {

    private Integer monto;
    private String nombre;
    private Date fechaFact;
    private Integer cantCuotas;
    private Integer periodo;
    private Expensas tipoExpensas;

    public Gasto (GastoDTO gastoDTO) {

        this.monto = gastoDTO.getMonto();
        this.nombre = gastoDTO.getNombre();
        this.fechaFact = gastoDTO.getFechaFact();
        this.cantCuotas = gastoDTO.getCantCuotas();
        this.periodo = gastoDTO.getPeriodo();
        this.tipoExpensas = gastoDTO.getTipoExpensas();
    }

    public GastoDTO gastoToDTO() {
        GastoDTO gastoDTO = new GastoDTO();

        gastoDTO.setMonto(this.monto);
        gastoDTO.setNombre(this.nombre);
        gastoDTO.setFechaFact(this.fechaFact);
        gastoDTO.setCantCuotas(this.cantCuotas);
        gastoDTO.setPeriodo(this.periodo);
        gastoDTO.setTipoExpensas(this.tipoExpensas);

        return gastoDTO;
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
}
