/**
 * 
 */
package com.matoosfe.java8;

import java.util.Date;

/**
 * Clase para representar a la entidad estudiante
 * 
 * @author martosfre
 *
 */
public class Estudiante {

	private Integer codEst;
	private String nombreEst;
	private String apellidoEst;
	private Integer edadEst;
	private Date fechaEst;

	/**
	 * @param codEst
	 * @param nombreEst
	 * @param apellidoEst
	 * @param edadEst
	 * @param fechaEst
	 */
	public Estudiante(Integer codEst, String nombreEst, String apellidoEst, Integer edadEst, Date fechaEst) {
		this.codEst = codEst;
		this.nombreEst = nombreEst;
		this.apellidoEst = apellidoEst;
		this.edadEst = edadEst;
		this.fechaEst = fechaEst;
	}

	/**
	 * @return the codEst
	 */
	public Integer getCodEst() {
		return codEst;
	}

	/**
	 * @param codEst the codEst to set
	 */
	public void setCodEst(Integer codEst) {
		this.codEst = codEst;
	}

	/**
	 * @return the nombreEst
	 */
	public String getNombreEst() {
		return nombreEst;
	}

	/**
	 * @param nombreEst the nombreEst to set
	 */
	public void setNombreEst(String nombreEst) {
		this.nombreEst = nombreEst;
	}

	/**
	 * @return the apellidoEst
	 */
	public String getApellidoEst() {
		return apellidoEst;
	}

	/**
	 * @param apellidoEst the apellidoEst to set
	 */
	public void setApellidoEst(String apellidoEst) {
		this.apellidoEst = apellidoEst;
	}

	/**
	 * @return the edadEst
	 */
	public Integer getEdadEst() {
		return edadEst;
	}

	/**
	 * @param edadEst the edadEst to set
	 */
	public void setEdadEst(Integer edadEst) {
		this.edadEst = edadEst;
	}

	/**
	 * @return the fechaEst
	 */
	public Date getFechaEst() {
		return fechaEst;
	}

	/**
	 * @param fechaEst the fechaEst to set
	 */
	public void setFechaEst(Date fechaEst) {
		this.fechaEst = fechaEst;
	}

	@Override
	public String toString() {
		return "Estudiante [codEst=" + codEst + ", nombreEst=" + nombreEst + ", apellidoEst=" + apellidoEst
				+ ", edadEst=" + edadEst + ", fechaEst=" + fechaEst + "]";
	}

}
