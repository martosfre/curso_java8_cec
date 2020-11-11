package com.matoosfe.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar como utilizar filtros con Streams
 * 
 * @author martosfre
 *
 */
public class EjemploFiltro {
	public static List<Estudiante> filtrarPorEdad(List<Estudiante> estudiantes, int edad){
		List<Estudiante> listaRet = new ArrayList<Estudiante>();
		for (Estudiante est : estudiantes) {
			if(est.getEdadEst() > edad) {
				listaRet.add(est);
			}
		}
		return listaRet;
	}
	
	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null));
		
		System.out.println("Filtrar estudiantes por edad");
		List<Estudiante> listaEst = EjemploFiltro.filtrarPorEdad(estudiantes, 18);
		for (Estudiante estudiante : listaEst) {
			System.out.println(estudiante);
		}
		
		System.out.println("\nFiltrar estudiantes por edad con streams");
		estudiantes.stream().filter(e -> e.getEdadEst() > 18).forEach(System.out::println);
		
		System.out.println("\nFiltrar estudiantes por edad con streams");
		estudiantes.stream().filter(e -> e.getEdadEst() > 18).filter(e -> e.getNombreEst().startsWith("M")).forEach(System.out::println);
	}
}
