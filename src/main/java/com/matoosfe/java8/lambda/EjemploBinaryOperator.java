/**
 * 
 */
package com.matoosfe.java8.lambda;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import com.matoosfe.java8.Estudiante;

/**
 * Clase para mostrar la Functional Interface Bynary Operator
 * 
 * @author martosfre
 *
 */
public class EjemploBinaryOperator {
	public static void main(String[] args) {
		BinaryOperator<Integer> binInt = (val1, val2) -> {
			int c = 0;
			c = val1 + val2;
			return c;
		};
		BinaryOperator<BigDecimal> binDec = (val1, val2) -> {
			Integer c = 0;
			c = val1.add(val2).intValue();
			return new BigDecimal(c);
		};
		BinaryOperator<BigDecimal> binDecOpt = (val1, val2) -> {
			return val1.add(val2);
		};

		System.out.println("Ejemplo BinaryOperator");
		System.out.println("Suma enteros:" + binInt.apply(67, 89));
		System.out.println("Suma decimales:" + binDec.apply(new BigDecimal("6.7"), new BigDecimal("7.6")));
		System.out.println("Suma decimales:" + binDecOpt.apply(new BigDecimal(6.7), new BigDecimal(7.6)));

		UnaryOperator<Estudiante> empUni = (Estudiante est) -> {
			est.setEdadEst(23);
			return est;
		};
		System.out.println("\nEjemplo UnaryOperator");
		Estudiante est = new Estudiante(1, "Marlon", "Bravo", 19, null);
		System.out.println(est);
		System.out.println(empUni.apply(est));
	}
}
