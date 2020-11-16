/**
 * 
 */
package com.matoosfe.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Clase para mostrar el uso de la operación flatMap en los streams
 * 
 * @author martosfre
 *
 */
public class EjemploFlatMap {

	public static void main(String[] args) {
		String[][] nombres = new String[][] { { "Marco", "Luis" }, { "Cris", "Wilma" }, { "Mateo", "Fabián" } };

		System.out.println("Imprimir los nombres que terminen en o (no devuelve nada");
		Stream<String[]> stNomUno = Arrays.stream(nombres);
		stNomUno.filter(n -> n.toString().endsWith("o")).forEach(System.out::println);

		System.out.println("Imprimir los nombres que terminen en o con posición arreglo");
		Stream<String[]> stNom = Arrays.stream(nombres);
		stNom.filter(n -> n[0].toString().endsWith("o")).forEach(System.out::println);

		System.out.println("Imprimir los nombres que terminen en o con flatMap");
		Stream<String> nombresSt = Arrays.stream(nombres).flatMap(n -> Arrays.stream(n));
		nombresSt.filter(n -> n.endsWith("o")).forEach(System.out::println);
		
		System.out.println("\n\nArreglo bidimensional convertido en un arreglo lineal");
		System.out.println("Valores:" + nombres[0] + "," + nombres[1] + "," + nombres[2]);
		Arrays.stream(nombres).flatMap(n -> Arrays.stream(n)).forEach(System.out::println);
	}

}
