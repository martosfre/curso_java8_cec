/**
 * 
 */
package com.matoosfe.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar las utilidades de lambda
 * 
 * @author martosfre
 *
 */
public class EjemploLambda {

	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null));

		System.out.println("Ordenar Estudiantes por edad de forma ascendente con clase anónimo");
		Comparator<Estudiante> comparatorPorEdad = new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				return o1.getEdadEst().compareTo(o2.getEdadEst());
			}
		};
		Collections.sort(estudiantes, comparatorPorEdad);
		estudiantes.forEach(System.out::println);

		System.out.println("\n\nOrdenar Estudiantes por edad de forma descendente con Lambda ");
		Comparator<Estudiante> comparatoPorEdadDes = (Estudiante o1, Estudiante o2) -> o2.getEdadEst()
				.compareTo(o1.getEdadEst());
		Collections.sort(estudiantes, comparatoPorEdadDes);
		estudiantes.forEach(System.out::println);
		
	}
}
