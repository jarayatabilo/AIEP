package cl.aiep.modulos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.modulos.service.PaisesService;

@Controller
@RequestMapping("/")
public class PaisesController {
	
	Logger logger = LogManager.getLogger(this);

	
	@Autowired
	PaisesService servicio;
	
	
	@GetMapping("/obtiene")
	public String obtieneFichero(final Model model) {
	    model.addAttribute("paises", servicio.obtienePaises());
	    return "index";
	}
	
	@GetMapping("/obtiene/{id}")
	public String obtieneFichero(@PathVariable Integer id,  final Model model) {
			 model.addAttribute("pais",servicio.obtienePais(id));
			 logger.info("Obteniendo pais con el siguiente id [ " + id + " ]");
	    return "detalle";
	}
	
	

}
