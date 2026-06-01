package Negocio;
import java.util.Date;

public class Cliente extends Persona {
    
    public enum TipoCliente { CASUAL, FRECUENTE }
private Date registro;
private TipoCliente tipo;
private int totalTiquetes;


  public Cliente(String documento, String nombre){
      super(documento, nombre);
      this.registro = new Date();
      this.tipo= TipoCliente.CASUAL;
      this.totalTiquetes = 0;
  }
   public void registrarCompra() {
        this.totalTiquetes++;
        if (this.totalTiquetes >= 7) {
            this.tipo = TipoCliente.FRECUENTE;
        }
    }
   
    public boolean esFrecuente() {
        return this.tipo == TipoCliente.FRECUENTE;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Cliente{documento=" + getDocumento()
                + ", nombre=" + getNombre()
                + ", tipo=" + tipo
                + ", tiquetes comprados=" + totalTiquetes + "}";
    }
  
}
