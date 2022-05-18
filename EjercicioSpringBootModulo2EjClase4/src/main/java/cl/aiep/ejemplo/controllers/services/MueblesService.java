package cl.aiep.ejemplo.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.entities.MueblesEntity;
import cl.aiep.ejemplo.repositories.MueblesRepository;

@Service
public class MueblesService {
	
	@Autowired
	MueblesRepository repositorio;
	
	
	public List<MueblesEntity> obtieneMuebles(){
		
		
		return repositorio.findAll();
	}

}
