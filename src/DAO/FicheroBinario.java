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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus
 */
public class FicheroBinario {

    private ArrayList<Empleado> listaDeEmpleado;
    private ArrayList<Movimiento> listaDeMovimientos;

    public FicheroBinario() {
        listaDeEmpleado = new ArrayList<Empleado>();
        listaDeMovimientos = new ArrayList<Movimiento>();
    }
    private static FicheroBinario ficheroBinario = null;

    public static FicheroBinario devolver() {

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
    public boolean escribirFicheroEmpleadosDat(String numeroDeEmpleado, String nombre,
            String apellido) throws IOException {
        boolean existe = false;

        ArrayList<Empleado> listaDeEmpleadosComparar = leerFicherosEmpleadosDat();
        for (Empleado e : listaDeEmpleadosComparar) {
            if (e.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                existe = true;
            }
        }
        if (!existe) {

            /**
             * Declaramos el fichero
             */
            File f = new File("./FicheroEmpleadosDeDatos.dat");
            FileOutputStream fOS;
            if (!f.exists()) {
                f.createNewFile();
            }
            /**
             * Escribimos los datos
             */
            fOS = new FileOutputStream(f, true);
            try (DataOutputStream dOS = new DataOutputStream(fOS)) {
                dOS.writeUTF(numeroDeEmpleado);
                dOS.writeUTF(nombre);
                dOS.writeUTF(apellido);

            }
        }
        return existe;
    }

    public boolean escribirFicheroMovimientoDat(String numeroDeMovimiento, double Importe, String tipo, String fecha, String descripcion, String numeroDeEmpleado) throws IOException {
        /**
         * Declaramos el fichero
         */
        boolean existe = false;
        ArrayList<Movimiento> listaComprobarMovimiento = new ArrayList();
        listaComprobarMovimiento = leerFicherosMovimientoDat();
        for (Movimiento m : listaComprobarMovimiento) {
            if (m.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                if (m.getNumeroDeMovimiento().equals(numeroDeMovimiento)) {
                    existe = true;
                }
            }

        }
        if (!existe) {
            try {
                File f = new File("./FicheroMovimientosDeDatos.dat");
                FileOutputStream fOS;
                if (!f.exists()) {
                    f.createNewFile();
                }
                /**
                 * Escribimos los datos
                 */
                fOS = new FileOutputStream(f, true);
                DataOutputStream dOS = new DataOutputStream(fOS);

                dOS.writeUTF(numeroDeMovimiento);
                dOS.writeDouble(Importe);
                dOS.writeUTF(tipo);
                dOS.writeUTF(fecha);
                dOS.writeUTF(descripcion);
                dOS.writeUTF(numeroDeEmpleado);

            } catch (IOException ex) {
                Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return existe;
    }

    public ArrayList leerFicherosEmpleadosDat() throws IOException {

      
        /**
         * Declaramos el ficheros
         */
        File f = new File("FicheroEmpleadosDeDatos.dat");
        FileInputStream fIS;
        if (!f.exists()) {
            f.createNewFile();
        }

        /**
         * Leemos los datos de un fichero binario
         */
        fIS = new FileInputStream(f);
        try (DataInputStream dIS = new DataInputStream(fIS)) {
            listaDeMovimientos.removeAll(listaDeMovimientos);
            listaDeEmpleado.removeAll(listaDeEmpleado);
            listaDeMovimientos = leerFicherosMovimientoDat();
            while (dIS.available() > 0) {
                ArrayList<Movimiento> listaDeMovimientosEmpleado = new ArrayList();
                String numeroDeEmpleado = dIS.readUTF();
                String nombre = dIS.readUTF();
                String apellido = dIS.readUTF();

                
                for (Movimiento m : listaDeMovimientos) {
                    if (m.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                        listaDeMovimientosEmpleado.add(m);

                    }
                }
                Empleado empleadoDat = new Empleado(numeroDeEmpleado, nombre, apellido, listaDeMovimientosEmpleado);
                addListaDeEmpleados(empleadoDat);
            }
            dIS.close();
            return listaDeEmpleado;
        }

    }

    public ArrayList leerFicherosMovimientoDat() throws IOException {

        /**
         * Declaramos el ficheros
         */
        File f = new File("FicheroMovimientosDeDatos.dat");
        FileInputStream fIS;
        if (!f.exists()) {
            f.createNewFile();
        }

        /**
         * Leemos los datos de un fichero binario
         */
        fIS = new FileInputStream(f);
        try (DataInputStream dIS = new DataInputStream(fIS)) {
            listaDeMovimientos.removeAll(listaDeMovimientos);
            while (dIS.available() > 0) {
                String numeroDeMovimiento = dIS.readUTF();
                double Importe = dIS.readDouble();
                String tipo = dIS.readUTF();
                String fecha = dIS.readUTF();
                String descripcion = dIS.readUTF();
                String numeroDeEmpleado = dIS.readUTF();

                //leer movimientos
                Movimiento movimientoDat = new Movimiento(numeroDeMovimiento, Importe, tipo, fecha, descripcion, numeroDeEmpleado);
                addListaDeMovimientos(movimientoDat);
            }
            dIS.close();

        }
        return listaDeMovimientos;
    }

    private void addListaDeMovimientos(Movimiento movimiento) {
        this.listaDeMovimientos.add(movimiento);
    }

    private void addListaDeEmpleados(Empleado empleado) {
        this.listaDeEmpleado.add(empleado);
    }
}
