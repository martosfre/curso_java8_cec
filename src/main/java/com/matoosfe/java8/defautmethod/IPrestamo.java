/**
 * 
 */
package com.matoosfe.java8.defautmethod;

import java.math.BigDecimal;

/**
 * @author martosfre
 *
 */
public interface IPrestamo {

	public boolean solicitarPrestamo(Cliente cliente, BigDecimal monto, int plazoMeses) throws Exception;
	
	default void enviarNotificacion(Prestamo prestamo, Cliente cliente) throws Exception{
		System.out.println("Enviar notificación:" + cliente);
	}
}
