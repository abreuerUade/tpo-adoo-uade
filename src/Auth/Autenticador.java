package Auth;
import Controllers.*;

import java.util.ArrayList;


public class Autenticador implements AuthProvider  {

    private ArrayList<Credencial> Credenciales = null;
    private static Autenticador instancia = null;
    private Autenticador(){Credenciales = new ArrayList<Credencial>();}
    public static Autenticador getInstance() {
        if (instancia == null) {
            instancia = new Autenticador();
        }
        return instancia;
    }

    private Credencial getCredencial(String usuario){
        for (Credencial credencial:Credenciales){
            if(credencial.getUsuario().equalsIgnoreCase(usuario)){
                return credencial;
            }
        }
        return null;
    }

    //La primera password es el mismo mail
    public void crearCredenciales(String mail){
        if (getCredencial(mail) == null) {
            Credencial credencial = new Credencial(mail, mail);
            Credenciales.add(credencial);
        }
    }

    public void editarPassword(String mail, String password){
        if (getCredencial(mail)!=null){
            getCredencial(mail).setPassword(password);
        }
    }

    public void eliminarCredencial(String mail){
        if(getCredencial(mail)!=null){
            Credenciales.remove(getCredencial(mail));
        }
    }


    public boolean autenticar(String mail, String password){
        boolean flag = false;
        if (getCredencial(mail)!=null){
            if (getCredencial(mail).getPassword().equals(password)) {
                flag = true;

            }
        }
        return flag;
    }


}
