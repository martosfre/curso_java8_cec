package com.matoosfe.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * 
 * @author martosfre
 *
 */
public class EjemploReduce {
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

		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Operación reduce con amulador");
		System.out.print("Total Sumá de valores (Binany Operators):");
		Arrays.stream(numeros).reduce((n1, n2) -> n1 + n2).ifPresent(n -> System.out.println(n));
		System.out.print("Total Sumá de valores (Método Referencial API):");
		Arrays.stream(numeros).reduce(Integer::sum).ifPresent(n -> System.out.println(n));
		System.out.print("Total Sumá de valores (Método Referencial propio):");
		System.out.println(Arrays.stream(numeros).reduce(EjemploReduce::sumar).getAsInt());

		System.out.println("\n\nApellidos Estudiantes:" + estudiantes.stream().sorted().map(Estudiante::getApellidoEst)
				.reduce((s1, s2) -> s1.concat(",").concat(s2)).get());

		System.out.println("\n\nOperación reduce con Acumulador y Identity");
		System.out.println("Apellidos Estudiantes" + estudiantes.stream().sorted().map(Estudiante::getApellidoEst)
				.reduce("->Periodo 2020:", (s1, s2) -> s1.concat(",").concat(s2)));

		System.out.println("\n\nOperacion reduce con combinator");
		List<Integer> numerosDos = Arrays.asList(1, 2, 3, 4);
		// TODO Revisar operadores
		int valor = numerosDos.stream().reduce(2 , (n1, n2) -> n1 + n2, (a, b) -> a + b).intValue();
		System.out.println("Valor:" + valor);
		int valorDos = numerosDos.parallelStream().reduce(2, (n1, n2) -> n1 + n2, (a, b) -> a + b).intValue();
		System.out.println("Valor Dos :" + valorDos);

		System.out.println(estudiantes.parallelStream().map(Estudiante::getPension).reduce("Total:" + estudiantes.stream().count() + "->",
				(p1, p2) -> p1 + "-" + p2, (pp1, pp2) -> pp1.concat(":").concat(pp2)));

	}

	public static int sumar(int n1, int n2) {
		return n1 + n2;
	}
}
