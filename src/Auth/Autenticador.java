package Auth;
import Controllers.*;


public class Autenticador  {

    //DB Usuarios&Paswords
    private static String usuarioRoot = "rr@consorcios.com";
    private static Integer passwordRoot = 123;
    //
    private static Autenticador instancia = null;
    public static Autenticador getInstance() {
        if (instancia == null) {
            instancia = new Autenticador();
        }
        return instancia;
    }
    public boolean autenticar(String mail, Integer password){
        boolean flag = false;
        if (mail == usuarioRoot) {
            System.out.println("Usuario ok");
            if (password == passwordRoot){
                System.out.println("Pass ok");
                flag = true;
            }
        }
        return flag;
    }
}


