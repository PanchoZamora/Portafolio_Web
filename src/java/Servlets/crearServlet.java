/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Daos.*;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author cetecom
 */
@WebServlet(name = "crearServlet", urlPatterns = {"/crearServlet"})
public class crearServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            response.setContentType("text/html;charset=UTF-8");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String rut=request.getParameter("rut");
            String correo=request.getParameter("correo");
            String contrasena=request.getParameter("contrasena");
            Usuario usuario=new Usuario(nombre, apellido, rut, correo, contrasena);
            IUsuario userDAO = new UsuarioImplementacion();
            String mensaje;
            if(userDAO.crearUsuario(usuario)){
                mensaje="Cliente Creado"; 
                session.setAttribute("correoUsuario", usuario.getCorreo());
                session.setAttribute("nombreUsuario", usuario.getNombre());
                session.setAttribute("apellidoUsuario", usuario.getApellido());
                response.sendRedirect("index.jsp");
            }else{
                mensaje="Error al crear el cliente";
            }
            request.setAttribute("mensaje", mensaje); 
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/crearUsuario.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(crearServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
