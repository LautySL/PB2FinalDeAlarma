package ar.edu.unlam;

public class Usuario {
	
	private Integer DNI;
	private String Nombre;
	
	public Usuario(Integer dNI, String nombre) {
		this.DNI = dNI;
		this.Nombre = nombre;
	}
	
	public Integer getDNI() {
		return DNI;
	}
	
	public void setDNI(Integer dNI) {
		DNI = dNI;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
