package Presentacion;
import javax.swing.Timer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;

public class FrmVentaDePasajes extends javax.swing.JFrame {
    
    private MenuPrincipal myPrincipal;
    public FrmVentaDePasajes(MenuPrincipal mp) {
        initComponents();
        this.myPrincipal=mp;
        setLocationRelativeTo(null);
        mp.getReloj().addActionListener(e -> actualizarReloj());
        cargarSalidas();
        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            myPrincipal.setVisible(true);
                }
        });
        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
        autocompletarCliente();
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
    
    
    
    private void autocompletarCliente() {
    String documento = txtDocumento.getText().trim();

    if (documento.isEmpty()) {
        limpiarDatosCliente();
        return;
    }

    String cad = myPrincipal.getMyEmpresa().buscarDatosCliente(documento);

    if (cad.isEmpty()) {
        // Cliente nuevo — limpiar campos pero dejarlos editables
        limpiarDatosCliente();
        return;
    }

    // Cliente encontrado — rellenar campos
    String[] datos = cad.split(",");
    txtNombre.setText(datos[0]);
    txtTelefono.setText(datos[1]);
    txtCorreo.setText(datos[2]);

    // Mostrar tipo de cliente en el área de resultado
    txtMostrarS.setText("Cliente registrado encontrado:\n"
            + "Nombre: "   + datos[0] + "\n"
            + "Teléfono: " + datos[1] + "\n"
            + "Correo: "   + datos[2] + "\n"
            + "Tipo: "     + datos[3]);
}

