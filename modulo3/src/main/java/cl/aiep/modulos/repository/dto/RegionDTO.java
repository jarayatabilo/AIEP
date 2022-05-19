package cl.aiep.modulos.repository.dto;

import java.io.Serializable;

public class RegionDTO implements Comparable<RegionDTO> {
	
	private Integer  id;

	private Integer  idpais;
	
	private String sigla;
	
	private String detalle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public RegionDTO(Integer id, Integer idpais, String sigla, String detalle) {
		super();
		this.id = id;
		this.idpais = idpais;
		this.sigla = sigla;
		this.detalle = detalle;
	}

	@Override
	public int compareTo(RegionDTO o) {
		 if (getId() == null || o.getId() == null) {
		      return 0;
		    }
		    return getId().compareTo(o.getId());
	}

	
}
