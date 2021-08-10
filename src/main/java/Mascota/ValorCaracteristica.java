package Mascota;


import Caracteristica.Caracteristica;

public class ValorCaracteristica<T>{
  Caracteristica<T> caracteristica;
  T valor;

  public ValorCaracteristica(Caracteristica<T> caracteristica, T valor) {
    this.caracteristica = caracteristica;
    this.valor = valor;
  }

  public T getValor() {
    return valor;
  }
}



