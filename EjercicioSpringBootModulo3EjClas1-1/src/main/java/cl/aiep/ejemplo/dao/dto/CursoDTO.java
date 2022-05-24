package cl.aiep.ejemplo.dao.dto;

import java.io.Serializable;
import java.util.List;

public class CursoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nombre;
	
	private String detalle;
	
	private String profesor;

	private List<AlumnosDTO> alumnos;
	
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

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public List<AlumnosDTO> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnosDTO> alumnos) {
		this.alumnos = alumnos;
	}

	public CursoDTO(Integer id, String nombre, String detalle, String profesor, List<AlumnosDTO> alumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.profesor = profesor;
		this.alumnos = alumnos;
	}
	
	
	
	

}
