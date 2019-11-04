/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Daos.IReserva;
import Daos.ReservaImplementacion;
import Entidades.Mesa;
import Entidades.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanis
 */
@WebServlet(name = "editarReservaServlet", urlPatterns = {"/editarReservaServlet"})
public class editarReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try{
            int idcliente = Integer.parseInt(request.getParameter("idcliente"));
            int idreserva = Integer.parseInt(request.getParameter("idreserva"));
            String hora = request.getParameter("hora");
            int idmesa1 = Integer.parseInt(request.getParameter("idmesa"));
            int idmesa2 = Integer.parseInt(request.getParameter("mesa"));
            String tipo = request.getParameter("tipo");
            String fechaIngreso = request.getParameter("fecha");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = (Date) formato.parse(fechaIngreso);
            Reserva reserva =  new Reserva();
            reserva.setIdReserva(idreserva);
            reserva.setFechaReserva(fecha);
            reserva.setHoraReserva(hora);
            reserva.setIdmesa(idmesa2);
            reserva.setTipoReserva(tipo);
            IReserva reservaDAO = new ReservaImplementacion();
            if(reservaDAO.editarReserva(reserva)){
                List<Mesa> mesasDisponibles = reservaDAO.mesasDisponibles();
                session.setAttribute("mesasDisponibles",mesasDisponibles);
                List<Reserva> reservasCliente = reservaDAO.reservasCliente(idcliente);
                session.setAttribute("reservasCliente",reservasCliente);
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Listo', 'Su reserva fue actualizada exitosamente', 'success');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                rd.include(request, response);
            }else{
                List<Mesa> mesasDisponibles = reservaDAO.editarMesa(idmesa1);
                session.setAttribute("mesasDisponibles",mesasDisponibles);
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Error', 'No se pudo actualizar su reserva, intente nuevamente', 'error');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                rd.include(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(editarReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(editarReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
