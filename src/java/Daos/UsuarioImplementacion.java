/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Entidades.Conexion;
import Entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cetecom
 */
public class UsuarioImplementacion implements IUsuario{

    private Connection conn;

    public UsuarioImplementacion() throws Exception {
        Conexion con= new Conexion();
        this.conn=con.conectarBD();
    }
    @Override
    public boolean crearUsuario(Usuario usuario) {
        boolean creado = false;
        try {
            CallableStatement cstmt = conn.prepareCall("{CALL ingresar_usuario(?,?,?,?,?)}");
            cstmt.setString(1,usuario.getNombre());
            cstmt.setString(2,usuario.getApellido());
            cstmt.setString(3,usuario.getRut());
            cstmt.setString(4, usuario.getContrasena());
            cstmt.setString(5, usuario.getCorreo());
            cstmt.executeUpdate();
            creado = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return creado;
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario verificarUsuario(String correo, String clave) {
        Usuario usuario = null;
        try{
        String query = "select * from usuario where correo=? and contrasena=? ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,correo);
        stmt.setString(2,clave);
        ResultSet rs=stmt.executeQuery();
            if (rs.next()){
                usuario.setCorreo(rs.getString("correo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    private static Usuario mapeo(ResultSet resultSet) throws SQLException, ParseException {
        Usuario usuario = new Usuario();
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setApellido(resultSet.getString("apellidos"));
        usuario.setRut(resultSet.getString("rut"));
        usuario.setContrasena(resultSet.getString("contrasena"));
        return usuario;
    }
}
