package isi.died2020.parcial01.ejercicio1;

public class Gastos {
	protected int comprobanteNro;
	protected String descripcion;
	protected boolean aprobado;
	protected double total;
	
	public Gastos(int comprobanteNro, String descripcion, boolean aprobado, double total) {

		this.comprobanteNro = comprobanteNro;
		this.descripcion = descripcion;
		this.aprobado = aprobado;
		this.total = total;
	}
	
}
