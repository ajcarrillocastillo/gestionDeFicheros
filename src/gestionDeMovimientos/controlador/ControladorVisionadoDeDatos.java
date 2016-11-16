/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;
import gestionDeMovimientos.vista.JFrameVisionadoDeDatos;
/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeDatos {
       private final JFrameVisionadoDeDatos vistaVisionadoDeDatos;
       
     public ControladorVisionadoDeDatos(JFrameVisionadoDeDatos vistaVisionadoDeDatos) {
        this.vistaVisionadoDeDatos = vistaVisionadoDeDatos;

    }
     
      public void AbrirPeliculaMiLista() {
        ControladorInsertardoDeDatos.AbrirInsertadoDeDatos(vistaVisionadoDeDatos);
    }
}

