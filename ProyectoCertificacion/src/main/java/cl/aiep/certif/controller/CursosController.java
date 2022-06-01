package cl.aiep.certif.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursosController {
	
	@GetMapping("/test")
	public String test() {
		
		System.out.println("lala");
		
		return "LLegue al debug";
	}

}
