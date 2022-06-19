package Adapter;

import Negocio.Cuenta;

import java.util.Date;

public class AdapterCuenta implements  IAdapterCuenta{

    private Float saldo;

    public AdapterCuenta(final Float saldo) {
        this.saldo = saldo;
    }
    public float obtenerSaldo(String cbu, Date fecha, String token) {
        if(token == "1A2B3C4F") {
            return this.saldo;
        }
        return 0;
    }

    public void depositar(float pago){
        this.saldo = saldo + pago;
    }

    public void pagar(float pago) {
        if(pago <= saldo){
            this.saldo = saldo - pago;
        }
        else{
            System.out.println("No hay fondos suficientes");
        }
    }
}
