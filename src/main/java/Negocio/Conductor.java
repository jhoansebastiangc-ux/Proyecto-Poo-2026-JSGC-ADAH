package Negocio;
import java.util.Date;

public class Conductor extends Persona {
    
private Date yearContrat;
    
  public Conductor(String documento, String nombre, Date yearContrat) {
        super(documento, nombre);
        this.yearContrat = yearContrat;
    }

    public Date getYearContrat() {
        return yearContrat;
    }

    public void setYearContrat(Date yearContrat) {
        this.yearContrat = yearContrat;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nAño contratación: " + yearContrat;
    }
}
