package ar.edu.unlam;

public class Accion {
	
	private Integer identificadorDeLaAccion;
	private Alarma alarmaSobreLaQueOpera;
	private Usuario usuarioQueRealizaLaAccion;
	private TipoDeOperacion tipoDeOperacion;

	public Accion(Integer identificadorDeLaAccion, Alarma alarmaSobreLaQueOpera, Usuario usuarioQueRealizaLaAccion, TipoDeOperacion tipoDeOperacion) {
		this.identificadorDeLaAccion = identificadorDeLaAccion;
		this.alarmaSobreLaQueOpera = alarmaSobreLaQueOpera;
		this.usuarioQueRealizaLaAccion = usuarioQueRealizaLaAccion;
		this.tipoDeOperacion = tipoDeOperacion;
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
	
	
}
