/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "salirServlet", urlPatterns = {"/salirServlet"})
public class salirServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.removeAttribute("correoUsuario");
        session.removeAttribute("nombreUsuario");
        session.removeAttribute("apellidoUsuario");
        session.removeAttribute("rutUsuario");
        session.removeAttribute("claveUsuario");
        session.removeAttribute("idUsuario");
        session.removeAttribute("idCliente");
        session.removeAttribute("fonoCliente");
        session.removeAttribute("mesasDisponibles");
        session.removeAttribute("reservasCliente");
        response.sendRedirect("index.jsp");
    }


}
