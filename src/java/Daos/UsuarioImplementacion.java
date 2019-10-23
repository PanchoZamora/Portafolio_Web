/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Entidades.Cliente;
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
    public int crearUsuario(Usuario usuario, int fono) {
        boolean creado = false;
        int idUsuario = 0;
        try {
            String query = ("INSERT INTO USUARIO(NOMBRE,APELLIDOS,RUT,CORREO,CONTRASENA) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2,usuario.getApellido());
            stmt.setString(3,usuario.getRut());
            stmt.setString(4,usuario.getCorreo());
            stmt.setString(5,usuario.getContrasena());
            stmt.executeUpdate();
            creado = true;
            if(creado){
                String buscarUser = ("select * from usuario where correo = ?");
                PreparedStatement stmtBuscar = conn.prepareStatement(buscarUser);
                stmtBuscar.setString(1,usuario.getCorreo());
                ResultSet rs=stmtBuscar.executeQuery();
                if(rs.next()){
                    String insertCliente = "insert into cliente (fono, usuario_idusuario) values(?,?)";
                    PreparedStatement stmtInsert = conn.prepareStatement(insertCliente);
                    stmtInsert.setInt(1, fono);
                    stmtInsert.setInt(2, rs.getInt("idUsuario"));
                    stmtInsert.executeUpdate();
                    idUsuario = rs.getInt("idUsuario");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUsuario;
    }

    @Override
    public Usuario buscarUsuario(String correo, String clave) {
        Usuario usuario = null;
        try{
        String query = "select * from usuario where correo = ? and contrasena = ? ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,correo);
        stmt.setString(2,clave);
        ResultSet rs=stmt.executeQuery();
            if (rs.next()){
                usuario = new Usuario(rs.getInt("idUsuario"),rs.getString("nombre"), rs.getString("apellidos"), rs.getString("rut"), rs.getString("correo"), rs.getString("contrasena"));
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

    @Override
    public Cliente datosCliente(int idUsuario) {
        Cliente cliente = new Cliente();
        try{
        String query = "select * from cliente where usuario_idusuario= ? ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,idUsuario);
        ResultSet rs=stmt.executeQuery();
            if (rs.next()){
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setFono(rs.getInt("fono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario, int fono) {
        boolean modificado = false;
        try{
            String query = "select * from usuario where idusuario = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,usuario.getIdUsuario());
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                String modify = "update usuario set nombre = ?, apellidos = ?, rut = ?, correo = ?, contrasena = ?  where idusuario = ?";
                PreparedStatement stmtModify = conn.prepareStatement(modify);
                stmtModify.setString(1, usuario.getNombre());
                stmtModify.setString(2,usuario.getApellido());
                stmtModify.setString(3,usuario.getRut());
                stmtModify.setString(4,usuario.getCorreo());
                stmtModify.setString(5,usuario.getContrasena());
                stmtModify.setInt(6,usuario.getIdUsuario());
                stmtModify.executeUpdate();
                modificado = true;
                if(modificado){
                    String fonoCli = "update cliente set fono = ?  where usuario_idusuario = ?";
                    PreparedStatement stmtFono = conn.prepareStatement(fonoCli);
                    stmtFono.setInt(1, fono);
                    stmtFono.setInt(2, usuario.getIdUsuario());
                    stmtFono.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
