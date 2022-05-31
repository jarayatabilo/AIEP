package cl.aiep.jwtDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.jwtDemo.dto.UserDTO;
import cl.aiep.jwtDemo.security.SpringSecurityConfig;

@RestController
public class UserController {

	@Autowired
	SpringSecurityConfig secure;
	
	@GetMapping("/getToken")
	@PreAuthorize("isAuthenticated()")
	public UserDTO login() {
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
	    User usuario= (User) auth.getPrincipal();
	    
		String token = secure.getJWTToken(usuario.getUsername());
		UserDTO user = new UserDTO();
		user.setUser(usuario.getUsername());
		user.setToken(token);		
		return user;
	}

	
}
