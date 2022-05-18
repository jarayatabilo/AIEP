package cl.aiep.ejemplo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.ejemplo.controllers.services.AutosService;
import cl.aiep.ejemplo.controllers.services.MueblesService;
import cl.aiep.ejemplo.controllers.services.RopaService;
import cl.aiep.ejemplo.entities.AutosEntity;
import cl.aiep.ejemplo.entities.MueblesEntity;
import cl.aiep.ejemplo.entities.RopaEntity;

@RestController
@RequestMapping ("/todo")
public class MallController {
	
	@Autowired
	AutosService aservice;
	
	@Autowired
	MueblesService mservice;
	
	@Autowired
	RopaService rservice;
	
	@GetMapping("/autos")
	public List<AutosEntity> obtieneAutos(){
			
		return aservice.obtenerAutos() ;
	}
	
	@GetMapping("/muebles")
	public List<MueblesEntity> obtieneMuebles(){
			
		return mservice.obtieneMuebles();
	}
	
	@GetMapping("/ropa")
	public List<RopaEntity> obtieneRopa(){
				
		return rservice.obtieneRopa();
	}
	

}
