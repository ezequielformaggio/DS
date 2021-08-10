package Rescatista;

import Asociacion.*;
import Usuario.*;
import java.time.LocalDate;

public class FormularioMascotaEncontradaSinChapita extends FormularioMascotaEncontrada{
  private CentralAsociaciones centralAsociaciones;

  public FormularioMascotaEncontradaSinChapita(String nombre, String apellido, LocalDate fechaDeNacimiento, TipoDocumento tipoDocumento, String numeroDeDocumento, String direccion, CentralAsociaciones centralAsociaciones, Contacto contacto) {
    super(nombre, apellido, fechaDeNacimiento, tipoDocumento, numeroDeDocumento, direccion, contacto);
    this.centralAsociaciones = centralAsociaciones;
  }

  @Override
  public void notificacionMascotaEncontrada(MascotaPerdida mascotaPerdida) {
    centralAsociaciones.generarPublicacion(mascotaPerdida, contacto);
  }
}
