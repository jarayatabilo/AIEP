package cl.aiep.ejemplo.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.entities.Comida;
import cl.aiep.ejemplo.repositories.ComidaRepository;

@Service
public class ComidaService {

	@Autowired
	ComidaRepository repositorio;
	
	public List<Comida> obtieneComida(){
		return repositorio.findAll();
	}
	
}
