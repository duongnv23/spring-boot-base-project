package com.duongnv.spring.support;

import java.util.ArrayList;
import java.util.List;

import com.duongnv.spring.path.query.QueryException;
import com.duongnv.spring.path.query.filter.PropertyEvaluater;
import com.duongnv.spring.path.query.filter.WhereCriteria;
import com.duongnv.spring.web.rest.FilterParam;
import com.querydsl.core.types.Ops;

public class QueryDslSupport {

	private QueryDslSupport() {
	}

	public static final List<WhereCriteria> convert(Class<?> clazz, PropertyEvaluater evaluater,
			List<FilterParam> filterParams) {
		if (!evaluater.isSupport(clazz)) {
			throw new IllegalArgumentException(
					String.format("Class %s is not match with evaluater or whereGenerator", clazz.getName()));
		}

		List<WhereCriteria> criterias = new ArrayList<>();

		try {
		for (FilterParam filter : filterParams) {
			WhereCriteria criteria = new WhereCriteria();
			criteria.setField(filter.getField());
			criteria.setOps(Ops.valueOf(filter.getOperator().toUpperCase()));
			criteria.setValue(evaluater.getValue(filter.getField(), filter.getValue()));
			criterias.add(criteria);
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new QueryException(String.format("Can not convert to %s: %s",WhereCriteria.class, e.getMessage() ));
		}
		return criterias;
	}
}
