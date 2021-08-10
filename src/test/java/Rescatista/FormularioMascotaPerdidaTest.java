package Rescatista;

import NotificacionAppRescateDePatitas.*;
import Usuario.*;
import Asociacion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FormularioMascotaPerdidaTest {
  private Asociacion asociacion;
  private List<Contacto> contactos;
  private LocalDate fechaNacimiento;
  private Duenio duenio;
  private Contacto contactoRescatista;
  private List<MedioDeComunicacionPreferido> medios;
  private List<NotificacionAppRescateDePatitasObserver> notificacionesObserver;

  @BeforeEach
  void initFormularioMascotaPerdida() {
    asociacion = new Asociacion("Av de Mayo 130");
    contactos = Arrays.asList(new Contacto("Pirulo", "Camila", "123456","eformaggio@frba.utn.edu.ar"));
    fechaNacimiento = LocalDate.parse("1997-06-20");
    contactoRescatista = new Contacto("Mendez", "Martin", "123456","mendez@gmail.com");
    medios = Arrays.asList(MedioDeComunicacionPreferido.MAIL,MedioDeComunicacionPreferido.SMS);
    //MailObserver mailMock = mock(MailObserver.class);
    //SMSObserver smsMock = mock(SMSObserver.class);
    //notificacionesObserver = Arrays.asList(mailMock, smsMock);
    duenio = new Duenio("Camila", "Pirulo", fechaNacimiento, TipoDocumento.DNI, "42465789", contactos,"Camila","contra5647", medios);
  }
  @Test
  public void InformarMascotaPerdidaConChapitaEncontrada() {
    //MailObserver mailMock = mock(MailObserver.class);
    //SMSObserver smsMock = mock(SMSObserver.class);
    FormularioMascotaEncontradaConChapita formularioMascotaEncontrada = new FormularioMascotaEncontradaConChapita("Juan", "Flores", fechaNacimiento, TipoDocumento.DNI, "39908765", "Medrano 521", duenio, asociacion, contactoRescatista);
    formularioMascotaEncontrada.darAvisoMascotaEncontrada(Arrays.asList("foto.jpg"), "Hembra de color negro aproximadamente 2kg", "Malabia 500");
    formularioMascotaEncontrada.notificacionMascotaEncontrada(formularioMascotaEncontrada.mascotaPerdida);
    assertTrue(asociacion.getFormularioMascotaEncontradasConChapita().contains(formularioMascotaEncontrada));
    //verify(mailMock, times(1)).mascotaConChapitaEncontrada(duenio, asociacion.direccion);
    //verify(smsMock, times(1)).mascotaConChapitaEncontrada(duenio, asociacion.direccion);
  }

  @Test
  public void InformarMascotaPerdidaSinChapitaEncontrada() {
    CentralAsociaciones asociaciones = new CentralAsociaciones();
    asociaciones.setAsociaciones(asociacion);
    FormularioMascotaEncontradaSinChapita formularioMascotaEncontrada = new FormularioMascotaEncontradaSinChapita("Juan", "Flores", fechaNacimiento, TipoDocumento.DNI, "39908765", "Malabia 500", asociaciones, contactoRescatista);
    //Ver la diferencia entre direccion rescatista y direccion mascotaPerdida
    formularioMascotaEncontrada.darAvisoMascotaEncontrada(Arrays.asList("foto.jpg"), "Hembra de color negro aproximadamente 2kg", "Av de Mayo 130");
    formularioMascotaEncontrada.notificacionMascotaEncontrada(formularioMascotaEncontrada.mascotaPerdida);
    assertFalse(asociaciones.getPublicacionesPendientes().isEmpty());
  }
}
