package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrendaTest {


  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }

  @Test
  public void calculoDelImporteDeUnaVenta() {
    assertEquals(venta1().importeTotal(), 6450,0);
  }

  @Test
  public void laVenta2Vendio2Prendas() {
    assertEquals(venta2().cantidadPrendas(), 2,0);
  }

  @Test
  public void calculoDeLasGananciasDeUnDia() {
    assertEquals(local1().gananciaDia(LocalDate.now()),12201.2,0);
  }

  @Test
  public void venta3esDeFecha() {
    assertEquals(venta3().esDeFecha(LocalDate.now()),true);
  }

  @Test
  public void unaVentaVendioXCantidadDePrendas() {
    assertEquals(venta4().cantidadPrendas(),1,0);
  }

  private MacoWins.Prenda pantalonEnPromocion(double precioBase, double descuento) {
    MacoWins.Prenda pantalonEnPromocion = new MacoWins.Prenda();
    pantalonEnPromocion.setPrecioBase(precioBase);
    pantalonEnPromocion.setTipo(MacoWins.TipoPrenda.PANTALON);
    Promocion esPromocion = new Promocion();
    esPromocion.setDescuento(descuento);
    pantalonEnPromocion.setEstado(esPromocion);
    return pantalonEnPromocion;
  }

  private MacoWins.Prenda camisaNueva(double precioBase) {
    MacoWins.Prenda camisaNueva = new MacoWins.Prenda();
    camisaNueva.setPrecioBase(precioBase);
    camisaNueva.setTipo(MacoWins.TipoPrenda.CAMISA);
    Nueva esNueva = new Nueva();
    camisaNueva.setEstado(esNueva);
    return camisaNueva;
  }

  private MacoWins.Prenda sacoEnLiquidacion(double precioBase) {
    MacoWins.Prenda sacoEnLiquidacion = new MacoWins.Prenda();
    sacoEnLiquidacion.setPrecioBase(precioBase);
    sacoEnLiquidacion.setTipo(MacoWins.TipoPrenda.SACO);
    Liquidacion esLiquidacion = new Liquidacion();
    sacoEnLiquidacion.setEstado(esLiquidacion);
    return sacoEnLiquidacion;
  }

  private MacoWins.Venta venta1() {
    MacoWins.Venta venta1 = new MacoWins.Venta();
    venta1.agregarPrenda(sacoEnLiquidacion(4500));
    venta1.agregarPrenda(camisaNueva(1500));
    venta1.agregarPrenda(pantalonEnPromocion(3500, 800));
    venta1.setFecha(LocalDate.now());
    return venta1;
  }

  private MacoWins.Venta venta2() {
    MacoWins.VentaConTarjeta venta2 = new MacoWins.VentaConTarjeta();
    venta2.agregarPrenda(sacoEnLiquidacion(3400));
    venta2.setCantidadCuotas(5);
    venta2.setCoeficienteTarjeta(15);
    venta2.agregarPrenda(pantalonEnPromocion(4000, 80));
    venta2.setFecha(LocalDate.now());
    return venta2;
  }

  private MacoWins.Venta venta3() {
    MacoWins.VentaConTarjeta venta3 = new MacoWins.VentaConTarjeta();
    venta3.agregarPrenda(camisaNueva(2000));
    venta3.setCantidadCuotas(12);
    venta3.setCoeficienteTarjeta(5);
    venta3.setFecha(LocalDate.now());
    return venta3;
  }

  private MacoWins.Venta venta4() {
    MacoWins.Venta venta4 = new MacoWins.Venta();
    venta4.agregarPrenda(pantalonEnPromocion(3500, 800));
    venta4.setFecha(LocalDate.now());
    return venta4;
  }

  private MacoWins.Local local1() {
    MacoWins.Local local1 = new MacoWins.Local();
    local1.agregarVenta(venta1());
    local1.agregarVenta(venta2());
    //local1.agregarVenta(venta3());
    return local1;
  }



}


