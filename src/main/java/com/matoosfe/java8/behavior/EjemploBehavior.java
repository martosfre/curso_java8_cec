/**
 * 
 */
package com.matoosfe.java8.behavior;

import java.util.Arrays;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar las utilidades del behavior parameterization
 * @author martosfre
 *
 */
public class EjemploBehavior {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Estudiante> estudiantes = Arrays.asList(new Estudiante(1, "Marlon", "Bravo", 19, null),
				new Estudiante(2, "Evelyn", "Naranjo", 12, null), new Estudiante(3, "Marlon", "Carrasco", 24, null),
				new Estudiante(4, "Oscar", "Bravo", 19, null), new Estudiante(5, "Geovanny", "Artes", 26, null),
				new Estudiante(6, "Marlon", "Vizuete", 19, null), new Estudiante(7, "Marco", "Tipán", 11, null));

		System.out.println("Filtrar estudiantes mayores de edad");
		List<Estudiante> listaEst = ControladorEstudiante.filtarPorEdad(estudiantes);
		for (Estudiante estudiante : listaEst) {
			System.out.println(estudiante);
		}

		System.out.println("\nFiltrar estudiants mayores de edad y con nombre que comience M");
		List<Estudiante> listaEstDos = ControladorEstudiante.filtarPorEdadNombre(estudiantes);
		for (Estudiante estudiante : listaEstDos) {
			System.out.println(estudiante);
		}

		System.out.println("\n\nFiltrar utilizando Behavior Parameterization");
		System.out.println("Imprimir directamente");
		ControladorEstudiante.filtrar(estudiantes, new EdadNombreEstudiante()).forEach(System.out::println);
		System.out.println("\nImprimir con un for each");
		List<Estudiante> listaEstTres = ControladorEstudiante.filtrar(estudiantes, new EdadNombreEstudiante());
		for (Estudiante estudiante : listaEstTres) {
			System.out.println(estudiante);
		}

		System.out.println("\n\nFiltrar utilizando Behavior Parametrization con Clases Anónimas");
		List<Estudiante> listaEstCuatro = ControladorEstudiante.filtrar(estudiantes, new PredicadoEstudiante() {

			@Override
			public boolean filtrar(Estudiante est) {
				return est.getApellidoEst().startsWith("T");
			}
		});
		for (Estudiante estudiante : listaEstCuatro) {
			System.out.println(estudiante);
		}

		System.out.println("\nFiltrar utilizando Behavior Parametrization con Lambda");
		List<Estudiante> listaEstCinco = ControladorEstudiante.filtrar(estudiantes,
				(Estudiante est) -> (est.getEdadEst() != null && est.getEdadEst() > 18));
		listaEstCinco.forEach(System.out::println);

	}

}
