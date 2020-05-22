package isi.died2020.parcial01.ejercicio1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class EmpleadoEfectivo extends Empleado {
	
	public ArrayList<Gastos> getGastos() {
		return gastos;
	}


	public void setGastos(ArrayList<Gastos> gastos) {
		this.gastos = gastos;
	}


	public EmpleadoEfectivo(int dni, String nombre, String correo, LocalDateTime fechaContratacion) {
		super(dni, nombre, correo, fechaContratacion);
		gastos = null;
	}


	private ArrayList<Gastos> gastos;


	public double calcularSueldo(double basico) {
		
		double bono = 0;
		boolean hayBono=false;
		double extra = 0;
		
		if(Calendar.getInstance().get(Calendar.MONTH)==Calendar.DECEMBER || 
		   Calendar.getInstance().get(Calendar.MONTH)==Calendar.JUNE) {
			bono += 0.5*basico;
			hayBono=true;
			extra = 0.1 * this.gastos.stream()
				       .filter(g -> g.total > 1000)
				       .mapToDouble(g -> g.total)
				       .sum();	
			
		}
		double gastos = this.calcularGastos(hayBono);
		
		return basico*0.87 + gastos + bono + extra;
	}

	
	public double calcularGastos(boolean hayBono) {
		double monto;
		if(hayBono) {
			monto = this.gastos.stream()
				       			       .mapToDouble(g -> g.total)
				       			       .sum();
		}else {
			monto = this.gastos.stream()
										.filter(g -> g.aprobado)
										.mapToDouble(t -> t.total)
										.sum();
		}
		return monto;
	}
}
