package Asociacion;

public class AppRescateDePatitas {

  public static void main(String[] args){
    Recomendador recomendador = new Recomendador(new CentralAsociaciones());

    recomendador.generarRecomendacionSemanal();
  }
}
