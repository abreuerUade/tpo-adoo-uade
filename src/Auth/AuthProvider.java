package Auth;

public interface AuthProvider {
    boolean autenticar(String mail, String password);
    void crearCredenciales(String mail);

}
