package Asociacion;

import Caracteristica.Caracteristica;
import Rescatista.*;
import Rescatista.FormularioMascotaEncontradaConChapita;
import Rescatista.MascotaPerdida;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Asociacion {
  private List<FormularioMascotaEncontradaConChapita> formularioMascotaEncontradas = new ArrayList<>();
  private List<Caracteristica> preguntasAdopcion = new ArrayList<>();
  private List<FormularioDarEnAdopcion> publicaciones;
  public String direccion;


  public List<Caracteristica> getPreguntasAdopcion() {
    return preguntasAdopcion;
  }

  public void setPreguntasAdopcion(List<Caracteristica> preguntasAdopcion) {
    this.preguntasAdopcion = preguntasAdopcion;
  }

  public void agregarPreguntaAdopcion(Caracteristica pregunta) {
    preguntasAdopcion.add(pregunta);
  }

  public void removerPreguntaAdopcion(Caracteristica pregunta) {
    preguntasAdopcion.remove(pregunta);
  }

  public Asociacion(String direccion) {
    this.direccion = direccion;
  }

  public List<MascotaPerdida> mascotasEncontradasEnLosUltimosDias(int dias) {
    return formularioMascotaEncontradas
        .stream()
        .map(FormularioMascotaEncontrada::getMascotaPerdida)
        .filter(mascotaPerdida -> mascotaPerdida.encontradaEnTalDia(dias))
        .collect(Collectors.toList());
  }

  public List<FormularioMascotaEncontradaConChapita> getFormularioMascotaEncontradasConChapita(){ return formularioMascotaEncontradas;}

  public void registrarFormulario(FormularioMascotaEncontradaConChapita formulario) {
    formularioMascotaEncontradas.add(formulario);
  }
  public String getDireccion() {
    return direccion;
  }

  // TODO revisar como se construye
  public void generarPublicacion(FormularioDarEnAdopcion publicacion) {
    publicaciones.add(publicacion);
  }
}
