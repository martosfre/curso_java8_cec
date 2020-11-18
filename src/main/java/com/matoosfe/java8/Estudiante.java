/**
 * 
 */
package com.matoosfe.java8;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase para representar a la entidad estudiante
 * 
 * @author martosfre
 *
 */
public class Estudiante implements Comparable<Estudiante> {

	private Integer codEst;
	private String nombreEst;
	private String apellidoEst;
	private Integer edadEst;
	private Date fechaEst;
	private BigDecimal pension;
	private Direccion direccion;

	/**
	 * @param codEst
	 * @param nombreEst
	 * @param apellidoEst
	 * @param edadEst
	 * @param fechaEst
	 */
	public Estudiante(Integer codEst, String nombreEst, String apellidoEst, Integer edadEst, Date fechaEst, BigDecimal pension ) {
		this.codEst = codEst;
		this.nombreEst = nombreEst;
		this.apellidoEst = apellidoEst;
		this.edadEst = edadEst;
		this.fechaEst = fechaEst;
		this.pension = pension;
	}
	
	public Estudiante(Integer codEst, String nombreEst, String apellidoEst, Integer edadEst, Date fechaEst) {
		this.codEst = codEst;
		this.nombreEst = nombreEst;
		this.apellidoEst = apellidoEst;
		this.edadEst = edadEst;
		this.fechaEst = fechaEst;
	}
	
	

	/**
	 * @param codEst
	 * @param nombreEst
	 * @param apellidoEst
	 * @param edadEst
	 * @param fechaEst
	 * @param pension
	 * @param direccion
	 */
	public Estudiante(Integer codEst, String nombreEst, String apellidoEst, Integer edadEst, Date fechaEst,
			BigDecimal pension, Direccion direccion) {
		this.codEst = codEst;
		this.nombreEst = nombreEst;
		this.apellidoEst = apellidoEst;
		this.edadEst = edadEst;
		this.fechaEst = fechaEst;
		this.pension = pension;
		this.direccion = direccion;
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
	
	
	/**
	 * @return the pension
	 */
	public BigDecimal getPension() {
		return pension;
	}

	/**
	 * @param pension the pension to set
	 */
	public void setPension(BigDecimal pension) {
		this.pension = pension;
	}
	
	

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoEst == null) ? 0 : apellidoEst.hashCode());
		result = prime * result + ((edadEst == null) ? 0 : edadEst.hashCode());
		result = prime * result + ((nombreEst == null) ? 0 : nombreEst.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (apellidoEst == null) {
			if (other.apellidoEst != null)
				return false;
		} else if (!apellidoEst.equals(other.apellidoEst))
			return false;
		if (edadEst == null) {
			if (other.edadEst != null)
				return false;
		} else if (!edadEst.equals(other.edadEst))
			return false;
		if (nombreEst == null) {
			if (other.nombreEst != null)
				return false;
		} else if (!nombreEst.equals(other.nombreEst))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estudiante [codEst=" + codEst + ", nombreEst=" + nombreEst + ", apellidoEst=" + apellidoEst
				+ ", edadEst=" + edadEst + ", fechaEst=" + fechaEst + "]";
	}

	@Override
	public int compareTo(Estudiante o) {
		return getCodEst().compareTo(o.getCodEst());
	}

}
