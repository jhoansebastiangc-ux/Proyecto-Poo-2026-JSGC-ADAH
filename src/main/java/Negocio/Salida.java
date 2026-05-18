/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
/**
 *
 * @author CAMILA ARIAS
 */
public class Salida {
    private String idSalida;
    private String ruta;
    private String fecha;
    private String hora;
    private String busAsignado;
    private String estado;
    private String fechaLlegada;
    private String horaLlegada;
    private double tarifa;
    
    public Salida(int codSalida, String ruta, String fecha, String hora, String busAsignado, int rutaTime) {
        String fechaLlegada="";
        String horaLlegada="";
        try{
        String salidaComp=fecha+" "+hora;
        SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date salida = formato.parse(salidaComp);
        Calendar cal = Calendar.getInstance();
        cal.setTime(salida);
        cal.add(Calendar.HOUR_OF_DAY, rutaTime);
        Date llegada=cal.getTime();
        SimpleDateFormat formatoFecha =new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora =new SimpleDateFormat("HH:mm");
        fechaLlegada =formatoFecha.format(llegada);
        horaLlegada =formatoHora.format(llegada);
        }catch(ParseException e){
          //Genera error si no se pone try-catch  
        }
        this.idSalida = generarCodigoSalida(codSalida);
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
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

    public String getRuta() {
        return ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getBusAsignado() {
        return busAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }
    

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setBusAsignado(String busAsignado) {
        this.busAsignado = busAsignado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    

    @Override
    public String toString() {
        return "Salida\nidSalida=" + idSalida + "\nRuta=" + ruta + "\nFechaSalida=" + fecha + 
                "\nHoraSalida=" + hora + "\nBusAsignado=" + busAsignado +"\nFechaLlegada="+fechaLlegada+
                "\nHoraLlegada="+horaLlegada +"\nEstado=" + estado+"\n";
    }
    
}
