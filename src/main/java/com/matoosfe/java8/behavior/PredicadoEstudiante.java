/**
 * 
 */
package com.matoosfe.java8.behavior;

import com.matoosfe.java8.Estudiante;

/**
 * @author martosfre
 *
 */
@FunctionalInterface
public interface PredicadoEstudiante {

	public boolean filtrar(Estudiante est);
}
