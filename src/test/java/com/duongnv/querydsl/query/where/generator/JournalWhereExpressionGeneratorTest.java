package com.duongnv.querydsl.query.where.generator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.duongnv.path.query.QueryParser;
import com.duongnv.path.query.filter.PropertyEvaluater;
import com.duongnv.path.query.filter.WhereCriteria;
import com.duongnv.path.query.filter.WherePredicateGenerator;
import com.duongnv.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.path.query.filter.generator.JournalWhereExpressionGenerator;
import com.duongnv.spring.dao.entity.QJournal;
import com.querydsl.core.types.Predicate;

public class JournalWhereExpressionGeneratorTest {
	WherePredicateGenerator<QJournal> generator;
	PropertyEvaluater<QJournal> evaluater;
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
			criterias = QueryParser.parseWhere(QJournal.class, evaluater, query);
			Predicate predicate = generator.get(criterias);
			assertNotNull(predicate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
