package isi.died2020.parcial01.ejercicio1;

public class ReciboSueldo {
	private int numero;
	private int nroMes;
	private Empleado receptor;
	private double total;
	
	public ReciboSueldo(int numero, int nroMes, Empleado receptor, double total) {
		this.setNumero(numero);
		this.setNroMes(nroMes);
		this.setReceptor(receptor);
		this.setTotal(total);
	}
	
	public boolean equals(ReciboSueldo r) {
		return this.numero == r.getNumero() && this.nroMes==r.getNroMes() && this.receptor.dni==r.getReceptor().dni && this.total==r.getTotal();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Empleado getReceptor() {
		return receptor;
	}

	public void setReceptor(Empleado receptor) {
		this.receptor = receptor;
	}

	public int getNroMes() {
		return nroMes;
	}

	public void setNroMes(int nroMes) {
		this.nroMes = nroMes;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
