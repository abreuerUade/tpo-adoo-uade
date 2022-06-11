package Test;

import Controllers.ControladorPersona;
import Controllers.ControladorUnidadFuncional;

public class TestUnidadFuncional {
    public static void testing(){
        ControladorUnidadFuncional.getInstance().agregarInquilino((ControladorPersona.getInstance().getPersonabyDNI(37451633)).personaToDTO(),1);
        ControladorUnidadFuncional.getInstance().agregarInquilino((ControladorPersona.getInstance().getPersonabyDNI(27523655)).personaToDTO(),1);
        ControladorUnidadFuncional.getInstance().viewUnidadFuncional(1);
        ControladorUnidadFuncional.getInstance().eliminarInquilino((ControladorPersona.getInstance().getPersonabyDNI(27523655)).personaToDTO(),1);
        ControladorUnidadFuncional.getInstance().viewUnidadFuncional(1);

    }
}
