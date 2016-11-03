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
 * @author Familia Suaza
 */
public class Usuario {
    
    OperacionesBD operacionesBD;
    
    public Usuario(){
        operacionesBD = new OperacionesBD();
    }
    
    public String validarUsuario(String id_usuario, String password){
        String tipo_usuario = "";
        try { 
            String consultaSQL = "SELECT tipo_usuario FROM usuarios WHERE id_usuario = '" + id_usuario +
                    "' AND password_usuario = '" + password + "';";
            
            ResultSet resultado = operacionesBD.consultas(consultaSQL);
            while(resultado.next()){
                tipo_usuario = resultado.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return tipo_usuario;
    }
    
    public void crearUsuario(String id, String password, String nombre, String tipo,String email, String telefono, String fecha_ingreso, String sede_id){
        String consultaSQL = "INSERT INTO usuarios(id_usuario, password_usuario, nombre_usuario, estado_usuario, email_usuario, telefono_usuario, tipo_usuario, fecha_ingreso_usuario, id_sede)"
                    + " VALUES('" + id +"', '" + password + "', '" + nombre + "', TRUE, '" + email + "', '" + telefono + "', '" + tipo + "', '" + fecha_ingreso + "', '" + sede_id + "');";
        int codigo = operacionesBD.insertar(consultaSQL);
        if(codigo != 0){
            JOptionPane.showMessageDialog(null, "Usuario creado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
