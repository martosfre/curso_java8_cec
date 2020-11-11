/**
 * 
 */
package com.matoosfe.java8.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import com.matoosfe.java8.Estudiante;

/**
 * @author martosfre
 *
 */
public class EjemploBinaryOperator {
	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(4, 5, 6, 7, 8, 8);
		BinaryOperator<Integer> binInt = ( val1,  val2) -> { int c = 0; c= val1+ val2; return c;};
		BinaryOperator<BigDecimal> binDec = ( val1,  val2) -> { Integer c = 0; c= val1.add(val2).intValue(); return new BigDecimal(c);};
		BinaryOperator<BigDecimal> binDecOpt = ( val1,  val2) -> { return val1.add(val2);};
		
		System.out.println("Ejemolo BinaryOperator");
		System.out.println("Suma:" + binDecOpt.apply(new BigDecimal(6), new BigDecimal(7)));
		
		UnaryOperator<Estudiante> empUni = (Estudiante est) -> {
			est.setEdadEst(23); return est;
		};
		System.out.println("\nEjemplo UnaryOperator");
		Estudiante est = new Estudiante(1, "Marlon", "Bravo", 19, null);
		System.out.println(est);
		System.out.println(empUni.apply(est));
	}
}
