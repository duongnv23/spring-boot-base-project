package com.duongnv.spring.web.rest;

public class ApiGlobalError {
	private String code;

	public ApiGlobalError() {
	}

	public ApiGlobalError(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
