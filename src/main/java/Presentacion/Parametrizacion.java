package Presentacion;
import Negocio.Conductor;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;

public class Parametrizacion extends javax.swing.JFrame {
    
    private MenuPrincipal myPrincipal;
    public Parametrizacion(MenuPrincipal mp) {
        initComponents();    
        setLocationRelativeTo(null);
        this.myPrincipal=mp;
        mp.getReloj().addActionListener(e -> actualizarReloj());
        cargarPlacas();
        cargarRutas();
        cargarConductores();
        javax.swing.JTextField txtFecha =(javax.swing.JTextField) cmdFechaS.getDateEditor().getUiComponent();
        txtFecha.setEditable(false);
        txtFecha.setBackground(java.awt.Color.WHITE);
        
        txtMostrar.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtMostrarBR.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtMostrarR.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtMostrarRutaA.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtMostrarSr.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
         addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            myPrincipal.setVisible(true);
                }
        });
        SpinnerDateModel modeloHora =
        new SpinnerDateModel();

        cmdHoraS.setModel(modeloHora);
        

         JSpinner.DateEditor editorS =
         new JSpinner.DateEditor(cmdHoraS, "HH:mm");

         cmdHoraS.setEditor(editorS);
         
         SpinnerNumberModel modelo =new SpinnerNumberModel (2,2,36,1);

         cmdHoraR.setModel(modelo);
         
    }
    
           private void actualizarReloj() {
        DateTimeFormatter formatoF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoH = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaActual = LocalTime.now();
        LocalDate fecha = LocalDate.now();
        lblHora.setText("Fecha: "+formatoF.format(fecha)+"\nHora: "+horaActual.format(formatoH)); 
    }
    
    private void cargarPlacas() {
    String cad = this.myPrincipal.getMyEmpresa().cargarPlacas();

    String[] placas = cad.split(",");

    for(String p : placas){

        boolean existe = false;

        // recorrer combo box
        for(int i = 0; i < cmdPlacaActualizar.getItemCount(); i++){

            String item = cmdPlacaActualizar.getItemAt(i).toString();

            if(item.equals(p)){
                existe = true;
                break;
            }
        }

        // si no existe lo agrega
        if(!existe){
            cmdPlacaActualizar.addItem(p);
            cmdBus.addItem(p);
        }
    }
}
    private void cargarRutas(){
    String cad = this.myPrincipal.getMyEmpresa().cargarRutas();

    String[] rutas = cad.split(",");

    for(String p : rutas){

        boolean existe = false;

        // recorrer combo box
        for(int i = 0; i < cmdRuta.getItemCount(); i++){

            String item = cmdRuta.getItemAt(i).toString();

            if(item.equals(p)){
                existe = true;
                break;
            }
        }

        // si no existe lo agrega
        if(!existe){
            cmdRuta.addItem(p);
            cmdRutaA.addItem(p);
        }
    }
    }

    
    private void cargarConductores(){
    String cad = this.myPrincipal.getMyEmpresa().cargarConductores();

    String[] conductores = cad.split(",");

    for(String p : conductores){

        boolean existe = false;

        // recorrer combo box
        for(int i = 0; i < cmdConductor.getItemCount(); i++){

            String item = cmdConductor.getItemAt(i).toString();

            if(item.equals(p)){
                existe = true;
                break;
            }
        }

        // si no existe lo agrega
        if(!existe){
            cmdConductor.addItem(p);
        }   
    }    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox7 = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmdPlaca = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmdTipoServicio = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtCap = new javax.swing.JTextField();
        cmdCrearB = new javax.swing.JButton();
        cmdListarB = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMostrarBR = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmdEstadoActualizar = new javax.swing.JComboBox<>();
        cmdPlacaActualizar = new javax.swing.JComboBox<>();
        cmdListarBA = new javax.swing.JButton();
        cmdActualizarEstado = new javax.swing.JButton();
        cmdTipoServActualizar = new javax.swing.JTextField();
        txtCapacidadActualizar = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMostrar = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTarifa = new javax.swing.JTextField();
        cmdCrearR = new javax.swing.JButton();
        cmdListarR = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMostrarR = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        cmdHoraR = new javax.swing.JSpinner();
        jLabel29 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        txtDestinoR = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        cmdRutaA = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtTarifaA = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cmdListarRutasA = new javax.swing.JButton();
        cmdActualizarR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrarRutaA = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmdFechaS = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cmdHoraS = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        cmdRuta = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmdBus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtCapacidadSalida = new javax.swing.JTextField();
        cmdListarS = new javax.swing.JButton();
        cmdCrearS = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtMostrarSr = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtOrigenS = new javax.swing.JTextField();
        txtDestinoS = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        cmdConductor = new javax.swing.JComboBox<>();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtDocumentoConductor = new javax.swing.JTextField();
        txtNombreConductor = new javax.swing.JTextField();
        cmdFechaIngreso = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMostrarCond = new javax.swing.JTextArea();
        cmdCrearC = new javax.swing.JButton();
        cmdListarC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblHora = new javax.swing.JTextPane();

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Buses");

        jLabel15.setText("Placa");

        jLabel17.setText("Tipo de Servicio");

        cmdTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Ejecutivo" }));
        cmdTipoServicio.setSelectedIndex(-1);
        cmdTipoServicio.addActionListener(this::cmdTipoServicioActionPerformed);

        jLabel16.setText("Capacidad");

        txtCap.setEditable(false);
        txtCap.addActionListener(this::txtCapActionPerformed);

        cmdCrearB.setText("Crear");
        cmdCrearB.addActionListener(this::cmdCrearBActionPerformed);

        cmdListarB.setText("Listar");
        cmdListarB.addActionListener(this::cmdListarBActionPerformed);

        txtMostrarBR.setEditable(false);
        txtMostrarBR.setColumns(20);
        txtMostrarBR.setRows(5);
        jScrollPane3.setViewportView(txtMostrarBR);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmdCrearB)
                                    .addComponent(txtCap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cmdListarB)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cmdPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cmdTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdCrearB)
                            .addComponent(cmdListarB)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar", jPanel5);
        jPanel5.getAccessibleContext().setAccessibleName("r");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Buses");

        jLabel19.setText("Placa");

        jLabel20.setText("Tipo de Servicio");

        jLabel21.setText("Capacidad");

        jLabel3.setText("Estado");

        cmdEstadoActualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Mantenimiento" }));

        cmdPlacaActualizar.addActionListener(this::cmdPlacaActualizarActionPerformed);

        cmdListarBA.setText("Listar");
        cmdListarBA.addActionListener(this::cmdListarBAActionPerformed);

        cmdActualizarEstado.setText("Actualizar");
        cmdActualizarEstado.addActionListener(this::cmdActualizarEstadoActionPerformed);

        cmdTipoServActualizar.setEditable(false);

        txtCapacidadActualizar.setEditable(false);

        txtMostrar.setEditable(false);
        txtMostrar.setColumns(20);
        txtMostrar.setRows(5);
        jScrollPane5.setViewportView(txtMostrar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel19)
                        .addGap(50, 50, 50)
                        .addComponent(cmdPlacaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdTipoServActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdEstadoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCapacidadActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(cmdActualizarEstado)
                        .addGap(18, 18, 18)
                        .addComponent(cmdListarBA)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cmdPlacaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cmdTipoServActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtCapacidadActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmdEstadoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdActualizarEstado)
                            .addComponent(cmdListarBA))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Actualizar", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Buses", jPanel2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Rutas");

        jLabel4.setText("Origen");

        jLabel5.setText("Destino");

        jLabel6.setText("Tarifa Base");

        txtTarifa.addActionListener(this::txtTarifaActionPerformed);

        cmdCrearR.setText("Crear");
        cmdCrearR.addActionListener(this::cmdCrearRActionPerformed);

        cmdListarR.setText("Listar");
        cmdListarR.addActionListener(this::cmdListarRActionPerformed);

        txtMostrarR.setEditable(false);
        txtMostrarR.setColumns(20);
        txtMostrarR.setRows(5);
        jScrollPane6.setViewportView(txtMostrarR);

        jLabel28.setText("Tiempo de Viaje");

        jLabel29.setText("H");

        jTextField4.setEditable(false);
        jTextField4.setText("CUCÚTA");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(cmdCrearR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdListarR, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(cmdHoraR, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(61, 61, 61))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4)
                            .addComponent(txtDestinoR, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDestinoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cmdHoraR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCrearR)
                    .addComponent(cmdListarR))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jTabbedPane3.addTab("Registrar", jPanel6);

        cmdRutaA.addActionListener(this::cmdRutaAActionPerformed);

        jLabel23.setText("Ruta");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("Rutas");

        jLabel25.setText("Origen");

        jLabel26.setText("Destino");

        txtOrigen.setEditable(false);

        txtDestino.setEditable(false);

        txtTarifaA.setEditable(false);

        jLabel27.setText("Tarifa");
        jLabel27.setToolTipText("");

        cmdListarRutasA.setText("Listar");
        cmdListarRutasA.addActionListener(this::cmdListarRutasAActionPerformed);

        cmdActualizarR.setText("Actualizar");
        cmdActualizarR.addActionListener(this::cmdActualizarRActionPerformed);

        txtMostrarRutaA.setEditable(false);
        txtMostrarRutaA.setColumns(20);
        txtMostrarRutaA.setRows(5);
        jScrollPane1.setViewportView(txtMostrarRutaA);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(txtTarifaA)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel24))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel23)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdRutaA, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(cmdActualizarR)
                        .addGap(18, 18, 18)
                        .addComponent(cmdListarRutasA)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdRutaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTarifaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdActualizarR)
                            .addComponent(cmdListarRutasA)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Actualizar", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Rutas", jPanel1);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Salidas");

        jLabel9.setText("Fecha");

        cmdFechaS.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmdFechaSAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel10.setText("Hora");

        jLabel11.setText("Ruta");

        cmdRuta.addActionListener(this::cmdRutaActionPerformed);

        jLabel12.setText("Bus Asignado");

        cmdBus.addActionListener(this::cmdBusActionPerformed);

        jLabel8.setText("Capacidad bus");

        txtCapacidadSalida.setEditable(false);

        cmdListarS.setText("Listar");
        cmdListarS.addActionListener(this::cmdListarSActionPerformed);

        cmdCrearS.setText("Crear");
        cmdCrearS.addActionListener(this::cmdCrearSActionPerformed);

        txtMostrarSr.setEditable(false);
        txtMostrarSr.setColumns(20);
        txtMostrarSr.setRows(5);
        jScrollPane8.setViewportView(txtMostrarSr);

        jLabel13.setText("Origen");

        jLabel22.setText("Destino");

        txtOrigenS.setEditable(false);

        txtDestinoS.setEditable(false);

        jLabel40.setText("Conductor Asignado");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCapacidadSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel22)
                                    .addGap(38, 38, 38)))
                            .addComponent(cmdBus, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmdHoraS, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOrigenS)
                            .addComponent(txtDestinoS, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(cmdFechaS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(cmdConductor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cmdCrearS)
                        .addGap(32, 32, 32)
                        .addComponent(cmdListarS)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(cmdFechaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdHoraS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtOrigenS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(txtDestinoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdBus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacidadSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdCrearS)
                        .addComponent(cmdListarS))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Registrar", jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Salidas", jPanel3);

        jLabel30.setText("Documento");

        jLabel31.setText("Nombre");

        jLabel32.setText("Fecha de Ingreso");

        cmdFechaIngreso.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmdFechaIngresoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtMostrarCond.setColumns(20);
        txtMostrarCond.setRows(5);
        jScrollPane4.setViewportView(txtMostrarCond);

        cmdCrearC.setText("Crear");
        cmdCrearC.addActionListener(this::cmdCrearCActionPerformed);

        cmdListarC.setText("Listar");
        cmdListarC.addActionListener(this::cmdListarCActionPerformed);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDocumentoConductor)
                            .addComponent(txtNombreConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdFechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 36, Short.MAX_VALUE)
                                .addComponent(cmdCrearC)
                                .addGap(32, 32, 32)
                                .addComponent(cmdListarC)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtDocumentoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(cmdFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdCrearC)
                            .addComponent(cmdListarC))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Registrar", jPanel9);

        jTabbedPane2.addTab("Conductores", jTabbedPane5);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("PARAMETRIZACION");

        lblHora.setEditable(false);
        jScrollPane2.setViewportView(lblHora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addGap(162, 162, 162)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCrearSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearSActionPerformed
        // TODO add your handling code here:
        if (cmdFechaS.getDate()!=null){
            SimpleDateFormat formatoF = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoH= new SimpleDateFormat("HH:mm");
            String fecha=formatoF.format(cmdFechaS.getDate());
            String hora=formatoH.format(cmdHoraS.getValue());
            String ruta=cmdRuta.getSelectedItem().toString();
            String bus=cmdBus.getSelectedItem().toString();
            String conductor= cmdConductor.getSelectedItem().toString();
            String cad=this.myPrincipal.getMyEmpresa().registrarSalida(fecha,hora,ruta,bus,conductor);
            txtMostrarSr.setText(cad);
        }else{
            txtMostrarSr.setText("Digite una fecha");
        }
    }//GEN-LAST:event_cmdCrearSActionPerformed

    /*
        this.txtMostrar.setText(cad);    }                                                   
*/
    private void cmdListarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarSActionPerformed
        // TODO add your handling code here:
        String cad=this.myPrincipal.getMyEmpresa().listarSalida();
        this.txtMostrarSr.setText(cad);
    }//GEN-LAST:event_cmdListarSActionPerformed

    /*
        this.txtMostrar.setText(cad);    }                                                   
*/
    private void cmdBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBusActionPerformed
        // TODO add your handling code here:
        String placaSeleccionada = cmdBus.getSelectedItem().toString();

        String cad= this.myPrincipal.getMyEmpresa().retornarDatosbus(placaSeleccionada);
        String[] datos= cad.split(",");
        String capacidad="30";
        switch (datos[0]){
            case "Ejecutivo":
            capacidad="40";
            break;
            case "Normal":
            capacidad="30";
            break;
        }
        txtCapacidadSalida.setText(capacidad);
    }//GEN-LAST:event_cmdBusActionPerformed

    private void cmdRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRutaActionPerformed
        // TODO add your handling code here:
        String rutaSeleccionada=cmdRuta.getSelectedItem().toString();

        String cad=this.myPrincipal.getMyEmpresa().retornarDatosRuta(rutaSeleccionada);
        String[] datos= cad.split(",");
        txtOrigenS.setText(datos[0]);
        txtDestinoS.setText(datos[1]);
    }//GEN-LAST:event_cmdRutaActionPerformed

    private void cmdFechaSAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmdFechaSAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdFechaSAncestorAdded

    private void cmdActualizarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarRActionPerformed
        // TODO add your handling code here:
        try{
            String ruta;
            int tarifa;

            ruta = cmdRutaA.getSelectedItem().toString();
            tarifa = Integer.parseInt(txtTarifaA.getText());

            String cad=this.myPrincipal.getMyEmpresa().actualizarRuta(ruta, tarifa);
            this.txtMostrarRutaA.setText(cad);
        }catch(NumberFormatException e){
            this.txtMostrarRutaA.setText("Ingrese un valor valido");
        }
    }//GEN-LAST:event_cmdActualizarRActionPerformed

    private void cmdListarRutasAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarRutasAActionPerformed
        // TODO add your handling code here:
        String cad=this.myPrincipal.getMyEmpresa().listarRuta();
        this.txtMostrarRutaA.setText(cad);
    }//GEN-LAST:event_cmdListarRutasAActionPerformed

    private void cmdRutaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRutaAActionPerformed
        // TODO add your handling code here:

        String rutaSeleccionada=cmdRutaA.getSelectedItem().toString();
        txtTarifaA.setEditable(true);

        String cad=this.myPrincipal.getMyEmpresa().retornarDatosRuta(rutaSeleccionada);
        String[] datos= cad.split(",");
        txtOrigen.setText(datos[0]);
        txtDestino.setText(datos[1]);
        txtTarifaA.setText(datos[2]);

    }//GEN-LAST:event_cmdRutaAActionPerformed

    private void cmdListarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarRActionPerformed
        // TODO add your handling code here:
        String cad=this.myPrincipal.getMyEmpresa().listarRuta();
        this.txtMostrarR.setText(cad);
    }//GEN-LAST:event_cmdListarRActionPerformed

    private void cmdCrearRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearRActionPerformed
        // TODO add your handling code here:
        try{
            String text=txtTarifa.getText().trim();

            if (!txtDestinoR.getText().isEmpty()&& !text.isEmpty()){

                String destino=txtDestinoR.getText();
                int viajeTime=(int)cmdHoraR.getValue();
                int tarifaB=Integer.parseInt(this.txtTarifa.getText());

                String cad=this.myPrincipal.getMyEmpresa().registrarRuta(destino,tarifaB,viajeTime);

                this.txtMostrarR.setText(cad);
                cargarRutas();
            }else{
                this.txtMostrarR.setText("Debe rellenar todos los parametros");
            }
        }catch(NumberFormatException e){
            this.txtMostrarR.setText( "Ingrese un valor valido");
        }
    }//GEN-LAST:event_cmdCrearRActionPerformed

    private void txtTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarifaActionPerformed

    private void cmdActualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarEstadoActionPerformed
        String placa, estado;

        placa = cmdPlacaActualizar.getSelectedItem().toString();
        estado = this.cmdEstadoActualizar.getSelectedItem().toString();

        String cad=this.myPrincipal.getMyEmpresa().actualizarBus(placa, estado);
        this.txtMostrar.setText(cad);
        

        
    }//GEN-LAST:event_cmdActualizarEstadoActionPerformed

    private void cmdListarBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarBAActionPerformed
        String cad=this.myPrincipal.getMyEmpresa().listarBus();
        txtMostrar.setText(cad);
    }//GEN-LAST:event_cmdListarBAActionPerformed

    private void cmdPlacaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPlacaActualizarActionPerformed

        String placaSeleccionada = cmdPlacaActualizar.getSelectedItem().toString();

        String cad= this.myPrincipal.getMyEmpresa().retornarDatosbus(placaSeleccionada);
        String[] datos= cad.split(",");
        String capacidad="30";
        switch (datos[0]){
            case "Ejecutivo":
            capacidad="40";
            break;
            case "Normal":
            capacidad="30";
            break;
        }
        cmdTipoServActualizar.setText(datos[0]);
        cmdEstadoActualizar.setSelectedItem(datos[1]);
        txtCapacidadActualizar.setText(capacidad);

    }//GEN-LAST:event_cmdPlacaActualizarActionPerformed

    private void cmdListarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarBActionPerformed
        // TODO add your handling code here:
        String cad=this.myPrincipal.getMyEmpresa().listarBus();
        this.txtMostrarBR.setText(cad);
    }//GEN-LAST:event_cmdListarBActionPerformed

    private void cmdCrearBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearBActionPerformed
        // TODO add your handling code here:
        String placa,tipoS;
        placa=this.cmdPlaca.getText();
        if (!placa.isEmpty() && this.cmdTipoServicio.getSelectedIndex()!=-1){

            tipoS=this.cmdTipoServicio.getSelectedItem().toString();
            String cad=this.myPrincipal.getMyEmpresa().registrarBus(placa, tipoS);

            this.txtMostrarBR.setText(cad);

            cargarPlacas();

        }else{

            this.txtMostrarBR.setText("Debe Digitar una placa Y El tipo de servicio");
        }

    }//GEN-LAST:event_cmdCrearBActionPerformed

    private void txtCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapActionPerformed

    private void cmdTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTipoServicioActionPerformed
        // TODO add your handling code here:
        String tipo = cmdTipoServicio.getSelectedItem().toString();

        switch(tipo){
            case "Normal":
            txtCap.setText("40");
            break;
            case "Ejecutivo":
            txtCap.setText("30");
            break;
        }

    }//GEN-LAST:event_cmdTipoServicioActionPerformed

    private void cmdFechaIngresoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmdFechaIngresoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdFechaIngresoAncestorAdded

    private void cmdCrearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearCActionPerformed
    String documento = txtDocumentoConductor.getText();
    String nombre = txtNombreConductor.getText();
    Date fecha = cmdFechaIngreso.getDate();
    String respuesta =this.myPrincipal.getMyEmpresa().registrarConductor(documento,nombre,fecha);
        txtMostrarCond.setText(respuesta);
        if(respuesta.contains("Conductor registrado correctamente")){
          txtDocumentoConductor.setText("");
          txtNombreConductor.setText("");
          cmdFechaIngreso.setDate(null);
}
    }//GEN-LAST:event_cmdCrearCActionPerformed

    private void cmdListarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarCActionPerformed
        txtMostrarCond.setText(this.myPrincipal.getMyEmpresa().listarConductores());
    }//GEN-LAST:event_cmdListarCActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdActualizarEstado;
    private javax.swing.JButton cmdActualizarR;
    private javax.swing.JComboBox<String> cmdBus;
    private javax.swing.JComboBox<String> cmdConductor;
    private javax.swing.JButton cmdCrearB;
    private javax.swing.JButton cmdCrearC;
    private javax.swing.JButton cmdCrearR;
    private javax.swing.JButton cmdCrearS;
    private javax.swing.JComboBox<String> cmdEstadoActualizar;
    private com.toedter.calendar.JDateChooser cmdFechaIngreso;
    private com.toedter.calendar.JDateChooser cmdFechaS;
    private javax.swing.JSpinner cmdHoraR;
    private javax.swing.JSpinner cmdHoraS;
    private javax.swing.JButton cmdListarB;
    private javax.swing.JButton cmdListarBA;
    private javax.swing.JButton cmdListarC;
    private javax.swing.JButton cmdListarR;
    private javax.swing.JButton cmdListarRutasA;
    private javax.swing.JButton cmdListarS;
    private javax.swing.JTextField cmdPlaca;
    private javax.swing.JComboBox<String> cmdPlacaActualizar;
    private javax.swing.JComboBox<String> cmdRuta;
    private javax.swing.JComboBox<String> cmdRutaA;
    private javax.swing.JTextField cmdTipoServActualizar;
    private javax.swing.JComboBox<String> cmdTipoServicio;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane lblHora;
    private javax.swing.JTextField txtCap;
    private javax.swing.JTextField txtCapacidadActualizar;
    private javax.swing.JTextField txtCapacidadSalida;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDestinoR;
    private javax.swing.JTextField txtDestinoS;
    private javax.swing.JTextField txtDocumentoConductor;
    private javax.swing.JTextArea txtMostrar;
    private javax.swing.JTextArea txtMostrarBR;
    private javax.swing.JTextArea txtMostrarCond;
    private javax.swing.JTextArea txtMostrarR;
    private javax.swing.JTextArea txtMostrarRutaA;
    private javax.swing.JTextArea txtMostrarSr;
    private javax.swing.JTextField txtNombreConductor;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtOrigenS;
    private javax.swing.JTextField txtTarifa;
    private javax.swing.JTextField txtTarifaA;
    // End of variables declaration//GEN-END:variables
}
