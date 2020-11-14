package com.matoosfe.java8.streams;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar como utilizar filtros con Streams
 * 
 * @author martosfre
 *
 */
public class EjemploFiltro {
	/**
	 * Método para filtrar los estudiantes por la edad
	 * 
	 * @param estudiantes
	 * @param edad
	 * @return
	 */
	public static List<Estudiante> filtrarPorEdad(List<Estudiante> estudiantes, int edad) {
		List<Estudiante> listaRet = new ArrayList<Estudiante>();
		for (Estudiante est : estudiantes) {
			if (est.getEdadEst() > edad) {
				listaRet.add(est);
			}
		}
		return listaRet;
	}
	

	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null));

		System.out.println("Filtrar estudiantes por edad");
		List<Estudiante> listaEst = EjemploFiltro.filtrarPorEdad(estudiantes, 18);
		for (Estudiante estudiante : listaEst) {
			System.out.println(estudiante);
		}

		System.out.println("\nFiltrar estudiantes por edad con streams");
		estudiantes.stream().filter(e -> e.getEdadEst() > 18).forEach(System.out::println);

		System.out.println("\nFiltrar estudiantes  por apellido termino");

		// El procesamiento del stream se almacena en una collection a través de la
		// operación terminal collect
		List<Estudiante> listaEstRet = estudiantes.stream().filter(e -> e.getApellidoEst().endsWith("o"))
				.collect(toList());
		listaEstRet.forEach(System.out::println);

		System.out.println("\nFiltrar estudiantes por edad con streams");
		estudiantes.stream()
				.filter(e -> e.getEdadEst() > 18 && e.getNombreEst().startsWith("M"))
				.forEach(System.out::println);

		System.out.println("\n\nLista de Estudiantes sin duplicados");

		Set<Estudiante> estudiantesSinDuplicados = new HashSet<Estudiante>(estudiantes);
		for (Estudiante est : estudiantesSinDuplicados) {
			System.out.println(est);
		}

		System.out.println("\n\nFiltrar estudiantes sin duplicados utilizando streams");
		estudiantes.stream().distinct().forEach(System.out::println);
		System.out.println("\n\nFiltrar estudiantes  mayores a 18 años sin duplicados utilizando streams");
		estudiantes.stream().filter(e -> e.getEdadEst() > 18).distinct().forEach(System.out::println);
		
		System.out.println("\n\nFiltrar estudiantes por nombre y obtener los dos primeros");
		estudiantes.stream().filter(e -> e.getEdadEst() > 18).filter(e -> e.getCodEst() > 4 && e.getCodEst() < 7).limit(3).forEach(System.out::println);
		
		System.out.println("\n\nFiltrar estudiantes por nombre y saltar los dos primeros");
		estudiantes.stream().filter(e -> e.getEdadEst() > 18).skip(2).forEach(System.out::println);
		
		System.out.println("\n\nFiltrar estudiantes por nombre y obtener el primer registro");
		Optional<Estudiante> est = estudiantes.stream().filter(e -> e.getNombreEst().equals("Marlon")).findFirst();
		System.out.println(est.get());
		
		Estudiante estudiante = null;
		Optional<Estudiante> opt = Optional.ofNullable(estudiante);
		System.out.println(opt.get());
	}
}
