package com.matoosfe.java8;

public class Direccion {

	private int idDir;
	private String nombreDir;

	/**
	 * @param idDir
	 * @param nombreDir
	 */
	public Direccion(int idDir, String nombreDir) {
		this.idDir = idDir;
		this.nombreDir = nombreDir;
	}

	/**
	 * @return the idDir
	 */
	public int getIdDir() {
		return idDir;
	}

	/**
	 * @param idDir the idDir to set
	 */
	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}

	/**
	 * @return the nombreDir
	 */
	public String getNombreDir() {
		return nombreDir;
	}

	/**
	 * @param nombreDir the nombreDir to set
	 */
	public void setNombreDir(String nombreDir) {
		this.nombreDir = nombreDir;
	}

}
