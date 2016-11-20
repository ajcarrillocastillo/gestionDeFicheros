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
import gestionDeMovimientos.vista.JDialogInsertadoDeDatos;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jesus
 */
public class ControladorInsertardoDeDatos {

    private final JDialogInsertadoDeDatos vistaInsertadoDeDatos;

    public ControladorInsertardoDeDatos(JDialogInsertadoDeDatos vistaInsertadoDeDatos) {
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
        String numeroDeMovimiento= vistaInsertadoDeDatos.getjTextFieldNumeroDeMovimiento().getText();
        String importeString = vistaInsertadoDeDatos.getjTextFieldImporte().getText();
        String tipo = vistaInsertadoDeDatos.getjComboBoxTipo().getSelectedItem()+"";
        String fecha = vistaInsertadoDeDatos.getjTextFieldFecha().getText();
        String descripcion = vistaInsertadoDeDatos.getjTextAreaDescripcion().getText() ;
        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty()||numeroDeMovimiento.isEmpty()||importeString.isEmpty()||tipo.isEmpty()||fecha.isEmpty()||descripcion.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
        double importe=Double.parseDouble(importeString);
            try {
                FicheroBinario.devolverFicherosEscritura().escribirFicherosDat(numeroDeEmpleado, nombre, apellido, numeroDeMovimiento, importe, tipo, fecha, descripcion);
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;
            } catch (IOException ex) {
                Logger.getLogger(ControladorInsertardoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            }
        }
        
        return control;
    }
    
      public boolean InsertarDatosTexto() {
        boolean control=false;
        String numeroDeEmpleado =vistaInsertadoDeDatos.getjTextFieldNumerodeEmpleado().getText();
        String nombre = vistaInsertadoDeDatos.getjTextFieldNombre().getText();
        String apellido = vistaInsertadoDeDatos.getjTextFieldApellido().getText();
        String numeroDeMovimiento= vistaInsertadoDeDatos.getjTextFieldNumeroDeMovimiento().getText();
        String importeString = vistaInsertadoDeDatos.getjTextFieldImporte().getText();
        String tipo = vistaInsertadoDeDatos.getjComboBoxTipo().getSelectedItem()+"";
        String fecha = vistaInsertadoDeDatos.getjTextFieldFecha().getText();
        String descripcion = vistaInsertadoDeDatos.getjTextAreaDescripcion().getText() ;
        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty()||numeroDeMovimiento.isEmpty()||importeString.isEmpty()||tipo.isEmpty()||fecha.isEmpty()||descripcion.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
        double importe=Double.parseDouble(importeString);
            try {
                FicheroTexto.devolverFicherosEscritura().escribirFicheroTxtClientes(numeroDeEmpleado, nombre, apellido, numeroDeMovimiento, importe, tipo, fecha, descripcion);
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;
            } catch (IOException ex) {
                Logger.getLogger(ControladorInsertardoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            }
        }
        
        return control;
    }
      
       public boolean InsertarDatosObjeto() {
        boolean control=false;
        String numeroDeEmpleado =vistaInsertadoDeDatos.getjTextFieldNumerodeEmpleado().getText();
        String nombre = vistaInsertadoDeDatos.getjTextFieldNombre().getText();
        String apellido = vistaInsertadoDeDatos.getjTextFieldApellido().getText();
        String numeroDeMovimiento= vistaInsertadoDeDatos.getjTextFieldNumeroDeMovimiento().getText();
        String importeString = vistaInsertadoDeDatos.getjTextFieldImporte().getText();
        String tipo = vistaInsertadoDeDatos.getjComboBoxTipo().getSelectedItem()+"";
        String fecha = vistaInsertadoDeDatos.getjTextFieldFecha().getText();
        String descripcion = vistaInsertadoDeDatos.getjTextAreaDescripcion().getText() ;
        if(numeroDeEmpleado.isEmpty()|| nombre.isEmpty()||apellido.isEmpty()||numeroDeMovimiento.isEmpty()||importeString.isEmpty()||tipo.isEmpty()||fecha.isEmpty()||descripcion.isEmpty())
        {
         control=false;
        JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
        double importe=Double.parseDouble(importeString);
            try {
                FicheroObjetosEmpleado.devolverFicherosEscritura().escribirFicherosObjEmpleado(numeroDeEmpleado, nombre, apellido, numeroDeMovimiento, importe, tipo, fecha, descripcion);
                FicheroObjetosMovimiento.devolverFicherosEscritura().escribirFicherosObjMovimiento(numeroDeMovimiento, importe, tipo, fecha, descripcion, numeroDeEmpleado);
                JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;
            } catch (IOException ex) {
                Logger.getLogger(ControladorInsertardoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Error al insertar Datos en el fichero binario contacte con el programador", "Error", JOptionPane.ERROR_MESSAGE);
                control=false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorInsertardoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return control;
    }
      

    //Abrir Insertar Datos   
    public static void AbrirInsertadoDeDatos(JFrame jFrame) {
        JDialogInsertadoDeDatos nuevaVistaInsertadoDeDatos = new JDialogInsertadoDeDatos(jFrame, true);
        nuevaVistaInsertadoDeDatos.setLocationRelativeTo(null);
        nuevaVistaInsertadoDeDatos.setVisible(true);
    }
}
