package com.duongnv.path.query.filter;

import java.util.List;

import com.querydsl.core.types.Predicate;

public interface WherePredicateGenerator<T> {

	boolean isSupport(Class<?> clazz);

	Predicate get(List<WhereCriteria> criterias);
}
