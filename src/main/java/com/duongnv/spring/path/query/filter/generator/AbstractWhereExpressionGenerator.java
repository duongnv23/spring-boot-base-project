package com.duongnv.spring.path.query.filter.generator;

import java.util.ArrayList;
import java.util.List;

import com.duongnv.spring.path.query.QueryException;
import com.duongnv.spring.path.query.filter.WhereCriteria;
import com.duongnv.spring.path.query.filter.WherePredicateGenerator;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

public abstract class AbstractWhereExpressionGenerator implements WherePredicateGenerator {

	protected BooleanExpression createStringPrediate(WhereCriteria criteria, PathBuilder<?> entityBuilder) {
		StringPath path = entityBuilder.getString(criteria.getField());
		String value = (String) criteria.getValue();
		switch (criteria.getOps()) {
		case LIKE:
			return path.like(value);
		case LIKE_IC:
			return path.likeIgnoreCase(value);
		case EQ:
			return path.eq(value);
		case EQ_IGNORE_CASE:
			return path.equalsIgnoreCase(value);
		case STARTS_WITH:
			return path.startsWith(value);
		case STARTS_WITH_IC:
			return path.startsWithIgnoreCase(value);
		case ENDS_WITH:
			return path.endsWith(value);
		case ENDS_WITH_IC:
			return path.endsWithIgnoreCase(value);
		default:
			throw new QueryException(String.format("operator %s not support", criteria.getOps()));
		}
	}

	protected BooleanExpression createLongPrediate(WhereCriteria criteria, PathBuilder<?> entityBuilder) {
		NumberPath<Long> path = entityBuilder.getNumber(criteria.getField(), Long.class);
		Long value = (Long) criteria.getValue();
		switch (criteria.getOps()) {
		case EQ:
			return path.eq(value);
		case GT:
			return path.gt(value);
		case GOE:
			return path.goe(value);
		case LT:
			return path.lt(value);
		case LOE:
			return path.loe(value);
		default:
			throw new QueryException(String.format("operator %s not support", criteria.getOps()));
		}
	}

	protected BooleanExpression createQuery(WhereCriteria criteria, PathBuilder<?> entityBuilder) {
		if (criteria.getValue() instanceof String) {
			return createStringPrediate(criteria, entityBuilder);
		} else if (criteria.getValue() instanceof Long) {
			return createLongPrediate(criteria, entityBuilder);
		} else {
			throw new QueryException(String.format("Can't not create expression for this criteria: % ", criteria));
		}
	}

	protected List<Predicate> createQuery(List<WhereCriteria> criterias, PathBuilder<?> entityBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		try {
			for (WhereCriteria criteria : criterias) {
				predicates.add(createQuery(criteria, entityBuilder));
			}
		} catch (Exception e) {
			throw new QueryException(String.format("Can not create predicate for filters: + %s", e.getMessage()), e);
		}
		return predicates;
	}
}
