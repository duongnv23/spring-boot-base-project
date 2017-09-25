package com.duongnv.path.query.order;

import com.querydsl.core.types.Order;

public class OrderCriteria {
	private String field;
	private Order order;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderCriteria [field=" + field + ", order=" + order + "]";
	}

}
