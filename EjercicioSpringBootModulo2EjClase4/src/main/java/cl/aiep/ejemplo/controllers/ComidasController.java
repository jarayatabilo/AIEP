package cl.aiep.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.ejemplo.controllers.services.ComidaService;


@Controller
@RequestMapping("/comida")
public class ComidasController {

	@Autowired
	ComidaService service;
	
	@GetMapping("/obtiene")
	public String obtieneComida(final Model modelo){
		
		modelo.addAttribute("comidas",service.obtieneComida());
		
		return "index";
	}
}
