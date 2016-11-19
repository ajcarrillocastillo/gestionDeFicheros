package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.modelo.Movimiento;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class FicheroBinario 
{ 
    private ArrayList<Empleado> listaDeEmpleado;
    private ArrayList<Movimiento> listaDeMovimientos ;
      
    public FicheroBinario() {
        listaDeEmpleado = new ArrayList<Empleado>();
        listaDeMovimientos = new ArrayList<Movimiento>();
    }
    private static FicheroBinario ficheroBinario = null;

    public static FicheroBinario devolverFicherosEscritura() {

        if (ficheroBinario != null) {
            return ficheroBinario;
        } else {
            ficheroBinario = new FicheroBinario();
            return ficheroBinario;
        }
    }
/**
 * escribimos los datos en un fichero binario
 */
    public void escribirFicherosDat(String numeroDeEmpleado, String nombre,
        String apellido, String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion ) throws IOException {
          /**
         * Declaramos el fichero
         */
        File f = new File("./FicheroDeDatos.dat");
        FileOutputStream fOS;
        if (!f.exists()) {
            f.createNewFile();
        }
         /**
         * Escribimos los datos
         */
        fOS = new FileOutputStream("./FicheroDeDatos.dat", true);
        try (DataOutputStream dOS = new DataOutputStream(fOS)) {
            dOS.writeUTF(numeroDeEmpleado);
            dOS.writeUTF(nombre);
            dOS.writeUTF(apellido);
            dOS.writeUTF(numeroDeMovimiento);
            dOS.writeDouble(Importe);
            dOS.writeUTF(tipo);
            dOS.writeUTF(fecha);
            dOS.writeUTF(descripcion);
            
            
        } 
    }
    
    
     public void leerFicherosDat() throws IOException {

       
          /**
         * Declaramos el ficherp
         */
        File f = new File("FicheroDeDatos.dat");
        FileInputStream fIS;
        if (!f.exists()) {
            f.createNewFile();
        }
        /**
         * Leemos los datos de un fichro vinario
         */
        fIS = new FileInputStream(f);
        try (DataInputStream dIS = new DataInputStream(fIS)) {
            while (dIS.available() >= 0) {
                String numeroDeEmpleado = dIS.readUTF();
                String nombre = dIS.readUTF();
                String apellido = dIS.readUTF();
                
                String numeroDeMovimiento = dIS.readUTF();
                double Importe = dIS.readDouble();
                String tipo = dIS.readUTF();
                String fecha = dIS.readUTF();
                String descripcion = dIS.readUTF();
                
                Movimiento movimientoDat = new Movimiento(numeroDeMovimiento, Importe, tipo, fecha, descripcion, numeroDeEmpleado);
                Empleado empleadoDat = new Empleado(numeroDeEmpleado, nombre, apellido);
                addListaDeMovimientos(movimientoDat);
                addListaDeEmpleados(empleadoDat);
            }
            dIS.close();
            /**
             * añadimos los movimientos del empleado recorriendo el array de Movimientos y comparandolo con el de empleados
             */
            for (int x = 0; x < listaDeMovimientos.size(); x++) {
                Movimiento comprobarMovimiento = listaDeMovimientos.get(x);
                String numeroDeEmpleadoDeMovimiento = comprobarMovimiento.getNumeroDeEmpleado();
                for (int y = 0; x < listaDeEmpleado.size(); y++) {
                    Empleado comprobarEmpleado = listaDeEmpleado.get(y);
                    String numeroDeEmpleadoDeEmpleado = comprobarEmpleado.getNumeroDeEmpleado();
                    if (numeroDeEmpleadoDeEmpleado == numeroDeEmpleadoDeMovimiento) {
                        listaDeEmpleado.get(y).addListaDeMovimientos(comprobarMovimiento);
                    }

                }
            }
        }
        
        

    }
     private void addListaDeMovimientos(Movimiento movimiento){
     this.listaDeMovimientos.add(movimiento);
    }
     private void addListaDeEmpleados(Empleado empleado){
     this.listaDeEmpleado.add(empleado);
     }
}