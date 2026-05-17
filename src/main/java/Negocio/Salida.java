/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
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

    public Salida(int codSalida, String ruta, String fecha, String hora, String busAsignado) {
        this.idSalida = generarCodigoSalida(codSalida);
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.busAsignado = busAsignado;
        this.estado = "Programada";
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

    @Override
    public String toString() {
        return "Salida\nidSalida=" + idSalida + "\nruta=" + ruta + "\nfecha=" + fecha + "\nhora=" + hora + "\nbusAsignado=" + busAsignado + "\nestado=" + estado+"\n";
    }
    
}
