package com.duongnv.spring.path.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duongnv.spring.path.query.filter.WhereCriteria;
import com.duongnv.spring.path.query.filter.WherePredicateGenerator;
import com.duongnv.spring.path.query.order.OrderCriteria;
import com.duongnv.spring.path.query.order.OrderSpecifierGenerator;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

@Service
public class QueryPredicateBuilder {

	public Predicate buildWhere(Class<?> clazz, WherePredicateGenerator whereGenerator, List<WhereCriteria> criterias) {

		if (!whereGenerator.isSupport(clazz)) {
			throw new QueryException(String.format("Class %s is not support by Generator %s", clazz.getName(),
					whereGenerator.getClass()));
		}

		return whereGenerator.get(criterias);

	}

	public List<OrderSpecifier<?>> buildOrder(Class<?> cls, OrderSpecifierGenerator generator,
			List<OrderCriteria> criterias) {

		if (!generator.isSupport(cls)) {
			throw new QueryException(
					String.format("Class %s does not support by Generator %s", cls, generator.getClass()));
		}

		return generator.get(criterias);

	}

}
