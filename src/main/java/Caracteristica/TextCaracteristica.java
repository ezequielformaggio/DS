package Caracteristica;

public class TextCaracteristica implements Caracteristica<String> {

  String titulo;

  public TextCaracteristica(String titulo) {
    this.titulo = titulo;
  }

  public String getTitulo(){
    return titulo;
  }
}