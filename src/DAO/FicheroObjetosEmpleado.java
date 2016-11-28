
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
    private Movimiento movimiento;
    private boolean flagEmpleadoExistente;

    public FicheroObjetosEmpleado() {
        this.flagEmpleadoExistente = false;
        listaDeEmpleado = new ArrayList<Empleado>();
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
        public void escribirFicherosObjEmpleado(String numeroDeEmpleado, String nombre,
        String apellido, String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion ) throws IOException, ClassNotFoundException
        {

        File f = new File("EmpleadoObjeto.dat");
        FileOutputStream fOS;
        movimiento = new Movimiento(numeroDeMovimiento, Importe, tipo, fecha, descripcion, numeroDeEmpleado);
 
        if (!f.exists()) {
            f.createNewFile();
        }

        if (f.length() > 0) {
            leerFicherosObjEmpleado();
        }

        fOS = new FileOutputStream(f, false);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);

        if (listaDeEmpleado == null) {
            listaDeEmpleado = new ArrayList<Empleado>();
        }
        
         for (int x = 0; x < listaDeEmpleado.size(); x++) {
                Empleado comprobarEmpleado = listaDeEmpleado.get(x);
                   if(comprobarEmpleado.getNumeroDeEmpleado()==numeroDeEmpleado){
                    flagEmpleadoExistente=true;
                    listaDeEmpleado.get(x).addListaDeMovimientos(movimiento);
                    
         }
                
         }
         if (flagEmpleadoExistente==false){
        listaDeEmpleado.add(new Empleado( numeroDeEmpleado,nombre,apellido));
         }

        for (Empleado c : listaDeEmpleado) {
            oOS.writeObject(c);
        }

        oOS.close();
    }
        
         public ArrayList leerFicherosObjEmpleado() throws IOException, ClassNotFoundException {

        File f = new File("./EmpleadosObjetos.dat");
        if (!f.exists()) {
            f.createNewFile();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        listaDeEmpleado.removeAll(listaDeEmpleado);
        listaDeEmpleado = (ArrayList< Empleado>) ois.readObject();
        ois.close();
        return listaDeEmpleado;
    }
}
