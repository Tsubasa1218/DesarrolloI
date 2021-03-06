/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import dataBaseOperations.OperacionesBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juanjose
 */
public class Vehiculo {
    
    OperacionesBD operacionesBD;
    
    public Vehiculo(){
        operacionesBD = new OperacionesBD();
    }
    
    public int agregarVehiculo(String marca_vehiculo, String modelo_vehiculo, String color_vehiculo, String nuevo_vehiculo, String cantidad_disponible, float valor_vehiculo, String fecha_adicion_vehiculo, String id_sede){
        String consultaSQL = "INSERT INTO vehiculos(marca_vehiculo, modelo_vehiculo, color_vehiculo, nuevo_vehiculo, cantidad_disponible_vehiculo, valor_vehiculo, fecha_adicion_vehiculo, id_sede)"
                    + " VALUES('" + marca_vehiculo + "', '" + modelo_vehiculo + "',  '" + color_vehiculo + "',  '" + nuevo_vehiculo + "',  '"  + cantidad_disponible + "',  '" + valor_vehiculo + "',  '" + fecha_adicion_vehiculo + "',  '" + id_sede + "');";
        int codigo = operacionesBD.insertar(consultaSQL);
        return codigo;
    }
    
    public int modificarVehiculo(String id_vehiculo, String marca_vehiculo, String modelo_vehiculo, String color_vehiculo, String nuevo_vehiculo, float valor_vehiculo,  String id_sede){
            String consultaSQL = "UPDATE vehiculos SET "
                    + "marca_vehiculo = '" + marca_vehiculo + "', "
                    + "modelo_vehiculo = '" + modelo_vehiculo + "', "
                    + "color_vehiculo = '" + color_vehiculo + "', "
                    + "nuevo_vehiculo = '" + nuevo_vehiculo + "', "
                    //+ "cantidad_disponible_vehiculo = '" + cantidad_disponible_vehiculo + "', "                 
                    + "valor_vehiculo = " + valor_vehiculo + ", "
                    //+ "fecha_adicion_vehiculo = '" + fecha_adicion_vehiculo + "', "
                    + "id_sede = " + id_sede + " "
                    + " WHERE id_vehiculo = " + id_vehiculo + ";";
        int codigo = operacionesBD.updates(consultaSQL);
        return codigo;
    }
    
    public double valorVehiculoIVA(String id_vehiculo){
        String consultaSQL = "SELECT valor_vehiculo FROM vehiculos WHERE id_vehiculo = " + id_vehiculo + ";";
        ResultSet valor = operacionesBD.consultas(consultaSQL);
        double valorVehiculo = 0.0;
        try{
            while(valor.next()){
                valorVehiculo = valor.getDouble(1);
                valorVehiculo = valorVehiculo + valorVehiculo*0.16;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return valorVehiculo;
    }
    
}
