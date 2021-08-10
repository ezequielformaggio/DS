package Prenda;

import static java.util.Objects.requireNonNull;

public class BorradorDePrenda {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;

  public void setTipoPrenda(TipoPrenda tipoPrenda){
    this.tipoPrenda = requireNonNull(tipoPrenda, "tipo de prenda es obligatorio");;
  }

  public void setMaterial(Material material){
    this.material = requireNonNull(material, "material es obligatorio");;
  }

  public void setColorPrincipal(Color color){
    this.colorPrincipal = requireNonNull(colorPrincipal, "color principal es obligatorio");;
  }

  public void setColorSecundario(Color color){
    this.colorSecundario = color;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public Prenda crearPrenda(){
    return new Prenda(tipoPrenda,material,colorPrincipal,colorSecundario,trama);
  }
}
