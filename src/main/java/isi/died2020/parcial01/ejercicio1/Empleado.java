package isi.died2020.parcial01.ejercicio1;

import java.time.LocalDateTime;

public abstract class Empleado {
	
	public Empleado(int dni, String nombre, String correo, LocalDateTime fechaContratacion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
		this.fechaContratacion = fechaContratacion;
	}
	protected int dni;
	protected String nombre;
	protected String correo;
	protected LocalDateTime fechaContratacion;
	
	
	public abstract double calcularSueldo(double basico);
	public abstract double calcularGastos(boolean hayBono);
	
}
