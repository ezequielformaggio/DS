package Rescatista;
import Usuario.Contacto;
import Usuario.Duenio;
import Usuario.TipoDocumento;

import java.time.LocalDate;
import java.util.List;

public abstract class FormularioMascotaEncontrada {
  private String nombre;
  private String apellido;
  private LocalDate fechaDeNacimiento;
  private TipoDocumento tipoDocumento;
  private String numeroDeDocumento;
  protected String direccion;
  public MascotaPerdida mascotaPerdida;
  public Contacto contacto;

  public FormularioMascotaEncontrada(String nombre, String apellido, LocalDate fechaDeNacimiento, TipoDocumento tipoDocumento, String numeroDeDocumento, String direccion, Contacto contacto) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.numeroDeDocumento = numeroDeDocumento;
    this.direccion = direccion;
    this.contacto = contacto;
  }

  public void darAvisoMascotaEncontrada(List<String> fotos, String descripcion, String lugar){
    this.mascotaPerdida = new MascotaPerdida(fotos, descripcion, lugar);
    notificacionMascotaEncontrada(mascotaPerdida);
  }

  abstract void notificacionMascotaEncontrada(MascotaPerdida mascotaPerdida);

  public MascotaPerdida getMascotaPerdida() {
    return mascotaPerdida;
  }

}
