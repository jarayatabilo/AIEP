package cl.aiep.modulos.repository.dto;

import java.io.Serializable;
import java.util.List;

public class PaisesRegionesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PaisesDTO> paises;
	private List<RegionDTO> regiones;
	public List<PaisesDTO> getPaises() {
		return paises;
	}
	public void setPaises(List<PaisesDTO> paises) {
		this.paises = paises;
	}
	public List<RegionDTO> getRegiones() {
		return regiones;
	}
	public void setRegiones(List<RegionDTO> regiones) {
		this.regiones = regiones;
	}
	
	

}
