/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import javax.swing.JDialog;

/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeMovimientos {
    String nombreEmpleado;
    JDialog verMovimientos;

    public ControladorVisionadoDeMovimientos(String nombreEmpleado, JDialog verMovimientos) {
        this.nombreEmpleado = nombreEmpleado;
        this.verMovimientos = verMovimientos;
    }
    
    
}
