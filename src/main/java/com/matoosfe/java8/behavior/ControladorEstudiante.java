/**
 * 
 */
package com.matoosfe.java8.behavior;

import java.util.ArrayList;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para manejar las operaciones de estudiante
 * 
 * @author martosfre
 *
 */
public class ControladorEstudiante {

	/**
	 * Método para filtrar los estudiantes mayores de 18 años
	 * 
	 * @param estudiantes
	 * @return
	 */
	public static List<Estudiante> filtarPorEdad(List<Estudiante> estudiantes) {
		List<Estudiante> estudiantesRet = new ArrayList<>();
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getEdadEst() > 18) {
				estudiantesRet.add(estudiante);
			}
		}
		return estudiantesRet;
	}

	/**
	 * Método para filtrar los estudiantes mayores de 18 años y nombre comience con
	 * M
	 * 
	 * @param estudiantes
	 * @return
	 */
	public static List<Estudiante> filtarPorEdadNombre(List<Estudiante> estudiantes) {
		List<Estudiante> estudiantesRet = new ArrayList<>();
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getEdadEst() > 18 && estudiante.getNombreEst().startsWith("M")) {
				estudiantesRet.add(estudiante);
			}
		}
		return estudiantesRet;
	}

	/**
	 * Método para filtrar estudiantes genérico
	 * 
	 * @param estudiantes
	 * @param pre
	 * @return
	 */
	public static List<Estudiante> filtrar(List<Estudiante> estudiantes, PredicadoEstudiante pre) {
		List<Estudiante> estudiantesRet = new ArrayList<>();
		for (Estudiante estudiante : estudiantes) {
			if (pre.filtrar(estudiante)) {
				estudiantesRet.add(estudiante);
			}
		}
		return estudiantesRet;
	}

	/**
	 * Método para acumular los valores de una lista y sumales cinco
	 * @param numeroes
	 * @param suma
	 * @return
	 */
	public static int acumular(List<Integer> numeroes, ISuma suma) {
		int total = 0;
		for (Integer i : numeroes) {
			total += suma.sumar(5, i);
		}
		return total;
	}
}
