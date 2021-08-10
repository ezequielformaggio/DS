package Uniforme;

import Prenda.Prenda;

public interface CreadorUniformes {
  abstract Prenda fabricarParteSuperior();
  abstract Prenda fabricarParteInferior();
  abstract Prenda fabricarCalzado();

  public default Uniforme fabricarUniforme(){
    return new Uniforme(this.fabricarParteSuperior(), this.fabricarParteInferior(), this.fabricarCalzado());
  }

}
