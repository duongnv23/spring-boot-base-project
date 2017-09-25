package com.duongnv.spring.web.rest;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Error {

	@JsonFormat(shape=Shape.OBJECT)
	private HttpStatus status = HttpStatus.NOT_FOUND;
	private String message = HttpStatus.NOT_FOUND.getReasonPhrase();
	private int code = 0;

	public Error() {
	}

	public Error(HttpStatus httpStatus, String message, int code) {
		this.status = httpStatus;
		this.message = message;
		this.code = code;
	}

	public Error(HttpStatus httpStatus, int code) {
		this.status = httpStatus;
		this.message = httpStatus.getReasonPhrase();
		this.code = code;
	}

	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
