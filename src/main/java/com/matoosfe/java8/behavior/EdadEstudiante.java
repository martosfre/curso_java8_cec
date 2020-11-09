/**
 * 
 */
package com.matoosfe.java8.behavior;

import com.matoosfe.java8.Estudiante;

/**
 * @author martosfre
 *
 */
public class EdadEstudiante implements PredicadoEstudiante{

	@Override
	public boolean filtrar(Estudiante est) {
		return est.getEdadEst() > 18;
	}

}
