package com.duongnv.spring.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class VimoRestControllerAdvice extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

}
