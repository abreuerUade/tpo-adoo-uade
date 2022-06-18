package Data;
import DTO.*;
import static Negocio.ServiciosEnvio.*;
import Controllers.*;
import Negocio.Cuenta;
import Negocio.Expensas;
import Negocio.FacturaUnidadFuncional;

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
        admin3.setApellido("Breuer");
        admin3.setNombre("Andres");
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


        UnidadFuncionalDTO uf1 = new UnidadFuncionalDTO();
        uf1.setIdUnidadFuncional(1);
        uf1.setIdconsorcio(1);
        uf1.setNroUnidad(1);
        uf1.setSuperficie(45);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf1);
        ControladorUnidadFuncional.getInstance().agregarInquilino(persona1,1);
        ControladorUnidadFuncional.getInstance().agregarPropietario(persona2,1);

        UnidadFuncionalDTO uf2 = new UnidadFuncionalDTO();
        uf2.setIdUnidadFuncional(2);
        uf2.setIdconsorcio(1);
        uf2.setNroUnidad(2);
        uf2.setSuperficie(70);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf2);
        ControladorUnidadFuncional.getInstance().agregarInquilino(persona3,2);

        UnidadFuncionalDTO uf3 = new UnidadFuncionalDTO();
        uf3.setIdUnidadFuncional(3);
        uf3.setIdconsorcio(1);
        uf3.setNroUnidad(3);
        uf3.setSuperficie(65);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf3);
        ControladorUnidadFuncional.getInstance().agregarPropietario(persona4,3);

        UnidadFuncionalDTO uf4 = new UnidadFuncionalDTO();
        uf4.setIdUnidadFuncional(4);
        uf4.setIdconsorcio(1);
        uf4.setNroUnidad(4);
        uf4.setSuperficie(40);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf4);
        ControladorUnidadFuncional.getInstance().agregarInquilino(persona4,4);

        UnidadFuncionalDTO uf5 = new UnidadFuncionalDTO();
        uf5.setIdUnidadFuncional(5);
        uf5.setIdconsorcio(1);
        uf5.setNroUnidad(5);
        uf5.setSuperficie(66);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf5);

        UnidadFuncionalDTO uf6 = new UnidadFuncionalDTO();
        uf6.setIdUnidadFuncional(6);
        uf6.setIdconsorcio(1);
        uf6.setNroUnidad(6);
        uf6.setSuperficie(45);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf6);

        UnidadFuncionalDTO uf7 = new UnidadFuncionalDTO();
        uf7.setIdUnidadFuncional(7);
        uf7.setIdconsorcio(1);
        uf7.setNroUnidad(7);
        uf7.setSuperficie(70);
        ControladorUnidadFuncional.getInstance().crearUnidadFuncional(uf7);

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

        GastoDTO gasto4 = new GastoDTO();
        gasto4.setId(4);
        gasto4.setMonto(100000);
        gasto4.setNombre("Pintar Fachada");
        gasto4.setFechaFact(new Date(122,3,1));
        gasto4.setCantCuotas(4);
        gasto4.setPeriodo(2);
        gasto4.setIdconsorcio(1);
        gasto4.setTipoExpensas(Expensas.EXTRAORDINARIAS);
        ControladorGasto.getInstance().crearGasto(gasto4);

        GastoDTO gasto5 = new GastoDTO();
        gasto5.setId(5);
        gasto5.setMonto(10000);
        gasto5.setNombre("Reparacion cerradura entrada");
        gasto5.setFechaFact(fechaactual);
        gasto5.setCantCuotas(0);
        gasto5.setPeriodo(0);
        gasto5.setIdconsorcio(1);
        gasto5.setTipoExpensas(Expensas.GASTOS_PARTICULARES);
        ControladorGasto.getInstance().crearGasto(gasto5);

        FacturaUnidadFuncional factura1 = new FacturaUnidadFuncional(4234, 234623, 4789,false, new Date());
        ControladorUnidadFuncional.getInstance().agregarFactura(factura1, 1);
    }
}
