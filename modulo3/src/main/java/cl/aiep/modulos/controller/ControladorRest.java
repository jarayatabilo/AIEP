package cl.aiep.modulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.repository.dto.RegionDTO;
import cl.aiep.modulos.service.PaisesService;
import cl.aiep.modulos.service.RegionesService;

@RestController
@RequestMapping("/api")
public class ControladorRest {
	
	
	@Autowired
	PaisesService service;
	
	@Autowired
	RegionesService regservice;
	
	@GetMapping("/findPais/{id}")
	public PaisesDTO obtenerPais(@PathVariable Integer id) {
		
		return service.obtienePais(id);
	}
	
	@GetMapping("/findRegion/{id}")
	public RegionDTO obtenerRegion(@PathVariable Integer id) {
		
		return regservice.obtieneRegion(id);
		
	}
	
	@PutMapping("/savePais")
	public boolean savePais(@RequestBody PaisesDTO pais) {
		
		service.guardar(pais);
		
		return true;
	}
	
	@PutMapping("/saveRegion")
	public boolean saveRegion(@RequestBody RegionDTO region) {
		
		return true;
	}
	
	
	

}
