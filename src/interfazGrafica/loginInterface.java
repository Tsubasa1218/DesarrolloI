/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import Ordenes.Ordenes;
import Reportes.Reporte;
import Usuarios.Usuario;
import javax.swing.JOptionPane;
import dataBaseOperations.OperacionesBD;
import inventario.Vehiculo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import Sedes.Sede;
import Usuarios.Comprador;
import Ventas.Venta;
import inventario.Partes;
import java.awt.Color;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;


/**
 *
 * @author juanjose
 */
public class loginInterface extends javax.swing.JFrame {
    BorderLayout border;
    CardLayout cl, clVendedor, clJefe, clInventario;
    
    ButtonGroup modUsuario;
    ButtonGroup agregarVehiculos;
    ButtonGroup modVehiculos;
    ButtonGroup tiempoReporte;
    ButtonGroup espacioReporte;
  
    int tipoReporte;
    final int COTIZACIONES_SEDE = 1;
    final int COTIZACIONES_EMPRESA = 2;
    final int ORDENES_SEDE = 3;
    final int ORDENES_EMPRESA = 4;
    final int VENTAS_SEDE = 5;
    final int VENTAS_EMPRESA = 6;
    final int VEHICULOS_AGREGADOS = 7;
    String id_usuario_global;
    /**
     * Creates new form loginInterface
     */

