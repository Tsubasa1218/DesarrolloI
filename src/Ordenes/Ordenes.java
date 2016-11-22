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
    
    
 
    public boolean generarOrden(String codigoVehiculo, String codigoParte,String codigoJefe,String resumen){

      
               
        String generarSQLemitidas ="insert into ordenes_emitidas(id_usuario,id_vehiculo,id_parte,fecha_emision) values('"+codigoJefe+"',"+codigoVehiculo+","+codigoParte+",'"+objetoOPeraciones.obtenerFecha()+"');";
        
        String generarSQLordenes ="insert into ordenes(resumen_orden) values('"+resumen+"');";

        int orden = objetoBD.insertar(generarSQLordenes);
        int ordenEmitida = objetoBD.insertar(generarSQLemitidas);
        if(orden != 0 && ordenEmitida != 0){
            
            return true;
        }else{
            
            return false;
                
        }
    } 
    
    public String consultarOrden(String id_consulta){
        String consultaSQL = "SELECT resumen_orden FROM ordenes WHERE id_orden = '"+id_consulta+"' ;";
        String consulta = "No encontrada";
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        
        try {
         
                consulta = tabla.getString("resumen_orden");
            
        } catch (SQLException ex) {
            ex.printStackTrace();        
        }
        
        return consulta;
    }

    public String obtenerUltimoCodigoOrden(){
        String consultaSQL = "SELECT last_value FROM ordenes_id_orden_seq;";
        int siguienteId = -1;
        
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        
        try {
            while(tabla.next()){
                siguienteId = tabla.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();        
        }
        
        siguienteId++;
        return ""+siguienteId;
    }
    
}


