package com.springboot.rest.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//has been blocked by CORS policy: Response to preflight request
		// 1. we need to disable the CROSS policy i.e. csrf().disable
		// 2.per OPTIONS we need to allow all URL 
		

		http
		    .csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
			.anyRequest().authenticated()
			.and()
			//.formLogin().and()
			.httpBasic();
	}	
	
}
