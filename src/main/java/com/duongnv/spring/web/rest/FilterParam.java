package com.duongnv.spring.web.rest;

public class FilterParam {

	private String field;
	private String operator;
	private String value;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FilterParam [field=" + field + ", operator=" + operator + ", value=" + value + "]";
	}

}
