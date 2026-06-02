package Presentacion;
import java.time.LocalDate;
import javax.swing.Timer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
public class Reportes extends javax.swing.JFrame {
    

    private MenuPrincipal myPrincipal;
    public Reportes(MenuPrincipal mp) {
        initComponents();
        this.myPrincipal=mp;
        cargarRutas();
        setLocationRelativeTo(null);
        mp.getReloj().addActionListener(e -> actualizarReloj());
        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            myPrincipal.setVisible(true);
                }
        });
    }
        private void actualizarReloj() {
        DateTimeFormatter formatoF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoH = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaActual = LocalTime.now();
        LocalDate fecha = LocalDate.now();
        lblHora.setText("Fecha: "+formatoF.format(fecha)+"\nHora: "+horaActual.format(formatoH)); 
    }
    
    private void cargarRutas(){

    String rutas =
            myPrincipal.getMyEmpresa().cargarRutas();

    String[] lista = rutas.split(",");

    for(String r : lista){

        if(!r.isEmpty()){
            cmdRutas.addItem(r);
        }
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cmdReporteRuta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMostrarRuta = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cmdRutas = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cmdReporteDiario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMostrarDiario = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        cmdReporteFecha = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMostrarFecha = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cmdFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cmdFechaFin = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblHora = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("REPORTES DEL SISTEMA");

        cmdReporteRuta.setText("Generar Reporte Completo");
        cmdReporteRuta.addActionListener(this::cmdReporteRutaActionPerformed);

        txtMostrarRuta.setColumns(20);
        txtMostrarRuta.setRows(5);
        jScrollPane2.setViewportView(txtMostrarRuta);

        jLabel4.setText("Rutas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(cmdReporteRuta)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdReporteRuta)
                    .addComponent(jLabel4)
                    .addComponent(cmdRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas por Ruta", jPanel2);

        cmdReporteDiario.setText("Generar Reporte Completo");
        cmdReporteDiario.addActionListener(this::cmdReporteDiarioActionPerformed);

        txtMostrarDiario.setColumns(20);
        txtMostrarDiario.setRows(5);
        jScrollPane3.setViewportView(txtMostrarDiario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(cmdReporteDiario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdReporteDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reporte Diario", jPanel1);

        cmdReporteFecha.setText("Generar Reporte Completo");
        cmdReporteFecha.addActionListener(this::cmdReporteFechaActionPerformed);

        txtMostrarFecha.setColumns(20);
        txtMostrarFecha.setRows(5);
        jScrollPane4.setViewportView(txtMostrarFecha);

        jLabel2.setText("Fecha inicio:");

        jLabel3.setText("Fecha fin:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdReporteFecha)
                        .addGap(23, 23, 23))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdReporteFecha)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(cmdFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas por Fecha", jPanel3);

        lblHora.setEditable(false);
        jScrollPane1.setViewportView(lblHora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdReporteFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReporteFechaActionPerformed
        // TODO add your handling code here:
            if(cmdFechaInicio.getDate() == null
            || cmdFechaFin.getDate() == null){

        txtMostrarFecha.setText(
                "Debe seleccionar ambas fechas"
        );

        return;
    }

    LocalDate inicio =
            cmdFechaInicio.getDate()
                    .toInstant()
                    .atZone(
                        java.time.ZoneId.systemDefault()
                    )
                    .toLocalDate();

    LocalDate fin =
            cmdFechaFin.getDate()
                    .toInstant()
                    .atZone(
                        java.time.ZoneId.systemDefault()
                    )
                    .toLocalDate();
    if(inicio.isAfter(fin)){

    txtMostrarFecha.setText(
            "La fecha inicial no puede ser mayor a la fecha final"
    );

    return;
}

    String reporte =
            myPrincipal.getMyEmpresa()
                    .reportePorFechas(inicio, fin);

    txtMostrarFecha.setText(reporte);
    }//GEN-LAST:event_cmdReporteFechaActionPerformed

    private void cmdReporteRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReporteRutaActionPerformed
        // TODO add your handling code here:
            String ruta =
            cmdRutas.getSelectedItem().toString();

    String reporte =
            myPrincipal.getMyEmpresa()
                    .reporteVentasRuta(ruta);

    txtMostrarRuta.setText(reporte);
    }//GEN-LAST:event_cmdReporteRutaActionPerformed

    private void cmdReporteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReporteDiarioActionPerformed
        // TODO add your handling code here:
            String reporte =
            myPrincipal.getMyEmpresa()
                    .reporteDiario();

    txtMostrarDiario.setText(reporte);
    }//GEN-LAST:event_cmdReporteDiarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser cmdFechaFin;
    private com.toedter.calendar.JDateChooser cmdFechaInicio;
    private javax.swing.JButton cmdReporteDiario;
    private javax.swing.JButton cmdReporteFecha;
    private javax.swing.JButton cmdReporteRuta;
    private javax.swing.JComboBox<String> cmdRutas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane lblHora;
    private javax.swing.JTextArea txtMostrarDiario;
    private javax.swing.JTextArea txtMostrarFecha;
    private javax.swing.JTextArea txtMostrarRuta;
    // End of variables declaration//GEN-END:variables
}
