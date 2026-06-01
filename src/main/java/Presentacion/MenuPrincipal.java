package Presentacion;
import Negocio.Empresa;
import javax.swing.Timer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import java.awt.Image;

public class MenuPrincipal extends javax.swing.JFrame {
    
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());
    private Empresa myEmpresa;
    private Timer reloj;
    
    public MenuPrincipal() {
        this.myEmpresa=new Empresa();
        initComponents();
        setLocationRelativeTo(null);
        iniciarReloj();
        bloquearSistema();
        activarIcons();
        
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
    
    private void iniciarReloj(){
        
        reloj = new Timer(1000, e -> {
            DateTimeFormatter formatoF =DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatoH=DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaActual = LocalTime.now();
            LocalDate fecha=LocalDate.now();
            lblHora.setText("Fecha: "+formatoF.format(fecha)+"\nHora: "+horaActual.format(formatoH));
            myEmpresa.validarMinimoTiquetes();
            myEmpresa.validarEstadoSalidas();
            
        });

        reloj.start();
        
    }
    
    public Timer getReloj() {
    return reloj;
    }
    private void activarIcons(){
        
        ImageIcon iconoCaja = new ImageIcon(getClass().getResource("/Imagenes/caja.png"));
        
        Image imgCaja = iconoCaja.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);

        cmdCajaDia.setIcon(new ImageIcon(imgCaja));
        
        ImageIcon iconoVenta = new ImageIcon(getClass().getResource("/Imagenes/venta.png"));
        
        Image imgVenta = iconoVenta.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);

        cmdVenta.setIcon(new ImageIcon(imgVenta));
        
        ImageIcon iconoParametrizacion = new ImageIcon(getClass().getResource("/Imagenes/parametrizacion.png"));
        
        Image imgParametrizacion = iconoParametrizacion.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);

        cmdParametrizacion.setIcon(new ImageIcon(imgParametrizacion));
        
        ImageIcon iconoCancelar = new ImageIcon(getClass().getResource("/Imagenes/cancelar.png"));
        
        Image imgCancelaciones = iconoCancelar.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);

        cmdCancelaciones.setIcon(new ImageIcon(imgCancelaciones));
        
        ImageIcon iconoReporte = new ImageIcon(getClass().getResource("/Imagenes/reporte.png"));
        
        Image imgReportes = iconoReporte.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);

        cmdReportes.setIcon(new ImageIcon(imgReportes));
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lblHora = new javax.swing.JTextPane();

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

        lblHora.setEditable(false);
        jScrollPane1.setViewportView(lblHora);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmdCajaDia, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(cmdVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmdParametrizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(cmdCancelaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(cmdReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdCajaDia, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(cmdParametrizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(cmdCancelaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdReportes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane lblHora;
    // End of variables declaration//GEN-END:variables
}
