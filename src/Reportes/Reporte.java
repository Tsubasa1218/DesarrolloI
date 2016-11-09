/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
import dataBaseOperations.OperacionesBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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
    Nombre: generarReporteVentasPorSede
    @param: ninguno
    Objetivo: Obtener la cantidad de dinero que ha recaudado cada sede por ventas de vehiculos
    Autor: Juan David Suaza Cruz 1427841
    */
    
    public ChartPanel generarReporteVentasPorSede(){
        String consultaSQL = "";
        
        //SELECT  FROM ventas_vehiculos NATURAL JOIN usuarios NATURAL JOIN vehiculos;
        
        
        return null;
    }
    
}
