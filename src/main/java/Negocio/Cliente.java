package Negocio;
import java.util.Date;

public class Cliente extends Persona {

    public enum TipoCliente { CASUAL, FRECUENTE }

    private Date        registro;
    private TipoCliente tipo;
    private int         totalTiquetes;
    private String      telefono;
    private String      correo;

    public Cliente(String documento, String nombre, String telefono, String correo) {
        super(documento, nombre);
        this.registro      = new Date();
        this.tipo          = TipoCliente.CASUAL;
        this.totalTiquetes = 0;
        this.telefono      = telefono;
        this.correo        = correo;
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

    public Date        getRegistro()          { return registro; }
    public TipoCliente getTipoCliente()       { return tipo; }
    public int         getTotalTiquetes()     { return totalTiquetes; }
    public String      getTelefono()          { return telefono; }
    public String      getCorreo()            { return correo; }

    public void setRegistro(Date registro)    { this.registro  = registro; }
    public void setTelefono(String telefono)  { this.telefono  = telefono; }
    public void setCorreo(String correo)      { this.correo    = correo; }

    @Override
    public String toString() {
        return "Cliente{documento=" + getDocumento()
                + ", nombre="    + getNombre()
                + ", telefono="  + telefono
                + ", correo="    + correo
                + ", tipo="      + tipo
                + ", tiquetes="  + totalTiquetes + "}";
    }
}