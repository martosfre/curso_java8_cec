/**
 * 
 */
package com.matoosfe.java8.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
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
				} catch (ParseException e){
					lista.add("Error Fecha:" + m[0]);
					return false;
				}
			}).filter(EjemploFile::validarLinea).filter(EjemploFile::validarMonto).count();
			long fin = System.currentTimeMillis() - inicio;
			System.out.println("Contador:" + contador);
			System.out.println("Tiempo Duración:" + fin);
			System.out.println(lista);

		} catch (Exception e) {

		}

	}

	public static boolean validarLinea(String[] linea) {
		return true;
	}
	
	
	public static boolean validarMonto(String[] linea) {
		boolean valMont = false;
		
		if(Double.parseDouble(linea[4]) > 30) {
			valMont = true;
		}else {
			lista.add("Error Monto:" + linea[4]);
		}
		return valMont;
	}
}
