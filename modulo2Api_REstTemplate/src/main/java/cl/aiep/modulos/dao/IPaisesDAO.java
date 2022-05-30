package cl.aiep.modulos.dao;

import java.util.List;

import cl.aiep.modulos.dto.PaisDTO;

public interface IPaisesDAO {

	List<PaisDTO> obtenerPaises();

	PaisDTO obtenerId(Integer id);

	void guardar(PaisDTO pais);

	void eliminar(Integer id);

	void modificar(PaisDTO pais);

	List<PaisDTO> obtieneporLetra(String letra);
	
	

}
