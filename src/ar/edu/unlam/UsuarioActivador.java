package ar.edu.unlam;

import ar.edu.unlam.*;

// https://github.com/lcattaneo98/PB2-Parcial2-2C2022-CattaneoLaureano

public class UsuarioActivador extends Usuario implements Activable {

	public UsuarioActivador(Integer dNI, String nombre) {
		super(dNI, nombre);
	}
	
	public boolean activarDesactivarAlarma (Alarma alarma, String codigoActivacionAlarma, Central central) {
		Alarma alarmaAModificar = central.getAlarma(alarma.getIDalarma());
		if (alarmaAModificar.verificarSiTodosLosSensoresDeUnaAlarmaEstanActivados() && alarmaAModificar.getEstaActivada() == false) {
			alarmaAModificar.setEstaActivada(true);
			return true;
		} else if (alarmaAModificar.getEstaActivada() == true) {
			alarmaAModificar.setEstaActivada(false);
		} return false;
	} 
}
