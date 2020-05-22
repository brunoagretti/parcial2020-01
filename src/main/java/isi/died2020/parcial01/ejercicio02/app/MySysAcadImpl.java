package isi.died2020.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import isi.died2020.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died2020.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died2020.parcial01.ejercicio02.dominio.*;
import isi.died2020.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws NoPuedeInscribirException {
		if(!m.getDocentes().contains(d)) {
			throw new NoPuedeInscribirException("El docente " + d.getNombre() +" no pertenece a \"" + m.getNombre() + "\""); //creo que usando la \ hago que se puedan poner las " en el string que voy a retornar
		}
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		
		try {
			DB.guardar(insc);
		} catch (BaseDeDatosExcepcion e) {
			throw new NoPuedeInscribirException("Ha sucedido un error en la inscripcion: " + e);
		} 
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	
	public void registrarNota(Examen e, int nota) { //supongo que la nota final de las materias es un entero
		e.setNota(nota);
		if(nota>5) {
			e.getAlumno().getMateriasCursadas().stream()
											   .filter(i -> i.getMateria().equals(e.getMateria()))
											   .forEach(m -> m.setEstado(Estado.PROMOCIONADO));
		}
		
		
		
	}


	@Override
	public List<Materia> materiasAprobadas(Alumno m) {
		
		return m.getExamenes().stream()
				.filter(e -> e.getNota()>5)
				.sorted((e1,e2)-> e1.getNota().compareTo(e2.getNota()))
				.map(e -> e.getMateria())
				.collect(Collectors.toList());

	}
	

}
