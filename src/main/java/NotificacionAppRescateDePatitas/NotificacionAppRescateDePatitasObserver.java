package NotificacionAppRescateDePatitas;

import Asociacion.PublicacionDarEnAdopcion;
import Mascota.Mascota;
import Usuario.Contacto;
import Usuario.Duenio;

import java.util.List;

// es lo mismo que el enum, la interfz deberia llamarse medios de comunicacion, y el dueño deberia tener una lista de estos

public interface NotificacionAppRescateDePatitasObserver {
  void mascotaConChapitaEncontrada(Duenio duenio, String lugar);
  void peticionDeAdopcion(Contacto contacto, Mascota mascota);
  void recomendadorSemanal(Contacto contacto, List<PublicacionDarEnAdopcion> publicaciones);
  boolean verificarMedioDeComunicacion(Duenio duenio);
}
