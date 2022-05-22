package Auth;
import Controllers.*;


public class Autenticador  {

    //DB Usuarios&Paswords
    private String usuarioRoot = "rr@consorcios.com";
    private Integer passwordRoot = 123456;

    //Verificar acceso
    public boolean autenticar(String mail, Integer password){
        boolean flag = false;
        if(ControladorUsuario.getInstance().verificarUsuarioBoolean(mail));{
            if (mail == usuarioRoot) {
                if (password == passwordRoot){
                    flag = true;
                }
            }
        }
        return flag;
    }

}
