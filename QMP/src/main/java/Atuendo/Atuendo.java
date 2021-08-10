package Atuendo;

import Prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Atuendo {

  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;
  private Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio){
    this.parteSuperior = requireNonNull(parteSuperior, "parte superior es obligatorio");
    this.parteInferior = requireNonNull(parteInferior, "parte inferior es obligatorio");
    this.calzado = requireNonNull(calzado, "calzado es obligatorio");
    this.accesorio = accesorio;
  }

}
