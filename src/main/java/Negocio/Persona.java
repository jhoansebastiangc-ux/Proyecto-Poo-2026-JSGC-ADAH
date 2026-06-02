package Negocio;

public class Persona {
    private String documento;
    private String nombre;
    
    public Persona(String documento, String nombre){
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "documento=" + documento + ", nombre=" + nombre + '}';
    }
    
}

