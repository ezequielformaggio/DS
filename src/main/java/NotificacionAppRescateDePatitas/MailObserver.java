package NotificacionAppRescateDePatitas;
import Asociacion.FormularioParaAdoptar;
import Asociacion.PublicacionDarEnAdopcion;
import Mascota.Mascota;
import Usuario.Contacto;
import Usuario.Duenio;
import Usuario.MedioDeComunicacionPreferido;

import java.util.List;

public class MailObserver implements NotificacionAppRescateDePatitasObserver {
  JavaMailApi javaMailApi = new JavaMailApi();

  @Override
  public void mascotaConChapitaEncontrada(Duenio duenio, String lugar) {
    if(duenio.getMedioNotificacion().contains(MedioDeComunicacionPreferido.MAIL)){
      javaMailApi.notificarMascotaEncontrada(duenio.getMail(), lugar);
    }
  }

  @Override
  public void peticionDeAdopcion(Contacto contacto, Mascota mascota) {
    javaMailApi.notificarPedidoDeAdopcion(contacto, mascota);

  }

  @Override
  public void recomendadorSemanal(Contacto contacto, List<PublicacionDarEnAdopcion> publicaciones) {
    javaMailApi.enviarRemcomendacion(contacto.getMail(), publicaciones);
  }

  @Override
  public boolean verificarMedioDeComunicacion(Duenio duenio){
    return duenio.getMedioNotificacion().contains(MedioDeComunicacionPreferido.MAIL);
  }

  public void enviarRemcomendacion(String destinatario, List<FormularioParaAdoptar> publicaciones){
    //TODO
  }
}
