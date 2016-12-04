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

    //Singleton

    public static FicheroBinario devolver() {

        if (ficheroBinario != null) {
            return ficheroBinario;
        } else {
            ficheroBinario = new FicheroBinario();
            return ficheroBinario;
        }
    }

    /**
     * escribe el fichero de Empleados
     *
     * @param numeroDeEmpleado
     * @param nombre
     * @param apellido
     * @return boolean para saber si existe
     * @throws IOException
     */

    public boolean escribirFicheroEmpleadosDat(String numeroDeEmpleado, String nombre,
            String apellido) throws IOException {
        boolean existe = false;
        /**
         * Recogemos la lista de empleados y comprobamos si existe
         */
        ArrayList<Empleado> listaDeEmpleadosComparar = leerFicherosEmpleadosDat();
        for (Empleado e : listaDeEmpleadosComparar) {
            if (e.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                existe = true;
            }
        }
        if (!existe) {

            /**
             * Declaramos el fichero Esto se hace en todas las de escritura y
             * lectutra igual
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

    /**
     * Escribimos el fichero de movimientos
     *
     * @param numeroDeMovimiento
     * @param Importe
     * @param tipo
     * @param fecha
     * @param descripcion
     * @param numeroDeEmpleado
     * @return boolean para saber si existe
     * @throws IOException
     */
    public boolean escribirFicheroMovimientoDat(String numeroDeMovimiento, double Importe, String tipo, String fecha, String descripcion, String numeroDeEmpleado) throws IOException {

        boolean existe = false;
        /**
         * comprobamos si existe el movimiento en ese empleado
         */
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

    /**
     * leemos el fichero de Empleados
     *
     * @return devolvemos la lista de empleados
     * @throws IOException
     */
    public ArrayList leerFicherosEmpleadosDat() throws IOException {

        File f = new File("FicheroEmpleadosDeDatos.dat");
        FileInputStream fIS;
        if (!f.exists()) {
            f.createNewFile();
        }

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

                /**
                 * rellenamos la lista de movimientos de los empleados
                 */
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
    /**
     * lee el fichero movimientos
     * @return Arraylist de Movimientos
     * @throws IOException 
     */
    public ArrayList leerFicherosMovimientoDat() throws IOException {

        File f = new File("FicheroMovimientosDeDatos.dat");
        FileInputStream fIS;
        if (!f.exists()) {
            f.createNewFile();
        }

        fIS = new FileInputStream(f);
        try (DataInputStream dIS = new DataInputStream(fIS)) {
            listaDeMovimientos.removeAll(listaDeMovimientos);
            /**
             * recorremos el fichero para rellenar la lista de movimientos
             */
            while (dIS.available() > 0) {
                String numeroDeMovimiento = dIS.readUTF();
                double Importe = dIS.readDouble();
                String tipo = dIS.readUTF();
                String fecha = dIS.readUTF();
                String descripcion = dIS.readUTF();
                String numeroDeEmpleado = dIS.readUTF();
                Movimiento movimientoDat = new Movimiento(numeroDeMovimiento, Importe, tipo, fecha, descripcion, numeroDeEmpleado);
                addListaDeMovimientos(movimientoDat);
            }
            dIS.close();

        }
        return listaDeMovimientos;
    }
    /**
     * 
     * @param movimiento 
     */
    private void addListaDeMovimientos(Movimiento movimiento) {
        this.listaDeMovimientos.add(movimiento);
    }
    /**
     * 
     * @param empleado 
     */
    private void addListaDeEmpleados(Empleado empleado) {
        this.listaDeEmpleado.add(empleado);
    }
}
