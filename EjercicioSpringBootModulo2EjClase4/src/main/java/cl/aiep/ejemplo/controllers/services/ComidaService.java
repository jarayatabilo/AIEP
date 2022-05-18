package cl.aiep.ejemplo.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.dao.EjemploDao;
import cl.aiep.ejemplo.dao.dto.ComidaDTO;
import cl.aiep.ejemplo.entities.Comida;
import cl.aiep.ejemplo.repositories.ComidaRepository;

@Service
public class ComidaService {

	@Autowired
	EjemploDao repositorio;
	
	public List<ComidaDTO> obtieneComida(){
		return repositorio.obtenerComidas();
	}
	
}
