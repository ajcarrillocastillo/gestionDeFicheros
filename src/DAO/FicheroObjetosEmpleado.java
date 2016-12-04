package DAO;

import gestionDeMovimientos.modelo.Empleado;
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
public class FicheroObjetosEmpleado {

    private ArrayList<Empleado> listaDeEmpleado;
    private ArrayList<Movimiento> listaDeMovimientos;

    public FicheroObjetosEmpleado() {
        listaDeEmpleado = new ArrayList<Empleado>();
        listaDeMovimientos = new ArrayList<Movimiento>();
    }
    private static FicheroObjetosEmpleado ficheroObjetosEmpleado = null;

    public static FicheroObjetosEmpleado devolver() {

        if (ficheroObjetosEmpleado != null) {
            return ficheroObjetosEmpleado;
        } else {
            ficheroObjetosEmpleado = new FicheroObjetosEmpleado();
            return ficheroObjetosEmpleado;
        }
    }

    public boolean escribirFicherosObjEmpleado(String numeroDeEmpleado, String nombre,
            String apellido) throws IOException, ClassNotFoundException {
        boolean existe = false;
        File f = new File("EmpleadosObjeto.dat");
        FileOutputStream fOS;
        if (!f.exists()) {
            f.createNewFile();
        }
        listaDeEmpleado.removeAll(listaDeEmpleado);
        if (f.length() > 0) {
            
            ArrayList<Empleado> listaComprobarEmpleado = new ArrayList();
            listaComprobarEmpleado = leerFicherosObjEmpleado();
            for (Empleado e : listaComprobarEmpleado) {
                if (e.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                    {
                        existe = true;
                    }
                }
            }
            listaDeEmpleado = leerFicherosObjEmpleado();
        }
        if (!existe) {
            fOS = new FileOutputStream(f, false);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);

            listaDeEmpleado.add(new Empleado(numeroDeEmpleado, nombre, apellido));

                oOS.writeObject(listaDeEmpleado);


            oOS.close();

        }
        return existe;
    }

    public ArrayList leerFicherosObjEmpleado() throws IOException, ClassNotFoundException {
          ArrayList<Empleado> listadeEmpleadoConMovimientos = new ArrayList();
     
        File f = new File("EmpleadosObjeto.dat");
        if (!f.exists()) {
            f.createNewFile();
        }
        if(f.length()>0){
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        listaDeEmpleado.removeAll(listaDeEmpleado);
        listaDeEmpleado = (ArrayList< Empleado>) ois.readObject();
      
        listaDeMovimientos.removeAll(listaDeMovimientos);
        listaDeMovimientos = FicheroObjetosMovimiento.devolver().leerFicherosObjMovimiento();
        for (Empleado e : listaDeEmpleado) {
               ArrayList<Movimiento> listadeMovimientosConEmpleados = new ArrayList();
            for (Movimiento m : listaDeMovimientos) {
                if (e.getNumeroDeEmpleado().equals(m.getNumeroDeEmpleado())) {
                    listadeMovimientosConEmpleados.add(m);
                }
            }
            listadeEmpleadoConMovimientos.add(new Empleado(e.getNumeroDeEmpleado(), e.getNombre(), e.getApellido(), listadeMovimientosConEmpleados));
        }
        ois.close();
        }
        return listadeEmpleadoConMovimientos;
    }
}
