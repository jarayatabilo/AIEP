package cl.aiep.modulos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.modulos.dao.IRegionesDAO;
import cl.aiep.modulos.repository.dto.RegionDTO;

@Service
public class RegionesService {
	
	@Autowired
	IRegionesDAO dao;
	
	public RegionDTO obtieneRegion(Integer id) {
		return dao.obtenerRegion(id);
	}

	public void guardar(RegionDTO region) {
		dao.guardar(region);
		
	}
	

}
