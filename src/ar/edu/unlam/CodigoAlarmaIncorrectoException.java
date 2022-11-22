package ar.edu.unlam;

public class CodigoAlarmaIncorrectoException extends Exception {
	
	public CodigoAlarmaIncorrectoException() {
		super("El código que ha ingresado es incorrecto. Intente nuevamente.");
		
	}

}
