package com.lastm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 
 * Security configuration Class
 * 
 * @author Gabriel Martin 
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// Authentication : User --> Roles
		auth.inMemoryAuthentication().withUser("user").password("pass")
				.roles("USER").and().withUser("admin").password("admin")
				.roles("USER", "ADMIN");
	}

	
	protected void configure(HttpSecurity http) throws Exception {
		// Authorization : Role -> Access
		http.httpBasic().and().authorizeRequests().antMatchers("/lastm/**")
				.hasRole("USER").antMatchers("/fare/**").hasRole("USER")
				.antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
				.headers().frameOptions().disable();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		//Why?
		//https://www.harinathk.com/spring/no-passwordencoder-mapped-id-null/
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
 
}
