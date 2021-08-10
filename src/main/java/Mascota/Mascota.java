package Mascota;

import Caracteristica.Caracteristica;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
  private Animal animal;
  private String nombre;
  private String apodo;
  private int edad;
  private Sexo sexo;
  private String descripcion;
  private List<String> fotos=new ArrayList<String>();
  private List<ValorCaracteristica> caracteristicas = new ArrayList<ValorCaracteristica>();

  public Mascota(List<ValorCaracteristica> caracteristicas, Animal animal, String nombre, String apodo, int edad, Sexo sexo, String descripcion, List<String> fotos) {
    this.caracteristicas = caracteristicas;
    this.animal = animal;
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.descripcion = descripcion;
    this.fotos = fotos;
  }

  public List<ValorCaracteristica> getCaracteristicas() {
    return caracteristicas;
  }

  public Animal getAnimal() {
    return animal;
  }
}
