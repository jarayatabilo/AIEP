package cl.aiep.modulos.repository.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class PaisesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer  id;
	@NotEmpty (message = "nombre no puede ser vacio")
	private String name;
	private long conteo;
	List<RegionDTO> regiones;
	
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
	public long getConteo() {
		return conteo;
	}
	public void setConteo(long conteo) {
		this.conteo = conteo;
	}

	
	public List<RegionDTO> getRegiones() {
		return regiones;
	}
	public void setRegiones(List<RegionDTO> regiones) {
		this.regiones = regiones;
	}
	public PaisesDTO(Integer id, String name, long conteo,List<RegionDTO> regiones) {
		super();
		this.id = id;
		this.name = name;
		this.conteo= conteo;
		this.regiones= regiones;
	}
	public PaisesDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public PaisesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}