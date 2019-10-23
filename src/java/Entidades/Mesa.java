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
public class Mesa {
    private int idmesa;
    private int capacidad;
    private String estado;
    
    public Mesa(int idmesa, int capacidad, String estado) {
        this.idmesa = idmesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa() {
        this.idmesa = 0;
        this.capacidad = 0;
        this.estado = "";       
    }

    public int getId() {
        return idmesa;
    }

    public void setId(int idmesa) {
        this.idmesa = idmesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if(capacidad <= 0 ){
            throw new IllegalArgumentException("La capacidad no puede ser 0 o inferior"); 
        }
        else{
            this.capacidad = capacidad;
        }
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        // Se valida que el valor no esté vacio, de ser asi, se emite la excepción a ser controlada
        if(estado == null || estado.isEmpty() || "".equals(estado)){
            throw new IllegalArgumentException("El estado esta vacio"); 
        }
        else{
            this.estado=estado;
        }
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + idmesa + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }
    
    
}
