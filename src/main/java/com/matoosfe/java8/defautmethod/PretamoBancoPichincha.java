/**
 * 
 */
package com.matoosfe.java8.defautmethod;

import java.math.BigDecimal;

/**
 * @author martosfre
 *
 */
public class PretamoBancoPichincha implements IPrestamo {

	@Override
	public boolean solicitarPrestamo(Cliente cliente, BigDecimal monto, int plazoMeses) throws Exception {
		enviarNotificacion(null, null);
		return false;
	}
	
	

}
