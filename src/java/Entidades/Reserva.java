/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author yanis
 */
public class Reserva {
    private int idReserva;
    private Date fechaReserva;
    private String horaReserva;
    private String tipoReserva;
    private int idmesa;
    private int idcliente;

    public Reserva() {
    }

    public Reserva(int idReserva, Date fechaReserva, String horaReserva, String tipoReserva, int idmesa, int idcliente) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.tipoReserva = tipoReserva;
        this.idmesa = idmesa;
        this.idcliente = idcliente;
    }
    
    public Reserva(Date fechaReserva, String horaReserva, String tipoReserva, int idmesa, int idcliente) {
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.tipoReserva = tipoReserva;
        this.idmesa = idmesa;
        this.idcliente = idcliente;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        
        this.horaReserva = horaReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        
        // Se valida que el valor no esté vacio, de ser asi, se emite la excepción a ser controlada
        if(tipoReserva == null || tipoReserva.isEmpty() || "".equals(tipoReserva)){
            throw new IllegalArgumentException("El tipo de reserva es invalido"); 
        }
        else{
            this.tipoReserva=tipoReserva;
        }
        
    }

    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public int getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(int idcliente) {
        this.idcliente = idcliente;
    }
    

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + ", tipoReserva=" + tipoReserva + '}';
    }
}
