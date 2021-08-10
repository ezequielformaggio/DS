package NotificacionAppRescateDePatitas;
import Asociacion.FormularioParaAdoptar;
import Asociacion.PublicacionDarEnAdopcion;
import Mascota.Mascota;
import Usuario.Contacto;
import Usuario.Duenio;
import Usuario.MedioDeComunicacionPreferido;

import java.util.List;

public class SMSObserver implements NotificacionAppRescateDePatitasObserver {
  SMSApi smsApi = new SMSApi();

  @Override
  public void mascotaConChapitaEncontrada(Duenio duenio, String lugar) {
    if(verificarMedioDeComunicacion(duenio)){
      smsApi.notificarMascotaEncontrada(duenio.getTelefono(), lugar);
    }
  }

  @Override
  public void peticionDeAdopcion(Contacto contacto, Mascota mascota) {
      smsApi.notificarPedidoDeAdopcion(contacto, mascota);
  }

  @Override
  public void recomendadorSemanal(Contacto contacto, List<PublicacionDarEnAdopcion> publicaciones){
    smsApi.enviarRemcomendacion(contacto.getTelefono(), publicaciones);
  }

  @Override
  public boolean verificarMedioDeComunicacion(Duenio duenio){
    return duenio.getMedioNotificacion().contains(MedioDeComunicacionPreferido.SMS);
  }
}
