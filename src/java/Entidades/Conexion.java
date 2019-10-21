/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private Connection conexion;
    
    
    public Connection getConexion() {
        return conexion;
    }

    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    //conectar a una bd
    public Connection conectarBD() throws Exception {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@192.168.16.129:1521:orcl";
        conexion= DriverManager.getConnection(BaseDeDatos,"portafolio","portafolio");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            throw new Exception(e.getMessage());
        }
        return conexion;
    }
    
    
}
