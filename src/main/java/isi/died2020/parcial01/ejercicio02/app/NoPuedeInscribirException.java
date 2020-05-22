package isi.died2020.parcial01.ejercicio02.app;

public class NoPuedeInscribirException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 420L;
	public NoPuedeInscribirException(String errorString) {
		super(errorString);
	}
}
