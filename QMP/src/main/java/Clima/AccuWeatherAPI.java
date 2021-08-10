package Clima;

import java.util.*;

public final class AccuWeatherAPI extends Clima {

  AccuWeatherAPI apiClima = new AccuWeatherAPI();
  List<InformeDelClima> informesDelClima;
  List<ClimaObserver> climaObservers;

  public final List<Map<String, Object>> getWeather(String ciudad) {
    return Arrays.asList(new HashMap<String, Object>() {{
      put("DateTime", "2019-05-03T01:00:00-03:00");
      put("EpochDateTime", 1556856000);
      put("WeatherIcon", 33);
      put("IconPhrase", "Clear");
      put("IsDaylight", false);
      put("PrecipitationProbability", 0);
      put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
      put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
      put("Temperature", new HashMap<String, Object>() {{
        put("Value", 57);
        put("Unit", "F");
        put("UnitType", 18);
      }});
    }});
  }

  public final Map<String, Object> getAlerts(String ciudad){
    String[] pronosticos = {"SUNNY", "STORM", "HAIL"};
    return Arrays.asList(new HashMap<String, Object>() {{
      put("CurrentAlerts", Arrays.asList(pronosticos));
    }}).get(0);
  }

  public void actualizacionRecibida(InformeDelClima informeDelClima){
    climaObservers.forEach(climaObserver -> climaObserver.actualizacionRecibida(informeDelClima));
    agregarInforme(informeDelClima);
  }

  public void agregarInforme(InformeDelClima informeDelClima){
    if (informesDelClima.size() >= 10){
      informesDelClima.remove(0);
    }
    informesDelClima.add(informeDelClima);
  }

  public InformeDelClima getInforme(String ciudad) {
    InformeDelClima informeDelClima = new InformeDelClima(getTemperatura(ciudad),getPronostico(ciudad));
    agregarInforme(informeDelClima);
    return informeDelClima;
  }

  public List<InformeDelClima> getInformesDelClima() {
    return informesDelClima;
  }

  public List<String> getPronostico(String ciudad) {
    Map<String, Object> alertas = apiClima.getAlerts(ciudad);
    List<String> alertasObtenidas = (List<String>) alertas.get("CurrentAlerts");
    return alertasObtenidas;
  }

  public Double getTemperatura(String ciudad) {
    List<Map<String, Object>> temperatura = apiClima.getWeather(ciudad);
    Double temperaturaFarenheit = (Double) temperatura.get(0).get("Value");
    return conversionACelcius(temperaturaFarenheit);
  }

  public Double conversionACelcius(Double temperaturaFarenheit){
    return (temperaturaFarenheit  - 32)*5/9;
  }

}