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
    private static FicheroObjetosMovimiento ficheroObjetosMovimiento = null;

    public static FicheroObjetosMovimiento devolverFicherosEscritura() {

        if (ficheroObjetosMovimiento != null) {
            return ficheroObjetosMovimiento;
        } else {
            ficheroObjetosMovimiento = new FicheroObjetosMovimiento();
            return ficheroObjetosMovimiento;
        }
    }
        public void escribirFicherosObjMovimiento( String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion, String numeroDeEmpleado ) throws IOException, ClassNotFoundException
        {
        File f = new File("MovimientoObjeto.dat");
        FileOutputStream fOS;
        if (!f.exists()) {
            f.createNewFile();
        }
        if (f.length() > 0) {
            leerFicherosObjMovimiento();
        }
        fOS = new FileOutputStream(f, false);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);

        if (listaDeMovimientos == null) {
            listaDeMovimientos = new ArrayList<Movimiento>();
        }
        

        listaDeMovimientos.add(new Movimiento(numeroDeMovimiento, Importe, tipo, fecha, descripcion, numeroDeEmpleado));
         
        for (Movimiento c : listaDeMovimientos) {
            oOS.writeObject(c);
        }

        oOS.close();
    }
        
         public ArrayList leerFicherosObjMovimiento() throws IOException, ClassNotFoundException {

        File f = new File("./MovientoObjetos.dat");
        if (!f.exists()) {
            f.createNewFile();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

        listaDeMovimientos.removeAll(listaDeMovimientos);
        listaDeMovimientos = (ArrayList< Movimiento>) ois.readObject();
        ois.close();
        return listaDeMovimientos;
    }
}
