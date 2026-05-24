package Negocio;

public class Ruta {
    private String codigo;
    private String origen;
    private String destino;
    private int viajeTime;
    private int Tarifab;

    public Ruta(int cont, String destino,int viajeTime, int Tarifab) {
        this.codigo = generarCodigoRuta(cont);
        this.origen = "Cucúta";
        this.destino = destino;
        this.viajeTime=viajeTime;
        this.Tarifab = Tarifab;
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
        return Tarifab;
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

    public void setTarifab(int Tarifab) {
        this.Tarifab = Tarifab;
    }

    public void setViajeTime(int viajeTime) {
        this.viajeTime = viajeTime;
    }

    @Override
    public String toString() {
        return "Codigo=" + codigo + "\nOrigen=" + origen + "\nDestino=" + destino + "\nTiempo de viaje= "+viajeTime+"\nTarifa Base=" + Tarifab+"\n";
    }
    
  
}
