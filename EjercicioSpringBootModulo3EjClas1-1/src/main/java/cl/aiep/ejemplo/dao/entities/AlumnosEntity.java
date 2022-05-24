package cl.aiep.ejemplo.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlumnosEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String nombre;
	@Column (nullable = false)
	private long edad;
	@Column (nullable = false)
	private String domicilio;
	
	@Column(nullable = false, insertable = false, updatable = false)
	private Integer idCurso;
	
	@ManyToOne
	@JoinColumn (name="idCurso")
	private CursoEntity curso;
	
	
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
