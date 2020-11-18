/**
 * 
 */
package com.matoosfe.java8.fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author martosfre
 *
 */
public class EjemploFecha8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Fecha Actual:" + fechaActual);

		LocalTime tiempoActual = LocalTime.now();
		System.out.println("Tiempo Actual:" + tiempoActual);

		LocalDate fechaParam = LocalDate.of(2023, 2, 17);
		System.out.println("Fecha Param:" + fechaParam);

		LocalDate fechaPar = LocalDate.parse("2023-11-12");
		System.out.println("Fecha Parseada:" + fechaPar);

		System.out.println("Sumar años fecha:" + fechaActual.plusYears(2));
		System.out.println("Sumar meses fecha:" + fechaActual.plusMonths(2));
		System.out.println("Sumar dias fecha:" + fechaActual.plusDays(14));
		
		System.out.println("Dia de la semana:" + fechaActual.getDayOfWeek().getValue());
		
		System.out.println("Comparar fechas:" + fechaActual.isAfter(fechaParam));
		System.out.println("Comparar fechas:" + fechaActual.isBefore(fechaParam));
		
		Period tiempoFechas = Period.between(fechaActual, fechaParam);
		System.out.println("Fecha Actual:" + fechaActual + " - Fecha Posterior:" + fechaParam);
		System.out.println("Tiempo Años:" + tiempoFechas.getYears());
		System.out.println("Tiempo Meses:" + tiempoFechas.getMonths());
		System.out.println("Tiempo Días:" + tiempoFechas.getDays());
		System.out.println("Total Dias: " + tiempoFechas.get(ChronoUnit.DAYS));
		
		System.out.println("Total Días:" + ChronoUnit.DAYS.between(fechaActual, fechaParam));
		System.out.println("Total Meses:" + ChronoUnit.MONTHS.between(fechaActual, fechaParam));
		
		
		Date fecha = Date.from(fechaActual.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		System.out.println("Conversión LocalDate a Date :" + fecha );
		
		LocalDateTime fechaCompleta = LocalDateTime.now();
		System.out.println("Fecha Completa:" + fechaCompleta);
		System.out.println("Formatear fecha:" + fechaCompleta.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println("Formatear fecha:" + fechaCompleta.format(DateTimeFormatter.ISO_DATE));
		System.out.println("Formatear fecha:" + fechaCompleta.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US)));
		
	

	}

}
