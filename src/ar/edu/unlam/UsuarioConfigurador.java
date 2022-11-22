package ar.edu.unlam;

import ar.edu.unlam.*;

public class UsuarioConfigurador extends Usuario implements Configurable {

	public UsuarioConfigurador(Integer dNI, String nombre) {
		super(dNI, nombre);
	}
	
	public boolean agregarUsuarioAlaListaDeUsuariosValidosDeUnaAlarma(int idUsuario, int idAlarma, String codigoConfiguracionAlarma, Central central) throws CodigoAlarmaIncorrectoException {
		Alarma alarmaALaQueLeAgregoElUsuarioASuLista = central.getAlarma(idAlarma);
		Usuario usuarioAlQueAgregoALaAlarma = central.getUsuario(idUsuario);
		
		if (alarmaALaQueLeAgregoElUsuarioASuLista.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
			alarmaALaQueLeAgregoElUsuarioASuLista.agregarUsuarioValidoParaOperar(usuarioAlQueAgregoALaAlarma);
			return true;
		} else if (alarmaALaQueLeAgregoElUsuarioASuLista.getCodigoDeConfiguracion() != codigoConfiguracionAlarma) {
			throw new CodigoAlarmaIncorrectoException();
		} return false;
	}

	public void agregarSensorAUnaAlarma (int idAlarma, String codigoConfiguracionAlarma, Sensor sensor, Central central) throws SensorDuplicadoException {
		Alarma alarmaALaQueLeAgregoElSensor = central.getAlarma(idAlarma);
		
		if (alarmaALaQueLeAgregoElSensor.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
			alarmaALaQueLeAgregoElSensor.agregarSensor(sensor);
		} else if (alarmaALaQueLeAgregoElSensor.buscarSensorPorID(idAlarma) != null){
			throw new SensorDuplicadoException();
		}
	}
	
	public void activarUnSensorDeUnaAlarma (int idSensor, int idAlarma, String codigoConfiguracionAlarma, Central central) {
		Alarma alarmaALaQueLeActivoUnSensor = central.getAlarma(idAlarma);
		Sensor sensorDeLaAlarma = alarmaALaQueLeActivoUnSensor.buscarSensorPorID(idSensor);
		if (sensorDeLaAlarma.getEstaActivado() == false) {
			sensorDeLaAlarma.setEstaActivado(true);
		}
	}
}
