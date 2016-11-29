/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import DAO.FicheroBinario;
import DAO.FicheroObjetosEmpleado;
import DAO.FicheroTexto;
import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.vista.JFrameVisionadoDeEmpleados;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeEmpleados {

    private JFrameVisionadoDeEmpleados vistaVisionadoDeDatos;
    private ArrayList<Empleado> listaDeEmpleado;

    public ControladorVisionadoDeEmpleados(JFrameVisionadoDeEmpleados visionadoDeDatos) {
        this.vistaVisionadoDeDatos = visionadoDeDatos;
        FicheroObjetosEmpleado.devolverFicherosEscritura();
    }
    public void creaColumnas(TableModelNoEditable modelo){
        modelo.addColumn("Numero de Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cantidad de Movimientos");
    }

    public void RellenarTabla(JTable tablaEmpleados, int tipoFichero) {
        //Sección 1 
        TableModelNoEditable modelo = new TableModelNoEditable();
        tablaEmpleados.setModel(modelo);
        creaColumnas(modelo);
        
        
        try {
            switch (tipoFichero) {
                case 0:
                    listaDeEmpleado = FicheroTexto.devolverFicherosEscritura().leerFicheroTxtEmpleados(0);
                    break;
                    
                case 1:
                    listaDeEmpleado = FicheroBinario.devolverFicherosEscritura().leerFicherosDat(0);
                    break;
                    
                case 2:
                    listaDeEmpleado = FicheroObjetosEmpleado.devolverFicherosEscritura().leerFicherosObjEmpleado();
                    break;
                    
                case 3:
                    break;
                    
                default:
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Sección 2
        Object[] columna = new Object[4];
        
        for(Empleado e: listaDeEmpleado){
            columna[0]=e.getNumeroDeEmpleado();
            columna[1]=e.getApellido();
            columna[2]=e.getNombre();
            columna[3]="2";
        }
       
       
        //Sección 5
        tablaEmpleados.setModel(modelo);
        tablaEmpleados.repaint();

    }

    public void AbrirInsertadoDeDatos() {
        ControladorInsertardoDeDatos.AbrirInsertadoDeDatos(vistaVisionadoDeDatos);
    }
   /* public void AbrirVerMovimiento(String nombreEmpleado){
        new contro
    }*/
}
