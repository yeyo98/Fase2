package Conexion;


import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mi pc
 */
public class Acciones {
    
    public boolean Registrarse(int cod, String nombre, String correo, String nacimiento,String contra, String nick){
     boolean cond=true;
        try{
            Connection miConexion=new Conexion().getConexion();
            
            Statement miStatement = miConexion.createStatement();
            
            String instruccionsql="INSERT INTO USUARIO(COD_USER,NOMBRE,CORREO,NACIMIENTO,CONTRASEÑA,NICKNAME) "
                    + "VALUES ('"+cod+"','"+nombre+"','"+correo+"','"+nacimiento+"','"+contra+"','"+nick+"')";
            
            miStatement.executeUpdate(instruccionsql);
            
            miStatement.close();
            
            System.out.println("Datos insertados correctamente");
            
        }catch(Exception e){
            cond=false;
            System.out.println("NO CONECTA!!");
            e.printStackTrace();
        }
        return cond;
    }
    
    public boolean Login(String correo,String contraseña){
      boolean cond=false;
      
         try{
            Connection miConexion=new Conexion().getConexion();
            
            Statement miStatement = miConexion.createStatement();
            
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM USUARIO");
//            miStatement.executeUpdate(instruccionsql);
            
            while(miResultSet.next()){
                if(miResultSet.getString("CORREO").equals(correo) && miResultSet.getString("CONTRASEÑA").equals(contraseña)){
                    cond=true;
                    break;
                }else{
//                    System.out.println("NO HAY!!");
                }
            }
            miStatement.close();
        }catch(Exception e){
            cond=false;
            System.out.println("NO CONECTA!!");
            e.printStackTrace();
        }
         return cond;
    }
    
    public String Obtener_nombre(String correo){
    String cond="";
      
         try{
            Connection miConexion=new Conexion().getConexion();
            
            Statement miStatement = miConexion.createStatement();
            
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM USUARIO");
//            miStatement.executeUpdate(instruccionsql);
            
            while(miResultSet.next()){
                if(miResultSet.getString("CORREO").equals(correo)){
                    cond=miResultSet.getString("NOMBRE");
                    break;
                }else{
//                    System.out.println("NO HAY!!");
                }
            }
         }catch(Exception e){
            cond="";
            System.out.println("NO CONECTA!!");
            e.printStackTrace();
        }
         return cond;
    }
    
    public boolean Estado(String estado){
     boolean cond=true;
        try{
            Connection miConexion=new Conexion().getConexion();
            
            Statement miStatement = miConexion.createStatement();
            
            String instruccionsql="INSERT INTO ESTADO(ESTADOS) "
                    + "VALUES ('"+estado+"')";
            
            miStatement.executeUpdate(instruccionsql);
            
            miStatement.close();
            
            System.out.println("Datos insertados correctamente");
            
        }catch(Exception e){
            cond=false;
            System.out.println("NO CONECTA!!");
            e.printStackTrace();
        }
        return cond;
    }
    
     public String Obtener_estados(){
         String[] cadena= new String[200];
         String cond="";
         int cont=0;
      
         try{
            Connection miConexion=new Conexion().getConexion();
            
            Statement miStatement = miConexion.createStatement();
            
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM ESTADO");
//            miStatement.executeUpdate(instruccionsql);
            
            while(miResultSet.next()){
                    cadena[cont]=miResultSet.getString("ESTADOS");
                    cont++;
//                    cond+=miResultSet.getString("ESTADOS")+";";
            }
            
            for(int i=cadena.length;0<=i-1;i--){ 
                if(cadena[i-1] != null){
                cond+=cadena[i-1]+";";
                }
            }
            
         }catch(Exception e){
            cond="";
            System.out.println("NO CONECTA!!");
            e.printStackTrace();
        }
         return cond;
    }
    
    
}
