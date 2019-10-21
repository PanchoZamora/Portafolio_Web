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
        try {
            usuarioDAO = new UsuarioImplementacion();
            
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario user = usuarioDAO.verificarUsuario(correo, contrasena);
        if(user != null){
            session.setAttribute("correoUsuario", user.getCorreo());
            session.setAttribute("nombreUsuario", user.getNombre());
            session.setAttribute("apellidoUsuario", user.getApellido());
            response.sendRedirect("index.jsp");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario o contraseña incorrecta!');");
            out.println("location='index.jsp';");
            out.println("</script>");
            
        }
    }

    

}
