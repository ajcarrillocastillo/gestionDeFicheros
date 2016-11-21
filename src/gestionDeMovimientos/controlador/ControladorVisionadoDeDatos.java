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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeDatos {

    private JFrameVisionadoDeEmpleados vistaVisionadoDeDatos;
    private ArrayList<Empleado> listaDeEmpleado;

    public ControladorVisionadoDeDatos(JFrameVisionadoDeEmpleados visionadoDeDatos) {
        this.vistaVisionadoDeDatos = visionadoDeDatos;
        FicheroObjetosEmpleado.devolverFicherosEscritura();
    }

    public void RellenarTabla(JTable tablaEmpleados, int tipoFichero) {
        //Sección 1 
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
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
            Logger.getLogger(ControladorVisionadoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVisionadoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Sección 2
        Object[] fila = new Object[6];

        //Sección 3
        fila[0] = txtNombrecontacto.getText();
        fila[1] = txtApellidoscontacto.getText();
        fila[2] = txtEmail.getText();
        fila[3] = txtTelefono.getText();
        fila[4] = txtDireccion.getText();
        fila[5] = cboxSexo.getSelectedItem().toString();

        //Sección 4
        modelo.addRow(fila);

        //Sección 5
        tblDatos.setModel(modelo);

    }

    public void AbrirPeliculaMiLista() {
        ControladorInsertardoDeDatos.AbrirInsertadoDeDatos(vistaVisionadoDeDatos);
    }
}
