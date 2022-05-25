package cl.aiep.modulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.service.PaisesService;

@Controller
//@PreAuthorize("isAuthenticated()")
public class LoginController {
	
	@Autowired
	PaisesService servicio;
	

	@GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }
	
	@GetMapping("/")
	@PreAuthorize("isAuthenticated()")
	public String defaultAfterLogin(Model model) {
        model.addAttribute("paises", servicio.obtienePaises());
	    return "index";
   }
	
	@GetMapping("/obtiene/{id}")
	@PreAuthorize("isAuthenticated()")
	public String obtieneFichero(@PathVariable Integer id,  final Model model) {
			PaisesDTO dto= servicio.obtienePais(id);
			 model.addAttribute("pais",dto);
			 
	    return "detalle";
	}
	
}
