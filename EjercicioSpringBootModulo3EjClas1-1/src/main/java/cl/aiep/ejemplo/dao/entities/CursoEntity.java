package cl.aiep.ejemplo.dao.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CursoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String nombre;
	
	@Column (nullable = false)
	private String detalle;
	
	@Column (nullable = false)
	private String profesor;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private Set<AlumnosEntity> alumnos;
	
	public Set<AlumnosEntity> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<AlumnosEntity> alumnos) {
		this.alumnos = alumnos;
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
	
	

}
