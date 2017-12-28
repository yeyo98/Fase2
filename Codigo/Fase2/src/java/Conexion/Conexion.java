package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mi pc
 */
public class Conexion {
    
    private static String username = "root";
    private static String passw="";
    private static String host = "localhost";
    private static String port = "3306";
    private static String database = "warlock_soft";
    private static String classname = "com.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://"+host+":"+port+"/"+database;
    
    public Connection getConexion(){
        Connection con=null;
        try {
            //aqui se instancia el driver de la base de datos
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            //en esta clase se realiza la coneccion a la base de datos
            con= DriverManager.getConnection(url,username,passw);
            
        } catch (Exception e) {
        }     
       return con; 
    }
    
}
