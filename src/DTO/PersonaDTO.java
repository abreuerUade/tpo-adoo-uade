package DTO;

import Negocio.ServiciosEnvio;

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String mail;
    private int dni;
    private int telefono;
    private ServiciosEnvio serviciosEnvio;

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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ServiciosEnvio getServiciosEnvio() {
        return serviciosEnvio;
    }

    public void setServiciosEnvio(ServiciosEnvio serviciosEnvio) {
        this.serviciosEnvio = serviciosEnvio;
    }
}
