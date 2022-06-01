package cl.aiep.certif.dao.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ContenidoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String detalle;
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
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public ContenidoDTO(Integer id, String nombre, String detalle) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
	}
	public ContenidoDTO( String nombre, String detalle) {
		super();
		this.nombre = nombre;
		this.detalle = detalle;
	}
	public ContenidoDTO() {
		super();
	}
	
}
