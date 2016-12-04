/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import DAO.FicheroBinario;
import DAO.FicheroObjetosEmpleado;
import DAO.FicheroObjetosMovimiento;
import DAO.FicheroTexto;
import DAO.FicheroXML;
import gestionDeMovimientos.vista.JDialogInsertadoEmpleados;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.transform.TransformerException;

/**
 *
 * @author jesus
 */
public class ControladorInsertardoDeEmpleados {

    private final JDialogInsertadoEmpleados vistaInsertadoDeDatos;

    public ControladorInsertardoDeEmpleados(JDialogInsertadoEmpleados vistaInsertadoDeDatos) {
        this.vistaInsertadoDeDatos = vistaInsertadoDeDatos;
    }

    //vaciar campos
    /**
     *
     * @param evt
     * @param seleccion
     */
    public boolean VaciarCampos( JTextField campo, boolean flag) {
        if (flag == false) {
            campo.setText("");
            campo.setForeground(Color.black);
            flag = true;
        }
        return flag;
    }
    
     public boolean VaciarCampos( JTextArea campo, boolean flag) {
        if (flag == false) {
            campo.setText("");
            campo.setForeground(Color.black);
            flag = true;
        }
        return flag;
    }

    public boolean RellenarCampos(String Texto, JTextField campo, boolean flag) {

        campo.setText(Texto);
        campo.setForeground(Color.GRAY);
        flag = false;
        return flag;
    }
    
      public boolean RellenarCampos(String Texto, JTextArea campo, boolean flag) {

        campo.setText(Texto);
        campo.setForeground(Color.GRAY);
        flag = false;
        return flag;
    }


    
    public void limitadorNumeros(java.awt.event.KeyEvent evt){
     char letra=evt.getKeyChar();
        if(!Character.isDigit(letra)){
        evt.consume();
        }
    }


    public boolean InsertarDatosBinario() {
        boolean control=false;
        String numeroDeEmpleado =vistaInsertadoDeDatos.getjTextFieldNumerodeEmpleado().getText();
        String nombre = vistaInsertadoDeDatos.getjTextFieldNombre().getText();
        String apellido = vistaInsertadoDeDatos.getjTextFieldApellido().getText();

        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
            try {
                if(FicheroBinario.devolver().escribirFicheroEmpleadosDat(numeroDeEmpleado, nombre, apellido)){
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Ya existe el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
            } catch (IOException ex) {
                Logger.getLogger(ControladorInsertardoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            }
        }
        
        return control;
    }
    
      public boolean InsertarEmpleadosTexto() {
        boolean control=false;
        String numeroDeEmpleado =vistaInsertadoDeDatos.getjTextFieldNumerodeEmpleado().getText();
        String nombre = vistaInsertadoDeDatos.getjTextFieldNombre().getText();
        String apellido = vistaInsertadoDeDatos.getjTextFieldApellido().getText();
        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
        
            try {
                if(FicheroTexto.devolver().escribirFicheroTxtEmpleados(numeroDeEmpleado, nombre, apellido)){
                    JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Ya existe el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
            } catch (IOException ex) {
                Logger.getLogger(ControladorInsertardoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            }
        }
        
        return control;
    }
      
          public boolean InsertarEmpleadosObjetos() {
        boolean control=false;
        String numeroDeEmpleado =vistaInsertadoDeDatos.getjTextFieldNumerodeEmpleado().getText();
        String nombre = vistaInsertadoDeDatos.getjTextFieldNombre().getText();
        String apellido = vistaInsertadoDeDatos.getjTextFieldApellido().getText();
        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
        
            try {
                if(FicheroObjetosEmpleado.devolver().escribirFicherosObjEmpleado(numeroDeEmpleado, nombre, apellido)){
                    JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Ya existe el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
            } catch (IOException ex) {
                Logger.getLogger(ControladorInsertardoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorInsertardoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            }
        }
        
        return control;
    }
        public boolean InsertarEmpleadosXML() {
        boolean control=false;
        String numeroDeEmpleado =vistaInsertadoDeDatos.getjTextFieldNumerodeEmpleado().getText();
        String nombre = vistaInsertadoDeDatos.getjTextFieldNombre().getText();
        String apellido = vistaInsertadoDeDatos.getjTextFieldApellido().getText();
        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
        
            try {
                if(FicheroXML.devolver().escribirFicheroXMLEmpleados(numeroDeEmpleado, nombre, apellido)){
                    JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Ya existe el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
            } catch (TransformerException ex) {
                Logger.getLogger(ControladorInsertardoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            }
        }
        
        return control;
    }
      
    //Abrir Insertar Datos   
    public static void AbrirInsertadoDeDatos(JFrame jFrame) {
        JDialogInsertadoEmpleados nuevaVistaInsertadoDeDatos = new JDialogInsertadoEmpleados(jFrame, true);
        nuevaVistaInsertadoDeDatos.setLocationRelativeTo(null);
        nuevaVistaInsertadoDeDatos.setVisible(true);
    }
}
