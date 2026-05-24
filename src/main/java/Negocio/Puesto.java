package Negocio;

public class Puesto {
    
    private int numAsiento;
    private String estado;

    public Puesto(int numAsiento) {
        this.numAsiento = numAsiento;
        this.estado = "Disponible";
    }
    

    public int getNumAsiento() {
        return numAsiento;
    }

    public String getEstado() {
        return estado;
    }

    public void ocupar() {
        this.estado = "Ocupado";
    }
    public void liberar() {
        this.estado = "Disponible";
    }
    
    public void mantenimiento() {
        this.estado = "Mantemiento";
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Puesto\nnumAsiento=" + numAsiento +"\nEstado: "+ estado;
    }
    
    
    
}
