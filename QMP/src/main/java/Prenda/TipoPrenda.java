package Prenda;

public class TipoPrenda {
  private Categoria categoria;
  private Double temperaturaMaxima;

  public TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Double getTemperaturaMaxima() {
    return temperaturaMaxima;
  }
}