/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import DAO.*;
import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.vista.JDialogInsertadoMovimientos;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.transform.TransformerException;

/**
 *
 * @author jesus
 */
public class ControladorInsertardoDeMovimientos {

    private ArrayList<Empleado> listaDeEmpleados;
    private int tipoDeFichero;
    private JDialogInsertadoMovimientos vistaMovimientos;
    private int tipoDeDatos;

    public ControladorInsertardoDeMovimientos(ArrayList listaDeEmpleado, int tipoDeDatos) {
        this.tipoDeDatos = tipoDeDatos;
        this.listaDeEmpleados = listaDeEmpleado;
        this.vistaMovimientos = new JDialogInsertadoMovimientos(null, true);
        vistaMovimientos.setControladorAnnadirMovimientos(this);
        vistaMovimientos.getjComboBoxNumeroDeEmpleado().removeAllItems();
        for (Empleado e : this.listaDeEmpleados) {
            vistaMovimientos.getjComboBoxNumeroDeEmpleado().addItem(e.getNumeroDeEmpleado());
        }
        vistaMovimientos.setLocationRelativeTo(null);
        vistaMovimientos.setVisible(true);
    }

    //vaciar campos
    /**
     *
     * @param evt
     * @param seleccion
     */
    public boolean VaciarCampos(JTextField campo, boolean flag) {
        if (flag == false) {
            campo.setText("");
            campo.setForeground(Color.black);
            flag = true;
        }
        return flag;
    }

    public boolean VaciarCampos(JTextArea campo, boolean flag) {
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

    public void limitadorNumeros(java.awt.event.KeyEvent evt) {
        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }
    }

    public boolean insertarDatosMovimientos() {
        boolean control=true;
        String numeroDeMovimiento= vistaMovimientos.getjTextFieldNumeroDeMovimiento().getText();
        String importeString= vistaMovimientos.getjTextFieldImporte().getText();
        String tipo= ""+vistaMovimientos.getjComboBoxTipo().getSelectedItem().toString();
        String fecha= vistaMovimientos.getjTextFieldFecha().getText();
        String descripcion=vistaMovimientos.getjTextAreaDescripcion().getText();
        String numeroDeEmpleado=""+vistaMovimientos.getjComboBoxNumeroDeEmpleado().getSelectedItem().toString();
        if(numeroDeMovimiento.isEmpty()|| importeString.isEmpty()||tipo.isEmpty()||fecha.isEmpty()||descripcion.isEmpty()|| numeroDeEmpleado.isEmpty()){
        control=false;
         JOptionPane.showMessageDialog(vistaMovimientos, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                
        }else{
        
        double importe= Double.parseDouble(importeString);
        try {
            switch (tipoDeDatos) {
                case 0:
                    
                    control=true;
                    if(FicheroTexto.devolver().escribirFicheroTxtMovimientos(numeroDeMovimiento, importe, tipo, fecha, descripcion, numeroDeEmpleado)){
                    JOptionPane.showMessageDialog(vistaMovimientos, "Ya existe el Movimiento", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaMovimientos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
                    break;
                case 1:
                         
                    control=true;
                    if(FicheroBinario.devolver().escribirFicheroMovimientoDat(numeroDeMovimiento, importe, tipo, fecha, descripcion, numeroDeEmpleado)){
                    JOptionPane.showMessageDialog(vistaMovimientos, "Ya existe el Movimiento", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaMovimientos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
                    break;
                case 2:
                    control=true;
                    if(FicheroObjetosMovimiento.devolver().escribirFicherosObjMovimiento(numeroDeMovimiento, importe, tipo, fecha, descripcion, numeroDeEmpleado)){
                    JOptionPane.showMessageDialog(vistaMovimientos, "Ya existe el Movimiento", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaMovimientos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
                    break;
                case 3:
                      control=true;
                    if(FicheroXML.devolver().escribirFicheroXMLMovimientos(numeroDeMovimiento, importe, tipo, fecha, descripcion, numeroDeEmpleado)){
                    JOptionPane.showMessageDialog(vistaMovimientos, "Ya existe el Movimiento", "Error", JOptionPane.ERROR_MESSAGE);
                    control=false;
                }else{
                JOptionPane.showMessageDialog(vistaMovimientos, "Se han insertado los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                control=true;}
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            control=false;
            Logger.getLogger(ControladorInsertardoDeMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (ClassNotFoundException ex) {
             control=false;
                Logger.getLogger(ControladorInsertardoDeMovimientos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                 control=false;
                Logger.getLogger(ControladorInsertardoDeMovimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     return control;
    }
}
