package cl.aiep.modulos.dao;

import cl.aiep.modulos.repository.dto.RegionDTO;

public interface IRegionesDAO {
	
	public RegionDTO obtenerRegion(Integer id);

	public void guardar(RegionDTO region);

}
