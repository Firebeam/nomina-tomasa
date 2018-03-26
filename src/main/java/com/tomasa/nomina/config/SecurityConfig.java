package com.tomasa.nomina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*static {
		SecurityContextHolder.setStrategyName(VaadinSessionSecurityContextHolderStrategy.class.getName());
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable() // Use Vaadin's CSRF protection
				.authorizeRequests().anyRequest().authenticated() // User must be authenticated to access any part of the application
				.and()
				.httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/*"); // Static resources are ignored
	}
}
