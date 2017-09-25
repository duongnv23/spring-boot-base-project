package com.duongnv.path.query.filter.generator;

import java.util.List;

import com.duongnv.path.query.filter.WhereCriteria;
import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.entity.QJournal;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;

public class JournalWhereExpressionGenerator extends AbstractWhereExpressionGenerator<QJournal> {

	@Override
	public boolean isSupport(Class<?> clazz) {
		return QJournal.class.isAssignableFrom(clazz);
	}

	@Override
	public Predicate get(List<WhereCriteria> criterias) {
		PathBuilder<Journal> entityBuilder = new PathBuilder<>(QJournal.journal.getType(), QJournal.journal.getMetadata().getName());

		List<Predicate> predicates = createQuery(criterias, entityBuilder);

		return ExpressionUtils.allOf(predicates);
	}

}
