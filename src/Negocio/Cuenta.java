package Negocio;


public class Cuenta {

    private String propietario;
    private String CBU;
    private Float Saldo;

    public Cuenta(String propietario, String CBU, Float Saldo) {
        this.propietario = propietario;
        this.CBU = CBU;
        this.Saldo = Saldo;
    }

    public Float getSaldo() {
        return Saldo;
    }

    public void setSaldo(Float saldo) {
        Saldo = saldo;
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
