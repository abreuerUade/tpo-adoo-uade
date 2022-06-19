package Negocio;


import Adapter.AdapterCuenta;
import Adapter.IAdapterCuenta;

import java.util.Date;

public class  Cuenta {
    private String propietario;
    private String CBU;
    private IAdapterCuenta adapter;

    public Cuenta(String propietario, String CBU, IAdapterCuenta adapter) {
        this.propietario = propietario;
        this.CBU = CBU;
        this.adapter = adapter;
    }

    public Float getSaldo(String token) {
        return adapter.obtenerSaldo(this.CBU, new Date(), token);
    }

    public void pagar(float saldo){
        this.adapter.pagar(saldo);
    }
    public void depositar(float saldo){
        this.adapter.depositar(saldo);
    }
    public IAdapterCuenta getAdapter() {
        return this.adapter;
    }

    public void setAdapter(final IAdapterCuenta adapter) {
        this.adapter = adapter;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

}
