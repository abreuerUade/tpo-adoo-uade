package Data;
import DTO.*;
import static Negocio.ServiciosEnvio.*;
import Controllers.*;
import Negocio.Cuenta;
import Negocio.Expensas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


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

        UnidadFuncionalDTO uf1A = new UnidadFuncionalDTO();
        uf1A.setNroUnidad(1);
        uf1A.setSuperficie(45);


        ConsorcioDTO consorcio1 = new ConsorcioDTO();
        consorcio1.setNombre("Lima 474");
        consorcio1.setCuentaBanco(new Cuenta("Lima 474","543215495432",25516f));
        consorcio1.setBarrio("CABA");
        consorcio1.setId(1);
        ControladorConsorcio.getInstance().crearConsorcio(consorcio1);

        //Reloj
        Date fechaactual = new Date();
        //Expensas
        GastoDTO gasto1 = new GastoDTO();
        gasto1.setId(1);
        gasto1.setMonto(5000);
        gasto1.setNombre("EDENOR");
        gasto1.setFechaFact(fechaactual);
        gasto1.setCantCuotas(0);
        gasto1.setPeriodo(0);
        gasto1.setIdconsorcio(1);
        gasto1.setTipoExpensas(Expensas.ORDINARIAS);
        ControladorGasto.getInstance().crearGasto(gasto1);

        GastoDTO gasto2 = new GastoDTO();
        gasto2.setId(2);
        gasto2.setMonto(60000);
        gasto2.setNombre("Sueldo");
        gasto2.setFechaFact(fechaactual);
        gasto2.setCantCuotas(0);
        gasto2.setPeriodo(0);
        gasto2.setIdconsorcio(1);
        gasto2.setTipoExpensas(Expensas.ORDINARIAS);
        ControladorGasto.getInstance().crearGasto(gasto2);

        GastoDTO gasto3 = new GastoDTO();
        gasto3.setId(3);
        gasto3.setMonto(7000);
        gasto3.setNombre("Arreglo Terraza");
        gasto3.setFechaFact(fechaactual);
        gasto3.setCantCuotas(0);
        gasto3.setPeriodo(0);
        gasto3.setIdconsorcio(1);
        gasto3.setTipoExpensas(Expensas.EXTRAORDINARIAS);
        ControladorGasto.getInstance().crearGasto(gasto3);

    }
}
