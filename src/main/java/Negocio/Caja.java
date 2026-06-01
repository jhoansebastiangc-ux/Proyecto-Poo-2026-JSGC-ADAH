package Negocio;

public class Caja {
    private double montocaja;
    private double totalVendido;
    private double totalReembolsado;
    private double totalVuelta;   // suma de valores a transferir al destino
    private double ingresoNeto;

    public Caja(double montocaja) {
        this.montocaja        = montocaja;
        this.totalVendido     = 0.0;
        this.totalReembolsado = 0.0;
        this.totalVuelta      = 0.0;
        this.ingresoNeto      = 0.0;
    }

    public void setMontocaja(double ingreso, double reembolsado, double vuelta) {
    this.montocaja        += ingreso;
    this.montocaja        -= reembolsado;
    this.totalVendido     += ingreso;
    this.totalReembolsado += reembolsado;

    if (reembolsado > 0) {
        this.totalVuelta -= vuelta;
    } else {
        this.totalVuelta += vuelta;
    }

    actualizarIngresoNeto();
    }

    private void actualizarIngresoNeto() {
        // El ingreso neto excluye reembolsos Y la porción de vuelta
        this.ingresoNeto = totalVendido - totalReembolsado - totalVuelta;
    }

    public double getMontocaja()        { return montocaja; }
    public double getTotalVendido()     { return totalVendido; }
    public double getTotalReembolsado() { return totalReembolsado; }
    public double getTotalVuelta()      { return totalVuelta; }
    public double getIngresoNeto()      { return ingresoNeto; }

    // mantener compatibilidad con llamadas anteriores (reembolsos)
    public void setMontocaja(double ingreso, double reembolsado) {
        setMontocaja(ingreso, reembolsado, 0.0);
    }

    @Override
    public String toString() {
        return "Caja{montocaja=" + montocaja
                + ", totalVendido=" + totalVendido
                + ", totalReembolsado=" + totalReembolsado
                + ", totalVuelta=" + totalVuelta
                + ", ingresoNeto=" + ingresoNeto + "}";
    }
}