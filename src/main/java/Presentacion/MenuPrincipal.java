/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;
import Negocio.Empresa;

public class MenuPrincipal extends javax.swing.JFrame {
    
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());
    /**
     * Creates new form MenuPrincipal
     */
    private Empresa myEmpresa;
    
    public MenuPrincipal() {
        this.myEmpresa=new Empresa();
        //aqui no
        this.myEmpresa.registrarDatosBase();
        initComponents();
    }

    public Empresa getMyEmpresa() {
        return myEmpresa;
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmdCajaDia = new javax.swing.JButton();
        cmdParametrizacion = new javax.swing.JButton();
        cmdCancelaciones = new javax.swing.JButton();
        cmdVenta = new javax.swing.JButton();
        cmdReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");

        cmdCajaDia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmdCajaDia.setText("Caja Del Dia");
        cmdCajaDia.addActionListener(this::cmdCajaDiaActionPerformed);

        cmdParametrizacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmdParametrizacion.setText("Parametrización");
        cmdParametrizacion.addActionListener(this::cmdParametrizacionActionPerformed);

        cmdCancelaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmdCancelaciones.setText("Cancelaciones");
        cmdCancelaciones.addActionListener(this::cmdCancelacionesActionPerformed);

        cmdVenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmdVenta.setText("Venta");
        cmdVenta.addActionListener(this::cmdVentaActionPerformed);

        cmdReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmdReportes.setText("Reportes");
        cmdReportes.addActionListener(this::cmdReportesActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdCajaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdParametrizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(cmdCancelaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(cmdReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCajaDia)
                    .addComponent(cmdParametrizacion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdVenta)
                    .addComponent(cmdCancelaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdReportes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCajaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCajaDiaActionPerformed
     // TODO add your handling code here:
     FrmCajaDia cajaDia=new FrmCajaDia(this);
     cajaDia.setVisible(true);
    }//GEN-LAST:event_cmdCajaDiaActionPerformed

    private void cmdParametrizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdParametrizacionActionPerformed
    // TODO add your handling code here:
    Parametrizacion myParametrizacion=new Parametrizacion(this);
    myParametrizacion.setVisible(true);
    }//GEN-LAST:event_cmdParametrizacionActionPerformed

    private void cmdCancelacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelacionesActionPerformed
       // TODO add your handling code here:
       
    }//GEN-LAST:event_cmdCancelacionesActionPerformed

    private void cmdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVentaActionPerformed
       // TODO add your handling code here:
       FrmVentaDePasajes venta=new FrmVentaDePasajes(this);
       venta.setVisible(true);
    }//GEN-LAST:event_cmdVentaActionPerformed

    private void cmdReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReportesActionPerformed
      // TODO add your handling code here:
      Reportes reportes=new Reportes(this);
      reportes.setVisible(true);
    }//GEN-LAST:event_cmdReportesActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCajaDia;
    private javax.swing.JButton cmdCancelaciones;
    private javax.swing.JButton cmdParametrizacion;
    private javax.swing.JButton cmdReportes;
    private javax.swing.JButton cmdVenta;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
