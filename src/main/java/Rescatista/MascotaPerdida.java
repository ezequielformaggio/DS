package Rescatista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MascotaPerdida {
  private List<String> fotos = new ArrayList<String>();
  private String descripcion;
  public String lugar;  //La informacion viene de adentro del sistema por lo cual no validamos
  public LocalDate fechaEncontrado =LocalDate.now();

  public MascotaPerdida(List<String> fotos, String descripcion, String lugar) {
    this.fotos = fotos;
    this.descripcion = descripcion;
    this.lugar = lugar;
  }

  public void setFechaEncontrado(LocalDate fechaEncontrado) {
    this.fechaEncontrado = fechaEncontrado;
  }

  public Boolean encontradaEnTalDia(int dias){
    LocalDate presente = LocalDate.now();
    return this.fechaEncontrado.isAfter(presente.minusDays(dias));
  }
  public String getLugar(){
    return lugar;
  }
}
