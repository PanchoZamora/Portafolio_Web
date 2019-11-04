/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Entidades.Conexion;
import Entidades.Mesa;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanis
 */
public class ReservaImplementacion implements IReserva{

    private final Connection conn;

    public ReservaImplementacion() throws Exception {
        Conexion con= new Conexion();
        this.conn=con.conectarBD();
    }
    
    @Override
    public ArrayList<Mesa> mesasDisponibles() {
        ArrayList<Mesa> mesasDisponibles = new ArrayList<>();
        String estado = "disponible";
        try{
            String query = "select * from mesa where estado = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,estado);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                mesasDisponibles.add(mapeoMesa(rs));
            }
        }catch(SQLException ex){
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesasDisponibles;
    }
    
    private static Mesa mapeoMesa(ResultSet resultSet) throws SQLException 
    {
        Mesa mesa = new Mesa();
        mesa.setId(resultSet.getInt("idmesa"));
        mesa.setCapacidad(resultSet.getInt("capacidad"));
        mesa.setEstado(resultSet.getString("estado"));
        return mesa;
    }

    @Override
    public boolean crearReserva(Reserva reserva) {
        String query = "insert into reserva (fechareserva, horareserva, tiporeserva,cliente_idcliente, mesa_idmesa) values (?,?,?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            java.util.Date fec = reserva.getFechaReserva();
            java.sql.Date fecha = new java.sql.Date(fec.getTime());
            stmt.setDate(1, fecha);
            stmt.setString(2, reserva.getHoraReserva());
            stmt.setString(3, reserva.getTipoReserva());
            stmt.setInt(4, reserva.getIdCliente());
            stmt.setInt(5, reserva.getIdmesa());
            int insert = stmt.executeUpdate();
            if(insert > 0){
                String estado = "ocupado";
                String modifyMesa = "update mesa set estado = ? where idmesa = ?";
                PreparedStatement stmtMesa = conn.prepareStatement(modifyMesa);
                stmtMesa.setString(1, estado);
                stmtMesa.setInt(2, reserva.getIdmesa());
                stmtMesa.executeUpdate();
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public ArrayList<Reserva> reservasCliente(int idcliente) {
        ArrayList<Reserva> reservasCliente = new ArrayList<>();
        try{
            String query = "select * from reserva where cliente_idcliente = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,idcliente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                reservasCliente.add(mapeoReserva(rs));
            }
        }catch(SQLException ex){
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservasCliente;
    }
    
    private static Reserva mapeoReserva(ResultSet resultSet) throws SQLException 
    {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(resultSet.getInt("idreserva"));
        reserva.setFechaReserva(resultSet.getDate("fechareserva"));
        reserva.setHoraReserva(resultSet.getString("horareserva"));
        reserva.setTipoReserva(resultSet.getString("tiporeserva"));
        reserva.setIdmesa(resultSet.getInt("mesa_idmesa"));
        return reserva;
    }

    @Override
    public boolean cancelarReserva(int idreserva, int idmesa) {
        String query = "delete from reserva where idreserva= ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, idreserva);
            int cancelar = stmt.executeUpdate();
            if(cancelar > 0){
                String estado = "disponible";
                String modifyMesa = "update mesa set estado = ? where idmesa = ?";
                PreparedStatement stmtMesa = conn.prepareStatement(modifyMesa);
                stmtMesa.setString(1, estado);
                stmtMesa.setInt(2, idmesa);
                stmtMesa.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Mesa> actualizarMesa(int idmesa) {
        ArrayList<Mesa> mesasDisponibles = new ArrayList<>();
        String estado = "disponible";
        String modifyMesa = "update mesa set estado = ? where idmesa = ?";
        try(PreparedStatement stmtMesa = conn.prepareStatement(modifyMesa)){
            stmtMesa.setString(1, estado);
            stmtMesa.setInt(2, idmesa);
            int mesa = stmtMesa.executeUpdate();
            if(mesa > 0){
                String query = "select * from mesa where estado = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1,estado);
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    mesasDisponibles.add(mapeoMesa(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesasDisponibles;
    }

    @Override
    public ArrayList<Mesa> editarMesa(int idmesa) {
        ArrayList<Mesa> mesasDisponibles = new ArrayList<>();
        String estado = "ocupado";
        String modifyMesa = "update mesa set estado = ? where idmesa = ?";
        try(PreparedStatement stmtMesa = conn.prepareStatement(modifyMesa)){
            stmtMesa.setString(1, estado);
            stmtMesa.setInt(2, idmesa);
            int mesa = stmtMesa.executeUpdate();
            if(mesa > 0){
                String estado2 = "disponible";
                String query = "select * from mesa where estado = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1,estado2);
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    mesasDisponibles.add(mapeoMesa(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesasDisponibles;
    }

    @Override
    public boolean editarReserva(Reserva reserva) {
        String query = "update reserva set fechareserva = ?, horareserva = ?, tiporeserva = ?, mesa_idmesa = ? where idreserva = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            java.util.Date fec = reserva.getFechaReserva();
            java.sql.Date fecha = new java.sql.Date(fec.getTime());
            stmt.setDate(1, fecha);
            stmt.setString(2, reserva.getHoraReserva());
            stmt.setString(3, reserva.getTipoReserva());
            stmt.setInt(4, reserva.getIdmesa());
            stmt.setInt(5, reserva.getIdReserva());
            int insert = stmt.executeUpdate();
            if(insert > 0){
                String estado = "ocupado";
                String modifyMesa = "update mesa set estado = ? where idmesa = ?";
                PreparedStatement stmtMesa = conn.prepareStatement(modifyMesa);
                stmtMesa.setString(1, estado);
                stmtMesa.setInt(2, reserva.getIdmesa());
                stmtMesa.executeUpdate();
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
