package com.duongnv.path.query.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.types.Ops;

public class WhereCriteria {

	private String field;
	private Ops ops;
	private String value;
	@JsonIgnore
	private Object realValue;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Object getRealValue() {
		return realValue;
	}

	public void setRealValue(Object value) {
		this.realValue = value;
	}

	@Override
	public String toString() {
		return "WhereCriteria [field=" + field + ", ops=" + ops + ", value=" + value + ", realValue=" + realValue + "]";
	}

}
