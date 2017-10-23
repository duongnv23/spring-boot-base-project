package com.duongnv.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().realmName("My Spring Application, Duong123")
				// .and().requiresChannel().anyRequest().requiresSecure()
				.and().authorizeRequests().antMatchers(HttpMethod.GET).permitAll().anyRequest().authenticated()
				.and().formLogin().loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
				.and().logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
				;
		
	}
	
	
	
}
