/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
/**
 *
 * @author CAMILA ARIAS
 */
public class Empresa {
    private ArrayList<Bus> myBuses;
    private ArrayList<Ruta> myRutas;
    private ArrayList<Salida> mySalidas;
    public Empresa() {
        //Aquí se inicializa los atributos de las clases
        this.myBuses=new ArrayList<>();
        this.myRutas=new ArrayList<>();
        this.mySalidas=new ArrayList<>();
        registrarDatosBase();      

    }
    
    //Metodo usado para cargar las placas dentro de un comboBox
    public String cargarPlacas() {
        StringBuilder cad=new StringBuilder();
        for(Bus b:myBuses){
            cad.append(b.getPlaca()).append(",");
        }
    return cad.toString();
}
   
    //Metodo usado para cargar las rutas dentro de un comboBox
    public String cargarRutas(){
        StringBuilder cad=new StringBuilder();
        for (Ruta r:myRutas){
            cad.append(r.getCodigo()).append(",");
        }
        return cad.toString();
    }
    
    //Métodos para la creación de los objetos por default    
    private void registrarDatosBase(){
        registrarBusesBase();
        registrarRutasBase();
        registrarSalidasBase();
    }
    
    //Creación de objetos tipo Bus por default
    private void registrarBusesBase(){
        myBuses.add(new Bus("KAA-101","Normal"));
        myBuses.add(new Bus("KBB-202","Ejecutivo"));
        myBuses.add(new Bus("KCC-303 ","Normal"));
        myBuses.add(new Bus("KDD-404","Ejecutivo"));
        myBuses.add(new Bus("KEE-505 ","Normal"));
        myBuses.getLast().setEstado("Mantenimiento");
        myBuses.add(new Bus("KFF-606 ","Normal"));
    }
    
    //Creación de objetos tipo Ruta por default
    private void registrarRutasBase(){
        myRutas.add(new Ruta(0,"Cucuta","Bucaramanga",6,80000));
        myRutas.add(new Ruta(1,"Cucuta","Bogota",15,160000));
        myRutas.add(new Ruta(2,"Cucuta","Medellin",16,180000));
        myRutas.add(new Ruta(3,"Cucuta","Cartagena",17,220000));
    }
    //Creación de objetos tipo Salida por default
    private void registrarSalidasBase(){
        mySalidas.add(new Salida(1,"R01","15/03/2026","06:00","KAA-101",6));
        mySalidas.add(new Salida(2,"R01","15/03/2026","14:00","KBB-202",6));        
        mySalidas.add(new Salida(3,"R02","16/03/2026","07:00","KCC-303",15));
        mySalidas.add(new Salida(4,"R02","16/03/2026","20:00","KDD-404",15));
        mySalidas.add(new Salida(5,"R03","17/03/2026","05:30 ","KFF-606",16));
        mySalidas.add(new Salida(6,"R03","17/03/2026","18:00","KAA-101",16));
        mySalidas.add(new Salida(7,"R04","18/03/2026","06:30","KCC-303",17));
        mySalidas.add(new Salida(8,"R04","18/03/2026","19:30","KBB-202",17));
    }
    
        //Metodo Usado para retornar los datos que tenga un bus
   public String retornarDatosbus(String placa){
       String cad="";
       for (Bus b:myBuses){
           if(b.getPlaca().equals(placa)){
               cad=(b.getTipoServ()+","+b.getEstado());
               break;
           }
       }
       return cad;
   }
   
    //Metodo Usado para retornar los datos que tenga una ruta
   public String retornarDatosRuta(String codigo){
       String cad="";
       for (Ruta r:myRutas){
           if(r.getCodigo().equals(codigo)){
               cad=(r.getOrigen()+","+r.getDestino()+","+r.getTarifab());
               break;
           }
       }
       return cad;
   }
   
    //REQUERIMIENTOS FUNCIONALES #1
    
    //Método para registar obejtos tipo Bus
    public String registrarBus(String placa, String tipoServ){
        String cad="";
        if (validarPlaca(placa)){
            return "Placa ya registrada";
        }
        Bus nuevo = new Bus(placa,tipoServ);
        myBuses.add(nuevo);
        cad="Se registro un nuevo bus: \n"+ myBuses.getLast().toString();
        return cad;
    }
      
    //Método para registrar objetos tipo Ruta
    public String registrarRuta(String origen,String destino,int tarifa, int viajeTime){
        String cad="";
        if(!validarRuta(origen,destino)){
        int contR=buscarCodUltimaRuta();
        Ruta ruta=new Ruta(contR,origen,destino,viajeTime,tarifa);
        myRutas.add(ruta);
        cad="Se registro la ruta: \n"+ myRutas.getLast().toString();
        }else{
            cad="Ruta ya Registrada";
        }
        return cad;

    }
    
