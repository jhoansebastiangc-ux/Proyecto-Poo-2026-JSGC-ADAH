package Negocio;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Empresa {

    private ArrayList<Bus>       myBuses;
    private ArrayList<Ruta>      myRutas;
    private ArrayList<Salida>    mySalidas;
    private ArrayList<Cliente>   myClientes;
    private ArrayList<Conductor> myConductores;
    private Caja cajaDeldia;

    public Empresa() {
        this.myBuses       = new ArrayList<>();
        this.myRutas       = new ArrayList<>();
        this.mySalidas     = new ArrayList<>();
        this.myClientes    = new ArrayList<>();
        this.myConductores = new ArrayList<>();
        registrarDatosBase();
    }

    // =========================================================
    // MÓDULO: CAJA
    // =========================================================

    public String abrirCaja(double montoInicial) {
        String error = validarMontoPositivo(montoInicial, "El monto inicial");
        if (error != null) return error;
        if (this.cajaDeldia != null) return "La caja ya ha sido abierta";
        this.cajaDeldia = new Caja(montoInicial);
        return "Caja abierta con exito";
    }

    public boolean validarCaja() {
        return this.cajaDeldia != null;
    }

    private void actualizarCaja(double ingreso, double reembolsado) {
        this.cajaDeldia.setMontocaja(ingreso, reembolsado,0.0);
    }
    
    private void actualizarCaja(double ingreso, double reembolsado, double vuelta) {
        this.cajaDeldia.setMontocaja(ingreso, reembolsado, vuelta);
    }

    // =========================================================
    // MÓDULO: CARGA DE DATOS PARA COMBOS
    // =========================================================

    public String cargarPlacas() {
        return construirCadena(myBuses.stream()
                .map(Bus::getPlaca).toArray(String[]::new));
    }

    public String cargarRutas() {
        return construirCadena(myRutas.stream()
                .map(Ruta::getCodigo).toArray(String[]::new));
    }

    public String cargarSalidas() {
        return construirCadena(mySalidas.stream()
                .map(Salida::getIdSalida).toArray(String[]::new));
    }

    public String cargarConductores() {
        return construirCadena(myConductores.stream()
                .map(Conductor::getNombre).toArray(String[]::new));
    }

    public String cargarSalidasVenta() {
        StringBuilder cad = new StringBuilder();
        for (Salida s : mySalidas) {
            if (!s.getEstado().equals("Cancelada") &&
                !s.getEstado().equals("Terminada") &&
                tieneAsientosDisponibles(s)) {
                cad.append(s.getIdSalida()).append(",");
            }
        }
        return cad.toString();
    }
    
    public String cargarSalidasCancelar() {
    StringBuilder cad = new StringBuilder();

    for (Salida s : mySalidas) {
        if (s.getEstado().equals("Programada")) {
            cad.append(s.getIdSalida()).append(",");
        }
    }

    return cad.toString();
}

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

    public String buscarDatosCliente(String documento) {
    Cliente c = recorrerCliente(documento);
    if (c == null) return "";
    return c.getNombre() + ","
         + c.getTelefono() + ","
         + c.getCorreo() + ","
         + c.getTipoCliente();
    }
    
    private boolean tieneAsientosDisponibles(Salida s) {
        for (Puesto p : s.getBusAsignado().getMyPuestos()) {
            if (!s.puestoOcupado(p.getNumAsiento())) return true;
        }
        return false;
    }

    private String construirCadena(String[] valores) {
        StringBuilder cad = new StringBuilder();
        for (String v : valores) cad.append(v).append(",");
        return cad.toString();
    }

    // =========================================================
    // MÓDULO: BÚSQUEDA (recorridos internos)
    // =========================================================

    private Bus recorrerBus(String placa) {
        for (Bus b : myBuses)
            if (b.getPlaca().equals(placa)) return b;
        return null;
    }

    private Ruta recorrerRuta(String ruta) {
        for (Ruta r : myRutas)
            if (r.getCodigo().equals(ruta)) return r;
        return null;
    }

    private Cliente recorrerCliente(String documento) {
        for (Cliente c : myClientes)
            if (c.getDocumento().equals(documento)) return c;
        return null;
    }

    private Salida recorrerSalida(String salida) {
        for (Salida s : mySalidas)
            if (s.getIdSalida().equals(salida)) return s;
        return null;
    }

    private Conductor recorrerConductor(String nombre) {
        for (Conductor c : myConductores)
            if (c.getNombre().equals(nombre)) return c;
        return null;
    }

    private Conductor recorrerConductorDocumento(String documento) {
        for (Conductor c : myConductores)
            if (c.getDocumento().equals(documento)) return c;
        return null;
    }

    // =========================================================
    // MÓDULO: REGISTRO
    // =========================================================

    public String registrarBus(String placa, String tipoServ) {
        String e;
        if ((e = validarCampoVacio(placa,    "La placa"))            != null) return e;
        if ((e = validarCampoVacio(tipoServ, "El tipo de servicio")) != null) return e;
        if ((e = validarFormatoPlaca(placa))                         != null) return e;
        if ((e = validarTipoServicio(tipoServ))                      != null) return e;
        if (validarPlaca(placa)) return "Placa ya registrada";
        myBuses.add(new Bus(placa, tipoServ));
        return "Se registro un nuevo bus: \n" + myBuses.getLast();
    }

    public String registrarRuta(String destino, int tarifa, int viajeTime) {
        String e;
        if ((e = validarCampoVacio(destino, "El destino"))        != null) return e;
        if ((e = validarMontoPositivo(tarifa,    "La tarifa"))     != null) return e;
        if ((e = validarMontoPositivo(viajeTime, "El tiempo de viaje")) != null) return e;
        if ((e = validarTiempoViaje(viajeTime))                   != null) return e;
        if (validarRuta(destino)) return "Ruta ya Registrada";
        int cod = buscarCodUltimaRuta();
        myRutas.add(new Ruta(cod, destino, viajeTime, tarifa));
        return "Se registro la ruta: \n" + myRutas.getLast();
    }

    public String registrarSalida(String fecha, String hora, String codRuta,
                                   String placaBus, String nombreConductor) {
        String e;
        if ((e = validarCampoVacio(fecha,           "La fecha"))           != null) return e;
        if ((e = validarCampoVacio(hora,            "La hora"))            != null) return e;
        if ((e = validarCampoVacio(codRuta,         "El código de ruta"))  != null) return e;
        if ((e = validarCampoVacio(placaBus,        "La placa del bus"))   != null) return e;
        if ((e = validarCampoVacio(nombreConductor, "El nombre del conductor")) != null) return e;

        LocalDateTime salida;
        try {
            salida = convertirFechaHora(fecha, hora);
        } catch (DateTimeParseException ex) {
            return "Formato de fecha u hora inválido. Use: dd/MM/yyyy y HH:mm";
        }

        if ((e = validarFechaFutura(salida)) != null) return e;

        Bus       bus       = recorrerBus(placaBus);
        Ruta      ruta      = recorrerRuta(codRuta);
        Conductor conductor = recorrerConductor(nombreConductor);

        if (bus       == null) return "El bus con placa " + placaBus + " no existe";
        if (ruta      == null) return "La ruta con código " + codRuta + " no existe";
        if (conductor == null) return "El conductor " + nombreConductor + " no existe";

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

public String registrarTiquete(String salida, int asiento, String nombre,
                                String documento, boolean idaYVuelta,
                                String telefono, String correo) {
    String e;
    if ((e = validarAsiento(asiento))       != null) return e;
    if ((e = validarDocumento(documento))    != null) return e;
    if ((e = validarNombrePersona(nombre))   != null) return e;
    if ((e = validarTelefono(telefono))      != null) return e;
    if ((e = validarCorreo(correo))          != null) return e;
    if (!validarCaja()) return "No se puede vender: la caja no ha sido abierta";

    Salida s = recorrerSalida(salida);
    if (s == null) return "La salida " + salida + " no existe";
    if (s.getEstado().equals("Cancelada"))
        return "No se puede vender tiquetes para una salida cancelada";
    if (s.getEstado().equals("Terminada"))
        return "No se puede vender tiquetes para una salida terminada";

    Puesto puesto = s.getBusAsignado().buscarPuesto(asiento);
    if (puesto == null)           return "El asiento " + asiento + " no existe en el bus asignado";
    if (s.puestoOcupado(asiento)) return "El asiento " + asiento + " ya está ocupado";

    if ((e = validarLimiteTiquetesCliente(s, documento))   != null) return e;
    if ((e = validarParejaAsientos(s, documento, asiento)) != null) return e;

    // Resolver cliente con todos sus datos
    Cliente cliente = resolverCliente(documento, nombre, telefono, correo);
    if (cliente == null)
        return "El documento ya está registrado con datos diferentes (nombre, teléfono o correo no coinciden)";

    double valorPagar  = calcularValorTiquete(s.getTarifa(), idaYVuelta, cliente);
    double valorVuelta = idaYVuelta ? valorPagar / 2.0 : 0.0;

    cliente.registrarCompra();

    String cad = s.registrarTiquete(s, nombre, documento, cliente, puesto, valorPagar, idaYVuelta);
    actualizarCaja(valorPagar, 0.0, valorVuelta);
    return cad;
}

/**
 * Calcula el valor final del tiquete aplicando descuentos en orden:
 * 1. Ida y vuelta: 10% de descuento
 * 2. Cliente frecuente: 5% adicional
 */
private double calcularValorTiquete(double tarifa, boolean idaYVuelta, Cliente cliente) {
    double valor = idaYVuelta ? tarifa * 2 * 0.90 : tarifa;
    if (cliente.esFrecuente()) {
        valor *= 0.95;
    }
    return valor;
}

    public String registrarConductor(String documento, String nombre, Date fechaIngreso) {
        String e;
        if ((e = validarCampoVacio(documento, "El documento")) != null) return e;
        if ((e = validarCampoVacio(nombre,    "El nombre"))    != null) return e;
        if ((e = validarFechaConductor(fechaIngreso))          != null) return e;
        if ((e = validarDocumento(documento))                  != null) return e;
        if ((e = validarNombrePersona(nombre))                 != null) return e;
        if (validarConductorExistente(documento))
            return "Ya existe un conductor registrado con ese documento";
        Conductor nuevo = new Conductor(documento, nombre, fechaIngreso);
        myConductores.add(nuevo);
        return "Conductor registrado correctamente\n" + nuevo;
    }

private Cliente resolverCliente(String documento, String nombre,
                                 String telefono, String correo) {
    Cliente cliente = recorrerCliente(documento);

    if (cliente == null) {
        // Cliente nuevo: verificar que teléfono y correo no estén en uso
        if (telefonoEnUso(telefono, documento))
            return null; // señal de error, se maneja arriba
        if (correoEnUso(correo, documento))
            return null;
        cliente = new Cliente(documento, nombre, telefono, correo);
        myClientes.add(cliente);
        return cliente;
    }

    // Cliente existente: todos los datos deben coincidir
    if (!cliente.getNombre().equalsIgnoreCase(nombre))     return null;
    if (!cliente.getTelefono().equals(telefono))           return null;
    if (!cliente.getCorreo().equalsIgnoreCase(correo))     return null;

    return cliente;
}

    // =========================================================
    // MÓDULO: CANCELACIÓN
    // =========================================================

    public String cancelarSalida(String codSalida) {
    String error = validarCampoVacio(codSalida, "El código de salida");
    if (error != null) return error;

    Salida salidaCancelada = recorrerSalida(codSalida);
    if (salidaCancelada == null)
        return "Salida no encontrada";
    if (salidaCancelada.getEstado().equals("Cancelada"))
        return "La salida ya fue cancelada anteriormente";
    if (salidaCancelada.getEstado().equals("En Viaje"))
        return "No se puede cancelar una salida que ya está en viaje";
    if (salidaCancelada.getEstado().equals("Terminada"))
        return "No se puede cancelar una salida ya terminada";
    if (!salidaCancelada.getMyTiquetes().isEmpty() && !validarCaja())
        return "No se puede cancelar: la caja no ha sido abierta";

    salidaCancelada.setEstado("Cancelada");

    StringBuilder reporte = new StringBuilder();
    agregarEncabezadoCancelacion(reporte, salidaCancelada);
    reporte.append("Tiquetes procesados:\n");

    int[] contadores = procesarTiquetesCancelacion(salidaCancelada, reporte);

    reporte.append("TOTAL REPROGRAMADOS: ").append(contadores[0]).append("\n");
    reporte.append("TOTAL REEMBOLSADOS:  ").append(contadores[1]);
    return reporte.toString();
}

    private void agregarEncabezadoCancelacion(StringBuilder reporte, Salida s) {
        reporte.append("CANCELACION DE SALIDA: ").append(s.getIdSalida())
               .append(" (").append(s.getRuta().getCodigo()).append(" ")
               .append(s.getRuta().getOrigen()).append(" -> ")
               .append(s.getRuta().getDestino()).append(")\n");
    }

    private int[] procesarTiquetesCancelacion(Salida salidaCancelada, StringBuilder reporte) {
        int reprogramados = 0, reembolsados = 0;
        for (Tiquete t : salidaCancelada.getMyTiquetes()) {
            Salida alternativa = buscarSalidaAlternativa(salidaCancelada);
            if (alternativa != null) {
                reprogramarTiquete(t, alternativa, reprogramados, reporte);
                reprogramados++;
            } else {
                reembolsarTiquete(t, reporte);
                reembolsados++;
            }
        }
        return new int[]{reprogramados, reembolsados};
    }

    private void reprogramarTiquete(Tiquete t, Salida nuevaSalida,
    int contador, StringBuilder reporte) {
    int sillaNueva = buscarSillaDisponible(nuevaSalida);
    Puesto nuevoPuesto = nuevaSalida.getBusAsignado().buscarPuesto(sillaNueva);

    Tiquete nuevo = new Tiquete(
            contador + 100,
            t.getNombre(),
            t.getDocumento(),
            t.getCliente(),        
            nuevoPuesto,
            nuevaSalida.getTarifa(),
            t.isIdaYVuelta());

    nuevo.setEstado("Reprogramado");
    nuevaSalida.getMyTiquetes().add(nuevo);
    t.setEstado("Reprogramado");

    reporte.append("- ").append(t.getCodTq())
           .append(" Pasajero ").append(t.getDocumento())
           .append(" Silla ").append(t.getMyPuesto().getNumAsiento())
           .append(" -> REPROGRAMADO a ").append(nuevaSalida.getIdSalida())
           .append(" Silla ").append(sillaNueva).append("\n");
}

    private void reembolsarTiquete(Tiquete t, StringBuilder reporte) {
        t.setEstado("Reembolsado");
    actualizarCaja(0, t.getValorPagar(), t.getValorVuelta());
    reporte.append("- ").append(t.getCodTq())
           .append(" Pasajero ").append(t.getDocumento())
           .append(" -> REEMBOLSADO\n");
    }

    // =========================================================
    // MÓDULO: ACTUALIZACIÓN
    // =========================================================

    public String actualizarBus(String placa, String nuevoEstado) {
        String e;
        if ((e = validarCampoVacio(placa,       "La placa"))  != null) return e;
        if ((e = validarCampoVacio(nuevoEstado, "El estado")) != null) return e;
        if ((e = validarEstadoBus(nuevoEstado))               != null) return e;

        Bus b = recorrerBus(placa);
        if (b == null) return "Bus no encontrado";
        if (b.getEstado().equals(nuevoEstado))
            return "El bus ya se encuentra en estado: " + nuevoEstado;
        if (nuevoEstado.equals("Mantenimiento") && tieneSalidasProgramadas(b))
            return "No se puede poner en mantenimiento: el bus tiene salidas programadas";

        b.setEstado(nuevoEstado);
        return "Estado actualizado correctamente a: " + nuevoEstado;
    }

    public String actualizarRuta(String cod, int nuevatarifa) {
        String e;
        if ((e = validarCampoVacio(cod, "El código de ruta"))   != null) return e;
        if ((e = validarMontoPositivo(nuevatarifa, "La tarifa")) != null) return e;

        Ruta r = recorrerRuta(cod);
        if (r == null) return "No se encontró esa ruta";
        if (r.getTarifab() == nuevatarifa) return "La ruta ya tiene esa tarifa registrada";

        r.setTarifab(nuevatarifa);
        return "Ruta actualizada correctamente";
    }

    private boolean tieneSalidasProgramadas(Bus bus) {
        for (Salida s : mySalidas)
            if (s.getBusAsignado().equals(bus) && s.getEstado().equals("Programada"))
                return true;
        return false;
    }

    // =========================================================
    // MÓDULO: LISTADOS Y REPORTES
    // =========================================================

    public String listarBus(){
        String encabezado =String.format("%-12s %-12s %-12s %-15s%n",
                    "PLACA", "TIPO", "CAPACIDAD", "ESTADO")
                + "--------------------------------------------------------------\n"; 
        
    return encabezado+listarColeccion(myBuses,    "No hay buses registrados"); 
    }
    public String listarRuta()   { 
            String encabezado = String.format(
            "%-8s %-12s %-15s %-12s %-12s%n",
            "CODIGO", "ORIGEN", "DESTINO", "HORAS", "TARIFA")
            + "--------------------------------------------------------------\n";
            
        
        return encabezado+listarColeccion(myRutas,    "No hay rutas registradas"); 
    }
    public String listarSalida() { 
            String encabezado = String.format(
            "%-6s %-6s %-12s %-8s %-10s %-20s %-15s%n",
            "ID", "RUTA", "FECHA", "HORA",
            "BUS", "CONDUCTOR", "ESTADO")
            +"-------------------------------------------------------------------------------\n";
        
        
        return encabezado+listarColeccion(mySalidas,  "No hay Salidas registradas"); 
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
            cad.append("\n").append(t).append("\n");
        return cad.toString();
    }
    
    public String listarConductores() {

    String encabezado = String.format(
            "%-15s %-25s %-15s%n",
            "DOCUMENTO", "NOMBRE", "INGRESO")
            + "--------------------------------------------------------\n";

    return encabezado + listarColeccion(myConductores,
            "No hay conductores registrados");
 }

    public String reporteVentasRuta(String codRuta) {
    String error = validarCampoVacio(codRuta, "El código de ruta");
    if (error != null) return error;
    Ruta ruta = recorrerRuta(codRuta);
    if (ruta == null) return "La ruta con código " + codRuta + " no existe";

    StringBuilder cad = new StringBuilder("REPORTE DE VENTAS POR RUTA\nRuta: ")
            .append(codRuta).append("\n\n");

    int totalTiquetes = 0;
    double totalRecaudado = 0, totalNeto = 0;

    for (Salida s : mySalidas) {
        if (!s.getRuta().getCodigo().equals(codRuta)) continue;

        double recaudadoSalida = 0, netoSalida = 0;
        int tiquetesValidos = 0;

        for (Tiquete t : s.getMyTiquetes()) {
            // Excluir tiquetes reembolsados
            if (t.getEstado().equals("Reembolsado")) continue;
            recaudadoSalida += t.getValorPagar();
            netoSalida      += t.getValorNeto();
            tiquetesValidos++;
        }

        agregarLineaSalidaReporte(cad, s, recaudadoSalida, netoSalida, tiquetesValidos);
        totalTiquetes  += tiquetesValidos;
        totalRecaudado += recaudadoSalida;
        totalNeto      += netoSalida;
    }

    if (totalTiquetes == 0)
        cad.append("No hay tiquetes vendidos para esta ruta.\n\n");

    cad.append("TOTAL TIQUETES:        ").append(totalTiquetes).append("\n");
    cad.append("TOTAL RECAUDADO:     $ ").append(totalRecaudado).append("\n");
    cad.append("TOTAL NETO EMPRESA:  $ ").append(totalNeto);
    return cad.toString();
    }
    
    private void agregarLineaSalidaReporte(StringBuilder cad, Salida s,
                                        double recaudado, double neto,
                                        int tiquetesValidos) {
     cad.append("Salida: ").append(s.getIdSalida())
       .append(" | Fecha: ").append(s.getFecha())
       .append(" | Hora: ").append(s.getHora()).append("\n")
       .append("Bus: ").append(s.getBusAsignado().getPlaca()).append("\n")
       .append("Tiquetes vigentes: ").append(tiquetesValidos).append("\n")
       .append("Recaudado: $").append(recaudado)
       .append("  /  Neto empresa: $").append(neto).append("\n\n");
    }
    
    
    public String reporteDiario() {
    if (!validarCaja())
        return "No se puede generar el reporte: la caja no ha sido abierta";

    StringBuilder cad = new StringBuilder("REPORTE DIARIO - RUTAS COLOMBIA\n\n");
    cad.append("Total recaudado:              $ ").append(cajaDeldia.getTotalVendido()).append("\n");
    cad.append("  - Por transferir a destinos: $ ").append(cajaDeldia.getTotalVuelta()).append("\n");
    cad.append("  - Reembolsos:                $ ").append(cajaDeldia.getTotalReembolsado()).append("\n");
    cad.append("─────────────────────────────────\n");
    cad.append("Ingreso neto empresa:         $ ").append(cajaDeldia.getIngresoNeto()).append("\n");
    cad.append("Caja final:                   $ ").append(cajaDeldia.getMontocaja()).append("\n\n");
    cad.append("Ventas por ruta:\n\n");

    for (Ruta r : myRutas) {
        double[] totalesRuta = calcularTotalesRuta(r);
        cad.append(r.getCodigo()).append(" ")
           .append(r.getOrigen()).append("-").append(r.getDestino())
           .append(":  recaudado $").append(totalesRuta[0])
           .append("  /  neto $").append(totalesRuta[1])
           .append("\n");
    }
    return cad.toString();
}
    
    private double[] calcularTotalesRuta(Ruta r) {
    double recaudado = 0, neto = 0;
    for (Salida s : mySalidas) {
        if (!s.getRuta().equals(r)) continue;
        for (Tiquete t : s.getMyTiquetes()) {
            if (t.getEstado().equals("Reembolsado")) continue;
            recaudado += t.getValorPagar();
            neto      += t.getValorNeto();
        }
    }
    return new double[]{recaudado, neto};
    }

    public String reportePorFechas(LocalDate inicio, LocalDate fin) {
    if (inicio == null) return "La fecha de inicio no puede estar vacía";
    if (fin    == null) return "La fecha de fin no puede estar vacía";
    if (inicio.isAfter(fin))
        return "La fecha de inicio no puede ser posterior a la fecha de fin";
    if (inicio.plusYears(1).isBefore(fin))
        return "El rango de fechas no puede superar un año";

    StringBuilder cad = new StringBuilder("REPORTE POR FECHAS\n\nDesde: ")
            .append(inicio).append("\nHasta: ").append(fin).append("\n\n");

    double totalRecaudado = 0, totalNeto = 0;
    boolean haySalidas = false;

    for (Salida s : mySalidas) {
        if (!verificarRangoDeFechas(s.getFecha(), inicio, fin)) continue;

        double recaudadoSalida = 0, netoSalida = 0;
        int tiquetesValidos = 0;

        for (Tiquete t : s.getMyTiquetes()) {
            if (t.getEstado().equals("Reembolsado")) continue;
            recaudadoSalida += t.getValorPagar();
            netoSalida      += t.getValorNeto();
            tiquetesValidos++;
        }

        agregarLineaSalidaReporteFechas(cad, s, recaudadoSalida, netoSalida, tiquetesValidos);
        totalRecaudado += recaudadoSalida;
        totalNeto      += netoSalida;
        haySalidas = true;
    }

    if (!haySalidas)
        cad.append("No se encontraron salidas en el rango indicado.\n\n");

    cad.append("TOTAL RECAUDADO:     $ ").append(totalRecaudado).append("\n");
    cad.append("TOTAL NETO EMPRESA:  $ ").append(totalNeto);
    return cad.toString();
}

    private boolean verificarRangoDeFechas(LocalDate fecha, LocalDate inicio, LocalDate fin) {
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }


   private void agregarLineaSalidaReporteFechas(StringBuilder cad, Salida s,
                                              double recaudado, double neto,
                                              int tiquetesValidos) {
    cad.append("Salida: ").append(s.getIdSalida()).append("\n")
       .append("Ruta: ").append(s.getRuta().getOrigen())
       .append(" -> ").append(s.getRuta().getDestino()).append("\n")
       .append("Fecha: ").append(s.getFecha()).append("\n")
       .append("Tiquetes vigentes: ").append(tiquetesValidos).append("\n")
       .append("Recaudado: $").append(recaudado)
       .append("  /  Neto empresa: $").append(neto).append("\n\n");
}

    private String listarColeccion(ArrayList<?> coleccion, String mensajeVacio) {
        if (coleccion.isEmpty()) return mensajeVacio;
        StringBuilder cad = new StringBuilder();
        for (Object o : coleccion) cad.append(o).append("\n");
        return cad.toString();
    }

    // =========================================================
    // MÓDULO: VALIDACIONES AUTOMÁTICAS (llamadas desde el Timer)
    // =========================================================

    /**
     * Marca como "Terminada" toda salida cuya hora de llegada ya pasó.
     * Llamar desde el Timer de MenuPrincipal cada segundo.
     */
    public void validarEstadoSalidas() {
    LocalDateTime ahora = LocalDateTime.now();
    for (Salida s : mySalidas) {
        if (s.getEstado().equals("Cancelada")) continue;

        // Programada → En Viaje cuando llega la hora de salida
        if (s.getEstado().equals("Programada") &&
            !s.getFechaHoraSalida().isAfter(ahora)) {
            s.setEstado("En Viaje");
            s.getBusAsignado().setEstado("Activo");
            continue;
        }

        // En Viaje → Terminada cuando llega la hora de llegada
        if (s.getEstado().equals("En Viaje") &&
            !s.getFechaHoraLlegada().isAfter(ahora)) {
            s.setEstado("Terminada");
            s.getBusAsignado().setEstado("Inactivo");
        }
    }
}

    /**
     * Al llegar la hora de salida, si hay menos de 5 tiquetes vendidos:
     * cancela la salida y reprograma o reembolsa cada tiquete.
     * Llamar desde el Timer de MenuPrincipal cada segundo.
     */
    public void validarMinimoTiquetes() {
    LocalDateTime ahora = LocalDateTime.now();
    for (Salida s : mySalidas) {
        if (!s.getEstado().equals("Programada"))   continue;
        if (s.getFechaHoraSalida().isAfter(ahora)) continue;
        if (s.getMyTiquetes().size() >= 5)         continue;
        // Cancela antes de que validarEstadoSalidas la ponga "En Viaje"
        s.setEstado("Cancelada");
        procesarTiquetesCancelacion(s, new StringBuilder());
    }
}

    // =========================================================
    // MÓDULO: VALIDACIONES
    // =========================================================

    public boolean validarPlaca(String placa) { return recorrerBus(placa) != null; }

    public boolean validarRuta(String destino) {
        for (Ruta r : myRutas)
            if (r.getDestino().equals(destino)) return true;
        return false;
    }

    private boolean validarSalidas(LocalDateTime salida, Ruta ruta, Bus bus) {
        LocalDateTime llegadaNueva = calcularLlegada(salida, ruta).plusHours(ruta.getViajeTime());
        for (Salida s : mySalidas) {
        
            if (s.getEstado().equals("Cancelada") || 
               s.getEstado().equals("Terminada")) continue;

            if (s.getBusAsignado().equals(bus)) {
               LocalDateTime salidaE  = s.getFechaHoraSalida();
               LocalDateTime llegadaE = s.getFechaHoraLlegada().plusHours(s.getRuta().getViajeTime());
            if (hayCruceDeHorarios(salida, llegadaNueva, salidaE, llegadaE)) return true;
        }
    }
    return false;
}

    private boolean validarConductor(LocalDateTime salida, Ruta ruta, Conductor conductor) {
        LocalDateTime llegadaNueva = calcularLlegada(salida, ruta);
        for (Salida s : mySalidas) {
       
            if (s.getEstado().equals("Cancelada") || 
                s.getEstado().equals("Terminada")) continue;
        
            if (s.getConductorAsignado().equals(conductor)) {
                if (hayCruceDeHorarios(salida, llegadaNueva,
                     s.getFechaHoraSalida(), s.getFechaHoraLlegada())) return true;
        }
    }
    return false;
}

    private boolean hayCruceDeHorarios(LocalDateTime ini1, LocalDateTime fin1,
                                        LocalDateTime ini2, LocalDateTime fin2) {
        return ini1.isBefore(fin2) && fin1.isAfter(ini2);
    }

    private boolean busEnMantenimiento(Bus bus) { return bus.getEstado().equals("Mantenimiento"); }

    private String validarCampoVacio(String valor, String nombreCampo) {
        return (valor == null || valor.trim().isEmpty())
                ? nombreCampo + " no puede estar vacío" : null;
    }

    private String validarMontoPositivo(double valor, String nombreCampo) {
        return valor <= 0 ? nombreCampo + " debe ser un valor mayor a cero" : null;
    }

    private String validarFormatoPlaca(String placa) {
        return placa.matches("[A-Za-z]{3}-\\d{3}\\s?") ? null
                : "Formato de placa inválido. Use el formato: AAA-000";
    }

    private String validarTipoServicio(String tipoServ) {
        return (tipoServ.equals("Normal") || tipoServ.equals("Ejecutivo")) ? null
                : "Tipo de servicio inválido. Use: Normal o Ejecutivo";
    }

    private String validarDocumento(String documento) {
        return documento.matches("\\d+") ? null
                : "El documento debe contener solo números";
    }

    private String validarNombrePersona(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ? null
                : "El nombre solo puede contener letras y espacios";
    }

    private String validarAsiento(int asiento) {
        return asiento > 0 ? null : "El número de asiento debe ser mayor a cero";
    }

    private String validarTiempoViaje(int viajeTime) {
        return viajeTime <= 36 ? null : "El tiempo de viaje no puede superar las 36 horas";
    }

    private String validarEstadoBus(String estado) {
        return (estado.equals("Activo") || estado.equals("Mantenimiento") ||
                estado.equals("Inactivo")) ? null
                : "Estado inválido. Use: Activo, Mantenimiento o Inactivo";
    }

    private String validarFechaFutura(LocalDateTime fechaHora) {
        return fechaHora.isBefore(LocalDateTime.now())
                ? "No se puede registrar una salida en una fecha y hora pasada" : null;
    }

    private boolean validarConductorExistente(String documento) {
        return recorrerConductorDocumento(documento) != null;
    }

    private String validarFechaConductor(Date fecha) {
        if (fecha == null)        return "La fecha de ingreso no puede estar vacía";
        if (fecha.after(new Date())) return "La fecha de ingreso no puede ser futura";
        return null;
    }

    private String validarParejaAsientos(Salida salida, String documento, int nuevoAsiento) {
        int asientoAnterior = -1;
        for (Tiquete t : salida.getMyTiquetes()) {
            if (t.getDocumento().equals(documento)) {
                asientoAnterior = t.getMyPuesto().getNumAsiento();
                break;
            }
        }
        if (asientoAnterior == -1) return null;
        boolean parejaValida =
                (asientoAnterior % 2 != 0 && nuevoAsiento == asientoAnterior + 1) ||
                (asientoAnterior % 2 == 0 && nuevoAsiento == asientoAnterior - 1);
        return parejaValida ? null
                : "Los dos tiquetes deben ser asientos consecutivos (1-2, 3-4, 5-6...)";
    }

    private String validarLimiteTiquetesCliente(Salida salida, String documento) {
        int cantidad = 0;
        for (Tiquete t : salida.getMyTiquetes())
            if (t.getDocumento().equals(documento)) cantidad++;
        return cantidad >= 2 ? "Un cliente solo puede comprar máximo 2 tiquetes por salida" : null;
    }
    
    private String validarTelefono(String telefono) {
    if (telefono == null || telefono.trim().isEmpty())
        return "El teléfono no puede estar vacío";
    if (!telefono.matches("\\d{7,15}"))
        return "El teléfono debe contener entre 7 y 15 dígitos";
    return null;
}

private String validarCorreo(String correo) {
    if (correo == null || correo.trim().isEmpty())
        return "El correo no puede estar vacío";
    if (!correo.matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$"))
        return "El correo no tiene un formato válido";
    return null;
}

private boolean telefonoEnUso(String telefono, String documentoActual) {
    for (Cliente c : myClientes)
        if (c.getTelefono().equals(telefono) &&
            !c.getDocumento().equals(documentoActual)) return true;
    return false;
}

private boolean correoEnUso(String correo, String documentoActual) {
    for (Cliente c : myClientes)
        if (c.getCorreo().equals(correo) &&
            !c.getDocumento().equals(documentoActual)) return true;
    return false;
}

    // =========================================================
    // MÓDULO: BÚSQUEDA DE SALIDA ALTERNATIVA
    // =========================================================

    /**
     * Busca una salida alternativa para reprogramar tiquetes.
     * Condiciones: misma ruta, estado Programada, con cupos,
     * y dentro de las 24 horas siguientes a la salida cancelada.
     */
    private Salida buscarSalidaAlternativa(Salida cancelada) {
        LocalDateTime inicioBusqueda = cancelada.getFechaHoraSalida();
        LocalDateTime finBusqueda    = inicioBusqueda.plusHours(24);

        for (Salida s : mySalidas) {
            if (s.getIdSalida().equals(cancelada.getIdSalida()))    continue;
            if (!s.getEstado().equals("Programada"))                continue;
            if (!s.getRuta().getCodigo().equals(
                    cancelada.getRuta().getCodigo()))               continue;
            if (s.getFechaHoraSalida().isBefore(inicioBusqueda))    continue;
            if (!s.getFechaHoraSalida().isBefore(finBusqueda))      continue;
            if (!cuposDisponibles(s))                               continue;
            return s;
        }
        return null;
    }

    private boolean cuposDisponibles(Salida s) {
        return s.getMyTiquetes().size() < s.getBusAsignado().getMyPuestos().length;
    }

    private int buscarSillaDisponible(Salida s) {
        for (Puesto p : s.getBusAsignado().getMyPuestos())
            if (!s.puestoOcupado(p.getNumAsiento())) return p.getNumAsiento();
        return -1;
    }

    // =========================================================
    // MÓDULO: UTILIDADES
    // =========================================================

    private LocalDateTime convertirFechaHora(String fecha, String hora) {
        return LocalDateTime.parse(fecha + " " + hora,
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    private LocalDateTime calcularLlegada(LocalDateTime salida, Ruta ruta) {
        return salida.plusHours(ruta.getViajeTime());
    }

    private int buscarCodUltimaRuta() {
        String cod = myRutas.getLast().getCodigo();
        return cod.isEmpty() ? 1 : Integer.parseInt(cod.substring(1));
    }

    private int buscarCodUltimaSalida() {
        String cod = mySalidas.getLast().getIdSalida();
        return cod.isEmpty() ? 1 : Integer.parseInt(cod.substring(1)) + 1;
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
        myBuses.add(new Bus("KAA-101",  "Normal"));
        myBuses.add(new Bus("KBB-202",  "Ejecutivo"));
        myBuses.add(new Bus("KCC-303 ", "Normal"));
        myBuses.add(new Bus("KDD-404",  "Ejecutivo"));
        myBuses.add(new Bus("KEE-505 ", "Normal"));
        myBuses.getLast().setEstado("Mantenimiento");
        myBuses.add(new Bus("KFF-606 ", "Normal"));
    }

    private void registrarRutasBase() {
        myRutas.add(new Ruta(0, "Bucaramanga", 6,  80000));
        myRutas.add(new Ruta(1, "Bogota",     15, 160000));
        myRutas.add(new Ruta(2, "Medellin",   16, 180000));
        myRutas.add(new Ruta(3, "Cartagena",  17, 220000));
    }

    private void registrarConductoresBase() {
        myConductores.add(new Conductor("1001", "Carlos Hernandez", new Date()));
        myConductores.add(new Conductor("2002", "Juan Lopez",       new Date()));
        myConductores.add(new Conductor("3003", "Santiago Gamboa",  new Date()));
        myConductores.add(new Conductor("4004", "Luis Celis",       new Date()));
    }

    private void registrarSalidasBase() {
        agregarSalidaBase(1, 0, LocalDateTime.of(2026, 6, 1, 6,  0),  0, 0);
        agregarSalidaBase(2, 0, LocalDateTime.of(2026, 6, 7, 14, 0),  1, 1);
        agregarSalidaBase(3, 1, LocalDateTime.of(2026, 6, 11, 7,  0),  2, 2);
        agregarSalidaBase(4, 1, LocalDateTime.of(2026, 6, 13, 20, 0),  3, 3);
        agregarSalidaBase(5, 2, LocalDateTime.of(2026, 6, 14, 5, 30),  5, 0);
        agregarSalidaBase(6, 2, LocalDateTime.of(2026, 6, 19, 18, 0),  0, 1);
        agregarSalidaBase(7, 3, LocalDateTime.of(2026, 6, 20, 6, 30),  2, 2);
        agregarSalidaBase(8, 3, LocalDateTime.of(2026, 6, 21, 19, 30), 1, 3);
    }

    private void agregarSalidaBase(int id, int indiceRuta, LocalDateTime fechaHora,
                                    int indiceBus, int indiceConductor) {
        Ruta ruta = myRutas.get(indiceRuta);
        mySalidas.add(new Salida(id, ruta, fechaHora,
                calcularLlegada(fechaHora, ruta),
                myBuses.get(indiceBus),
                myConductores.get(indiceConductor)));
    }
}