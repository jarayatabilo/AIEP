package cl.aiep.modulos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	   WebApplicationContext webApplicationContext;
	
	
	
    @Test
    public void shouldAnswerWithTrue()
    {
    	
    	String uri = "/api/obtiene";
    	   MvcResult mvcResult;
    	   List<String> mensajeList = new ArrayList<>();
		try {
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
    	   
    	   int status = mvcResult.getResponse().getStatus();
    	   assertEquals(200, status);
    	   String content = mvcResult.getResponse().getContentAsString();
    	   mensajeList.add(content);
    	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(mensajeList.size() > 0);
    }
    
    
}
