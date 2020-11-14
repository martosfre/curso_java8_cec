package com.matoosfe.java8.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
				new Estudiante(1, "Marlon", "Bravo", 19, null, new BigDecimal("234.56")),
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

		System.out.println("Máximo:" + estudiantes.stream().map(Estudiante::getPension)
				.mapToDouble(d -> Double.parseDouble(d.toString())).max().getAsDouble());

		System.out.println("\n\nRecuperar el promedio de las pensiones de los estudiantes por Collectors");
		System.out.println("Promedio:" + estudiantes.stream().map(Estudiante::getPension)
				.collect(Collectors.averagingDouble(d -> Double.parseDouble(d.toString()))).doubleValue());

		System.out.println("\n\n");
		DoubleSummaryStatistics dS = estudiantes.stream().map(Estudiante::getPension)
				.collect(Collectors.summarizingDouble(d -> Double.parseDouble(d.toString())));
		System.out.println("Máximo:" + dS.getMax());
		System.out.println("Mínimo:" + dS.getMin());
		System.out.println("Suma:" + dS.getSum());
		System.out.println("Promedio:" + dS.getAverage());

		System.out.println("\n\nIncrementar valor de la pensión más el interés");
		estudiantes.stream().map(Estudiante::getPension).map(p -> p.add(p.multiply(new BigDecimal(0.10)))).limit(4)
				.forEach(System.out::println);

		System.out.println("\n\nIncrementar valor de la pensión más el interés y imprimir los dos resultados");
		estudiantes.stream().map(Estudiante::getPension).map(p -> {
			BigDecimal[] valores = new BigDecimal[2];
			valores[0] = p;
			valores[1] = p.add(p.multiply(new BigDecimal(0.10))).setScale(2, RoundingMode.HALF_UP);
			return valores;
		}).forEach(x -> System.out.println("Pensión:" + x[0] + ", Pensión más interés:" + x[1]));

		System.out.println("\n\nEscribir procesamiento a un archivo");
		File archivoPro = new File("/Users/martosfre/Downloads/procesamiento.txt");
		try (FileWriter escritorDos = new FileWriter(archivoPro)) {
			escritorDos.write("Promedio:" + estudiantes.stream().map(Estudiante::getPension)
					.mapToDouble(d -> Double.parseDouble(d.toString())).average().getAsDouble());
			estudiantes.stream().map(Estudiante::getPension).map(p -> {
				BigDecimal[] valores = new BigDecimal[2];
				valores[0] = p;
				valores[1] = p.add(p.multiply(new BigDecimal(0.10))).setScale(2, RoundingMode.HALF_UP);
				return valores;
			}).map(x -> {
				try {
					escritorDos.write("Pensión:" + x[0] + ", Pensión más interés:" + x[1]);
				} catch (IOException e1) {
					return "Falla";
				}
				return "Procesado";
			}).count();

		} catch (Exception e2) {
			System.out.println("Error escribir archivo:" + e2.getMessage());
		}

		
		
//		
//		
//		Stream<Object> stream = estudiantes.stream().map(Estudiante::getPension).map(p -> {
//			BigDecimal[] valores = new BigDecimal[2];
//			valores[0] = p;
//			valores[1] = p.add(p.multiply(new BigDecimal(0.10))).setScale(2, RoundingMode.HALF_UP);
//			return valores;
//		});
//
//		try (FileWriter escritor = new FileWriter(archivoPro)) {
//			escritor.write("Promedio:" + estudiantes.stream().map(Estudiante::getPension)
//					.mapToDouble(d -> Double.parseDouble(d.toString())).average().getAsDouble());
//			stream.map(x -> {
//				BigDecimal[] valores = (BigDecimal[]) x;
//				String linea = "\nPensión:" + valores[0] + ", Pensión más interés:" + valores[1];
//				try {
//					escritor.write(linea);
//				} catch (IOException e1) {
//					return "Fallo";
//				}
//				return "Ingresado correctamente";
//			}).count();
//
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}

	}
}
