/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
import dataBaseOperations.OperacionesBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import interfazGrafica.Operaciones;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Juan Suaza
 */
public class Reporte {
    
    public Reporte(){
        
    }
    
    /*
    Nombre: generarReportePersonal
    @param: ninguno
    Objetivo: Obtener la informacion de la base de datos, relacionada con la cantidad de empleados por sede y mostrarla en un grafico
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReportePersonal(){
        //Consulta SQL  de la cantidad de trabajadores que hay en cada sede
        String consultaSQL = "SELECT DISTINCT sedes.nombre_sede, COUNT(id_sede) FROM usuarios NATURAL JOIN sedes GROUP BY sedes.nombre_sede;";
        String[] nombresSedes;
        int[] cantidadEmpleados;
        int filas = 0;
        
        //Obtencion de la consulta
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        
        //Cuenta cuantas filas hay en la consulta
        try {
            while(tabla.next()){
                filas++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //Inicializacion de los arrays
        nombresSedes = new String[filas];
        cantidadEmpleados = new int[filas];
        
        //Consulta nuevamente
        tabla = new OperacionesBD().consultas(consultaSQL);
        filas = 0;
        
        //Llenado de los arreglos
        try {
            while(tabla.next()){
                nombresSedes[filas] = tabla.getString(1);
                cantidadEmpleados[filas] = tabla.getInt(2);
                filas++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //Inicializacion del buffer donde se guardan la informacion
        //para usarse en el grafico
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        //Llenado de la informacion de las sedes que tienen empleados
        for (int i = 0; i < nombresSedes.length; i++) {
            data.setValue((double)cantidadEmpleados[i], "Empleados por sede", nombresSedes[i]);
        }
        
        //Consulta de las sedes que no tienen empleados
        consultaSQL = "SELECT nombre_sede FROM sedes EXCEPT SELECT DISTINCT sedes.nombre_sede FROM usuarios NATURAL JOIN sedes;";
        tabla = new OperacionesBD().consultas(consultaSQL);
        try {
            while(tabla.next()){
                data.setValue(0.0, "Empleados por sede", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //Construccion del panel con el grafico a partir de la informacion
        ChartPanel panel = new BarChart().reporteEmpleados(data);
        return panel;
    }
    
    
    /*
    Nombre: generarReporteAportePorSede
    @param: ninguno
    Objetivo: Obtener la cantidad de dinero que ha recaudado cada sede por ventas de vehiculos
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteAportePorSede(){
        String consultaSQL = "SELECT nombre_sede, SUM(valor_vehiculo) FROM ventas_vehiculos NATURAL JOIN vehiculos NATURAL JOIN sedes GROUP BY nombre_sede;";
        String[] nombreSedes;
        float[] valorVentas;
        int filas = 0;
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        try {
            while(tabla.next()){
                filas++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        nombreSedes = new String[filas];
        valorVentas = new float[filas];
        
        tabla = new OperacionesBD().consultas(consultaSQL);
        filas = 0;
        try {
            while(tabla.next()){
                nombreSedes[filas] = tabla.getString(1);
                valorVentas[filas] = tabla.getFloat(2);
                filas++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 0; i < nombreSedes.length; i++) {
            data.setValue((double)valorVentas[i], "Aporte por sede", nombreSedes[i]);
        }
        
        ChartPanel panel = new BarChart().reporteAportesVentas(data);
        return panel;
    }
    
    /*
    Nombre: generarReporteCantidadVehiculos
    @param: ninguno
    Objetivo: Obtener la cantidad de vehiculos que posee cada sede 
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteCantidadVehiculos(){
        String consultaSQL = "SELECT nombre_sede, COUNT(id_sede) FROM vehiculos NATURAL JOIN sedes WHERE cantidad_disponible_vehiculo = 1 GROUP BY nombre_sede;";        
        String[] nombreSedes;
        int[] cantidadVehiculos;
        int filas = 0;
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        try {
            while(tabla.next()){
                filas++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        nombreSedes = new String[filas];
        cantidadVehiculos = new int[filas];
        
        tabla = new OperacionesBD().consultas(consultaSQL);
        filas = 0;
        try {
            while(tabla.next()){
                nombreSedes[filas] = tabla.getString(1);
                cantidadVehiculos[filas] = tabla.getInt(2);
                filas++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 0; i < nombreSedes.length; i++) {
            data.setValue((double)cantidadVehiculos[i], "Cantidad de vehiculos/sede", nombreSedes[i]);
        }
        
        consultaSQL = "SELECT nombre_sede FROM sedes EXCEPT SELECT nombre_sede FROM vehiculos NATURAL JOIN sedes;";
        tabla  = new OperacionesBD().consultas(consultaSQL);
        try {
            while(tabla.next()){
                data.setValue(0.0, "Cantidad de vehiculos/sede", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ChartPanel panel = new BarChart().reporteCantidadVehiculosPorSede(data);
        return panel;
    }
    
    /*
    Nombre: generarReporteCotizacionesSede
    @param: Date, String
    Objetivo: Obtener la cantidad de cotizaciones que ha hehco cada empleado en la sede
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteCotizacionesSede(Date fechaInicio, String codigoSede){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Operaciones oper = new Operaciones();        
        Date fechaFinal = oper.aumentarFecha(fechaInicio);
        
        String fechaI = sdf.format(fechaInicio);
        String fechaF = sdf.format(fechaFinal);
        
        System.out.println(fechaI);
        System.out.println(fechaF);
        
        String consultaSQL = "SELECT usuarios.nombre_usuario, COUNT(usuarios.id_usuario) FROM cotizaciones_realizadas NATURAL JOIN usuarios WHERE id_sede = " + codigoSede +
                "AND fecha_cotizacion BETWEEN '" + fechaI +"' AND '" + fechaF + "' GROUP BY usuarios.nombre_usuario;";
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        try {
            while(tabla.next()){
                data.setValue(tabla.getInt(2), "Cantidad de cotizaciones/vendedor", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        consultaSQL = "SELECT usuarios.nombre_usuario FROM usuarios WHERE tipo_usuario LIKE 'Vendedor' AND id_sede = " + codigoSede 
                + "EXCEPT SELECT usuarios.nombre_usuario FROM cotizaciones_realizadas NATURAL JOIN usuarios WHERE id_sede = " + codigoSede + 
                " AND fecha_cotizacion BETWEEN '" + fechaI +"' AND '" + fechaF + "';";
        
        ChartPanel panel = new BarChart().reporteCantidadCotizacionesSede(data);
        
        return panel;
    }
    
    /*
    Nombre: generarReporteCotizacionesSedeAll
    @param: int
    Objetivo: Obtener la cantidad de cotizaciones que han hecho los vendedores de una sede
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteCotizacionesSedeAll(String codigoSede){
                
        String consultaSQL = "SELECT usuarios.nombre_usuario, COUNT(usuarios.id_usuario) FROM cotizaciones_realizadas NATURAL JOIN usuarios WHERE id_sede = " + codigoSede +
                 " GROUP BY usuarios.nombre_usuario;";
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        try {
            while(tabla.next()){
                data.setValue(tabla.getInt(2), "Cantidad de cotizaciones/vendedor", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        consultaSQL = "SELECT usuarios.nombre_usuario FROM usuarios WHERE tipo_usuario LIKE 'Vendedor' AND id_sede = " + codigoSede 
                + "EXCEPT SELECT usuarios.nombre_usuario FROM cotizaciones_realizadas NATURAL JOIN usuarios WHERE id_sede = " + codigoSede +";";
        
        tabla = new OperacionesBD().consultas(consultaSQL);
        try {
            while(tabla.next()){
                data.setValue(0.0, "Cantidad de cotizaciones/vendedor", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ChartPanel panel = new BarChart().reporteCantidadCotizacionesSede(data);
        
        return panel;
    }
    
    /*
    Nombre: generarReporteCotizacionesEmpresa
    @param: Date
    Objetivo: Obtener la cantidad de cotizaciones que se han hecho en las sedes a partir de determinada fecha
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteCotizacionesEmpresa(Date fechaInicio){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Operaciones oper = new Operaciones();        
        Date fechaFinal = oper.aumentarFecha(fechaInicio);
        
        String fechaI = sdf.format(fechaInicio);
        String fechaF = sdf.format(fechaFinal);
        
       // System.out.println(fechaI);
        //System.out.println(fechaF);
        
        String consultaSQL = "SELECT sedes.nombre_sede,COUNT(sedes.nombre_sede) FROM cotizaciones_realizadas NATURAL JOIN usuarios NATURAL JOIN sedes WHERE fecha_cotizacion BETWEEN '"
                + fechaI + "' AND '" + fechaF + "' GROUP BY sedes.nombre_sede;";
        //System.out.println(consultaSQL);
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        try {
            while(tabla.next()){
                data.setValue(tabla.getInt(2), "Cantidad de cotizaciones/sede", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        consultaSQL = "SELECT sedes.nombre_sede FROM sedes EXCEPT SELECT sedes.nombre_sede FROM cotizaciones_realizadas NATURAL JOIN usuarios NATURAL JOIN sedes WHERE fecha_cotizacion BETWEEN '"
                + fechaI + "' AND '" + fechaF + "';";
        
        try {
            while(tabla.next()){
                data.setValue(0.0, "Cantidad de cotizaciones/sede", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ChartPanel panel = new BarChart().reporteCantidadCotizacionesEmpresa(data);
        
        return panel;
    }
    
    /*
    Nombre: generarReporteCotizacionesEmpresaAll
    @param: ninguno
    Objetivo: Obtener la cantidad de cotizaciones que se han hecho en las sedes
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteCotizacionesEmpresaAll(){
                
        String consultaSQL = "SELECT sedes.nombre_sede,COUNT(sedes.nombre_sede) FROM cotizaciones_realizadas NATURAL JOIN usuarios NATURAL JOIN sedes GROUP BY sedes.nombre_sede;";
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        try {
            while(tabla.next()){
                data.setValue(tabla.getInt(2), "Cantidad de cotizaciones/sede", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        consultaSQL = "SELECT sedes.nombre_sede FROM sedes EXCEPT SELECT sedes.nombre_sede FROM cotizaciones_realizadas NATURAL JOIN usuarios NATURAL JOIN sedes;";
        tabla = new OperacionesBD().consultas(consultaSQL);
        
        try {
            while(tabla.next()){
                data.setValue(0.0, "Cantidad de cotizaciones/sede", tabla.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ChartPanel panel = new BarChart().reporteCantidadCotizacionesEmpresa(data);
        
        return panel;
    }
}
