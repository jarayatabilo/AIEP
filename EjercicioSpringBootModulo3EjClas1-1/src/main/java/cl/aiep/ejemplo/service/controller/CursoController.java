package cl.aiep.ejemplo.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.ejemplo.dao.dto.CursoDTO;
import cl.aiep.ejemplo.service.CursoService;

@RestController
@RequestMapping ("/curso")
public class CursoController {
	
	@Autowired
	CursoService service;

	@GetMapping ("/obtener")
	public List<CursoDTO> obtieneCurso(){
		
		return service.obtieneCurso();
	}
	
}
