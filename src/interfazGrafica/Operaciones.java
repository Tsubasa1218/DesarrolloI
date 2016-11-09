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
    /*
    Nombre: agregarItemCombo
    @param: ResultSet, &JComboBox
    Objetivo: Agregar los elementos de un resultadop de una consulta con una sola columna a un
                combo box
    Autor: Juan David Suaza Cruz
    */
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
    
    /*
    Nombre: codigoSedeDeNombre
    @param: String
    Objetivo: conocer el codigo de una sede a partir de su nombre
    Autor: Juan David Suaza Cruz
    */
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
    
    /*
    Nombre: obtenerFecha
    @param: Ninguno
    Objetivo: Obtener la fecha del computador en el que se ejecuta el aplicativo
    Autor: Juan David Suaza Cruz
    */
    public String obtenerFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String fecha_ingreso_usuario = dateFormat.format(date);
        String fecha[] = fecha_ingreso_usuario.split("/");
        return fecha[0] + "-" + fecha[1] + "-" + fecha[2];
    }
    
    /*
    Nombre: obtenerUltimoCodigoSede
    @param: Ninguno
    Objetivo: Obtener el ultimo valorr almacenado en la sequencia que asigna los valores a los ids de las sedes
    Autor: Juan David Suaza Cruz
    */
    public String obtenerUltimoCodigoSede(){
        String consultaSQL = "SELECT last_value FROM sedes_id_sede_seq;";
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
    
    /*
    Nombre tieneGerente
    @param: String 
    Objetivo: Conocer si una sede que pertenece al sistema tiene al menos un empleado gerente
    Autor: Juan David Suaza Cruz
    */
    public boolean tieneGerente(String nombre_sede){
        String consultaSQL = "SELECT id_usuario FROM usuarios NATURAL JOIN sedes WHERE tipo_usuario LIKE 'Gerente' AND estado_usuario = TRUE AND nombre_sede LIKE '" + nombre_sede + "';";
        ResultSet tabla = new OperacionesBD().consultas(consultaSQL);
        int tiene = 0;
        
        try {
            while(tabla.next()){
                tiene++;
            }
            //System.out.println(""+tiene);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(tiene != 0){
            return true;
        }
        
        return false;
    }
}
