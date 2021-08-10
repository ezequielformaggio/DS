package Asociacion;

import Mascota.*;

import Usuario.Duenio;

import java.util.ArrayList;
import java.util.List;

public class FormularioDarEnAdopcion {
  Mascota mascota;
  Duenio duenio;
  List<ValorCaracteristica> preguntasRespuestas = new ArrayList<ValorCaracteristica>();

  public FormularioDarEnAdopcion(Mascota mascota, Duenio duenio, List<ValorCaracteristica> preguntasRespuestas) {
    this.mascota = mascota;
    this.duenio = duenio;
    this.preguntasRespuestas = preguntasRespuestas;
  }

}
