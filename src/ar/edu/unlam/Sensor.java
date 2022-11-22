package ar.edu.unlam;

import java.util.Objects;

public class Sensor {
	
	@Override
	public int hashCode() {
		return Objects.hash(identificadorNumerico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return Objects.equals(identificadorNumerico, other.identificadorNumerico);
	}
	
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
