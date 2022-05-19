package cl.aiep.ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

	@GetMapping ("/obtener")
	public String obtenerEmpleados(final Model model){
		model.addAttribute("empleados", null);
		
		return "index";
	}
	
	
}
