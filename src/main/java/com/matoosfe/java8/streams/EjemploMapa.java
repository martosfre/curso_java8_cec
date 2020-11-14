package com.matoosfe.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar el uso de mapa
 * 
 * @author martosfre
 *
 */
public class EjemploMapa {

	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(
				new Estudiante(1, "Marlon", "Bravo", 19, null, new BigDecimal(234.56)),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null, new BigDecimal(456.45)),
				new Estudiante(3, "Marlon", "Carrasco", 24, null, new BigDecimal(234.78)),
				new Estudiante(4, "Oscar", "Bravo", 19, null, new BigDecimal(1000.45)),
				new Estudiante(5, "Geovanny", "Artes", 26, null, new BigDecimal(678.45)),
				new Estudiante(6, "Marlon", "Vizuete", 19, null, new BigDecimal(123)),
				new Estudiante(7, "Marco", "Tipán", 11, null, new BigDecimal(345)),
				new Estudiante(6, "Marlon", "Vizuete", 19, null, new BigDecimal(2345)),
				new Estudiante(7, "Marco", "Tipán", 11, null, new BigDecimal(1244)),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null, new BigDecimal(2000)));

		estudiantes.stream().filter(e -> e.getApellidoEst() != null).forEach(System.out::println);

		System.out.println(
				"\n\nRecuperar los apellidos de los estudiantes ordenados en forma descendente y quitados duplicados");
		estudiantes.stream().sorted(Comparator.comparing(Estudiante::getApellidoEst).reversed())
				.map(Estudiante::getApellidoEst).distinct().forEach(System.out::println);

		System.out.println("\n\nRecuperar el promedio de las pensiones de los estudiantes");
		System.out.println("Promedio:" + estudiantes.stream().map(Estudiante::getPension)
				.mapToDouble(d -> Double.parseDouble(d.toString())).average().getAsDouble());
		
		
	}
}
