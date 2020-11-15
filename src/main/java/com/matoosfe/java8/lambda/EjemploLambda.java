/**
 * 
 */
package com.matoosfe.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.java8.Estudiante;
import com.matoosfe.java8.behavior.ControladorEstudiante;
import com.matoosfe.java8.behavior.IMensaje;
import com.matoosfe.java8.behavior.ISuma;

/**
 * Clase para mostrar las utilidades de lambda
 * 
 * @author martosfre
 *
 */
public class EjemploLambda {

	public static void main(String[] args) {
		
		ISuma iacumular = (a, b) -> a + b; // Es la implementación de la interfaz con lambda (sin declaración)
		ISuma iacumularDos = new ISuma() { // Es la implementación de la interfaz con clase anónima

			@Override
			public int sumar(int a, int b) {
				return a + b;
			}
		};
		ISuma iacumularTres = (int a, int b) -> a + b; // Lambda con declaración

		List<Integer> numeros = Arrays.asList(4, 5, 6, 7, 8, 8);
		System.out.println("Total:" + ControladorEstudiante.acumular(numeros, iacumular));
		System.out.println("Total:" + ControladorEstudiante.acumular(numeros, iacumularDos));
		System.out.println("Total:" + ControladorEstudiante.acumular(numeros, iacumularTres));

		IMensaje emiMen = (mensaje) -> System.out.println(mensaje.toUpperCase());
		emiMen.emitirMensaje("Registro guardado correctamente!!!");
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
