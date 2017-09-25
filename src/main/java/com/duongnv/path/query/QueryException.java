package com.duongnv.path.query;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class QueryException extends RuntimeException {
	public QueryException(String message) {
		super(message);
	}

	public QueryException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
