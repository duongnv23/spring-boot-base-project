package com.duongnv.querydsl.query;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.duongnv.path.query.QueryParser;
import com.duongnv.path.query.filter.PropertyEvaluater;
import com.duongnv.path.query.filter.WhereCriteria;
import com.duongnv.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.spring.dao.entity.QJournal;

public class QueryParserTest {

	PropertyEvaluater<QJournal> evaluater;

	@Before
	public void init() {
		evaluater = new JournalPropertiesEvaluate();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseQueryThrowIllegalArgumentException1() {
		String query = "";
		QueryParser.parseWhere(QJournal.class, evaluater, query);

	}

	@Test
	public void testParseQuery() {
		String query = "id eq 123, title like %tit%";

		List<WhereCriteria> criterias = QueryParser.parseWhere(QJournal.class, evaluater, query);
		for (WhereCriteria criteria : criterias) {
			System.out.println(criteria);
		}

		assertTrue(!criterias.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseQueryThrowIllegalArgumentException2() {
		String query = "id eq 123, title like123 %tit%";

		List<WhereCriteria> criterias = QueryParser.parseWhere(QJournal.class, evaluater, query);
		for (WhereCriteria criteria : criterias) {
			System.out.println(criteria);
		}

		assertTrue(!criterias.isEmpty());
	}
}
