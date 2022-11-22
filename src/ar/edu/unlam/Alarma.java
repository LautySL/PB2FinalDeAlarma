package ar.edu.unlam;

import java.util.List;
import java.util.ArrayList;

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

	public Boolean getEstaActivada() {
		return estaActivada;
	}

	public void setEstaActivada(Boolean estaActivada) {
		this.estaActivada = estaActivada;
	} 
}
