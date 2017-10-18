package com.duongnv.spring.config;

import org.springframework.boot.actuate.endpoint.ConfigurationPropertiesReportEndpoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class BeanConfigurationPropertiesReportEndpoint extends ConfigurationPropertiesReportEndpoint {
	@Override
	protected void configureObjectMapper(ObjectMapper mapper) {
		super.configureObjectMapper(mapper);
		mapper.addMixIn(HikariDataSource.class, HikariDataSourceMixIn.class);
	}
}
