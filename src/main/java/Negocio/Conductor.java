package Negocio;
import java.util.Date;

public class Conductor extends Persona {
    
private Date fechaContratacion;
    
  public Conductor(String documento, String nombre, Date fechaContratacion) {
        super(documento, nombre);
        this.fechaContratacion = fechaContratacion;
    }

    public Date getYearContrat() {
        return fechaContratacion;
    }

    public void setYearContrat(Date yearContrat) {
        this.fechaContratacion = yearContrat;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nAño contratación: " + fechaContratacion;
    }
}
