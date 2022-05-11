package cl.aiep.modulos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        new App().obtieneFichero();
        
    }
   public boolean obtieneFichero() {
	   InputStream is = App.class.getClassLoader().getResourceAsStream("lectura.txt");
       
       try
       {
           String line;
           BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( is ) );
           while( (line = bufferedReader.readLine()) != null )
           { 
               System.out.printf("%s\n", line);
           }  
       } 
       catch( IOException e )
       {
           System.err.println( "Error: " + e );
           return false;
       }
       return true;
   }
    
}
