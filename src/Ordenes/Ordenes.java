/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenes;

import dataBaseOperations.OperacionesBD;
import interfazGrafica.Operaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Ordenes {
    
    OperacionesBD objetoBD;
    Operaciones objetoOPeraciones;


    public Ordenes() {
        objetoBD = new OperacionesBD();
        objetoOPeraciones = new Operaciones();
    }
    
    
 
    public boolean generarOrden(String codigoVehiculo, String codigoParte,String codigoJefe,String resumen, int cantidad){
        String consultaSQL = "SELECT cantidad_parte FROM partes WHERE id_parte = " + codigoParte + ";";
        ResultSet tablaCantidad = objetoBD.consultas(consultaSQL);
        try {
            while (tablaCantidad.next()) {
                if (tablaCantidad.getInt(1) >= cantidad) {
                    String generarSQLemitidas = "insert into ordenes_emitidas(id_usuario,id_vehiculo,id_parte,fecha_emision, resumen_orden, cantidad) values('" + codigoJefe + "'," + codigoVehiculo + "," + codigoParte + ",'"
                            + objetoOPeraciones.obtenerFecha() + "', '" + resumen + "', " + cantidad + ");";

                    int ordenEmitida = objetoBD.insertar(generarSQLemitidas);
                    if (ordenEmitida != 0) {
                        int nuevaCantidad = tablaCantidad.getInt(1) - cantidad;
                        consultaSQL = "UPDATE partes SET cantidad_parte = " + nuevaCantidad + " WHERE id_parte = " + codigoParte + ";";
                        objetoBD.updates(consultaSQL);
                        return true;                  
                    }else {
                        return false;

                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No hay tantas existencias\nVerifica la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return false;
    }    

    public ResultSet consultarOrden(String id_consulta){
        String consultaSQL = "SELECT marca_vehiculo, nombre_parte, resumen_orden, cantidad FROM ordenes_emitidas AS OE NATURAL JOIN partes INNER JOIN vehiculos AS V ON OE.id_vehiculo = V.id_vehiculo  WHERE id_orden = "+id_consulta+" ;";
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
            
        return tabla;
    }

    public String obtenerUltimoCodigoOrden(){
        String consultaSQL = "SELECT last_value FROM ordenes_emitidas_id_orden_seq;";
        int siguienteId = -1;
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        
        try {
            while(tabla.next()){
                siguienteId = tabla.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();        
        }
        if(siguienteId != 1)
            siguienteId++;
        return ""+siguienteId;
    }
    
}


