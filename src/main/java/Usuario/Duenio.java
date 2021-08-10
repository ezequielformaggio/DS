package Usuario;

import Asociacion.Asociacion;
import Mascota.Mascota;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Duenio extends Usuario {
  private String nombre;
  private String apellido;
  private LocalDate fechaDeNacimiento;
  private TipoDocumento tipoDeDocumento;
  private String numeroDeDocumento;
  private Asociacion asociacion;
  private List<Contacto> contactos=new ArrayList<Contacto>();
  private List<Mascota> mascotas=new ArrayList<Mascota>();
  private List<MedioDeComunicacionPreferido> medios;

  // es probable que este idDuenio necesite un preprocesado de algun otro objeto que genere IDs
  public Duenio(String nombre, String apellido, LocalDate fechaDeNacimiento, TipoDocumento tipoDeDocumento, String numeroDeDocumento, List<Contacto> contactos, String user, String password, List<MedioDeComunicacionPreferido> medios) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.tipoDeDocumento = tipoDeDocumento;
    this.numeroDeDocumento = numeroDeDocumento;
    this.validarContacto(contactos);
    this.transformarContraseña(user, password);
    this.medios = medios;
  }

  public void registrarPersona(Asociacion asociacion) {
    this.asociacion = asociacion;
  }

  public Asociacion getAsociacion() {
    return asociacion;
  }

  private void darEnAdopcion(){

  }

  private void validarContacto(List<Contacto> contactos) {
    if(contactos.isEmpty()) {
      throw new PersonaInvalidaException("le falta como minimo un contacto");
    }
    this.contactos=contactos;
  }

  protected void registrarMascota(Mascota mascota){
    mascotas.add(mascota);
  }

  public String getMail(){
    return this.contactos.get(0).getMail();
  }

  public String getTelefono() { return this.contactos.get(0).getTelefono(); }

  public List<MedioDeComunicacionPreferido> getMedioNotificacion() {
    return this.medios;
  }

}

