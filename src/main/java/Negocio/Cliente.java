package Negocio;
import java.util.Date;

public class Cliente extends Persona {
    
private Date registro;

  public Cliente(String documento, String nombre, Date registro){
      super(documento, nombre);
      this.registro = registro;
  }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Cliente{" + "registro=" + registro + '}';
    }
  }
