package com.duongnv.path.query.filter;

import java.util.List;

import com.duongnv.path.query.QueryException;
import com.duongnv.path.query.QueryParser;
import com.querydsl.core.types.Predicate;

public class WherePredicateBuilder {

	private PropertyEvaluater<?> evaluater;
	private WherePredicateGenerator<?> generator;

	public WherePredicateBuilder(PropertyEvaluater<?> evaluater, WherePredicateGenerator<?> generator) {
		this.evaluater = evaluater;
		this.generator = generator;
	}

	public Predicate build(Class<?> clazz, String query) {
		if (!evaluater.isSupport(clazz) || !generator.isSupport(clazz)) {
			throw new QueryException(
					String.format("Class %s is not match with evaluater or generator", clazz.getName()));
		}

		List<WhereCriteria> criterias = QueryParser.parseWhere(clazz, evaluater, query);

		return generator.get(criterias);
	}
}
