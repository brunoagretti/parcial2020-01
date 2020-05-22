package isi.died2020.parcial01.ejercicio1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

public class TestEjercicio1 {


	@Test
	public void test() {
		
		
		EmpleadoEfectivo emp1 = new EmpleadoEfectivo(1, "Juan", "a@y.com", LocalDateTime.now());
		EmpleadoJerarquico emp2 = new EmpleadoJerarquico(2, "Arnaldo", "a@y.com", LocalDateTime.now());
		
		Gastos gasto = new Gastos(1, "", false, 800);
		
		ArrayList<Gastos> listaGastos = new ArrayList<Gastos>();
		listaGastos.add(gasto);
		
		emp1.setGastos(listaGastos);
		emp2.setGastos(listaGastos);
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(emp1);
		empleados.add(emp2);
		
		ArrayList<ReciboSueldo> generado = new ArrayList<ReciboSueldo>();
		ReciboSueldo rs1 = new ReciboSueldo(0, 4, emp1, 1740.0);
		ReciboSueldo rs2 = new ReciboSueldo(1, 4, emp2, 1900.0);
		
		generado = RRHH.calcularSueldos(empleados);
		
		assertTrue(rs1.equals(generado.get(0))); //defini el metodo equals para ReciboSueldo
		assertTrue(rs2.equals(generado.get(1))); //no logro hacer aprobar el test, no me queda mas tiempo


	}

}
