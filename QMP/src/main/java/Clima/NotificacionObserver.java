package Clima;

import Persona.*;

import java.util.List;

public class NotificacionObserver implements ClimaObserver {

  List<Persona> personas;

  @Override
  public void actualizacionRecibida(InformeDelClima informeDelClima) {
    this.personas.stream()
        .filter(persona -> persona.getMediosDeComunicacion().contains(MediosDeComunicacion.NOTIFICACION))
        .forEach(persona -> persona.lanzarNotificacion(informeDelClima));
  }

}
