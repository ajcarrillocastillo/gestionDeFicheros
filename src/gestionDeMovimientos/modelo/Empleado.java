/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.modelo;
import java.io.Serializable;
import java.util.ArrayList;
 
/**
 *
 * @author jesus
 */
public class Empleado implements Serializable{
       
   private String numeroDeEmpleado;
   private String nombre;
   private String apellido;
   private ArrayList<Movimiento> listaDeMovimientos;

    public Empleado(String numeroDeEmpleado, String nombre, String apellido, ArrayList<Movimiento> listaDeMovimiento) {
        this.numeroDeEmpleado = numeroDeEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaDeMovimientos = listaDeMovimiento;
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

    public ArrayList<Movimiento> getListaDeMovimientos() {
        return listaDeMovimientos;
    }

    public void setListaDeMovimientos(ArrayList<Movimiento> listaDeMovimientos) {
        this.listaDeMovimientos = listaDeMovimientos;
    }
    public void addListaDeMovimientos(Movimiento movimiento){
     this.listaDeMovimientos.add(movimiento);
    }
    
  

    @Override
    public String toString() {
        ArrayList<Movimiento> listaDeMovimientosToString = getListaDeMovimientos();
        String texto=/*NumeroDeEmpleado:0*/getNumeroDeEmpleado()+"|"/*Nombre:1*/+getNombre()+"|"  /*Apellido:2*/+getApellido();
        for(int x=0;x<listaDeMovimientosToString.size();x++) {
        texto= texto +"|"+ listaDeMovimientosToString.get(x);
            }
        return texto;
    }
 

    
    
}
