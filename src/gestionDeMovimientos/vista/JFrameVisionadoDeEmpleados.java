/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.vista;
import gestionDeMovimientos.controlador.ControladorVisionadoDeEmpleados;
import javax.swing.JTable;
/**
 *
 * @author jesus
 */
public class JFrameVisionadoDeEmpleados extends javax.swing.JFrame {
      private final ControladorVisionadoDeEmpleados controladorVisionadoDeEmpleados;
    /**
     * Creates new form visionadoDeDatos
     */
    public JFrameVisionadoDeEmpleados() {
        initComponents();
        controladorVisionadoDeEmpleados = new ControladorVisionadoDeEmpleados(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        jButtonVerTexto = new javax.swing.JButton();
        jButtonVerBinario = new javax.swing.JButton();
        jButtonVerObjeto = new javax.swing.JButton();
        jButtonVerXML = new javax.swing.JButton();
        jMenuBarVisionadoDeDatos = new javax.swing.JMenuBar();
        jMenuInsertadoDeDatos = new javax.swing.JMenu();
        jMenuItemInsertadoDeEmpleados = new javax.swing.JMenuItem();
        jMenuItemInsertadoDeMovimientosTexto = new javax.swing.JMenuItem();
        jMenuItemInsertadoDeMovimientosBinario = new javax.swing.JMenuItem();
        jMenuItemInsertadoDeMovimientosObjeto = new javax.swing.JMenuItem();
        jMenuItemInsertadoDeMovimientosXML = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero De Empleado", "Nombre", "Apellido", "Cantidad De Movimientos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmpleados);

        jButtonVerTexto.setText("Texto");
        jButtonVerTexto.setToolTipText("Insertar los datos en el archivo Texto");
        jButtonVerTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerTextoActionPerformed(evt);
            }
        });

        jButtonVerBinario.setText("Binario");
        jButtonVerBinario.setToolTipText("Insertar los datos en el archivo Binario");
        jButtonVerBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerBinarioActionPerformed(evt);
            }
        });

        jButtonVerObjeto.setText("Objeto");
        jButtonVerObjeto.setToolTipText("Insertar los datos en el archivo Objeto");
        jButtonVerObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerObjetoActionPerformed(evt);
            }
        });

        jButtonVerXML.setText("XML");
        jButtonVerXML.setToolTipText("Insertar los datos en el archivo XML");
        jButtonVerXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerXMLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButtonVerTexto)
                .addGap(18, 18, 18)
                .addComponent(jButtonVerBinario)
                .addGap(26, 26, 26)
                .addComponent(jButtonVerObjeto)
                .addGap(31, 31, 31)
                .addComponent(jButtonVerXML)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerBinario)
                    .addComponent(jButtonVerObjeto)
                    .addComponent(jButtonVerXML)
                    .addComponent(jButtonVerTexto))
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jMenuInsertadoDeDatos.setText("Insertar Datos");

        jMenuItemInsertadoDeEmpleados.setText("Insertar Empleados");
        jMenuItemInsertadoDeEmpleados.setToolTipText("Inserta todos los datos de movimientos y usuario");
        jMenuItemInsertadoDeEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertadoDeEmpleadosActionPerformed(evt);
            }
        });
        jMenuInsertadoDeDatos.add(jMenuItemInsertadoDeEmpleados);

        jMenuItemInsertadoDeMovimientosTexto.setText("Insertar Movimientos Texto");
        jMenuItemInsertadoDeMovimientosTexto.setToolTipText("Inserta todos los datos de movimientos y usuario");
        jMenuItemInsertadoDeMovimientosTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertadoDeMovimientosTextoActionPerformed(evt);
            }
        });
        jMenuInsertadoDeDatos.add(jMenuItemInsertadoDeMovimientosTexto);

        jMenuItemInsertadoDeMovimientosBinario.setText("Insertar Movimientos Binario");
        jMenuItemInsertadoDeMovimientosBinario.setToolTipText("Inserta todos los datos de movimientos y usuario");
        jMenuItemInsertadoDeMovimientosBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertadoDeMovimientosBinarioActionPerformed(evt);
            }
        });
        jMenuInsertadoDeDatos.add(jMenuItemInsertadoDeMovimientosBinario);

        jMenuItemInsertadoDeMovimientosObjeto.setText("Insertar Movimientos Objeto");
        jMenuItemInsertadoDeMovimientosObjeto.setToolTipText("Inserta todos los datos de movimientos y usuario");
        jMenuItemInsertadoDeMovimientosObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertadoDeMovimientosObjetoActionPerformed(evt);
            }
        });
        jMenuInsertadoDeDatos.add(jMenuItemInsertadoDeMovimientosObjeto);

        jMenuItemInsertadoDeMovimientosXML.setText("Insertar Movimientos XML");
        jMenuItemInsertadoDeMovimientosXML.setToolTipText("Inserta todos los datos de movimientos y usuario");
        jMenuItemInsertadoDeMovimientosXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertadoDeMovimientosXMLActionPerformed(evt);
            }
        });
        jMenuInsertadoDeDatos.add(jMenuItemInsertadoDeMovimientosXML);

        jMenuBarVisionadoDeDatos.add(jMenuInsertadoDeDatos);

        setJMenuBar(jMenuBarVisionadoDeDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemInsertadoDeEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInsertadoDeEmpleadosActionPerformed
        controladorVisionadoDeEmpleados.AbrirInsertadoDeEmpleados();
    }//GEN-LAST:event_jMenuItemInsertadoDeEmpleadosActionPerformed

    private void jButtonVerBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerBinarioActionPerformed
      controladorVisionadoDeEmpleados.RellenarTabla(1);
    }//GEN-LAST:event_jButtonVerBinarioActionPerformed

    private void jButtonVerTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerTextoActionPerformed
     controladorVisionadoDeEmpleados.RellenarTabla(0); 
    }//GEN-LAST:event_jButtonVerTextoActionPerformed

    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMouseClicked
   
        controladorVisionadoDeEmpleados.AbrirVerMovimiento(evt, jTableEmpleados);
        
    }//GEN-LAST:event_jTableEmpleadosMouseClicked

    private void jMenuItemInsertadoDeMovimientosTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInsertadoDeMovimientosTextoActionPerformed
     
       controladorVisionadoDeEmpleados.AbrirInsertadoDeMovimientos(0);  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemInsertadoDeMovimientosTextoActionPerformed

    private void jMenuItemInsertadoDeMovimientosBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInsertadoDeMovimientosBinarioActionPerformed
       controladorVisionadoDeEmpleados.AbrirInsertadoDeMovimientos(1); 
    }//GEN-LAST:event_jMenuItemInsertadoDeMovimientosBinarioActionPerformed

    private void jMenuItemInsertadoDeMovimientosObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInsertadoDeMovimientosObjetoActionPerformed
        controladorVisionadoDeEmpleados.AbrirInsertadoDeMovimientos(2); 
    }//GEN-LAST:event_jMenuItemInsertadoDeMovimientosObjetoActionPerformed

    private void jMenuItemInsertadoDeMovimientosXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInsertadoDeMovimientosXMLActionPerformed
        controladorVisionadoDeEmpleados.AbrirInsertadoDeMovimientos(3); 
    }//GEN-LAST:event_jMenuItemInsertadoDeMovimientosXMLActionPerformed

    private void jButtonVerObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerObjetoActionPerformed
        controladorVisionadoDeEmpleados.RellenarTabla(2); 
    }//GEN-LAST:event_jButtonVerObjetoActionPerformed

    private void jButtonVerXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerXMLActionPerformed
       controladorVisionadoDeEmpleados.RellenarTabla(3); 
    }//GEN-LAST:event_jButtonVerXMLActionPerformed

    public JTable getjTableEmpleados() {
        return jTableEmpleados;
    }

    public void setjTableEmpleados(JTable jTableEmpleados) {
        this.jTableEmpleados = jTableEmpleados;
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
            java.util.logging.Logger.getLogger(JFrameVisionadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVisionadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVisionadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVisionadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                    JFrameVisionadoDeEmpleados visionadoDeDatosCreado= new JFrameVisionadoDeEmpleados();
                    visionadoDeDatosCreado.setLocationRelativeTo(null);
                    visionadoDeDatosCreado.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVerBinario;
    private javax.swing.JButton jButtonVerObjeto;
    private javax.swing.JButton jButtonVerTexto;
    private javax.swing.JButton jButtonVerXML;
    private javax.swing.JMenuBar jMenuBarVisionadoDeDatos;
    private javax.swing.JMenu jMenuInsertadoDeDatos;
    private javax.swing.JMenuItem jMenuItemInsertadoDeEmpleados;
    private javax.swing.JMenuItem jMenuItemInsertadoDeMovimientosBinario;
    private javax.swing.JMenuItem jMenuItemInsertadoDeMovimientosObjeto;
    private javax.swing.JMenuItem jMenuItemInsertadoDeMovimientosTexto;
    private javax.swing.JMenuItem jMenuItemInsertadoDeMovimientosXML;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmpleados;
    // End of variables declaration//GEN-END:variables
}
