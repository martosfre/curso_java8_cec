/**
 * 
 */
package com.matoosfe.java8.behavior;

import java.util.Arrays;
import java.util.List;

import com.matoosfe.java8.Estudiante;

/**
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

		System.out.println("\nFiltrar utilizando Lambda");
		List<Estudiante> listaEstCinco = ControladorEstudiante.filtrar(estudiantes,
				(Estudiante est) -> (est.getEdadEst() != null && est.getEdadEst() > 18));
		listaEstCinco.forEach(System.out::println);

		
		ISuma iacumular = (a, b) -> a + b; //Es la implementación de la interfaz con lambda (sin declaración)
		ISuma iacumularDos = new ISuma() { // Es la implementación de la interfaz con clase anónima
			
			@Override
			public int sumar(int a, int b) {
				return a + b;
			}
		};
		
		ISuma iacumularTres = (int a, int b) -> a + b; //Lambda con declaración
		
		List<Integer> numeros = Arrays.asList(4, 5, 6, 7, 8, 8);
		System.out.println("Total:" + ControladorEstudiante.acumular(numeros, iacumular));
		System.out.println("Total:" + ControladorEstudiante.acumular(numeros, iacumularDos));
		
		IMensaje emiMen = (mensaje) -> System.out.println(mensaje.toUpperCase());

	}

}
