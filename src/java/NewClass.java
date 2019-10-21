
import Entidades.Conexion;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cetecom
 */
public class NewClass {
    
    public static void main(String[] args) {
        
        Conexion conn = new Conexion();
        
        Conexion conexion = new Conexion();
        try {
            conexion.conectarBD();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        
        
        
    }
    
    
    
}
