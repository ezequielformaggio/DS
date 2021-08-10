package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MacoWins {

  public static class Prenda {

    private Estado estado;
    private TipoPrenda tipo;
    private double precioBase;

    public double precio() {
      return estado.precio(precioBase);
    }

    // getters setters
    void setEstado(Estado estadoNuevo) {
      this.estado = estadoNuevo;
    }

    void setPrecioBase(double precioBaseNuevo) {
      this.precioBase = precioBaseNuevo;
    }

    TipoPrenda getTipo() {
      return tipo;
    }

    void setTipo(TipoPrenda tipoNuevo) {
      this.tipo = tipoNuevo;
    }
  }

  public enum TipoPrenda {
    ZAPATOS, PANTALON, CAMISA_DE_MANGA_CORTA
  }

  public static class Venta {

    private List<Prenda> prendas = new ArrayList<Prenda>() {{}};
    private LocalDate fecha;

    void agregarPrenda(Prenda prenda) {
      prendas.add(prenda);
    }

    int cantidadPrendas() {
      return prendas.size();
    }

    void setFecha(LocalDate fechaNueva) {
      this.fecha = fechaNueva;
    }

    public boolean esDeFecha(LocalDate fechaComparar) {
      return fechaComparar.compareTo(fecha) == 0;
    }

    public double importeTotal() {
      return importeNeto();
    }

    public double importeNeto() {
      return prendas.stream().flatMapToDouble(prenda -> DoubleStream.of(prenda.precio())).sum();
    }
  }

  static class VentaConTarjeta extends Venta {
    int cantidadCuotas;
    double coeficienteTarjeta;

    void setCantidadCuotas(int cantCuotasNuevas) {
      this.cantidadCuotas = cantCuotasNuevas;
    }

    void setCoeficienteTarjeta(double coeficienteTarjetaNuevo) {
      this.coeficienteTarjeta = coeficienteTarjetaNuevo;
    }

    @Override
    public double importeTotal() {
      return super.importeNeto() + recargoTarjeta();
    }

    double recargoTarjeta() {
      return coeficienteTarjeta * cantidadCuotas + importeNeto() * 0.01;
    }
  }

  public static class Local {

    private List<Venta> ventas = new ArrayList<Venta>() {{}};

    void agregarVenta(Venta venta) {
      ventas.add(venta);
    }

    Stream<Venta> ventasDelDia(LocalDate fechaDeterminada) {
      return ventas.stream().filter(venta -> venta.esDeFecha
          (fechaDeterminada));
    }

    double gananciaDia(LocalDate fechaDeterminada) {
      return ventasDelDia(fechaDeterminada)
          .flatMapToDouble(venta -> DoubleStream.of(venta.importeTotal()))
          .sum();
    }
  }
}
