package Controllers;
import DTO.GastoDTO;
import Negocio.Gasto;
import java.util.ArrayList;
import java.util.List;

public class ControladorGasto {

    private ArrayList<Gasto> gastos = null;
    private static ControladorGasto instancia = null;
    private ControladorGasto() {
        gastos = new ArrayList<Gasto>();
    }
    public static ControladorGasto getInstance(){
        if (instancia == null){
            instancia = new ControladorGasto();
        }

        return instancia;
    }

    private Gasto getGastoById(Integer id) {
        for (Gasto g : gastos) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    public List<GastoDTO> obtenerGastos(){
        List<GastoDTO> listaGastos = new ArrayList<GastoDTO>();

        for (Gasto g : this.gastos){
            listaGastos.add(g.gastoToDTO());
        }

        return listaGastos;
    }


    public void crearGasto(GastoDTO gasto){
        if (gasto != null) {
            Gasto nuevoGasto = new Gasto(gasto);
            gastos.add(nuevoGasto);
        }
    }

    public void eliminarGasto(GastoDTO gasto){
        if (gasto != null) {
            Gasto gastoARemover = getGastoById(gasto.getId());
            gastos.remove(getGastoById(gasto.getId()));
        }
    }


    public void modificarGasto(GastoDTO gasto){
        if (gasto != null) {
            Gasto gastoModif = getGastoById(gasto.getId());

            if (gastoModif != null) {
                int index = gastos.indexOf(gastoModif);
                gastoModif.setCantCuotas(gasto.getCantCuotas());
                gastoModif.setFechaFact(gasto.getFechaFact());
                gastoModif.setMonto(gasto.getMonto());
                gastoModif.setNombre(gasto.getNombre());
                gastoModif.setPeriodo(gasto.getPeriodo());
                gastoModif.setTipoExpensas(gasto.getTipoExpensas());
                gastos.set(index, gastoModif);
            }
        }
    }


}
