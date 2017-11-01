package com.duongnv.spring.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

}
