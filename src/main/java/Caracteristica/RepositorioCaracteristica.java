package Caracteristica;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCaracteristica {
  private static RepositorioCaracteristica repoDeCaracteristicasInstance = new RepositorioCaracteristica();
  private List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();

  public static RepositorioCaracteristica getRepoDeCaracteristicasInstance() {
    return repoDeCaracteristicasInstance;
  }
  public void agregarCaracteristica(Caracteristica caracteristica){
    caracteristicas.add(caracteristica);
  }
  public List<Caracteristica> getCaracteristicas(){
    return caracteristicas;
  }
}
