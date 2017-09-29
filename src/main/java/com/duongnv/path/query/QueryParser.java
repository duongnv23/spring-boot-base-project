package com.duongnv.path.query;

import java.util.ArrayList;
import java.util.List;

import com.duongnv.path.query.filter.PropertyEvaluater;
import com.duongnv.path.query.filter.WhereCriteria;
import com.duongnv.path.query.order.OrderCriteria;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Order;

public class QueryParser {

	private static final String WHERE_FORMAT = "\"field operator value, field operator value\"";
	private static final String SORT_FORMAT = "\"field, asc; field, desc\"";

	private static final String ELEMENT_SEPARATOR = ";";
	private static final String PROPERTY_SEPARATOR = ",";

	private QueryParser() {
	}

	public static List<WhereCriteria> parseWhere(Class<?> clazz, PropertyEvaluater<?> evaluater, String filter) {
		
		if (!evaluater.isSupport(clazz)) {
			throw new QueryException("evaluater does not support class " + clazz.getName());
		}
		
		List<WhereCriteria> criterias = new ArrayList<>();
		if(filter == null || filter.isEmpty()) {
			return criterias;
		}

		String items[] = filter.split(ELEMENT_SEPARATOR);
		for (String item : items) {
			criterias.add(QueryParser.parseWhere(evaluater, item));
		}

		return criterias;
	}

	private static WhereCriteria parseWhere(PropertyEvaluater<?> evaluater, String criteria) {
		assert (criteria != null);

		String[] items = criteria.trim().split(PROPERTY_SEPARATOR);
		if (items.length != 3) {
			throw new QueryException("Query criteria is not in format: " + WHERE_FORMAT);
		}

		WhereCriteria queryCriteria = createWhereCriteria(evaluater, items);

		return queryCriteria;
	}

	private static WhereCriteria createWhereCriteria(PropertyEvaluater<?> evaluater, String[] items) {
		WhereCriteria queryCriteria = new WhereCriteria();
		queryCriteria.setField(items[0].trim());
		queryCriteria.setOps(Ops.valueOf(items[1].trim().toUpperCase()));
		queryCriteria.setRealValue(evaluater.getValue(queryCriteria.getField(), items[2].trim()));
		return queryCriteria;
	}

	public static List<OrderCriteria> parseOrder(String sort) {

		if (sort == null || sort.isEmpty()) {
			throw new QueryException(String.format("Sort %s invalid format: %s ", sort, SORT_FORMAT));
		}

		List<OrderCriteria> criterias = new ArrayList<>();

		String[] items = sort.split(ELEMENT_SEPARATOR);

		for (String item : items) {
			OrderCriteria criteria = new OrderCriteria();

			String[] elements = item.split(PROPERTY_SEPARATOR);
			if (elements.length != 2) {
				throw new QueryException(String.format("Element %s invalid format: %s", item, SORT_FORMAT));
			}

			criteria.setField(elements[0].trim());
			criteria.setOrder(Order.valueOf(elements[1].trim().toUpperCase()));

			criterias.add(criteria);
		}
		return criterias;
	}

}
