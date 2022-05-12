package cl.aiep.ejemplo.facade;

import java.util.ArrayList;
import java.util.List;

public class PaisesServiceImpl implements IPaisesService{

	@Override
	public List<String> getPaises() {
		List<String> paises= new ArrayList<String>();
		for (int i= 0; i<=10;i++) {
			paises.add("pais"+i);
		}
		return paises;
	}

	
}
