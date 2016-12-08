/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizaciones;

import dataBaseOperations.Fachada;
import dataBaseOperations.OperacionesBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Alejandro
 */
public class Cotizaciones {
        OperacionesBD operacionesBD;


 public Cotizaciones(){
        operacionesBD = new OperacionesBD();
    }
    
    public void crearCoti(String id_usuario, String id_vehiculo, String id_comprador, String fecha_cot){
        ResultSet consulta = operacionesBD.consultas("SELECT cantidad_disponible_vehiculo FROM vehiculos WHERE id_vehiculo = " + id_vehiculo + ";");
        
        String consultaSQL = "INSERT INTO cotizaciones_realizadas(id_usuario, id_vehiculo, id_comprador, fecha_cotizacion) "
                    + " VALUES('" + id_usuario + "', " + id_vehiculo + ", '"+ id_comprador + "', '" + fecha_cot +  "');";
        
        String cantidad = "";
        try {
            while(consulta.next()){
                cantidad = consulta.getString(1);
            }
            if(cantidad.equalsIgnoreCase("1")){
                int codigo1 = operacionesBD.insertar(consultaSQL);
               // int codigo2 = operacionesBD.updates("UPDATE vehiculos SET cantidad_disponible_vehiculo = 0 WHERE id_vehiculo = " + id_vehiculo + ";");
                if(codigo1 != 0 ){
                    JOptionPane.showMessageDialog(null, "Cotizacion realizada con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al realizar la cotizacion", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Vehiculo no disponible, consulte la cantidad", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe el vehiculo con id: " + id_vehiculo, "Error", JOptionPane.ERROR_MESSAGE);
            
        }     
    }
    
    public ResultSet consultarCotizacion(String id_cotizacion){
        String consultaSQL = "SELECT nombre_comprador, nombre_usuario, marca_vehiculo, valor_vehiculo FROM cotizaciones_realizadas NATURAL"
                + " JOIN comprador NATURAL JOIN usuarios NATURAL JOIN vehiculos WHERE id_cotizaciones = " + id_cotizacion + ";";
        ResultSet tabla = operacionesBD.consultas(consultaSQL);
        return tabla;
    }
    
    public Date obtenerFechaVencimiento(Date fechaInicial){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicial);
        cal.add(Calendar.DATE, 30);
        
        String output = sdf.format(cal.getTime());
        System.out.println(sdf.format(fechaInicial));
        System.out.println(output);
        Date fechaFinal = cal.getTime();
        return fechaFinal;
    }
    
    public void generarFactura(int id_cot, double valor_Total, Date fecha){
        
        try {
            JasperReport jasperReport=JasperCompileManager.compileReport("C:\\Users\\Familia Suaza\\Documents\\NetBeansProjects\\Desarrollo\\DesarrolloI\\src\\Cotizaciones\\cotizacion.jrxml");
            HashMap map = new HashMap();
            Connection conn = new Fachada().conectarBD();
            System.out.println(""+id_cot);
            int id = id_cot;
            double valor = valor_Total;
            Date fechaValidez = fecha;
            map.put("numero_factura", id);
            map.put("valor_total", valor);
            map.put("fechaValida", fechaValidez);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
            //JasperViewer.viewReport(jasperPrint); 
            String filename=null;
            filename="cotizacion"+id_cot+".pdf";

        //Report saved in specified path
            JasperExportManager.exportReportToPdfFile(jasperPrint,filename);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public String buscarUltimoCodigo(){
        String consultaSQL = "SELECT last_value FROM cotizaciones_realizadas_id_cotizaciones_seq;";
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
}