package ar.edu.unlam.test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import ar.edu.unlam.*;

import org.junit.Test;

public class Testometro {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		Central centralDeAlarmas = new Central();
		Alarma alarmaARegistrar = new Alarma (1234, "Alarm", "CONFIG", "DEACTIVATE");
		
		assertTrue(centralDeAlarmas.agregarAlarma(alarmaARegistrar));
	}
	
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws CodigoAlarmaIncorrectoException {
		UsuarioConfigurador usuarioConfig = new UsuarioConfigurador (1233, "Juan");
		Central centralDeAlarmas = new Central();
		Alarma alarmaALaQueLeAgregoElUsuarioConfigurador = new Alarma (1224, "Alarm", "CONFIG", "DEACTIVATE");
		
		centralDeAlarmas.agregarAlarma(alarmaALaQueLeAgregoElUsuarioConfigurador);
		centralDeAlarmas.agregarUsuario(usuarioConfig);
		alarmaALaQueLeAgregoElUsuarioConfigurador.agregarAccion(3000, alarmaALaQueLeAgregoElUsuarioConfigurador, usuarioConfig, LocalDate.now(),TipoDeOperacion.CONFIGURACION);
		
		assertEquals (1, alarmaALaQueLeAgregoElUsuarioConfigurador.getAccionesRealizadas().size());
		assertTrue (usuarioConfig.agregarUsuarioAlaListaDeUsuariosValidosDeUnaAlarma(1223, 1224, "CONFIG", centralDeAlarmas));
	}
	
	@Test (expected = CodigoAlarmaIncorrectoException.class)
	public void queAlAgregarUnUsuarioConfiguradorAUnaAlarmaConCodigoDeConfiguracionIncorrectoLanceLaExcepcion() throws CodigoAlarmaIncorrectoException {
		UsuarioConfigurador usuarioConfig = new UsuarioConfigurador (1233, "Juan");
		Central centralDeAlarmas = new Central();
		Alarma alarmaALaQueLeAgregoElUsuarioConfigurador = new Alarma (1224, "Alarm", "CONFIG", "DEACTIVATE");
		
		centralDeAlarmas.agregarAlarma(alarmaALaQueLeAgregoElUsuarioConfigurador);
		centralDeAlarmas.agregarUsuario(usuarioConfig);
		alarmaALaQueLeAgregoElUsuarioConfigurador.agregarAccion(3000, alarmaALaQueLeAgregoElUsuarioConfigurador, usuarioConfig, LocalDate.now(),TipoDeOperacion.CONFIGURACION);
		
		assertEquals (1, alarmaALaQueLeAgregoElUsuarioConfigurador.getAccionesRealizadas().size());
		assertTrue (usuarioConfig.agregarUsuarioAlaListaDeUsuariosValidosDeUnaAlarma(1223, 1224, "COfNFIG", centralDeAlarmas));
	}
	
	@Test (expected = SensorDuplicadoException.class)
	public void queAlAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnSensorDuplicadoException() throws SensorDuplicadoException {
		UsuarioConfigurador usuarioConfig = new UsuarioConfigurador (1233, "Juan");
		Central centralDeAlarmas = new Central();
		Alarma alarmaALaQueLeAgregoElUsuarioConfigurador = new Alarma (1224, "Alarm", "CONFIG", "DEACTIVATE");
		
		Sensor sensor = new Sensor (123, false);
		Sensor sensorDuplicado = new Sensor (123, false);
		Sensor sensor2 = new Sensor (321, false);
		
		centralDeAlarmas.agregarAlarma(alarmaALaQueLeAgregoElUsuarioConfigurador);
		centralDeAlarmas.agregarUsuario(usuarioConfig);
		alarmaALaQueLeAgregoElUsuarioConfigurador.agregarAccion(3000, alarmaALaQueLeAgregoElUsuarioConfigurador, usuarioConfig, LocalDate.now(),TipoDeOperacion.CONFIGURACION);
		
		usuarioConfig.agregarSensorAUnaAlarma(1224, "CONFIG", sensor, centralDeAlarmas);
		usuarioConfig.agregarSensorAUnaAlarma(1224, "CONFIG", sensor2, centralDeAlarmas);
		
		
		Integer cantidadDeSensoresEnLaAlarmaEsperado = 2;
		Integer cantidadDeSensoresEnLaAlarma = alarmaALaQueLeAgregoElUsuarioConfigurador.getListaDeSensores().size();
		
		assertEquals (cantidadDeSensoresEnLaAlarmaEsperado, cantidadDeSensoresEnLaAlarma);
		assertTrue (usuarioConfig.agregarSensorAUnaAlarma(1224, "CONFIG", sensorDuplicado, centralDeAlarmas));
	}
	
	@Test
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws CodigoAlarmaIncorrectoException, SensorDuplicadoException {
		UsuarioAdministrador administrador = new UsuarioAdministrador(41026566, "Pancho Cerro");
		Central central = new Central();
		Alarma alarma = new Alarma(1, "2222", "3333", "ProteccionTotal2000");
		central.agregarUsuario(administrador);
		administrador.agregarAlarma(alarma, central);

		administrador.agregarUnUsuarioALaListaDeUsuariosValidos(central, administrador.getDNI(), alarma.getIDalarma(), alarma.getCodigoDeConfiguracion());

		alarma.agregarAccion(1, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		Sensor sensor = new Sensor(1, true);
		administrador.agregarSensorAAlarma(1, "3333", sensor, administrador.getDNI(), central);
		Sensor sensor1 = new Sensor(26, true);
		administrador.agregarSensorAAlarma(1, "3233", sensor1, administrador.getDNI(), central);

		administrador.activarODesactivarAlarma(alarma.getIDalarma(), alarma.getCodigoDeActivacionDesactivacion(), central);

		Boolean esperado = true;
		Boolean obtenido = alarma.getEstaActivada();

		assertEquals(esperado, obtenido);
	}

	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAcccionesDeTipoConfiguracionOdenadasPorldDeAccion() throws CodigoAlarmaIncorrectoException {
		UsuarioAdministrador administrador = new UsuarioAdministrador(41026566, "Pancho Cerro");
		Central central = new Central();
		Alarma alarma = new Alarma (1224, "Alarm", "CONFIG", "DEACTIVATE");
		
		central.agregarUsuario(administrador);
		administrador.agregarAlarma(alarma, central);
		administrador.agregarUnUsuarioALaListaDeUsuariosValidos(central, administrador.getDNI(), alarma.getIDalarma(), alarma.getCodigoDeConfiguracion());
		
		alarma.agregarAccion(1, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(50, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(3000, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(8, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		

		for (Accion accion : alarma.getAccionesOrdenadasPorId()) {
			System.out.println(accion.toString());
		}
	}

}
