package Guardarropa;

import Atuendo.Atuendo;
import Atuendo.GeneradorDeAtuendo;
import Clima.AccuWeatherAPI;
import Prenda.Prenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {
  private AccuWeatherAPI clima;
  private CriterioSeparacion criterio;
  private GeneradorDeAtuendo generadorDeAtuendo;
  private List<Prenda> prendas = new ArrayList<>();
  private Atuendo sugerenciaDiaria;
  private String ciudad;

  public Guardarropa(CriterioSeparacion criterio) {
    this.criterio = criterio;
  }

  public Atuendo sugerirAtuendo(){
    return generadorDeAtuendo.crearAtuendo(obtenerPrendasSegunClima());
  }

  public void sugerenciaDiaria(){ // hacer un disparador que a tal hora ejecute este metodo
    sugerenciaDiaria = generadorDeAtuendo.crearAtuendo(obtenerPrendasSegunClima());
  }

  Timer timer = new Timer(86400000, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
      sugerenciaDiaria();
      timer.restart();
    }
  });

  // obtener prendas segun clima -> temperatura y estado meteorologico
  // ademas crear un metodo sugerencia diaria que se actualize solo todos los dias
  // tiene que ser para todos los usuarios, es necesaria una lista de usuarios y un for each? probablemente
  // crear un metodo obtener condiciones meteorologicas asi como tengo el de temperatura
  // necesito un observer que se actualize cuando se notifique una alerta nueva para la sugerencia diaria
  // if hay tormenta mensaje usar paraguas, exception?
  // if hay granizo mensaje no salir en auto
  // ante la notificacion de un alerta meteorologico, mandar un mail
  // como usuario quiero elegir mis medios preferidos de notificacion
  // las alertas deben ser automaticas opcionalmente


  public List<Prenda> obtenerPrendasSegunClima(){
    Double temperatura = clima.getTemperatura("Buenos Aires, Argentina");
    return this.prendas
        .stream()
        .filter(prenda -> prenda.validarTemperatura(temperatura))
        .collect(Collectors.toList());
  }

  public void agregarPrenda(Prenda prenda){
    this.prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda){
    this.prendas.remove(prenda);
  }

  public Atuendo getSugerenciaDiaria() {
    return sugerenciaDiaria;
  }

}
