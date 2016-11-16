/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import gestionDeMovimientos.vista.JDialogInsertadoDeDatos;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jesus
 */
public class ControladorInsertardoDeDatos {
    private final JDialogInsertadoDeDatos vistaInsertadoDeDatos;
     private static final String PATTERN_NUMERICO = "^\\d+$";
    
    public ControladorInsertardoDeDatos(JDialogInsertadoDeDatos vistaInsertadoDeDatos){
    this.vistaInsertadoDeDatos=vistaInsertadoDeDatos;
    }

     
      //vaciar campos
    /**
     *
     * @param evt
     * @param seleccion
     */
    public boolean VaciarCampos(java.awt.event.FocusEvent evt, JTextField campo,boolean flag) {
                if (flag == false) {
                    campo.setText("");
                    campo.setForeground(Color.black);
                    flag=true;
                }
                return flag;
    }

     
      public boolean RellenarCampos(java.awt.event.FocusEvent evt, String Texto,JTextField campo,boolean flag) {
               
               campo.setText(Texto);
               campo.setForeground(Color.GRAY);
               flag=false;
               return flag;
    }

    /**
     *
     * @param minimo 
     * @return
     */
    public boolean limitarCampos(JTextField campo,int minimo) {
        boolean superaLimite = limitadorDeDatos(campo.getText(), minimo);
        if (!superaLimite) {
            JOptionPane.showMessageDialog(vistaInsertadoDeDatos, "Debe tener mas de " + minimo, "Error", JOptionPane.ERROR_MESSAGE);

        } 
        return superaLimite;
    }
      public  boolean limitadorDeDatos(String nombre,int minimo) {
        boolean superaMinimo = false;
        if (nombre.length() >= minimo) {
            superaMinimo = true;

        }
        return superaMinimo;
    }
      //Valida Si Hay numeros
      public static boolean validateNumeros(String numero) {
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_NUMERICO);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }
      
       //Abrir Insertar Datos   
     public static void AbrirInsertadoDeDatos(JFrame jFrame) {
       JDialogInsertadoDeDatos nuevaVistaInsertadoDeDatos=new JDialogInsertadoDeDatos(jFrame, true);
           nuevaVistaInsertadoDeDatos.setLocationRelativeTo(null);
        nuevaVistaInsertadoDeDatos.setVisible(true);
    }
}
