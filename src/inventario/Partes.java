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
public class Partes {
    OperacionesBD operacionesBD;
    
    public Partes(){
        operacionesBD = new OperacionesBD();
    }
    
    public void agregarPartes(String nombre_parte, String estado_parte, String cantidad_parte, String id_sede_parte){      
        String consultaSQL = "INSERT INTO vehiculos(nombre_parte, modelo_vehiculo, color_vehiculo, nuevo_vehiculo, estado_vehiculo, cantidad_disponible_vehiculo, id_sede_vehiculo)"
                    + " VALUES('" + nombre_parte + "', '" + estado_parte + "',  '" + cantidad_parte + "',  '" + cantidad_parte + "', '" + id_sede_parte +  "');";
        int codigo = operacionesBD.insertar(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Parte añadida con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        
        }       
    }
    
    public void modificarParte(String id_parte, String nombre_parte, String cantidad_parte, String valor_parte, String id_sede){
            String consultaSQL = "UPDATE vehiculos SET "
                    + "nombre_parte = '" + nombre_parte + "', "
                    + "cantidad_parte = '" + cantidad_parte + "', "
                    + "valor_parte = '" + valor_parte + "', "
                    + "id_sede = '" + id_sede + "' "
                    + " WHERE id_vehiculo = '" + id_parte + "';";
        int codigo = operacionesBD.updates(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Parte modificado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
}
