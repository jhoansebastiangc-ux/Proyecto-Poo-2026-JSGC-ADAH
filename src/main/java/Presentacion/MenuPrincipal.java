package Presentacion;
import Negocio.Empresa;
import javax.swing.Timer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
public class MenuPrincipal extends javax.swing.JFrame {
    
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());
    private Empresa myEmpresa;
    private Timer reloj;
    
    public MenuPrincipal() {
        this.myEmpresa=new Empresa();
        initComponents();
        setLocationRelativeTo(null);
        bloquearSistema();
    }

    public Empresa getMyEmpresa() {
        return myEmpresa;
    }
    public void bloquearSistema(){
            cmdParametrizacion.setEnabled(false);
            cmdVenta.setEnabled(false);
            cmdCancelaciones.setEnabled(false);
            cmdReportes.setEnabled(false);
    }
        public void habiitarSistema(){
            cmdParametrizacion.setEnabled(true);
            cmdVenta.setEnabled(true);
            cmdCancelaciones.setEnabled(true);
            cmdReportes.setEnabled(true);  
    }
    
    /*private void iniciarReloj(){
        
        reloj = new Timer(1000, e -> {
            DateTimeFormatter formatoF =DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatoH=DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaActual = LocalTime.now();
            LocalDate fecha=LocalDate.now();
            lblHora.setText("Fecha: "+formatoF.format(fecha)+"\nHora: "+horaActual.format(formatoH));

        });

        reloj.start();
    }*/
    


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
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");

        cmdCajaDia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmdCajaDia.setText("Abrir Caja Del Dia");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdCajaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdParametrizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdCancelaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(cmdReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdParametrizacion)
                    .addComponent(cmdCajaDia, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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
     AperturaCaja cajaDia=new AperturaCaja(this);
     cajaDia.setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_cmdCajaDiaActionPerformed

    private void cmdParametrizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdParametrizacionActionPerformed
    // TODO add your handling code here:
    Parametrizacion myParametrizacion=new Parametrizacion(this);
    myParametrizacion.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_cmdParametrizacionActionPerformed

    private void cmdCancelacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelacionesActionPerformed
       // TODO add your handling code here:
       Cancelaciones cancelacion=new Cancelaciones(this);
       cancelacion.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_cmdCancelacionesActionPerformed

    private void cmdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVentaActionPerformed
       // TODO add your handling code here:
       FrmVentaDePasajes venta=new FrmVentaDePasajes(this);
       venta.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_cmdVentaActionPerformed

    private void cmdReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReportesActionPerformed
      // TODO add your handling code here:
      Reportes reportes=new Reportes(this);
      reportes.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_cmdReportesActionPerformed

    public static void main(String args[]) {
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
