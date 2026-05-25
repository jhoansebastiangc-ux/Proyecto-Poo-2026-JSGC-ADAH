package Negocio;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Salida {
    private String idSalida;
    private Ruta ruta;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private Bus busAsignado;
    private String estado;
    private LocalDate fechaLlegada;
    private LocalTime horaLlegada;
    private double tarifa;
    private ArrayList<Tiquete> myTiquetes;
    private Conductor conductorAsignado;
    
    public Salida(int codSalida, Ruta ruta,LocalDateTime salida, LocalDateTime llegada, Bus busAsignado, Conductor conductorAsignado) {
        this.idSalida = generarCodigoSalida(codSalida);
        this.ruta = ruta;
        this.fechaSalida = salida.toLocalDate();
        this.horaSalida = salida.toLocalTime();
        this.busAsignado = busAsignado;
        this.conductorAsignado = conductorAsignado;
        this.estado = "Programada";
        this.fechaLlegada= llegada.toLocalDate();
        this.horaLlegada= llegada.toLocalTime();
        this.tarifa=calcularTarifa();
        this.myTiquetes=new ArrayList<>();
    }
    public String registrarTiquete(Salida salida,String nombre, String documento, Puesto myPuesto, double valorPagar){
        int cod=buscarCodUltimoTq();
        Tiquete t=new Tiquete(cod,nombre,documento,myPuesto, valorPagar);
        this.myTiquetes.add(t);
        return "Tiquete vendido con exito:\nTiquete:"+myTiquetes.getLast().getCodTq()+"\nPasajero: "+myTiquetes.getLast().getDocumento()+"---"+myTiquetes.getLast().getNombre()
                +"\nSalida:"+salida.getIdSalida()+"("+salida.getRuta().getOrigen()+"--->"+salida.getRuta().getDestino()
                +")"+salida.getFecha()+"   "+salida.getHora()+"\nBus: "+salida.getBusAsignado().getPlaca()
                +"  "+"("+salida.getBusAsignado().getTipoServ()+")  Capacidad: "+salida.getBusAsignado().getMyPuestos().length
                +"\nSilla: "+myPuesto.getNumAsiento()+"\nValor Pagado: $"+valorPagar+"\nEstado del tiquete: "+t.getEstado();
    }
    
    private int buscarCodUltimoTq(){
        if(this.myTiquetes.isEmpty()){
            return 0;
        }
        String cod=this.myTiquetes.getLast().getCodTq();
        int numCod=Integer.parseInt(cod.substring(3));
        return numCod;
    }
    public boolean hayAsientosDisponibles(){

    for(Puesto p : this.busAsignado.getMyPuestos()){

        if(!puestoOcupado(p.getNumAsiento())){
            return true;
        }
    }

    return false;
}
    public Puesto buscarPrimerAsientoLibre(){

    for(Puesto p : busAsignado.getMyPuestos()){

        if(!puestoOcupado(p.getNumAsiento())){
            return p;
        }
    }

    return null;
}
    
    public boolean puestoOcupado(int numPuesto){

    for(Tiquete t : myTiquetes){

        if(t.getMyPuesto().getNumAsiento() == numPuesto){
            return true;
        }
    }

    return false;
}
    
    private String generarCodigoSalida(int codSalida){
        String cod=String.format("S%03d",codSalida);
        return cod;
    }
    
    private double calcularTarifa(){
        double tarifa=ruta.getTarifab();
        if(busAsignado.getTipoServ().equals("Ejecutivo")){
            tarifa*=1.20;
        }
        return tarifa;
    }
    
    public String getIdSalida() {
        return idSalida;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public LocalDate getFecha() {
        return fechaSalida;
    }

    public LocalTime getHora() {
        return horaSalida;
    }

    public Bus getBusAsignado() {
        return busAsignado;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public double getTarifa() {
        return tarifa;
    }


    public String getEstado() {
        return estado;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }
    public LocalDateTime getFechaHoraSalida(){
        return LocalDateTime.of(fechaSalida, horaSalida);
    }
    
     public LocalDateTime getFechaHoraLlegada(){
         return LocalDateTime.of(fechaLlegada, horaLlegada);
    }

    public ArrayList<Tiquete> getMyTiquetes() {
        return myTiquetes;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }
     

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }


    public void setFecha(LocalDate fecha) {
        this.fechaSalida = fecha;
    }

    public void setHora(LocalTime hora) {
        this.horaSalida = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void setBusAsignado(Bus busAsignado) {
        this.busAsignado = busAsignado;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }
    
    

    @Override
public String toString() {

    DateTimeFormatter formatoFecha =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    DateTimeFormatter formatoHora =
            DateTimeFormatter.ofPattern("HH:mm");

    return "Salida\n" +
            "idSalida=" + idSalida +
            "\nRuta=" + ruta.getCodigo() +
            "\nFechaSalida=" +
            fechaSalida.format(formatoFecha) +
            "\nHoraSalida=" +
            horaSalida.format(formatoHora) +
            "\nBusAsignado=" + busAsignado.getPlaca() +
            "\nFechaLlegada=" +
            fechaLlegada.format(formatoFecha) +
            "\nHoraLlegada=" +
            horaLlegada.format(formatoHora) +
            "\nEstado=" + estado +
            "\nTarifa="+tarifa +
            "\nConductor="+conductorAsignado.getNombre();
}
    
}
