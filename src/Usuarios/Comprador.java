/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import dataBaseOperations.OperacionesBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juanjose
 */
public class Comprador {
    OperacionesBD operacionesBD;
    
    public Comprador(){
        operacionesBD = new OperacionesBD();
        
    }
    
    public void crearComprador(String id_comprador, String nombre_comprador, String direccion_comprador, String telefono_comprador ,String email_comprador){
        String consultaSQL = "INSERT INTO comprador(id_comprador, nombre_comprador, direccion_comprador, telefono_comprador, email_comprador)"
                    + " VALUES('" + id_comprador +"', '" + nombre_comprador +"', '" + direccion_comprador + "', '" + telefono_comprador + "', '" + email_comprador + "');";
        int codigo = operacionesBD.insertar(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Comprador creado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public boolean existeComprador(String id_comprador){
        
        try {
            ResultSet existe = operacionesBD.consultas("SELECT * FROM comprador WHERE id_comprador = '" + id_comprador + "';");
            //System.out.println("inicio existe");
            boolean bool = existe.next();
            //System.out.println(bool);
            return bool;
        } catch (SQLException ex) {
            Logger.getLogger(Comprador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