    public loginInterface() {
        initComponents();
        id_usuario_global = "";
        tipoReporte = -1;
        //Inicializacion de paneles como no visibles
        panelContenedor.setVisible(true);
        panelContenedorJefe.setVisible(true);
        panelContenedorVendedor.setVisible(true);
        
        panelCrearUsuario.setVisible(false);
        panelModificarUsuario.setVisible(false);
        panelCrearSede.setVisible(false);
        panelModificarSede.setVisible(false);
        panelAgregarVehiculos.setVisible(false);
        panelModificarVehiculo.setVisible(false);
        panelAgregarPartes.setVisible(false);
        panelModificarPartes.setVisible(false);
        panelGenerarReportes.setVisible(false);
        
        //Adicion de paneles al card layout del gerente
        panelContenedor.setLayout(new CardLayout());
        panelContenedor.add(panelVacio, "Inicio");
        panelContenedor.add(panelCrearUsuario, "Crear Usuario");
        panelContenedor.add(panelCrearSede, "Crear Sede");
        panelContenedor.add(panelModificarUsuario, "Modificar Usuario");
        panelContenedor.add(panelModificarSede, "Modificar Sede");
        panelContenedor.add(panelAgregarVehiculos, "Agregar Vehiculo");
        panelContenedor.add(panelModificarVehiculo, "Modificar Vehiculo");
        panelContenedor.add(panelAgregarPartes, "Agregar Partes");
        panelContenedor.add(panelModificarPartes, "Modificar Partes");
        panelContenedor.add(panelGenerarReportes, "Generar reportes");
        panelContenedor.add(panelConsultas, "Consultas");
        panelContenedor.add(panelReporteFinal, "Reporte");
        
        cl = (CardLayout)(panelContenedor.getLayout());
        
        
        //Adicion de paneles al card layout del vendedor
        panelContenedorVendedor.setLayout(new CardLayout());
        panelContenedorVendedor.add(panelVacio1, "Inicio");
        panelContenedorVendedor.add(panelCrearCotizacion, "Crear cotizacion");
        panelContenedorVendedor.add(panelConsultarCotizacion, "Consultar cotizacion");
        panelContenedorVendedor.add(panelVender, "Vender");

        clVendedor = (CardLayout)(panelContenedorVendedor.getLayout());
        
        //Adicion de paneles al card layout del jefe de taller
        panelContenedorJefe.setLayout(new CardLayout());
        panelContenedorJefe.add(panelVacio2, "Inicio");
        panelContenedorJefe.add(panelCrearOrden, "Crear orden");
        panelContenedorJefe.add(panelConsultarOrden, "Consultar orden");
        
        clJefe = (CardLayout)panelContenedorJefe.getLayout();
        
        //Adicion de paneles al cardlayout del panel de inventario
        panel.setLayout(new CardLayout());
        panel.add(panelGestion, "Gestion");
        panel.add(manejoVehiculos, "Vehiculos");
        panel.add(manejoPartes, "Partes");

        //System.out.println(""+panelContenedorInventario.getLayout());
        clInventario = (CardLayout)panel.getLayout();
        
        
         //Creacion de ButtonGroups
        modUsuario = new ButtonGroup();
        agregarVehiculos = new ButtonGroup();
        modVehiculos = new ButtonGroup();
        tiempoReporte = new ButtonGroup();
        espacioReporte = new ButtonGroup();
        
        modUsuario.add(modificarActivoRB);
        modUsuario.add(modificarInactivoRB);
        
        agregarVehiculos.add(crearVehiculoNuevoRB);
        agregarVehiculos.add(crearVehiculoUsadoRB);
        
        modVehiculos.add(modificarVehiculoNuevoRB);
        modVehiculos.add(modificarVehiculoUsadoRB);
        
        tiempoReporte.add(semanalOpcionesReportes);
        tiempoReporte.add(todoOpcionesReportes);
        
        espacioReporte.add(sedesOpcionesReportes);
        espacioReporte.add(empresaOpcionesReportes);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gerenteJFrame = new javax.swing.JFrame();
        gerenteJPanel = new javax.swing.JPanel();
        manejoUsuariosJPanel = new javax.swing.JPanel();
        crearUsuarioButton = new javax.swing.JButton();
        modificarUsuarioButton = new javax.swing.JButton();
        consultarUsuarios = new javax.swing.JButton();
        manejoSedesJPanel = new javax.swing.JPanel();
        crearSedeButton = new javax.swing.JButton();
        modificarSedeButton = new javax.swing.JButton();
        consultarSedes = new javax.swing.JButton();
        manejoReportesJPanel = new javax.swing.JPanel();
        generarReporteButton = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        panelBanner = new javax.swing.JPanel();
        nombreUserLabel = new javax.swing.JLabel();
        sedeCargoLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        salirLabel = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        jefeJFrame = new javax.swing.JFrame();
        panelContenedorJefe = new javax.swing.JPanel();
        panelBanner3 = new javax.swing.JPanel();
        nombreUserLabel3 = new javax.swing.JLabel();
        sedeCargoLabel3 = new javax.swing.JLabel();
        logoLabel3 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        salirLabel1 = new javax.swing.JLabel();
        manejoOrdenesJPanel = new javax.swing.JPanel();
        crearOrdenButton = new javax.swing.JButton();
        consultarOrdenButton = new javax.swing.JButton();
        vendedorJFrame = new javax.swing.JFrame();
        vendedorJPanel = new javax.swing.JPanel();
        manejoOrdenesJPanel1 = new javax.swing.JPanel();
        crearCotizacionButton = new javax.swing.JButton();
        consultarCotizacionButton = new javax.swing.JButton();
        manejoOrdenesJPanel2 = new javax.swing.JPanel();
        venderButton = new javax.swing.JButton();
        panelContenedorVendedor = new javax.swing.JPanel();
        panelBanner4 = new javax.swing.JPanel();
        nombreUserLabel4 = new javax.swing.JLabel();
        sedeCargoLabel4 = new javax.swing.JLabel();
        logoLabel4 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        salirLabel2 = new javax.swing.JLabel();
        frameOpcionesReporte = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        mesOpcionesReportes = new javax.swing.JTextField();
        sedesOpcionesReportes = new javax.swing.JRadioButton();
        yearOpcionesReportes = new javax.swing.JTextField();
        empresaOpcionesReportes = new javax.swing.JRadioButton();
        generarReporteOpcionesButon = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        sedesOpcionesReporte = new javax.swing.JComboBox();
        semanalOpcionesReportes = new javax.swing.JRadioButton();
        todoOpcionesReportes = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        diaOpcionesReportes = new javax.swing.JTextField();
        ingresarUsuarioFrame = new javax.swing.JFrame();
        panelContIngresarUsuario = new javax.swing.JPanel();
        direccionIngresarCliente = new javax.swing.JTextField();
        emailIngresarCliente = new javax.swing.JTextField();
        telefonoIngresarCliente = new javax.swing.JTextField();
        ingresarUsuarioBoton = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        cedulaIngresarCliente = new javax.swing.JTextField();
        nombreIngresarCliente = new javax.swing.JTextField();
        cancelarIngresarUsuario = new javax.swing.JButton();
        panelCrearUsuario = new javax.swing.JPanel();
        confirmarCrearUsuarioB = new javax.swing.JButton();
        botonCancelarCrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id_usuarioCrear = new javax.swing.JTextField();
        passwordCrear = new javax.swing.JTextField();
        nombresCrear = new javax.swing.JTextField();
        apellidosCrear = new javax.swing.JTextField();
        CrearUsuarioSedesCB = new javax.swing.JComboBox<String>();
        tipoUsuarioCB = new javax.swing.JComboBox<String>();
        jLabel75 = new javax.swing.JLabel();
        emailUsuarioCrearTF = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        telefonoUsuarioCrearTF = new javax.swing.JTextField();
        panelModificarUsuario = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        modificarCodigoUsuarioTF = new javax.swing.JTextField();
        modificarNombreTF = new javax.swing.JTextField();
        modificarActivoRB = new javax.swing.JRadioButton();
        modificarInactivoRB = new javax.swing.JRadioButton();
        modificarTipoUsuarioCB = new javax.swing.JComboBox<String>();
        modificarSedeUsuarioCB = new javax.swing.JComboBox<String>();
        confirmarModificarUsuarioB = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        emailUsuarioModificarTF = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        telefonoUsuarioModificarTF = new javax.swing.JTextField();
        modificarConfirmarContraseñaTF = new javax.swing.JPasswordField();
        modificarContraseñaTF = new javax.swing.JPasswordField();
        cancelarModUsuario = new javax.swing.JButton();
        panelCrearSede = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        codigoSedeTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nombreSedeTF = new javax.swing.JTextField();
        confirmarCrearSede = new javax.swing.JButton();
        direccionSedeCrearTF = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        telefonoSedeCrearTF = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        emailSedeCrearTF = new javax.swing.JTextField();
        cancelarCrearSede = new javax.swing.JButton();
        panelModificarSede = new javax.swing.JPanel();
        modificarSedeSedesCB = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        nuevoNombreTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        confirmarModificarSede = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        direccionSedeModificarTF = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        telefonoSedeModificarTF = new javax.swing.JTextField();
        emailSedeModificarTF = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        cancelarModSede = new javax.swing.JButton();
        panelAgregarVehiculos = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        crearMarcaVehiculoTF = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        crearModeloVehiculoTF = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        crearColorVehiculoTF = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        crearVehiculoNuevoRB = new javax.swing.JRadioButton();
        crearVehiculoUsadoRB = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        crearCantidadVehiculoTF = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        crearSedeVehiculoCB = new javax.swing.JComboBox<String>();
        confirmarAgregarVehiculoB = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        crearValorVehiculoTF = new javax.swing.JTextField();
        cancelarAgregarVehiculo = new javax.swing.JButton();
        panelAgregarPartes = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        crearValorParteTF = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        crearNombreParteTF = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        crearCantidadPartesTF = new javax.swing.JTextField();
        confirmarCrearParteB = new javax.swing.JButton();
        crearParteSedeCB = new javax.swing.JComboBox<String>();
        cancelarAgregarParte = new javax.swing.JButton();
        panelModificarPartes = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        modificarNombreParteTF = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        modificarCantidadPartesTF = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        confirmarModificarParteB = new javax.swing.JButton();
        modificarParteSedeCB = new javax.swing.JComboBox<String>();
        jLabel55 = new javax.swing.JLabel();
        modificarValorParteTF = new javax.swing.JTextField();
        parteModificarCB = new javax.swing.JComboBox<String>();
        modificarParteID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cancelarModParte = new javax.swing.JButton();
        panelGenerarReportes = new javax.swing.JPanel();
        reporteUsuariosPanel = new javax.swing.JPanel();
        reportePersonal = new javax.swing.JButton();
        inventarioReportesPanel = new javax.swing.JPanel();
        vehiculosPorSedeBoton = new javax.swing.JButton();
        vehiculosAgregadosReporteBoton = new javax.swing.JButton();
        reporteVentasPanel = new javax.swing.JPanel();
        ventasReporteBoton = new javax.swing.JButton();
        aportePorSedeReportesBoton = new javax.swing.JButton();
        cotizacionesReportePanel = new javax.swing.JPanel();
        cotizacionesReporteBoton = new javax.swing.JButton();
        ordenesReportePanel = new javax.swing.JPanel();
        ordenesReporteBoton = new javax.swing.JButton();
        panelModificarVehiculo = new javax.swing.JPanel();
        modificarSedeVehiculoCB = new javax.swing.JComboBox<String>();
        jLabel27 = new javax.swing.JLabel();
        modificarVehiculoNuevoRB = new javax.swing.JRadioButton();
        modificarVehiculoUsadoRB = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        modificarCodigoVehiculoTF = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        modificarMarcaVehiculoTF = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        modificarModeloVehiculoTF = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        modificarColorVehiculoTF = new javax.swing.JTextField();
        confirmarModificarVehiculoB = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        modificarValorVehiculoTF = new javax.swing.JTextField();
        cancelarModVehiculo = new javax.swing.JButton();
        panelCrearOrden = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        codOrdenCrearOrdenTF = new javax.swing.JTextField();
        codVehiculoCrearOrdenTF = new javax.swing.JTextField();
        codParteCrearOrdenTF = new javax.swing.JTextField();
        codJefeTallerCrearOrdenTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumenCrearOrdenTA = new javax.swing.JTextArea();
        botonCrearOrden = new javax.swing.JButton();
        cancelarCrearOrden = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        panelConsultarOrden = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        codOrdenConsultarOrdenTF = new javax.swing.JTextField();
        aceptarConsultarOrden = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        vehiculoConsultarOrden = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        parteConsultarOrden = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descripcionConsultarOrden = new javax.swing.JTextArea();
        labelCantidadConsultarOrden = new javax.swing.JLabel();
        panelCrearCotizacion = new javax.swing.JPanel();
        cancelarCrearCot = new javax.swing.JButton();
        crearCotizacion = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        codVendedorCrearCot = new javax.swing.JTextField();
        codCompradorCrearCot = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        codVehiculoCrearCot = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        vehiculosDispCrearCot = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCrearCot = new javax.swing.JTable();
        panelConsultarCotizacion = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        codCotConsultarCot = new javax.swing.JTextField();
        aceptarConsultarCot = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        codVendedorConsultarCot = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        codCompradorConsultarCot = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        codVehiculoConsultarCot = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        valorTotalConsultarCot = new javax.swing.JLabel();
        panelVender = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        codCotVender = new javax.swing.JTextField();
        codVentaVender = new javax.swing.JTextField();
        codVendedorVender = new javax.swing.JTextField();
        codCompradorVender = new javax.swing.JTextField();
        codVehiculoVender = new javax.swing.JTextField();
        ventaCrearVentaButton = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        vehiculosDispVender = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCrearCot1 = new javax.swing.JTable();
        venderBuscarCotButton = new javax.swing.JButton();
        cancelarVender = new javax.swing.JButton();
        panelConsultas = new javax.swing.JPanel();
        panelReporteFinal = new javax.swing.JPanel();
        panelReporte = new javax.swing.JPanel();
        exportarButton = new javax.swing.JButton();
        panelVacio = new javax.swing.JPanel();
        panelVacio1 = new javax.swing.JPanel();
        panelVacio2 = new javax.swing.JPanel();
        manejoVehiculos = new javax.swing.JPanel();
        agregarVehiculosButton = new javax.swing.JButton();
        modificarVehiculos = new javax.swing.JButton();
        manejoPartes = new javax.swing.JPanel();
        agregarPartes = new javax.swing.JButton();
        modificarPartes = new javax.swing.JButton();
        panelGestion = new javax.swing.JPanel();
        gestionVehiculos = new javax.swing.JButton();
        gestionPartes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanelCampos = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        tfLogin = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();

        gerenteJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        gerenteJFrame.setTitle("ABC Corp. - Gerente");
        gerenteJFrame.setBackground(new java.awt.Color(255, 255, 255));
        gerenteJFrame.setLocation(new java.awt.Point(300, 100));
        gerenteJFrame.setMinimumSize(new java.awt.Dimension(1015, 756));
        gerenteJFrame.setResizable(false);
        gerenteJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                gerenteJFrameWindowClosing(evt);
            }
        });

        gerenteJPanel.setBackground(new java.awt.Color(255, 255, 255));
        gerenteJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        gerenteJPanel.setToolTipText("");
        gerenteJPanel.setAlignmentX(0.0F);
        gerenteJPanel.setAlignmentY(0.0F);
        gerenteJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gerenteJPanel.setFocusable(false);
        gerenteJPanel.setName(""); // NOI18N

        manejoUsuariosJPanel.setBackground(new java.awt.Color(255, 255, 255));
        manejoUsuariosJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        crearUsuarioButton.setBackground(new java.awt.Color(255, 255, 255));
        crearUsuarioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/crear.png"))); // NOI18N
        crearUsuarioButton.setBorder(null);
        crearUsuarioButton.setBorderPainted(false);
        crearUsuarioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        crearUsuarioButton.setMaximumSize(new java.awt.Dimension(160, 40));
        crearUsuarioButton.setMinimumSize(new java.awt.Dimension(160, 40));
        crearUsuarioButton.setPreferredSize(new java.awt.Dimension(160, 40));
        crearUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioButtonActionPerformed(evt);
            }
        });

        modificarUsuarioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/modificar.png"))); // NOI18N
        modificarUsuarioButton.setBorder(null);
        modificarUsuarioButton.setMaximumSize(new java.awt.Dimension(160, 40));
        modificarUsuarioButton.setMinimumSize(new java.awt.Dimension(160, 40));
        modificarUsuarioButton.setPreferredSize(new java.awt.Dimension(160, 40));
        modificarUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioButtonActionPerformed(evt);
            }
        });

        consultarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/consultar.png"))); // NOI18N
        consultarUsuarios.setBorder(null);
        consultarUsuarios.setMargin(new java.awt.Insets(0, 0, 0, 0));
        consultarUsuarios.setMaximumSize(new java.awt.Dimension(160, 40));
        consultarUsuarios.setMinimumSize(new java.awt.Dimension(160, 40));
        consultarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoUsuariosJPanelLayout = new javax.swing.GroupLayout(manejoUsuariosJPanel);
        manejoUsuariosJPanel.setLayout(manejoUsuariosJPanelLayout);
        manejoUsuariosJPanelLayout.setHorizontalGroup(
            manejoUsuariosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoUsuariosJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manejoUsuariosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consultarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(modificarUsuarioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearUsuarioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        manejoUsuariosJPanelLayout.setVerticalGroup(
            manejoUsuariosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoUsuariosJPanelLayout.createSequentialGroup()
                .addComponent(crearUsuarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarUsuarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manejoSedesJPanel.setBackground(new java.awt.Color(255, 255, 255));
        manejoSedesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sedes"));

        crearSedeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/crear.png"))); // NOI18N
        crearSedeButton.setBorder(null);
        crearSedeButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        crearSedeButton.setMaximumSize(new java.awt.Dimension(160, 40));
        crearSedeButton.setMinimumSize(new java.awt.Dimension(160, 40));
        crearSedeButton.setPreferredSize(new java.awt.Dimension(160, 40));
        crearSedeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearSedeButtonActionPerformed(evt);
            }
        });

        modificarSedeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/modificar.png"))); // NOI18N
        modificarSedeButton.setBorder(null);
        modificarSedeButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        modificarSedeButton.setMaximumSize(new java.awt.Dimension(160, 40));
        modificarSedeButton.setMinimumSize(new java.awt.Dimension(160, 40));
        modificarSedeButton.setPreferredSize(new java.awt.Dimension(160, 40));
        modificarSedeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarSedeButtonActionPerformed(evt);
            }
        });

        consultarSedes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/consultar.png"))); // NOI18N
        consultarSedes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        consultarSedes.setMaximumSize(new java.awt.Dimension(160, 40));
        consultarSedes.setMinimumSize(new java.awt.Dimension(160, 40));
        consultarSedes.setPreferredSize(new java.awt.Dimension(160, 40));
        consultarSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarSedesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoSedesJPanelLayout = new javax.swing.GroupLayout(manejoSedesJPanel);
        manejoSedesJPanel.setLayout(manejoSedesJPanelLayout);
        manejoSedesJPanelLayout.setHorizontalGroup(
            manejoSedesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoSedesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manejoSedesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(consultarSedes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarSedeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearSedeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manejoSedesJPanelLayout.setVerticalGroup(
            manejoSedesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoSedesJPanelLayout.createSequentialGroup()
                .addComponent(crearSedeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarSedeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarSedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manejoReportesJPanel.setBackground(new java.awt.Color(255, 255, 255));
        manejoReportesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Reportes"));

        generarReporteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reportes.png"))); // NOI18N
        generarReporteButton.setBorder(null);
        generarReporteButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        generarReporteButton.setMaximumSize(new java.awt.Dimension(160, 40));
        generarReporteButton.setMinimumSize(new java.awt.Dimension(160, 40));
        generarReporteButton.setPreferredSize(new java.awt.Dimension(160, 40));
        generarReporteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoReportesJPanelLayout = new javax.swing.GroupLayout(manejoReportesJPanel);
        manejoReportesJPanel.setLayout(manejoReportesJPanelLayout);
        manejoReportesJPanelLayout.setHorizontalGroup(
            manejoReportesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoReportesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generarReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manejoReportesJPanelLayout.setVerticalGroup(
            manejoReportesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoReportesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generarReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout gerenteJPanelLayout = new javax.swing.GroupLayout(gerenteJPanel);
        gerenteJPanel.setLayout(gerenteJPanelLayout);
        gerenteJPanelLayout.setHorizontalGroup(
            gerenteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gerenteJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gerenteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gerenteJPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(manejoUsuariosJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(manejoReportesJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manejoSedesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        gerenteJPanelLayout.setVerticalGroup(
            gerenteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gerenteJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manejoUsuariosJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manejoSedesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manejoReportesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBanner.setBackground(new java.awt.Color(67, 165, 208));
        panelBanner.setMaximumSize(new java.awt.Dimension(791, 150));
        panelBanner.setMinimumSize(new java.awt.Dimension(791, 150));

        nombreUserLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreUserLabel.setText("Juan David Suaza Cruz");

        sedeCargoLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sedeCargoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sedeCargoLabel.setText("Gerente - Londres");

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/logo.png"))); // NOI18N

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/default-user.png"))); // NOI18N

        salirLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salirLabel.setForeground(new java.awt.Color(255, 255, 255));
        salirLabel.setText("Salir");
        salirLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                .addGroup(panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salirLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreUserLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sedeCargoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel83)
                .addGap(18, 18, 18))
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel)
                    .addComponent(jLabel83)
                    .addGroup(panelBannerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(nombreUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sedeCargoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salirLabel)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedor.setMaximumSize(new java.awt.Dimension(780, 813));
        panelContenedor.setMinimumSize(new java.awt.Dimension(780, 813));
        panelContenedor.setName(""); // NOI18N

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout gerenteJFrameLayout = new javax.swing.GroupLayout(gerenteJFrame.getContentPane());
        gerenteJFrame.getContentPane().setLayout(gerenteJFrameLayout);
        gerenteJFrameLayout.setHorizontalGroup(
            gerenteJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gerenteJFrameLayout.createSequentialGroup()
                .addComponent(gerenteJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        gerenteJFrameLayout.setVerticalGroup(
            gerenteJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gerenteJFrameLayout.createSequentialGroup()
                .addComponent(panelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gerenteJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gerenteJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 623, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jefeJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jefeJFrame.setTitle("ABC Corp. - Jefe de Taller");
        jefeJFrame.setBackground(new java.awt.Color(255, 255, 255));
        jefeJFrame.setLocation(new java.awt.Point(300, 100));
        jefeJFrame.setMinimumSize(new java.awt.Dimension(830, 715));
        jefeJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jefeJFrameWindowClosing(evt);
            }
        });

        panelContenedorJefe.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedorJefe.setMaximumSize(new java.awt.Dimension(617, 579));
        panelContenedorJefe.setMinimumSize(new java.awt.Dimension(617, 579));
        panelContenedorJefe.setPreferredSize(new java.awt.Dimension(617, 579));

        javax.swing.GroupLayout panelContenedorJefeLayout = new javax.swing.GroupLayout(panelContenedorJefe);
        panelContenedorJefe.setLayout(panelContenedorJefeLayout);
        panelContenedorJefeLayout.setHorizontalGroup(
            panelContenedorJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContenedorJefeLayout.setVerticalGroup(
            panelContenedorJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBanner3.setBackground(new java.awt.Color(67, 165, 208));
        panelBanner3.setMaximumSize(new java.awt.Dimension(791, 150));
        panelBanner3.setMinimumSize(new java.awt.Dimension(791, 150));

        nombreUserLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreUserLabel3.setForeground(new java.awt.Color(255, 255, 255));
        nombreUserLabel3.setText("Juan David Suaza Cruz");

        sedeCargoLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sedeCargoLabel3.setForeground(new java.awt.Color(255, 255, 255));
        sedeCargoLabel3.setText("Gerente - Londres");

        logoLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/logo.png"))); // NOI18N

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/default-user.png"))); // NOI18N

        salirLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salirLabel1.setForeground(new java.awt.Color(255, 255, 255));
        salirLabel1.setText("Salir");
        salirLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBanner3Layout = new javax.swing.GroupLayout(panelBanner3);
        panelBanner3.setLayout(panelBanner3Layout);
        panelBanner3Layout.setHorizontalGroup(
            panelBanner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBanner3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                .addGroup(panelBanner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sedeCargoLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreUserLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salirLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel84)
                .addContainerGap())
        );
        panelBanner3Layout.setVerticalGroup(
            panelBanner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanner3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBanner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel3)
                    .addGroup(panelBanner3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelBanner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84)
                            .addGroup(panelBanner3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(nombreUserLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sedeCargoLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salirLabel1)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        manejoOrdenesJPanel.setBackground(new java.awt.Color(255, 255, 255));
        manejoOrdenesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenes de trabajo"));

        crearOrdenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/crear.png"))); // NOI18N
        crearOrdenButton.setBorder(null);
        crearOrdenButton.setMaximumSize(new java.awt.Dimension(160, 40));
        crearOrdenButton.setMinimumSize(new java.awt.Dimension(160, 40));
        crearOrdenButton.setPreferredSize(new java.awt.Dimension(160, 40));
        crearOrdenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearOrdenButtonActionPerformed(evt);
            }
        });

        consultarOrdenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/consultar.png"))); // NOI18N
        consultarOrdenButton.setBorder(null);
        consultarOrdenButton.setMaximumSize(new java.awt.Dimension(160, 40));
        consultarOrdenButton.setMinimumSize(new java.awt.Dimension(160, 40));
        consultarOrdenButton.setPreferredSize(new java.awt.Dimension(160, 40));
        consultarOrdenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarOrdenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoOrdenesJPanelLayout = new javax.swing.GroupLayout(manejoOrdenesJPanel);
        manejoOrdenesJPanel.setLayout(manejoOrdenesJPanelLayout);
        manejoOrdenesJPanelLayout.setHorizontalGroup(
            manejoOrdenesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoOrdenesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manejoOrdenesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crearOrdenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarOrdenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        manejoOrdenesJPanelLayout.setVerticalGroup(
            manejoOrdenesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoOrdenesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crearOrdenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarOrdenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(459, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jefeJFrameLayout = new javax.swing.GroupLayout(jefeJFrame.getContentPane());
        jefeJFrame.getContentPane().setLayout(jefeJFrameLayout);
        jefeJFrameLayout.setHorizontalGroup(
            jefeJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jefeJFrameLayout.createSequentialGroup()
                .addComponent(manejoOrdenesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedorJefe, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
            .addComponent(panelBanner3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jefeJFrameLayout.setVerticalGroup(
            jefeJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jefeJFrameLayout.createSequentialGroup()
                .addComponent(panelBanner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jefeJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelContenedorJefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manejoOrdenesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        vendedorJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        vendedorJFrame.setTitle("ABC Corp. - Vendedor");
        vendedorJFrame.setBackground(new java.awt.Color(255, 255, 255));
        vendedorJFrame.setLocation(new java.awt.Point(300, 100));
        vendedorJFrame.setMinimumSize(new java.awt.Dimension(900, 832));
        vendedorJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                vendedorJFrameWindowClosing(evt);
            }
        });

        vendedorJPanel.setBackground(new java.awt.Color(255, 255, 255));

        manejoOrdenesJPanel1.setBackground(new java.awt.Color(255, 255, 255));
        manejoOrdenesJPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cotizaciones"));

        crearCotizacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/crear.png"))); // NOI18N
        crearCotizacionButton.setBorder(null);
        crearCotizacionButton.setMaximumSize(new java.awt.Dimension(160, 40));
        crearCotizacionButton.setMinimumSize(new java.awt.Dimension(160, 40));
        crearCotizacionButton.setPreferredSize(new java.awt.Dimension(160, 40));
        crearCotizacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCotizacionButtonActionPerformed(evt);
            }
        });

        consultarCotizacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/consultar.png"))); // NOI18N
        consultarCotizacionButton.setBorder(null);
        consultarCotizacionButton.setMaximumSize(new java.awt.Dimension(160, 40));
        consultarCotizacionButton.setMinimumSize(new java.awt.Dimension(160, 40));
        consultarCotizacionButton.setPreferredSize(new java.awt.Dimension(160, 40));
        consultarCotizacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCotizacionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoOrdenesJPanel1Layout = new javax.swing.GroupLayout(manejoOrdenesJPanel1);
        manejoOrdenesJPanel1.setLayout(manejoOrdenesJPanel1Layout);
        manejoOrdenesJPanel1Layout.setHorizontalGroup(
            manejoOrdenesJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoOrdenesJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manejoOrdenesJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consultarCotizacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearCotizacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manejoOrdenesJPanel1Layout.setVerticalGroup(
            manejoOrdenesJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoOrdenesJPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crearCotizacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarCotizacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        manejoOrdenesJPanel2.setBackground(new java.awt.Color(255, 255, 255));
        manejoOrdenesJPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas"));

        venderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/vender.png"))); // NOI18N
        venderButton.setBorder(null);
        venderButton.setMaximumSize(new java.awt.Dimension(160, 40));
        venderButton.setMinimumSize(new java.awt.Dimension(160, 40));
        venderButton.setPreferredSize(new java.awt.Dimension(160, 40));
        venderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoOrdenesJPanel2Layout = new javax.swing.GroupLayout(manejoOrdenesJPanel2);
        manejoOrdenesJPanel2.setLayout(manejoOrdenesJPanel2Layout);
        manejoOrdenesJPanel2Layout.setHorizontalGroup(
            manejoOrdenesJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manejoOrdenesJPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(venderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        manejoOrdenesJPanel2Layout.setVerticalGroup(
            manejoOrdenesJPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoOrdenesJPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(venderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout vendedorJPanelLayout = new javax.swing.GroupLayout(vendedorJPanel);
        vendedorJPanel.setLayout(vendedorJPanelLayout);
        vendedorJPanelLayout.setHorizontalGroup(
            vendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vendedorJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manejoOrdenesJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manejoOrdenesJPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        vendedorJPanelLayout.setVerticalGroup(
            vendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendedorJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manejoOrdenesJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manejoOrdenesJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
        );

        panelContenedorVendedor.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedorVendedor.setMaximumSize(new java.awt.Dimension(617, 579));
        panelContenedorVendedor.setMinimumSize(new java.awt.Dimension(617, 579));
        panelContenedorVendedor.setPreferredSize(new java.awt.Dimension(617, 579));

        javax.swing.GroupLayout panelContenedorVendedorLayout = new javax.swing.GroupLayout(panelContenedorVendedor);
        panelContenedorVendedor.setLayout(panelContenedorVendedorLayout);
        panelContenedorVendedorLayout.setHorizontalGroup(
            panelContenedorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContenedorVendedorLayout.setVerticalGroup(
            panelContenedorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBanner4.setBackground(new java.awt.Color(67, 165, 208));
        panelBanner4.setMaximumSize(new java.awt.Dimension(791, 150));
        panelBanner4.setMinimumSize(new java.awt.Dimension(791, 150));

        nombreUserLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreUserLabel4.setForeground(new java.awt.Color(255, 255, 255));
        nombreUserLabel4.setText("Nombre del empleado");

        sedeCargoLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sedeCargoLabel4.setForeground(new java.awt.Color(255, 255, 255));
        sedeCargoLabel4.setText("Cargo - Sede");

        logoLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/logo.png"))); // NOI18N

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/default-user.png"))); // NOI18N

        salirLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salirLabel2.setForeground(new java.awt.Color(255, 255, 255));
        salirLabel2.setText("Salir");
        salirLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBanner4Layout = new javax.swing.GroupLayout(panelBanner4);
        panelBanner4.setLayout(panelBanner4Layout);
        panelBanner4Layout.setHorizontalGroup(
            panelBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBanner4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 538, Short.MAX_VALUE)
                .addGroup(panelBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sedeCargoLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreUserLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salirLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel85)
                .addContainerGap())
        );
        panelBanner4Layout.setVerticalGroup(
            panelBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanner4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel4)
                    .addGroup(panelBanner4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addGroup(panelBanner4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(nombreUserLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sedeCargoLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salirLabel2)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout vendedorJFrameLayout = new javax.swing.GroupLayout(vendedorJFrame.getContentPane());
        vendedorJFrame.getContentPane().setLayout(vendedorJFrameLayout);
        vendedorJFrameLayout.setHorizontalGroup(
            vendedorJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendedorJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vendedorJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedorVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE))
            .addComponent(panelBanner4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vendedorJFrameLayout.setVerticalGroup(
            vendedorJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vendedorJFrameLayout.createSequentialGroup()
                .addComponent(panelBanner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vendedorJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vendedorJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedorVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                .addContainerGap())
        );

        frameOpcionesReporte.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameOpcionesReporte.setTitle("ABC Corp. - Reportes");
        frameOpcionesReporte.setLocation(new java.awt.Point(500, 300));
        frameOpcionesReporte.setMinimumSize(new java.awt.Dimension(300, 300));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setText("Opciones:");

        sedesOpcionesReportes.setBackground(new java.awt.Color(255, 255, 255));
        sedesOpcionesReportes.setText("Sede");
        sedesOpcionesReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sedesOpcionesReportesActionPerformed(evt);
            }
        });

        empresaOpcionesReportes.setBackground(new java.awt.Color(255, 255, 255));
        empresaOpcionesReportes.setText("Empresa");

        generarReporteOpcionesButon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        generarReporteOpcionesButon.setBorder(null);
        generarReporteOpcionesButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteOpcionesButonActionPerformed(evt);
            }
        });

        jLabel31.setText("Sedes:");

        semanalOpcionesReportes.setBackground(new java.awt.Color(255, 255, 255));
        semanalOpcionesReportes.setText("Semanal");
        semanalOpcionesReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semanalOpcionesReportesActionPerformed(evt);
            }
        });

        todoOpcionesReportes.setBackground(new java.awt.Color(255, 255, 255));
        todoOpcionesReportes.setText("Todos los tiempos");
        todoOpcionesReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoOpcionesReportesActionPerformed(evt);
            }
        });

        jLabel37.setText("Dia:");

        jLabel41.setText("Mes:");

        jLabel56.setText("Año:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(sedesOpcionesReportes)
                        .addGap(18, 18, 18)
                        .addComponent(empresaOpcionesReportes))
                    .addComponent(jLabel29)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sedesOpcionesReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semanalOpcionesReportes)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diaOpcionesReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(mesOpcionesReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearOpcionesReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(todoOpcionesReportes, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generarReporteOpcionesButon)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sedesOpcionesReportes)
                    .addComponent(empresaOpcionesReportes))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(sedesOpcionesReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semanalOpcionesReportes)
                    .addComponent(todoOpcionesReportes))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel56)
                    .addComponent(diaOpcionesReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesOpcionesReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearOpcionesReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addComponent(generarReporteOpcionesButon)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout frameOpcionesReporteLayout = new javax.swing.GroupLayout(frameOpcionesReporte.getContentPane());
        frameOpcionesReporte.getContentPane().setLayout(frameOpcionesReporteLayout);
        frameOpcionesReporteLayout.setHorizontalGroup(
            frameOpcionesReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        frameOpcionesReporteLayout.setVerticalGroup(
            frameOpcionesReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ingresarUsuarioFrame.setTitle("ABC Corp. - Registrar Cliente");
        ingresarUsuarioFrame.setBackground(new java.awt.Color(255, 255, 255));
        ingresarUsuarioFrame.setLocation(new java.awt.Point(500, 300));
        ingresarUsuarioFrame.setMinimumSize(new java.awt.Dimension(282, 329));

        panelContIngresarUsuario.setBackground(new java.awt.Color(255, 255, 255));

        ingresarUsuarioBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        ingresarUsuarioBoton.setBorder(null);
        ingresarUsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarUsuarioBotonActionPerformed(evt);
            }
        });

        jLabel67.setText("Cédula:");

        jLabel79.setText("Nombre:");

        jLabel80.setText("Dirección:");

        jLabel81.setText("E-mail:");

        jLabel82.setText("Teléfono:");

        cancelarIngresarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarIngresarUsuario.setBorder(null);

        javax.swing.GroupLayout panelContIngresarUsuarioLayout = new javax.swing.GroupLayout(panelContIngresarUsuario);
        panelContIngresarUsuario.setLayout(panelContIngresarUsuarioLayout);
        panelContIngresarUsuarioLayout.setHorizontalGroup(
            panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContIngresarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelContIngresarUsuarioLayout.createSequentialGroup()
                        .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jLabel81)
                            .addComponent(jLabel80)
                            .addComponent(jLabel79)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreIngresarCliente)
                            .addComponent(direccionIngresarCliente)
                            .addComponent(emailIngresarCliente)
                            .addComponent(telefonoIngresarCliente)
                            .addComponent(cedulaIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContIngresarUsuarioLayout.createSequentialGroup()
                        .addComponent(ingresarUsuarioBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarIngresarUsuario)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        panelContIngresarUsuarioLayout.setVerticalGroup(
            panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContIngresarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addGap(18, 18, 18)
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addGap(18, 18, 18)
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addGap(18, 18, 18)
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addGap(18, 18, 18)
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelContIngresarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelarIngresarUsuario)
                    .addComponent(ingresarUsuarioBoton))
                .addGap(141, 141, 141))
        );

        javax.swing.GroupLayout ingresarUsuarioFrameLayout = new javax.swing.GroupLayout(ingresarUsuarioFrame.getContentPane());
        ingresarUsuarioFrame.getContentPane().setLayout(ingresarUsuarioFrameLayout);
        ingresarUsuarioFrameLayout.setHorizontalGroup(
            ingresarUsuarioFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContIngresarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ingresarUsuarioFrameLayout.setVerticalGroup(
            ingresarUsuarioFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContIngresarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelCrearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelCrearUsuario.setMaximumSize(new java.awt.Dimension(617, 579));
        panelCrearUsuario.setMinimumSize(new java.awt.Dimension(617, 579));
        panelCrearUsuario.setPreferredSize(new java.awt.Dimension(617, 579));

        confirmarCrearUsuarioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarCrearUsuarioB.setBorder(null);
        confirmarCrearUsuarioB.setMaximumSize(new java.awt.Dimension(160, 40));
        confirmarCrearUsuarioB.setMinimumSize(new java.awt.Dimension(160, 40));
        confirmarCrearUsuarioB.setPreferredSize(new java.awt.Dimension(160, 40));
        confirmarCrearUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarCrearUsuarioBActionPerformed(evt);
            }
        });

        botonCancelarCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        botonCancelarCrear.setBorder(null);
        botonCancelarCrear.setMaximumSize(new java.awt.Dimension(160, 40));
        botonCancelarCrear.setMinimumSize(new java.awt.Dimension(160, 40));
        botonCancelarCrear.setPreferredSize(new java.awt.Dimension(160, 40));
        botonCancelarCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarCrearActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de usuario:");

        jLabel2.setText("Codigo de usuario:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Nombre(s):");

        jLabel5.setText("Apellidos(s):");

        jLabel6.setText("Sede:");

        id_usuarioCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_usuarioCrearActionPerformed(evt);
            }
        });

        CrearUsuarioSedesCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CrearUsuarioSedesCBItemStateChanged(evt);
            }
        });

        tipoUsuarioCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerente", "Jefe de taller", "Vendedor" }));
        tipoUsuarioCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoUsuarioCBActionPerformed(evt);
            }
        });

        jLabel75.setText("Email:");

        jLabel76.setText("Telefono:");

        javax.swing.GroupLayout panelCrearUsuarioLayout = new javax.swing.GroupLayout(panelCrearUsuario);
        panelCrearUsuario.setLayout(panelCrearUsuarioLayout);
        panelCrearUsuarioLayout.setHorizontalGroup(
            panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76))
                        .addGap(51, 51, 51)
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_usuarioCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombresCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidosCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrearUsuarioSedesCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailUsuarioCrearTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoUsuarioCrearTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoUsuarioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addComponent(confirmarCrearUsuarioB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCancelarCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        panelCrearUsuarioLayout.setVerticalGroup(
            panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipoUsuarioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(id_usuarioCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(passwordCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(nombresCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(apellidosCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(CrearUsuarioSedesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(emailUsuarioCrearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefonoUsuarioCrearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addGap(18, 18, 18)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarCrearUsuarioB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelarCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        panelModificarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelModificarUsuario.setMaximumSize(new java.awt.Dimension(617, 579));
        panelModificarUsuario.setMinimumSize(new java.awt.Dimension(617, 579));
        panelModificarUsuario.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel11.setText("Identificación:");

        jLabel12.setText("Contraseña: ");

        jLabel13.setText("Confirmar Contraseña:");

        jLabel14.setText("Nombre:");

        jLabel16.setText("Estado:");

        jLabel17.setText("Tipo:");

        jLabel18.setText("Sede:");

        modificarCodigoUsuarioTF.setMaximumSize(new java.awt.Dimension(6, 20));

        modificarNombreTF.setMaximumSize(new java.awt.Dimension(6, 20));

        modificarActivoRB.setBackground(new java.awt.Color(255, 255, 255));
        modificarActivoRB.setText("Activo");

        modificarInactivoRB.setBackground(new java.awt.Color(255, 255, 255));
        modificarInactivoRB.setText("Inactivo");

        modificarTipoUsuarioCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vendedor", "Jefe de taller", "Gerente" }));
        modificarTipoUsuarioCB.setMaximumSize(new java.awt.Dimension(88, 20));

        modificarSedeUsuarioCB.setMaximumSize(new java.awt.Dimension(28, 20));

        confirmarModificarUsuarioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarModificarUsuarioB.setBorder(null);
        confirmarModificarUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarModificarUsuarioBActionPerformed(evt);
            }
        });

        jLabel77.setText("Email:");

        emailUsuarioModificarTF.setMaximumSize(new java.awt.Dimension(6, 20));

        jLabel78.setText("Telefono:");

        telefonoUsuarioModificarTF.setMaximumSize(new java.awt.Dimension(6, 20));

        modificarConfirmarContraseñaTF.setMaximumSize(new java.awt.Dimension(6, 20));

        modificarContraseñaTF.setMaximumSize(new java.awt.Dimension(6, 20));

        cancelarModUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarModUsuario.setBorder(null);
        cancelarModUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarModUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarUsuarioLayout = new javax.swing.GroupLayout(panelModificarUsuario);
        panelModificarUsuario.setLayout(panelModificarUsuarioLayout);
        panelModificarUsuarioLayout.setHorizontalGroup(
            panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                        .addComponent(confirmarModificarUsuarioB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarModUsuario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                        .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel78)
                            .addComponent(jLabel12)
                            .addComponent(jLabel77)
                            .addComponent(jLabel11))
                        .addGap(32, 32, 32)
                        .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(modificarNombreTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                                        .addComponent(modificarActivoRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modificarInactivoRB)
                                        .addGap(54, 54, 54))
                                    .addComponent(modificarContraseñaTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(modificarCodigoUsuarioTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modificarConfirmarContraseñaTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(modificarTipoUsuarioCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificarSedeUsuarioCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailUsuarioModificarTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefonoUsuarioModificarTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(270, 270, 270))))
        );
        panelModificarUsuarioLayout.setVerticalGroup(
            panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(modificarCodigoUsuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(modificarContraseñaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(modificarConfirmarContraseñaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(modificarNombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(modificarActivoRB)
                    .addComponent(modificarInactivoRB))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(modificarTipoUsuarioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(modificarSedeUsuarioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(emailUsuarioModificarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(telefonoUsuarioModificarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarModificarUsuarioB)
                    .addComponent(cancelarModUsuario))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        panelCrearSede.setBackground(new java.awt.Color(255, 255, 255));
        panelCrearSede.setMaximumSize(new java.awt.Dimension(617, 579));
        panelCrearSede.setMinimumSize(new java.awt.Dimension(617, 579));

        jLabel7.setText("Código de la sede:");

        codigoSedeTF.setEditable(false);

        jLabel8.setText("Nombre:");

        nombreSedeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreSedeTFActionPerformed(evt);
            }
        });

        confirmarCrearSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarCrearSede.setBorder(null);
        confirmarCrearSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarCrearSedeActionPerformed(evt);
            }
        });

        jLabel69.setText("Direccion:");

        jLabel70.setText("Telefono:");

        jLabel71.setText("Email:");

        cancelarCrearSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarCrearSede.setBorder(null);
        cancelarCrearSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearSedeLayout = new javax.swing.GroupLayout(panelCrearSede);
        panelCrearSede.setLayout(panelCrearSedeLayout);
        panelCrearSedeLayout.setHorizontalGroup(
            panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearSedeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCrearSedeLayout.createSequentialGroup()
                        .addComponent(confirmarCrearSede)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarCrearSede))
                    .addGroup(panelCrearSedeLayout.createSequentialGroup()
                        .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailSedeCrearTF, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(direccionSedeCrearTF)
                            .addComponent(nombreSedeTF)
                            .addComponent(codigoSedeTF)
                            .addComponent(telefonoSedeCrearTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                .addGap(274, 350, Short.MAX_VALUE))
        );
        panelCrearSedeLayout.setVerticalGroup(
            panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(codigoSedeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreSedeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionSedeCrearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(telefonoSedeCrearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(emailSedeCrearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmarCrearSede)
                    .addComponent(cancelarCrearSede))
                .addContainerGap(345, Short.MAX_VALUE))
        );

        panelModificarSede.setBackground(new java.awt.Color(255, 255, 255));
        panelModificarSede.setMaximumSize(new java.awt.Dimension(617, 579));
        panelModificarSede.setMinimumSize(new java.awt.Dimension(617, 579));
        panelModificarSede.setPreferredSize(new java.awt.Dimension(617, 579));

        modificarSedeSedesCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modificarSedeSedesCBItemStateChanged(evt);
            }
        });

        jLabel9.setText("Sede:");

        jLabel10.setText("Nombre:");

        confirmarModificarSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarModificarSede.setBorder(null);
        confirmarModificarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarModificarSedeActionPerformed(evt);
            }
        });

        jLabel72.setText("Dirección:");

        jLabel73.setText("Teléfono:");

        telefonoSedeModificarTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoSedeModificarTFActionPerformed(evt);
            }
        });

        jLabel74.setText("E-mail:");

        cancelarModSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarModSede.setBorder(null);
        cancelarModSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarModSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarSedeLayout = new javax.swing.GroupLayout(panelModificarSede);
        panelModificarSede.setLayout(panelModificarSedeLayout);
        panelModificarSedeLayout.setHorizontalGroup(
            panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addComponent(confirmarModificarSede)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarModSede)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(telefonoSedeModificarTF, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addComponent(nuevoNombreTF)
                                .addComponent(modificarSedeSedesCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(direccionSedeModificarTF))
                            .addComponent(emailSedeModificarTF, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(268, 268, 268))))
        );
        panelModificarSedeLayout.setVerticalGroup(
            panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarSedeSedesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoNombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(direccionSedeModificarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(telefonoSedeModificarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailSedeModificarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarModificarSede)
                    .addComponent(cancelarModSede))
                .addContainerGap(337, Short.MAX_VALUE))
        );

        panelAgregarVehiculos.setBackground(new java.awt.Color(255, 255, 255));
        panelAgregarVehiculos.setMaximumSize(new java.awt.Dimension(617, 579));
        panelAgregarVehiculos.setMinimumSize(new java.awt.Dimension(617, 579));

        jLabel20.setText("Marca Vehiculo: ");

        jLabel21.setText("Modelo Vehiculo:");

        jLabel22.setText("Color vehiculo:");

        jLabel23.setText("Nuevo:");

        crearVehiculoNuevoRB.setBackground(new java.awt.Color(255, 255, 255));
        crearVehiculoNuevoRB.setText("Nuevo");

        crearVehiculoUsadoRB.setBackground(new java.awt.Color(255, 255, 255));
        crearVehiculoUsadoRB.setText("Usado");

        jLabel25.setText("Cantidad Disponible:");

        jLabel26.setText("Sede:");

        confirmarAgregarVehiculoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarAgregarVehiculoB.setBorder(null);
        confirmarAgregarVehiculoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarAgregarVehiculoBActionPerformed(evt);
            }
        });

        jLabel51.setText("Valor del vehículo:");

        cancelarAgregarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarAgregarVehiculo.setBorder(null);
        cancelarAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAgregarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarVehiculosLayout = new javax.swing.GroupLayout(panelAgregarVehiculos);
        panelAgregarVehiculos.setLayout(panelAgregarVehiculosLayout);
        panelAgregarVehiculosLayout.setHorizontalGroup(
            panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                        .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel51))
                        .addGap(18, 18, 18)
                        .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crearValorVehiculoTF, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(crearCantidadVehiculoTF)))
                    .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(79, 79, 79)
                        .addComponent(crearVehiculoNuevoRB)
                        .addGap(10, 10, 10)
                        .addComponent(crearVehiculoUsadoRB))
                    .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(88, 88, 88)
                        .addComponent(crearSedeVehiculoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                        .addComponent(confirmarAgregarVehiculoB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarAgregarVehiculo))
                    .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                        .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(34, 34, 34)
                        .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(crearModeloVehiculoTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crearColorVehiculoTF)
                            .addComponent(crearMarcaVehiculoTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panelAgregarVehiculosLayout.setVerticalGroup(
            panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarVehiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(crearMarcaVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearModeloVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(crearColorVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(crearVehiculoNuevoRB)
                        .addComponent(crearVehiculoUsadoRB)))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(crearCantidadVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(crearValorVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(crearSedeVehiculoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarAgregarVehiculoB)
                    .addComponent(cancelarAgregarVehiculo))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        panelAgregarPartes.setBackground(new java.awt.Color(255, 255, 255));
        panelAgregarPartes.setMaximumSize(new java.awt.Dimension(617, 579));
        panelAgregarPartes.setMinimumSize(new java.awt.Dimension(617, 579));

        jLabel35.setText("Valor parte:");

        jLabel36.setText("Nombre parte:");

        jLabel38.setText("Cantidad Partes:");

        jLabel39.setText("Sede:");

        confirmarCrearParteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarCrearParteB.setBorder(null);
        confirmarCrearParteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarCrearParteBActionPerformed(evt);
            }
        });

        cancelarAgregarParte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarAgregarParte.setBorder(null);
        cancelarAgregarParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAgregarParteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarPartesLayout = new javax.swing.GroupLayout(panelAgregarPartes);
        panelAgregarPartes.setLayout(panelAgregarPartesLayout);
        panelAgregarPartesLayout.setHorizontalGroup(
            panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarPartesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarPartesLayout.createSequentialGroup()
                        .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(crearCantidadPartesTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(crearNombreParteTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crearValorParteTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crearParteSedeCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelAgregarPartesLayout.createSequentialGroup()
                        .addComponent(confirmarCrearParteB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarAgregarParte)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panelAgregarPartesLayout.setVerticalGroup(
            panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarPartesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(crearNombreParteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(crearCantidadPartesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(crearValorParteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(crearParteSedeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarCrearParteB)
                    .addComponent(cancelarAgregarParte))
                .addContainerGap(375, Short.MAX_VALUE))
        );

        panelModificarPartes.setBackground(new java.awt.Color(255, 255, 255));
        panelModificarPartes.setMaximumSize(new java.awt.Dimension(617, 579));
        panelModificarPartes.setMinimumSize(new java.awt.Dimension(617, 579));
        panelModificarPartes.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel40.setText("Nombre parte:");

        jLabel42.setText("Cantidad Partes:");

        jLabel43.setText("Sede:");

        jLabel44.setText("Parte:");

        confirmarModificarParteB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarModificarParteB.setBorder(null);
        confirmarModificarParteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarModificarParteBActionPerformed(evt);
            }
        });

        modificarParteSedeCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modificarParteSedeCBItemStateChanged(evt);
            }
        });

        jLabel55.setText("Valor parte:");

        parteModificarCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                parteModificarCBItemStateChanged(evt);
            }
        });

        modificarParteID.setEditable(false);
        modificarParteID.setEnabled(false);

        jLabel24.setText("ID parte:");

        cancelarModParte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarModParte.setBorder(null);
        cancelarModParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarModParteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarPartesLayout = new javax.swing.GroupLayout(panelModificarPartes);
        panelModificarPartes.setLayout(panelModificarPartesLayout);
        panelModificarPartesLayout.setHorizontalGroup(
            panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarPartesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarPartesLayout.createSequentialGroup()
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addComponent(jLabel24))
                        .addGap(33, 33, 33)
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(parteModificarCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 214, Short.MAX_VALUE)
                            .addComponent(modificarNombreParteTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarCantidadPartesTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarValorParteTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarParteID)
                            .addComponent(modificarParteSedeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel55)
                    .addGroup(panelModificarPartesLayout.createSequentialGroup()
                        .addComponent(confirmarModificarParteB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarModParte)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panelModificarPartesLayout.setVerticalGroup(
            panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarPartesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelModificarPartesLayout.createSequentialGroup()
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(modificarParteSedeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(parteModificarCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(modificarNombreParteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(modificarCantidadPartesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(modificarValorParteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(modificarParteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(panelModificarPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarModificarParteB)
                    .addComponent(cancelarModParte))
                .addContainerGap(299, Short.MAX_VALUE))
        );

        panelGenerarReportes.setBackground(new java.awt.Color(255, 255, 255));
        panelGenerarReportes.setMaximumSize(new java.awt.Dimension(617, 579));
        panelGenerarReportes.setMinimumSize(new java.awt.Dimension(617, 579));
        panelGenerarReportes.setPreferredSize(new java.awt.Dimension(617, 579));

        reporteUsuariosPanel.setBackground(new java.awt.Color(255, 255, 255));
        reporteUsuariosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        reportePersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reportePersonal.png"))); // NOI18N
        reportePersonal.setBorder(null);
        reportePersonal.setMaximumSize(new java.awt.Dimension(220, 40));
        reportePersonal.setMinimumSize(new java.awt.Dimension(220, 40));
        reportePersonal.setPreferredSize(new java.awt.Dimension(220, 40));
        reportePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportePersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reporteUsuariosPanelLayout = new javax.swing.GroupLayout(reporteUsuariosPanel);
        reporteUsuariosPanel.setLayout(reporteUsuariosPanelLayout);
        reporteUsuariosPanelLayout.setHorizontalGroup(
            reporteUsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reporteUsuariosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportePersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        reporteUsuariosPanelLayout.setVerticalGroup(
            reporteUsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reporteUsuariosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportePersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inventarioReportesPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventarioReportesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        vehiculosPorSedeBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reporteCantidadVehiculos.png"))); // NOI18N
        vehiculosPorSedeBoton.setToolTipText("");
        vehiculosPorSedeBoton.setBorder(null);
        vehiculosPorSedeBoton.setMaximumSize(new java.awt.Dimension(220, 40));
        vehiculosPorSedeBoton.setMinimumSize(new java.awt.Dimension(220, 40));
        vehiculosPorSedeBoton.setPreferredSize(new java.awt.Dimension(220, 40));
        vehiculosPorSedeBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculosPorSedeBotonActionPerformed(evt);
            }
        });

        vehiculosAgregadosReporteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reporteAdicionados.png"))); // NOI18N
        vehiculosAgregadosReporteBoton.setBorder(null);
        vehiculosAgregadosReporteBoton.setMaximumSize(new java.awt.Dimension(220, 40));
        vehiculosAgregadosReporteBoton.setMinimumSize(new java.awt.Dimension(220, 40));
        vehiculosAgregadosReporteBoton.setPreferredSize(new java.awt.Dimension(220, 40));
        vehiculosAgregadosReporteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculosAgregadosReporteBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inventarioReportesPanelLayout = new javax.swing.GroupLayout(inventarioReportesPanel);
        inventarioReportesPanel.setLayout(inventarioReportesPanelLayout);
        inventarioReportesPanelLayout.setHorizontalGroup(
            inventarioReportesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioReportesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventarioReportesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vehiculosPorSedeBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehiculosAgregadosReporteBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        inventarioReportesPanelLayout.setVerticalGroup(
            inventarioReportesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioReportesPanelLayout.createSequentialGroup()
                .addComponent(vehiculosPorSedeBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vehiculosAgregadosReporteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        reporteVentasPanel.setBackground(new java.awt.Color(255, 255, 255));
        reporteVentasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas"));

        ventasReporteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reporteVentas.png"))); // NOI18N
        ventasReporteBoton.setBorder(null);
        ventasReporteBoton.setMaximumSize(new java.awt.Dimension(220, 40));
        ventasReporteBoton.setMinimumSize(new java.awt.Dimension(220, 40));
        ventasReporteBoton.setPreferredSize(new java.awt.Dimension(220, 40));
        ventasReporteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasReporteBotonActionPerformed(evt);
            }
        });

        aportePorSedeReportesBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reporteAporteSedes.png"))); // NOI18N
        aportePorSedeReportesBoton.setBorder(null);
        aportePorSedeReportesBoton.setMaximumSize(new java.awt.Dimension(220, 40));
        aportePorSedeReportesBoton.setMinimumSize(new java.awt.Dimension(220, 40));
        aportePorSedeReportesBoton.setPreferredSize(new java.awt.Dimension(220, 40));
        aportePorSedeReportesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aportePorSedeReportesBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reporteVentasPanelLayout = new javax.swing.GroupLayout(reporteVentasPanel);
        reporteVentasPanel.setLayout(reporteVentasPanelLayout);
        reporteVentasPanelLayout.setHorizontalGroup(
            reporteVentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reporteVentasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reporteVentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ventasReporteBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aportePorSedeReportesBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        reporteVentasPanelLayout.setVerticalGroup(
            reporteVentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reporteVentasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ventasReporteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aportePorSedeReportesBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cotizacionesReportePanel.setBackground(new java.awt.Color(255, 255, 255));
        cotizacionesReportePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cotizaciones"));

        cotizacionesReporteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reporteCotizaciones.png"))); // NOI18N
        cotizacionesReporteBoton.setBorder(null);
        cotizacionesReporteBoton.setMaximumSize(new java.awt.Dimension(220, 40));
        cotizacionesReporteBoton.setMinimumSize(new java.awt.Dimension(220, 40));
        cotizacionesReporteBoton.setPreferredSize(new java.awt.Dimension(220, 40));
        cotizacionesReporteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cotizacionesReporteBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cotizacionesReportePanelLayout = new javax.swing.GroupLayout(cotizacionesReportePanel);
        cotizacionesReportePanel.setLayout(cotizacionesReportePanelLayout);
        cotizacionesReportePanelLayout.setHorizontalGroup(
            cotizacionesReportePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cotizacionesReportePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cotizacionesReporteBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        cotizacionesReportePanelLayout.setVerticalGroup(
            cotizacionesReportePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cotizacionesReportePanelLayout.createSequentialGroup()
                .addComponent(cotizacionesReporteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ordenesReportePanel.setBackground(new java.awt.Color(255, 255, 255));
        ordenesReportePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenes de trabajo"));

        ordenesReporteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/reporteOrdenes.png"))); // NOI18N
        ordenesReporteBoton.setBorder(null);
        ordenesReporteBoton.setMaximumSize(new java.awt.Dimension(220, 40));
        ordenesReporteBoton.setMinimumSize(new java.awt.Dimension(220, 40));
        ordenesReporteBoton.setPreferredSize(new java.awt.Dimension(220, 40));
        ordenesReporteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenesReporteBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ordenesReportePanelLayout = new javax.swing.GroupLayout(ordenesReportePanel);
        ordenesReportePanel.setLayout(ordenesReportePanelLayout);
        ordenesReportePanelLayout.setHorizontalGroup(
            ordenesReportePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordenesReportePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ordenesReporteBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ordenesReportePanelLayout.setVerticalGroup(
            ordenesReportePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordenesReportePanelLayout.createSequentialGroup()
                .addComponent(ordenesReporteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGenerarReportesLayout = new javax.swing.GroupLayout(panelGenerarReportes);
        panelGenerarReportes.setLayout(panelGenerarReportesLayout);
        panelGenerarReportesLayout.setHorizontalGroup(
            panelGenerarReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGenerarReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGenerarReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reporteUsuariosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventarioReportesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reporteVentasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cotizacionesReportePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ordenesReportePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        panelGenerarReportesLayout.setVerticalGroup(
            panelGenerarReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGenerarReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reporteUsuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventarioReportesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cotizacionesReportePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordenesReportePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reporteVentasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(6, Short.MAX_VALUE))
        );

        panelModificarVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        panelModificarVehiculo.setMaximumSize(new java.awt.Dimension(617, 579));
        panelModificarVehiculo.setMinimumSize(new java.awt.Dimension(617, 579));
        panelModificarVehiculo.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel27.setText("Nuevo:");

        modificarVehiculoNuevoRB.setBackground(new java.awt.Color(255, 255, 255));
        modificarVehiculoNuevoRB.setText("Nuevo");

        modificarVehiculoUsadoRB.setBackground(new java.awt.Color(255, 255, 255));
        modificarVehiculoUsadoRB.setText("Usado");

        jLabel28.setText("Codigo Vehiculo:");

        modificarCodigoVehiculoTF.setEditable(false);

        jLabel30.setText("Marca Vehiculo: ");

        jLabel32.setText("Modelo Vehiculo:");

        jLabel33.setText("Sede:");

        jLabel34.setText("Color vehiculo:");

        confirmarModificarVehiculoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        confirmarModificarVehiculoB.setBorder(null);
        confirmarModificarVehiculoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarModificarVehiculoBActionPerformed(evt);
            }
        });

        jLabel19.setText("Valor:");

        cancelarModVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarModVehiculo.setBorder(null);
        cancelarModVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarModVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarVehiculoLayout = new javax.swing.GroupLayout(panelModificarVehiculo);
        panelModificarVehiculo.setLayout(panelModificarVehiculoLayout);
        panelModificarVehiculoLayout.setHorizontalGroup(
            panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(33, 33, 33)
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                                .addComponent(modificarVehiculoNuevoRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modificarVehiculoUsadoRB))
                            .addComponent(modificarMarcaVehiculoTF, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(modificarModeloVehiculoTF)
                            .addComponent(modificarColorVehiculoTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modificarCodigoVehiculoTF)))
                    .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                        .addComponent(confirmarModificarVehiculoB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarModVehiculo))
                    .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel19))
                        .addGap(85, 85, 85)
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modificarValorVehiculoTF)
                            .addComponent(modificarSedeVehiculoCB, 0, 215, Short.MAX_VALUE))))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panelModificarVehiculoLayout.setVerticalGroup(
            panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(modificarCodigoVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(modificarMarcaVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(modificarModeloVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(modificarColorVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelModificarVehiculoLayout.createSequentialGroup()
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(modificarVehiculoNuevoRB)
                            .addComponent(modificarVehiculoUsadoRB))
                        .addGap(18, 18, 18)
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(modificarSedeVehiculoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(modificarValorVehiculoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmarModificarVehiculoB))
                    .addComponent(cancelarModVehiculo))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        panelCrearOrden.setBackground(new java.awt.Color(255, 255, 255));
        panelCrearOrden.setMaximumSize(new java.awt.Dimension(617, 579));
        panelCrearOrden.setMinimumSize(new java.awt.Dimension(617, 579));
        panelCrearOrden.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel45.setText("Código de la orden:");

        jLabel46.setText("Código de la parte:");

        jLabel47.setText("Código del jefe:");

        jLabel48.setText("Código del vehiculo:");

        jLabel49.setText("Resumen:");

        codOrdenCrearOrdenTF.setEditable(false);

        resumenCrearOrdenTA.setColumns(20);
        resumenCrearOrdenTA.setRows(5);
        jScrollPane1.setViewportView(resumenCrearOrdenTA);

        botonCrearOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        botonCrearOrden.setBorder(null);
        botonCrearOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearOrdenActionPerformed(evt);
            }
        });

        cancelarCrearOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarCrearOrden.setBorder(null);
        cancelarCrearOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCrearOrdenActionPerformed(evt);
            }
        });

        jLabel90.setText("Cantidad");

        javax.swing.GroupLayout panelCrearOrdenLayout = new javax.swing.GroupLayout(panelCrearOrden);
        panelCrearOrden.setLayout(panelCrearOrdenLayout);
        panelCrearOrdenLayout.setHorizontalGroup(
            panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearOrdenLayout.createSequentialGroup()
                        .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codJefeTallerCrearOrdenTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(codParteCrearOrdenTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codVehiculoCrearOrdenTF))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel90))
                    .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCrearOrdenLayout.createSequentialGroup()
                            .addComponent(jLabel45)
                            .addGap(18, 18, 18)
                            .addComponent(codOrdenCrearOrdenTF, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCrearOrdenLayout.createSequentialGroup()
                                .addComponent(botonCrearOrden)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelarCrearOrden))
                            .addGroup(panelCrearOrdenLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(66, 66, 66)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        panelCrearOrdenLayout.setVerticalGroup(
            panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(codOrdenCrearOrdenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(codVehiculoCrearOrdenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(codParteCrearOrdenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90)
                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(codJefeTallerCrearOrdenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelCrearOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCrearOrden)
                    .addComponent(cancelarCrearOrden))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        panelConsultarOrden.setBackground(new java.awt.Color(255, 255, 255));
        panelConsultarOrden.setMaximumSize(new java.awt.Dimension(617, 579));
        panelConsultarOrden.setMinimumSize(new java.awt.Dimension(617, 579));
        panelConsultarOrden.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel50.setText("Código de la orden:");

        aceptarConsultarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        aceptarConsultarOrden.setBorder(null);
        aceptarConsultarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarConsultarOrdenActionPerformed(evt);
            }
        });

        jLabel57.setText("Vehículo:");

        vehiculoConsultarOrden.setEditable(false);
        vehiculoConsultarOrden.setBackground(new java.awt.Color(255, 255, 255));

        jLabel65.setText("Parte:");

        parteConsultarOrden.setEditable(false);
        parteConsultarOrden.setBackground(new java.awt.Color(255, 255, 255));

        jLabel66.setText("Descripción:");

        descripcionConsultarOrden.setEditable(false);
        descripcionConsultarOrden.setColumns(20);
        descripcionConsultarOrden.setRows(5);
        jScrollPane4.setViewportView(descripcionConsultarOrden);

        labelCantidadConsultarOrden.setText("Cantidad: ");

        javax.swing.GroupLayout panelConsultarOrdenLayout = new javax.swing.GroupLayout(panelConsultarOrden);
        panelConsultarOrden.setLayout(panelConsultarOrdenLayout);
        panelConsultarOrdenLayout.setHorizontalGroup(
            panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarOrdenLayout.createSequentialGroup()
                        .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vehiculoConsultarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(codOrdenConsultarOrdenTF))
                        .addGap(20, 20, 20)
                        .addComponent(aceptarConsultarOrden))
                    .addGroup(panelConsultarOrdenLayout.createSequentialGroup()
                        .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addGap(54, 54, 54)
                        .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelConsultarOrdenLayout.createSequentialGroup()
                                .addComponent(parteConsultarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelCantidadConsultarOrden)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        panelConsultarOrdenLayout.setVerticalGroup(
            panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(codOrdenConsultarOrdenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarConsultarOrden))
                .addGap(16, 16, 16)
                .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(vehiculoConsultarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(parteConsultarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantidadConsultarOrden))
                .addGap(18, 18, 18)
                .addGroup(panelConsultarOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        panelCrearCotizacion.setBackground(new java.awt.Color(255, 255, 255));
        panelCrearCotizacion.setMaximumSize(new java.awt.Dimension(617, 579));
        panelCrearCotizacion.setMinimumSize(new java.awt.Dimension(617, 579));
        panelCrearCotizacion.setPreferredSize(new java.awt.Dimension(617, 579));

        cancelarCrearCot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarCrearCot.setBorder(null);

        crearCotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        crearCotizacion.setBorder(null);
        crearCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCotizacionActionPerformed(evt);
            }
        });

        jLabel52.setText("Codigo del vendedor:");

        jLabel53.setText("Codigo del comprador:");

        jLabel68.setText("Código del vehiculo:");

        codVehiculoCrearCot.setEnabled(false);

        jLabel54.setText("Marca del vehículo:");

        tableCrearCot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Marca", "Valor", "Modelo", "Estado"
            }
        ));
        tableCrearCot.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tableCrearCot);
        tableCrearCot.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout panelCrearCotizacionLayout = new javax.swing.GroupLayout(panelCrearCotizacion);
        panelCrearCotizacion.setLayout(panelCrearCotizacionLayout);
        panelCrearCotizacionLayout.setHorizontalGroup(
            panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                        .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vehiculosDispCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearCotizacionLayout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(codVehiculoCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(codCompradorCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(28, 28, 28)
                                .addComponent(codVendedorCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(crearCotizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarCrearCot))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCrearCotizacionLayout.setVerticalGroup(
            panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearCotizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(codVendedorCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(codCompradorCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(codVehiculoCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(vehiculosDispCrearCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crearCotizacion)
                    .addComponent(cancelarCrearCot))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        panelConsultarCotizacion.setBackground(new java.awt.Color(255, 255, 255));
        panelConsultarCotizacion.setMaximumSize(new java.awt.Dimension(617, 579));
        panelConsultarCotizacion.setMinimumSize(new java.awt.Dimension(617, 579));
        panelConsultarCotizacion.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel58.setText("Codigo de la cotización:");

        aceptarConsultarCot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        aceptarConsultarCot.setBorder(null);

        jLabel86.setText("Codigo del vendedor:");

        codVendedorConsultarCot.setEditable(false);
        codVendedorConsultarCot.setBackground(new java.awt.Color(255, 255, 255));

        jLabel87.setText("Codigo del comprador:");

        codCompradorConsultarCot.setEditable(false);
        codCompradorConsultarCot.setBackground(new java.awt.Color(255, 255, 255));

        jLabel88.setText("Vehiculo:");

        codVehiculoConsultarCot.setEditable(false);
        codVehiculoConsultarCot.setBackground(new java.awt.Color(255, 255, 255));

        jLabel89.setText("Valor total:");

        valorTotalConsultarCot.setText("Precio");

        javax.swing.GroupLayout panelConsultarCotizacionLayout = new javax.swing.GroupLayout(panelConsultarCotizacion);
        panelConsultarCotizacion.setLayout(panelConsultarCotizacionLayout);
        panelConsultarCotizacionLayout.setHorizontalGroup(
            panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarCotizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelConsultarCotizacionLayout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valorTotalConsultarCot))
                    .addGroup(panelConsultarCotizacionLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(codCotConsultarCot))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarCotizacionLayout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codVehiculoConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConsultarCotizacionLayout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codCompradorConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConsultarCotizacionLayout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(28, 28, 28)
                        .addComponent(codVendedorConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(aceptarConsultarCot)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        panelConsultarCotizacionLayout.setVerticalGroup(
            panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarCotizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel58)
                        .addComponent(codCotConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aceptarConsultarCot))
                .addGap(13, 13, 13)
                .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(codVendedorConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(codCompradorConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(codVehiculoConsultarCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(valorTotalConsultarCot))
                .addContainerGap(383, Short.MAX_VALUE))
        );

        panelVender.setBackground(new java.awt.Color(255, 255, 255));
        panelVender.setMaximumSize(new java.awt.Dimension(617, 579));
        panelVender.setMinimumSize(new java.awt.Dimension(617, 579));
        panelVender.setPreferredSize(new java.awt.Dimension(617, 579));

        jLabel59.setText("Código de la cotización:");

        jLabel60.setText("Código de la venta:");

        jLabel61.setText("Código del vendedor:");

        jLabel62.setText("Código del comprador:");

        jLabel63.setText("Código del vehiculo:");

        codCotVender.setForeground(new java.awt.Color(102, 102, 102));
        codCotVender.setText("(Opcional)");
        codCotVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codCotVenderActionPerformed(evt);
            }
        });

        ventaCrearVentaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        ventaCrearVentaButton.setBorder(null);
        ventaCrearVentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaCrearVentaButtonActionPerformed(evt);
            }
        });

        jLabel64.setText("Marcas disponibles:");

        vehiculosDispVender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vehiculosDispVenderItemStateChanged(evt);
            }
        });

        tableCrearCot1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Marca", "Valor", "Modelo", "Estado"
            }
        ));
        jScrollPane3.setViewportView(tableCrearCot1);
        tableCrearCot1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        venderBuscarCotButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/aceptar.png"))); // NOI18N
        venderBuscarCotButton.setBorder(null);
        venderBuscarCotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderBuscarCotButtonActionPerformed(evt);
            }
        });

        cancelarVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/cancelar.png"))); // NOI18N
        cancelarVender.setBorder(null);
        cancelarVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarVenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVenderLayout = new javax.swing.GroupLayout(panelVender);
        panelVender.setLayout(panelVenderLayout);
        panelVenderLayout.setHorizontalGroup(
            panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelVenderLayout.createSequentialGroup()
                        .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelVenderLayout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(vehiculosDispVender, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelVenderLayout.createSequentialGroup()
                                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel63))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(codCompradorVender, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codVendedorVender, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codVentaVender, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codCotVender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(codVehiculoVender))))
                        .addGap(18, 18, 18)
                        .addComponent(venderBuscarCotButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVenderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ventaCrearVentaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelarVender)
                .addContainerGap())
        );
        panelVenderLayout.setVerticalGroup(
            panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(codCotVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venderBuscarCotButton))
                .addGap(18, 18, 18)
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(codVentaVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(codVendedorVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(codCompradorVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(codVehiculoVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(vehiculosDispVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ventaCrearVentaButton)
                    .addComponent(cancelarVender))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelConsultas.setBackground(new java.awt.Color(255, 255, 255));
        panelConsultas.setMaximumSize(new java.awt.Dimension(761, 813));
        panelConsultas.setMinimumSize(new java.awt.Dimension(761, 813));
        panelConsultas.setPreferredSize(new java.awt.Dimension(761, 813));

        javax.swing.GroupLayout panelConsultasLayout = new javax.swing.GroupLayout(panelConsultas);
        panelConsultas.setLayout(panelConsultasLayout);
        panelConsultasLayout.setHorizontalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );
        panelConsultasLayout.setVerticalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );

        panelReporteFinal.setBackground(new java.awt.Color(255, 255, 255));
        panelReporteFinal.setMaximumSize(new java.awt.Dimension(617, 579));
        panelReporteFinal.setMinimumSize(new java.awt.Dimension(617, 579));

        panelReporte.setBackground(new java.awt.Color(255, 255, 255));
        panelReporte.setMaximumSize(new java.awt.Dimension(597, 365));
        panelReporte.setMinimumSize(new java.awt.Dimension(597, 365));

        javax.swing.GroupLayout panelReporteLayout = new javax.swing.GroupLayout(panelReporte);
        panelReporte.setLayout(panelReporteLayout);
        panelReporteLayout.setHorizontalGroup(
            panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelReporteLayout.setVerticalGroup(
            panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        exportarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/exportar.png"))); // NOI18N
        exportarButton.setBorder(null);

        javax.swing.GroupLayout panelReporteFinalLayout = new javax.swing.GroupLayout(panelReporteFinal);
        panelReporteFinal.setLayout(panelReporteFinalLayout);
        panelReporteFinalLayout.setHorizontalGroup(
            panelReporteFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReporteFinalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReporteFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReporteFinalLayout.createSequentialGroup()
                        .addGap(0, 436, Short.MAX_VALUE)
                        .addComponent(exportarButton)))
                .addContainerGap())
        );
        panelReporteFinalLayout.setVerticalGroup(
            panelReporteFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReporteFinalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exportarButton)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        panelVacio.setBackground(new java.awt.Color(255, 255, 255));
        panelVacio.setMaximumSize(new java.awt.Dimension(780, 813));
        panelVacio.setMinimumSize(new java.awt.Dimension(780, 813));
        panelVacio.setPreferredSize(new java.awt.Dimension(780, 813));

        javax.swing.GroupLayout panelVacioLayout = new javax.swing.GroupLayout(panelVacio);
        panelVacio.setLayout(panelVacioLayout);
        panelVacioLayout.setHorizontalGroup(
            panelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        panelVacioLayout.setVerticalGroup(
            panelVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );

        panelVacio1.setBackground(new java.awt.Color(255, 255, 255));
        panelVacio1.setMaximumSize(new java.awt.Dimension(780, 813));
        panelVacio1.setMinimumSize(new java.awt.Dimension(780, 813));

        javax.swing.GroupLayout panelVacio1Layout = new javax.swing.GroupLayout(panelVacio1);
        panelVacio1.setLayout(panelVacio1Layout);
        panelVacio1Layout.setHorizontalGroup(
            panelVacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        panelVacio1Layout.setVerticalGroup(
            panelVacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );

        panelVacio2.setBackground(new java.awt.Color(255, 255, 255));
        panelVacio2.setMaximumSize(new java.awt.Dimension(780, 813));
        panelVacio2.setMinimumSize(new java.awt.Dimension(780, 813));

        javax.swing.GroupLayout panelVacio2Layout = new javax.swing.GroupLayout(panelVacio2);
        panelVacio2.setLayout(panelVacio2Layout);
        panelVacio2Layout.setHorizontalGroup(
            panelVacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        panelVacio2Layout.setVerticalGroup(
            panelVacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );

        manejoVehiculos.setBackground(new java.awt.Color(255, 255, 255));
        manejoVehiculos.setToolTipText("Manejo de vehiculos");

        agregarVehiculosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/agregar.png"))); // NOI18N
        agregarVehiculosButton.setBorder(null);
        agregarVehiculosButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        agregarVehiculosButton.setMaximumSize(new java.awt.Dimension(160, 40));
        agregarVehiculosButton.setMinimumSize(new java.awt.Dimension(160, 40));
        agregarVehiculosButton.setPreferredSize(new java.awt.Dimension(160, 40));
        agregarVehiculosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarVehiculosButtonActionPerformed(evt);
            }
        });

        modificarVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/modificar.png"))); // NOI18N
        modificarVehiculos.setBorder(null);
        modificarVehiculos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        modificarVehiculos.setMaximumSize(new java.awt.Dimension(160, 40));
        modificarVehiculos.setMinimumSize(new java.awt.Dimension(160, 40));
        modificarVehiculos.setPreferredSize(new java.awt.Dimension(160, 40));
        modificarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarVehiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoVehiculosLayout = new javax.swing.GroupLayout(manejoVehiculos);
        manejoVehiculos.setLayout(manejoVehiculosLayout);
        manejoVehiculosLayout.setHorizontalGroup(
            manejoVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoVehiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manejoVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarVehiculosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manejoVehiculosLayout.setVerticalGroup(
            manejoVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoVehiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregarVehiculosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manejoPartes.setBackground(new java.awt.Color(255, 255, 255));

        agregarPartes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/agregar.png"))); // NOI18N
        agregarPartes.setBorder(null);
        agregarPartes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        agregarPartes.setMaximumSize(new java.awt.Dimension(160, 40));
        agregarPartes.setMinimumSize(new java.awt.Dimension(160, 40));
        agregarPartes.setPreferredSize(new java.awt.Dimension(160, 40));
        agregarPartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPartesActionPerformed(evt);
            }
        });

        modificarPartes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/modificar.png"))); // NOI18N
        modificarPartes.setBorder(null);
        modificarPartes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        modificarPartes.setMaximumSize(new java.awt.Dimension(160, 40));
        modificarPartes.setMinimumSize(new java.awt.Dimension(160, 40));
        modificarPartes.setPreferredSize(new java.awt.Dimension(160, 40));
        modificarPartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPartesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manejoPartesLayout = new javax.swing.GroupLayout(manejoPartes);
        manejoPartes.setLayout(manejoPartesLayout);
        manejoPartesLayout.setHorizontalGroup(
            manejoPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoPartesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manejoPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarPartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificarPartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manejoPartesLayout.setVerticalGroup(
            manejoPartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manejoPartesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregarPartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarPartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGestion.setBackground(new java.awt.Color(255, 255, 255));

        gestionVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/vehiculos.png"))); // NOI18N
        gestionVehiculos.setBorder(null);
        gestionVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionVehiculosActionPerformed(evt);
            }
        });

        gestionPartes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/partes.png"))); // NOI18N
        gestionPartes.setBorder(null);
        gestionPartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionPartesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGestionLayout = new javax.swing.GroupLayout(panelGestion);
        panelGestion.setLayout(panelGestionLayout);
        panelGestionLayout.setHorizontalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionVehiculos)
                    .addComponent(gestionPartes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGestionLayout.setVerticalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gestionVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gestionPartes)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ABC Corp. - Log in");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(500, 300));

        jPanel2.setBackground(new java.awt.Color(67, 165, 208));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/logo.png"))); // NOI18N

        jPanelCampos.setBackground(new java.awt.Color(255, 255, 255));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelUsuario.setText("Nombre de usuario:");

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPassword.setText("Contraseña: ");

        jButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazGrafica/Imagenes/ingresar.png"))); // NOI18N
        jButtonLogin.setBorder(null);
        jButtonLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonLogin.setMaximumSize(new java.awt.Dimension(160, 40));
        jButtonLogin.setMinimumSize(new java.awt.Dimension(160, 40));
        jButtonLogin.setPreferredSize(new java.awt.Dimension(160, 40));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCamposLayout = new javax.swing.GroupLayout(jPanelCampos);
        jPanelCampos.setLayout(jPanelCamposLayout);
        jPanelCamposLayout.setHorizontalGroup(
            jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamposLayout.createSequentialGroup()
                        .addGroup(jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jPasswordField)))))
        );
        jPanelCamposLayout.setVerticalGroup(
            jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        
        String id_usuario = tfLogin.getText().trim();
        char pass_usuario[] = jPasswordField.getPassword();
        String password = "";
        for (int i = 0; i < jPasswordField.getPassword().length; i++) {
            password += pass_usuario[i];
        }
        Usuario user = new Usuario();

        String tipo = user.validarUsuario(id_usuario, password);
        
        if (tipo.equalsIgnoreCase("Gerente")) {
            id_usuario_global = id_usuario;
            gerenteJFrame.setEnabled(true);
            gerenteJFrame.setVisible(true);
            gerenteJFrame.pack();
            this.setVisible(false);
            ResultSet tabla = user.datosUsuario(id_usuario);
            try {
                while (tabla.next()) {
                    nombreUserLabel.setText(tabla.getString(1));
                    sedeCargoLabel.setText(tabla.getString(2) + " - " + tabla.getString(3));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (tipo.equalsIgnoreCase("Jefe")) {
            id_usuario_global = id_usuario;
            jefeJFrame.setEnabled(true);
            jefeJFrame.setVisible(true);
            this.setVisible(false);

            ResultSet tabla = user.datosUsuario(id_usuario);
            try {
                while (tabla.next()) {
                    nombreUserLabel3.setText(tabla.getString(1));
                    sedeCargoLabel3.setText(tabla.getString(2) + " - " + tabla.getString(3));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (tipo.equalsIgnoreCase("Vendedor")) {
            id_usuario_global = id_usuario;
            vendedorJFrame.setEnabled(true);
            vendedorJFrame.setVisible(true);
            this.setVisible(false);
            ResultSet tabla = user.datosUsuario(id_usuario);
            try {
                while (tabla.next()) {
                    nombreUserLabel4.setText(tabla.getString(1));
                    sedeCargoLabel4.setText(tabla.getString(2) + " - " + tabla.getString(3));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        tfLogin.setText("");
        jPasswordField.setText("");
/*        vendedorJFrame.setVisible(true);
        jefeJFrame.setVisible(true);
        gerenteJFrame.setVisible(true);
        this.setVisible(false);*/
       
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void crearUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioButtonActionPerformed
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes");
        new Operaciones().agregarItemCombo(listaSedes, CrearUsuarioSedesCB);
        panelContenedor.setVisible(true);
        cl.show(panelContenedor, "Crear Usuario");
        
    }//GEN-LAST:event_crearUsuarioButtonActionPerformed

    private void tipoUsuarioCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoUsuarioCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoUsuarioCBActionPerformed

    private void id_usuarioCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_usuarioCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_usuarioCrearActionPerformed

    private void confirmarCrearUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarCrearUsuarioBActionPerformed
        
        String nombre_usuario = nombresCrear.getText().trim();
        String apellido = apellidosCrear.getText().trim();
        String password_usuario = passwordCrear.getText().trim();
        String tipo_usuario = tipoUsuarioCB.getSelectedItem().toString().trim();
        String nombre_sede = CrearUsuarioSedesCB.getSelectedItem().toString().trim();
        String email_usuario = emailUsuarioCrearTF.getText().trim();
        String id_usuario = id_usuarioCrear.getText().trim();
        String telefono_usuario = telefonoUsuarioCrearTF.getText().trim();
        
        String fecha_ingreso_usuario = new Operaciones().obtenerFecha();
        nombre_usuario = nombre_usuario + " " + apellido;
        Usuario user = new Usuario();

        String id_sede = new Operaciones().codigoSedeDeNombre(nombre_sede);
        
        user.crearUsuario(id_usuario, password_usuario, nombre_usuario, tipo_usuario, email_usuario, telefono_usuario, fecha_ingreso_usuario, id_sede);
        
        limpiarCrearUsuario();
        
        
    }//GEN-LAST:event_confirmarCrearUsuarioBActionPerformed

    private void crearSedeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearSedeButtonActionPerformed
        panelContenedor.setVisible(true);
        Operaciones oper = new Operaciones();
        String id = oper.obtenerUltimoCodigoSede();
        codigoSedeTF.setText(id);
        cl.show(panelContenedor, "Crear Sede");
    }//GEN-LAST:event_crearSedeButtonActionPerformed

    private void nombreSedeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreSedeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreSedeTFActionPerformed

    private void crearOrdenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearOrdenButtonActionPerformed
        // TODO add your handling code here:
        panelContenedorJefe.setVisible(true);
        String ultimoCod = new Ordenes().obtenerUltimoCodigoOrden();
        codOrdenCrearOrdenTF.setText(ultimoCod);
        clJefe.show(panelContenedorJefe, "Crear orden");
    }//GEN-LAST:event_crearOrdenButtonActionPerformed

    private void crearCotizacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCotizacionButtonActionPerformed
        // TODO add your handling code here:
        panelContenedorVendedor.setVisible(true);
        
        clVendedor.show(panelContenedorVendedor, "Crear cotizacion");
    }//GEN-LAST:event_crearCotizacionButtonActionPerformed

    private void venderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderButtonActionPerformed
        // TODO add your handling code here:
        OperacionesBD marcas = new OperacionesBD();
        codVentaVender.setText(new Venta().buscarUltimoCodigo());
        ResultSet listaMarcas = marcas.consultas("SELECT V.marca_vehiculo FROM vehiculos V GROUP BY V.marca_vehiculo;");
        new Operaciones().agregarItemCombo(listaMarcas, vehiculosDispVender);
        panelContenedorVendedor.setVisible(true);
        clVendedor.show(panelContenedorVendedor, "Vender");
        
    }//GEN-LAST:event_venderButtonActionPerformed

    private void modificarUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioButtonActionPerformed
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, modificarSedeUsuarioCB);
        panelContenedor.setVisible(true);
        cl.show(panelContenedor, "Modificar Usuario");
        
        String codigo = JOptionPane.showInputDialog("Codigo del usuario");
        OperacionesBD usuario = new OperacionesBD();
        ResultSet consulta = usuario.consultas("SELECT * FROM usuarios WHERE id_usuario = '" + codigo + "';");
        try {
            while (consulta.next()){
                modificarCodigoUsuarioTF.setText(consulta.getString("id_usuario"));
                modificarContraseñaTF.setText(consulta.getString("password_usuario"));
                if(consulta.getBoolean("estado_usuario") == true){
                    modificarActivoRB.setSelected(true);
                }else{
                    modificarInactivoRB.setSelected(true);
                }
                modificarNombreTF.setText(consulta.getString("nombre_usuario"));
                emailUsuarioModificarTF.setText(consulta.getString("email_usuario"));
                telefonoUsuarioModificarTF.setText(consulta.getString("telefono_usuario"));
                //consulta.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_modificarUsuarioButtonActionPerformed

    private void modificarSedeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarSedeButtonActionPerformed
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, modificarSedeSedesCB);
        panelContenedor.setVisible(true);       
        cl.show(panelContenedor, "Modificar Sede");
        
        
        
    }//GEN-LAST:event_modificarSedeButtonActionPerformed

    private void agregarVehiculosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarVehiculosButtonActionPerformed
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, crearSedeVehiculoCB);
        panelContenedor.setVisible(true);
                
        cl.show(panelContenedor, "Agregar Vehiculo");
        
    }//GEN-LAST:event_agregarVehiculosButtonActionPerformed

    private void modificarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarVehiculosActionPerformed
        panelContenedor.setVisible(true);
        cl.show(panelContenedor, "Modificar Vehiculo");
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, modificarSedeVehiculoCB);
            
        String codigo = JOptionPane.showInputDialog("Codigo del vehiculo");
        OperacionesBD vehiculo = new OperacionesBD();
        ResultSet consulta = vehiculo.consultas("SELECT * FROM vehiculos WHERE id_vehiculo = '" + codigo + "';");
        try {
            while (consulta.next()){
                modificarCodigoVehiculoTF.setText(codigo);
                modificarMarcaVehiculoTF.setText(consulta.getString(2));
                modificarModeloVehiculoTF.setText(consulta.getString(3));
                modificarColorVehiculoTF.setText(consulta.getString(4));
                if("t".equals(consulta.getString(5))){
                    modificarVehiculoNuevoRB.setSelected(true);
                    modificarVehiculoUsadoRB.setSelected(false);
                }else if("f".equals(consulta.getString(5))){
                    modificarVehiculoNuevoRB.setSelected(false);
                    modificarVehiculoUsadoRB.setSelected(true);
                }
                modificarValorVehiculoTF.setText(consulta.getString(7));
                //consulta.close();
            }
        
        
            
        } catch (SQLException ex) {
            Logger.getLogger(loginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarVehiculosActionPerformed

    private void agregarPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPartesActionPerformed
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, crearParteSedeCB);
        panelContenedor.setVisible(true);
        cl.show(panelContenedor, "Agregar Partes");
    }//GEN-LAST:event_agregarPartesActionPerformed

    private void modificarPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPartesActionPerformed
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, modificarParteSedeCB);
        panelContenedor.setVisible(true);
        cl.show(panelContenedor, "Modificar Partes");
    }//GEN-LAST:event_modificarPartesActionPerformed

    private void generarReporteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteButtonActionPerformed
        panelContenedor.setVisible(true);
        cl.show(panelContenedor, "Generar reportes");
    }//GEN-LAST:event_generarReporteButtonActionPerformed

    private void confirmarAgregarVehiculoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarAgregarVehiculoBActionPerformed
        try{
            String marca_vehiculo = crearMarcaVehiculoTF.getText().trim();
            String modelo_vehiculo = crearModeloVehiculoTF.getText().trim();
            String color_vehiculo = crearColorVehiculoTF.getText().trim();
            String nuevo_vehiculo = "";
        
            if(crearVehiculoNuevoRB.isSelected()){
                nuevo_vehiculo = "true";
            }else{
                nuevo_vehiculo = "false";
            }
            int cantidad = Integer.parseInt(crearCantidadVehiculoTF.getText());
            float valor = Float.parseFloat(crearValorVehiculoTF.getText());
            String nombre_sede = (String)crearSedeVehiculoCB.getSelectedItem();
        
            Operaciones op = new Operaciones();
            String fecha = op.obtenerFecha();
            String id_sede = op.codigoSedeDeNombre(nombre_sede);     
            Vehiculo vehiculo = new Vehiculo();
            
            int codigo = 0;
            for(int i = 0; i < cantidad; i++){
                codigo = vehiculo.agregarVehiculo(marca_vehiculo, modelo_vehiculo, color_vehiculo, nuevo_vehiculo, "1", valor, fecha, id_sede);
            }
            
            if(codigo != 0){
                JOptionPane.showMessageDialog(null, "Vehículo(s) agregados con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "La cantidad y el valor deben ser numeros", "Error", JOptionPane.ERROR_MESSAGE);
        }   
        
        limpiarCrearVehiculos();
        
    }//GEN-LAST:event_confirmarAgregarVehiculoBActionPerformed

    private void confirmarCrearSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarCrearSedeActionPerformed
        String nombre = nombreSedeTF.getText();       
        String direccion = direccionSedeCrearTF.getText().trim();
        String telefono = telefonoSedeCrearTF.getText().trim();
        String email = emailSedeCrearTF.getText().trim();
        Sede sede = new Sede();
        sede.agregarSede(nombre, direccion, telefono, email);
        
        Operaciones oper = new Operaciones();
        String id = oper.obtenerUltimoCodigoSede();
        
        limpiarCrearSede();       
    }//GEN-LAST:event_confirmarCrearSedeActionPerformed

    private void telefonoSedeModificarTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoSedeModificarTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoSedeModificarTFActionPerformed

    private void consultarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarUsuariosActionPerformed
        // TODO add your handling code here:
        panelConsultas.removeAll();
        String consultaSQL = "SELECT id_usuario, nombre_usuario, tipo_usuario, estado_usuario FROM usuarios;";
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        
        try{
            int count = 0;
            while(tabla.next()){
                count++;
            }
            
            String[][] data = new String[count][4];
            int i = 0;
            tabla = new OperacionesBD().consultas(consultaSQL);
            while(tabla.next()){
                data[i][0] = "" + tabla.getInt(1);
                data[i][1] = tabla.getString(2);
                data[i][2] = tabla.getString(3);
                if("true".equals(""+tabla.getBoolean(4))){
                    data[i][3] = "Activo";
                }else{
                    data[i][3] = "Inactivo";
                }
                i++;
            }
            String[] nombreColumnas = {"Identificador", "Nombre", "Rol", "Estado"};
            JTable tablaUsuario = new JTable(data, nombreColumnas);
            BorderLayout bl = new BorderLayout();
            panelConsultas.setLayout(bl);
            JScrollPane jsp = new JScrollPane(tablaUsuario);
            panelConsultas.add(jsp, BorderLayout.CENTER);
            jsp.setBackground(new Color(255,255,255));
            panelConsultas.setBackground(new Color(255,255,255));
            gerenteJFrame.getContentPane().add(panelContenedor);
            //gerenteJFrame.pack();
            //panelContenedor.setVisible(true);
            cl.show(panelContenedor, "Consultas");
            panelContenedor.repaint();
            panelConsultas.repaint();
            jsp.repaint();
            panelConsultas.setSize(780, 813);
            
        }catch(SQLException exc){
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
            exc.printStackTrace();
        }
        
    }//GEN-LAST:event_consultarUsuariosActionPerformed

    private void confirmarModificarUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarModificarUsuarioBActionPerformed

        String id_usuario = modificarCodigoUsuarioTF.getText().trim();
        char[] password = modificarContraseñaTF.getPassword();
        char[] password_2 = modificarConfirmarContraseñaTF.getPassword();
        String nombre_usuario = modificarNombreTF.getText().trim();
        String tipo_usuario = (String) modificarTipoUsuarioCB.getSelectedItem();
        String sede = (String) modificarSedeUsuarioCB.getSelectedItem();
        String email_usuario = emailUsuarioModificarTF.getText().trim();
        String telefono_usuario = telefonoUsuarioModificarTF.getText().trim();

        String password_usuario = "";
        String password_usuario2 = "";
        try {
            for (int i = 0; i < password.length; i++) {
                password_usuario += password[i];
                password_usuario2 += password_2[i];
                String estado = "false";
                if (modificarActivoRB.isSelected()) {
                    estado = "true";
                }
                if (!password_usuario.equals(password_usuario2)) {
                    JOptionPane.showMessageDialog(null, "Contraseñas no coinciden\nEscribelas nuevamente");
                } else {
                    Operaciones operaciones = new Operaciones();
                    String id_sede = operaciones.codigoSedeDeNombre(sede);
                    Usuario usuario = new Usuario();
                    usuario.modificarUsuario(id_usuario, password_usuario, nombre_usuario, email_usuario, telefono_usuario, tipo_usuario, id_sede, estado);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, completa los campos de contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        }

        limpiarModificarUsuario();
       
        
    }//GEN-LAST:event_confirmarModificarUsuarioBActionPerformed

    private void confirmarModificarParteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarModificarParteBActionPerformed
        try {
            String id_parte = modificarParteID.getText().trim();
            String nombre_parte = modificarNombreParteTF.getText().trim();
            int cantidad_parte = Integer.parseInt(modificarCantidadPartesTF.getText());
            float valor_parte = Float.parseFloat(modificarValorParteTF.getText());
            String sede = (String) modificarParteSedeCB.getSelectedItem();

            Operaciones operaciones = new Operaciones();
            String id_sede = operaciones.codigoSedeDeNombre(sede);
            Partes parte = new Partes();

            parte.modificarParte(id_parte, nombre_parte, cantidad_parte, valor_parte, id_sede);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "La cantidad y el valor deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        limpiarModificarPartes();
    }//GEN-LAST:event_confirmarModificarParteBActionPerformed

    private void consultarOrdenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarOrdenButtonActionPerformed
        // TODO add your handling code here:
        panelContenedorJefe.setVisible(true);
        clJefe.show(panelContenedorJefe, "Consultar orden");
        
        
    }//GEN-LAST:event_consultarOrdenButtonActionPerformed

    private void consultarCotizacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCotizacionButtonActionPerformed
        // TODO add your handling code here:
        panelContenedorVendedor.setVisible(true);
        clVendedor.show(panelContenedorVendedor, "Consultar cotizacion");
    }//GEN-LAST:event_consultarCotizacionButtonActionPerformed

    private void consultarSedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarSedesActionPerformed
        panelConsultas.removeAll();
        panelContenedor.setVisible(true);
        String consultaSQL = "SELECT id_sede, nombre_sede, direccion_sede, telefono_sede, email_sede FROM sedes;";
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        
        try{
            int count = 0;
            while(tabla.next()){
                count++;
            }
            
            String[][] data = new String[count][5];
            int i = 0;
            tabla = new OperacionesBD().consultas(consultaSQL);
            while(tabla.next()){
                data[i][0] = "" + tabla.getInt(1);
                data[i][1] = tabla.getString(2);
                data[i][2] = tabla.getString(3);
                data[i][3] = tabla.getString(4);
                data[i][4] = tabla.getString(5);
                i++;
            }
            String[] nombreColumnas = {"Codigo", "Nombre", "Direccion", "Telefono", "E-mail"};
            JTable tablaUsuario = new JTable(data, nombreColumnas);
            BorderLayout bl = new BorderLayout();
            panelConsultas.setLayout(bl);
            JScrollPane jsp = new JScrollPane(tablaUsuario);
            panelConsultas.add(jsp, BorderLayout.CENTER);
        
            gerenteJFrame.getContentPane().add(panelContenedor);
            gerenteJFrame.pack();
            
            cl.show(panelContenedor, "Consultas");
            panelContenedor.repaint();
        }catch(SQLException exc){
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
            exc.printStackTrace();
        }
        
    }//GEN-LAST:event_consultarSedesActionPerformed

    private void CrearUsuarioSedesCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CrearUsuarioSedesCBItemStateChanged
        // TODO add your handling code here:
        tipoUsuarioCB.removeAllItems();
        boolean tiene =  new Operaciones().tieneGerente((String)CrearUsuarioSedesCB.getSelectedItem());
        if(tiene){
            tipoUsuarioCB.addItem("Vendedor");
            tipoUsuarioCB.addItem("Jefe de taller");
        }else{
            tipoUsuarioCB.addItem("Gerente");
            tipoUsuarioCB.addItem("Vendedor");
            tipoUsuarioCB.addItem("Jefe de taller");
        }
        
    }//GEN-LAST:event_CrearUsuarioSedesCBItemStateChanged

    private void confirmarModificarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarModificarSedeActionPerformed
        // TODO add your handling code here:
        String id = new Operaciones().codigoSedeDeNombre((String)modificarSedeSedesCB.getSelectedItem());
        String nombre = nuevoNombreTF.getText().trim();
        String direccion = direccionSedeModificarTF.getText().trim();
        String telefono = telefonoSedeModificarTF.getText().trim();
        String email = emailSedeModificarTF.getText().trim();
        
        Sede sede = new Sede();
        sede.modificarSede(id, nombre, direccion, telefono, email);
        
        limpiarModificarSede();
        
    }//GEN-LAST:event_confirmarModificarSedeActionPerformed

    private void confirmarModificarVehiculoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarModificarVehiculoBActionPerformed
        // TODO add your handling code here:
        String codigo_vehiculo = modificarCodigoVehiculoTF.getText().trim();
        String marca_vehiculo = modificarMarcaVehiculoTF.getText().trim();
        String modelo_vehiculo = modificarModeloVehiculoTF.getText().trim();
        String color_vehiculo = modificarColorVehiculoTF.getText().trim();
        String nuevo_vehiculo = "";
        
        if(modificarVehiculoNuevoRB.isSelected()){
            nuevo_vehiculo = "true";
        }else if(modificarVehiculoUsadoRB.isSelected()){
            nuevo_vehiculo = "false";
        }
        
        
        //int cantidad = Integer.parseInt(modificarCantidadVehiculoTF.getText());
        //int id = Integer.parseInt(codigo_vehiculo);
        String nombre_sede = (String)modificarSedeVehiculoCB.getSelectedItem();
        float valor = Float.parseFloat(modificarValorVehiculoTF.getText());
        //String id_vehiculo = modificarCantidadVehiculoTF.getText();

        Operaciones op = new Operaciones();

        String id_sede = op.codigoSedeDeNombre(nombre_sede);
        
        Vehiculo vehiculo = new Vehiculo();       
        int codigo = 0;
        codigo = vehiculo.modificarVehiculo(codigo_vehiculo, marca_vehiculo, modelo_vehiculo, color_vehiculo, nuevo_vehiculo, valor, id_sede);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Vehículo modificado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
        limpiarModificarVehiculos();
              
    }//GEN-LAST:event_confirmarModificarVehiculoBActionPerformed

    private void modificarSedeSedesCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modificarSedeSedesCBItemStateChanged
        String consultaSQL = "SELECT * FROM sedes WHERE nombre_sede LIKE '" + (String)modificarSedeSedesCB.getSelectedItem() + "';";
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        try {
            while(tabla.next()){
                nuevoNombreTF.setText(tabla.getString("nombre_sede"));
                direccionSedeModificarTF.setText(tabla.getString("direccion_sede"));
                telefonoSedeModificarTF.setText(tabla.getString("telefono_sede"));
                emailSedeModificarTF.setText(tabla.getString("email_sede"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_modificarSedeSedesCBItemStateChanged

    private void modificarParteSedeCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modificarParteSedeCBItemStateChanged
        //parteModificarCB.removeAllItems();
        Operaciones operaciones = new Operaciones();
        String consultaSQL = "";
        String id_sede = operaciones.codigoSedeDeNombre((String)modificarParteSedeCB.getSelectedItem());
        if(!id_sede.equals("")){
            consultaSQL = "SELECT nombre_parte FROM partes WHERE id_sede = " + id_sede + ";";
            ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
            operaciones.agregarItemCombo(tabla, parteModificarCB);
        }
        
    }//GEN-LAST:event_modificarParteSedeCBItemStateChanged

    private void parteModificarCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_parteModificarCBItemStateChanged
        if(parteModificarCB.getSelectedItem() != null){
            String consultaSQL = "SELECT * FROM partes WHERE nombre_parte LIKE '" + (String)parteModificarCB.getSelectedItem() + "';";
        
            ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
            try {
                while(tabla.next()){
                    modificarParteID.setText(tabla.getString("id_parte"));
                    modificarNombreParteTF.setText(tabla.getString("nombre_parte"));
                    modificarCantidadPartesTF.setText(tabla.getString("cantidad_parte"));
                    modificarValorParteTF.setText(tabla.getString("valor_parte"));
                }   
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }      
    }//GEN-LAST:event_parteModificarCBItemStateChanged

    private void confirmarCrearParteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarCrearParteBActionPerformed
        Partes parte = new Partes();
        Operaciones operaciones = new Operaciones();
        String nombre_parte = crearNombreParteTF.getText();
        String cantidad_parte = crearCantidadPartesTF.getText();
        String valor_parte = crearValorParteTF.getText();
        String id_sede_parte = operaciones.codigoSedeDeNombre((String)crearParteSedeCB.getSelectedItem());
        parte.agregarPartes(nombre_parte, cantidad_parte, valor_parte, id_sede_parte);
        limpiarCrearPartes();
        
    }//GEN-LAST:event_confirmarCrearParteBActionPerformed

    private void aportePorSedeReportesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aportePorSedeReportesBotonActionPerformed
        // TODO add your handling code here:
        panelReporte.removeAll();
        ChartPanel panel = new Reporte().generarReporteAportePorSede();
        cl.show(panelContenedor, "Reporte");
        panelReporte.add(panel);
        panelReporte.updateUI();
    }//GEN-LAST:event_aportePorSedeReportesBotonActionPerformed

    private void vehiculosPorSedeBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculosPorSedeBotonActionPerformed
        // TODO add your handling code here:
        panelReporte.removeAll();
        ChartPanel panel = new Reporte().generarReporteCantidadVehiculos();
        cl.show(panelContenedor, "Reporte");
        panelReporte.add(panel);
        panelReporte.updateUI();
    }//GEN-LAST:event_vehiculosPorSedeBotonActionPerformed

    private void generarReporteOpcionesButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteOpcionesButonActionPerformed
        // TODO add your handling code here:
        if(COTIZACIONES_SEDE == tipoReporte){
            panelReporte.removeAll();
            
            if(semanalOpcionesReportes.isSelected() && sedesOpcionesReportes.isSelected()){
                int dia = Integer.parseInt(diaOpcionesReportes.getText());
                int mes = Integer.parseInt(mesOpcionesReportes.getText());
                int year = Integer.parseInt(yearOpcionesReportes.getText());
                Calendar c  = Calendar.getInstance();
                c.set(year, --mes, dia);
            
                java.util.Date fechaInicial = c.getTime();
            
                String id_sede = new Operaciones().codigoSedeDeNombre((String)sedesOpcionesReporte.getSelectedItem());
                ChartPanel panel = new Reporte().generarReporteCotizacionesSede(fechaInicial, id_sede);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(sedesOpcionesReportes.isSelected() && todoOpcionesReportes.isSelected()){
                String id_sede = new Operaciones().codigoSedeDeNombre((String)sedesOpcionesReporte.getSelectedItem());
                ChartPanel panel = new Reporte().generarReporteCotizacionesSedeAll(id_sede);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(empresaOpcionesReportes.isSelected() && semanalOpcionesReportes.isSelected()){
                int dia = Integer.parseInt(diaOpcionesReportes.getText());
                int mes = Integer.parseInt(mesOpcionesReportes.getText());
                int year = Integer.parseInt(yearOpcionesReportes.getText());
                Calendar c  = Calendar.getInstance();
                c.set(year, --mes, dia);            
                java.util.Date fechaInicial = c.getTime();
            
                ChartPanel panel = new Reporte().generarReporteCotizacionesEmpresa(fechaInicial);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(empresaOpcionesReportes.isSelected() && todoOpcionesReportes.isSelected()){
                ChartPanel panel = new Reporte().generarReporteCotizacionesEmpresaAll();
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
            
        }else if(tipoReporte == VEHICULOS_AGREGADOS){
            if(semanalOpcionesReportes.isSelected() && !(diaOpcionesReportes.getText().trim().equals("") && mesOpcionesReportes.getText().trim().equals("") && yearOpcionesReportes.getText().trim().equals(""))){
                try{
                    int dia = Integer.parseInt(diaOpcionesReportes.getText());
                    int mes = Integer.parseInt(mesOpcionesReportes.getText());
                    int year = Integer.parseInt(yearOpcionesReportes.getText());
                    Calendar c = Calendar.getInstance();
                    c.set(year, --mes, dia);

                    java.util.Date fechaInicial = c.getTime();

                    panelReporte.removeAll();
                    ChartPanel panel = new Reporte().generarReporteVehiculosAgregadosSemanal(fechaInicial);
                    cl.show(panelContenedor, "Reporte");
                    panelReporte.add(panel);
                    panelReporte.updateUI();
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Los valores ingresados no son válidos", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }else if(todoOpcionesReportes.isSelected()){
                panelReporte.removeAll();
                ChartPanel panel = new Reporte().generarReporteVehiculosAgregados();
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }           
        }else if(tipoReporte == ORDENES_EMPRESA){
            panelReporte.removeAll();
            if(semanalOpcionesReportes.isSelected() && sedesOpcionesReportes.isSelected()){
                int dia = Integer.parseInt(diaOpcionesReportes.getText());
                int mes = Integer.parseInt(mesOpcionesReportes.getText());
                int year = Integer.parseInt(yearOpcionesReportes.getText());
                Calendar c  = Calendar.getInstance();
                c.set(year, --mes, dia);
            
                java.util.Date fechaInicial = c.getTime();
            
                String id_sede = new Operaciones().codigoSedeDeNombre((String)sedesOpcionesReporte.getSelectedItem());
                ChartPanel panel = new Reporte().generarReporteOrdenesSemanalSede(fechaInicial, id_sede);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(sedesOpcionesReportes.isSelected() && todoOpcionesReportes.isSelected()){
                String id_sede = new Operaciones().codigoSedeDeNombre((String)sedesOpcionesReporte.getSelectedItem());
                ChartPanel panel = new Reporte().generarReporteOrdenesSede(id_sede);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(empresaOpcionesReportes.isSelected() && semanalOpcionesReportes.isSelected()){
                int dia = Integer.parseInt(diaOpcionesReportes.getText());
                int mes = Integer.parseInt(mesOpcionesReportes.getText());
                int year = Integer.parseInt(yearOpcionesReportes.getText());
                Calendar c  = Calendar.getInstance();
                c.set(year, --mes, dia);            
                java.util.Date fechaInicial = c.getTime();
            
                ChartPanel panel = new Reporte().generarReporteOrdenesSemanalEmpresa(fechaInicial);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(empresaOpcionesReportes.isSelected() && todoOpcionesReportes.isSelected()){
                ChartPanel panel = new Reporte().generarReporteOrdenesEmpresa();
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(tipoReporte == VENTAS_EMPRESA){
            panelReporte.removeAll();
            if(semanalOpcionesReportes.isSelected() && sedesOpcionesReportes.isSelected()){
                int dia = Integer.parseInt(diaOpcionesReportes.getText());
                int mes = Integer.parseInt(mesOpcionesReportes.getText());
                int year = Integer.parseInt(yearOpcionesReportes.getText());
                Calendar c  = Calendar.getInstance();
                c.set(year, --mes, dia);
            
                java.util.Date fechaInicial = c.getTime();
            
                String id_sede = new Operaciones().codigoSedeDeNombre((String)sedesOpcionesReporte.getSelectedItem());
                ChartPanel panel = new Reporte().generarReporteVentasSemanalSede(fechaInicial, id_sede);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(sedesOpcionesReportes.isSelected() && todoOpcionesReportes.isSelected()){
                String id_sede = new Operaciones().codigoSedeDeNombre((String)sedesOpcionesReporte.getSelectedItem());
                ChartPanel panel = new Reporte().generarReporteVentasSede(id_sede);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(empresaOpcionesReportes.isSelected() && semanalOpcionesReportes.isSelected()){
                int dia = Integer.parseInt(diaOpcionesReportes.getText());
                int mes = Integer.parseInt(mesOpcionesReportes.getText());
                int year = Integer.parseInt(yearOpcionesReportes.getText());
                Calendar c  = Calendar.getInstance();
                c.set(year, --mes, dia);            
                java.util.Date fechaInicial = c.getTime();
            
                ChartPanel panel = new Reporte().generarReporteVentasSemanalEmpresa(fechaInicial);
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else if(empresaOpcionesReportes.isSelected() && todoOpcionesReportes.isSelected()){
                ChartPanel panel = new Reporte().generarReporteVentasEmpresa();
                cl.show(panelContenedor, "Reporte");
                panelReporte.add(panel);
                panelReporte.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        frameOpcionesReporte.setVisible(false);
        sedesOpcionesReportes.setSelected(false);
        empresaOpcionesReportes.setSelected(false);
        sedesOpcionesReporte.removeAllItems();
        semanalOpcionesReportes.setSelected(false);
        todoOpcionesReportes.setSelected(false);
        diaOpcionesReportes.setText("");
        mesOpcionesReportes.setText("");
        yearOpcionesReportes.setText("");
        diaOpcionesReportes.setEnabled(true);
        mesOpcionesReportes.setEnabled(true);
        yearOpcionesReportes.setEnabled(true);
        panelReporte.updateUI();
    }//GEN-LAST:event_generarReporteOpcionesButonActionPerformed

    private void ordenesReporteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenesReporteBotonActionPerformed
        // TODO add your handling code here:
        frameOpcionesReporte.setVisible(true);
        tipoReporte = ORDENES_EMPRESA;
    }//GEN-LAST:event_ordenesReporteBotonActionPerformed

    private void vehiculosAgregadosReporteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculosAgregadosReporteBotonActionPerformed
        // TODO add your handling code here:
        frameOpcionesReporte.setVisible(true);
        sedesOpcionesReporte.setEnabled(false);
        sedesOpcionesReportes.setEnabled(false);
        empresaOpcionesReportes.setEnabled(false);
        tipoReporte = VEHICULOS_AGREGADOS;        
    }//GEN-LAST:event_vehiculosAgregadosReporteBotonActionPerformed

    private void cotizacionesReporteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cotizacionesReporteBotonActionPerformed
        // TODO add your handling code here:
        frameOpcionesReporte.setVisible(true);
        tipoReporte = COTIZACIONES_SEDE;
    }//GEN-LAST:event_cotizacionesReporteBotonActionPerformed

    private void sedesOpcionesReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sedesOpcionesReportesActionPerformed
        // TODO add your handling code here:
        OperacionesBD sedes = new OperacionesBD();
        ResultSet listaSedes = sedes.consultas("SELECT nombre_sede FROM sedes;");
        new Operaciones().agregarItemCombo(listaSedes, sedesOpcionesReporte);
        
    }//GEN-LAST:event_sedesOpcionesReportesActionPerformed

    private void todoOpcionesReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoOpcionesReportesActionPerformed
        // TODO add your handling code here:
        diaOpcionesReportes.setEnabled(false);
        mesOpcionesReportes.setEnabled(false);
        yearOpcionesReportes.setEnabled(false);
    }//GEN-LAST:event_todoOpcionesReportesActionPerformed

    private void semanalOpcionesReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semanalOpcionesReportesActionPerformed
        // TODO add your handling code here:
        diaOpcionesReportes.setEnabled(true);
        mesOpcionesReportes.setEnabled(true);
        yearOpcionesReportes.setEnabled(true);
    }//GEN-LAST:event_semanalOpcionesReportesActionPerformed

    private void venderBuscarCotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderBuscarCotButtonActionPerformed
        // TODO add your handling code here:
        String codigoCotizacion = codCotVender.getText();
        ResultSet consulta = new Venta().buscarCotizacion(codigoCotizacion);
        try {
            while (consulta.next()){
                codCotVender.setText(codigoCotizacion);
                codVendedorVender.setText(consulta.getString("id_usuario"));
                codCompradorVender.setText(consulta.getString("id_comprador"));
                
                codVehiculoVender.setText(consulta.getString("id_vehiculo"));
                
                modificarValorVehiculoTF.setText(consulta.getString(7));
                consulta.close();
            }
        
        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Eror", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_venderBuscarCotButtonActionPerformed

    private void ventaCrearVentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaCrearVentaButtonActionPerformed
        // TODO add your handling code here:
        Venta venta = new Venta();
        Comprador comprador = new Comprador();
        
        Operaciones operacion = new Operaciones();
        String id_usuario = (String)codVendedorVender.getText();
        String id_vehiculo = (String)codVehiculoVender.getText();
        String id_comprador = (String)codCompradorVender.getText();
        String fecha_venta = operacion.obtenerFecha();
        Object[] options = {"Pagar","Cancelar"};
        int n = JOptionPane.showOptionDialog(null, "Está a punto de confirmar la venta por un valor de: " + new Vehiculo().valorVehiculoIVA(id_vehiculo) 
                + "\n¿Desea confirmar el pago?", "Confirmar pago", WIDTH, HEIGHT, null, options, options[1]);
        boolean bool;
        bool = (id_usuario.isEmpty() || id_vehiculo.isEmpty() || id_comprador.isEmpty());
        if(!bool){
            if(n == 0 ){
            cedulaIngresarCliente.setText(id_comprador);
                if(!comprador.existeComprador(id_comprador)){
                    ingresarUsuarioFrame.setVisible(true);
                    JOptionPane.showMessageDialog(null, "El comprador no se encuentra registrado\nPor favor ingrese los datos.");
                }else{
                    venta.crearVenta(id_usuario, id_vehiculo, id_comprador, fecha_venta);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error en el pago");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No deje espacios vacios");
        }
        
        limpiarCrearVenta();
        codVentaVender.setText(venta.buscarUltimoCodigo());
    }//GEN-LAST:event_ventaCrearVentaButtonActionPerformed

    private void vehiculosDispVenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vehiculosDispVenderItemStateChanged
        // TODO add your handling code here:
        panelConsultas.removeAll();
        panelContenedor.setVisible(true);
        String consultaSQL = "SELECT id_vehiculo, marca_vehiculo, modelo_vehiculo, color_vehiculo, "
                + "nuevo_vehiculo, valor_vehiculo, id_sede FROM vehiculos WHERE marca_vehiculo = '" + (String)vehiculosDispVender.getSelectedItem()
                + "' AND cantidad_disponible_vehiculo = 1;";
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        DefaultTableModel dtm = new DefaultTableModel(0,0);
        
        try{
            int count = 0;
            while(tabla.next()){
                count++;
            }
            
            String[][] data = new String[count][7];
            int i = 0;
            tabla = new OperacionesBD().consultas(consultaSQL);
            while(tabla.next()){
                data[i][0] = "" + tabla.getInt("id_vehiculo");
                data[i][1] = tabla.getString("marca_vehiculo");
                data[i][2] = tabla.getString("modelo_vehiculo");
                data[i][3] = tabla.getString("color_vehiculo");
                data[i][4] = tabla.getString("nuevo_vehiculo");
                data[i][5] = tabla.getString("valor_vehiculo");
                data[i][6] = tabla.getString("id_sede");
                i++;
            }
            String[] nombreColumnas = {"Codigo", "Marca", "Modelo", "Color", "Nuevo", "Valor", "Sede"};
            dtm.setColumnIdentifiers(nombreColumnas);
            tableCrearCot1.setModel(dtm);
            for (int j = 0; j < count; j++) {
                dtm.addRow(data[j]);
            }
            
            
        }catch(SQLException exc){
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
            exc.printStackTrace();
        }
    }//GEN-LAST:event_vehiculosDispVenderItemStateChanged

    private void botonCrearOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearOrdenActionPerformed
        // TODO add your handling code here:
        String codigoVehiculo = codVehiculoCrearOrdenTF.getText();
        String codigoParte = codParteCrearOrdenTF.getText();
        String codigoJefe = codJefeTallerCrearOrdenTF.getText();
        String resumen = resumenCrearOrdenTA.getText();
        int cantidad = (int)spinnerCantidad.getValue();
        
        if (!(codigoJefe.equals("") && codigoParte.equals("") && codigoVehiculo.equals("") && resumen.equals(""))) {
            Ordenes objeto = new Ordenes();
            if (objeto.generarOrden(codigoVehiculo, codigoParte, codigoJefe, resumen, cantidad)) {
                codVehiculoCrearOrdenTF.setText("");
                codParteCrearOrdenTF.setText("");
                codJefeTallerCrearOrdenTF.setText("");
                resumenCrearOrdenTA.setText("");
                JOptionPane.showMessageDialog(gerenteJPanel, "Orden generada con exito");
                String ordenCod = objeto.obtenerUltimoCodigoOrden();
                codOrdenCrearOrdenTF.setText(ordenCod);
            } else {
                JOptionPane.showMessageDialog(gerenteJPanel, "La orden no fue generada");
            }
        }    
        
        limpiarCrearOrden();
    }//GEN-LAST:event_botonCrearOrdenActionPerformed

    private void aceptarConsultarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarConsultarOrdenActionPerformed
        // TODO add your handling code here:
        Ordenes orden = new Ordenes();
        String codString = codOrdenConsultarOrdenTF.getText();
        ResultSet tabla = orden.consultarOrden(codString);
        try {
            while(tabla.next()){
                vehiculoConsultarOrden.setText(tabla.getString(1));
                parteConsultarOrden.setText(tabla.getString(2));
                descripcionConsultarOrden.setText(tabla.getString(3));
                labelCantidadConsultarOrden.setText("Cantidad: "+tabla.getInt(4));
            }           
        } catch (SQLException ex) {
            ex.printStackTrace();        
        }
        
        
    }//GEN-LAST:event_aceptarConsultarOrdenActionPerformed

    private void crearCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCotizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearCotizacionActionPerformed

    private void ventasReporteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasReporteBotonActionPerformed
        // TODO add your handling code here:
        frameOpcionesReporte.setVisible(true);
        tipoReporte = VENTAS_EMPRESA;
    }//GEN-LAST:event_ventasReporteBotonActionPerformed

    private void salirLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirLabelMouseClicked
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null, "Esta a punto de salir del sistema.\n¿Desea continuar?");
        if(salir == JOptionPane.YES_OPTION){
            Usuario user = new Usuario();
            user.desconectarUsuario(id_usuario_global);
            gerenteJFrame.setVisible(false);
            this.setVisible(true);
        }
    }//GEN-LAST:event_salirLabelMouseClicked

    private void gerenteJFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_gerenteJFrameWindowClosing
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null, "Esta a punto de salir del sistema.\n¿Desea continuar?");
        if(salir == JOptionPane.YES_OPTION){
            Usuario user = new Usuario();
            user.desconectarUsuario(id_usuario_global);
            gerenteJFrame.setVisible(false);
            this.setVisible(true);
        }
        
    }//GEN-LAST:event_gerenteJFrameWindowClosing

    private void jefeJFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jefeJFrameWindowClosing
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null, "Esta a punto de salir del sistema.\n¿Desea continuar?");
        if(salir == JOptionPane.YES_OPTION){
            Usuario user = new Usuario();
            user.desconectarUsuario(id_usuario_global);
            jefeJFrame.setVisible(false);
            this.setVisible(true);
        }
    }//GEN-LAST:event_jefeJFrameWindowClosing

    private void vendedorJFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_vendedorJFrameWindowClosing
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null, "Esta a punto de salir del sistema.\n¿Desea continuar?");
        if(salir == JOptionPane.YES_OPTION){
            Usuario user = new Usuario();
            user.desconectarUsuario(id_usuario_global);
            vendedorJFrame.setVisible(false);
            this.setVisible(true);
        }
    }//GEN-LAST:event_vendedorJFrameWindowClosing

    private void salirLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirLabel1MouseClicked
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null, "Esta a punto de salir del sistema.\n¿Desea continuar?");
        if(salir == JOptionPane.YES_OPTION){
            Usuario user = new Usuario();
            user.desconectarUsuario(id_usuario_global);
            jefeJFrame.setVisible(false);
            this.setVisible(true);
        }
    }//GEN-LAST:event_salirLabel1MouseClicked

    private void salirLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirLabel2MouseClicked
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null, "Esta a punto de salir del sistema.\n¿Desea continuar?");
        if(salir == JOptionPane.YES_OPTION){
            Usuario user = new Usuario();
            user.desconectarUsuario(id_usuario_global);
            vendedorJFrame.setVisible(false);
            this.setVisible(true);
        }
    }//GEN-LAST:event_salirLabel2MouseClicked

    private void reportePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportePersonalActionPerformed
        // TODO add your handling code here:
        panelReporte.removeAll();
        ChartPanel panel = new Reporte().generarReportePersonal();
        cl.show(panelContenedor, "Reporte");
        panelReporte.add(panel);
        panelReporte.updateUI();
    }//GEN-LAST:event_reportePersonalActionPerformed

    private void gestionVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionVehiculosActionPerformed
        // TODO add your handling code here:
        clInventario.show(panel, "Vehiculos");
    }//GEN-LAST:event_gestionVehiculosActionPerformed

    private void gestionPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionPartesActionPerformed
        // TODO add your handling code here:
        clInventario.show(panel, "Partes");
    }//GEN-LAST:event_gestionPartesActionPerformed

    private void ingresarUsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarUsuarioBotonActionPerformed
        // TODO add your handling code here:
        Comprador comprador = new Comprador();

        String id_comprador = cedulaIngresarCliente.getText();
        String nombre_comprador = nombreIngresarCliente.getText();
        String direccion_comprador = direccionIngresarCliente.getText();
        String email_comprador = emailIngresarCliente.getText();
        String telefono_comprador = telefonoIngresarCliente.getText();

        cedulaIngresarCliente.setText("");
        comprador.crearComprador(id_comprador, nombre_comprador, direccion_comprador, telefono_comprador, email_comprador);
        frameOpcionesReporte.setVisible(false);
        cedulaIngresarCliente.setText("");
        nombreIngresarCliente.setText("");
        direccionIngresarCliente.setText("");
        emailIngresarCliente.setText("");
        telefonoIngresarCliente.setText("");
    }//GEN-LAST:event_ingresarUsuarioBotonActionPerformed

    private void codCotVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codCotVenderActionPerformed
        // TODO add your handling code here:
        codCotVender.setText("");
    }//GEN-LAST:event_codCotVenderActionPerformed

    private void cancelarVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVenderActionPerformed
        // TODO add your handling code here:
        limpiarCrearVenta();
        clVendedor.show(panelContenedorVendedor, "Inicio");
    }//GEN-LAST:event_cancelarVenderActionPerformed

    private void cancelarCrearSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearSedeActionPerformed
        // TODO add your handling code here:
        limpiarCrearSede();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarCrearSedeActionPerformed

    private void cancelarModSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarModSedeActionPerformed
        // TODO add your handling code here:
        limpiarModificarSede();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarModSedeActionPerformed

    private void botonCancelarCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarCrearActionPerformed
        // TODO add your handling code here:
        limpiarCrearUsuario();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_botonCancelarCrearActionPerformed

    private void cancelarModUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarModUsuarioActionPerformed
        // TODO add your handling code here:
        limpiarModificarUsuario();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarModUsuarioActionPerformed

    private void cancelarAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAgregarVehiculoActionPerformed
        // TODO add your handling code here:
        limpiarCrearVehiculos();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarAgregarVehiculoActionPerformed

    private void cancelarModVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarModVehiculoActionPerformed
        // TODO add your handling code here:
        limpiarModificarVehiculos();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarModVehiculoActionPerformed

    private void cancelarAgregarParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAgregarParteActionPerformed
        // TODO add your handling code here:
        limpiarCrearPartes();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarAgregarParteActionPerformed

    private void cancelarModParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarModParteActionPerformed
        // TODO add your handling code here:
        limpiarModificarPartes();
        cl.show(panelContenedor, "Inicio");
    }//GEN-LAST:event_cancelarModParteActionPerformed

    private void cancelarCrearOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCrearOrdenActionPerformed
        // TODO add your handling code here:
        limpiarCrearOrden();
        clJefe.show(panelContenedorJefe, "Inicio");
    }//GEN-LAST:event_cancelarCrearOrdenActionPerformed
    
    private void limpiarCrearSede(){
        String id = new Operaciones().obtenerUltimoCodigoSede();
        codigoSedeTF.setText(id);
        nombreSedeTF.setText("");
        direccionSedeCrearTF.setText("");
        telefonoSedeCrearTF.setText("");
        emailSedeCrearTF.setText("");
    }
    
    private void limpiarModificarSede(){
        nuevoNombreTF.setText("");
        direccionSedeModificarTF.setText("");
        telefonoSedeModificarTF.setText("");
        emailSedeModificarTF.setText("");
    }
    
    private void limpiarCrearUsuario(){
        nombresCrear.setText("");
        apellidosCrear.setText("");
        passwordCrear.setText("");
        emailUsuarioCrearTF.setText("");
        id_usuarioCrear.setText("");
        telefonoUsuarioCrearTF.setText("");
    }
    
    private void limpiarModificarUsuario(){
        modificarCodigoUsuarioTF.setText("");
        modificarContraseñaTF.setText("");
        modificarNombreTF.setText("");
        modificarConfirmarContraseñaTF.setText("");
        emailUsuarioModificarTF.setText("");
        telefonoUsuarioModificarTF.setText("");
    }
    
    private void limpiarCrearVehiculos(){
        crearMarcaVehiculoTF.setText("");
        crearModeloVehiculoTF.setText("");
        crearColorVehiculoTF .setText("");
        crearCantidadVehiculoTF.setText("");
        crearValorVehiculoTF.setText(""); 
    }
    
    private void limpiarModificarVehiculos(){
        modificarCodigoVehiculoTF.setText("");
        modificarMarcaVehiculoTF.setText("");
        modificarModeloVehiculoTF.setText("");
        modificarColorVehiculoTF.setText("");
        modificarValorVehiculoTF.setText("");  
    }
    
    private void limpiarCrearPartes(){
        crearNombreParteTF.setText("");
        crearCantidadPartesTF.setText("");
        crearValorParteTF.setText("");
    }
    
    private void limpiarModificarPartes(){
        modificarParteID.setText("");
        modificarNombreParteTF.setText("");
        modificarCantidadPartesTF.setText("");
        modificarValorParteTF.setText("");
    }
    
    private void limpiarCrearOrden(){
        codVehiculoCrearOrdenTF.setText("");
        codParteCrearOrdenTF.setText("");
        codJefeTallerCrearOrdenTF.setText("");
        resumenCrearOrdenTA.setText("");
        spinnerCantidad.setValue(0);
    }
    
    private void limpiarCrearCotizacion(){
        
    }
    
    private void limpiarCrearVenta(){
        codVendedorVender.setText("");
        codVehiculoVender.setText("");
        codCompradorVender.setText("");
        codCotVender.setText("(Opcional)");
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginInterface().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CrearUsuarioSedesCB;
    private javax.swing.JButton aceptarConsultarCot;
    private javax.swing.JButton aceptarConsultarOrden;
    private javax.swing.JButton agregarPartes;
    private javax.swing.JButton agregarVehiculosButton;
    private javax.swing.JTextField apellidosCrear;
    private javax.swing.JButton aportePorSedeReportesBoton;
    private javax.swing.JButton botonCancelarCrear;
    private javax.swing.JButton botonCrearOrden;
    private javax.swing.JButton cancelarAgregarParte;
    private javax.swing.JButton cancelarAgregarVehiculo;
    private javax.swing.JButton cancelarCrearCot;
    private javax.swing.JButton cancelarCrearOrden;
    private javax.swing.JButton cancelarCrearSede;
    private javax.swing.JButton cancelarIngresarUsuario;
    private javax.swing.JButton cancelarModParte;
    private javax.swing.JButton cancelarModSede;
    private javax.swing.JButton cancelarModUsuario;
    private javax.swing.JButton cancelarModVehiculo;
    private javax.swing.JButton cancelarVender;
    private javax.swing.JTextField cedulaIngresarCliente;
    private javax.swing.JTextField codCompradorConsultarCot;
    private javax.swing.JTextField codCompradorCrearCot;
    private javax.swing.JTextField codCompradorVender;
    private javax.swing.JTextField codCotConsultarCot;
    private javax.swing.JTextField codCotVender;
    private javax.swing.JTextField codJefeTallerCrearOrdenTF;
    private javax.swing.JTextField codOrdenConsultarOrdenTF;
    private javax.swing.JTextField codOrdenCrearOrdenTF;
    private javax.swing.JTextField codParteCrearOrdenTF;
    private javax.swing.JTextField codVehiculoConsultarCot;
    private javax.swing.JTextField codVehiculoCrearCot;
    private javax.swing.JTextField codVehiculoCrearOrdenTF;
    private javax.swing.JTextField codVehiculoVender;
    private javax.swing.JTextField codVendedorConsultarCot;
    private javax.swing.JTextField codVendedorCrearCot;
    private javax.swing.JTextField codVendedorVender;
    private javax.swing.JTextField codVentaVender;
    private javax.swing.JTextField codigoSedeTF;
    private javax.swing.JButton confirmarAgregarVehiculoB;
    private javax.swing.JButton confirmarCrearParteB;
    private javax.swing.JButton confirmarCrearSede;
    private javax.swing.JButton confirmarCrearUsuarioB;
    private javax.swing.JButton confirmarModificarParteB;
    private javax.swing.JButton confirmarModificarSede;
    private javax.swing.JButton confirmarModificarUsuarioB;
    private javax.swing.JButton confirmarModificarVehiculoB;
    private javax.swing.JButton consultarCotizacionButton;
    private javax.swing.JButton consultarOrdenButton;
    private javax.swing.JButton consultarSedes;
    private javax.swing.JButton consultarUsuarios;
    private javax.swing.JButton cotizacionesReporteBoton;
    private javax.swing.JPanel cotizacionesReportePanel;
    private javax.swing.JTextField crearCantidadPartesTF;
    private javax.swing.JTextField crearCantidadVehiculoTF;
    private javax.swing.JTextField crearColorVehiculoTF;
    private javax.swing.JButton crearCotizacion;
    private javax.swing.JButton crearCotizacionButton;
    private javax.swing.JTextField crearMarcaVehiculoTF;
    private javax.swing.JTextField crearModeloVehiculoTF;
    private javax.swing.JTextField crearNombreParteTF;
    private javax.swing.JButton crearOrdenButton;
    private javax.swing.JComboBox<String> crearParteSedeCB;
    private javax.swing.JButton crearSedeButton;
    private javax.swing.JComboBox<String> crearSedeVehiculoCB;
    private javax.swing.JButton crearUsuarioButton;
    private javax.swing.JTextField crearValorParteTF;
    private javax.swing.JTextField crearValorVehiculoTF;
    private javax.swing.JRadioButton crearVehiculoNuevoRB;
    private javax.swing.JRadioButton crearVehiculoUsadoRB;
    private javax.swing.JTextArea descripcionConsultarOrden;
    private javax.swing.JTextField diaOpcionesReportes;
    private javax.swing.JTextField direccionIngresarCliente;
    private javax.swing.JTextField direccionSedeCrearTF;
    private javax.swing.JTextField direccionSedeModificarTF;
    private javax.swing.JTextField emailIngresarCliente;
    private javax.swing.JTextField emailSedeCrearTF;
    private javax.swing.JTextField emailSedeModificarTF;
    private javax.swing.JTextField emailUsuarioCrearTF;
    private javax.swing.JTextField emailUsuarioModificarTF;
    private javax.swing.JRadioButton empresaOpcionesReportes;
    private javax.swing.JButton exportarButton;
    private javax.swing.JFrame frameOpcionesReporte;
    private javax.swing.JButton generarReporteButton;
    private javax.swing.JButton generarReporteOpcionesButon;
    private javax.swing.JFrame gerenteJFrame;
    private javax.swing.JPanel gerenteJPanel;
    private javax.swing.JButton gestionPartes;
    private javax.swing.JButton gestionVehiculos;
    private javax.swing.JTextField id_usuarioCrear;
    private javax.swing.JButton ingresarUsuarioBoton;
    private javax.swing.JFrame ingresarUsuarioFrame;
    private javax.swing.JPanel inventarioReportesPanel;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JFrame jefeJFrame;
    private javax.swing.JLabel labelCantidadConsultarOrden;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel3;
    private javax.swing.JLabel logoLabel4;
    private javax.swing.JPanel manejoOrdenesJPanel;
    private javax.swing.JPanel manejoOrdenesJPanel1;
    private javax.swing.JPanel manejoOrdenesJPanel2;
    private javax.swing.JPanel manejoPartes;
    private javax.swing.JPanel manejoReportesJPanel;
    private javax.swing.JPanel manejoSedesJPanel;
    private javax.swing.JPanel manejoUsuariosJPanel;
    private javax.swing.JPanel manejoVehiculos;
    private javax.swing.JTextField mesOpcionesReportes;
    private javax.swing.JRadioButton modificarActivoRB;
    private javax.swing.JTextField modificarCantidadPartesTF;
    private javax.swing.JTextField modificarCodigoUsuarioTF;
    private javax.swing.JTextField modificarCodigoVehiculoTF;
    private javax.swing.JTextField modificarColorVehiculoTF;
    private javax.swing.JPasswordField modificarConfirmarContraseñaTF;
    private javax.swing.JPasswordField modificarContraseñaTF;
    private javax.swing.JRadioButton modificarInactivoRB;
    private javax.swing.JTextField modificarMarcaVehiculoTF;
    private javax.swing.JTextField modificarModeloVehiculoTF;
    private javax.swing.JTextField modificarNombreParteTF;
    private javax.swing.JTextField modificarNombreTF;
    private javax.swing.JTextField modificarParteID;
    private javax.swing.JComboBox<String> modificarParteSedeCB;
    private javax.swing.JButton modificarPartes;
    private javax.swing.JButton modificarSedeButton;
    private javax.swing.JComboBox<String> modificarSedeSedesCB;
    private javax.swing.JComboBox<String> modificarSedeUsuarioCB;
    private javax.swing.JComboBox<String> modificarSedeVehiculoCB;
    private javax.swing.JComboBox<String> modificarTipoUsuarioCB;
    private javax.swing.JButton modificarUsuarioButton;
    private javax.swing.JTextField modificarValorParteTF;
    private javax.swing.JTextField modificarValorVehiculoTF;
    private javax.swing.JRadioButton modificarVehiculoNuevoRB;
    private javax.swing.JRadioButton modificarVehiculoUsadoRB;
    private javax.swing.JButton modificarVehiculos;
    private javax.swing.JTextField nombreIngresarCliente;
    private javax.swing.JTextField nombreSedeTF;
    private javax.swing.JLabel nombreUserLabel;
    private javax.swing.JLabel nombreUserLabel3;
    private javax.swing.JLabel nombreUserLabel4;
    private javax.swing.JTextField nombresCrear;
    private javax.swing.JTextField nuevoNombreTF;
    private javax.swing.JButton ordenesReporteBoton;
    private javax.swing.JPanel ordenesReportePanel;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelAgregarPartes;
    private javax.swing.JPanel panelAgregarVehiculos;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelBanner3;
    private javax.swing.JPanel panelBanner4;
    private javax.swing.JPanel panelConsultarCotizacion;
    private javax.swing.JPanel panelConsultarOrden;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelContIngresarUsuario;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelContenedorJefe;
    private javax.swing.JPanel panelContenedorVendedor;
    private javax.swing.JPanel panelCrearCotizacion;
    private javax.swing.JPanel panelCrearOrden;
    private javax.swing.JPanel panelCrearSede;
    private javax.swing.JPanel panelCrearUsuario;
    private javax.swing.JPanel panelGenerarReportes;
    private javax.swing.JPanel panelGestion;
    private javax.swing.JPanel panelModificarPartes;
    private javax.swing.JPanel panelModificarSede;
    private javax.swing.JPanel panelModificarUsuario;
    private javax.swing.JPanel panelModificarVehiculo;
    private javax.swing.JPanel panelReporte;
    private javax.swing.JPanel panelReporteFinal;
    private javax.swing.JPanel panelVacio;
    private javax.swing.JPanel panelVacio1;
    private javax.swing.JPanel panelVacio2;
    private javax.swing.JPanel panelVender;
    private javax.swing.JTextField parteConsultarOrden;
    private javax.swing.JComboBox<String> parteModificarCB;
    private javax.swing.JTextField passwordCrear;
    private javax.swing.JButton reportePersonal;
    private javax.swing.JPanel reporteUsuariosPanel;
    private javax.swing.JPanel reporteVentasPanel;
    private javax.swing.JTextArea resumenCrearOrdenTA;
    private javax.swing.JLabel salirLabel;
    private javax.swing.JLabel salirLabel1;
    private javax.swing.JLabel salirLabel2;
    private javax.swing.JLabel sedeCargoLabel;
    private javax.swing.JLabel sedeCargoLabel3;
    private javax.swing.JLabel sedeCargoLabel4;
    private javax.swing.JComboBox sedesOpcionesReporte;
    private javax.swing.JRadioButton sedesOpcionesReportes;
    private javax.swing.JRadioButton semanalOpcionesReportes;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTable tableCrearCot;
    private javax.swing.JTable tableCrearCot1;
    private javax.swing.JTextField telefonoIngresarCliente;
    private javax.swing.JTextField telefonoSedeCrearTF;
    private javax.swing.JTextField telefonoSedeModificarTF;
    private javax.swing.JTextField telefonoUsuarioCrearTF;
    private javax.swing.JTextField telefonoUsuarioModificarTF;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JComboBox<String> tipoUsuarioCB;
    private javax.swing.JRadioButton todoOpcionesReportes;
    private javax.swing.JLabel valorTotalConsultarCot;
    private javax.swing.JTextField vehiculoConsultarOrden;
    private javax.swing.JButton vehiculosAgregadosReporteBoton;
    private javax.swing.JComboBox vehiculosDispCrearCot;
    private javax.swing.JComboBox vehiculosDispVender;
    private javax.swing.JButton vehiculosPorSedeBoton;
    private javax.swing.JFrame vendedorJFrame;
    private javax.swing.JPanel vendedorJPanel;
    private javax.swing.JButton venderBuscarCotButton;
    private javax.swing.JButton venderButton;
    private javax.swing.JButton ventaCrearVentaButton;
    private javax.swing.JButton ventasReporteBoton;
    private javax.swing.JTextField yearOpcionesReportes;
    // End of variables declaration//GEN-END:variables

    
}
