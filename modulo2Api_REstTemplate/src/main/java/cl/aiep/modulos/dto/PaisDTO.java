package cl.aiep.modulos.dto;

import java.io.Serializable;

public class PaisDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
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
	
	public PaisDTO() {
		super();
	}
	public PaisDTO(String name) {
		super();
		this.name = name;
	}
	public PaisDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	
}
