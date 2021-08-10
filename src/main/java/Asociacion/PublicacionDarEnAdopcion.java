package Asociacion;

import Mascota.Mascota;
import Mascota.ValorCaracteristica;
import NotificacionAppRescateDePatitas.NotificacionAppRescateDePatitasObserver;
import Usuario.Contacto;
import java.util.ArrayList;
import java.util.List;

public class PublicacionDarEnAdopcion {
  private Contacto contacto;
  private Mascota mascota;
  private List<ValorCaracteristica> preguntasRespuestas;
  public List<NotificacionAppRescateDePatitasObserver> notificacionesObserver = new ArrayList<NotificacionAppRescateDePatitasObserver>();

  public PublicacionDarEnAdopcion(Mascota mascota, List<ValorCaracteristica> preguntasRespuestas, Contacto contacto) {
    this.mascota =  mascota;
    this.preguntasRespuestas = preguntasRespuestas;
    this.contacto = contacto;
  }

  public void notificarDuenioAdopcion() {
    this.notificacionesObserver
        .forEach(notificacionObserver -> notificacionObserver.peticionDeAdopcion(contacto, mascota));
  }

  public Mascota getMascota() {
    return mascota;
  }

  public List<ValorCaracteristica> getPreguntasRespuestas() {
    return preguntasRespuestas;
  }
}
