package cl.aiep.jwtDemo.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${app.secretKey}")
    private String secretKey;

	@Value("${app.appid}")
    private String idApp;

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
    		.and()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/getToken").hasAuthority("USER")
			.antMatchers(HttpMethod.GET, "/getToken").hasAuthority("ADMIN")
			.anyRequest().authenticated();
		
		http.csrf().disable();
	}

	
    
	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  	auth.inMemoryAuthentication()
	              .withUser("user").password("{noop}nana").authorities("USER")
	              .and()
	              .withUser("admin").password("{noop}password").authorities("USER", "ADMIN");

	  }
	
	public String getJWTToken(String username) {
		//String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId(idApp)
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
   

}
