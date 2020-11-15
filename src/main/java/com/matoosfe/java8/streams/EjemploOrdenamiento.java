package com.matoosfe.java8.streams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * 
 *Clase para mostrar el uso de ordenamiento con Streams
 * @author martosfre
 *
 */
public class EjemploOrdenamiento {

	/**
	 * Método para paginar
	 * 
	 * @param estudiantes
	 * @param inicial
	 * @param fin
	 * @return
	 */
	public static List<Estudiante> paginar(List<Estudiante> estudiantes, int inicial, int fin) {
		return estudiantes.stream().filter(e -> e.getCodEst() >= inicial && e.getCodEst() <= fin).collect(toList());
	}

	public static void main(String[] args) {

		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null),
				new Estudiante(2, "Evelyn", null, 12, null));

		System.out.println("\n\nPaginar");
		System.out.println("\n\nOrdernar Estudiantes por Comparable");
		Collections.sort(estudiantes);
		System.out.println("\n\nOrdenar Estudiantes por Comparable utilizando streams");
		List<Estudiante> estOrd = estudiantes.stream().sorted().collect(toList());
		System.out.println("Primeros 3 elementos");
		EjemploOrdenamiento.paginar(estOrd, 1, 4).forEach(System.out::println);
		System.out.println("\n\nSiguientes 3 elementos");
		EjemploOrdenamiento.paginar(estOrd, 5, 7).forEach(System.out::println);

		System.out.println("\n\nOrdenar Estudiantes por Comparator");
		Collections.sort(estudiantes, new NombreComparator());
		estudiantes.forEach(System.out::println);
		System.out.println("\n\nOrdenar Estudiantes por Comparator utilizando Streams");
		estudiantes.stream().sorted(Comparator.comparing(Estudiante::getNombreEst)).forEach(System.out::println);

		System.out.println("\n\nOrdenar estudiantes por nombre al revés");
		estudiantes.stream().sorted(comparing(Estudiante::getNombreEst).reversed()).forEach(System.out::println);
		System.out.println("\n\nOrdenar estudiantes por edad al revés");
		estudiantes.stream().sorted(comparing(Estudiante::getEdadEst).reversed()).forEach(System.out::println);
		System.out.println("\n\nOrdenar estudiantes por edad al revés 2");
		estudiantes.stream().sorted(comparing(Estudiante::getEdadEst, (est1, est2) -> {
			return est2.compareTo(est1);
		})).forEach(System.out::println);
		
		System.out.println("\n\nOrdenar estudiantes y eliminar los duplicados");
		estudiantes.stream().sorted().distinct().forEach(System.out::println);
		
		System.out.println("\n\nOrdenar estudiantes por código, nombre y apellido");
		Comparator<Estudiante> comparatorEst = Comparator.comparing(Estudiante::getNombreEst)
				.thenComparing(comparing(Estudiante::getApellidoEst));
		estudiantes.stream().distinct().sorted(comparatorEst).forEach(System.out::println);
		
		
	}

}
