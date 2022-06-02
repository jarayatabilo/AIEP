package cl.aiep.certif.dao.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;




public class CursoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Nombre no debe ser vacio")
	private String nombre;
	@NotEmpty(message = "Imagen no debe ser vacio")
	private String imagen;
//	@NotNull(message = "Fecha Inicio no debe ser vacio")
//	@Pattern(regexp = "(Date of birth:|Birthday:)\\s+(?:19\\d{2}|20[01][0-9]|2022)[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])\\b")
	@DateTimeFormat (pattern = "dd-MM-yyyy")
	private Date fecinicio;
	@DateTimeFormat (pattern = "dd-MM-yyyy")
	private Date fectermino;
	@Min(value = 1, message = "Cupos no debe ser vacio")
	private Integer cupos;
	@NotEmpty(message = "Descripcion no debe ser vacio")
	private String descripcion;
	
	
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFecinicio() {
		return fecinicio;
	}
	public void setFecinicio(Date fecinicio) {
		this.fecinicio = fecinicio;
	}
	public Date getFectermino() {
		return fectermino;
	}
	public void setFectermino(Date fectermino) {
		this.fectermino = fectermino;
	}
	public Integer getCupos() {
		return cupos;
	}
	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CursoDTO() {
		super();
	}
	public CursoDTO( String nombre, String imagen, Date fecinicio, Date fectermino, Integer cupos,
			String descripcion) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.fecinicio = fecinicio;
		this.fectermino = fectermino;
		this.cupos = cupos;
		this.descripcion = descripcion;
	}
	
	public CursoDTO(Integer id, String nombre, String imagen, Date fecinicio, Date fectermino, Integer cupos,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.fecinicio = fecinicio;
		this.fectermino = fectermino;
		this.cupos = cupos;
		this.descripcion = descripcion;
	}
	
	

	
}
