package Negocio;

public class Ruta {
    private String codigo;
    private String origen;
    private String destino;
    private int viajeTime;
    private int tarifab;

    public Ruta(int cont, String destino,int viajeTime, int tarifab) {
        this.codigo = generarCodigoRuta(cont);
        this.origen = "Cucúta";
        this.destino = destino;
        this.viajeTime=viajeTime;
        this.tarifab = tarifab;
    }
    private String generarCodigoRuta(int cont){
        cont++;
        String cod=String.format("R%02d",cont);
        return cod;
    }
    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getTarifab() {
        return tarifab;
    }

    public int getViajeTime() {
        return viajeTime;
    }
    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setTarifab(int tarifab) {
        this.tarifab = tarifab;
    }

    public void setViajeTime(int viajeTime) {
        this.viajeTime = viajeTime;
    }

    @Override
    public String toString() {
    return String.format(
            "%-8s %-12s %-15s %-12d $%-11d",
            codigo,
            origen,
            destino,
            viajeTime,
            tarifab);    }
    
  
}
