package cl.aiep.ejemplo.dao.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ComidaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nombre;
	
	private long costo;
	
	private String enduro;
	
	

	public String getEnduro() {
		return enduro;
	}

	public void setEnduro(String enduro) {
		this.enduro = enduro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCosto() {
		return costo;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}

	public ComidaDTO(Integer id, String nombre, long costo, String enduro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.enduro = enduro;
	}
	
}
