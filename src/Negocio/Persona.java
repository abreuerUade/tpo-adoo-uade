package Negocio;

import DTO.PersonaDTO;

public class Persona {

    private String nombre;
    private String apellido;
    private String mail;
    private int dni;
    private int telefono;
    private ServiciosEnvio serviciosEnvio;

    public Persona (PersonaDTO personaDTO) {

        this.nombre = personaDTO.getNombre();
        this.apellido = personaDTO.getApellido();
        this.mail = personaDTO.getMail();
        this.dni = personaDTO.getDni();
        this.telefono = personaDTO.getTelefono();
        this.serviciosEnvio = personaDTO.getServiciosEnvio();
    }

    public PersonaDTO personaToDTO () {
        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setNombre(this.nombre);
        personaDTO.setApellido(this.apellido);
        personaDTO.setMail(this.mail);
        personaDTO.setDni(this.dni);
        personaDTO.setTelefono(this.telefono);
        personaDTO.setServiciosEnvio(this.serviciosEnvio);

        return personaDTO;
    }

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

    public ServiciosEnvio getModoDeEnvio() {
        return serviciosEnvio;
    }

    public void setModoDeEnvio(ServiciosEnvio serviciosEnvio) {
        this.serviciosEnvio = serviciosEnvio;
    }
}
