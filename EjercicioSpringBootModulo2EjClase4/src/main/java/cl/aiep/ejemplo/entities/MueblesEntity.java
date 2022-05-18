package cl.aiep.ejemplo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MueblesEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String nombre;
	
	@Column (nullable = false)
	private String tipo;
	
	@Column (nullable =  false)
	private long valor;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}
	
	
}
