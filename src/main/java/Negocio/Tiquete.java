package Negocio;

public class Tiquete {
    private String nombre;
    private String documento;
    private Puesto myPuesto;
    private double valorPagar;
    private String estado;

    public Tiquete(String nombre, String documento, Puesto myPuesto, double valorPagar) {
        this.nombre = nombre;
        this.documento = documento;
        this.myPuesto = myPuesto;
        this.valorPagar = valorPagar;
        this.estado = "Vigente";
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

    public String getEstado() {
        return estado;
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
        return "Tiquete{" + "nombre=" + nombre + ", documento=" + documento + ", myPuesto=" + myPuesto.getNumAsiento() + ", valorPagar=" + valorPagar + ", estado=" + estado + '}';
    }
    


    
}
