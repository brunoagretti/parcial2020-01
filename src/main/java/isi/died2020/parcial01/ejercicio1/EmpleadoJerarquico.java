package isi.died2020.parcial01.ejercicio1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class EmpleadoJerarquico extends Empleado {
	
	
	public ArrayList<Gastos> getGastos() {
		return gastos;
	}


	public void setGastos(ArrayList<Gastos> gastos) {
		this.gastos = gastos;
	}


	public EmpleadoJerarquico(int dni, String nombre, String correo, LocalDateTime fechaContratacion) {
		super(dni, nombre, correo, fechaContratacion);
		gastos = null;
	
	}


	private ArrayList<Gastos> gastos;
	
	public double calcularSueldo(double basico) {
			
			double bono = 0;
			double gastos = 0;
			double extra = 0;
			
			if(Calendar.getInstance().get(Calendar.MONTH)==Calendar.DECEMBER || 
			   Calendar.getInstance().get(Calendar.MONTH)==Calendar.JUNE) {
				bono += 0.5*basico;
				gastos = this.calcularGastos(true);
				extra = 0.1 * this.gastos.stream()
							       .filter(g -> g.total > 1000)
							       .mapToDouble(g -> g.total)
							       .sum();							
			}

			
			return basico*0.95 + gastos + bono + extra;
		}
	
		
		public double calcularGastos(boolean hayBono) {
			
			double gastos = this.gastos.stream()
								.filter(g -> g.aprobado)
								.mapToDouble(t -> t.total)
								.sum();
			return gastos;
		}
}
