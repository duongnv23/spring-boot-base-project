package com.duongnv.path.query.order;

import java.util.List;

import com.querydsl.core.types.OrderSpecifier;

public interface OrderSpecifierGenerator<T> {

	boolean isSupport(Class<?> cls);

	List<OrderSpecifier<?>> get(List<OrderCriteria> criterias);

}
