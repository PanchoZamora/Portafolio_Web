/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Daos.IReserva;
import Daos.ReservaImplementacion;
import Entidades.Mesa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "editarMesaServlet", urlPatterns = {"/editarMesaServlet"})
public class editarMesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        int idmesa = Integer.parseInt(request.getParameter("idmesa"));
        IReserva reservaDAO;
        try {
            reservaDAO = new ReservaImplementacion();
            List<Mesa> mesasDisponibles = reservaDAO.editarMesa(idmesa);
            session.setAttribute("mesasDisponibles",mesasDisponibles);
            response.sendRedirect("perfil.jsp");
        } catch (Exception ex) {
            Logger.getLogger(actualizarMesasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
