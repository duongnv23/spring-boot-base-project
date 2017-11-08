package com.duongnv.spring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

import com.duongnv.spring.auth.MyUserDetailsService;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LogManager.getFormatterLogger(WebSecurityConfiguration.class);

	@Autowired
	private Environment environment;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
        http
            .csrf().disable()
            .httpBasic().realmName("My Spring Application, Duong123")
            .and().requestCache().requestCache(new NullRequestCache())
            .and().formLogin().loginProcessingUrl("vimo-secret-login")
            .and().logout().logoutUrl("vimo-secret-logout")
            ;
        // @formatter:on

		String[] activeProfiles = environment.getActiveProfiles();
		if (activeProfiles != null && activeProfiles.length > 0) {
			for (String activeProfile : activeProfiles) {
				if ("test".equalsIgnoreCase(activeProfile) || "prod".equalsIgnoreCase(activeProfile)) {
					http.requiresChannel().anyRequest().requiresSecure();
					LOGGER.info("profile %s is actived -> HTTPS required ", activeProfile);
					break;
				}
			}
		}

	}

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
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

}
