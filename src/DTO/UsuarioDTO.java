package DTO;

public class UsuarioDTO {

    private String nombre;
    private String apellido;
    private String mail;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String in_nombre) {
        this.nombre = in_nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String in_apellido) {
        this.apellido = in_apellido;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String in_mail) {
        this.mail = in_mail;
    }

}
