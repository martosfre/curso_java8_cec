/**
 * 
 */
package com.matoosfe.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author martosfre
 *
 */
public class EjemploConsumer {

	/**
	 * Método para ejecutar acciones sobre los elementos de una colección a través
	 * de un Consumidor
	 * 
	 * @param <T>
	 * @param lista
	 * @param con
	 */
	public static <T> void ejecutar(List<T> lista, Consumer<T> con) {
		for (T t : lista) {
			con.accept(t);
		}
	}

	public static void main(String[] args) {

		List<String> archivos = Arrays.asList("trabajo.txt", "horizonte.jpg", "documento.rtf");
		EjemploConsumer.ejecutar(archivos, s -> System.out.println(s.toUpperCase()));
	}
}
