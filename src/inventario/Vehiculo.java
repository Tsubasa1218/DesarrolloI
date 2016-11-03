/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import dataBaseOperations.OperacionesBD;
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
    
    public void agregarVehiculo(String marca_vehiculo, String modelo_vehiculo, String color_vehiculo, String nuevo_vehiculo, String cantidad_disponible, String id_sede){
        String consultaSQL = "INSERT INTO vehiculos(marca_vehiculo, modelo_vehiculo, color_vehiculo, nuevo_vehiculo, cantidad_disponible_vehiculo, id_sede)"
                    + " VALUES('" + marca_vehiculo + "', '" + modelo_vehiculo + "',  '" + color_vehiculo + "',  '" + cantidad_disponible + "',  '" + id_sede + "');";
        int codigo = operacionesBD.insertar(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Vehículo añadido con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void modificarVehiculo(String id_vehiculo, String marca_vehiculo, String modelo_vehiculo, String color_vehiculo, String nuevo_vehiculo, String estado_vehiculo, String cantidad_disponible, String id_sede){
            
            String consultaSQL = "UPDATE vehiculos SET "
                    + "modelo_vehiculo = '" + modelo_vehiculo + "' "
                    + "color_vehiculo = '" + color_vehiculo + "' "
                    + "nuevo_vehiculo = '" + nuevo_vehiculo + "' "
                    + "estado_vehiculo = " + estado_vehiculo + " "                 
                    + "id_sede_vehiculo = '" + id_sede
                    + " WHERE id_vehiculo = '" + id_vehiculo + "';";
        int codigo = operacionesBD.insertar(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Vehículo modificado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
