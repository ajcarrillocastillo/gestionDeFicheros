/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.modelo.Movimiento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class FicheroTexto {

    private ArrayList<Empleado> listaDeEmpleado;
    private ArrayList<Movimiento> listaDeMovimientos;

    public FicheroTexto() {
        listaDeEmpleado = new ArrayList<Empleado>();
        listaDeMovimientos = new ArrayList<Movimiento>();
    }
    private static FicheroTexto ficheroTexto = null;

    public static FicheroTexto devolver() {

        if (ficheroTexto != null) {
            return ficheroTexto;
        } else {
            ficheroTexto = new FicheroTexto();
            return ficheroTexto;
        }
    }

    public boolean escribirFicheroTxtEmpleados(String numeroDeEmpleado, String nombre, String apellido) throws IOException {
        boolean existe = false;

        File f = new File("./ficheroTextoEmpleados.txt");
        FileWriter fW;

        if (!f.exists()) {
            f.createNewFile();
        }
        ArrayList<Empleado> listaEmpleados = leerFicheroTxtEmpleados();
        for (Empleado e : listaEmpleados) {
            if(e.getNumeroDeEmpleado().equals(numeroDeEmpleado)){
            existe =true ;
            }
        }
        if (!existe) {
            fW = new FileWriter(f, true);
            try (PrintWriter pW = new PrintWriter(fW)) {

                pW.println(numeroDeEmpleado + "|" + nombre + "|" + apellido);

                pW.close(); 
            }
        }
        return existe;
    }

     public boolean escribirFicheroTxtMovimientos(String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion ,String numeroDeEmpleado) throws IOException {
        boolean existe = false;

        File f = new File("./ficheroTextoMovimientos.txt");
        FileWriter fW;

        if (!f.exists()) {
            f.createNewFile();
        }
        ArrayList<Movimiento> listaMovimiento = leerFicheroTxtMovimientos();
        for (Movimiento m : listaMovimiento) {
            if(m.getNumeroDeEmpleado().equals(numeroDeEmpleado)){
            if( m.getNumeroDeMovimiento().equals(numeroDeMovimiento) ){
            existe =true;}
        }
        }
        if (!existe) {
            fW = new FileWriter(f, true);
            try (PrintWriter pW = new PrintWriter(fW)) {

                pW.println(numeroDeMovimiento+"|"+Importe+"|"+tipo+"|"+fecha+"|"+descripcion+"|"+numeroDeEmpleado);

                pW.close(); 
            }
        }
        return existe;
    }

    public ArrayList leerFicheroTxtEmpleados() throws IOException {
        ArrayList<Movimiento> listaDeMovimientosEmpleado= new ArrayList();
        File f = new File("./ficheroTextoEmpleados.txt");
        FileReader fR;

        if (!f.exists()) {
            f.createNewFile();
        }

        fR = new FileReader(f);
        BufferedReader br = new BufferedReader(fR);
        String cadenaTexto = br.readLine();
        listaDeEmpleado.removeAll(listaDeEmpleado);
        listaDeMovimientos.removeAll(listaDeMovimientos);
         listaDeMovimientos=leerFicheroTxtMovimientos();
        while (cadenaTexto != null) {
            listaDeMovimientosEmpleado= new ArrayList();
            String[] arrayDatosTexto = cadenaTexto.split("\\|");
            for(Movimiento m:listaDeMovimientos){
                if(m.getNumeroDeEmpleado().equals(arrayDatosTexto[0])){
                listaDeMovimientosEmpleado.add(m);
                }
            }
            Empleado empleado = new Empleado(arrayDatosTexto[0], arrayDatosTexto[1], arrayDatosTexto[2],listaDeMovimientosEmpleado);
           listaDeEmpleado.add(empleado);

            cadenaTexto = br.readLine();
        }
        
        
        return listaDeEmpleado;

    }

   public ArrayList leerFicheroTxtMovimientos() throws IOException {
        File f = new File("./ficheroTextoMovimientos.txt");
        FileReader fR;

        if (!f.exists()) {
            f.createNewFile();
        }

        fR = new FileReader(f);
        BufferedReader br = new BufferedReader(fR);
        String cadenaTexto = br.readLine();
        listaDeMovimientos.removeAll(listaDeMovimientos);
        while (cadenaTexto != null) {
            String[] arrayDatosTexto = cadenaTexto.split("\\|");
            Movimiento movimiento = new Movimiento(arrayDatosTexto[0], Double.parseDouble(arrayDatosTexto[1]), arrayDatosTexto[2],arrayDatosTexto[3], arrayDatosTexto[4], arrayDatosTexto[5]);
           listaDeMovimientos.add(movimiento);

            cadenaTexto = br.readLine();
        }
       
        
        return listaDeMovimientos;

    }

}
