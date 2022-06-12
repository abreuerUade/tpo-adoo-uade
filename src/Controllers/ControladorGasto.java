package Controllers;
import DTO.GastoDTO;
import Negocio.Expensas;
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
            if (g.getId().equals(id)) {
                return g;
            }
        }
        return null;
    }

    public List<GastoDTO> getGastos(){
        List<GastoDTO> listaGastos = new ArrayList<GastoDTO>();

        for (Gasto g : this.gastos){
            listaGastos.add(g.gastoToDTO());
        }

        return listaGastos;
    }

    public void viewGastos(Integer idconsorcio){
        if (ControladorConsorcio.getInstance().existeConsorcio(idconsorcio)){
            System.out.println("Lista de gastos del consorcio: " + ControladorConsorcio.getInstance().getConsorcioDTO(idconsorcio).getNombre());
            for (Gasto g:this.gastos) {
                if (g.getIdconsorcio().equals(idconsorcio)){
                    System.out.println();
                    System.out.println(g.getNombre());
                    System.out.println("Costo: " + g.getMonto());
                    System.out.println(g.getFechaFact());
                    System.out.println("Cantidad de cuotas: " + g.getCantCuotas());
                    System.out.println("Periodo entre cuotas en meses: " + g.getPeriodo());
                    System.out.println(g.getTipoExpensas());
                }

            }
        }
    }

    public Integer gastosOrdinariosbyConsorcio(Integer idconsorcio){
        int totalgastos = 0;
        if (ControladorConsorcio.getInstance().existeConsorcio(idconsorcio)){
            for (Gasto g:this.gastos){
                if(g.getIdconsorcio().equals(idconsorcio)){
                    if(g.getTipoExpensas().equals(Expensas.ORDINARIAS)){
                        if(g.getCantCuotas()==0) {
                            totalgastos += g.getMonto();
                        }
                    }
                }
            }
        }
        return totalgastos;
    }


    public Integer gastosExtraordinariosbyConsorcio(Integer idconsorcio){
        Integer gastosExtraordinarios = 0;
        if (ControladorConsorcio.getInstance().existeConsorcio(idconsorcio)){
            for (Gasto gExt:gastos){
                if(gExt.getIdconsorcio().equals(idconsorcio)){
                    if(gExt.getTipoExpensas().equals(Expensas.EXTRAORDINARIAS)){
                        if(gExt.getCantCuotas()==0) {
                            gastosExtraordinarios += gExt.getMonto();
                        }
                    }
                }
            }
        }
        return gastosExtraordinarios;
    }





    public void crearGasto(GastoDTO gasto){
        if (gasto != null) {
            if (ControladorConsorcio.getInstance().existeConsorcio(gasto.getIdconsorcio())){
                Gasto nuevoGasto = new Gasto(gasto);
                gastos.add(nuevoGasto);
            }
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
            Gasto gastoVerificar = getGastoById(gasto.getId());
            Gasto gastoModif = getGastoById(gasto.getId());
            if (gastoVerificar != null) {
                int index = gastos.indexOf(gastoModif);
                gastoModif.setCantCuotas(gasto.getCantCuotas());
                gastoModif.setFechaFact(gasto.getFechaFact());
                gastoModif.setMonto(gasto.getMonto());
                gastoModif.setNombre(gasto.getNombre());
                gastoModif.setPeriodo(gasto.getPeriodo());
                gastoModif.setTipoExpensas(gasto.getTipoExpensas());
                gastoModif.setIdconsorcio(gasto.getIdconsorcio());
                gastos.set(index, gastoModif);
            }
        }
    }


}
