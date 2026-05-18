/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author estudiante
 */
public class Ruta {
    private String codigo;
    private String origen;
    private String destino;
    private int viajeTime;
    private int Tarifab;

    public Ruta(int cont,String origen, String destino,int viajeTime, int Tarifab) {
        this.codigo = generarCodigoRuta(cont);
        this.origen = origen;
        this.destino = destino;
        this.viajeTime=viajeTime;
        this.Tarifab = Tarifab;
    }
    private String generarCodigoRuta(int cont){
        cont++;
        String cod=String.format("R%02d",cont);
        return cod;
    }
    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getTarifab() {
        return Tarifab;
    }

    public int getViajeTime() {
        return viajeTime;
    }
    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setTarifab(int Tarifab) {
        this.Tarifab = Tarifab;
    }

    public void setViajeTime(int viajeTime) {
        this.viajeTime = viajeTime;
    }

    @Override
    public String toString() {
        return "Codigo=" + codigo + "\nOrigen=" + origen + "\nDestino=" + destino + "\nTiempo de viaje= "+viajeTime+"\nTarifa Base=" + Tarifab+"\n";
    }
    
  
}
