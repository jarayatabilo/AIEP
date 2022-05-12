package cl.aiep.ejemplo;

import java.util.List;

import cl.aiep.ejemplo.facade.IPaisesService;
import cl.aiep.ejemplo.facade.PaisesServiceImpl;

public class Ejercicio1 {

	public static void main(String[] args) {
//		new Ejercicio1().muestraSuma();
//		System.out.println(new Ejercicio1().obtienePaises());
	}

	public String muestraSuma() {
		
		int variable1= 30;
		int variable2= 50;
		
		int suma= variable1 + variable2;
		
		System.out.println("Suma" + suma);
		
		return String.valueOf(suma);
		
	}
	
	public boolean muestraResta() {
		
		int variable1= 80;
		int variable2= 50;
		
		int resta= variable1 - variable2;
		
		System.out.println("Resta" + resta);
		
		return resta>0?true:false;
	}
	
	public List<String> obtienePaises() {
		IPaisesService  service = new PaisesServiceImpl();
		return service.getPaises();
		
	}

}
