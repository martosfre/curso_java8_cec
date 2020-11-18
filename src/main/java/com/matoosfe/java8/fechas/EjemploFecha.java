/**
 * 
 */
package com.matoosfe.java8.fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author martosfre
 *
 */
public class EjemploFecha {

	/**
	 * Método para convertir una fecha
	 * 
	 * @param fecha
	 * @return
	 * @throws ParseException
	 */
	public static Date parsearFecha(String fecha) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFor = formato.parse(fecha);
		return fechaFor;
	}

	/**
	 * Método para formatear una fecha
	 * 
	 * @param fecha
	 * @return
	 */
	public static String formatearFecha(Date fecha, String patron) {
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		String fechaFor = formato.format(fecha);
		return fechaFor;
	}

	public static void main(String[] args) {
		System.out.println("Fecha Actual:" + new Date());
		System.out.println("Fecha Actual con valores:" + new Date(120, 10, 17));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 10, 17);
		System.out.println("\n\nFecha Actual a través del Calendario:" + calendar.getTime());

		Calendar calendarTiempo = Calendar.getInstance();
		calendarTiempo.set(2020, 10, 17, 22, 10);
		System.out.println("\n\nFecha Actual con hora a través del Calendario:" + calendarTiempo.getTime());

		System.out.print("\n\nSumar años a una fecha:");
		calendar.add(Calendar.YEAR, 2);
		System.out.println(calendar.getTime());

		System.out.print("\n\nSumar meses a una fecha:");
		calendar.add(Calendar.MONTH, 2);
		System.out.println(calendar.getTime());

		System.out.print("\n\nSumar dias a una fecha:");
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		System.out.println(calendar.getTime());

		System.out.println("\n\nComparar fecha");
		System.out
				.println(calendar.getTime() + " - " + calendarTiempo.getTime() + ":" + calendar.before(calendarTiempo));
		System.out
				.println(calendar.getTime() + " - " + calendarTiempo.getTime() + ":" + calendar.after(calendarTiempo));

		try {
			System.out.println("\n\nConvertir una fecha: 2020-05-12");
			System.out.println("Fecha:" + EjemploFecha.parsearFecha("2020-05-12"));
		} catch (ParseException e) {
			System.out.println("Fecha Incorrecta");
		}

		System.out.println("\n\nFormatear fecha:" + calendar.getTime());
		System.out.println("Fecha Formateada:" + EjemploFecha.formatearFecha(calendar.getTime(), "yy-MM-dd"));

		System.out.println("Obtener día de la semana:" + calendar.get(Calendar.DAY_OF_WEEK));
	}
	

}
