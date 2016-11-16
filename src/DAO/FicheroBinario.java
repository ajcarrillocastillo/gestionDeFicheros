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
import java.util.HashSet;

/**
 *
 * @author jesus
 */
public class FicheroBinario 
{ 
    private HashSet<Empleado> listaDeEmpleado;
    private HashSet<Movimiento> listaDeMovimientos ;
      
    public FicheroBinario() {
        listaDeEmpleado = new HashSet<Empleado>();
        listaDeMovimientos = new HashSet<Movimiento>();
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

    public void escribirFicherosDat(String numeroDeEmpleado, String nombre,
        String apellido, String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion ) throws IOException {
        File archivoDatEmpleados = new File("./FicheroDeDatos.dat");
        FileOutputStream fos;
        if (!archivoDatEmpleados.exists()) {
            archivoDatEmpleados.createNewFile();
        }
        fos = new FileOutputStream("./FicheroDeDatos.dat", true);
        try (DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(numeroDeEmpleado);
            dos.writeUTF(nombre);
            dos.writeUTF(apellido);
            dos.writeUTF(numeroDeMovimiento);
            dos.writeDouble(Importe);
            dos.writeUTF(tipo);
            dos.writeUTF(fecha);
            dos.writeUTF(descripcion);           
        } 
    }
     public void leerFicherosDatEmpleados() throws IOException {

       
        File archivo = new File("./FicheroDeDatos.dat");
        FileInputStream fis;
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * DataOutputStream guarda como ficheros de datos. llama a la clase con
         * la que escribiremos en un fichero binario.
         */
        //no entiendo esto
        fis = new FileInputStream("./FicheroDeDatos.dat");
        DataInputStream dis = new DataInputStream(fis);
            String contenidoLinea;
        while((contenidoLinea = dis.readUTF()) != null){
            System.out.println("soy linea"+contenidoLinea);
        } 
         System.out.println("DATA: "+contenidoLinea);
    }
}
