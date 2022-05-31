package cl.aiep.jwtDemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
	    User usuario= (User) auth.getPrincipal();
		return "Hello "+name+"!!";
	}
}
