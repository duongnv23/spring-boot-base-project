package com.duongnv.spring.path.query.order.generator;

import java.util.List;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.entity.QJournal;
import com.duongnv.spring.path.query.order.OrderCriteria;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;

public class JournalOderSpecifierGenerator extends AbstractOderSpecifierGenerator<QJournal> {

	@Override
	public boolean isSupport(Class<?> cls) {
		return QJournal.class.isAssignableFrom(cls);
	}

	@Override
	public List<OrderSpecifier<?>> get(List<OrderCriteria> criterias) {
		PathBuilder<Journal> entityBuilder = new PathBuilder<>(QJournal.journal.getType(),
				QJournal.journal.getMetadata().getName());

		List<OrderSpecifier<?>> orderSpecifiers = createOrder(criterias, entityBuilder);

		return orderSpecifiers;
	}

}
