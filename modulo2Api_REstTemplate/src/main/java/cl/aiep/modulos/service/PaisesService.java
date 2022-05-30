package cl.aiep.modulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.modulos.dao.IPaisesDAO;
import cl.aiep.modulos.dao.repository.PaisesRepository;
import cl.aiep.modulos.dao.repository.entity.Paises;
import cl.aiep.modulos.dto.PaisDTO;

@Service
public class PaisesService {
	
	@Autowired
	IPaisesDAO dao;
	
	
	public List <PaisDTO> obtienePaises(){
		return dao.obtenerPaises();
	}
	public PaisDTO obtienePais(Integer id) {
			return dao.obtenerId(id);
	}
	
	public void agregarPais(PaisDTO pais) {
		dao.guardar(pais);	
	}
	public void eliminarPais(Integer id) {
		dao.eliminar(id);
		
	}
	public void modificarPais(PaisDTO pais) {
		dao.modificar(pais);
	}
	public List<PaisDTO> obtieneporLetra(String letra) {
		// TODO Auto-generated method stub
		return dao.obtieneporLetra(letra);
	}
	
}
