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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "crearReservaServlet", urlPatterns = {"/crearReservaServlet"})
public class crearReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        try {
            response.setContentType("text/html;charset=UTF-8");
            int idcliente = Integer.parseInt(request.getParameter("idcliente"));
            String hora = request.getParameter("hora");
            int idmesa = Integer.parseInt(request.getParameter("mesa"));
            String tipo = request.getParameter("tipo");
            String fechaIngreso = request.getParameter("fecha");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = (Date) formato.parse(fechaIngreso);
            Reserva reserva = new Reserva();
            reserva.setFechaReserva(fecha);
            reserva.setHoraReserva(hora);
            reserva.setTipoReserva(tipo);
            reserva.setIdCliente(idcliente);
            reserva.setIdmesa(idmesa);
            IReserva reservaDAO = new ReservaImplementacion();
            if(reservaDAO.crearReserva(reserva)){
                List<Mesa> mesasDisponibles = reservaDAO.mesasDisponibles();
                session.setAttribute("mesasDisponibles",mesasDisponibles);
                List<Reserva> reservasCliente = reservaDAO.reservasCliente(idcliente);
                session.setAttribute("reservasCliente",reservasCliente);
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Felicidades', 'Su reserva fue creada exitosamente', 'success');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }else{
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Error al crear la reserva', 'No se pudo crear la reserva, intente mas tarde', 'error');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
        } catch (Exception ex) {
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal('Error al crear la reserva', 'No se pudo crear la reserva, intente mas tarde', 'error');");
            out.println("});");
            out.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        }    
    }

}
