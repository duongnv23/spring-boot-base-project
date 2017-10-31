package com.duongnv.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

import com.duongnv.spring.auth.MyUserDetailsService;

@Configuration
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//			.addFilterBefore(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.csrf().disable()
			
			.httpBasic().realmName("My Spring Application, Duong123")
			// .and().requiresChannel().anyRequest().requiresSecure()
			.and().authorizeRequests().antMatchers(HttpMethod.GET).permitAll().anyRequest().authenticated()
//			.and().formLogin().loginProcessingUrl("/login").usernameParameter(usernameParameter).passwordParameter(passwordParameter)
//			.and().logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
			.and().requestCache().requestCache(new NullRequestCache())
			;

	}
	// @formatter:on

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		// authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

}
