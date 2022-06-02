package cl.aiep.certif.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.certif.controller.service.CursoService;
import cl.aiep.certif.dao.dto.CursoDTO;

@Controller
public class CursosController {
	
	@Autowired
	CursoService service;
	
	@GetMapping("/crearCurso")
	public String crearCurso(final Model model) {
		
		model.addAttribute("curso", new CursoDTO());
		
		return "nuevoCurso";
	}
	
	@PostMapping("/guardarCurso")
	public String guardarCurso(@Valid CursoDTO curso, BindingResult result, final Model model) {
		if (result.hasErrors()) {
			model.addAttribute("curso", curso);
			 model.addAttribute("mensaje", result.getFieldError().getDefaultMessage());
	        return "nuevoCurso";
		}
		
		service.guardarCurso(curso);

        return "redirect:/";
	}
	
	@GetMapping("/obtiene/{id}")
	public String verCurso(final Model model, @PathVariable Integer id) {
		
		model.addAttribute("curso", service.obtenerCurso(id));
		
	return "curso";
	}

	
	@GetMapping("/asignarCurso/{id}")
	public String agregaCurso(@PathVariable Integer id){
		 Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		    auth.getPrincipal();
		
		    
		    
		return "redirect:/";
	}
}
