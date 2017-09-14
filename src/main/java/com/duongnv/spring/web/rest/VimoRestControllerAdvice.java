package com.duongnv.spring.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;

@Order(1)
@RestControllerAdvice
public class VimoRestControllerAdvice {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(SQLGrammarException.class)
	public Error sqlGrammarExceptionHandler(SQLGrammarException exception) {
		Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, exception.getLocalizedMessage(),
				exception.getErrorCode());

		return error;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public Error badInputException(IllegalArgumentException exception) {
		Error error = new Error(HttpStatus.BAD_REQUEST, exception.getMessage(), 100);
		return error;
	}

	@ExceptionHandler(MultipartException.class)
	public Error multipartException(HttpServletRequest request, MultipartException exception) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

		Error error = new Error(HttpStatus.BAD_REQUEST, exception.getMessage(), 101);

		if (statusCode != null) {
			error = new Error(HttpStatus.valueOf(statusCode), exception.getMessage(), 101);
		}

		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ApiErrorsView handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		BindingResult bindingResult = ex.getBindingResult();

		List<ApiFieldError> apiFieldErrors = bindingResult.getFieldErrors().stream()
				.map(fieldError -> new ApiFieldError(fieldError.getField(), fieldError.getCode(),
						fieldError.getRejectedValue(),
						messageSource.getMessage(fieldError.getCode(), fieldError.getArguments(), request.getLocale())))
				.collect(Collectors.toList());

		List<ApiGlobalError> apiGlobalErrors = bindingResult.getGlobalErrors().stream()
				.map(globalError -> new ApiGlobalError(globalError.getCode())).collect(Collectors.toList());

		ApiErrorsView apiErrorsView = new ApiErrorsView(apiFieldErrors, apiGlobalErrors);

		return apiErrorsView;
	}
}
