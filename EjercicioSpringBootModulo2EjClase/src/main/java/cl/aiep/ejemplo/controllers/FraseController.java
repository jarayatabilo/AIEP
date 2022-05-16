package cl.aiep.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.ejemplo.controllers.services.OracionService;

@RestController
@RequestMapping ("/frase")
public class FraseController {
	
	@Autowired
	OracionService service;
	
	@GetMapping("/completa")
	public String obtieneFrase() {
		return service.oracion();
	}
	

}
