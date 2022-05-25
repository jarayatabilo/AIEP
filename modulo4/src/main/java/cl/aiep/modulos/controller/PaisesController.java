package cl.aiep.modulos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.service.PaisesService;

@RestController
@RequestMapping ("/api")
public class PaisesController {
	
	@Autowired
	PaisesService servicio;
	
	
	@GetMapping("/obtiene")
	@PreAuthorize("isAuthenticated()")
	public List<PaisesDTO> obtieneFichero() {
	    String palabra= "lala";
		String lala = new BCryptPasswordEncoder().encode(palabra);
		
		boolean esigual= new BCryptPasswordEncoder().matches(palabra, lala);
		
	    return servicio.obtienePaises();
	}
	
	@GetMapping("/obtiene/{id}")
	@PreAuthorize("isAuthenticated()")
	public PaisesDTO  obtieneFichero(@PathVariable Integer id) {
	   return servicio.obtienePais(id);
	}

	
}
