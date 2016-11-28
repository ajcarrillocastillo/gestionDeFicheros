
package gestionDeMovimientos.controlador;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class TableModelNoEditable extends DefaultTableModel {
/**
 * 
 * @param row
 * @param column
 * @return volvemos false una celda
 */
 @Override
 public boolean isCellEditable (int row, int column)
    {
        
       
        return false;
    }
}