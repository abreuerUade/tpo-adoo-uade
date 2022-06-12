package Test;

import Controllers.ControladorPersona;
import Controllers.ControladorUnidadFuncional;
import DTO.PersonaDTO;

import static Negocio.ServiciosEnvio.EMAIL;

public class TestUnidadFuncional {
    public static void testing(){

        PersonaDTO persona = new PersonaDTO();
        persona.setDni(27523655);
        persona.setApellido("Gimenez");
        persona.setNombre("Santiago");
        persona.setTelefono(113356988);
        persona.setMail("sgimenez@gmail.com");
        persona.setServiciosEnvio(EMAIL);
        ControladorPersona.getInstance().crearPersona(persona);

        ControladorUnidadFuncional.getInstance().agregarPropietario(persona,1);
        if (ControladorUnidadFuncional.getInstance().getUnidadFuncional(1).getPropietarios().get(ControladorUnidadFuncional.getInstance().getUnidadFuncional(1).getPropietarios().size()-1).getNombre() == "Santiago"){
            System.out.println("Test exitoso");
        }
    }
}
