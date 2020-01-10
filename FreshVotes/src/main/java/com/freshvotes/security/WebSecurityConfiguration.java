package com.freshvotes.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//Creating and authentication method
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("programmerolajide@gmail.com")
			.password("promise123@")
			.roles("USER");
	}
	
	//Creating an authorization method
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().hasRole("USER").and()
		.formLogin()
			.loginPage("/login")
			.permitAll().and()
		.logout()
			.logoutUrl("/logout")
			.permitAll();
	}
	
}
