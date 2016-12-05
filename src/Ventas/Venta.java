/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import dataBaseOperations.Fachada;
import dataBaseOperations.OperacionesBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author juanjose
 */
public class Venta {
    OperacionesBD operacionesBD;
    
    public Venta(){
        operacionesBD = new OperacionesBD();
    }
    
    public void crearVenta(String id_usuario, String id_vehiculo, String id_comprador, String fecha_venta){
        ResultSet consulta = operacionesBD.consultas("SELECT cantidad_disponible_vehiculo FROM vehiculos WHERE id_vehiculo = " + id_vehiculo + ";");
        
        String consultaSQL = "INSERT INTO ventas_vehiculos(id_usuario, id_vehiculo, id_comprador, fecha_venta)"
                    + " VALUES('" + id_usuario + "', " + id_vehiculo + ", '"+ id_comprador + "', '" + fecha_venta +  "');";
        
        String cantidad = "";
        try {
            while(consulta.next()){
                cantidad = consulta.getString(1);
            }
            if(cantidad.equalsIgnoreCase("1")){
                int codigo1 = operacionesBD.insertar(consultaSQL);
                int codigo2 = operacionesBD.updates("UPDATE vehiculos SET cantidad_disponible_vehiculo = 0 WHERE id_vehiculo = " + id_vehiculo + ";");
                if(codigo1 != 0 && codigo2 != 0){
                    JOptionPane.showMessageDialog(null, "Venta realizada con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al realizar la venta", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Vehiculo no disponible, consulte la cantidad", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe el vehiculo con id: " + id_vehiculo, "Error", JOptionPane.ERROR_MESSAGE);
            
        }     
    }
    
    public ResultSet buscarCotizacion(String codigoCotizacion){
        ResultSet consulta = operacionesBD.consultas("SELECT * FROM cotizaciones_realizadas WHERE id_cotizaciones = '" + codigoCotizacion + "';");
        return consulta;
    }
    
    public String buscarUltimoCodigo(){
        String consultaSQL = "SELECT last_value FROM ventas_vehiculos_id_venta_seq;";
        int last_value = 0;
        ResultSet tabla = operacionesBD.consultas(consultaSQL);
        
        try{
            while(tabla.next()){
                last_value = tabla.getInt(1);
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        if(last_value == 1){
            return "" + last_value;
        }else{
            return "" + ++last_value;
        }
        
    }
    
    
    public void generarFactura(int id_venta, double valor_Total){
        
        try {
            JasperReport jasperReport=JasperCompileManager.compileReport("C:\\Users\\Juan Suaza\\Documents\\GitHub\\DesarrolloI-master\\src\\Ventas\\facturaVenta.jrxml");
            HashMap map = new HashMap();
            Connection conn = new Fachada().conectarBD();
            System.out.println(""+id_venta);
            int id = id_venta;
            double valor = valor_Total;
            map.put("numero_factura", id);
            map.put("valor_total", valor);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
            //JasperViewer.viewReport(jasperPrint); 
            String filename=null;
            filename="C:\\Users\\Juan Suaza\\Documents\\GitHub\\DesarrolloI-master\\Facturas\\facturaVenta"+id_venta+".pdf";

        //Report saved in specified path
            JasperExportManager.exportReportToPdfFile(jasperPrint,filename);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
