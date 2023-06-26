package ar.edu.unlam;

import java.util.ArrayList;
import java.util.List;

public class Central {
	
	private Integer nombre;
	private List <Usuario> usuarios;
	private List <Alarma> alarmas;
	
	public Central() {
		super();
		this.usuarios = new ArrayList <Usuario>();
		this.alarmas = new ArrayList <Alarma>();
	}
	
	public Integer getNombre() {
		return nombre;
	}
	
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Alarma> getAlarmas() {
		return alarmas;
	}
	
	public void setAlarmas(List<Alarma> alarmas) {
		this.alarmas = alarmas;
	}
	
	public Boolean agregarAlarma (Alarma alarma) {
		return this.alarmas.add(alarma);
	}
	
	public Boolean agregarUsuario (Usuario usuario) {
		if (this.usuarios.add(usuario)) {
			return true;
		} return false;
	}
	
	public Alarma getAlarma (int idAlarma) {
		for (Alarma alarma : alarmas) {
			if (alarma.getIDalarma() == idAlarma) {
				return alarma;
			}
		} return null;
	}
	
	public Usuario getUsuario (int DniUsuario) {
		for (Usuario usuario : usuarios) {
			if (usuario.getDNI() == DniUsuario) {
				return usuario;
			}
		} return null;
	}
	
	public boolean agregarSensorAAlarma(int idAlarma, String codigoConfiguracionAlarma, Sensor sensor, int idUsuarioConfigurador) throws SensorDuplicadoException {	
			Alarma alarma = getAlarmaPorID(idAlarma);
			List <Sensor> listaDeSensoresDeLaAlarma = alarma.getListaDeSensores();
	
			if (alarma.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
				if (listaDeSensoresDeLaAlarma.size() == 0) {
					alarma.agregarSensor(sensor);
					return true;
				}	
					for (Sensor sensor2 : listaDeSensoresDeLaAlarma) {
						if (sensor2.getIdentificadorNumerico() != sensor.getIdentificadorNumerico()) {
							alarma.agregarSensor(sensor);
							return true;
						}
					}
				} else if (alarma.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
						for (Sensor sensor2 : listaDeSensoresDeLaAlarma) {
							if (sensor2.getIdentificadorNumerico().equals(sensor.getIdentificadorNumerico())) {
								throw new SensorDuplicadoException();
						}
					}
				}
		 return false;
	}
	
	public boolean activarSensorDeAlarma (int idSensor, int idAlarma, String codigoActivacionAlarma) {
		Sensor sensorABuscar = new Sensor (idSensor, false);
		
		for (Alarma alarma : alarmas) {	
			if (alarma.getIDalarma() == idAlarma) {
				if (alarma.getCodigoDeActivacionDesactivacion().equals(codigoActivacionAlarma)) {
					if (alarma.buscarSensorPorID(idSensor) != null) {
						sensorABuscar.setEstaActivado(true);
						return true;
					}
				}
			}
		} return false;
	}
	
	private Alarma getAlarmaPorID (int idAlarma) {
		Alarma alarmaBuscada = null;
		for (Alarma alarma : alarmas) {
			if (alarma.getIDalarma().equals(idAlarma)) {
				alarmaBuscada = alarma;
				return alarmaBuscada;
			}
		} return null;
	}
	
	public Boolean activarAlarma (int idAlarma, String codigoActivacionAlarma) {
		Alarma alarma = getAlarmaPorID(idAlarma);
		if (alarma.getCodigoDeActivacionDesactivacion().equals(codigoActivacionAlarma)) {
			if (alarma.verificarSiTodosLosSensoresDeUnaAlarmaEstanActivados()) {
				if (alarma.getEstaActivada() == false) {
					alarma.setEstaActivada(true);
					return true;
				}
			}
		}
		return false;
	}
	
	public void desactivarAlarma (int idAlarma) {
		Alarma alarma = getAlarmaPorID(idAlarma);
		if (alarma.getEstaActivada() == true) {
			alarma.setEstaActivada(false);
		}
	}

	public boolean agregarUsuarioALaListaDeUsuariosValidosDeUnaAlarma(Usuario usuario, Integer iDAlarma, String codigoDeConfiguracionDeLaAlarma) {
		Alarma alarmaALaQueLeAgregoElUsuario = getAlarmaPorID(iDAlarma);
		if (alarmaALaQueLeAgregoElUsuario.agregarUsuarioValidoParaOperar(usuario)) {
			return true;
		}
		return false;
	}
	
	
}
