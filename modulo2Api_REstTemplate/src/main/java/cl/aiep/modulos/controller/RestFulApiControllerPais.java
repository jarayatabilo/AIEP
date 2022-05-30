package cl.aiep.modulos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cl.aiep.modulos.dao.repository.entity.Paises;
import cl.aiep.modulos.dto.PaisDTO;
import cl.aiep.modulos.service.PaisesService;

@RestController
@RequestMapping("/api/v1/paises")
public class RestFulApiControllerPais {
	
	@Autowired
	PaisesService service;
	
	@GetMapping ("/listartodos")
	public List<PaisDTO> obtienePaises(){
		return service.obtienePaises();
	}
	
	@GetMapping("/mostrarpor/{id}")
	public PaisDTO obtener(@PathVariable Integer id) {
		
		return service.obtienePais(id);
	}
	
	@GetMapping("/mostrarporletra/{letra}")
	public List<PaisDTO> obtieneporletra(@PathVariable String letra){
		
		return service.obtieneporLetra(letra);
	}
	
	@PutMapping ("/agregar")
	public String agregarPais(@RequestBody PaisDTO pais) {
		
		service.agregarPais(pais);
		return "Pais Insertado Correctamente";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarPais(@PathVariable Integer id) {
		
		service.eliminarPais(id);
		return "Pais Eliminado Correctamente";
	}
	
	@PatchMapping ("/modificar")
	public String modificarPais(@RequestBody PaisDTO pais) {
		service.modificarPais(pais);
		return "Pais modificado Correctamente";
	}
	
	@PostMapping ("/eliminarPorLetra/{letra}")
	public String eliminarPorLetra(@PathVariable String letra) {
		StringBuffer stringb = new StringBuffer("");
		for(PaisDTO pais:service.obtieneporLetra(letra.toUpperCase())) {
			stringb.append(pais.getName());
			service.eliminarPais(pais.getId());
		}
		
		String anexo = stringb.toString().equals("")?"No borre nada":stringb.toString();
		return "Paises Eliminados :" + anexo ;
	}
	
	
	@PostMapping("/cambiaNombres")
	public List<PaisDTO> cambiaNombrePaises(){
		for(PaisDTO pais:service.obtienePaises()) {
			pais.setName(cambiaNombre(8));
			service.modificarPais(pais);
		}
		return service.obtienePaises();
	}
	
	
	private String cambiaNombre(int len) {
		String name = "";
		for (int i = 0; i < len; i++) {
		int v = 1 + (int) (Math.random() * 26);
		char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
		name += c;
		}
		return name;
	}
	
	
	@PostMapping ("/guardaPaises")
	public List<PaisDTO> guardaPaises(){
		String url= "https://api.first.org/data/v1/countries";
		RestTemplate rest= new RestTemplate();
		String respuesta= rest.getForObject(url, String.class);
		try {
			JSONObject jsonObject= new JSONObject(respuesta).getJSONObject("data");
			JSONArray array = jsonObject.names();
			for(int i=0;i<array.length();i++){
				service.agregarPais(new PaisDTO((String)jsonObject.getJSONObject(""+array.get(i)).get("country")));
            }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return service.obtienePaises();
	}
	
	
	

}
