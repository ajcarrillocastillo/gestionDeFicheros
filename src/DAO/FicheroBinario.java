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
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

       public void escribirFicherosDatEmpleado(String numeroDeEmpleado, String nombre,
            String apellido) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File archivoDatEmpleados = new File("./Empleado.dat");
        FileOutputStream fos;

        if (!archivoDatEmpleados.exists()) {
            archivoDatEmpleados.createNewFile();
        }
        /**
         * DataOutputStream guarda como ficheros de datos. llama a la clase con
         * la que escribiremos en un fichero binario.
         */
        fos = new FileOutputStream("./Empleado.dat", true);
        DataOutputStream dos = new DataOutputStream(fos);
        /**
         * Con .write escribiremos en el fichero, hay que recordar que se tiene
         * que acompañar con el tipo de dato que escribamos, UTF si es String,
         * Int para enteros, etc. Aqui escribiremos lo que queremos que escriba
         * (guarde) en el fichero:
         */
        dos.writeUTF(numeroDeEmpleado);
        dos.writeUTF(nombre);
        dos.writeUTF(apellido);
        dos.close(); //Cerramos la clase printWriter
        
    }
}
