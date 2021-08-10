package Mascota;

import Caracteristica.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {
  @Test
  public void mascotaTieneCaracteristicas() { //Falta agregar usuario y contrasena
    List<ValorCaracteristica> caracteristicas = new ArrayList<ValorCaracteristica>();
    Caracteristica caracteristicaCastrado = new BoolCaracteristica("castrado");
    ValorCaracteristica<Boolean> castrado = new ValorCaracteristica(caracteristicaCastrado,true);
    caracteristicas.add(castrado);
    caracteristicas.add(castrado);
    Mascota beagle = new Mascota(caracteristicas, Animal.PERRO, "Greta", "Gretuchis", 13, Sexo.FEMENINO, "Es de color negro, marron y blanco", null);

    assertEquals(beagle.getCaracteristicas(), caracteristicas);
  }

}
