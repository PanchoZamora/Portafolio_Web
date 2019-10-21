/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author cetecom
 */
public class Usuario {
    // VARIABLES
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private String contrasena;
    
    // Constructor con parametros
    public Usuario(int idUsuario, String nombre, String apellido, String rut, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    // Constructor con parametros sin id
    public Usuario(String nombre, String apellido, String rut, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    // Constructor con parametros por defecto ( NO NULOS )
    public Usuario() {
        this.idUsuario = 0;
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
        this.correo = "";
        this.contrasena = "";
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Se valida que el valor no esté vacio, de ser asi, se emite la excepción a ser controlada
        if(nombre == null || nombre.isEmpty() || "".equals(nombre)){
            throw new IllegalArgumentException("El apellido esta vacio"); 
        }
        else{
            this.nombre=nombre;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        
        // Se valida que el valor no esté vacio, de ser asi, se emite la excepción a ser controlada
        if(apellido == null || apellido.isEmpty() || "".equals(apellido)){
            throw new IllegalArgumentException("El apellido esta vacio"); 
        }
        else{
            this.apellido=apellido;
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        String[] rut_dv = rut.split("-");
        
        if( rut_dv.length == 2 ){
            try {
                int auxRut = Integer.parseInt( rut_dv[0] );
                        char dv = rut_dv[1].charAt(0);
 
                        // Validamos que sea un rut valido según la norma
                        if ( this.ValidarRut(auxRut, dv)  )
                        {
                            
                            this.rut = rut;
                        }
                        else
                        {
                            throw new IllegalArgumentException("Rut mal ingresado");
                        }
            } catch (Exception e) {
                throw new IllegalArgumentException("Rut mal ingresado");
            }
        }
        else{
            throw new IllegalArgumentException("Rut mal ingresado");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        // Se valida que el valor no esté vacio, de ser asi, se emite la excepción a ser controlada
        if(correo == null || correo.isEmpty() || "".equals(correo) ){
            throw new IllegalArgumentException("El correo esta vacio"); 
        }
        else if( !correo.contains("@") || !correo.contains(".")){
            throw new IllegalArgumentException("El correo no es valido");
        }
        else{
            this.correo=correo;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        // Se valida que el valor no esté vacio, de ser asi, se emite la excepción a ser controlada
        if(contrasena == null || contrasena.isEmpty() || "".equals(contrasena)){
            throw new IllegalArgumentException("La contrasena esta vacia"); 
        }
        else{
            this.contrasena=contrasena;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
    
    public static boolean ValidarRut(int rut, char dv)
    {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10)
        {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
}
