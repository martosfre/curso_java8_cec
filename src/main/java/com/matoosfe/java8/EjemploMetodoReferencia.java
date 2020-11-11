/**
 * 
 */
package com.matoosfe.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author martosfre
 *
 */
public class EjemploMetodoReferencia {
	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null));
		
		System.out.println(estudiantes);
		
		System.out.println("Impresión Estudiantes por Lambda");
		estudiantes.forEach(e -> System.out.println(e));
		System.out.println("\n\nImpresión Estudiantes por Método Referencia (static)");
		estudiantes.forEach(System.out::println);
		
		System.out.println("\nOrdenamiento utilizando Método por Referencia  - Instancia");
		estudiantes.stream().sorted(Comparator.comparing(Estudiante::getApellidoEst)).forEach(System.out::println);
		
	}
}
