package cl.aiep.modulos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.service.PaisesService;

@Controller
@RequestMapping ("/tabla")
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
	
	
	@GetMapping("/obtieneAmbas")
	public String obtieneAmbas(final Model model) {
	    model.addAttribute("ambas", servicio.obtieneAmbasListas());
	    return "ambas";
	}
	
	@GetMapping("/newPais")
	public String nuevoPais(final Model model) {
		model.addAttribute("pais", new PaisesDTO());
		return "nuevo";
	}
	
	@PostMapping("/addpais")
	public String addPais2(@Valid PaisesDTO pais, BindingResult result, Model model) {
		  if (result.hasErrors()) {
			  model.addAttribute("pais", new PaisesDTO());
			  model.addAttribute("mensaje", result.getFieldError().getDefaultMessage());
	            return "nuevo";
	        }
	     	servicio.guardar(pais);
	        return "redirect:/tabla/obtiene";
	}
	

}
