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
    private boolean ocupado;

    public Puesto(int numAsiento) {
        this.numAsiento = numAsiento;
        this.ocupado = false;
    }
    

    public int getNumAsiento() {
        return numAsiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }
    public void liberar() {
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return "Puesto{" + "numAsiento=" + numAsiento +"- Estado: "+(ocupado?"Ocupado":"Libre");
    }
    
    
    
}
