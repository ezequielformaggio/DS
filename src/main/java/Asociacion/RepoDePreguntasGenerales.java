package Asociacion;

import Caracteristica.Caracteristica;
import java.util.List;

public class RepoDePreguntasGenerales {

  List<Caracteristica> preguntas;

  public List<Caracteristica> getPreguntas() {
    return preguntas;
  }

  private void agregarPreguntaGeneral(Caracteristica pregunta) {
    preguntas.add(pregunta);
  }

  private void removerPreguntaGeneral(Caracteristica pregunta) { preguntas.remove(pregunta); }
}
