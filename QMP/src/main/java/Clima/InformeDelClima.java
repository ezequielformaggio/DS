package Clima;

import java.util.List;

public class InformeDelClima {
  public Double temperatura;
  public List<String> pronostico;

  public InformeDelClima(Double temperatura, List<String> pronostico){
    this.temperatura = temperatura;
    this.pronostico = pronostico;
  }
}
