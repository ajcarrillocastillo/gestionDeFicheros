/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class FicheroObjetos {
        public void escribirFicherosObjEmpleado(String numeroDeEmpleado , String nombre,
            String apellido) throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File archivo = new File("./FicheroDeObjetos.dat");
        FileOutputStream fos;

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        
        /**
         * ObjectOutputStream llama a la clase con la que escribiremos un objeto
         * en un fichero. Con writeObject escribimos el objeto. Lee el Fichero
         * antes de escribir en el para que no sobreescriba.
         */
        fos = new FileOutputStream(archivo, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /**
         * Escribimos el ArrayList dentro del fichero. Si no existe la
         * listaDeClientes se crea. se pasan por parametros los atributos y se
         * crea la clase.
         */

        if (listaDeClientes == null) {
            listaDeClientes = new ArrayList<Clientes>();
        }
        listaDeClientes.add(new Clientes(nombreCliente, DNI, nHabitacion, nNoches));
        oos.writeObject(listaDeClientes);
        /**
         * for (Clientes c: listaDeClientes) { oos.writeObject(listaDeClientes);
         * }
         *
         */
        oos.close();
    }
         public void leerFicherosObjClientes(String nombreFichero) throws IOException, ClassNotFoundException {
        /**
         * Declaramos todos los Ficheros. con el mkdir creamos el directorio.
         * Con el createNewFile creamos el Fichero
         */
        File rutaPrincipal = new File("./Hoteles");
        File subruta = new File("./Hoteles/" + nombreFichero);
        File archivo = new File("./Hoteles/" + nombreFichero + "/" + nombreFichero + "Clientes.obj");
        if (!rutaPrincipal.exists()) {
            rutaPrincipal.mkdir();
            subruta.mkdir();
        } else {
            subruta.mkdir();
        }

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        /**
         * ObjectInputStream llama a la clase con la que leemos un objeto en un
         * fichero. Con writeObject escribimos el objeto.
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));

        //probar el removeAll
        listaDeClientes.removeAll(listaDeClientes);
        listaDeClientes = (ArrayList< Clientes>) ois.readObject();
        ois.close();
    }
}
