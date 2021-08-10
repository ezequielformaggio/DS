package ar.edu.utn.frba.dds.macowins;

// implemento interface
public interface Estado {
  public double precio(double precioBase);
}

class Nueva implements Estado {
  public double precio(double precioBase) {
    return precioBase;
  }
}

class Promocion implements Estado {

  double descuento;

  void setDescuento(double descuentoNuevo) {
    this.descuento = descuentoNuevo;
  }

  public double precio(double precioBase) {
    return precioBase - descuento;
  }
}

class Liquidacion implements Estado {
  public double precio(double precioBase) {
    return precioBase * 0.5;
  }
}
