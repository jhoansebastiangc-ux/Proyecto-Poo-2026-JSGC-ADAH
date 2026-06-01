package Negocio;

public class Tiquete {
    private String codTq;
    private String nombre;
    private String documento;
    private Puesto myPuesto;
    private double valorPagar;
    private double  valorVuelta;
    private String estado;
    private boolean idaYVuelta;

    public Tiquete(int cod,String nombre, String documento, Puesto myPuesto, double valorPagar, boolean  idaYVuelta) {
        this.codTq=generarCodigoTiquete(cod);
        this.nombre = nombre;
        this.documento = documento;
        this.myPuesto = myPuesto;
        this.valorPagar = valorPagar;
        this.estado = "Vigente";
        this.idaYVuelta = idaYVuelta;
        this.valorVuelta = calcularValorVuelta(valorPagar, idaYVuelta);
    }
        private String generarCodigoTiquete(int codTq){
        String cod=String.format("TQ-%04d",codTq+1);
        return cod;
    }
         private double calcularValorVuelta(double valor, boolean idaYVuelta) {
        return idaYVuelta ? valor / 2.0 : 0.0;
    }
    
    public double getValorVuelta() { 
        return valorVuelta; 
    }

    public String getCodTq() {
        return codTq;
    }
        
    
    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public Puesto getMyPuesto() {
        return myPuesto;
    }

    public double getValorPagar() {
        return valorPagar;
    }
     
    public double getValorNeto() {
        return valorPagar - valorVuelta;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isIdaYVuelta() {
        return idaYVuelta;
    }
    
    public void setMyPuesto(Puesto myPuesto) {
        this.myPuesto = myPuesto;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    
    @Override
    public String toString() {
                String tipo = idaYVuelta ? "Ida y Vuelta" : "Solo Ida";
        String info = "Tiquete=" + codTq
                + "\nPasajero=" + documento + "----" + nombre
                + "\nPuesto=" + myPuesto.getNumAsiento()
                + "\nValor pagado: $" + valorPagar
                + "\nTipo de viaje: " + tipo
                + "\nEstado=" + estado;
        if (idaYVuelta) {
            info += "\nValor vuelta (transferir destino): $" + valorVuelta
                  + "\nIngreso neto empresa: $" + getValorNeto();
        }
        return info;
        
    }
    


    
}
