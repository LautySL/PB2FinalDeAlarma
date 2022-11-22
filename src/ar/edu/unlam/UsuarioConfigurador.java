package ar.edu.unlam;

import ar.edu.unlam.*;

public class UsuarioConfigurador extends Usuario implements Configurable {

	public UsuarioConfigurador(Integer dNI, String nombre) {
		super(dNI, nombre);
	}
	
	public void agregarUsuarioAlaListaDeUsuariosValidosDeUnaAlarma(int idUsuario, int idAlarma, String codigoConfiguracionAlarma) throws CodigoAlarmaIncorrectoException {
		Usuario usuarioAAgregar = new Usuario (idUsuario, null);
		Alarma alarma = new Alarma (idAlarma, null, codigoConfiguracionAlarma, null);
		
		if (alarma.getIDalarma() == idAlarma && alarma.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
			alarma.getUsuariosValidosParaOperar().add(usuarioAAgregar);
		} else if (alarma.getIDalarma() == idAlarma && alarma.getCodigoDeConfiguracion() != codigoConfiguracionAlarma) {
			throw new CodigoAlarmaIncorrectoException();
		}
	}

	public void agregarSensorAUnaAlarma (int idAlarma, String codigoConfiguracionAlarma, Sensor sensor) throws SensorDuplicadoException {
		
	}
	
	public boolean activarUnSensorDeUnaAlarma (int idSensor, int idAlarma, String codigoConfiguracionAlarma) {
		
	}
}
