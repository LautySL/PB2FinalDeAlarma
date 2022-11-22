package ar.edu.unlam;

import ar.edu.unlam.*;

public class UsuarioActivador extends Usuario implements Activable {

	public UsuarioActivador(Integer dNI, String nombre) {
		super(dNI, nombre);
	}
	
	public boolean activarDesactivarAlarma (Alarma alarma, String codigoActivacionAlarma, Central central) {
		
	}

}
