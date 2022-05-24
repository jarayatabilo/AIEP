package cl.aiep.ejemplo.dao.dto;

import java.io.Serializable;


public class AlumnosDTO implements Serializable{
	

	public AlumnosDTO(Integer id, String nombre, long edad, String domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
	}
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private long edad;
	private String domicilio;
	
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
	public long getEdad() {
		return edad;
	}
	public void setEdad(long edad) {
		this.edad = edad;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
}
