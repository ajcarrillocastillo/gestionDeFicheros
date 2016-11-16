/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.vista;

import gestionDeMovimientos.controlador.ControladorInsertardoDeDatos;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author jesus
 */
public class JDialogInsertadoDeDatos extends javax.swing.JDialog {
    
    private ControladorInsertardoDeDatos controladorInsertadoDeDatos;
    private boolean flagNumeroEmpleado = false;
    private boolean flagNombreEmpleado = false;
    private boolean flagApellidoEmpleado = false;
    private boolean flagIdMovimiento = false;
    private boolean flagImporteMovimiento = false;
    private boolean flagFechaMovimiento = false;
    /**
     * Creates new form JFrameInsertadoDeDatos
     */
    public JDialogInsertadoDeDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controladorInsertadoDeDatos= new ControladorInsertardoDeDatos(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInsertarDatos = new javax.swing.JPanel();
        jLabelInsertarDatos = new javax.swing.JLabel();
        jTextFieldNumerodeEmpleado = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldImporte = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox();
        jTextFieldFecha = new javax.swing.JTextField();
        jButtonInsertarTexto = new javax.swing.JButton();
        jButtonInsertarBinario = new javax.swing.JButton();
        jButtonInsertarObjeto = new javax.swing.JButton();
        jButtonInsertarXML = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelInsertarDatos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelInsertarDatos.setText("Insertar Datos");

        jTextFieldNumerodeEmpleado.setForeground(new java.awt.Color(126, 126, 126));
        jTextFieldNumerodeEmpleado.setText("Numero");
        jTextFieldNumerodeEmpleado.setToolTipText("Numero de Empleado");
        jTextFieldNumerodeEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumerodeEmpleadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumerodeEmpleadoFocusLost(evt);
            }
        });

        jTextFieldNombre.setForeground(new java.awt.Color(126, 126, 126));
        jTextFieldNombre.setText("Nombre");
        jTextFieldNombre.setToolTipText("Nombre del Empleado");
        jTextFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFocusLost(evt);
            }
        });

        jTextFieldApellido.setForeground(new java.awt.Color(126, 126, 126));
        jTextFieldApellido.setText("Apellidos");
        jTextFieldApellido.setToolTipText("Apellidos del Empleado");
        jTextFieldApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldApellidoFocusLost(evt);
            }
        });

        jTextFieldId.setForeground(new java.awt.Color(126, 126, 126));
        jTextFieldId.setText("Id");
        jTextFieldId.setToolTipText("Id de Movimiento");
        jTextFieldId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIdFocusLost(evt);
            }
        });

        jTextFieldImporte.setForeground(new java.awt.Color(126, 126, 126));
        jTextFieldImporte.setText("Importe");
        jTextFieldImporte.setToolTipText("Importe de Movimiento");
        jTextFieldImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldImporteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldImporteFocusLost(evt);
            }
        });

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gasto", "Ingreso" }));
        jComboBoxTipo.setToolTipText("Tipo de Movimiento");

        jTextFieldFecha.setForeground(new java.awt.Color(126, 126, 126));
        jTextFieldFecha.setText("20/01/2000");
        jTextFieldFecha.setToolTipText("Fecha De Movimiento");
        jTextFieldFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFechaFocusLost(evt);
            }
        });

        jButtonInsertarTexto.setText("Texto");
        jButtonInsertarTexto.setToolTipText("Insertar los datos en el archivo Texto");

        jButtonInsertarBinario.setText("Binario");
        jButtonInsertarBinario.setToolTipText("Insertar los datos en el archivo Binario");

        jButtonInsertarObjeto.setText("Objeto");
        jButtonInsertarObjeto.setToolTipText("Insertar los datos en el archivo Objeto");

        jButtonInsertarXML.setText("XML");
        jButtonInsertarXML.setToolTipText("Insertar los datos en el archivo XML");

        javax.swing.GroupLayout jPanelInsertarDatosLayout = new javax.swing.GroupLayout(jPanelInsertarDatos);
        jPanelInsertarDatos.setLayout(jPanelInsertarDatosLayout);
        jPanelInsertarDatosLayout.setHorizontalGroup(
            jPanelInsertarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInsertarDatosLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabelInsertarDatos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelInsertarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInsertarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInsertarDatosLayout.createSequentialGroup()
                        .addComponent(jTextFieldNumerodeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInsertarDatosLayout.createSequentialGroup()
                        .addComponent(jButtonInsertarTexto)
                        .addGap(18, 18, 18)))
                .addGroup(jPanelInsertarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInsertarDatosLayout.createSequentialGroup()
                        .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInsertarDatosLayout.createSequentialGroup()
                        .addComponent(jButtonInsertarBinario)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonInsertarObjeto)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonInsertarXML)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelInsertarDatosLayout.setVerticalGroup(
            jPanelInsertarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInsertarDatosLayout.createSequentialGroup()
                .addComponent(jLabelInsertarDatos)
                .addGap(33, 33, 33)
                .addGroup(jPanelInsertarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumerodeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(jPanelInsertarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsertarBinario)
                    .addComponent(jButtonInsertarObjeto)
                    .addComponent(jButtonInsertarXML)
                    .addComponent(jButtonInsertarTexto)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInsertarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInsertarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumerodeEmpleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumerodeEmpleadoFocusGained
        flagNumeroEmpleado=controladorInsertadoDeDatos.VaciarCampos(evt, jTextFieldNumerodeEmpleado, flagNumeroEmpleado);
    }//GEN-LAST:event_jTextFieldNumerodeEmpleadoFocusGained

    private void jTextFieldNumerodeEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumerodeEmpleadoFocusLost
          if (jTextFieldNumerodeEmpleado.getText().isEmpty()) {
        flagNumeroEmpleado=controladorInsertadoDeDatos.RellenarCampos(evt, "Numero", jTextFieldNumerodeEmpleado, flagNumeroEmpleado); 
        
        }else{
           controladorInsertadoDeDatos.limitarCampos(jTextFieldNumerodeEmpleado, 1); 
        }
    }//GEN-LAST:event_jTextFieldNumerodeEmpleadoFocusLost

    private void jTextFieldNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFocusGained
       flagNombreEmpleado=controladorInsertadoDeDatos.VaciarCampos(evt,jTextFieldNombre , flagNombreEmpleado);
    }//GEN-LAST:event_jTextFieldNombreFocusGained

    private void jTextFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFocusLost
        if (jTextFieldNombre.getText().isEmpty()) {
        flagNombreEmpleado=controladorInsertadoDeDatos.RellenarCampos(evt, "Nombre", jTextFieldNombre, flagNombreEmpleado); 
        
        }else{
           controladorInsertadoDeDatos.limitarCampos(jTextFieldNombre, 2); 
        }
    }//GEN-LAST:event_jTextFieldNombreFocusLost

    private void jTextFieldApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldApellidoFocusGained
       flagApellidoEmpleado=controladorInsertadoDeDatos.VaciarCampos(evt,jTextFieldApellido , flagApellidoEmpleado);
    }//GEN-LAST:event_jTextFieldApellidoFocusGained

    private void jTextFieldApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldApellidoFocusLost
        if (jTextFieldApellido.getText().isEmpty()) {
        flagApellidoEmpleado=controladorInsertadoDeDatos.RellenarCampos(evt, "Apellidos", jTextFieldApellido, flagApellidoEmpleado); 
        
        }else{
           controladorInsertadoDeDatos.limitarCampos(jTextFieldApellido, 2); 
        }
    }//GEN-LAST:event_jTextFieldApellidoFocusLost

    private void jTextFieldIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdFocusGained
        flagIdMovimiento=controladorInsertadoDeDatos.VaciarCampos(evt,jTextFieldId , flagIdMovimiento);
    }//GEN-LAST:event_jTextFieldIdFocusGained

    private void jTextFieldIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdFocusLost
        if (jTextFieldId.getText().isEmpty()) {
        flagIdMovimiento=controladorInsertadoDeDatos.RellenarCampos(evt, "Id", jTextFieldId, flagIdMovimiento); 
        
        }else{
           controladorInsertadoDeDatos.limitarCampos(jTextFieldId, 2); 
        }
    }//GEN-LAST:event_jTextFieldIdFocusLost

    private void jTextFieldImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldImporteFocusGained
        flagImporteMovimiento=controladorInsertadoDeDatos.VaciarCampos(evt,jTextFieldImporte , flagImporteMovimiento);
    }//GEN-LAST:event_jTextFieldImporteFocusGained

    private void jTextFieldImporteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldImporteFocusLost
        if (jTextFieldImporte.getText().isEmpty()) {
        flagImporteMovimiento=controladorInsertadoDeDatos.RellenarCampos(evt, "Importe", jTextFieldImporte, flagImporteMovimiento); 
        
        }else{
           controladorInsertadoDeDatos.limitarCampos(jTextFieldImporte, 2); 
        }
    }//GEN-LAST:event_jTextFieldImporteFocusLost

    private void jTextFieldFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFechaFocusGained
        flagFechaMovimiento=controladorInsertadoDeDatos.VaciarCampos(evt,jTextFieldFecha , flagFechaMovimiento);
    }//GEN-LAST:event_jTextFieldFechaFocusGained

    private void jTextFieldFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFechaFocusLost
            if (jTextFieldFecha.getText().isEmpty()) {
        flagFechaMovimiento=controladorInsertadoDeDatos.RellenarCampos(evt, "20/01/2000", jTextFieldFecha, flagFechaMovimiento); 
        
        }else{
           controladorInsertadoDeDatos.limitarCampos(jTextFieldFecha, 2); 
        }
    }//GEN-LAST:event_jTextFieldFechaFocusLost

    public boolean isFlagNumeroEmpleado() {
        return flagNumeroEmpleado;
    }

    public void setFlagNumeroEmpleado(boolean flagNumeroEmpleado) {
        this.flagNumeroEmpleado = flagNumeroEmpleado;
    }

    public boolean isFlagNombreEmpleado() {
        return flagNombreEmpleado;
    }

    public void setFlagNombreEmpleado(boolean flagNombreEmpleado) {
        this.flagNombreEmpleado = flagNombreEmpleado;
    }

    public boolean isFlagApellidoEmpleado() {
        return flagApellidoEmpleado;
    }

    public void setFlagApellidoEmpleado(boolean flagApellidoEmpleado) {
        this.flagApellidoEmpleado = flagApellidoEmpleado;
    }

    public boolean isFlagIdMovimiento() {
        return flagIdMovimiento;
    }

    public void setFlagIdMovimiento(boolean flagIdMovimiento) {
        this.flagIdMovimiento = flagIdMovimiento;
    }

    public boolean isFlagImporteMovimiento() {
        return flagImporteMovimiento;
    }

    public void setFlagImporteMovimiento(boolean flagImporteMovimiento) {
        this.flagImporteMovimiento = flagImporteMovimiento;
    }

    public boolean isFlagFechaMovimiento() {
        return flagFechaMovimiento;
    }

    public void setFlagFechaMovimiento(boolean flagFechaMovimiento) {
        this.flagFechaMovimiento = flagFechaMovimiento;
    }

    public JButton getjButtonInsertar() {
        return jButtonInsertarObjeto;
    }

    public void setjButtonInsertar(JButton jButtonInsertar) {
        this.jButtonInsertarObjeto = jButtonInsertar;
    }

    public JComboBox getjComboBoxTipo() {
        return jComboBoxTipo;
    }

    public void setjComboBoxTipo(JComboBox jComboBoxTipo) {
        this.jComboBoxTipo = jComboBoxTipo;
    }

    public JTextField getjTextFieldApellido() {
        return jTextFieldApellido;
    }

    public void setjTextFieldApellido(JTextField jTextFieldApellido) {
        this.jTextFieldApellido = jTextFieldApellido;
    }

    public JTextField getjTextFieldFecha() {
        return jTextFieldFecha;
    }

    public void setjTextFieldFecha(JTextField jTextFieldFecha) {
        this.jTextFieldFecha = jTextFieldFecha;
    }

    public JTextField getjTextFieldId() {
        return jTextFieldId;
    }

    public void setjTextFieldId(JTextField jTextFieldId) {
        this.jTextFieldId = jTextFieldId;
    }

    public JTextField getjTextFieldImporte() {
        return jTextFieldImporte;
    }

    public void setjTextFieldImporte(JTextField jTextFieldImporte) {
        this.jTextFieldImporte = jTextFieldImporte;
    }

    public JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public void setjTextFieldNombre(JTextField jTextFieldNombre) {
        this.jTextFieldNombre = jTextFieldNombre;
    }

    public JTextField getjTextFieldNumerodeEmpleado() {
        return jTextFieldNumerodeEmpleado;
    }

    public void setjTextFieldNumerodeEmpleado(JTextField jTextFieldNumerodeEmpleado) {
        this.jTextFieldNumerodeEmpleado = jTextFieldNumerodeEmpleado;
    }

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogInsertadoDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogInsertadoDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogInsertadoDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogInsertadoDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogInsertadoDeDatos dialog = new JDialogInsertadoDeDatos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertarBinario;
    private javax.swing.JButton jButtonInsertarObjeto;
    private javax.swing.JButton jButtonInsertarTexto;
    private javax.swing.JButton jButtonInsertarXML;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabelInsertarDatos;
    private javax.swing.JPanel jPanelInsertarDatos;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldImporte;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumerodeEmpleado;
    // End of variables declaration//GEN-END:variables
}
