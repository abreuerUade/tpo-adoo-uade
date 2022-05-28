package Negocio;


public class Cuenta {

    private String propietario;
    private String CBU;

    public Cuenta(String propietario, String CBU) {
        this.propietario = propietario;
        this.CBU = CBU;
    }

    public String obtenerSaldo() {
        return "";
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
