package Negocio;
import java.util.Date;

public class Conductor extends Persona {
    
private Date fechaContratacion;
    
  public Conductor(String documento, String nombre, Date fechaContratacion) {
        super(documento, nombre);
        this.fechaContratacion = fechaContratacion;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
        return "Conductor{" + "fechaContratacion=" + fechaContratacion + '}';
    }

}
