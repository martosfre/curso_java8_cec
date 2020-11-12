/**
 * 
 */
package com.matoosfe.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.matoosfe.java8.Estudiante;

/**
 * 
 * @author martosfre
 *
 */
public class EjemploParallel {

	/**
	 * Método para imprimir números en un rango generado
	 * 
	 * @param min
	 * @param max
	 */
	public static void imprimirNúmeros(int min, int max, boolean modo) {
		long tiempoInicial = System.currentTimeMillis();
		if (!modo) {
			System.out.println("Normal");
			IntStream rangoNumeros = IntStream.range(min, max);
			rangoNumeros.forEach(i -> System.out.println("Hilo:" + Thread.currentThread() + ":" + i));
		} else {
			System.out.println("Parallel");
			IntStream rangoNumerosDos = IntStream.range(min, max);
			rangoNumerosDos.parallel().forEach(i -> System.out.println("Hilo:" + Thread.currentThread() + ":" + i));
		}
		long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("Tiempo Duración:" + tiempoFinal);
	}
	/**
	 * Método para imprimir números en un rango determinado
	 * 
	 * @param min
	 * @param max
	 */
	public static void imprimirNúmeros(int min, int max, int[] numeros, boolean modo) {
		long tiempoInicial = System.currentTimeMillis();
		if (!modo) {
			System.out.println("Normal");
			IntStream rangoNumeros = IntStream.range(min, max);
			rangoNumeros.forEach(i -> System.out.println("Hilo:" + Thread.currentThread() + ":" + i));
		} else {
			System.out.println("Parallel");
			IntStream rangoNumerosDos = IntStream.range(min, max);
			rangoNumerosDos.parallel().forEach(i -> System.out.println("Hilo:" + Thread.currentThread() + ":" + i));
		}
		long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("Tiempo Duración:" + tiempoFinal);
	}
	
	public static void contarNumeros(int min, int max, boolean modo) {
		long tiempoInicial = System.currentTimeMillis();
		if (!modo) {
			System.out.println("Normal");
			IntStream rangoNumeros = IntStream.range(min, max);
			System.out.println("Count:" + rangoNumeros.average());
		} else {
			System.out.println("Parallel");
			IntStream rangoNumerosDos = IntStream.range(min, max);
			System.out.println("Count:" + rangoNumerosDos.parallel().average());
		}
		long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("Tiempo Duración:" + tiempoFinal);
	}


	/**
	 * Método para imprimir los objetos de una lista
	 * 
	 * @param estudiantes
	 */
	public static void imprimirObjetos(List<Estudiante> estudiantes) {
		System.out.println("Normal");
		long tiempoInicial = System.currentTimeMillis();
		estudiantes.stream().forEach(e -> System.out.println("Hilo:" + Thread.currentThread() + ":" + e));
		long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("Tiempo Duración:" + tiempoFinal);

		System.out.println("\n\n............................");
		System.out.println("Parallel");
		tiempoInicial = System.currentTimeMillis();
		estudiantes.parallelStream().forEach(e -> System.out.println("Hilo:" + Thread.currentThread() + ":" + e));
		tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("Tiempo Duración:" + tiempoFinal);

	}

	public static void main(String[] args) {
		System.out.println("Imprimir números en una secuencia utilizando los modos stream y parallel");
//		EjemploParallel.imprimirNúmeros(1, 100, true);
		EjemploParallel.imprimirNúmeros(1, 100, false);
		System.out.println("\n\n For Normal");
		IntStream rangoNumeros = IntStream.range(1, 100);
		int[] numeros = rangoNumeros.toArray();
		long tiempoInicial = System.currentTimeMillis();
		for (int i : numeros) {
			System.out.println("Hilo:" + Thread.currentThread() + ":" + i);
		}
		long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
		System.out.println("Tiempo Duración:" + tiempoFinal);
		
		System.out.println("Contar número en una secuencia utiliznado los modos stream y parallel");
		EjemploParallel.contarNumeros(1, 1000000, false);
		EjemploParallel.contarNumeros(1, 1000000, true);

		System.out.println("\n\nImprimir estudiantes utilizando los modos stream y parallel");
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null),
				new Estudiante(2, "Evelyn", null, 12, null));
		EjemploParallel.imprimirObjetos(estudiantes);

	}

}
