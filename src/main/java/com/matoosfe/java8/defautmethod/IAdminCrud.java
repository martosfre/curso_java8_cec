/**
 * 
 */
package com.matoosfe.java8.defautmethod;

import java.util.List;

/**
 * @author martosfre
 *
 */
public interface IAdminCrud {
	
	/**
	 * Definición de método para guardar
	 * @param entidad
	 * @return
	 * @throws Exception
	 */
	public String guardar(Object entidad) throws Exception;
	
	/**
	 * Definición de método para actualizar
	 * @param entidad
	 * @return
	 * @throws Exception
	 */
	public String actualizar(Object entidad) throws Exception;

	/**
	 * Definición de método para eliminar
	 * @param entidad
	 * @return
	 * @throws Exception
	 */
	public String eliminar(Object entidad) throws Exception;
	
	/**
	 * Definición de método para consultar por id
	 * @param tabla
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object consultarPorId(Class<?> tabla, Integer id) throws Exception;
	
	
	/**
	 * 
	 * Dfinición de método para consultar todos
	 * @param tabla
	 * @return
	 * @throws Exception
	 */
	public List<?> consultarTodos(Class<?> tabla) throws Exception;
	
	
}
