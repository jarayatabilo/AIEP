package cl.aiep.modulos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.modulos.dao.PaisesDAO;
import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.repository.dto.PaisesRegionesDTO;

@Service
public class PaisesService {

	@Autowired
	PaisesDAO paisesDao;
	
	
	public List <PaisesDTO> obtienePaises(){
		return paisesDao.findAll();
	}
	public PaisesDTO obtienePais(Integer id) {
		return paisesDao.findById(id);
	}
	
	public PaisesRegionesDTO obtieneAmbasListas() {
		
		return paisesDao.obtieneAmbasListas();
	}
	public void guardar(PaisesDTO pais) {
		paisesDao.guardar(pais);
		
	}
}
