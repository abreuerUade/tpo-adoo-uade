package Negocio;

import Controllers.ControladorConsorcio;
import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.GastoDTO;
import DTO.UnidadFuncionalDTO;

import java.util.ArrayList;
import java.util.Date;

public class PagoCompletoGenerarReservas extends LiquidacionGenerica{
    // Crea un gasto del tipo fondo de reserva el cual se suma al TOTAL que obtengo de Calcular gasto y Dividir los gastos entre todas las unidades funcionales y generar sus facturas.
    @Override
    public void DivisionExpensas(int idconsorcio, ArrayList<Integer> gastos) {
        ConsorcioDTO consorcioDTO = ControladorConsorcio.getInstance().getConsorcioDTO(idconsorcio);
        ArrayList<UnidadFuncionalDTO> listUF = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO);
        float superficieTotal = ControladorUnidadFuncional.getInstance().calcularSuperficieTotalbyConsorcio(idconsorcio);


        //CHEQUEAR ESTO: deberia crear la reserva a traves del controller?
        //de donde obtengo el monto seteado para reserva?
        //
        GastoDTO gastoDto = new GastoDTO();
        gastoDto.setNombre("Reservas");
        gastoDto.setFechaFact(new Date());
        gastoDto.setCantCuotas(1);
        gastoDto.setTipoExpensas(Expensas.FONDOS_RESERVA);
        gastoDto.setMonto(500);
        gastoDto.setId(6);
        gastoDto.setIdconsorcio(1);
        gastoDto.setPeriodo(0);

        Gasto gasto = new Gasto(gastoDto);
        //CHEQUEAR LO DE ARRIBA


        for (UnidadFuncionalDTO uf:listUF) {
            float coeficiente = uf.getSuperficie() / superficieTotal;
            float expensaOrdinaria = gastos.get(0) * coeficiente;
            float expensaExtraordinaria = gastos.get(1) * coeficiente;
            float reserva = gasto.getMonto() * coeficiente;
            //Facturador.crearFactura(uf.getNroUnidad(), expensaOrdinaria, expensaExtraordinaria, reserva);
        }
    }
}