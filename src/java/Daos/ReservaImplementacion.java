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
                mesasDisponibles.add(mapeo(rs));
            }
        }catch(SQLException ex){
            Logger.getLogger(ReservaImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesasDisponibles;
    }
    
    private static Mesa mapeo(ResultSet resultSet) throws SQLException 
    {
        Mesa mesa = new Mesa();
        mesa.setId(resultSet.getInt("idmesa"));
        mesa.setCapacidad(resultSet.getInt("capacidad"));
        mesa.setEstado(resultSet.getString("estado"));
        return mesa;
    }

    @Override
    public boolean crearReserva(Reserva reserva) {
        boolean crear = false;
        try{
            String query = "insert into reserva (fechareserva, horareserva, tiporeserva,cliente_idcliente, mesa_idmesa)";
            PreparedStatement stmt = conn.prepareStatement(query);
            java.util.Date fec = reserva.getFechaReserva();
            java.sql.Date fecha = new java.sql.Date(fec.getTime());
            stmt.setDate(1, fecha);
            stmt.setString(2, reserva.getHoraReserva());
            stmt.setString(3, reserva.getTipoReserva());
            stmt.setInt(4, reserva.getIdCliente());
            stmt.setInt(5, reserva.getIdmesa());
            stmt.executeUpdate();
            crear=true;
            if(crear){
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
