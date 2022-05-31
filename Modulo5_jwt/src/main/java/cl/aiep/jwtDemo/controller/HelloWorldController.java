package cl.aiep.jwtDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@RestController
public class HelloWorldController {
	
	@Value("${app.secretKey}")
    private String secretKey;
	
	private final String prefix="Bearer";

	@GetMapping("/hello")
	public String helloWorld(@RequestHeader("Authorization") String token, @RequestParam(value="name", defaultValue="World") String name) {
		
//		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//		String user= Jwts.parser()
//        .setSigningKey(secretKey.getBytes())
//        .parseClaimsJws(token.replace(prefix, ""))
//        .getBody()
//        .getSubject();
		
		Jws<Claims> user= Jwts.parser()
		        .setSigningKey(secretKey.getBytes())
		        .parseClaimsJws(token.replace(prefix, ""));
		        
		
		
		return "Hello "+name+"!!";
	}
}
