package cl.aiep.certif.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.aiep.certif.controller.service.CursoService;
import cl.aiep.certif.controller.service.EstudianteService;
import cl.aiep.certif.dao.dto.EstudianteDTO;
import cl.aiep.certif.util.CommonUtil;

@Controller
//@PreAuthorize("isAuthenticated()")
public class LoginController {
	
	@Autowired
	EstudianteService serviceEst;
	
	@Autowired
	CursoService serviceCurso;
	

	@GetMapping("/login" )
    public String viewLoginPage() {
        return "login";
    }
	
	@GetMapping("/registrate")
    public String viewRegister(final Model model) {
			model.addAttribute("estudiante", new EstudianteDTO());
			model.addAttribute("regiones", serviceEst.obtienRegiones());
	     return "nuevo";
		
    }
	
	@PostMapping("/guardar")
    public String guardar(@Valid EstudianteDTO estudiante, BindingResult result, final Model model) {
		if (result.hasErrors()) {
			model.addAttribute("estudiante", estudiante);
			model.addAttribute("regiones", serviceEst.obtienRegiones());
	        model.addAttribute("mensaje", result.getFieldError().getDefaultMessage());
	            return "nuevo";
	        }else {
	        	
	        }
		
			if(CommonUtil.validarRut(estudiante.getRut()))
					serviceEst.guardaEstudiante(estudiante);
			else {
				model.addAttribute("estudiante", estudiante);
				model.addAttribute("regiones", serviceEst.obtienRegiones());
		        model.addAttribute("mensaje", "Rut Invalido");
				return "nuevo";
				
			}
			
	        return "redirect:/";
		
		
    }
	
	@GetMapping("/")
	@PreAuthorize("isAuthenticated()")
    public String homeCursos() {
		
        return "index";
    }
	
	@GetMapping("/admin")
	@PreAuthorize("isAuthenticated()")
    public String adminCursos(final Model model) {
		model.addAttribute("cursos", serviceCurso.obtenerCursos());
        return "indexAdmin";
    }
	
	@GetMapping("{tab}")
    public String tab(@PathVariable String tab,final Model model) {
			String retorno="empty";
        	if(tab.equals("tab1")) {
        		model.addAttribute("estudiantes", serviceEst.obtenerEstudiantes());
        		retorno =  "_" + tab;
        	}else if(tab.equals("tab2")) {
        		model.addAttribute("cursos", serviceCurso.obtenerCursos());
        		retorno =  "_" + tab;
        	}
        	
            
        

        return retorno;
    }
	
	
}
