package Controllers;
import Auth.Autenticador;
import Auth.AuthProvider;
import Negocio.*;
import DTO.UsuarioDTO;

import java.util.ArrayList;

public class ControladorUsuario {

    private ArrayList<Usuario> Usuarios = null;
    private static ControladorUsuario instancia = null;
    private ControladorUsuario() {Usuarios = new ArrayList<Usuario>();}
    public static ControladorUsuario getInstance(){
        if (instancia == null){
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    public ArrayList<UsuarioDTO> getUsuarios() {
        ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
        for (Usuario u:this.Usuarios) {
            lista.add(u.usuarioToDto());
        }
        return lista;
    }

    private Usuario getUsuario(String mail){
        for (Usuario u:Usuarios) {
            if (u.getMail().equals(mail)){
                return u;
            }
        }
        return null;
    }

    public void crearUsuario(UsuarioDTO datos){
        if (datos != null){
            Usuario userCheck = getUsuario(datos.getMail());
            Usuario userNew = new Usuario(datos);
            if (userCheck == null) {
                userNew.setApellido(datos.getApellido());
                userNew.setNombre(datos.getNombre());
                userNew.setMail(datos.getMail());
                Usuarios.add(userNew);
                //Creamos las credenciales
                Autenticador.getInstance().crearCredenciales(datos.getMail());
            }
        }
    }

    public void editarUsuario(UsuarioDTO datos){
        if (datos!=null){
            Usuario userEdit = getUsuario(datos.getMail());
            if (userEdit!=null){
                int index = Usuarios.indexOf(userEdit);
                userEdit.setApellido(datos.getApellido());
                userEdit.setNombre(datos.getNombre());
                Usuarios.set(index, userEdit);
            }
        }
    }

    public void eliminarUsuario(UsuarioDTO datos){
        if (datos != null){
            Usuario userDel = getUsuario(datos.getMail());
            if (userDel!=null){
                Usuarios.remove(getUsuario(datos.getMail()));
                Autenticador.getInstance().eliminarCredencial(datos.getMail());
            }
        }
    }
    public UsuarioDTO verificarUsuario(String mail){
        Usuario u = getUsuario(mail);
        if (u == null){
            return null;
        }
        return u.usuarioToDto();
    }

    public boolean verificarUsuarioBoolean(String mail){
        Usuario u = getUsuario(mail);
        if (u == null){
            return false;
        }
        return true;
    }

}
