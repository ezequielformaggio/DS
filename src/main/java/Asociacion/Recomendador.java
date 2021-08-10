package Asociacion;

import NotificacionAppRescateDePatitas.NotificacionAppRescateDePatitasObserver;
import Usuario.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recomendador {

  CentralAsociaciones centralAsociaciones;
  public List<NotificacionAppRescateDePatitasObserver> notificacionesObserver = new ArrayList<NotificacionAppRescateDePatitasObserver>();

  public Recomendador(CentralAsociaciones centralAsociaciones) {
    this.centralAsociaciones = centralAsociaciones;
  }

  public void generarRecomendacionSemanal(){

    for (FormularioParaAdoptar adoptante: centralAsociaciones.getPublicacionParaAdoptar()) {

     Contacto contactoAdoptante = adoptante.getContacto();

     this.notificacionesObserver
      .forEach(notificacionObserver -> notificacionObserver
          .recomendadorSemanal(contactoAdoptante,
              centralAsociaciones.getPublicacionesDarAdopcion().stream()
                  .filter(publicacion -> adoptante.getPreferencias().contains(publicacion.getMascota().getAnimal())).collect(Collectors.toList())));
    }
  }
}
