/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author CAMILA ARIAS
 */
public class Puesto {
    
    private int numAsiento;
    private String estado;

    public Puesto(int numAsiento) {
        this.numAsiento = numAsiento;
        this.estado = "Disponible";
    }
    

    public int getNumAsiento() {
        return numAsiento;
    }

    public String isOcupado() {
        return estado;
    }

    public void ocupar() {
        this.estado = "Ocupado";
    }
    public void liberar() {
        this.estado = "Disponible";
    }

    @Override
    public String toString() {
        return "Puesto\nnumAsiento=" + numAsiento +"\nEstado: "+ estado;
    }
    
    
    
}
