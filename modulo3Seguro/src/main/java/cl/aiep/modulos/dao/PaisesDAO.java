package cl.aiep.modulos.dao;

import java.util.List;

import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.repository.dto.PaisesRegionesDTO;


public interface PaisesDAO {

	public List<PaisesDTO> findAll();

	public PaisesDTO findById(Integer id);
	
	public PaisesRegionesDTO obtieneAmbasListas();

	public void guardar(PaisesDTO pais);

	
}
