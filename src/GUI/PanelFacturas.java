package GUI;

import Controllers.ControladorUnidadFuncional;
import DTO.ConsorcioDTO;
import DTO.UnidadFuncionalDTO;
import Negocio.FacturaUnidadFuncional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class PanelFacturas extends JPanel {
    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;

    private JLabel lblOpciones;
    private JLabel lblUsuarios;
    private JButton btnPago;
    private JButton btnBaja;
    private JButton btnModificar;
    private JButton btnAtras;
    private JButton btnSalir;

    private DefaultTableModel contenidoTabla;
    private JTable tabla;
    private JScrollPane scrollPane;

    public PanelFacturas (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelFacturas(ConsorcioDTO consorcioDTO, UnidadFuncionalDTO unidadFuncionalDTO) {
        this.removeAll();
        ///////////// Panel Base ///////////////////

        this.setLayout(new BorderLayout());

        panelIz = new JPanel();
        GridLayout leftLayout = new GridLayout(6, 1);
        leftLayout.setVgap(30);
        panelIz.setLayout(leftLayout);
        panelIz.setPreferredSize(new Dimension(200, 500));
        panelIz.setBackground(Style.GRIS_CLARO);

        panelDe = new JPanel();
        BorderLayout rightLayout = new BorderLayout(20,20);
        panelDe.setLayout(rightLayout);
        panelDe.setPreferredSize(new Dimension(800, 500));
        panelDe.setBackground(Style.FONDO);
        panelDe.setBorder(BorderFactory.createEmptyBorder(30, 50, 20, 50));

        this.add(panelIz, BorderLayout.WEST);
        this.add(panelDe, BorderLayout.CENTER);

        //////////////////////////////////////////////////////////////////

        String unidad = unidadFuncionalDTO.getNroUnidad().toString();
        lblUsuarios = new JLabel("FACTURAS DE LA UNIDAD " + unidad);
        lblUsuarios.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblUsuarios.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnPago = new JButton("CONFIRMAR PAGO");
        btnBaja = new JButton("BAJA");
        btnBaja.setVisible(false);
        btnModificar = new JButton("MODIFICAR");
        btnModificar.setVisible(false);
        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

        ////////////// Tabla ////////////////

        contenidoTabla = new DefaultTableModel();
        tabla = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(tabla);
        scrollPane.setBounds(0, 0, 550, 370);
        scrollPane.setOpaque(false);

        contenidoTabla.addColumn("CODIGO");
        contenidoTabla.addColumn("FECHA");
        contenidoTabla.addColumn("MONTO ORD");
        contenidoTabla.addColumn("MONTO EXT");
        contenidoTabla.addColumn("FONDO DE RES.");
        contenidoTabla.addColumn("PAGADA");

        ArrayList<FacturaUnidadFuncional> facturas = ControladorUnidadFuncional.getInstance().getFacturasbyUf(unidadFuncionalDTO.getIdUnidadFuncional());

        for (FacturaUnidadFuncional f: facturas){
            Object [] row = new Object[6];

            row[0] = f.getCodigoFactura();
            row[1] = f.getFecha();
            row[2] = "$ " + f.getMontoOrdinario();
            row[3] = "$ " + f.getMontoExtraordinario();
            row[4] = "$ " + f.getReservas();
            row[5] = f.isPago() ? "Pagada" : "Sin Pagar";

                    contenidoTabla.addRow(row);
        }

        panelDe.add(lblUsuarios, BorderLayout.NORTH);
        panelDe.add(scrollPane, BorderLayout.CENTER);
        panelIz.add(lblOpciones);
        panelIz.add(btnPago);
        panelIz.add(btnBaja);
        panelIz.add(btnModificar);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);

        btnPago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    UUID id = (UUID) tabla.getValueAt(tabla.getSelectedRow(),0);
                    FacturaUnidadFuncional factura = ControladorUnidadFuncional.getInstance().getFacturaById(id, unidadFuncionalDTO.getIdUnidadFuncional());
                    if(factura.isPago()){
                        JOptionPane.showMessageDialog(masterFrame,"La factura ya esta paga.");
                    }else{
                        factura.setPago(true);
                        masterFrame.mostrarPanelFacturas(consorcioDTO, unidadFuncionalDTO);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar una factura");
                }
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelUnidadesFuncionales(consorcioDTO);
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });

    }
}
