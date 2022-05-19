package cl.aiep.ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.ejemplo.controller.service.EmpleadosService;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
	
	@Autowired
	EmpleadosService service;

	@GetMapping ("/obtener")
	public String obtenerEmpleados(final Model model){
		model.addAttribute("empresa", service.obtenerEmpleados());
		
		return "index";
	}
	
	
}
