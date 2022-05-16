package cl.aiep.ejemplo.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Url3Service {
	
	public List<Double> obtieneUrl3(){
		List<Double> retorno = new ArrayList<Double>();
		
		for (int i = 0; i < 10; i++) {
			retorno.add(Math.random());
		}
		
		return retorno;
	} 

}
