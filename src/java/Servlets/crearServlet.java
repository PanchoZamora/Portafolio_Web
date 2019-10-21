/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Daos.UsuarioImplementacion;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cetecom
 */
@WebServlet(name = "crearServlet", urlPatterns = {"/crearServlet"})
public class crearServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String rut=request.getParameter("rut");
            String correo=request.getParameter("correo");
            String contrasena=request.getParameter("contrasena");
            Usuario usuario=new Usuario(nombre, apellido, rut, correo, contrasena);
            UsuarioImplementacion userDAO = new UsuarioImplementacion();
            if(userDAO.crearUsuario(usuario)){
                response.sendRedirect("crearUsuario.jsp?mensaje="+"Cliente Creado");
            }else{
                response.sendRedirect("crearUsuario.jsp?mensaje="+"Error");
            }
        } catch (Exception ex) {
            Logger.getLogger(crearServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
