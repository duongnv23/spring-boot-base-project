package com.duongnv.spring.web.rest;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class RestResponse<T> {

	@JsonFormat(shape = Shape.NUMBER_INT)
	private HttpStatus status;
	private String message;
	private int code;
	private T data;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus httpStatus) {
		this.status = httpStatus;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestResponse [status=" + status + ", message=" + message + ", code=" + code + ", data=" + data + "]";
	}

}
