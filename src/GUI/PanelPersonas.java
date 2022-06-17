package GUI;

import Controllers.ControladorConsorcio;
import Controllers.ControladorPersona;
import Controllers.ControladorUnidadFuncional;
import Controllers.ControladorUsuario;
import DTO.ConsorcioDTO;
import DTO.PersonaDTO;
import DTO.UnidadFuncionalDTO;
import DTO.UsuarioDTO;
import Negocio.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPersonas extends JPanel {

    private MasterFrame masterFrame;
    private JPanel panelIz;
    private JPanel panelDe;

    private JLabel lblOpciones;
    private JLabel lblUsuarios;
    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JButton btnAtras;
    private JButton btnSalir;

    private DefaultTableModel contenidoTabla;
    private JTable tabla;
    private JScrollPane scrollPane;

    public PanelPersonas (MasterFrame masterFrame){
        this.masterFrame = masterFrame;

    }

    public void armarPanelPersonas(ConsorcioDTO consorcioDTO) {
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

        lblUsuarios = new JLabel("PANEL DE PROPIETARIOS E INQUILINOS");
        lblUsuarios.setFont(new Font(Style.FONT, Font.BOLD, 20));
        lblUsuarios.setHorizontalAlignment(0);

        lblOpciones = new JLabel("Opciones: ");
        lblOpciones.setFont(new Font(Style.FONT, Font.BOLD, 18));
        lblOpciones.setHorizontalAlignment(0);

        btnAlta = new JButton("ALTA");
        btnBaja = new JButton("BAJA");
        btnModificar = new JButton("MODIFICAR");
        btnAtras = new JButton("ATRAS");
        btnSalir = new JButton("SALIR");

        ////////////// Tabla ////////////////

        contenidoTabla = new DefaultTableModel();
        tabla = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(tabla);
        scrollPane.setBounds(0, 0, 550, 370);
        scrollPane.setOpaque(false);

        contenidoTabla.addColumn("NOMBRE");
        contenidoTabla.addColumn("APELLIDO");
        contenidoTabla.addColumn("DNI");
        contenidoTabla.addColumn("TELÉFONO");
        contenidoTabla.addColumn("EMAIL");
        contenidoTabla.addColumn("UNIDAD");
        contenidoTabla.addColumn("CONDICIÓN");

        ArrayList<UnidadFuncionalDTO> unidades = ControladorUnidadFuncional.getInstance().getUnidadesFuncionalesbyConsorcio(consorcioDTO);

        for(UnidadFuncionalDTO uf : unidades){
            ArrayList<PersonaDTO> prop = ControladorUnidadFuncional.getInstance().getPropietarioByUf(uf);
            ArrayList<PersonaDTO> inqui = ControladorUnidadFuncional.getInstance().getInquilinoByUf(uf);

            for(PersonaDTO p : prop){
                Object [] row = new Object[7];
                row[0] = p.getNombre();
                row[1] = p.getApellido();
                row[2] = p.getDni();
                row[3] = p.getTelefono();
                row[4] = p.getMail();
                row[5] = uf.getNroUnidad();
                row[6] = "Propietario";

                contenidoTabla.addRow(row);
            }

            for(PersonaDTO i : inqui){
                Object [] row = new Object[7];
                row[0] = i.getNombre();
                row[1] = i.getApellido();
                row[2] = i.getDni();
                row[3] = i.getTelefono();
                row[4] = i.getMail();
                row[5] = uf.getNroUnidad();
                row[6] = "Inquilino";

                contenidoTabla.addRow(row);
            }

        }

        panelDe.add(lblUsuarios, BorderLayout.NORTH);
        panelDe.add(scrollPane, BorderLayout.CENTER);
        panelIz.add(lblOpciones);
        panelIz.add(btnAlta);
        panelIz.add(btnBaja);
        panelIz.add(btnModificar);
        panelIz.add(btnAtras);
        panelIz.add(btnSalir);

        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelAltaPersonas(consorcioDTO, null);
            }
        });

        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PersonaDTO personaDTO;
                int dni = (int) tabla.getValueAt(tabla.getSelectedRow(),2);
                int uf = (int) tabla.getValueAt(tabla.getSelectedRow(),5);
                int idUf = ControladorUnidadFuncional.getInstance().getIdFromUf(consorcioDTO.getId(), uf);
                String condicion = tabla.getValueAt(tabla.getSelectedRow(),6).toString();
                personaDTO = ControladorPersona.getInstance().getPersonabyDNI(dni).personaToDTO();

                int res = JOptionPane.showOptionDialog(new JFrame(), "Seguro que desea elimiar esta persona?","Aviso",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    try {
                        if(condicion.equals("Propietario")){
                            ControladorUnidadFuncional.getInstance().eliminarPropietario(personaDTO,idUf);
                        }else {
                            ControladorUnidadFuncional.getInstance().eliminarInquilino(personaDTO,idUf);
                        }
                        masterFrame.mostrarPanelPersonas(consorcioDTO);
                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar una persona.");
                    }
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                PersonaDTO persona = new PersonaDTO();
                try {
                    int dni = (int) tabla.getValueAt(tabla.getSelectedRow(),2);
                    persona = ControladorPersona.getInstance().getPersonabyDNI(dni).personaToDTO();
                    masterFrame.mostrarPanelAltaPersonas(consorcioDTO, persona);

                    //ControladorUsuario.getInstance().eliminarUsuario(usuarioDTO);

                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(masterFrame,"Debe seleccionar un usuario.");
                }


            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelPrincipal();
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                masterFrame.mostrarPanelLogin();
            }
        });

    }
}
