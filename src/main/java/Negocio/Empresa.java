/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
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
    
    public String cargarSalidas(){
        StringBuilder cad=new StringBuilder();
        for(Salida s:mySalidas){
            cad.append(s.getIdSalida()).append(",");
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
        myRutas.add(new Ruta(0,"Bucaramanga",6,80000));
        myRutas.add(new Ruta(1,"Bogota",15,160000));
        myRutas.add(new Ruta(2,"Medellin",16,180000));
        myRutas.add(new Ruta(3,"Cartagena",17,220000));
    }
    //Creación de objetos tipo Salida por default
    private void registrarSalidasBase(){
        mySalidas.add(new Salida(1,myRutas.getFirst(),LocalDateTime.of(2026,3,15,6,0),calcularLlegada(LocalDateTime.of(2026,3,15,6,0),myRutas.getFirst()),myBuses.getFirst()));
        mySalidas.add(new Salida(2,myRutas.getFirst(),LocalDateTime.of(2026,3,15,14,0),calcularLlegada(LocalDateTime.of(2026,3,15,14,0),myRutas.getFirst()),myBuses.get(1)));        
        mySalidas.add(new Salida(3,myRutas.get(1),LocalDateTime.of(2026,3,16,7,0),calcularLlegada(LocalDateTime.of(2026,3,16,7,0),myRutas.get(1)),myBuses.get(2)));
        mySalidas.add(new Salida(4,myRutas.get(1),LocalDateTime.of(2026,3,16,20,0),calcularLlegada(LocalDateTime.of(2026,3,16,20,0),myRutas.get(1)),myBuses.get(3)));
        mySalidas.add(new Salida(5,myRutas.get(2),LocalDateTime.of(2026,3,17,5,30),calcularLlegada(LocalDateTime.of(2026,3,17,5,30),myRutas.get(2)),myBuses.getLast()));
        mySalidas.add(new Salida(6,myRutas.get(2),LocalDateTime.of(2026,3,17,18,0),calcularLlegada(LocalDateTime.of(2026,3,17,18,0),myRutas.get(2)),myBuses.getFirst()));
        mySalidas.add(new Salida(7,myRutas.get(3),LocalDateTime.of(2026,3,18,6,30),calcularLlegada(LocalDateTime.of(2026,3,18,6,30),myRutas.get(3)),myBuses.get(2)));
        mySalidas.add(new Salida(8,myRutas.get(3),LocalDateTime.of(2026,3,19,19,30),calcularLlegada(LocalDateTime.of(2026,3,19,19,30),myRutas.get(3)),myBuses.get(1)));
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
   
   private Bus recorrerBus(String placa){
       for(Bus b:myBuses){
           if (b.getPlaca().equals(placa)){
               return b;
           }
       }
       return null;
   }
   
      private Ruta recorrerRuta(String ruta){
       for(Ruta r:myRutas){
           if (r.getCodigo().equals(ruta)){
               return r;
           }
       }
       return null;
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
    public String registrarRuta(String destino,int tarifa, int viajeTime){
        String cad="";
        if(!validarRuta(destino)){
        int contR=buscarCodUltimaRuta();
        Ruta ruta=new Ruta(contR,destino,viajeTime,tarifa);
        myRutas.add(ruta);
        cad="Se registro la ruta: \n"+ myRutas.getLast().toString();
        }else{
            cad="Ruta ya Registrada";
        }
        return cad;

    }
    
    //Metodo para registrar objetos tipo salida
    public String registrarSalida(String fecha,String hora,String codRuta,String placaBus){
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      String salidaTexto = fecha + " " + hora;
      LocalDateTime salida = LocalDateTime.parse(salidaTexto, formato);
      
      Bus bus=recorrerBus(placaBus);
      Ruta ruta=recorrerRuta(codRuta);
      LocalDateTime llegada=calcularLlegada(salida,ruta);
              
        if(!validarSalidas(salida,ruta,bus)){
            for (Bus b:myBuses){
                if (b.getPlaca().equals(placaBus)&& b.getEstado().equals("Mantenimiento")){
                    return "El bus seleccionado esta en mantenimiento"; 
                }
            }
        int cod=buscarCodUltimaSalida();
        mySalidas.add(new Salida(cod,ruta,salida,llegada,bus));
        return "Salida registrada\n"+ mySalidas.getLast().toString();
    }else{
            return "No se pudo registrar la salida\nEl bus seleccionado tiene otra salida para ese horario";
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
    public boolean validarRuta(String destino){
        boolean retu=false;
        for(Ruta r:myRutas){
            if(r.getDestino().equals(destino)){
               retu=true;
            }
        } 
        return retu;
    }
    
    
    
private boolean validarSalidas(LocalDateTime salida,Ruta ruta,Bus bus){

    LocalDateTime llegadaNueva =
            calcularLlegada(salida, ruta);

    for(Salida s : mySalidas){

        if(s.getBusAsignado().equals(bus)){

            LocalDateTime salidaExistente =
                    s.getFechaHoraSalida();

            LocalDateTime llegadaExistente =
                    s.getFechaHoraLlegada();

            // Verifica cruce de horarios
            if(salida.isBefore(llegadaExistente)
                    && llegadaNueva.isAfter(salidaExistente)){

                return true;
            }
        }
    }

    return false;
}

    private LocalDateTime calcularLlegada(LocalDateTime salida,Ruta ruta){
    LocalDateTime llegada = salida.plusHours(ruta.getViajeTime());
    return llegada;

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
