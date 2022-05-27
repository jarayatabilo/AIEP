package cl.aiep.modulos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
//@RequestMapping ("/tabla")
public class PaisesController {
	
	@Autowired
	PaisesService servicio;
	
	@GetMapping("/login")
	public String login(final Model model) {
	    
	    return "login";
	}
	
	@GetMapping("/")
	@PreAuthorize("isAuthenticated()")
	public String obtieneFichero(final Model model) {
	    model.addAttribute("paises", servicio.obtienePaises());
	    Authentication auth= SecurityContextHolder.getContext().getAuthentication();
	    User usuario= (User) auth.getPrincipal();
	    
	    model.addAttribute("usuario", usuario);
	    
	    return "index";
	}
	
	@GetMapping("/obtiene/{id}")
	@PreAuthorize("isAuthenticated()")
	public String obtieneFichero(@PathVariable Integer id,  final Model model) {
			PaisesDTO dto= servicio.obtienePais(id);
			 model.addAttribute("pais",dto);
			 
	    return "detalle";
	}
	
	
	@GetMapping("/obtieneAmbas")
	@PreAuthorize("isAuthenticated()")
	public String obtieneAmbas(final Model model) {
	    model.addAttribute("ambas", servicio.obtieneAmbasListas());
	    return "ambas";
	}
	
	@GetMapping("/newPais")
	@PreAuthorize("isAuthenticated()")
	public String nuevoPais(final Model model) {
		model.addAttribute("pais", new PaisesDTO());
		return "nuevo";
	}
	
	@PostMapping("/addpais")
	@PreAuthorize("isAuthenticated()")
	public String addPais2(@Valid PaisesDTO pais, BindingResult result, Model model) {
		  if (result.hasErrors()) {
			  model.addAttribute("pais", new PaisesDTO());
			  model.addAttribute("mensaje", result.getFieldError().getDefaultMessage());
	            return "nuevo";
	        }
	     	servicio.guardar(pais);
	        return "redirect:/";
	}
	

}