    //Metodo para registrar objetos tipo salida
    public String registrarSalida(String fecha,String hora,String ruta,String bus){
        if(validarSalidas(fecha,hora,ruta,bus)){
            for (Bus b:myBuses){
                if (b.getPlaca().equals(bus)&& b.getEstado().equals("Mantenimiento")){
                    return "El bus seleccionado esta en mantenimiento"; 
                }
            }
        int viajeTime=0;
        /*for (Salida s:mySalidas){
          if(s.getBusAsignado().equals(bus)&& s.getFecha().equals(fecha))  {
              return "El bus ya tiene una ruta asignada para esa fecha";
          }
        }*/
        for(Ruta r:myRutas){
            if(r.getCodigo().equals(ruta)){
                viajeTime=r.getViajeTime();
            }
        }
        int cod=buscarCodUltimaSalida();
        mySalidas.add(new Salida(cod,ruta,fecha,hora,bus,viajeTime));
        return "Salida registrada\n"+ mySalidas.getLast().toString();
    }else{
            return "No se pudo registrar la salida";
        }
    }
    
    
    
    //Método para la validación de las Placas
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
    
    //Método para la validación de las Rutas
    public boolean validarRuta(String origen,String destino){
        boolean retu=false;
        for(Ruta r:myRutas){
            if(r.getOrigen().equals(origen) && r.getDestino().equals(destino)){
               retu=true;
            }
        } 
        return retu;
    }
    
    public boolean validarSalidas(String fecha,String hora,String ruta,String bus){
    try{
        SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date salidaNueva=null;
        Date llegadaNueva=null;
        for(Ruta r:myRutas){
                    if (r.getCodigo().equals(ruta)){
                     salidaNueva =formato.parse(fecha + " " + hora);
                     Calendar cal = Calendar.getInstance();
                     cal.setTime(salidaNueva);
                     cal.add(Calendar.HOUR_OF_DAY, r.getViajeTime());
                     llegadaNueva = cal.getTime();
                    }
                }
        for(Salida s:mySalidas){
            if(s.getBusAsignado().equals(bus)){
            Date inicioExistente =formato.parse(s.getFecha() + " " + s.getHora());
            Date finExistente =formato.parse(s.getFechaLlegada() + " " + s.getHoraLlegada());
            if(salidaNueva.before(finExistente)&& llegadaNueva.after(inicioExistente)){
                return false;
            }
            }
        }
        }catch(ParseException e){    
        }
     return true;
    }
    
    //Método para buscar el codigo de la última Ruta creada
    private int buscarCodUltimaRuta(){
        String cod=this.myRutas.getLast().getCodigo();
        if (cod.length()==0){
            return 1;
        }
        int numCod=Integer.parseInt(cod.substring(1));
        return numCod;
    }
    //Método para buscar el codigo de la última Salida creada
    private int buscarCodUltimaSalida(){
        String cod=this.mySalidas.getLast().getIdSalida();
        if(cod.length()==0){
            return 1;
        }
        int numCod=Integer.parseInt(cod.substring(1))+1;
        return numCod;
    }
    
    //Método para listar los Buses creados 
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
    
    //Método para listar las Rutas creadas
    public String listarRuta(){
        StringBuilder cad= new StringBuilder();
        for (Ruta r:myRutas){
            cad.append(r.toString()).append("\n");
        }
         if(cad.length()==0){
            cad.append("No hay rutas registradas");
         }
         return cad.toString();
    }
    
    //Metodo para listar las salidas creadas
    public String listarSalida(){
        StringBuilder cad= new StringBuilder();
        for (Salida s:mySalidas){
            cad.append(s.toString()).append("\n");
        }
         if(cad.length()==0){
            cad.append("No hay Salidas registradas");
         }
         return cad.toString();
    }
    
    //Metodo para actualizar el estado de un bus
    public String actualizarBus(String placa,String nuevoEstado){

        for (Bus b:myBuses){
            if (b.getPlaca().equals(placa)){
                b.setEstado(nuevoEstado);
                return "Estado actualizado correctamente";
            }
        }

    return "Bus no encontrado";
}
    
    //Metodo para actualizar el valor de una ruta
    public String actualizarRuta(String cod,int nuevatarifa){
        try{for (Ruta r:myRutas){
            if (r.getCodigo().equals(cod)){
                r.setTarifab(nuevatarifa);
                return "Ruta actualizada";
            }
        }
        return "No se encontro esa ruta";
        }catch(NumberFormatException e){
            return "Ingrese un valor válido";
        }
    }
    
}
