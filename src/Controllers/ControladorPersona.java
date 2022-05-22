package Controllers;

import DTO.GastoDTO;
import DTO.PersonaDTO;
import Negocio.Gasto;
import Negocio.Persona;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ControladorPersona {

    private ArrayList<Persona> personas = null;
    private static ControladorPersona instancia = null;
    public ControladorPersona(){personas = new ArrayList<Persona>();}
    public static ControladorPersona getInstance(){
        if (instancia == null){
            instancia = new ControladorPersona();
        }
        return instancia;
    }

    public Persona getPersonabyDNI(int DNI){
        for(Persona p : personas){
            if (p.getDni() == DNI) {
                return p;
            }
        }
        return null;
    }

    public List<PersonaDTO> obtenerPersonas() {

        List<PersonaDTO> listaPersonas = new ArrayList<PersonaDTO>();

        for (Persona p : personas) {
            listaPersonas.add(p.personaToDTO());
        }

        return listaPersonas;

    }


    public void crearPersona(PersonaDTO persona) {
        if (persona != null){
            Persona nuevaPersona = new Persona(persona);
            personas.add(nuevaPersona);
        }
    }


    public void eliminarPersona(PersonaDTO persona){
        if (persona != null) {
            Persona personaARemover = getPersonabyDNI(persona.getDni());
            personas.remove(personaARemover);
        }
    }

    public void modificarPersona(PersonaDTO persona){
        if (persona != null) {
            Persona personaModif = getPersonabyDNI(persona.getDni());

            if (personaModif != null) {
                int index = personas.indexOf(personaModif);
                personaModif.setApellido(persona.getApellido());
                personaModif.setDni(persona.getDni());
                personaModif.setMail(persona.getMail());
                personaModif.setNombre(persona.getNombre());
                personaModif.setTelefono(persona.getTelefono());
                personaModif.setModoDeEnvio(persona.getServiciosEnvio());

                personas.set(index, personaModif);
            }
        }
    }
}
