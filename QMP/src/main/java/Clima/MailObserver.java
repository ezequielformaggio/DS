package Clima;

import Persona.*;

import java.util.List;

public class MailObserver implements ClimaObserver{
  Mailsender mailsender = new MailObsender;
  List<Persona> personas;

  @Override
  public void actualizacionRecibida(InformeDelClima informeDelClima) {
    this.personas.stream()
        .filter(persona -> persona.getMediosDeComunicacion().contains(MediosDeComunicacion.MAIL))
        .forEach(persona -> mailsender.send(persona.getMail(), "Se le informa que se genero el alerta meteorologico informeDelClima.get..."));
  }
}
