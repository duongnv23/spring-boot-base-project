package com.duongnv.spring.config;

import java.io.PrintWriter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zaxxer.hikari.HikariConfigMXBean;

public abstract class HikariDataSourceMixIn {
	@JsonIgnore
	abstract PrintWriter getLogWriter();

	@JsonIgnore
	abstract HikariConfigMXBean getHikariConfigMXBean();

}
