package cl.aiep.modulos.seguridad;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class ModuloSeguridad extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

    	http.httpBasic()
    	.and()
    	.authorizeRequests()
    	.antMatchers(HttpMethod.GET, "/obtiene/**").hasAuthority("USER")
    	.antMatchers(HttpMethod.POST, "/obtiene").hasAuthority("ADMIN")
	    .antMatchers(HttpMethod.PUT, "/obtiene/**").hasAuthority("ADMIN")
	    .antMatchers(HttpMethod.PUT, "/api/savePais/**").hasAuthority("ADMIN")
	    .antMatchers(HttpMethod.PATCH, "/obtiene/**").hasAuthority("ADMIN")
	    .antMatchers(HttpMethod.DELETE, "/obtiene/**").hasAuthority("ADMIN")
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().permitAll();    
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
	
	
//	@Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//  	auth.inMemoryAuthentication()
//              .withUser("user").password("{noop}password").roles("USER")
//              .and()
//              .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//
//  }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
    	.dataSource(dataSource);  	
    }

}
