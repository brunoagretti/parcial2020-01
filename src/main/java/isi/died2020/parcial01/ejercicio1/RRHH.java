package isi.died2020.parcial01.ejercicio1;

import java.util.ArrayList;
import java.util.Calendar;

public class RRHH {
	
	
	public static int numeroRecibo = 0;
	public static double sueldoBasico = 2000; //dolares
	
	public static ArrayList<ReciboSueldo> calcularSueldos(ArrayList<Empleado> empleados){
		ArrayList<ReciboSueldo> sueldos = new ArrayList<ReciboSueldo>();
		
		empleados.stream()
				 .forEach(e -> {
					 sueldos.add(new 
							 ReciboSueldo(numeroRecibo++, Calendar.getInstance().get(Calendar.MONTH), e, e.calcularSueldo(sueldoBasico)));				 
				 });
		
		
		return sueldos;
		
	}
	
	
}
