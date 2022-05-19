package cl.aiep.modulos.repository.entity;

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
public class Paises implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private Set<Regiones> regiones;
	
	
	public Set<Regiones> getRegiones() {
		return regiones;
	}
	public void setRegiones(Set<Regiones> regiones) {
		this.regiones = regiones;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
