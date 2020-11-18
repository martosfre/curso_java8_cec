/**
 * 
 */
package com.matoosfe.java8.streams;

import java.math.BigDecimal;
import java.util.Optional;

import com.matoosfe.java8.Direccion;
import com.matoosfe.java8.Estudiante;

/**
 * @author martosfre
 *
 */
public class EjemploOptional {
	/**
	 * Método para crear un objeto Optional
	 * 
	 * @param est
	 * @param opc
	 * @return
	 */
	public static Optional<Estudiante> crearOptional(Estudiante est, int opc) {
		Optional<Estudiante> optEst = null;
		if (opc == 1) {
			optEst = Optional.of(est);
		} else if (opc == 2) {
			optEst = Optional.ofNullable(est);
		} else {
			optEst = Optional.empty();
		}
		return optEst;
	}

	/**
	 * Método para verificar los nulos antes de 8
	 * 
	 * @param est
	 */
	public static void verificarNulos(Estudiante est) {
		if (est != null) {
			if (est.getDireccion() != null) {
				System.out.println("Dirección Estudiante:" + est.getDireccion().getNombreDir());
			} else {
				System.out.println("Estudiante no tiene una dirección registrada");
			}
		} else {
			System.out.println("Estudiante no registrado");
		}
	}

	public static void verificarNulos8(Estudiante est) {
		System.out.println("Dirección Estudiante:"
				+ Optional.ofNullable(est).map(Estudiante::getDireccion).map(Direccion::getNombreDir));

		System.out.println("Encontrado:"
				+ Optional.ofNullable(est).map(Estudiante::getDireccion).map(Direccion::getNombreDir).isPresent());

		Optional.ofNullable(est).map(Estudiante::getDireccion).map(Direccion::getNombreDir)
				.ifPresent(v -> System.out.println("Dirección Estudiante:" + v));

		System.out.println(Optional.ofNullable(est).map(Estudiante::getDireccion).map(Direccion::getNombreDir)
				.orElse("Estudiante no tiene una dirección registrada"));
		System.out.println(
				Optional.ofNullable(est).map(Estudiante::getDireccion).map(Direccion::getNombreDir).orElseGet(() -> {
					return "algo";
				}));
	}
	
	public static void verificarNulos8Exception(Estudiante est) throws Exception {
		Optional.ofNullable(est).map(Estudiante::getDireccion).map(Direccion::getNombreDir).orElseThrow(() -> new Exception("Error"));
	}

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante(1, "Marlon", "Bravo", 19, null, new BigDecimal("50"));
		Estudiante e2 = null;
		Estudiante e3 = new Estudiante(100, "Aurelio", "Espinoza", 37, null, new BigDecimal(569), null);
		Estudiante e4 = new Estudiante(100, "Aurelio", "Espinoza", 37, null, new BigDecimal(569),
				new Direccion(101, "Santo Domingo"));

		System.out.println("Estudiante 1:" + e1.getNombreEst());
//		System.out.println("Estudiante 2:" + e2.getNombreEst());

		System.out.println("\n\nCrear un objeto Optional con un objeto con valor");
		System.out.println("Estudiante:" + EjemploOptional.crearOptional(e1, 1));
		System.out.println("Estudiante:" + EjemploOptional.crearOptional(e1, 2));
		System.out.println("Estudiante:" + EjemploOptional.crearOptional(e1, 3));

		System.out.println("\n\nCrear un objeto Optional con un objeto nulo");
//		System.out.println("Estudiante:" + EjemploOptional.crearOptional(e2, 1)); //Throw a exception antes de operar
		System.out.println("Estudiante:" + EjemploOptional.crearOptional(e2, 2));

		System.out.println("Estudiant:" + EjemploOptional.crearOptional(e1, 1).get());

		EjemploOptional.crearOptional(e1, 2).ifPresent(s -> System.out.println("Objeto no nulo:" + s.getNombreEst()));
		EjemploOptional.crearOptional(e2, 2).ifPresent(s -> System.out.println(s.getNombreEst()));

		System.out.println("\n\nObtener dirección del Estudiante, verificando nulos:");
		EjemploOptional.verificarNulos(e3);
		EjemploOptional.verificarNulos8(null);

		System.out.println("\n\nObtener dirección del Estudiante, verificando nulos 2:");
		EjemploOptional.verificarNulos8(e4);
		
		System.out.println("\n\nObtener dirección del Estudiante, verificando nulos exception:");
		try {
			EjemploOptional.verificarNulos8Exception(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n\nFilter in Optional");
		EjemploOptional.crearOptional(e4, 1).filter(e -> e.getDireccion().getIdDir() > 100).get();
	}

}
