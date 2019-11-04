/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Daos.*;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String correo=request.getParameter("correo");
        String contrasena=request.getParameter("contrasena");
        IUsuario usuarioDAO = null;
        IReserva reservaDAO = null;
        try {
            usuarioDAO = new UsuarioImplementacion();
            reservaDAO = new ReservaImplementacion();
            
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario user = usuarioDAO.buscarUsuario(correo, contrasena);
        if(user != null){
            Cliente cliente = usuarioDAO.datosCliente(user.getIdUsuario());
            session.setAttribute("idUsuario", user.getIdUsuario());
            session.setAttribute("correoUsuario", user.getCorreo());
            session.setAttribute("nombreUsuario", user.getNombre());
            session.setAttribute("apellidoUsuario", user.getApellido());
            session.setAttribute("fonoCliente", cliente.getFono());
            session.setAttribute("idCliente", cliente.getIdCliente());
            session.setAttribute("rutUsuario", user.getRut());
            session.setAttribute("claveUsuario", user.getContrasena());
            List<Mesa> mesasDisponibles = reservaDAO.mesasDisponibles();
            session.setAttribute("mesasDisponibles",mesasDisponibles);
            List<Reserva> reservasCliente = reservaDAO.reservasCliente(cliente.getIdCliente());
            session.setAttribute("reservasCliente",reservasCliente);
            response.sendRedirect("index.jsp");
        }else{
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal('No se pudo iniciar sesion', 'Usuario o clave incorrecto', 'error');");
            out.println("});");
            out.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("crearUsuario.jsp");
            rd.include(request, response);
        }
    }

    

}
