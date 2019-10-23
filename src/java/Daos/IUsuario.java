/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Entidades.Cliente;
import Entidades.Usuario;

/**
 *
 * @author cetecom
 */
public interface IUsuario {
     int crearUsuario(Usuario usuario, int fono );
     Usuario buscarUsuario( String correo,String clave );
     Cliente datosCliente (int idUsuario);
     boolean modificarUsuario (Usuario usuario, int fono);
}
