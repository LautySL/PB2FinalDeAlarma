package ar.edu.unlam;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Alarma {

	private Integer IDalarma;
	private String nombreDeLaAlarma, codigoDeConfiguracion, codigoDeActivacionDesactivacion;
	private List <Usuario> usuariosValidosParaOperar;
	private List <Accion> accionesRealizadas;
	private List <Sensor> listaDeSensores;
	private Boolean estaActivada = false;
	
	public Alarma(Integer iDalarma, String nombreDeLaAlarma, String codigoDeConfiguracion, String codigoDeActivacionDesactivacion) {
		super();
		this.IDalarma = iDalarma;
		this.nombreDeLaAlarma = nombreDeLaAlarma;
		this.codigoDeConfiguracion = codigoDeConfiguracion;
		this.codigoDeActivacionDesactivacion = codigoDeActivacionDesactivacion;
		this.usuariosValidosParaOperar = new ArrayList <Usuario>();
		this.accionesRealizadas = new ArrayList <Accion>();
		this.listaDeSensores = new ArrayList <Sensor>();
	}

	public Integer getIDalarma() {
		return IDalarma;
	}

	public void setIDalarma(Integer iDalarma) {
		IDalarma = iDalarma;
	}

	public String getCodigoDeConfiguracion() {
		return codigoDeConfiguracion;
	}

	public void setCodigoDeConfiguracion(String codigoDeConfiguracion) {
		this.codigoDeConfiguracion = codigoDeConfiguracion;
	}

	public String getCodigoDeActivacionDesactivacion() {
		return codigoDeActivacionDesactivacion;
	}

	public void setCodigoDeActivacionDesactivacion(String codigoDeActivacionDesactivacion) {
		this.codigoDeActivacionDesactivacion = codigoDeActivacionDesactivacion;
	}

	public String getNombreDeLaAlarma() {
		return nombreDeLaAlarma;
	}

	public void setNombreDeLaAlarma(String nombreDeLaAlarma) {
		this.nombreDeLaAlarma = nombreDeLaAlarma;
	}

	public List <Usuario> getUsuariosValidosParaOperar() {
		return usuariosValidosParaOperar;
	}

	public void setUsuariosValidosParaOperar(List <Usuario> usuariosValidosParaOperar) {
		this.usuariosValidosParaOperar = usuariosValidosParaOperar;
	}

	public List <Accion> getAccionesRealizadas() {
		return accionesRealizadas;
	}

	public void setAccionesRealizadas(List <Accion> accionesRealizadas) {
		this.accionesRealizadas = accionesRealizadas;
	}

	public List <Sensor> getListaDeSensores() {
		return listaDeSensores;
	}

	public void setListaDeSensores(List <Sensor> listaDeSensores) {
		this.listaDeSensores = listaDeSensores;
	}
	
	public Boolean verificarSiSensorYaEstaRegistrado(Sensor sensor) {
		boolean yaEstaRegistrado = false;
		for (Sensor Sensor : listaDeSensores) {
			if (Sensor.getIdentificadorNumerico() == sensor.getIdentificadorNumerico()) {
				yaEstaRegistrado = true;
			}
		} return yaEstaRegistrado;
	}
	
	public Sensor buscarSensorPorID (int idSensor) {
		for (Sensor Sensor : listaDeSensores) {
			if (Sensor.getIdentificadorNumerico() == idSensor) {
				return Sensor;
			}
		} return null;
	}
	
	public boolean verificarSiTodosLosSensoresDeUnaAlarmaEstanActivados() {
		for (Sensor Sensor : listaDeSensores) {
			if (Sensor.getEstaActivado() == false) {
				return false;
			}
		} return true;
	}
	
	public Integer getCantidadDeSensoresDesactivados() {
		Integer contadorDeSensoresDesactivados = 0;
		for (Sensor sensor : listaDeSensores) {
			if (sensor.getEstaActivado() == false) {
				contadorDeSensoresDesactivados++;
			}
		} return contadorDeSensoresDesactivados;
	}
	
	public void agregarSensor (Sensor sensor) {
		listaDeSensores.add(sensor);
	}
	
	public void agregarUsuarioValidoParaOperar (Usuario usuario) {
		usuariosValidosParaOperar.add(usuario);
	}

	public Boolean getEstaActivada() {
		return estaActivada;
	}

	public void setEstaActivada(Boolean estaActivada) {
		this.estaActivada = estaActivada;
	} 
	
	public Boolean agregarAccion (Integer identificadorDeLaAccion, Alarma alarmaSobreLaQueOpera, Usuario usuarioQueRealizaLaAccion, LocalDate fecha, TipoDeOperacion tipoDeOperacion) {
		Accion accionAAgregar = new Accion (identificadorDeLaAccion, alarmaSobreLaQueOpera, usuarioQueRealizaLaAccion, fecha, tipoDeOperacion);
		if (accionesRealizadas.add(accionAAgregar)) {
			return true;
		} return false;
	} 
	
	public ArrayList <Accion> getAccionesOrdenadasPorId() {
		ArrayList <Accion> accionesOrdenadasPorId = new ArrayList<>();
		accionesOrdenadasPorId.addAll(this.accionesRealizadas);
		Collections.sort(accionesOrdenadasPorId);
		return accionesOrdenadasPorId;
	}
}
