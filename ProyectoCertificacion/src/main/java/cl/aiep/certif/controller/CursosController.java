package cl.aiep.certif.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.certif.dao.dto.CursoDTO;
import cl.aiep.certif.dao.dto.EstudianteDTO;

@Controller
public class CursosController {
	
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
		
		
		return "nuevoCurso";
	}

}
