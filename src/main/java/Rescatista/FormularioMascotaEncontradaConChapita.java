package Rescatista;

import Asociacion.Asociacion;
import NotificacionAppRescateDePatitas.NotificacionAppRescateDePatitasObserver;
import Usuario.Contacto;
import Usuario.Duenio;
import Usuario.TipoDocumento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormularioMascotaEncontradaConChapita extends FormularioMascotaEncontrada {
  private Duenio duenio;
  public Asociacion asociacion;
  public List<NotificacionAppRescateDePatitasObserver> notificacionesObserver = new ArrayList<NotificacionAppRescateDePatitasObserver>();
  public FormularioMascotaEncontradaConChapita(String nombre, String apellido, LocalDate fechaDeNacimiento, TipoDocumento tipoDocumento, String numeroDeDocumento, String direccion, Duenio duenio, Asociacion asociacion, Contacto contacto) {
    super(nombre, apellido, fechaDeNacimiento, tipoDocumento, numeroDeDocumento, direccion, contacto);
    this.duenio = duenio;
    this.asociacion = asociacion;
  }

  @Override
  public void darAvisoMascotaEncontrada(List<String> fotos, String descripcion, String lugar) {
    super.darAvisoMascotaEncontrada(fotos, descripcion, lugar);
    notificacionMascotaEncontrada(mascotaPerdida);
    asociacion.registrarFormulario(this);
  }

  @Override
  public void notificacionMascotaEncontrada(MascotaPerdida mascotaPerdida) {
    this.notificacionesObserver
        .forEach(notificacionObserver -> notificacionObserver.mascotaConChapitaEncontrada(duenio, mascotaPerdida.lugar));
  }

}
