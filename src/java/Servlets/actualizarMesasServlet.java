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
@WebServlet(name = "actualizarMesasServlet", urlPatterns = {"/actualizarMesasServlet"})
public class actualizarMesasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        int idreserva = Integer.parseInt(request.getParameter("idreserva"));
        int idmesa = Integer.parseInt(request.getParameter("idmesa"));
        IReserva reservaDAO;
        try {
            reservaDAO = new ReservaImplementacion();
            List<Mesa> mesasDisponibles = reservaDAO.actualizarMesa(idmesa);
            session.setAttribute("mesasDisponibles",mesasDisponibles);
            request.setAttribute("idreserva", idreserva);
            request.setAttribute("idmesa", idmesa);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarReserva.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(actualizarMesasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
