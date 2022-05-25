package cl.aiep.modulos.dao;

import java.util.List;

import cl.aiep.modulos.repository.dto.PaisesDTO;


public interface PaisesDAO {

	public List<PaisesDTO> findAll();

	public PaisesDTO findById(Integer id);
	
	

}
