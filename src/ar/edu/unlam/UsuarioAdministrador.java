package ar.edu.unlam;

public class UsuarioAdministrador extends Usuario {

	public UsuarioAdministrador(Integer dNI, String nombre) {
		super(dNI, nombre);
	}
	
	public boolean agregarAlarma (Alarma alarma, Central central) {
		return central.agregarAlarma(alarma);
	}
	
	public boolean agregarUsuario (Usuario usuario, Central central) {
		return central.agregarUsuario(usuario);
	}
	
	public boolean agregarSensorAAlarma (int idAlarma, String codigoConfiguracionAlarma, Sensor sensor, int idUsuarioConfigurador, Central central) throws SensorDuplicadoException {
		return central.agregarSensorAAlarma(idAlarma, codigoConfiguracionAlarma, sensor, idUsuarioConfigurador);
	}
	
	public boolean activarSensorDeAlarma (int idSensor, int idAlarma, String codigoActivacionAlarma, Central central) {
		return central.activarSensorDeAlarma(idSensor, idAlarma, codigoActivacionAlarma);
	}
	
	public boolean activarODesactivarAlarma (int idAlarma, String codigoActivacionAlarma, Central central) {
		return central.activarODesactivarAlarma(idAlarma, codigoActivacionAlarma);
	}

	public boolean agregarUnUsuarioALaListaDeUsuariosValidos (Central central, Integer dni, Integer iDalarma, String codigoDeConfiguracionDeLaAlarma) {
		return central.agregarUsuarioALaListaDeUsuariosValidosDeUnaAlarma(dni, iDalarma, codigoDeConfiguracionDeLaAlarma);
		
	}

}
