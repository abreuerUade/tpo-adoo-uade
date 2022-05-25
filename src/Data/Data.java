package Data;
import DTO.*;
import static Negocio.ServiciosEnvio.*;
import Controllers.*;


public class Data {
    public static void load(){

        UsuarioDTO admin = new UsuarioDTO();
        admin.setApellido("root");
        admin.setNombre("root");
        admin.setMail("rr@consorcios.com");
        ControladorUsuario.getInstance().crearUsuario(admin);

        UsuarioDTO admin2 = new UsuarioDTO();
        admin2.setApellido("admin");
        admin2.setNombre("admin");
        admin2.setMail("admin@consorcios.com");
        ControladorUsuario.getInstance().crearUsuario(admin2);

        UsuarioDTO admin3 = new UsuarioDTO();
        admin3.setApellido("test");
        admin3.setNombre("test");
        admin3.setMail("test");
        ControladorUsuario.getInstance().crearUsuario(admin3);

        PersonaDTO persona1 = new PersonaDTO();
        persona1.setDni(25634855);
        persona1.setApellido("Perez");
        persona1.setNombre("Rodrigo");
        persona1.setTelefono(1145226368);
        persona1.setMail("rperez@gmail.com");
        persona1.setServiciosEnvio(EMAIL);
        ControladorPersona.getInstance().crearPersona(persona1);

        PersonaDTO persona2 = new PersonaDTO();
        persona2.setDni(27523655);
        persona2.setApellido("Gimenez");
        persona2.setNombre("Santiago");
        persona2.setTelefono(113356988);
        persona2.setMail("sgimenez@gmail.com");
        persona2.setServiciosEnvio(EMAIL);
        ControladorPersona.getInstance().crearPersona(persona2);

        PersonaDTO persona3 = new PersonaDTO();
        persona3.setDni(37451633);
        persona3.setApellido("Rodriguez");
        persona3.setNombre("Pablo");
        persona3.setTelefono(1133655211);
        persona3.setMail("prodriguez@gmail.com");
        persona3.setServiciosEnvio(WHATSAPP);
        ControladorPersona.getInstance().crearPersona(persona3);

        PersonaDTO persona4 = new PersonaDTO();
        persona4.setDni(20410653);
        persona4.setApellido("Martinez");
        persona4.setNombre("Juan");
        persona4.setTelefono(1133223365);
        persona4.setMail("jmartinez@gmail.com");
        persona4.setServiciosEnvio(SMS);
        ControladorPersona.getInstance().crearPersona(persona4);
    }
}
