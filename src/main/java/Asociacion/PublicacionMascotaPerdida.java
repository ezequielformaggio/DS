package Asociacion;

import Rescatista.MascotaPerdida;
import Usuario.Contacto;

public class PublicacionMascotaPerdida {
  private Asociacion asociacion;
  private MascotaPerdida mascotaPerdida;
  private Contacto contactoRescatista;

  public PublicacionMascotaPerdida(Asociacion asociacion, MascotaPerdida mascotaPerdida, Contacto contactoRescatista) {
    this.asociacion =  asociacion;
    this.mascotaPerdida = mascotaPerdida;
    this.contactoRescatista = contactoRescatista;
  }
}
