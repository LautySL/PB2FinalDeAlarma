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
		if (this.alarmas.add(alarma)) {
			return true;
		} return false;
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
		for (Alarma alarma : alarmas) {
			if (alarma.getIDalarma().equals(idAlarma)) {
				if (alarma.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
					List <Sensor> listaDeSensoresDeLaAlarma = alarma.getListaDeSensores();
					for (Sensor sensor2 : listaDeSensoresDeLaAlarma) {
						if (sensor2.getIdentificadorNumerico() != sensor.getIdentificadorNumerico()) {
							alarma.agregarSensor(sensor);
							return true;
						}
					}
				} else if (alarma.getIDalarma().equals(idAlarma)) {
					if (alarma.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
						List <Sensor> listaDeSensoresDeLaAlarma = alarma.getListaDeSensores();
						for (Sensor sensor2 : listaDeSensoresDeLaAlarma) {
							if (sensor2.getIdentificadorNumerico().equals(sensor.getIdentificadorNumerico())) {
								throw new SensorDuplicadoException();
							}
						}
					}
				}
			}
		} return false;
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
	
	public boolean activarODesactivarAlarma (int idAlarma, String codigoActivacionAlarma) {
		Boolean alarmaActivada = true;
		for (Alarma alarma : alarmas) {
			if (alarma.getIDalarma() == idAlarma) {
				if (alarma.getCodigoDeActivacionDesactivacion().equals(codigoActivacionAlarma)) {
					if (alarma.verificarSiTodosLosSensoresDeUnaAlarmaEstanActivados() && alarma.getEstaActivada() == false) {
						alarma.setEstaActivada(true);
						alarmaActivada = true;
					} else if (alarma.getEstaActivada() == true) {
						alarma.setEstaActivada(false);
						alarmaActivada = false;
					}
				}
			}
		} return alarmaActivada;
	}

	public boolean agregarUsuarioALaListaDeUsuariosValidosDeUnaAlarma(Integer dni, Integer iDalarma, String codigoDeConfiguracionDeLaAlarma) {
		Boolean fueAgregadoElUsuario = false;
		return false;
	}
	
	
}
