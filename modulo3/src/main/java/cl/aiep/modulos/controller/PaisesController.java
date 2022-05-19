package cl.aiep.modulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.service.PaisesService;

@Controller
@RequestMapping ("/api")
public class PaisesController {
	
	@Autowired
	PaisesService servicio;
	
	
	@GetMapping("/obtiene")
	public String obtieneFichero(final Model model) {
	    model.addAttribute("paises", servicio.obtienePaises());
	    return "index";
	}
	
	@GetMapping("/obtiene/{id}")
	public String obtieneFichero(@PathVariable Integer id,  final Model model) {
			PaisesDTO dto= servicio.obtienePais(id);
			 model.addAttribute("pais",dto);
			 
	    return "detalle";
	}

}
