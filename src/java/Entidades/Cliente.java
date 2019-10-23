/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author yanis
 */
public class Cliente {
    int idCliente;
    int fono;
    int idUsuario;

    public Cliente() {
        this.idCliente = 0;
        this.fono = 0;
        this.idUsuario = 0;

    }

    public Cliente(int idCliente, int fono, int idUsuario) {
        this.idCliente = idCliente;
        this.fono = fono;
        this.idUsuario = idUsuario;
    }
    
    public Cliente( int fono, int idUsuario) {
        this.fono = fono;
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", fono=" + fono + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
