package dataBaseOperations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author juandasc
 */
public class OperacionesBD {

    //Variables que usan las conexiones
    Fachada fachada;
    Statement instruccion;
    ResultSet consulta;

    //Constructor
    public OperacionesBD() {
        fachada = new Fachada();
    }
    
    public ResultSet consultas(String consultaSQL) {
        try {
            Connection con = fachada.conectarBD();
            //se crea la instruccion que inserta el tema
            instruccion = con.createStatement();
            

            //se ejecuta la instruccion
            consulta = instruccion.executeQuery(consultaSQL);
            
            fachada.cerrarConexion(con);
                        
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }
        return consulta;
    }
    
    
    public int insertar(String consultaSQL){
        int codigo = 0;
        try{
            Connection con = fachada.conectarBD();
            instruccion = con.createStatement();
            codigo = instruccion.executeUpdate(consultaSQL);          
            fachada.cerrarConexion(con);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos", "Error!", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }
        return codigo;      
    }
    public int updates(String consultaSQL){
        int codigo = 0;
        try{
            Connection con = fachada.conectarBD();
            instruccion = con.createStatement();
            codigo = instruccion.executeUpdate(consultaSQL);          
            fachada.cerrarConexion(con);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos", "Error!", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }
        return codigo;
    }
}
    