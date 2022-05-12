package cl.aiep.ejemplo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void muestraSuma()
    {
    	String suma= new Ejercicio1().muestraSuma();
    	
    	
        assertTrue( suma.equals("80") );
    }
    
    
    @Test
    public void muestraResta()
    {
        assertTrue( new Ejercicio1().muestraResta() );
    }
    
    @Test
    public void obtenerPaises() {
    	
    	List<String> paises= new Ejercicio1().obtienePaises();
    	
    	for(String pais:paises) {
    		System.out.println(pais);
    	}
    	
    	assertTrue(paises.size()>0);
    	
    }
}
