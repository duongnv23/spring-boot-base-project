package com.duongnv.spring.web.rest;

public class SortParam {

	private String field;
	private String order;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "SortParam [field=" + field + ", order=" + order + "]";
	}

}
