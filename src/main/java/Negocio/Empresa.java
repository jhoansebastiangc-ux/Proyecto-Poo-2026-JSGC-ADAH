package Negocio;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Empresa {
    private ArrayList<Bus> myBuses;
    private ArrayList<Ruta> myRutas;
    private ArrayList<Salida> mySalidas;
    private ArrayList<Cliente> myClientes;
    private ArrayList<Conductor> myConductores;
    private Caja cajaDeldia;

    public Empresa() {
        this.myBuses = new ArrayList<>();
        this.myRutas = new ArrayList<>();
        this.mySalidas = new ArrayList<>();
        this.myClientes = new ArrayList<>();
        this.myConductores = new ArrayList<>();
        registrarDatosBase();
    }

    // =========================================================
    // MÓDULO: CAJA
    // =========================================================

    public String abrirCaja(double montoInicial) {
        String errorMonto = validarMontoPositivo(montoInicial, "El monto inicial");
        if (errorMonto != null) return errorMonto;
        if (this.cajaDeldia != null) return "La caja ya ha sido abierta";
        this.cajaDeldia = new Caja(montoInicial);
        return "Caja abierta con exito";
    }

    public boolean validarCaja() {
        return this.cajaDeldia != null;
    }

    private void actualizarCaja(double ingreso, double rembolsado) {
        this.cajaDeldia.setMontocaja(ingreso, rembolsado);
    }

    // =========================================================
    // MÓDULO: CARGA DE DATOS PARA COMBOS
    // =========================================================

    public String cargarPlacas() {
        return construirCadena(myBuses.stream()
                .map(Bus::getPlaca)
                .toArray(String[]::new));
    }

    public String cargarRutas() {
        return construirCadena(myRutas.stream()
                .map(Ruta::getCodigo)
                .toArray(String[]::new));
    }

    public String cargarSalidas() {
        return construirCadena(mySalidas.stream()
                .map(Salida::getIdSalida)
                .toArray(String[]::new));
    }

    public String cargarConductores() {
        return construirCadena(myConductores.stream()
                .map(Conductor::getNombre)
                .toArray(String[]::new));
    }

    public String cargarSalidasVenta() {
        StringBuilder cad = new StringBuilder();
        for (Salida s : mySalidas) {
            if (!s.getEstado().equals("Cancelada") && tieneAsientosDisponibles(s)) {
                cad.append(s.getIdSalida()).append(",");
            }
        }
        return cad.toString();
    }

    /** Verifica si una salida tiene al menos un asiento disponible */
    private boolean tieneAsientosDisponibles(Salida s) {
        for (Puesto p : s.getBusAsignado().getMyPuestos()) {
            if (!s.puestoOcupado(p.getNumAsiento())) return true;
        }
        return false;
    }

    /** Construye un String separado por comas a partir de un arreglo de valores */
    private String construirCadena(String[] valores) {
        StringBuilder cad = new StringBuilder();
        for (String v : valores) cad.append(v).append(",");
        return cad.toString();
    }

    // =========================================================
    // MÓDULO: CONSULTA DE DATOS
    // =========================================================

    public String cargarDatosSalida(String salida) {
        Salida s = recorrerSalida(salida);
        if (s == null) return "";
        Ruta r = s.getRuta();
        return r.getOrigen() + "," + r.getDestino() + ","
                + s.getFecha().format(DateTimeFormatter.ISO_DATE) + ","
                + s.getHora().format(DateTimeFormatter.ofPattern("HH:mm")) + ","
                + s.getBusAsignado().getPlaca() + ","
                + s.getBusAsignado().getTipoServ();
    }

    public String cargarAsientos(String codSalida) {
        String error = validarCampoVacio(codSalida, "El código de salida");
        if (error != null) return error;
        Salida s = recorrerSalida(codSalida);
        if (s == null) return "Salida no encontrada";
        StringBuilder cad = new StringBuilder();
        for (Puesto p : s.getBusAsignado().getMyPuestos()) {
            if (!s.puestoOcupado(p.getNumAsiento()))
                cad.append("Asiento: ").append(p.getNumAsiento()).append(",");
        }
        return cad.toString();
    }

    public String cargarCancelacion(String codSalida) {
        Salida s = recorrerSalida(codSalida);
        if (s == null) return "";
        return s.getRuta().getCodigo() + "," + s.getRuta().getOrigen() + ","
                + s.getRuta().getDestino() + "," + s.getFecha() + ","
                + s.getHora() + "," + s.getBusAsignado().getPlaca() + ","
                + s.getBusAsignado().getTipoServ() + ","
                + s.getConductorAsignado().getNombre() + ","
                + s.getMyTiquetes().size();
    }

    public String retornarDatosbus(String placa) {
        Bus b = recorrerBus(placa);
        if (b == null) return "";
        return b.getTipoServ() + "," + b.getEstado();
    }

    public String retornarDatosRuta(String codigo) {
        Ruta r = recorrerRuta(codigo);
        if (r == null) return "";
        return r.getOrigen() + "," + r.getDestino() + "," + r.getTarifab();
    }

    // =========================================================
    // MÓDULO: BÚSQUEDA (recorridos internos)
    // =========================================================

    private Bus recorrerBus(String placa) {
        for (Bus b : myBuses) {
            if (b.getPlaca().equals(placa)) return b;
        }
        return null;
    }

    private Ruta recorrerRuta(String ruta) {
        for (Ruta r : myRutas) {
            if (r.getCodigo().equals(ruta)) return r;
        }
        return null;
    }

    private Cliente recorrerCliente(String documento) {
        for (Cliente c : myClientes) {
            if (c.getDocumento().equals(documento)) return c;
        }
        return null;
    }

    private Salida recorrerSalida(String salida) {
        for (Salida s : mySalidas) {
            if (s.getIdSalida().equals(salida)) return s;
        }
        return null;
    }
    
    private Conductor recorrerConductor(String nombre){
    for(Conductor c : myConductores){
        if(c.getNombre().equals(nombre)){
            return c;
        }
    }
    return null;
}

    private Conductor recorrerConductorDocumento(String documento){
    for(Conductor c : myConductores){
        if(c.getDocumento().equals(documento)){
            return c;
        }
    }
    return null;
}
    // =========================================================
    // MÓDULO: REGISTRO
    // =========================================================

    public String registrarBus(String placa, String tipoServ) {
    String errorPlaca = validarCampoVacio(placa, "La placa");
    if(errorPlaca != null) return errorPlaca;

    String errorTipo = validarCampoVacio(tipoServ, "El tipo de servicio");
    if(errorTipo != null) return errorTipo;

    String errorFormato = validarFormatoPlaca(placa);
    if(errorFormato != null) return errorFormato;

    String errorServicio = validarTipoServicio(tipoServ);
    if(errorServicio != null) return errorServicio;

    if(validarPlaca(placa)){
        return "Placa ya registrada";
    }

    Bus nuevo = new Bus(placa, tipoServ);
    myBuses.add(nuevo);

    return "Se registro un nuevo bus: \n"
            + myBuses.getLast().toString();
    }

    public String registrarRuta(String destino, int tarifa, int viajeTime) {
     String errorDestino = validarCampoVacio(destino, "El destino");
    if(errorDestino != null) return errorDestino;

    String errorTarifa = validarMontoPositivo(tarifa, "La tarifa");
    if(errorTarifa != null) return errorTarifa;

    String errorTiempo = validarMontoPositivo(viajeTime, "El tiempo de viaje");
    if(errorTiempo != null) return errorTiempo;

    String errorHoras = validarTiempoViaje(viajeTime);
    if(errorHoras != null) return errorHoras;

    if(validarRuta(destino)){
        return "Ruta ya Registrada";
    }

    int contR = buscarCodUltimaRuta();

    Ruta ruta = new Ruta(contR, destino, viajeTime, tarifa);

    myRutas.add(ruta);

    return "Se registro la ruta: \n"
            + myRutas.getLast().toString();

    }

    public String registrarSalida(String fecha, String hora, String codRuta,
                                   String placaBus, String nombreConductor) {
        // Validar campos vacíos
        String errorFecha = validarCampoVacio(fecha, "La fecha");
        if (errorFecha != null) return errorFecha;
        String errorHora = validarCampoVacio(hora, "La hora");
        if (errorHora != null) return errorHora;
        String errorRuta = validarCampoVacio(codRuta, "El código de ruta");
        if (errorRuta != null) return errorRuta;
        String errorPlaca = validarCampoVacio(placaBus, "La placa del bus");
        if (errorPlaca != null) return errorPlaca;
        String errorConductor = validarCampoVacio(nombreConductor, "El nombre del conductor");
        if (errorConductor != null) return errorConductor;

        // Validar formato de fecha y hora
        LocalDateTime salida;
        try {
            salida = convertirFechaHora(fecha, hora);
        } catch (DateTimeParseException e) {
            return "Formato de fecha u hora inválido. Use: dd/MM/yyyy y HH:mm";
        }

        String errorFutura = validarFechaFutura(salida);
          if(errorFutura != null) return errorFutura;

        // Validar existencia de los objetos relacionados
        Bus bus = recorrerBus(placaBus);
        if (bus == null) return "El bus con placa " + placaBus + " no existe";

        Ruta ruta = recorrerRuta(codRuta);
        if (ruta == null) return "La ruta con código " + codRuta + " no existe";

        Conductor conductor = recorrerConductor(nombreConductor);
        if (conductor == null) return "El conductor " + nombreConductor + " no existe";

        // Validar estado del bus y cruces de horario
        if (busEnMantenimiento(bus))
            return "El bus seleccionado está en mantenimiento";
        if (validarSalidas(salida, ruta, bus))
            return "No se pudo registrar la salida\nEl bus tiene otra salida en ese horario";
        if (validarConductor(salida, ruta, conductor))
            return "No se pudo registrar la salida\nEl conductor ya tiene una salida en ese horario";

        LocalDateTime llegada = calcularLlegada(salida, ruta);
        int cod = buscarCodUltimaSalida();
        mySalidas.add(new Salida(cod, ruta, salida, llegada, bus, conductor));
        return "Salida registrada\n" + mySalidas.getLast();
    }

    public String registrarTiquete(String salida, int asiento, String nombre, String documento, boolean idaYVuelta) {
        String errorAsiento = validarAsiento(asiento);
        if(errorAsiento != null) return errorAsiento;

        String errorDocumento = validarDocumento(documento);
        if(errorDocumento != null) return errorDocumento;

        String errorNombre = validarNombrePersona(nombre);
        if(errorNombre != null) return errorNombre;
        
        // Validar caja abierta antes de vender
        if (!validarCaja()) return "No se puede vender: la caja no ha sido abierta";

        // Validar existencia de la salida
        Salida s = recorrerSalida(salida);
        if (s == null) return "La salida " + salida + " no existe";

        // Validar estado de la salida
        if (s.getEstado().equals("Cancelada"))
            return "No se puede vender tiquetes para una salida cancelada";

        // Validar que el asiento exista en el bus
        Bus b = s.getBusAsignado();
        Puesto puesto = b.buscarPuesto(asiento);
        if (puesto == null)
            return "El asiento " + asiento + " no existe en el bus asignado";

        // Validar que el asiento esté disponible
        if (s.puestoOcupado(asiento))
            return "El asiento " + asiento + " ya está ocupado";
        
        String errorLimite = validarLimiteTiquetesCliente(s, documento);
         if(errorLimite != null) return errorLimite;
         
        String errorPareja = validarParejaAsientos(s, documento, asiento);
         if(errorPareja != null) return errorPareja;

        // Validar cliente
        Cliente cliente = resolverCliente(documento, nombre);
        if (cliente == null)
            return "El documento ya está registrado con otro nombre";

        double valorPagar;
         if(idaYVuelta){
          valorPagar = s.getTarifa() * 2 * 0.90;
        }else{
          valorPagar = s.getTarifa();
   }
        String cad = s.registrarTiquete(s, nombre, documento, puesto, valorPagar, idaYVuelta);
        actualizarCaja(valorPagar, 0.0);
        return cad;
    }
    
    public String registrarConductor(String documento, String nombre, Date fechaIngreso){

    String errorDocumento = validarCampoVacio(documento, "El documento");
    if(errorDocumento != null) return errorDocumento;

    String errorNombre = validarCampoVacio(nombre, "El nombre");
    if(errorNombre != null) return errorNombre;

    String errorFecha = validarFechaConductor(fechaIngreso);
    if(errorFecha != null) return errorFecha;

    errorDocumento = validarDocumento(documento);
    if(errorDocumento != null) return errorDocumento;

    errorNombre = validarNombrePersona(nombre);
    if(errorNombre != null) return errorNombre;

    if(validarConductorExistente(documento)){
        return "Ya existe un conductor registrado con ese documento";
    }

    Conductor nuevo = new Conductor(documento, nombre, fechaIngreso);

    myConductores.add(nuevo);

    return "Conductor registrado correctamente\n"
            + nuevo.toString();
}

    /**
     * Devuelve el cliente existente (si coincide el nombre) o crea uno nuevo.
     * Retorna null si el documento ya existe con otro nombre.
     */
    private Cliente resolverCliente(String documento, String nombre) {
        Cliente cliente = recorrerCliente(documento);
        if (cliente == null) {
            cliente = new Cliente(documento, nombre);
            myClientes.add(cliente);
            return cliente;
        }
        if (!cliente.getNombre().equalsIgnoreCase(nombre)) return null;
        return cliente;
    }

    // =========================================================
    // MÓDULO: CANCELACIÓN
    // =========================================================

    public String cancelarSalida(String codSalida) {
        // Validar campo vacío
        String error = validarCampoVacio(codSalida, "El código de salida");
        if (error != null) return error;

        // Validar existencia
        Salida salidaCancelada = recorrerSalida(codSalida);
        if (salidaCancelada == null) return "Salida no encontrada";

        // Validar estado actual
        if (salidaCancelada.getEstado().equals("Cancelada"))
            return "La salida ya fue cancelada anteriormente";

        // Validar caja abierta si hay tiquetes que reembolsar
        if (!salidaCancelada.getMyTiquetes().isEmpty() && !validarCaja())
            return "No se puede cancelar: la caja no ha sido abierta y hay tiquetes que reembolsar";

        salidaCancelada.setEstado("Cancelada");

        StringBuilder reporte = new StringBuilder();
        agregarEncabezadoCancelacion(reporte, salidaCancelada);
        reporte.append("Tiquetes procesados:\n");

        int[] contadores = procesarTiquetesCancelacion(salidaCancelada, reporte);

        reporte.append("TOTAL REPROGRAMADOS: ").append(contadores[0]).append("\n");
        reporte.append("TOTAL REEMBOLSADOS: ").append(contadores[1]);
        return reporte.toString();
    }

    /** Agrega el encabezado del reporte de cancelación */
    private void agregarEncabezadoCancelacion(StringBuilder reporte, Salida s) {
        reporte.append("CANCELACION DE SALIDA: ").append(s.getIdSalida())
                .append(" (").append(s.getRuta().getCodigo()).append(" ")
                .append(s.getRuta().getOrigen()).append(" -> ")
                .append(s.getRuta().getDestino()).append(")\n");
    }

    /**
     * Procesa cada tiquete de la salida cancelada:
     * reprograma si hay salida alternativa, reembolsa si no.
     * Retorna int[]{reprogramados, reembolsados}.
     */
    private int[] procesarTiquetesCancelacion(Salida salidaCancelada, StringBuilder reporte) {
        int reprogramados = 0;
        int reembolsados = 0;
        for (Tiquete t : salidaCancelada.getMyTiquetes()) {
            Salida nuevaSalida = buscarSalidaAlternativa(salidaCancelada);
            if (nuevaSalida != null) {
                reprogramarTiquete(t, nuevaSalida, reprogramados, reporte);
                reprogramados++;
            } else {
                reembolsarTiquete(t, reporte);
                reembolsados++;
            }
        }
        return new int[]{reprogramados, reembolsados};
    }

    /** Reprograma un tiquete a una salida alternativa */
    private void reprogramarTiquete(Tiquete t, Salida nuevaSalida,
                                     int contador, StringBuilder reporte) {
        int sillaNueva = buscarSillaDisponible(nuevaSalida);
        Puesto nuevoPuesto = nuevaSalida.getBusAsignado().buscarPuesto(sillaNueva);

        Tiquete nuevo = new Tiquete(
                contador + 100, t.getNombre(), t.getDocumento(),
                nuevoPuesto, nuevaSalida.getTarifa(), t.isIdaYVuelta()
        );
        nuevo.setEstado("Reprogramado");
        nuevaSalida.getMyTiquetes().add(nuevo);
        t.setEstado("Reprogramado");

        reporte.append("- ").append(t.getCodTq())
                .append(" Pasajero ").append(t.getDocumento())
                .append(" Silla ").append(t.getMyPuesto().getNumAsiento())
                .append(" -> REPROGRAMADO a ").append(nuevaSalida.getIdSalida())
                .append(" Silla ").append(sillaNueva).append("\n");
    }

    /** Reembolsa un tiquete y registra en caja */
    private void reembolsarTiquete(Tiquete t, StringBuilder reporte) {
        t.setEstado("Reembolsado");
        actualizarCaja(0, t.getValorPagar());
        reporte.append("- ").append(t.getCodTq())
                .append(" Pasajero ").append(t.getDocumento())
                .append(" -> REEMBOLSADO\n");
    }

    private Salida buscarSalidaAlternativa(Salida cancelada) {
        for (Salida s : mySalidas) {
            if (!s.getIdSalida().equals(cancelada.getIdSalida())
                    && s.getEstado().equals("Programada")
                    && s.getRuta().equals(cancelada.getRuta())
                    && cuposDisponibles(s)) {
                return s;
            }
        }
        return null;
    }

    private Salida buscarSalidaAlterna(Salida original) {
        for (Salida s : mySalidas) {
            if (!s.equals(original)
                    && s.getRuta().equals(original.getRuta())
                    && s.getEstado().equals("Programada")
                    && s.hayAsientosDisponibles()) {
                return s;
            }
        }
        return null;
    }

    private boolean cuposDisponibles(Salida s) {
        return s.getMyTiquetes().size() < s.getBusAsignado().getMyPuestos().length;
    }

    private int buscarSillaDisponible(Salida s) {
        for (Puesto p : s.getBusAsignado().getMyPuestos()) {
            if (!s.puestoOcupado(p.getNumAsiento())) return p.getNumAsiento();
        }
        return -1;
    }

    // =========================================================
    // MÓDULO: ACTUALIZACIÓN
    // =========================================================

    public String actualizarBus(String placa, String nuevoEstado) {
        // Validar campos vacíos
        String errorPlaca = validarCampoVacio(placa, "La placa");
        if (errorPlaca != null) return errorPlaca;
        String errorEstado = validarCampoVacio(nuevoEstado, "El estado");
        if (errorEstado != null) return errorEstado;

        String errorEstadoBus = validarEstadoBus(nuevoEstado);
        if(errorEstadoBus != null) return errorEstadoBus;

        Bus b = recorrerBus(placa);
        if (b == null) return "Bus no encontrado";

        // Evitar actualizar al mismo estado
        if (b.getEstado().equals(nuevoEstado))
            return "El bus ya se encuentra en estado: " + nuevoEstado;

        // Validar que no se ponga en Activo un bus con salidas activas si estaba en Mantenimiento
        if (nuevoEstado.equals("Mantenimiento") && tieneSalidasProgramadas(b))
            return "No se puede poner en mantenimiento: el bus tiene salidas programadas";

        b.setEstado(nuevoEstado);
        return "Estado actualizado correctamente a: " + nuevoEstado;
    }

    public String actualizarRuta(String cod, int nuevatarifa) {
        // Validar campo vacío
        String error = validarCampoVacio(cod, "El código de ruta");
        if (error != null) return error;

        // Validar tarifa positiva
        String errorTarifa = validarMontoPositivo(nuevatarifa, "La tarifa");
        if (errorTarifa != null) return errorTarifa;

        Ruta r = recorrerRuta(cod);
        if (r == null) return "No se encontró esa ruta";

        // Evitar actualizar al mismo valor
        if (r.getTarifab() == nuevatarifa)
            return "La ruta ya tiene esa tarifa registrada";

        r.setTarifab(nuevatarifa);
        return "Ruta actualizada correctamente";
    }

    /** Verifica si un bus tiene salidas en estado Programada */
    private boolean tieneSalidasProgramadas(Bus bus) {
        for (Salida s : mySalidas) {
            if (s.getBusAsignado().equals(bus) && s.getEstado().equals("Programada"))
                return true;
        }
        return false;
    }

    // =========================================================
    // MÓDULO: LISTADOS
    // =========================================================

    public String listarBus() {
        return listarColeccion(myBuses, "No hay buses registrados");
    }

    public String listarRuta() {
        return listarColeccion(myRutas, "No hay rutas registradas");
    }

    public String listarSalida() {
        return listarColeccion(mySalidas, "No hay Salidas registradas");
    }

    public String listarTiquetes(String salida) {
        String error = validarCampoVacio(salida, "El código de salida");
        if (error != null) return error;

        Salida s = recorrerSalida(salida);
        if (s == null) return "La salida " + salida + " no existe";

        if (s.getMyTiquetes().isEmpty())
            return "No hay tiquetes vendidos para la salida " + salida;

        StringBuilder cad = new StringBuilder("*********Tiquetes Vendidos*********");
        for (Tiquete t : s.getMyTiquetes())
            cad.append("\n").append(t.toString()).append("\n");
        return cad.toString();
    }

    /** Método genérico para listar cualquier colección con toString() */
    private String listarColeccion(ArrayList<?> coleccion, String mensajeVacio) {
        if (coleccion.isEmpty()) return mensajeVacio;
        StringBuilder cad = new StringBuilder();
        for (Object o : coleccion) cad.append(o.toString()).append("\n");
        return cad.toString();
    }

    // =========================================================
    // MÓDULO: REPORTES
    // =========================================================

    public String reporteVentasRuta(String codRuta) {
        // Validar campo vacío
        String error = validarCampoVacio(codRuta, "El código de ruta");
        if (error != null) return error;

        // Validar que la ruta exista
        Ruta ruta = recorrerRuta(codRuta);
        if (ruta == null) return "La ruta con código " + codRuta + " no existe";

        StringBuilder cad = new StringBuilder();
        cad.append("REPORTE DE VENTAS POR RUTA\n");
        cad.append("Ruta: ").append(codRuta).append("\n\n");

        int totalTiquetes = 0;
        double totalVentas = 0;

        for (Salida s : mySalidas) {
            if (s.getRuta().getCodigo().equals(codRuta)) {
                double ventaSalida = calcularVentaSalida(s);
                agregarLineaSalidaReporte(cad, s, ventaSalida);
                totalTiquetes += s.getMyTiquetes().size();
                totalVentas += ventaSalida;
            }
        }

        if (totalTiquetes == 0)
            cad.append("No hay tiquetes vendidos para esta ruta.\n\n");

        cad.append("TOTAL TIQUETES: ").append(totalTiquetes).append("\n");
        cad.append("TOTAL RECAUDADO: $").append(totalVentas);
        return cad.toString();
    }

    public String reporteDiario() {
        // Validar que la caja esté abierta
        if (!validarCaja())
            return "No se puede generar el reporte: la caja no ha sido abierta";

        StringBuilder cad = new StringBuilder("REPORTE DIARIO - RUTAS COLOMBIA\n\n");
        cad.append("Total vendido: $ ").append(cajaDeldia.getTotalVendido()).append("\n");
        cad.append("Total reembolsado: $ ").append(cajaDeldia.getTotalReembolsado()).append("\n\n\n");
        cad.append("Ingreso neto: $ ").append(cajaDeldia.getIngresoNeto()).append("\n");
        cad.append("Caja final: $ ").append(cajaDeldia.getMontocaja()).append("\n\n");
        cad.append("Ventas por ruta:\n\n");

        for (Ruta r : myRutas) {
            double totalRuta = calcularVentasPorRuta(r);
            cad.append(r.getCodigo()).append(" ")
                    .append(r.getOrigen()).append("-").append(r.getDestino())
                    .append(":     $ ").append(totalRuta).append("\n");
        }
        return cad.toString();
    }

    public String reportePorFechas(LocalDate inicio, LocalDate fin) {
        // Validar que las fechas no sean nulas
        if (inicio == null) return "La fecha de inicio no puede estar vacía";
        if (fin == null)    return "La fecha de fin no puede estar vacía";

        // Validar que inicio no sea posterior a fin
        if (inicio.isAfter(fin))
            return "La fecha de inicio no puede ser posterior a la fecha de fin";

        // Validar que el rango no supere 1 año
        if (inicio.plusYears(1).isBefore(fin))
            return "El rango de fechas no puede superar un año";

        StringBuilder cad = new StringBuilder("REPORTE POR FECHAS\n\n");
        cad.append("Desde: ").append(inicio).append("\n");
        cad.append("Hasta: ").append(fin).append("\n\n");

        double total = 0;
        boolean haySalidas = false;

        for (Salida s : mySalidas) {
            LocalDate fechaSalida = s.getFecha();
            if (estaEnRangoDeFechas(fechaSalida, inicio, fin)) {
                double vendido = calcularVentaSalida(s);
                agregarLineaSalidaReporteFechas(cad, s, vendido);
                total += vendido;
                haySalidas = true;
            }
        }

        if (!haySalidas)
            cad.append("No se encontraron salidas en el rango de fechas indicado.\n\n");

        cad.append("TOTAL RECAUDADO: $ ").append(total);
        return cad.toString();
    }

    /** Calcula el total vendido de una salida (tiquetes * tarifa) */
    private double calcularVentaSalida(Salida s) {
        return s.getMyTiquetes().size() * s.getTarifa();
    }

    /** Calcula el total de ventas de todas las salidas de una ruta */
    private double calcularVentasPorRuta(Ruta r) {
        double total = 0;
        for (Salida s : mySalidas) {
            if (s.getRuta().equals(r)) total += calcularVentaSalida(s);
        }
        return total;
    }

    /** Verifica si una fecha está dentro del rango [inicio, fin] */
    private boolean estaEnRangoDeFechas(LocalDate fecha, LocalDate inicio, LocalDate fin) {
        return (fecha.isEqual(inicio) || fecha.isAfter(inicio))
                && (fecha.isEqual(fin) || fecha.isBefore(fin));
    }

    /** Agrega la línea de detalle de una salida al reporte de ventas por ruta */
    private void agregarLineaSalidaReporte(StringBuilder cad, Salida s, double ventaSalida) {
        cad.append("Salida: ").append(s.getIdSalida())
                .append(" | Fecha: ").append(s.getFecha())
                .append(" | Hora: ").append(s.getHora()).append("\n");
        cad.append("Bus: ").append(s.getBusAsignado().getPlaca()).append("\n");
        cad.append("Tiquetes vendidos: ").append(s.getMyTiquetes().size()).append("\n");
        cad.append("Total vendido: $").append(ventaSalida).append("\n\n");
    }

    /** Agrega la línea de detalle de una salida al reporte por fechas */
    private void agregarLineaSalidaReporteFechas(StringBuilder cad, Salida s, double vendido) {
        cad.append("Salida: ").append(s.getIdSalida()).append("\n");
        cad.append("Ruta: ").append(s.getRuta().getOrigen())
                .append(" -> ").append(s.getRuta().getDestino()).append("\n");
        cad.append("Fecha: ").append(s.getFecha()).append("\n");
        cad.append("Tiquetes vendidos: ").append(s.getMyTiquetes().size()).append("\n");
        cad.append("Total vendido: $ ").append(vendido).append("\n\n");
    }

    // =========================================================
    // MÓDULO: VALIDACIONES
    // =========================================================

    public boolean validarPlaca(String placa) {
        return recorrerBus(placa) != null;
    }

    public boolean validarRuta(String destino) {
        for (Ruta r : myRutas) {
            if (r.getDestino().equals(destino)) return true;
        }
        return false;
    }

    private boolean validarSalidas(LocalDateTime salida, Ruta ruta, Bus bus) {
        LocalDateTime llegadaNueva = calcularLlegada(salida, ruta).plusHours(ruta.getViajeTime());
        for (Salida s : mySalidas) {
            if (s.getBusAsignado().equals(bus)) {
                LocalDateTime salidaExistente = s.getFechaHoraSalida();
                LocalDateTime llegadaExistente = s.getFechaHoraLlegada().plusHours(s.getRuta().getViajeTime());
                if (hayCruceDeHorarios(salida, llegadaNueva, salidaExistente, llegadaExistente))
                    return true;
            }
        }
        return false;
    }

    private boolean validarConductor(LocalDateTime salida, Ruta ruta, Conductor conductor) {
        LocalDateTime llegadaNueva = calcularLlegada(salida, ruta);
        for (Salida s : mySalidas) {
            if (s.getConductorAsignado().equals(conductor)) {
                if (hayCruceDeHorarios(salida, llegadaNueva, s.getFechaHoraSalida(), s.getFechaHoraLlegada()))
                    return true;
            }
        }
        return false;
    }

    /** Verifica si dos intervalos de tiempo se solapan */
    private boolean hayCruceDeHorarios(LocalDateTime inicioNuevo, LocalDateTime finNuevo,
                                        LocalDateTime inicioExistente, LocalDateTime finExistente) {
        return inicioNuevo.isBefore(finExistente) && finNuevo.isAfter(inicioExistente);
    }

    private boolean busEnMantenimiento(Bus bus) {
        return bus.getEstado().equals("Mantenimiento");
    }

    /**
     * Valida que un campo String no sea nulo ni vacío.
     * Retorna mensaje de error o null si es válido.
     */
    private String validarCampoVacio(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty())
            return nombreCampo + " no puede estar vacío";
        return null;
    }

    /**
     * Valida que un valor numérico sea mayor a cero.
     * Retorna mensaje de error o null si es válido.
     */
    private String validarMontoPositivo(double valor, String nombreCampo) {
        if (valor <= 0)
            return nombreCampo + " debe ser un valor mayor a cero";
        return null;
    }
    
    private String validarFormatoPlaca(String placa){
    if(!placa.matches("[A-Za-z]{3}-\\d{3}\\s?")){
        return "Formato de placa inválido. Use el formato: AAA-000";
    }
    return null;
}

    private String validarTipoServicio(String tipoServ){
    if(!tipoServ.equals("Normal") && !tipoServ.equals("Ejecutivo")){
        return "Tipo de servicio inválido. Use: Normal o Ejecutivo";
    }
    return null;
}

    private String validarDocumento(String documento){
    if(!documento.matches("\\d+")){
        return "El documento debe contener solo números";
    }
    return null;
}

    private String validarNombrePersona(String nombre){
    if(!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
        return "El nombre solo puede contener letras y espacios";
    }
    return null;
}

    private String validarAsiento(int asiento){
    if(asiento <= 0){
        return "El número de asiento debe ser mayor a cero";
    }
    return null;
}

    private String validarTiempoViaje(int viajeTime){
    if(viajeTime > 72){
        return "El tiempo de viaje no puede superar las 72 horas";
    }
    return null;
}

    private String validarEstadoBus(String estado){
    if(!estado.equals("Activo")
            && !estado.equals("Mantenimiento")
            && !estado.equals("Inactivo")){
        return "Estado inválido. Use: Activo, Mantenimiento o Inactivo";
    }
    return null;
}

    private String validarFechaHora(String fecha, String hora){
    try{
        convertirFechaHora(fecha, hora);
        return null;
    }catch(DateTimeParseException e){
        return "Formato de fecha u hora inválido. Use: dd/MM/yyyy y HH:mm";
    }
}

    private String validarFechaFutura(LocalDateTime fechaHora){
    if(fechaHora.isBefore(LocalDateTime.now())){
        return "No se puede registrar una salida en una fecha y hora pasada";
    }
    return null;
}
   
    private boolean validarConductorExistente(String documento){
    return recorrerConductorDocumento(documento) != null;
   }
    
    private String validarFechaConductor(Date fecha){
    if(fecha == null){
        return "La fecha de ingreso no puede estar vacía";
    }
    if(fecha.after(new Date())){
        return "La fecha de ingreso no puede ser futura";
    }
    return null;
}
    
    private String validarParejaAsientos(Salida salida,String documento,int nuevoAsiento){
    int asientoAnterior = -1;
    for(Tiquete t : salida.getMyTiquetes()){
        if(t.getDocumento().equals(documento)){
            asientoAnterior = t.getMyPuesto().getNumAsiento();
            break;
        }
    }
    // si es el primer tiquete no hay nada que validar
    if(asientoAnterior == -1){
        return null;
    }
    boolean parejaValida =
            (asientoAnterior % 2 != 0 && nuevoAsiento == asientoAnterior + 1)
         || (asientoAnterior % 2 == 0 && nuevoAsiento == asientoAnterior - 1);
    if(!parejaValida){
        return "Los dos tiquetes deben ser asientos consecutivos de una misma pareja (1-2, 3-4, 5-6...)";
    }
    return null;
}

    private String validarLimiteTiquetesCliente(Salida salida, String documento){
    int cantidad = 0;
    for(Tiquete t : salida.getMyTiquetes()){

        if(t.getDocumento().equals(documento)){
            cantidad++;
        }
    }
    if(cantidad >= 2){
        return "Un cliente solo puede comprar máximo 2 tiquetes por salida";
    }
    return null;
}
    // =========================================================
    // MÓDULO: UTILIDADES
    // =========================================================

    private LocalDateTime convertirFechaHora(String fecha, String hora) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(fecha + " " + hora, formato);
    }

    private LocalDateTime calcularLlegada(LocalDateTime salida, Ruta ruta) {
        return salida.plusHours(ruta.getViajeTime());
    }

    private int buscarCodUltimaRuta() {
        String cod = this.myRutas.getLast().getCodigo();
        if (cod.length() == 0) return 1;
        return Integer.parseInt(cod.substring(1));
    }

    private int buscarCodUltimaSalida() {
        String cod = this.mySalidas.getLast().getIdSalida();
        if (cod.length() == 0) return 1;
        return Integer.parseInt(cod.substring(1)) + 1;
    }

    // =========================================================
    // MÓDULO: INICIALIZACIÓN DE DATOS BASE
    // =========================================================

    private void registrarDatosBase() {
        registrarBusesBase();
        registrarRutasBase();
        registrarConductoresBase();
        registrarSalidasBase();
    }

    private void registrarBusesBase() {
        myBuses.add(new Bus("KAA-101", "Normal"));
        myBuses.add(new Bus("KBB-202", "Ejecutivo"));
        myBuses.add(new Bus("KCC-303 ", "Normal"));
        myBuses.add(new Bus("KDD-404", "Ejecutivo"));
        myBuses.add(new Bus("KEE-505 ", "Normal"));
        myBuses.getLast().setEstado("Mantenimiento");
        myBuses.add(new Bus("KFF-606 ", "Normal"));
    }

    private void registrarRutasBase() {
        myRutas.add(new Ruta(0, "Bucaramanga", 6, 80000));
        myRutas.add(new Ruta(1, "Bogota", 15, 160000));
        myRutas.add(new Ruta(2, "Medellin", 16, 180000));
        myRutas.add(new Ruta(3, "Cartagena", 17, 220000));
    }

    private void registrarConductoresBase() {
        myConductores.add(new Conductor("1001", "Carlos Hernandez", new Date()));
        myConductores.add(new Conductor("2002", "Juan Lopez", new Date()));
        myConductores.add(new Conductor("3003", "Santiago Gamboa", new Date()));
        myConductores.add(new Conductor("4004", "Luis Celis", new Date()));
    }

    private void registrarSalidasBase() {
        agregarSalidaBase(1, 0, LocalDateTime.of(2026, 3, 15, 6,  0),  0, 0);
        agregarSalidaBase(2, 0, LocalDateTime.of(2026, 3, 15, 14, 0),  1, 1);
        agregarSalidaBase(3, 1, LocalDateTime.of(2026, 3, 16, 7,  0),  2, 2);
        agregarSalidaBase(4, 1, LocalDateTime.of(2026, 3, 16, 20, 0),  3, 3);
        agregarSalidaBase(5, 2, LocalDateTime.of(2026, 3, 17, 5,  30), 5, 0);
        agregarSalidaBase(6, 2, LocalDateTime.of(2026, 3, 17, 18, 0),  0, 1);
        agregarSalidaBase(7, 3, LocalDateTime.of(2026, 3, 18, 6,  30), 2, 2);
        agregarSalidaBase(8, 3, LocalDateTime.of(2026, 3, 19, 19, 30), 1, 3);
    }

    /** Crea y agrega una salida base con índices de ruta, bus y conductor */
    private void agregarSalidaBase(int id, int indiceRuta, LocalDateTime fechaHora,
                                    int indiceBus, int indiceConductor) {
        Ruta ruta = myRutas.get(indiceRuta);
        mySalidas.add(new Salida(
                id, ruta, fechaHora,
                calcularLlegada(fechaHora, ruta),
                myBuses.get(indiceBus),
                myConductores.get(indiceConductor)
        ));
    }
}