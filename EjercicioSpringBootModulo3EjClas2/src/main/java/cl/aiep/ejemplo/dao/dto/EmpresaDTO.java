package cl.aiep.ejemplo.dao.dto;

import java.io.Serializable;
import java.util.List;

public class EmpresaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private Integer cantEmpleado;
	private String sucursal;
	private String rut;
	private List<EmpleadoDTO> empleados;
	
	
	
	
	public List<EmpleadoDTO> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoDTO> empleados) {
		this.empleados = empleados;
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
	public Integer getCantEmpleado() {
		return cantEmpleado;
	}
	public void setCantEmpleado(Integer cantEmpleado) {
		this.cantEmpleado = cantEmpleado;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public EmpresaDTO(Integer id, String nombre, Integer cantEmpleado, 
			String sucursal, String rut, List<EmpleadoDTO> empleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantEmpleado = cantEmpleado;
		this.sucursal = sucursal;
		this.rut = rut;
		this.empleados= empleados;
	}
	
	public EmpresaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
