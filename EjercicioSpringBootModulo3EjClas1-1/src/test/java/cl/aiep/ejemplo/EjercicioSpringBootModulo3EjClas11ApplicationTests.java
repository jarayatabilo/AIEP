package cl.aiep.ejemplo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.aiep.ejemplo.dao.dto.CursoDTO;
import cl.aiep.ejemplo.service.CursoService;

@SpringBootTest
class EjercicioSpringBootModulo3EjClas11ApplicationTests {
	
	@Autowired
	CursoService service;

	@Test
	void contextLoads() {
		
//		System.out.println(service);
//		List<CursoDTO> lista= service.obtieneCurso();
//		
//		
//		assertTrue(lista.size()>0);
		
	}

}
