package dataBaseOperations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author juandasc
 */
public class Fachada {
    private final String usuario, url, password;
    private Connection conexion;
    //Constructor
    public Fachada(){
        this.usuario = "Juan";
        this.password = "1218";
        this.url = "jdbc:postgresql://localhost:5432/desarrollo";
    }
    
    public Connection conectarBD(){
        //Creamos la conexion con la BD
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println( "Driver Cargado" );
        }catch(Exception e){
            System.out.println( "No se pudo cargar el driver."+e );
        }
              
        try{
            //Obtenemos la conexion
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println( "Conexion Abierta" );
            return conexion;
        } catch( Exception e ) {
            System.out.println( "No se pudo abrir."+e );
            return null;
        }
        
    }//fin metodo conectarABD
    
    public void cerrarConexion(Connection c){
            try{
                //Cerramos la conexion 
                c.close();
            } catch( Exception e ) {
                System.out.println( "No se pudo cerrar." );
            }
        }//fin metodo cerrarConexion
}
