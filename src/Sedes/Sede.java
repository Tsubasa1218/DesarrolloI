/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sedes;

import dataBaseOperations.OperacionesBD;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author juanjose
 */
public class Sede {
    OperacionesBD operaciones;
    
    public Sede(){
        operaciones = new OperacionesBD();
    }
    
    
    public void agregarSede(String nombre_sede, String direccion, String telefono, String email){      
        String consultaSQL = "INSERT INTO sedes(nombre_sede, direccion_sede, telefono_sede, email_sede)"
                    + " VALUES('" + nombre_sede + "', '" + direccion + "', '" + telefono + "', '" +
                    email + "');";
        int codigo = operaciones.insertar(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Sede agregada con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        
        }   
    }
    
    public void modificarSede(String id_sede, String nombre_sede, String direccion, String telefono, String email){
        String consultaSQL = "UPDATE sedes SET nombre_sede = '" + nombre_sede + "', direccion_sede = '" + direccion + "', telefono_sede = '" + telefono + 
                "', email_sede = '" + email + "' WHERE id_sede = '" + id_sede + "';"; 
        int codigo = operaciones.updates(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Sede modificada con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public ResultSet sedes(){
        String consultaSQL = "SELECT * FROM sedes;";
        ResultSet tabla = operaciones.consultas(consultaSQL);
        return tabla;
    }
}
