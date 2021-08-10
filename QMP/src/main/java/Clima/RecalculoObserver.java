package Clima;

import Guardarropa.Guardarropa;
import Persona.*;

import java.util.List;

public class RecalculoObserver implements ClimaObserver {

  List<Persona> personas;

  @Override
  public void actualizacionRecibida(InformeDelClima informeDelClima) {
    personas.stream()
        .filter(persona -> persona.getMediosDeComunicacion().contains(MediosDeComunicacion.RECALCULO))
        .forEach(persona -> persona.getGuardarropas().forEach(guardarropa -> guardarropa.sugerenciaDiaria()));
  }

}
