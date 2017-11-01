package com.duongnv.spring.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.duongnv.spring.config.WebSecurityConfiguration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final Logger LOGGER = LogManager.getFormatterLogger(JsonUsernamePasswordAuthenticationFilter.class);

	public JsonUsernamePasswordAuthenticationFilter() {
		super();
	}

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private WebSecurityConfiguration configuration;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		String password = "";

		if ("application/json".equals(request.getHeader("Content-Type"))) {
			try {

				// json transformation
				JsonNode jsonNode = mapper.readTree(request.getReader());
//				username = jsonNode.get(configuration.getUsernameParameter()).asText("").trim();
//				password = jsonNode.get(configuration.getPasswordParameter()).asText("");

			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			}

			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
			
			// Allow subclasses to set the "details" property
			setDetails(request, authRequest);
			return this.getAuthenticationManager().authenticate(authRequest);
		}

		return super.attemptAuthentication(request, response);
	}
}
