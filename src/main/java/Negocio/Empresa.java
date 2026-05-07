/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author CAMILA ARIAS
 */
public class Empresa {
    private ArrayList<Bus> myBuses;

    public Empresa() {
        //aqui es donde se inicializa los atributos de las clases
        
        this.myBuses=new ArrayList<>();
        
        //deben crear metodos privados para la creación de objetos por default.... 
        
    }
    
    
    
    
    public String registrarBus(String placa, String tipoServ){
        String cad="";
        if (validarPlaca(placa)){
            return "Placa ya registrada";
        }
        Bus nuevo = new Bus(placa,tipoServ);
        myBuses.add(nuevo);
        cad="Bus registrado";
        
      
        
        return cad;
    }
    public String actualizarBus(String placa, String tipoServ, String estado){
        String cad="";
        if(!this.myBuses.isEmpty()){
        if(!placa.equals("")){
        for (Bus b:myBuses){
           if(b.getPlaca().equals(placa) && b.getTipoServ().equals(tipoServ)){
           b.setEstado(estado);
           cad="Bus Actualizado";
           break;
        }else{
           cad="No se encontro un bus con esas caracteristicas";  
           }           
        }
        }else{
            cad="Tiene que digitar una placa para actualizar";
        }
        }else{
            cad="No hay buses registrados";
        
        }
        return cad;
    }
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
    public void registrarDatosBase(){
        registrarBusesBase();
    }
    
    //private 
    public void registrarBusesBase(){
        myBuses.add(new Bus("KAA-101","Normal"));
        myBuses.add(new Bus("KBB-202","Ejecutivo"));
        myBuses.add(new Bus("KCC-303 ","Normal"));
        myBuses.add(new Bus("KDD-404","Ejecutivo"));
        myBuses.add(new Bus("KEE-505 ","Normal"));
        myBuses.getLast().setEstado("Mantenimiento");
        myBuses.add(new Bus("KFF-606 ","Normal"));
    }
}
