/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author CAMILA ARIAS
 */
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
    
    public Salida(int codSalida, Ruta ruta,LocalDateTime salida, LocalDateTime llegada, Bus busAsignado) {
        
        LocalDate fechaLlegada = llegada.toLocalDate();
        LocalTime horaLlegada = llegada.toLocalTime();
        LocalDate fechaSalida = salida.toLocalDate();
        LocalTime horaSalida = salida.toLocalTime();
        
        this.idSalida = generarCodigoSalida(codSalida);
        this.ruta = ruta;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.busAsignado = busAsignado;
        this.estado = "Programada";
        this.fechaLlegada= fechaLlegada;
        this.horaLlegada= horaLlegada;
    }
    
    private String generarCodigoSalida(int codSalida){
        String cod=String.format("S%03d",codSalida);
        return cod;
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
            "\nEstado=" + estado + "\n";
}
    
}
