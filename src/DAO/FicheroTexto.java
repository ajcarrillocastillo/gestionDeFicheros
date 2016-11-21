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

    public static FicheroTexto devolverFicherosEscritura() {

        if (ficheroTexto != null) {
            return ficheroTexto;
        } else {
            ficheroTexto = new FicheroTexto();
            return ficheroTexto;
        }
    }

    public void escribirFicheroTxtClientes(String numeroDeEmpleado, String nombre, String apellido,
            String numeroDeMovimiento, double Importe, String tipo, String fecha, String descripcion) throws IOException {

        File f = new File("./ficheroTexto.txt");
        FileWriter fW;

        if (!f.exists()) {
            f.createNewFile();
        }
        /**
         * Forma 1: creamos el file writer antes (Arriba, debajo del file
         * archivo, lo declaramos). Luego lo usamos en el printWriter
         */
        fW = new FileWriter(f, true);//File Writer, aqui ponemos si es true o false.
        PrintWriter pW = new PrintWriter(fW); //llama a la clase con la que escribiremos en el fichero de texto

        pW.println(numeroDeEmpleado + "|" + nombre + "|" + apellido + "|" + numeroDeMovimiento
                + "|" + Importe + "|" + tipo + "|" + fecha + "|" + descripcion);
        pW.close(); //Cerramos la clase printWriter
    }

    /**
     *
     * @param eleccion
     * @return
     * @throws IOException
     */
    public ArrayList leerFicheroTxtEmpleados(int eleccion) throws IOException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File f = new File("./ficheroTexto.txt");
        FileReader fR;

        if (!f.exists()) {
            f.createNewFile();
        }

        fR = new FileReader(f);
        BufferedReader br = new BufferedReader(fR);
        //Aqui escribiremos lo que queremos que lea el fichero.
        //listaDeClientes.removeAll(listaDeClientes);
        String cadenaTexto = br.readLine();
        /*listaDeEmpleado.removeAll(listaDeEmpleado);
        listaDeMovimientos.removeAll(listaDeMovimientos);*/
        while (cadenaTexto != null) {
            String[] arrayDatosTexto = cadenaTexto.split("\\|");
            Empleado empleado = new Empleado(arrayDatosTexto[0], arrayDatosTexto[1], arrayDatosTexto[2]);
            Movimiento movimiento = new Movimiento(arrayDatosTexto[3], Double.parseDouble(arrayDatosTexto[4]), arrayDatosTexto[5], arrayDatosTexto[6], arrayDatosTexto[7], arrayDatosTexto[0]);
            listaDeEmpleado.add(empleado);
            listaDeMovimientos.add(movimiento);
            cadenaTexto = br.readLine();
        }
        br.close();
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
        if (eleccion==0){
        return listaDeEmpleado;
                }else{
            return listaDeMovimientos;
        }
        
    }

}
