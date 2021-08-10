package Usuario;

import Caracteristica.*;
import Mascota.*;
import Asociacion.Asociacion;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DuenioTest {
  @Test
  public void darDeAltaUnaMascota() { //Falta agregar usuario y contrasena
    Contacto hermano = new Contacto("Pirulo", "Martin", "123456","pirulo@gmail.com");
    Asociacion asociacion = new Asociacion("Av de Mayo 130");
    List<Contacto> contactos = new ArrayList<Contacto>();
    contactos.add(hermano);
    LocalDate fechaNacimiento = LocalDate.parse("1996-06-23");
    Duenio duenio = new Duenio("Camila", "Pirulo", fechaNacimiento, TipoDocumento.DNI, "42465789", contactos,"Camila","contra5647",Arrays.asList(MedioDeComunicacionPreferido.MAIL,MedioDeComunicacionPreferido.SMS));
    List<ValorCaracteristica> caracteristicas = new ArrayList<>();
    Caracteristica caracteristicaCastrado = new BoolCaracteristica("castrado");
    ValorCaracteristica<Boolean> castrado = new ValorCaracteristica(caracteristicaCastrado,true);
    caracteristicas.add(castrado);
    Mascota beagle = new Mascota(caracteristicas, Animal.PERRO, "Greta", "Gretuchis", 13, Sexo.FEMENINO, "Es de color negro, marron y blanco", null);
    duenio.registrarMascota(beagle);
    duenio.registrarPersona(asociacion);

    assertEquals(asociacion,duenio.getAsociacion());
  }

}
