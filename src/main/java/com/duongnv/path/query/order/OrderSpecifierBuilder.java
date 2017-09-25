package com.duongnv.path.query.order;

import java.util.List;

import com.duongnv.path.query.QueryException;
import com.duongnv.path.query.QueryParser;
import com.querydsl.core.types.OrderSpecifier;

public class OrderSpecifierBuilder {

	private OrderSpecifierGenerator<?> generator;

	public OrderSpecifierBuilder(OrderSpecifierGenerator<?> generator) {
		this.generator = generator;
	}

	public List<OrderSpecifier<?>> build(Class<?> cls, String order) {
		if (!generator.isSupport(cls)) {
			throw new QueryException("generator does not support class " + cls);
		}

		List<OrderCriteria> criterias = QueryParser.parseOrder(order);

		return generator.get(criterias);
	}
}
