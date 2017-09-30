package com.duongnv.spring.path.query.filter;

import com.querydsl.core.types.Ops;

public class WhereCriteria {

	private String field;
	private Ops ops;
	private Object value;

	public String getField() {
		return field;
	}

	public void setField(String key) {
		this.field = key;
	}

	public Ops getOps() {
		return ops;
	}

	public void setOps(Ops ops) {
		this.ops = ops;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "WhereCriteria [field=" + field + ", ops=" + ops + ", value=" + value + "]";
	}

}