private void limpiarDatosCliente() {
    txtNombre.setText("");
    txtTelefono.setText("");
    txtCorreo.setText("@");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmdSalidas = new javax.swing.JComboBox<>();
        cmdAsientos = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        cmdVender = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        cmdListar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBus = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTipoBus = new javax.swing.JTextField();
        cmdIdayVuelta = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrarS = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblHora = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("VENTA DE PASAJES");

        jLabel2.setText("Seleccionar Salida:");

        jLabel3.setText("Seleccionar Silla:");

        jLabel4.setText("Documento del Pasajero:");

        jLabel5.setText("Nombre del Pasajero:");

        cmdSalidas.addActionListener(this::cmdSalidasActionPerformed);

        cmdVender.setText("Vender");
        cmdVender.addActionListener(this::cmdVenderActionPerformed);

        jLabel6.setText("Origen:");

        jLabel7.setText("Destino:");

        txtOrigen.setEditable(false);
        txtOrigen.addActionListener(this::txtOrigenActionPerformed);

        txtDestino.setEditable(false);

        cmdListar.setText("Listar");
        cmdListar.addActionListener(this::cmdListarActionPerformed);

        jLabel8.setText("Fecha Salida:");

        txtFecha.setEditable(false);

        txtHora.setEditable(false);

        jLabel9.setText("Hora Salida:");

        txtBus.setEditable(false);
        txtBus.addActionListener(this::txtBusActionPerformed);

        jLabel10.setText("Bus Salida:");

        jLabel11.setText("Tipo de bus");

        txtTipoBus.setEditable(false);

        cmdIdayVuelta.setText("Desea comprar pasaje de ida y vuelta?");
        cmdIdayVuelta.addActionListener(this::cmdIdayVueltaActionPerformed);

        jLabel12.setText("Correo Contacto:");

        jLabel13.setText("Telefono Contacto:");

        txtCorreo.setText("@");
        txtCorreo.addActionListener(this::txtCorreoActionPerformed);

        txtTelefono.addActionListener(this::txtTelefonoActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSalidas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(22, 22, 22)
                                        .addComponent(txtOrigen))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDestino))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel9)))
                                                .addGap(2, 2, 2)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtHora)
                                                    .addComponent(txtBus)
                                                    .addComponent(txtFecha)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTipoBus)))))
                                .addGap(6, 6, 6)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdListar)
                        .addGap(18, 18, 18)
                        .addComponent(cmdVender)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmdAsientos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdIdayVuelta)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addComponent(txtTelefono)
                            .addComponent(txtNombre)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmdSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTipoBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdIdayVuelta)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdListar)
                    .addComponent(cmdVender))
                .addGap(30, 30, 30))
        );

        txtMostrarS.setEditable(false);
        txtMostrarS.setColumns(20);
        txtMostrarS.setRows(5);
        jScrollPane1.setViewportView(txtMostrarS);

        lblHora.setEditable(false);
        jScrollPane2.setViewportView(lblHora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalidasActionPerformed
        // TODO add your handling code here:
    if(cmdSalidas.getSelectedItem() == null){
        return;
    }
        cargarAsientos();
        String cad=this.myPrincipal.getMyEmpresa().cargarDatosSalida(cmdSalidas.getSelectedItem().toString());
        String[]datos=cad.split(",");
        txtOrigen.setText(datos[0]);
        txtDestino.setText(datos[1]);
        txtFecha.setText(datos[2]);
        txtHora.setText(datos[3]);
        txtBus.setText(datos[4]);
        txtTipoBus.setText(datos[5]);
    }//GEN-LAST:event_cmdSalidasActionPerformed

    private void cmdListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarActionPerformed
        // TODO add your handling code here:
        String cad="";
        if(cmdSalidas.getSelectedIndex()!=-1){
        String salida=cmdSalidas.getSelectedItem().toString();
        cad=this.myPrincipal.getMyEmpresa().listarTiquetes(salida);
        }else{
            cad="No hay salidas disponibles";
        }
        txtMostrarS.setText(cad);
    }//GEN-LAST:event_cmdListarActionPerformed

    private void cmdVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVenderActionPerformed
        // TODO add your handling code here:
        String cad = "";
    if (cmdSalidas.getSelectedIndex() != -1) {
        String texto  = cmdAsientos.getSelectedItem().toString().replace("Asiento: ", "");
        int    asiento   = Integer.parseInt(texto);
        String salida    = cmdSalidas.getSelectedItem().toString();
        String nombre    = txtNombre.getText();
        String documento = txtDocumento.getText();
        String telefono  = txtTelefono.getText();   
        String correo    = txtCorreo.getText();     
        boolean idaYVuelta = cmdIdayVuelta.isSelected();

        if (!nombre.isEmpty() && !documento.isEmpty()
                && !telefono.isEmpty() && !correo.isEmpty()) {
            cad = this.myPrincipal.getMyEmpresa()
                    .registrarTiquete(salida, asiento, nombre,
                                      documento, idaYVuelta,
                                      telefono, correo);
            cargarAsientos();
        } else {
            cad = "Digite nombre, documento, teléfono y correo del pasajero";
        }
    } else {
        cad = "No hay salidas disponibles";
    }
    txtMostrarS.setText(cad);
    }//GEN-LAST:event_cmdVenderActionPerformed

    private void cmdIdayVueltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIdayVueltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdIdayVueltaActionPerformed

    private void txtOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrigenActionPerformed

    private void txtBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cargarSalidas(){
    cmdSalidas.removeAllItems();

    String cad=this.myPrincipal.getMyEmpresa().cargarSalidasVenta();

    String[] salidas=cad.split(",");

    for(String p : salidas){

        if(!p.isEmpty()){
            cmdSalidas.addItem(p);
        }
    }
    }
    
    private void cargarAsientos(){
        cmdAsientos.removeAllItems();
        String cad=this.myPrincipal.getMyEmpresa().cargarAsientos(cmdSalidas.getSelectedItem().toString());
        String[] asientos=cad.split(",");
            for(String p : asientos){

        boolean existe = false;

        // recorrer combo box
        for(int i = 0; i < cmdAsientos.getItemCount(); i++){

            String item = cmdAsientos.getItemAt(i).toString();

            if(item.equals(p)){
                existe = true;
                break;
            }
        }

        // si no existe lo agrega
        if(!existe){
            cmdAsientos.addItem(p);
        }   
    }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmdAsientos;
    private javax.swing.JCheckBox cmdIdayVuelta;
    private javax.swing.JButton cmdListar;
    private javax.swing.JComboBox<String> cmdSalidas;
    private javax.swing.JButton cmdVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane lblHora;
    private javax.swing.JTextField txtBus;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextArea txtMostrarS;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoBus;
    // End of variables declaration//GEN-END:variables
}
