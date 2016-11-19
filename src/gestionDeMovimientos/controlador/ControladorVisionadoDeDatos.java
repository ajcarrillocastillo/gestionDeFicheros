/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;
import DAO.FicheroObjetosEmpleado;
import gestionDeMovimientos.vista.JFrameVisionadoDeEmpleados;
/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeDatos {
       private  JFrameVisionadoDeEmpleados vistaVisionadoDeDatos;
       
      public ControladorVisionadoDeDatos(JFrameVisionadoDeEmpleados visionadoDeDatos) {
        this.vistaVisionadoDeDatos = visionadoDeDatos;
        FicheroObjetosEmpleado.devolverFicherosEscritura();
    }
     
      public void AbrirPeliculaMiLista() {
        ControladorInsertardoDeDatos.AbrirInsertadoDeDatos(vistaVisionadoDeDatos);
    }
}

