package cl.aiep.ejemplo.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Url1Service {
	
	public List<String> obtieneUrl1(){
		List<String> retorno = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			retorno.add("Hola" +i);
		}
		
		return retorno;
	}

}
