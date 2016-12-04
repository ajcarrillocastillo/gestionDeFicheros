/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import gestionDeMovimientos.modelo.Movimiento;
import gestionDeMovimientos.vista.JDialogVerMovimientos;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeMovimientos {
    private ArrayList<Movimiento> listaDeMovimientos;
    private TableModelNoEditable TableModelNEMovimientos;
    private JDialogVerMovimientos VistaverMovimientos;

    public ControladorVisionadoDeMovimientos(ArrayList listaMovimientosEmpleados) {
        listaDeMovimientos=new ArrayList();
        listaDeMovimientos=listaMovimientosEmpleados;
        
        VistaverMovimientos = new JDialogVerMovimientos(null, true);
        //Le decimos quien es su Controlador.
        VistaverMovimientos.setControladorVerMovimientos(this);
        //Le ponemos la Localización en el centro
        VistaverMovimientos.setLocationRelativeTo(null);
        //Creamos el TableModel
        TableModelNEMovimientos = new TableModelNoEditable();
        //Le decimos quien va a ser su modelo de tabla. en este caso será noEditable.
        VistaverMovimientos.getjTableMovimientos().setModel(TableModelNEMovimientos);
        //Listar CLientes y asignarColumnaVerMovimientos
        asignarColumnaVerMovimientos(TableModelNEMovimientos);
        //Según lo que pase (de 0 a 3) cargará un listar u otro.
        listarMovimientos(TableModelNEMovimientos);
        
        //Ponemos la verMovimientos visible.
        VistaverMovimientos.setVisible(true);
    }
     public void asignarColumnaVerMovimientos(TableModelNoEditable modeloTabla){
        modeloTabla.addColumn("Numero De Movimiento");
        modeloTabla.addColumn("Importe");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Descripción");
    }
   /**
     * Listar Movimientos con la extension txt.
     * @param modeloTabla 
     */
    public void listarMovimientos(TableModelNoEditable modeloTabla){
        //borra los registros de la tabla y los vuelve a rellenar
        while(modeloTabla.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        //Creamos numero de columnas que habrá:
        Object[] columna = new Object[5];
       
        
        
            for(Movimiento m: listaDeMovimientos ){
                columna[0] = m.getNumeroDeMovimiento();
                columna[1] = m.getImporte();
                columna[2] = m.getTipo();
                columna[3] = m.getFecha();
                columna[4] = m.getDescripcion();
                modeloTabla.addRow(columna);
            }

    }
    
    
    
    
}
