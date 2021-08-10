package Persona;

import Atuendo.Atuendo;
import Clima.InformeDelClima;
import Guardarropa.Guardarropa;
import Sugerencia.*;

import java.util.ArrayList;
import java.util.List;

public class Persona {
  private List<Guardarropa> guardarropas;
  private List<Atuendo> atuendosSugeridos = new ArrayList<>();
  private List<Sugerencia> sugerencias = new ArrayList<>();
  private List<Sugerencia> sugerenciasEjecutadas = new ArrayList<>();
  private List<MediosDeComunicacion> mediosDeComunicacion;
  private String mail;

  public List<Atuendo> getAtuendosSugeridos() {
    return atuendosSugeridos;
  }

  public void compartirGuardarropa(Persona persona, Guardarropa guardarropa) {
    persona.guardarropas.add(guardarropa);
  }

  public void sugerirPrenda(Sugerencia sugerencia){
    sugerencias.add(sugerencia);
  }

  public void aceptarSugerencia(Sugerencia sugerencia) {
    sugerencia.ejecutarSugerencia(this);
    sugerenciasEjecutadas.add(sugerencia);
    sugerencias.remove(sugerencia);
  }

  public void rechazarSugerencia(Sugerencia sugerencia) {
    sugerencias.remove(sugerencia);
  }

  public void deshacerSugerenciaEjecutada(Sugerencia sugerencia) {
    sugerencia.deshacerSugerencia(this);
  }

  public List<Sugerencia> getSugerencias() {
    return sugerencias;
  }

  public String getMail() {
    return mail;
  }

  public List<Guardarropa> getGuardarropas() {
    return guardarropas;
  }

  public List<MediosDeComunicacion> getMediosDeComunicacion() {
    return mediosDeComunicacion;
  }

  public void lanzarNotificacion(InformeDelClima informeDelClima){
    if(informeDelClima.pronostico.contains("HAIL")){
      //NotificationService.notify("Se le notifica que habra una posible caida de granizo, evite salir en auto");
    }
    if(informeDelClima.pronostico.contains("STORM")){
      //NotificationService.notify("Se le notifica que habra posibles lluvias, use paraguas");
    }
  }
}
