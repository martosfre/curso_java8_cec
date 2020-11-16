package com.matoosfe.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * 
 * @author martosfre
 *
 */
public class EjemploMatching {
	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(
				new Estudiante(1, "Marlon", "Bravo", 19, null, new BigDecimal("50")),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null, new BigDecimal(456.45)),
				new Estudiante(3, "Marlon", "Carrasco", 24, null, new BigDecimal(234.78)),
				new Estudiante(4, "Oscar", "Bravo", 19, null, new BigDecimal(1000.45)),
				new Estudiante(5, "Geovanny", "Artes", 26, null, new BigDecimal(678.45)),
				new Estudiante(6, "Marlon", "Vizuete", 19, null, new BigDecimal(123)),
				new Estudiante(7, "Marco", "Tipán", 11, null, new BigDecimal(345)),
				new Estudiante(6, "Marlon", "Vizuete", 19, null, new BigDecimal(210)),
				new Estudiante(7, "Marco", "Tipán", 11, null, new BigDecimal(1)),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null, new BigDecimal(2000)));

		System.out.println("\n\nEncontrar el primer estudiante con pensión mayor a 1000, ordenado e iterado en un for");
		long inicio = System.currentTimeMillis();
		Collections.sort(estudiantes, new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				return o1.getPension().compareTo(o2.getPension());
			}
		});
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getPension().doubleValue() > 1000) {
				System.out.println(estudiante);
				break;
			}
		}
		System.out.println("Duración:" + (System.currentTimeMillis() - inicio));
		
		System.out.println("\n\nEncontrar el primer estudiante con pensión mayor a 1000, utilizando findFirst en streams");
		inicio = System.currentTimeMillis();
		System.out.println("Estudiante First:"
				+ estudiantes.stream().filter(e -> e.getPension().doubleValue() > 1000).findFirst().orElse(null));
		System.out.println("Duración:" + (System.currentTimeMillis() - inicio));
		
		inicio = System.currentTimeMillis();
		System.out.println("Estudiante First Parallel:"
				+ estudiantes.parallelStream().filter(e -> e.getPension().doubleValue() > 1000).findFirst().orElse(null));
		System.out.println("Duración:" + (System.currentTimeMillis() - inicio));

		System.out.println("\n\nConocer si al menos un estudiante tiene pensión mayor que 1000");
		estudiantes.stream().filter(e -> e.getPension().doubleValue() > 1000).findAny()
				.ifPresent(s -> System.out.println(s));
		System.out.println("Estudiante Any:"
				+ estudiantes.stream().filter(e -> e.getPension().doubleValue() > 1000).findAny().orElse(null));
		
		
		System.out.println("\n\nVerificar una condición para todo el conjunto de elementos");
		boolean verAll = estudiantes.stream().allMatch(e -> e.getPension().doubleValue() > 10);
		System.out.println("Todos los estudiantes tienen una pensión mayor que cero:" + verAll);
		boolean ninguno = estudiantes.stream().noneMatch(e -> e.getPension().doubleValue() < 0);
		System.out.println("Todos los estudiantes tienen una pensión mayor que cero:" + ninguno);

	}
}
