package Sugerencia;

import Guardarropa.Guardarropa;
import Persona.Persona;
import Prenda.Prenda;

public class SugerenciaAgregarPrenda implements Sugerencia{
  private Prenda prenda;
  private Guardarropa guardarropa;

  public SugerenciaAgregarPrenda(Prenda prenda, Guardarropa guardarropa){
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  @Override
  public void ejecutarSugerencia(Persona persona){
    guardarropa.agregarPrenda(prenda);
  }

  @Override
  public void deshacerSugerencia(Persona persona) {
    guardarropa.quitarPrenda(prenda);
  }
}
