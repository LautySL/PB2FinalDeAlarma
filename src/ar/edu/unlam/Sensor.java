package ar.edu.unlam;

public class Sensor {
	
	private Integer identificadorNumerico;
	private Boolean estaActivado = false;
	
	public Sensor(Integer identificadorNumerico, Boolean estaActivado) {
		this.identificadorNumerico = identificadorNumerico;
		this.estaActivado = estaActivado;
	}
	
	public Integer getIdentificadorNumerico() {
		return identificadorNumerico;
	}
	public void setIdentificadorNumerico(Integer identificadorNumerico) {
		this.identificadorNumerico = identificadorNumerico;
	}
	public Boolean getEstaActivado() {
		return estaActivado;
	}
	public void setEstaActivado(Boolean estaActivado) {
		this.estaActivado = estaActivado;
	}
	
	
}
