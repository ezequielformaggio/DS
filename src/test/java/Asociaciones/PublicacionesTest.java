package Asociaciones;

import Asociacion.*;
import Rescatista.FormularioMascotaEncontradaSinChapita;
import Usuario.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PublicacionesTest {
  @Test
  public void aprobarPublicacionQuitaLaPublicacionDeLaListaDePendientes() {
    Asociacion asociacion = new Asociacion("Av de Mayo 130");

    LocalDate fechaNacimiento = LocalDate.parse("1997-06-20");
    Contacto hermano = new Contacto("Pirulo", "Martin", "123456", "pirulo@gmail.com");
    List<Contacto> contactos = new ArrayList<Contacto>();
    contactos.add(hermano);
    Contacto contactoRescatista = new Contacto("Mendez", "Martin", "123456","mendez@gmail.com");
    Duenio duenio = new Duenio("Camila", "Pirulo", fechaNacimiento, TipoDocumento.DNI, "42465789", contactos, "Camila", "contra5647", Arrays.asList(MedioDeComunicacionPreferido.MAIL,MedioDeComunicacionPreferido.SMS));

    CentralAsociaciones asociaciones = new CentralAsociaciones();
    asociaciones.setAsociaciones(asociacion);
    FormularioMascotaEncontradaSinChapita formularioMascotaEncontrada = new FormularioMascotaEncontradaSinChapita("Juan", "Flores", fechaNacimiento, TipoDocumento.DNI, "39908765", "Malabia 500", asociaciones, contactoRescatista);
    //Ver la diferencia entre direccion rescatista y direccion mascotaPerdida
    formularioMascotaEncontrada.darAvisoMascotaEncontrada(Arrays.asList("foto.jpg"), "Hembra de color negro aproximadamente 2kg", "Av de Mayo 130");
    formularioMascotaEncontrada.notificacionMascotaEncontrada(formularioMascotaEncontrada.mascotaPerdida);
    asociaciones.aprobarPublicacion(asociaciones.getPublicacionesPendientes().get(0));
    assertTrue(asociaciones.getPublicacionesPendientes().isEmpty());
  }
}