package ar.edu.unlam;

import java.time.LocalDate;

public class Accion implements Comparable <Accion>{
	
	private Integer identificadorDeLaAccion;
	private Alarma alarmaSobreLaQueOpera;
	private Usuario usuarioQueRealizaLaAccion;
	private LocalDate fecha;
	private TipoDeOperacion tipoDeOperacion;

	public Accion(Integer identificadorDeLaAccion, Alarma alarmaSobreLaQueOpera, Usuario usuarioQueRealizaLaAccion, LocalDate fecha, TipoDeOperacion tipoDeOperacion) {
		this.identificadorDeLaAccion = identificadorDeLaAccion;
		this.alarmaSobreLaQueOpera = alarmaSobreLaQueOpera;
		this.fecha = fecha;
		this.usuarioQueRealizaLaAccion = usuarioQueRealizaLaAccion;
		this.tipoDeOperacion = tipoDeOperacion;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getIdentificadorDeLaAccion() {
		return identificadorDeLaAccion;
	}
	public void setIdentificadorDeLaAccion(Integer identificadorDeLaAccion) {
		this.identificadorDeLaAccion = identificadorDeLaAccion;
	}
	public Alarma getAlarmaSobreLaQueOpera() {
		return alarmaSobreLaQueOpera;
	}
	public void setAlarmaSobreLaQueOpera(Alarma alarmaSobreLaQueOpera) {
		this.alarmaSobreLaQueOpera = alarmaSobreLaQueOpera;
	}
	public Usuario getUsuarioQueRealizaLaAccion() {
		return usuarioQueRealizaLaAccion;
	}
	public void setUsuarioQueRealizaLaAccion(Usuario usuarioQueRealizaLaAccion) {
		this.usuarioQueRealizaLaAccion = usuarioQueRealizaLaAccion;
	}
	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}
	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}

	@Override
	public int compareTo(Accion o) {
		return this.identificadorDeLaAccion - o.identificadorDeLaAccion;
	}
	
	
}
