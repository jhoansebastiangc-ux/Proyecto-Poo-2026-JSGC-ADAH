/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author CAMILA ARIAS
 */

public class Bus {
    private String placa;
    private String tipoServ;
    private Puesto[] myPuestos;
    private String estado;

    public Bus(String placa, String tipoServ) {
        this.placa = placa;
        this.tipoServ = tipoServ;
        crearAsientos();
        //estado disponible
        this.estado = "Disponible";
    }
    private void crearAsientos(){
        int puestos;
        if(tipoServ.equals("Normal")){
            puestos=30;
        }else{
            puestos=40;
        }
        myPuestos=new Puesto[puestos];
        for (int i = 0; i < puestos; i++) {
        myPuestos[i] = new Puesto(i + 1);
    }
    }
    

    public String getPlaca() {
        return placa;
    }

    public String getTipoServ() {
        return tipoServ;
    }

    public String getEstado() {
        return estado;
    }

    public Puesto[] getMyPuestos() {
        return myPuestos;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoServ(String tipoServ) {
        this.tipoServ = tipoServ;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        //no exite bus sin puesto
        return "Placa: " + placa + "\nTipo De Servicio: " + tipoServ + "\nCapacidad: " + myPuestos.length + "\nEstado: " + estado+"\n" ;
    }
    
    
    
    
}
