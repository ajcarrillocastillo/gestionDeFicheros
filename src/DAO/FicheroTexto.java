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

    public boolean escribirFicheroTxtEmpleados(String numeroDeEmpleado, String nombre, String apellido) throws IOException {
        boolean existe = false;

        File f = new File("./ficheroTextoEmpleados.txt");
        FileWriter fW;

        if (!f.exists()) {
            f.createNewFile();
        }
        ArrayList<Empleado> listaEmpleados = leerFicheroTxtEmpleados();
        for (Empleado e : listaEmpleados) {
            existe = e.getNumeroDeEmpleado().equals(numeroDeEmpleado);
        }
        if (!existe) {
            fW = new FileWriter(f, true);
            try (PrintWriter pW = new PrintWriter(fW)) {

                pW.println(numeroDeEmpleado + "|" + nombre + "|" + apellido);

                pW.close(); //Cerramos la clase printWriter
            }
        }
        return existe;
    }

    public void escribirFicheroTxtMovimiento(String numeroDeEmpleado, String numeroDeMovimiento, double Importe, String tipo, String fecha, String descripcion) throws IOException {

        File f = new File("./ficheroTextoMovimiento.txt");
        FileWriter fW;

        if (!f.exists()) {
            f.createNewFile();
        }
          ArrayList<Movimiento> listaMovimientos= leerFicheroTxtMovimientos();
            for(Movimiento m : listaMovimientos){
            if(c.getNumeroDeEmpleado().equals(numeroDeEmpleado)){
                existe=true;
            }else{
                existe=false;
            }
            }
            if (!existe){
        fW = new FileWriter(f, true);
        PrintWriter pW = new PrintWriter(fW);
        pW.println(numeroDeMovimiento + "|" + Importe + "|" + tipo + "|" + fecha + "|" + descripcion + "|" + numeroDeEmpleado);
        pW.close(); //Cerramos la clase printWriter
    }

    public ArrayList leerFicheroTxtEmpleados() throws IOException {

        File f = new File("./ficheroTextoEmpleados.txt");
        FileReader fR;

        if (!f.exists()) {
            f.createNewFile();
        }

        fR = new FileReader(f);
        BufferedReader br = new BufferedReader(fR);
        String cadenaTexto = br.readLine();
        while (cadenaTexto != null) {
            String[] arrayDatosTexto = cadenaTexto.split("\\|");
            Empleado empleado = new Empleado(arrayDatosTexto[0], arrayDatosTexto[1], arrayDatosTexto[2]);

            Movimiento movimiento = new Movimiento(arrayDatosTexto[3], Double.parseDouble(arrayDatosTexto[4]), arrayDatosTexto[5], arrayDatosTexto[6], arrayDatosTexto[7], arrayDatosTexto[0]);
            listaDeEmpleado.add(empleado);
            listaDeMovimientos.add(movimiento);
            cadenaTexto = br.readLine();
        }
        //recorro lista de movimientos
        for (int x = 0; x < listaDeMovimientos.size(); x++) {
            Movimiento comprobarMovimiento = listaDeMovimientos.get(x);
            String numeroDeEmpleadoDeMovimiento = comprobarMovimiento.getNumeroDeEmpleado();
            //recorro Lista Empleados
            for (int y = 0; x < listaDeEmpleado.size(); y++) {

                Empleado comprobarEmpleado = listaDeEmpleado.get(y);

                String numeroDeEmpleadoDeEmpleado = comprobarEmpleado.getNumeroDeEmpleado();
                if (numeroDeEmpleadoDeEmpleado.equals(numeroDeEmpleadoDeMovimiento)) {
                    if (listaDeEmpleado.get(y).getListaDeMovimientos() == null) {
                        ArrayList<Movimiento> movimientoNuevo = new ArrayList<>();
                        listaDeEmpleado.get(y).setListaDeMovimientos(movimientoNuevo);
                    }
                    listaDeEmpleado.get(y).addListaDeMovimientos(comprobarMovimiento);
                    System.out.println(comprobarMovimiento);
                }

            }
        }
        if (eleccion == 0) {
            br.close();
            return listaDeEmpleado;
        } else {
            br.close();
            return listaDeMovimientos;
        }

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
        while (cadenaTexto != null) {
            String[] arrayDatosTexto = cadenaTexto.split("\\|");
            Empleado empleado = new Empleado(arrayDatosTexto[0], arrayDatosTexto[1], arrayDatosTexto[2]);

            Movimiento movimiento = new Movimiento(arrayDatosTexto[3], Double.parseDouble(arrayDatosTexto[4]), arrayDatosTexto[5], arrayDatosTexto[6], arrayDatosTexto[7], arrayDatosTexto[0]);
            listaDeEmpleado.add(empleado);
            listaDeMovimientos.add(movimiento);
            cadenaTexto = br.readLine();
        }
        //recorro lista de movimientos
        for (int x = 0; x < listaDeMovimientos.size(); x++) {
            Movimiento comprobarMovimiento = listaDeMovimientos.get(x);
            String numeroDeEmpleadoDeMovimiento = comprobarMovimiento.getNumeroDeEmpleado();
            //recorro Lista Empleados
            for (int y = 0; x < listaDeEmpleado.size(); y++) {

                Empleado comprobarEmpleado = listaDeEmpleado.get(y);

                String numeroDeEmpleadoDeEmpleado = comprobarEmpleado.getNumeroDeEmpleado();
                if (numeroDeEmpleadoDeEmpleado.equals(numeroDeEmpleadoDeMovimiento)) {
                    if (listaDeEmpleado.get(y).getListaDeMovimientos() == null) {
                        ArrayList<Movimiento> movimientoNuevo = new ArrayList<>();
                        listaDeEmpleado.get(y).setListaDeMovimientos(movimientoNuevo);
                    }
                    listaDeEmpleado.get(y).addListaDeMovimientos(comprobarMovimiento);
                    System.out.println(comprobarMovimiento);
                }

            }
        }
        if (eleccion == 0) {
            br.close();
            return listaDeEmpleado;
        } else {
            br.close();
            return listaDeMovimientos;
        }

    }

}
