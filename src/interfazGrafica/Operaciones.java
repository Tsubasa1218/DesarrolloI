/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import dataBaseOperations.OperacionesBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Suaza
 */
public class Operaciones {
    
    public Operaciones(){
        
    }
    
    public void agregarItemCombo(ResultSet resultado, javax.swing.JComboBox combo){
        combo.removeAllItems();
        try {
            while (resultado.next()){
                combo.addItem(resultado.getString(1));
            }
            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(loginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String codigoSedeDeNombre(String nombre_sede) {
        System.out.println(nombre_sede);
        String consultaSQL = "SELECT id_sede FROM sedes WHERE nombre_sede LIKE '" + nombre_sede + "';";
        System.out.println(consultaSQL);
        String id = "";
        OperacionesBD op = new OperacionesBD();
        ResultSet resultado = op.consultas(consultaSQL);
         try {
            while(resultado.next()){
                id = resultado.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe la sede con nombre: " + nombre_sede, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    
    public String obtenerFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String fecha_ingreso_usuario = dateFormat.format(date);
        String fecha[] = fecha_ingreso_usuario.split("/");
        return fecha[0] + "-" + fecha[1] + "-" + fecha[2];
    }
    
}
