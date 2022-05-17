package cl.aiep.ejemplo.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.entities.RopaEntity;
import cl.aiep.ejemplo.repositories.RopaRepository;

@Service
public class RopaService {
	
	@Autowired
	RopaRepository repositorio;

 public List<RopaEntity> obtieneRopa(){
	 
	 return repositorio.findAll();
 }
	
}
