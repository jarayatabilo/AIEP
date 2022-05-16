package cl.aiep.ejemplo.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OracionService {
	
	@Autowired
	Palabra1Service  palabra1;
	@Autowired
	Palabra2Service  palabra2;
	@Autowired
	Palabra3Service  palabra3;
	@Autowired
	Palabra4Service  palabra4;
	@Autowired
	Palabra5Service  palabra5;
	

	public String oracion() {
		StringBuffer oracion= new StringBuffer(palabra1.palabra1())
				.append(palabra2.palabra2())
				.append(palabra3.palabra3())
				.append(palabra4.palabra4())
				.append(palabra5.palabra5());
		
		return oracion.toString();
	}
	
}
