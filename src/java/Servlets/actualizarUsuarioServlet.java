/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Daos.IUsuario;
import Daos.UsuarioImplementacion;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "actualizarUsuarioServlet", urlPatterns = {"/actualizarUsuarioServlet"})
public class actualizarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
        PrintWriter out=response.getWriter();
        try {
            response.setContentType("text/html;charset=UTF-8");
            int idUsuario = Integer.parseInt(request.getParameter("idusuario"));
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String rut=request.getParameter("rut");
            int fono = Integer.parseInt(request.getParameter("fono"));
            String correo=request.getParameter("correo");
            String contrasena=request.getParameter("contrasena");
            Usuario usuario=new Usuario();
            usuario.setIdUsuario(idUsuario);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setRut(rut);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            IUsuario userDAO = new UsuarioImplementacion();
            if(userDAO.modificarUsuario(usuario, fono)){
                session.setAttribute("idUsuario", usuario.getIdUsuario());
                session.setAttribute("nombreUsuario", usuario.getNombre());
                session.setAttribute("apellidoUsuario", usuario.getApellido());
                session.setAttribute("rutUsuario", usuario.getRut());
                session.setAttribute("fonoCliente", fono);
                session.setAttribute("correoUsuario", usuario.getCorreo());
                session.setAttribute("claveUsuario", usuario.getContrasena());
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Actualizado', 'Sus datos fueron actualizados exitosamente ', 'success');");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
                rd.include(request, response);
            }
            
        } catch (Exception ex) {
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal('Error', 'No se pudieron actualizar sus datos, intente nuevamente', 'error');");
            out.println("});");
            out.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
            rd.include(request, response);
        }
    }
}
