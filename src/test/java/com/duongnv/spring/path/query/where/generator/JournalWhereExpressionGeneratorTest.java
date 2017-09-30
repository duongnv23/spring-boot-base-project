package com.duongnv.spring.path.query.where.generator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.duongnv.spring.dao.entity.QJournal;
import com.duongnv.spring.path.query.filter.PropertyEvaluater;
import com.duongnv.spring.path.query.filter.WhereCriteria;
import com.duongnv.spring.path.query.filter.WherePredicateGenerator;
import com.duongnv.spring.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.spring.path.query.filter.generator.JournalWhereExpressionGenerator;
import com.querydsl.core.types.Predicate;

public class JournalWhereExpressionGeneratorTest {
	WherePredicateGenerator generator;
	PropertyEvaluater evaluater;
	List<WhereCriteria> criterias;

	@Before
	public void init() throws Exception {
		generator = new JournalWhereExpressionGenerator();
		evaluater = new JournalPropertiesEvaluate();
	}

	@Test
	public void test() {
		String query = "id,gt,1; id loe 4, title like %111% ";
		try {
//			criterias = QueryDslUtils.parseWhere(QJournal.class, evaluater, query);
			Predicate predicate = generator.get(criterias);
			assertNotNull(predicate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
