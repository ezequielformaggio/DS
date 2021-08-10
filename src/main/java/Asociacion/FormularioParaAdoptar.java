package Asociacion;

import Caracteristica.Caracteristica;
import Mascota.Animal;
import Mascota.ValorCaracteristica;
import Usuario.Contacto;

import java.util.ArrayList;
import java.util.List;

public class FormularioParaAdoptar {
  Contacto contacto;
  List<Animal> preferencias = new ArrayList<Animal>();
  List<ValorCaracteristica> comodidades = new ArrayList<ValorCaracteristica>();

  public FormularioParaAdoptar(List<Animal> preferencias, List<ValorCaracteristica> comodidades, Contacto contacto){
    this.preferencias = preferencias;
    this.comodidades = comodidades;
    this.contacto = contacto;
  }

  public Contacto getContacto() {
    return contacto;
  }

  public List<Animal> getPreferencias() {
    return preferencias;
  }

  public List<ValorCaracteristica> getComodidades() {
    return comodidades;
  }
}
