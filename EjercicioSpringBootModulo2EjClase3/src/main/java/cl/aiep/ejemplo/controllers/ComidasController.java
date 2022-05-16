package cl.aiep.ejemplo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.ejemplo.controllers.services.ComidaService;
import cl.aiep.ejemplo.entities.Comida;


@RestController
@RequestMapping("/comida")
public class ComidasController {

	@Autowired
	ComidaService service;
	
	@GetMapping("/obtiene")
	public List<Comida> obtieneComida(){
		
		
		return service.obtieneComida();
	}
}
