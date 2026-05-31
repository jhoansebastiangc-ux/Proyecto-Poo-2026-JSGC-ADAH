package Negocio;

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
            puestos=40;
        }else{
            puestos=30;
        }
        myPuestos=new Puesto[puestos];
        for (int i = 0; i < puestos; i++) {
        myPuestos[i] = new Puesto(i + 1);
    }
    }
    
    public Puesto buscarPuesto(int puesto){
        for(Puesto p:this.myPuestos){
            if(p.getNumAsiento()==puesto){
                return p;
            }
        }
        return null;
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
