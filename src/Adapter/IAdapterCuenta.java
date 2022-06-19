package Adapter;

import java.util.Date;

public interface IAdapterCuenta {

    float obtenerSaldo(String cbu, Date fecha, String token);

    void depositar(float pago);

    void pagar(float pago);
}
