/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Entidades.Usuario;

/**
 *
 * @author cetecom
 */
public interface IUsuario {
     boolean crearUsuario(Usuario usuario );
     void modificarUsuario(Usuario usuario);
     Usuario verificarUsuario( String correo,String clave );
}
