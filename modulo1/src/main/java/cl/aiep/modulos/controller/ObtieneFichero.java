package cl.aiep.modulos.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.modulos.App;

@RestController
@RequestMapping ("/api")
public class ObtieneFichero {
	
	@RequestMapping("/obtiene")
	public List<String> obtieneFichero() {
		
		InputStream is = App.class.getClassLoader().getResourceAsStream("lectura.txt");
		List<String> lineas= new ArrayList<String>();
	       try
	       {
	           String line;
	           
	           BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( is ) );
	           while( (line = bufferedReader.readLine()) != null )
	           { 
	               System.out.printf("%s\n", line);
	               lineas.add(line);
	              
	           }  
	       } 
	       catch( IOException e )
	       {
	           System.err.println( "Error: " + e );
	           
	       }
		
		return lineas;
	}

}
