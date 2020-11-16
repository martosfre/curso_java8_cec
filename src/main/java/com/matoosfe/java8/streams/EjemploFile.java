/**
 * 
 */
package com.matoosfe.java8.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar como realizar la lectura  y escritura de un archivo y su procesamiento,
 * utilizando streams
 * 
 * @author martosfre
 *
 */
public class EjemploFile {

	public static List<String> lista = new ArrayList<>();

	public static void main(String[] args) {
		String nombreArchivo = "/Users/martosfre/Downloads/Archivo06_SPI1_SANTAROSA_3008.txt";

		try (Stream<String> streamFile = Files.lines(Paths.get(nombreArchivo))) {
			// System.out.println(streamFile.map(linea -> linea.split(",")).mapToDouble(m ->
			// Double.valueOf(m[4])).average());
			long inicio = System.currentTimeMillis();
			long contador = streamFile.parallel().map(linea -> linea.split(",")).filter(m -> {
				try {
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(m[0]);
					return true;
				} catch (ParseException e) {
					lista.add("Error Fecha:" + m[0]);
					return false;
				}
			}).filter(EjemploFile::validarMonto).count();
			long fin = System.currentTimeMillis() - inicio;
			System.out.println("Contador:" + contador);
			System.out.println("Tiempo Duración:" + fin);
			System.out.println(lista);

		} catch (Exception e) {

		}
		System.out.println("\n\nFlat Map");
		try (Stream<String> streamFile = Files.lines(Paths.get(nombreArchivo))) {
			streamFile.map(linea -> linea.split(",")).flatMap(linea -> Arrays.stream(linea)).limit(30).forEach(System.out::println);;
		}catch(Exception e) {
			
		}

		System.out.println("\n\nFiltrar el archivo y capturar los inválidos en otro lista");
		try (Stream<String> streamFile = Files.lines(Paths.get(nombreArchivo))) {
			Map<Boolean, List<String[]>> mapaProcesamiento = streamFile.parallel().map(linea -> linea.split(","))
					.filter(m -> {
						try {
							new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(m[0]);
							return true;
						} catch (ParseException e) {
							return false;
						}
					}).collect(Collectors.partitioningBy(EjemploFile::validarMonto));
			System.out.println("Incorrectos:" + mapaProcesamiento.get(false));
			System.out.println("Correctos:" + mapaProcesamiento.get(true));

		} catch (Exception e) {

		}
		
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
	}

	/**
	 * Método para validar el monnto, que será utilizado como método como referencia
	 * en el filtro
	 * 
	 * @param linea
	 * @return
	 */
	public static boolean validarMonto(String[] linea) {
		boolean valMont = false;

		if (Double.parseDouble(linea[4]) > 30) {
			valMont = true;
		} else {
			lista.add("Error Monto:" + linea[4]);
		}
		return valMont;
	}

}
