package cl.aiep.ejemplo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.ejemplo.controllers.services.Url1Service;
import cl.aiep.ejemplo.controllers.services.Url2Service;
import cl.aiep.ejemplo.controllers.services.Url3Service;





@RestController
@RequestMapping ("/diferentes")
public class DifUrlsController {
	
	@Autowired
	Url1Service url1;
	
	@Autowired
	Url2Service url2;

	@Autowired
	Url3Service url3;
	
	@GetMapping("/url1")
	public List<String> url1(){
		return url1.obtieneUrl1();
	}
	
	@GetMapping("/url2")
	public List<Integer> url2(){
		return url2.obtieneUrl2();
	}
	
	@GetMapping("/url3")
	public List<Double> url3(){
		return url3.obtieneUrl3();
	}
	
	
}
