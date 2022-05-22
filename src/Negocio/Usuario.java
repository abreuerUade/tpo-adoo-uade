package Negocio;

import DTO.UsuarioDTO;


public class Usuario {
    private String nombre;

    private String apellido;
    private String mail;


    public Usuario (UsuarioDTO usuarioDTO) {

        this.nombre = usuarioDTO.getNombre();
        this.apellido = usuarioDTO.getApellido();
        this.mail = usuarioDTO.getMail();

    }

    public UsuarioDTO usuarioToDto(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNombre(this.nombre);
        usuarioDTO.setApellido(this.apellido);
        usuarioDTO.setMail(this.mail);

        return usuarioDTO;
    }
    //
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
