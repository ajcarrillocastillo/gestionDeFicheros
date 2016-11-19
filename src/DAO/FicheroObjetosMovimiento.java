/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import gestionDeMovimientos.modelo.Movimiento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class FicheroObjetosMovimiento {
    private ArrayList<Movimiento> listaDeMovimientos;
    private Movimiento movimiento;
    private boolean flagEmpleadoExistente;

    public FicheroObjetosMovimiento() {
        listaDeMovimientos = new ArrayList<Movimiento>();
    }
    private static FicheroObjetosEmpleado ficheroObjetosEmpleado = null;

    public static FicheroObjetosEmpleado devolverFicherosEscritura() {

        if (ficheroObjetosEmpleado != null) {
            return ficheroObjetosEmpleado;
        } else {
            ficheroObjetosEmpleado = new FicheroObjetosEmpleado();
            return ficheroObjetosEmpleado;
        }
    }
        public void escribirFicherosObjEmpleado( String nombre,
        String apellido, String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion, String numeroDeEmpleado ) throws IOException, ClassNotFoundException
        {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File f = new File("MovimientoObjeto.dat");
        FileOutputStream fOS;
        if (!f.exists()) {
            f.createNewFile();
        }
        /**
         * Comprueba si el fichero está vacío o no. si no está vacío lee el
         * fichero y lo carga en memoria.
         */
        if (f.length() > 0) {
            leerFicherosObjMovimiento();
        }
        /**
         * ObjectOutputStream llama a la clase con la que escribiremos un objeto
         * en un fichero. Con writeObject escribimos el objeto. Lee el Fichero
         * antes de escribir en el para que no sobreescriba.
         */
        fOS = new FileOutputStream(f, false);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        /**
         * Escribimos el ArrayList dentro del fichero. Si no existe la
         * listaDeClientes se crea. se pasan por parametros los atributos y se
         * crea la clase.
         */

        if (listaDeMovimientos == null) {
            listaDeMovimientos = new ArrayList<Movimiento>();
        }
        

        listaDeMovimientos.add(new Movimiento(numeroDeMovimiento, Importe, tipo, fecha, descripcion, numeroDeEmpleado));
         
        //oos.writeObject(listaDeClientes);
        for (Movimiento c : listaDeMovimientos) {
            oOS.writeObject(c);
        }

        oOS.close();
    }
        
         public void leerFicherosObjMovimiento() throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File f = new File("./MovientoObjetos.dat");
        if (!f.exists()) {
            f.createNewFile();
        }
        /**
         * ObjectInputStream llama a la clase con la que leemos un objeto en un
         * fichero. Con writeObject escribimos el objeto.
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        //probar el removeAll
        listaDeMovimientos.removeAll(listaDeMovimientos);
        listaDeMovimientos = (ArrayList< Movimiento>) ois.readObject();
        ois.close();
    }
}
