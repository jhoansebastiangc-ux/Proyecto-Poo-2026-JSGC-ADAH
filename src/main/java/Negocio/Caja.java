/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author CAMILA ARIAS
 */
public class Caja {
    private double montocaja; 
    private double totalVendido;
    private double totalReembolsado; 
    private double ingresoNeto;

    public Caja(double montocaja) {
        this.montocaja = montocaja;
        this.totalVendido = 0.0;
        this.totalReembolsado = 0.0;
        this.ingresoNeto = 0.0;
    }

    public double getMontocaja() {
        return montocaja;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public double getTotalReembolsado() {
        return totalReembolsado;
    }

    public double getIngresoNeto() {
        return ingresoNeto;
    }

    public void setMontocaja(double ingreso,double reembolsado) {
        this.montocaja += ingreso;
        this.montocaja -= reembolsado;
        setTotalVendido(ingreso);
        setTotalReembolsado(reembolsado);
        actualizarIngresoNeto();
    }

    public void setTotalVendido(double ingreso) {
        this.totalVendido += ingreso;
    }

    public void setTotalReembolsado(double reembolsado) {
        this.totalReembolsado += reembolsado;
    }

    public void actualizarIngresoNeto() {
        this.ingresoNeto = this.totalVendido-this.totalReembolsado;
    }

    @Override
    public String toString() {
        return "Caja{" + "montocaja=" + montocaja + ", totalVendido=" + totalVendido + ", totalReembolsado=" + totalReembolsado + ", ingresoNeto=" + ingresoNeto + '}';
    }
    
}
