package Controllers;
import DTO.ConsorcioDTO;
import DTO.GastoDTO;
import Negocio.Expensas;
import Negocio.Gasto;
import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<GastoDTO> getGastosByConsorcio(ConsorcioDTO consorcioDTO){
        ArrayList<GastoDTO> gastosByConsorcio = new ArrayList<>();
        if(consorcioDTO != null) {
            for (Gasto g : gastos) {
                if (g.getIdconsorcio().equals(consorcioDTO.getId())) {
                    gastosByConsorcio.add(g.gastoToDTO());
                }
            }
        }
        return gastosByConsorcio;
    }

    public Integer gastosOrdinariosbyConsorcio(Integer idconsorcio){
        int totalgastos = 0;
        if (ControladorConsorcio.getInstance().existeConsorcio(idconsorcio)){
            for (Gasto g:this.gastos){
                if(g.getIdconsorcio().equals(idconsorcio)){
                    if(g.getTipoExpensas().equals(Expensas.ORDINARIAS) || g.getTipoExpensas().equals(Expensas.GASTOS_PARTICULARES)){
                        if(g.getFechaFact().getMonth()== new Date().getMonth()) {
                            if (g.getCantCuotas() == 0) {
                                totalgastos += g.getMonto();
                            }
                            if (g.getCantCuotas() > 0) {
                                totalgastos += ControladorGasto.getInstance().cobrarGastoCuota(g);
                            }
                        }
                        if (verificarMesCuota(g)){
                            if(g.getCantCuotas() > 0){
                                totalgastos += ControladorGasto.getInstance().cobrarGastoCuota(g);
                            }
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
                        if(gExt.getFechaFact().getMonth()== new Date().getMonth()) {
                            if (gExt.getCantCuotas() == 0) {
                                gastosExtraordinarios += gExt.getMonto();
                            }
                            if (gExt.getCantCuotas() > 0) {
                                gastosExtraordinarios += ControladorGasto.getInstance().cobrarGastoCuota(gExt);
                            }
                        }
                        // Pagos de cuotas de gastos fuera del mes.
                        if (verificarMesCuota(gExt)){
                            if(gExt.getCantCuotas() > 0){
                                gastosExtraordinarios += ControladorGasto.getInstance().cobrarGastoCuota(gExt);
                            }
                        }

                    }
                }
            }
        }
        return gastosExtraordinarios;
    }

    public Integer cobrarGastoCuota(Gasto gastoProcesarPago){
        Integer cuota = gastoProcesarPago.getMonto()/gastoProcesarPago.getCantCuotas();
        if(gastoProcesarPago.getCantCuotas()>0){
            gastoProcesarPago.setMonto(gastoProcesarPago.getMonto() - cuota);
            gastoProcesarPago.setCantCuotas(gastoProcesarPago.getCantCuotas()-1);
            modificarGasto(gastoProcesarPago.gastoToDTO());
        }
        return cuota;
    }

    public boolean verificarMesCuota(Gasto verificarGasto){
        boolean seDebePagar = false;
        int cuotas = verificarGasto.getCantCuotas();
        int mesActual = new Date().getMonth();
        int mesTest = verificarGasto.getFechaFact().getMonth();
        while (cuotas>0){
            mesTest += verificarGasto.getPeriodo();
            if (mesTest == mesActual){
                seDebePagar = true;
                break;
            }
            cuotas-=1;
        }
        return seDebePagar;
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
