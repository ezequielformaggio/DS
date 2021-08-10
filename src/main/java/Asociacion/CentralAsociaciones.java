package Asociacion;

import Mascota.Mascota;
import Mascota.ValorCaracteristica;
import Rescatista.MascotaPerdida;
import Usuario.Contacto;
import Mascota.Animal;
import java.util.ArrayList;
import java.util.List;

public class CentralAsociaciones {
  List<Asociacion> asociaciones = new ArrayList<Asociacion>();
  List<PublicacionMascotaPerdida> publicacionesPendientes = new ArrayList<PublicacionMascotaPerdida>();
  List<PublicacionMascotaPerdida> publicacionesAprobadas = new ArrayList<PublicacionMascotaPerdida>();
  List<PublicacionDarEnAdopcion> publicacionesDarAdopcion = new ArrayList<PublicacionDarEnAdopcion>();
  List<FormularioParaAdoptar> publicacionParaAdoptar = new ArrayList<FormularioParaAdoptar>();
  RepoDePreguntasGenerales repositorioPreguntasComunes;

  public List<FormularioParaAdoptar> getPublicacionParaAdoptar() {
    return publicacionParaAdoptar;
  }

  public List<PublicacionDarEnAdopcion> getPublicacionesDarAdopcion() {
    return publicacionesDarAdopcion;
  }

  public void setAsociaciones(Asociacion asociacion){
    asociaciones.add(asociacion);
  }
  public Asociacion buscarAsociacionMasCercana(String direccion){
    //Buscar algoritmo de busqueda cercana
    return asociaciones.stream()
        .filter(asociacion -> asociacion.getDireccion().equals(direccion))
        .findFirst().get();
  }
  public void generarPublicacion(MascotaPerdida mascotaPerdida, Contacto contactoRescatista) {
    publicacionesPendientes.add(
    new PublicacionMascotaPerdida(buscarAsociacionMasCercana(mascotaPerdida.getLugar()), mascotaPerdida, contactoRescatista));
  }
  public void aprobarPublicacion(PublicacionMascotaPerdida publicacionMascotaPerdida){
    publicacionesAprobadas.add(publicacionMascotaPerdida);
    publicacionesPendientes.remove(publicacionMascotaPerdida);
  }
  public void rechazarPublicacion(PublicacionMascotaPerdida publicacionMascotaPerdida) {
    publicacionesPendientes.remove(publicacionMascotaPerdida);
  }
  public List<PublicacionMascotaPerdida> getPublicacionesPendientes() {
    return publicacionesPendientes;
  }
  public void generarPublicacionDarEnAdopcion(Mascota mascota, List<ValorCaracteristica> preguntasRespuestas, Contacto contacto){
    publicacionesDarAdopcion.add(new PublicacionDarEnAdopcion(mascota, preguntasRespuestas, contacto));
  }
  public void generarPublicacionAdoptar(Contacto contacto, List<Animal> preferencias , List<ValorCaracteristica> comodidades){
    publicacionParaAdoptar.add(new FormularioParaAdoptar(preferencias, comodidades, contacto));
  }

}
