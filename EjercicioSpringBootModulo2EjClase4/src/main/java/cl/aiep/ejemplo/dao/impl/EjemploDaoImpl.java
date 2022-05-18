package cl.aiep.ejemplo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.dao.EjemploDao;
import cl.aiep.ejemplo.dao.dto.ComidaDTO;
import cl.aiep.ejemplo.entities.Comida;
import cl.aiep.ejemplo.repositories.ComidaRepository;

@Repository
public class EjemploDaoImpl implements EjemploDao{


	@Autowired
	ComidaRepository repositorio;
	
	@Override
	public List<ComidaDTO> obtenerComidas(){
		
		List<ComidaDTO> retorno = new ArrayList<ComidaDTO>();
		
		for(Comida com:repositorio.findAll()) {
			retorno.add(new ComidaDTO(com.getId(),com.getNombre(), com.getCosto(), "Hola"));
		}
		
		return retorno;
	}
	
	

}
