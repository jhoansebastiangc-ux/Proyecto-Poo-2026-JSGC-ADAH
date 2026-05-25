package Negocio;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Empresa {
    private ArrayList<Bus> myBuses;
    private ArrayList<Ruta> myRutas;
    private ArrayList<Salida> mySalidas;
    private ArrayList<Cliente> myClientes;
    private ArrayList<Conductor> myConductores;
    private Caja cajaDeldia;
    public Empresa() {
        //Aquí se inicializa los atributos de las clases
        this.myBuses=new ArrayList<>();
        this.myRutas=new ArrayList<>();
        this.mySalidas=new ArrayList<>();
        this.myClientes=new ArrayList<>();
        this.myConductores=new ArrayList<>();
        registrarDatosBase();      

    }
    public String abrirCaja(double montoInicial){
        String cad="";
        if(this.cajaDeldia==null){
        this.cajaDeldia=new Caja(montoInicial);
        cad="Caja abierta con exito";
        }else{
        cad="Caja ya ha sido abierta";
        } 
        return cad;
    }
    public boolean validarCaja(){
        if(this.cajaDeldia==null){
            return false;
        }else{
            return true;
        }
    }
    
    //Metodo usado para cargar las placas dentro de un comboBox
    public String cargarPlacas() {
        StringBuilder cad=new StringBuilder();
        for(Bus b:myBuses){
            cad.append(b.getPlaca()).append(",");
        }
    return cad.toString();
}
   
    //Metodo usado para cargar las rutas dentro de un comboBox
    public String cargarRutas(){
        StringBuilder cad=new StringBuilder();
        for (Ruta r:myRutas){
            cad.append(r.getCodigo()).append(",");
        }
        return cad.toString();
    }
    
    //Metodo usado para cargar las salidas dentro de un comboBox
    public String cargarSalidas(){
        StringBuilder cad=new StringBuilder();
        for(Salida s:mySalidas){
            cad.append(s.getIdSalida()).append(",");
        }
        return cad.toString();
    }
    
    //Método usado para cargar los conductores dentro de un comboBox
    public String cargarConductores(){
        StringBuilder cad=new StringBuilder();
        for(Conductor c :myConductores){
            cad.append(c.getNombre()).append(",");
        }
        return cad.toString();
    }
    
    // Método para cargar las salidas disponibles para venta
    public String cargarSalidasVenta(){
        StringBuilder cad=new StringBuilder();
        for (Salida s:mySalidas){
            if(!s.getEstado().equals("Cancelada")){
                for (Puesto p:s.getBusAsignado().getMyPuestos()){
                    if(p.isOcupado().equals("Disponible")){
                    break;
                    }
                }
              cad.append(s.getIdSalida()).append(",");  
            }
        }
        return cad.toString();
    }
    
    // Método para cargar la información de una salida
    public String cargarDatosSalida(String salida){
        
        StringBuilder cad=new StringBuilder();
        Salida s=recorrerSalida(salida);
        if(s == null){
            return "";
        }
        Ruta r=s.getRuta();
        cad.append(r.getOrigen()).append(",").append(r.getDestino()).append(",").append(s.getFecha().format(DateTimeFormatter.ISO_DATE))
                .append(",").append(s.getHora().format(DateTimeFormatter.ofPattern("HH:mm"))).append(",").append(s.getBusAsignado().getPlaca()).append(",")
                .append(s.getBusAsignado().getTipoServ());
        return cad.toString();
    }
    
    // Método para cargar los asientos disponibles de una salida
    public String cargarAsientos(String codSalida){
        Salida s=recorrerSalida(codSalida);
        StringBuilder cad=new StringBuilder();
        for(Puesto p:s.getBusAsignado().getMyPuestos()){
            if(!s.puestoOcupado(p.getNumAsiento())){
                cad.append("Asiento: "+p.getNumAsiento()).append(",");
            }
        }
        return cad.toString();
    }
    
    //Métodos para la creación de los objetos por default    
    private void registrarDatosBase(){
        registrarBusesBase();
        registrarRutasBase();
        registrarConductoresBase();
        registrarSalidasBase();
    }
    
    //Creación de objetos tipo Bus por default
    private void registrarBusesBase(){
        myBuses.add(new Bus("KAA-101","Normal"));
        myBuses.add(new Bus("KBB-202","Ejecutivo"));
        myBuses.add(new Bus("KCC-303 ","Normal"));
        myBuses.add(new Bus("KDD-404","Ejecutivo"));
        myBuses.add(new Bus("KEE-505 ","Normal"));
        myBuses.getLast().setEstado("Mantenimiento");
        myBuses.add(new Bus("KFF-606 ","Normal"));
    }
    
    //Creación de objetos tipo Ruta por default
    private void registrarRutasBase(){
        myRutas.add(new Ruta(0,"Bucaramanga",6,80000));
        myRutas.add(new Ruta(1,"Bogota",15,160000));
        myRutas.add(new Ruta(2,"Medellin",16,180000));
        myRutas.add(new Ruta(3,"Cartagena",17,220000));
    }
    //Creación de objetos tipo Salida por default
    private void registrarSalidasBase(){
        mySalidas.add(new Salida(1,myRutas.getFirst(),LocalDateTime.of(2026,3,15,6,0),calcularLlegada(LocalDateTime.of(2026,3,15,6,0),myRutas.getFirst()),myBuses.getFirst(), myConductores.getFirst()));
        mySalidas.add(new Salida(2,myRutas.getFirst(),LocalDateTime.of(2026,3,15,14,0),calcularLlegada(LocalDateTime.of(2026,3,15,14,0),myRutas.getFirst()),myBuses.get(1), myConductores.get(1)));        
        mySalidas.add(new Salida(3,myRutas.get(1),LocalDateTime.of(2026,3,16,7,0),calcularLlegada(LocalDateTime.of(2026,3,16,7,0),myRutas.get(1)),myBuses.get(2), myConductores.get(2)));
        mySalidas.add(new Salida(4,myRutas.get(1),LocalDateTime.of(2026,3,16,20,0),calcularLlegada(LocalDateTime.of(2026,3,16,20,0),myRutas.get(1)),myBuses.get(3), myConductores.get(3)));
        mySalidas.add(new Salida(5,myRutas.get(2),LocalDateTime.of(2026,3,17,5,30),calcularLlegada(LocalDateTime.of(2026,3,17,5,30),myRutas.get(2)),myBuses.getLast(), myConductores.getFirst()));
        mySalidas.add(new Salida(6,myRutas.get(2),LocalDateTime.of(2026,3,17,18,0),calcularLlegada(LocalDateTime.of(2026,3,17,18,0),myRutas.get(2)),myBuses.getFirst(), myConductores.get(1)));
        mySalidas.add(new Salida(7,myRutas.get(3),LocalDateTime.of(2026,3,18,6,30),calcularLlegada(LocalDateTime.of(2026,3,18,6,30),myRutas.get(3)),myBuses.get(2), myConductores.get(2)));
        mySalidas.add(new Salida(8,myRutas.get(3),LocalDateTime.of(2026,3,19,19,30),calcularLlegada(LocalDateTime.of(2026,3,19,19,30),myRutas.get(3)),myBuses.get(1), myConductores.get(3)));
    }
    
    //Creación de objetos tipo Conductor por default
    private void registrarConductoresBase(){
        myConductores.add(new Conductor("1001", "Carlos Hernandez", new Date()));
        myConductores.add(new Conductor("2002", "Juan Lopez", new Date()));
        myConductores.add(new Conductor("3003", "Santiago Gamboa", new Date()));
        myConductores.add(new Conductor("4004", "Luis Celis", new Date()));
    }
    
    // Método para retornar la información de un bus
    public String retornarDatosbus(String placa){
     Bus b = recorrerBus(placa);

       if(b == null){
        return "";
       }

      return b.getTipoServ() + "," + b.getEstado();
   }
   
    // Método para retornar la información de una ruta
    public String retornarDatosRuta(String codigo){
     Ruta r = recorrerRuta(codigo);
     if (r == null){
         return "";
     }
  return r.getOrigen() + ","
            + r.getDestino() + ","
            + r.getTarifab();
}
   
    // Método para buscar un bus por placa
    private Bus recorrerBus(String placa){
       for(Bus b:myBuses){
           if (b.getPlaca().equals(placa)){
               return b;
           }
       }
       return null;
   }
   
    // Método para buscar una ruta por código
    private Ruta recorrerRuta(String ruta){
       for(Ruta r:myRutas){
           if (r.getCodigo().equals(ruta)){
               return r;
           }
       }
       return null;
   }
    
    //Método para buscar Clientes por su documento
    private Cliente recorrerCliente(String documento){
        for (Cliente c : myClientes){
            if(c.getDocumento().equals(documento)){
                return c;
            }
        }
        return null;
    }
      
    // Método para buscar una salida por código
    private Salida recorrerSalida(String salida){
          for (Salida s:mySalidas){
              if(s.getIdSalida().equals(salida)){
                  return s;
              }
          }
          return null;
      }
    
    //Método para buscar Conductores por su nombre
    private Conductor recorrerConductor(String nombre){
        for (Conductor c: myConductores){
            if(c.getNombre().equals(nombre)){
                return c;
            }
        }
        return null;
    }
    
    private Salida buscarSalidaAlterna(Salida original){

    for(Salida s : mySalidas){

        if(
            !s.equals(original)
            && s.getRuta().equals(original.getRuta())
            && s.getEstado().equals("Programada")
            && s.hayAsientosDisponibles()
        ){

            return s;
        }
    }

    return null;
}
    
    //Método para convertir la Fecha y Hora
    private LocalDateTime convertirFechaHora(String fecha,String hora){
     DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
     return LocalDateTime.parse(fecha + " " + hora, formato);
  }
    
    //Método para verificar si un Bus se encuentra en mantenimiento
    private boolean busEnMantenimiento(Bus bus){
     return bus.getEstado().equals("Mantenimiento");
  }
    
    //REQUERIMIENTOS FUNCIONALES #1
    
    //Método para registar obejtos tipo Bus
    public String registrarBus(String placa, String tipoServ){
        String cad="";
        if (validarPlaca(placa)){
            return "Placa ya registrada";
        }
        Bus nuevo = new Bus(placa,tipoServ);
        myBuses.add(nuevo);
        cad="Se registro un nuevo bus: \n"+ myBuses.getLast().toString();
        return cad;
    }
      
    //Método para registrar objetos tipo Ruta
    public String registrarRuta(String destino,int tarifa, int viajeTime){
        String cad="";
        if(!validarRuta(destino)){
        int contR=buscarCodUltimaRuta();
        Ruta ruta=new Ruta(contR,destino,viajeTime,tarifa);
        myRutas.add(ruta);
        cad="Se registro la ruta: \n"+ myRutas.getLast().toString();
        }else{
            cad="Ruta ya Registrada";
        }
        return cad;

    }
    
    //Metodo para registrar objetos tipo salida
    public String registrarSalida(String fecha,String hora,String codRuta,String placaBus, String nombreConductor){
     LocalDateTime salida =convertirFechaHora(fecha,hora);

    Bus bus = recorrerBus(placaBus);
    Ruta ruta = recorrerRuta(codRuta);
    Conductor conductor = recorrerConductor(nombreConductor);
    LocalDateTime llegada = calcularLlegada(salida,ruta);

    if(busEnMantenimiento(bus)){
        return "El bus seleccionado está en mantenimiento";
    }

    if(validarSalidas(salida, ruta, bus)){

        return "No se pudo registrar la salida\nEl bus tiene otra salida";
    }

    int cod = buscarCodUltimaSalida();
    mySalidas.add(new Salida(cod, ruta, salida, llegada, bus, conductor));

      return "Salida registrada\n" + mySalidas.getLast();
    }
    
    //Metodo para registrar objetos tipo tiquete
    public String registrarTiquete(String salida, int asiento, String nombre, String documento){
       Salida s=recorrerSalida(salida);
       Bus b=s.getBusAsignado();
       Puesto puesto=b.buscarPuesto(asiento);
       Cliente cliente=recorrerCliente(documento);
       if (cliente == null){
           cliente = new Cliente(documento, nombre);
           myClientes.add(cliente);
       } else {
           if(!cliente.getNombre().equalsIgnoreCase(nombre)){
               return "El documento ya está registrado con otro nombre";
           }
       }
       double valorPagar=s.getTarifa();
       String cad=s.registrarTiquete(s,nombre,documento,puesto,valorPagar);
       actualizarCaja(valorPagar,0.0);
        return cad;
    }
    
public String cancelarSalida(String codSalida){

    Salida salidaCancelada = recorrerSalida(codSalida);

    if(salidaCancelada == null){
        return "Salida no encontrada";
    }
    if(salidaCancelada.getEstado().equals("Cancelada")){
        return "La salida ya fue cancelada anteriormente";
    }

    salidaCancelada.setEstado("Cancelada");

    StringBuilder reporte = new StringBuilder();

    reporte.append("CANCELACION DE SALIDA: ")
            .append(salidaCancelada.getIdSalida())
            .append(" (")
            .append(salidaCancelada.getRuta().getCodigo())
            .append(" ")
            .append(salidaCancelada.getRuta().getOrigen())
            .append(" -> ")
            .append(salidaCancelada.getRuta().getDestino())
            .append(")\n");

    reporte.append("Tiquetes procesados:\n");

    int reprogramados = 0;
    int reembolsados = 0;

    for(Tiquete t : salidaCancelada.getMyTiquetes()){

        Salida nuevaSalida = buscarSalidaAlternativa(salidaCancelada);

        if(nuevaSalida != null){

            int sillaNueva = buscarSillaDisponible(nuevaSalida);

            Puesto nuevoPuesto =
                    nuevaSalida.getBusAsignado()
                            .buscarPuesto(sillaNueva);

            Tiquete nuevo =
                    new Tiquete(
                            reprogramados + 100,
                            t.getNombre(),
                            t.getDocumento(),
                            nuevoPuesto,
                            nuevaSalida.getTarifa()
                    );

            nuevo.setEstado("Reprogramado");

            nuevaSalida.getMyTiquetes().add(nuevo);

            t.setEstado("Reprogramado");

            reporte.append("- ")
                    .append(t.getCodTq())
                    .append(" Pasajero ")
                    .append(t.getDocumento())
                    .append(" Silla ")
                    .append(t.getMyPuesto().getNumAsiento())
                    .append(" -> REPROGRAMADO a ")
                    .append(nuevaSalida.getIdSalida())
                    .append(" Silla ")
                    .append(sillaNueva)
                    .append("\n");

            reprogramados++;

        }else{

            t.setEstado("Reembolsado");

            actualizarCaja(0, t.getValorPagar());

            reporte.append("- ")
                    .append(t.getCodTq())
                    .append(" Pasajero ")
                    .append(t.getDocumento())
                    .append(" -> REEMBOLSADO\n");

            reembolsados++;
        }
    }

    reporte.append("TOTAL REPROGRAMADOS: ")
            .append(reprogramados)
            .append("\n");

    reporte.append("TOTAL REEMBOLSADOS: ")
            .append(reembolsados);

    return reporte.toString();
}
private Salida buscarSalidaAlternativa(Salida cancelada){

    for(Salida s : mySalidas){

        if(!s.getIdSalida().equals(cancelada.getIdSalida())
                && s.getEstado().equals("Programada")
                && s.getRuta().equals(cancelada.getRuta())){

            if(cuposDisponibles(s)){
                return s;
            }
        }
    }

    return null;
}
private boolean cuposDisponibles(Salida s){

    return s.getMyTiquetes().size()
            < s.getBusAsignado().getMyPuestos().length;
}
private int buscarSillaDisponible(Salida s){

    for(Puesto p : s.getBusAsignado().getMyPuestos()){

        if(!s.puestoOcupado(p.getNumAsiento())){
            return p.getNumAsiento();
        }
    }

    return -1;
}
    
    private void actualizarCaja(double ingreso,double rembolsado){
        this.cajaDeldia.setMontocaja(ingreso,rembolsado);
    }
    
    //Método para la validación de las Placas
    public boolean validarPlaca(String placa){
        boolean validar=false;
        for(Bus b:myBuses){
            if (b.getPlaca().equals(placa)){
                validar=true;
                break;
            }
        }
        return validar;
    }
    
    //Método para la validación de las Rutas
    public boolean validarRuta(String destino){
        boolean retu=false;
        for(Ruta r:myRutas){
            if(r.getDestino().equals(destino)){
               retu=true;
            }
        } 
        return retu;
    }
    
    //Método para la validación de las Salidas
    private boolean validarSalidas(LocalDateTime salida,Ruta ruta,Bus bus){

    LocalDateTime llegadaNueva =calcularLlegada(salida, ruta);
    llegadaNueva=llegadaNueva.plusHours(ruta.getViajeTime());

    for(Salida s : mySalidas){

        if(s.getBusAsignado().equals(bus)){

            LocalDateTime salidaExistente = s.getFechaHoraSalida();

            LocalDateTime llegadaExistente= s.getFechaHoraLlegada();
            
            llegadaExistente =llegadaExistente.plusHours(s.getRuta().getViajeTime());

            // Verifica cruce de horarios
            if(salida.isBefore(llegadaExistente)
                    && llegadaNueva.isAfter(salidaExistente)){

                return true;
            }
        }
    }

    return false;
 }
    
    // Método para calcular la fecha y hora de llegada
    private LocalDateTime calcularLlegada(LocalDateTime salida,Ruta ruta){
    LocalDateTime llegada = salida.plusHours(ruta.getViajeTime());
    return llegada;

    }
    
    //Método para buscar el codigo de la última Ruta creada
    private int buscarCodUltimaRuta(){
        String cod=this.myRutas.getLast().getCodigo();
        if (cod.length()==0){
            return 1;
        }
        int numCod=Integer.parseInt(cod.substring(1));
        return numCod;
    }
    
    //Método para buscar el codigo de la última Salida creada
    private int buscarCodUltimaSalida(){
        String cod=this.mySalidas.getLast().getIdSalida();
        if(cod.length()==0){
            return 1;
        }
        int numCod=Integer.parseInt(cod.substring(1))+1;
        return numCod;
    }
    
    //Método para listar los Buses creados 
    public  String  listarBus( ){
       StringBuilder cad = new StringBuilder();  
       for(Bus c:myBuses){
        cad.append(c.toString()).append("\n");
       }
    
        if (cad.length()==0) {
             return "No hay camiones registrados";
        }
    
        return cad.toString();
    }
    
    //Método para listar las Rutas creadas
    public String listarRuta(){
        StringBuilder cad= new StringBuilder();
        for (Ruta r:myRutas){
            cad.append(r.toString()).append("\n");
        }
         if(cad.length()==0){
            cad.append("No hay rutas registradas");
         }
         return cad.toString();
    }
    
    //Metodo para listar las salidas creadas
    public String listarSalida(){
        StringBuilder cad= new StringBuilder();
        for (Salida s:mySalidas){
            cad.append(s.toString()).append("\n");
        }
         if(cad.length()==0){
            cad.append("No hay Salidas registradas");
         }
         return cad.toString();
    }
    
    //Método para listar los Tiquetes de una salida
        public String listarTiquetes(String salida){
            StringBuilder cad= new StringBuilder();
            Salida s=recorrerSalida(salida);
            cad.append("*********Tiquetes Vendidos*********");
            for(Tiquete t:s.getMyTiquetes()){
                cad.append("\n").append(t.toString()).append("\n");
            }
         return cad.toString();
    }
        
    public String reporteVentasRuta(String codRuta){

    StringBuilder cad = new StringBuilder();

    int totalTiquetes = 0;
    double totalVentas = 0;

    cad.append("REPORTE DE VENTAS POR RUTA\n");
    cad.append("Ruta: ").append(codRuta).append("\n\n");

    for(Salida s : mySalidas){

        if(s.getRuta().getCodigo().equals(codRuta)){

            cad.append("Salida: ")
                    .append(s.getIdSalida())
                    .append(" | Fecha: ")
                    .append(s.getFecha())
                    .append(" | Hora: ")
                    .append(s.getHora())
                    .append("\n");

            cad.append("Bus: ")
                    .append(s.getBusAsignado().getPlaca())
                    .append("\n");

            cad.append("Tiquetes vendidos: ")
                    .append(s.getMyTiquetes().size())
                    .append("\n");

            cad.append("Total vendido: $")
                    .append(
                            s.getMyTiquetes().size()
                            * s.getTarifa()
                    )
                    .append("\n\n");

            totalTiquetes += s.getMyTiquetes().size();

            totalVentas +=
                    s.getMyTiquetes().size()
                    * s.getTarifa();
        }
    }

    cad.append("TOTAL TIQUETES: ")
            .append(totalTiquetes)
            .append("\n");

    cad.append("TOTAL RECAUDADO: $")
            .append(totalVentas);

    return cad.toString();
}
    
   public String reporteDiario(){

    StringBuilder cad = new StringBuilder();

    cad.append("REPORTE DIARIO - RUTAS COLOMBIA\n\n");

    double vendido =
            cajaDeldia.getTotalVendido();

    double reembolsado =
            cajaDeldia.getTotalReembolsado();

    double neto =
            cajaDeldia.getIngresoNeto();

    double cajaFinal =
            cajaDeldia.getMontocaja();

    cad.append("Total vendido: $ ")
            .append(vendido)
            .append("\n");

    cad.append("Total reembolsado: $ ")
            .append(reembolsado)
            .append("\n\n\n");

    cad.append("Ingreso neto: $ ")
            .append(neto)
            .append("\n");

    cad.append("Caja final: $ ")
            .append(cajaFinal)
            .append("\n\n");

    cad.append("Ventas por ruta:\n\n");

    for(Ruta r : myRutas){

        double totalRuta = 0;

        for(Salida s : mySalidas){

            if(s.getRuta().equals(r)){

                totalRuta +=
                        s.getMyTiquetes().size()
                        * s.getTarifa();
            }
        }

        cad.append(r.getCodigo())
                .append(" ")
                .append(r.getOrigen())
                .append("-")
                .append(r.getDestino())
                .append(":     $ ")
                .append(totalRuta)
                .append("\n");
    }

    return cad.toString();
}
   
   public String reportePorFechas(LocalDate inicio,
                               LocalDate fin){

    StringBuilder cad = new StringBuilder();

    cad.append("REPORTE POR FECHAS\n\n");

    cad.append("Desde: ")
            .append(inicio)
            .append("\n");

    cad.append("Hasta: ")
            .append(fin)
            .append("\n\n");

    double total = 0;

    for(Salida s : mySalidas){

        LocalDate fechaSalida =
                s.getFecha();

        if(
            (fechaSalida.isEqual(inicio)
            || fechaSalida.isAfter(inicio))

            &&

            (fechaSalida.isEqual(fin)
            || fechaSalida.isBefore(fin))
        ){

            double vendido =
                    s.getMyTiquetes().size()
                    * s.getTarifa();

            cad.append("Salida: ")
                    .append(s.getIdSalida())
                    .append("\n");

            cad.append("Ruta: ")
                    .append(s.getRuta().getOrigen())
                    .append(" -> ")
                    .append(s.getRuta().getDestino())
                    .append("\n");

            cad.append("Fecha: ")
                    .append(s.getFecha())
                    .append("\n");

            cad.append("Tiquetes vendidos: ")
                    .append(s.getMyTiquetes().size())
                    .append("\n");

            cad.append("Total vendido: $ ")
                    .append(vendido)
                    .append("\n\n");

            total += vendido;
        }
    }

    cad.append("TOTAL RECAUDADO: $ ")
            .append(total);

    return cad.toString();
}
    
    //Metodo para actualizar el estado de un bus
    public String actualizarBus(String placa,String nuevoEstado){
     Bus b = recorrerBus(placa);
     if (b == null){
         return "Bus no encontrado";
     }
     b.setEstado(nuevoEstado);
     return "Estado actualizado correctamente";
}
    
    //Metodo para actualizar el valor de una ruta
    public String actualizarRuta(String cod,int nuevatarifa){
    Ruta r = recorrerRuta(cod);
    if(r == null){
        return "No se encontró esa ruta";
    }
    r.setTarifab(nuevatarifa);
    return "Ruta actualizada";
   }
    
}
