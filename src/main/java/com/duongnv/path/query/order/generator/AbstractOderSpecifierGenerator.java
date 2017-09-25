package com.duongnv.path.query.order.generator;

import java.util.ArrayList;
import java.util.List;

import com.duongnv.path.query.order.OrderCriteria;
import com.duongnv.path.query.order.OrderSpecifierGenerator;
import com.duongnv.spring.dao.entity.Journal;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;

public abstract class AbstractOderSpecifierGenerator<T> implements OrderSpecifierGenerator<T> {

	protected List<OrderSpecifier<?>> createOrder(List<OrderCriteria> criterias, PathBuilder<Journal> entityBuilder) {
		List<OrderSpecifier<?>> specifiers = new ArrayList<>();

		for (OrderCriteria criteria : criterias) {
			Expression<Object> path = entityBuilder.get(criteria.getField());
			specifiers.add(new OrderSpecifier(criteria.getOrder(), path));
		}

		return specifiers;
	}

}
