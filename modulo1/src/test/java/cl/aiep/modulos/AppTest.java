package cl.aiep.modulos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	protected MockMvc mvc;
	@Autowired
	   WebApplicationContext webApplicationContext;
	
	protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	
    @Test
    public void shouldAnswerWithTrue()
    {
    	setUp();
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
