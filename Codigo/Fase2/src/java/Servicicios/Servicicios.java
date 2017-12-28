/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicicios;

import Conexion.Acciones;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author mi pc
 */
@WebService(serviceName = "Servicicios")
public class Servicicios {

    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
    @WebMethod(operationName = "Agregar_Usuario")
    public String Agregar_Usuario(@WebParam(name = "cod") int cod,@WebParam(name = "nombre") String nombre,@WebParam(name = "correo") String correo,
                                @WebParam(name = "nacimiento") String nac,@WebParam(name = "Contraseña") String contra,@WebParam(name = "nickname") String nick) {
        boolean cond=true;
        Acciones po = new Acciones();
        try{
             cond = po.Registrarse(cod, nombre, correo, nac, contra, nick);
//            return "Se ingreso correctamente";
        }catch(Exception e){
//            return "No se ingreso correctamente";
        }
        return "Seingreso: " +cond + " !";
    }
    
    @WebMethod(operationName = "Login")
    public boolean Login(@WebParam(name = "correo") String correo,@WebParam(name = "contraseña") String contra) {
        boolean cond=true;
        Acciones po = new Acciones();
        try{
        cond = po.Login(correo, contra);
        }catch(Exception e){
            cond=false;
        }
        return cond;
    }
    
     @WebMethod(operationName = "Agregar_estado")
     public void Agregar_estado(@WebParam(name = "Agregar_estado") String estado) {
        String cond="";
        Acciones po = new Acciones();
        try{
             po.Estado(estado);
//            return "Se ingreso correctamente";
        }catch(Exception e){
//            return "No se ingreso correctamente";
        }
//        return "Seingreso: " +cond + " !";
    }
    
    @WebMethod(operationName = "Publicar_Estado")
    public String Publicar_Estado() {
        String cond="";
        Acciones po = new Acciones();
        try{
        cond = po.Obtener_estados();
        }catch(Exception e){
            cond="";
        }
        return cond;
    }
    
    
}
