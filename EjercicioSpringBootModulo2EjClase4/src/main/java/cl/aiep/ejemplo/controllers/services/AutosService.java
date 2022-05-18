package cl.aiep.ejemplo.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.entities.AutosEntity;
import cl.aiep.ejemplo.repositories.AutosRepository;

@Service
public class AutosService {
	
	@Autowired
	AutosRepository repositorio;
	
	public List<AutosEntity> obtenerAutos(){
		
		return repositorio.findAll();
	}

}
