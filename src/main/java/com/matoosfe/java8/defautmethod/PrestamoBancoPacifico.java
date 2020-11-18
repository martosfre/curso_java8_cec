/**
 * 
 */
package com.matoosfe.java8.defautmethod;

import java.math.BigDecimal;

/**
 * @author martosfre
 *
 */
public class PrestamoBancoPacifico implements IPrestamo {

	@Override
	public boolean solicitarPrestamo(Cliente cliente, BigDecimal monto, int plazoMeses) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enviarNotificacion(Prestamo prestamo, Cliente cliente) throws Exception {
		System.out.println("Enviar:" + cliente);
	}

}
