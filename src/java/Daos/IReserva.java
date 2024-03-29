/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Entidades.Mesa;
import Entidades.Reserva;
import java.util.ArrayList;

/**
 *
 * @author yanis
 */
public interface IReserva {
    ArrayList<Mesa> mesasDisponibles();
    boolean crearReserva(Reserva reserva);
    boolean editarReserva(Reserva reserva);
    ArrayList<Reserva> reservasCliente(int idcliente);
    boolean cancelarReserva(int idreserva, int idmesa);
    ArrayList<Mesa> actualizarMesa(int idmesa);
    ArrayList<Mesa> editarMesa(int idmesa);
}
