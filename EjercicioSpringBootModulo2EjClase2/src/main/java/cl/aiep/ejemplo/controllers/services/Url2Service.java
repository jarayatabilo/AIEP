package cl.aiep.ejemplo.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Url2Service {
	
	public List<Integer> obtieneUrl2(){
		List<Integer> retorno = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			retorno.add(i);
		}
		
		return retorno;
	}

}
