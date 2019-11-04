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
@WebServlet(name = "cancelarReservaServlet", urlPatterns = {"/cancelarReservaServlet"})
public class cancelarReservaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        int idreserva = Integer.parseInt(request.getParameter("idreserva"));
        int idmesa = Integer.parseInt(request.getParameter("idmesa"));
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        IReserva reservaDAO;
        try {
            reservaDAO = new ReservaImplementacion();
            if(reservaDAO.cancelarReserva(idreserva,idmesa)){
                List<Mesa> mesasDisponibles = reservaDAO.mesasDisponibles();
                session.setAttribute("mesasDisponibles",mesasDisponibles);
                List<Reserva> reservasCliente = reservaDAO.reservasCliente(idcliente);
                session.setAttribute("reservasCliente",reservasCliente);
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Listo', 'Su reserva fue cancelada exitosamente', 'success');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                rd.include(request, response);
            }else{
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Error', 'No se pudo cancelar su reserva, intente nuevamente', 'error');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                rd.include(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(cancelarReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
