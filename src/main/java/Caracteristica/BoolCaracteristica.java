package Caracteristica;

public class BoolCaracteristica implements Caracteristica<Boolean>{

  String titulo;

  public BoolCaracteristica(String titulo) {
    this.titulo = titulo;
  }

  public String getTitulo(){ return titulo; }
}
