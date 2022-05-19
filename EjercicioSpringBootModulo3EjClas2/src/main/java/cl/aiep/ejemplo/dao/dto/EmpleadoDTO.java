package cl.aiep.ejemplo.dao.dto;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String cargo;
	private Integer edad;
	private long sueldo;
	private String jornada;
	
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public long getSueldo() {
		return sueldo;
	}
	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	
	public EmpleadoDTO(Integer id, String nombre, String cargo, Integer edad, long sueldo, String jornada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
		this.edad = edad;
		this.sueldo = sueldo;
		this.jornada = jornada;
	}
	
	
	
}
