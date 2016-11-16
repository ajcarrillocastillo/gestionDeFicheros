package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.modelo.Movimiento;
import java.io.DataOutputStream;
import java.io.File;
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
        File archivoDatEmpleados = new File("./Empleado.dat");
        FileOutputStream fos;
        if (!archivoDatEmpleados.exists()) {
            archivoDatEmpleados.createNewFile();
        }
        fos = new FileOutputStream("./Empleado.dat", true);
        DataOutputStream dos = new DataOutputStream(fos);
        
        dos.writeUTF(numeroDeEmpleado);
        dos.writeUTF(nombre);
        dos.writeUTF(apellido);
        dos.close(); 
    }
}
