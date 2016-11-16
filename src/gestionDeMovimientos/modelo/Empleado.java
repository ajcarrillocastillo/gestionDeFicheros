/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.modelo;

import java.io.Serializable;

/**
 *
 * @author jesus
 */
public class Empleado implements Serializable{
       
   private String numeroDeEmpleado;
   private String nombre;
   private String apellido;

    public Empleado(String numeroDeEmpleado, String nombre, String apellido) {
        this.numeroDeEmpleado = numeroDeEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNumeroDeEmpleado() {
        return numeroDeEmpleado;
    }

    public void setNumeroDeEmpleado(String numeroDeEmpleado) {
        this.numeroDeEmpleado = numeroDeEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
  

    @Override
    public String toString() {
        return /*NumeroDeEmpleado:0*/getNumeroDeEmpleado()+"|"/*Nombre:1*/+getNombre()+"|"  /*Apellido:2*/+getApellido();
    }
 

    
    
}
