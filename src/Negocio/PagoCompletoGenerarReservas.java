package Negocio;

import Controllers.ControladorConsorcio;
import Controllers.ControladorGasto;
import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.GastoDTO;
import DTO.UnidadFuncionalDTO;

import java.util.ArrayList;
import java.util.Date;

public class PagoCompletoGenerarReservas extends LiquidacionGenerica{
    // Crea un gasto del tipo fondo de reserva el cual se suma al TOTAL que obtengo de Calcular gasto y Dividir los gastos entre todas las unidades funcionales y generar sus facturas.
    @Override
    public void DivisionExpensas(int idconsorcio, Integer generarReserva, Integer usarReserva) {
        ConsorcioDTO consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(idconsorcio);
        ArrayList<UnidadFuncionalDTO> listUF = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO);
        float superficieTotal = ControladorUnidadFuncional.getInstance().calcularSuperficieTotalbyConsorcio(idconsorcio);
        ArrayList<Integer> gastos = calcularGastos(idconsorcio);

        //Creo Fondo de Reservas a asignar al consorcio
        GastoDTO gastoDto = new GastoDTO();
        gastoDto.setNombre("Fondo de Reservas");
        gastoDto.setFechaFact(new Date());
        gastoDto.setCantCuotas(1);
        gastoDto.setTipoExpensas(Expensas.FONDOS_RESERVA);
        gastoDto.setMonto(generarReserva);
        gastoDto.setId(6);
        gastoDto.setIdconsorcio(idconsorcio);
        gastoDto.setPeriodo(0);

        ControladorGasto.getInstance().crearGasto(gastoDto);

        for (UnidadFuncionalDTO uf:listUF) {
            float coeficiente = uf.getSuperficie() / superficieTotal;
            float expensaOrdinaria = gastos.get(0) * coeficiente;
            float expensaExtraordinaria = gastos.get(1) * coeficiente;
            float reserva = generarReserva * coeficiente;
            Facturador.crearFactura(uf.getIdUnidadFuncional(), expensaOrdinaria, expensaExtraordinaria, reserva);
        }
    }
}