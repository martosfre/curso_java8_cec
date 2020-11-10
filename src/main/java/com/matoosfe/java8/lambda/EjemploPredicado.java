/**
 * 
 */
package com.matoosfe.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.matoosfe.java8.Estudiante;

/**
 * @author martosfre
 *
 */
public class EjemploPredicado {

	/**
	 * Método para filtrar elementos de una colección a través de un predicado
	 * @param <T>
	 * @param lista
	 * @param pre
	 * @return
	 */
	public static <T> List<T> filtrar(List<T> lista, Predicate<T> pre) {
		List<T> resultados = new ArrayList<T>();
		for (T t : lista) {
			if (pre.test(t)) {
				resultados.add(t);
			}
		}
		return resultados;
	}

	public static void main(String[] args) {
		System.out.println("Imprimir Archivos");
		List<String> archivos = Arrays.asList("trabajo.txt", "horizonte.jpg", "documento.rtf");
		Predicate<String> preTipTxt = (String s) -> s.endsWith(".txt");
		EjemploPredicado.filtrar(archivos, preTipTxt).forEach(System.out::println);
		
		System.out.println("\n\nImprimir Estudiantes");
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null));
		
		EjemploPredicado.filtrar(estudiantes, (est) -> est.getEdadEst() > 18).forEach(System.out::println);
		
		
	}
}
