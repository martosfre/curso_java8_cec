/**
 * 
 */
package com.matoosfe.java8.streams;

import java.util.Comparator;

import com.matoosfe.java8.Estudiante;

/**
 * Clase que representa el Comparator de Estudiante por nombre utilizado para el
 * ordenamiento
 * 
 * @author martosfre
 *
 */
public class NombreComparator implements Comparator<Estudiante> {

	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		return o1.getNombreEst().compareTo(o2.getNombreEst());
	}

}
