package Negocio;
import java.util.Date;
import java.text.SimpleDateFormat;

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
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    return String.format(
            "%-15s %-25s %-15s",
            getDocumento(),
            getNombre(),
            formato.format(fechaContratacion));
}

}
