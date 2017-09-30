package com.duongnv.spring.path.query.order;

import java.util.List;

import com.querydsl.core.types.OrderSpecifier;

public interface OrderSpecifierGenerator {

	boolean isSupport(Class<?> cls);

	List<OrderSpecifier<?>> get(List<OrderCriteria> criterias);

}
