package com.duongnv.spring.dao.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.entity.QJournal;
import com.duongnv.spring.path.query.filter.PropertyEvaluater;
import com.duongnv.spring.path.query.filter.WhereCriteria;
import com.duongnv.spring.path.query.filter.WherePredicateGenerator;
import com.duongnv.spring.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.spring.path.query.filter.generator.JournalWhereExpressionGenerator;
import com.duongnv.spring.path.query.order.OrderCriteria;
import com.duongnv.spring.path.query.order.OrderSpecifierGenerator;
import com.duongnv.spring.path.query.order.generator.JournalOderSpecifierGenerator;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JournalRepositoryTest {

	@Autowired
	private JournalRepository repository;

	WherePredicateGenerator generator;
	PropertyEvaluater evaluater;
	List<WhereCriteria> criterias;

	OrderSpecifierGenerator orderSpecifierGenerator;
	List<OrderCriteria> orderCriterias;

	@Before
	public void init() throws Exception {
		generator = new JournalWhereExpressionGenerator();
		evaluater = new JournalPropertiesEvaluate();
		orderSpecifierGenerator = new JournalOderSpecifierGenerator();
	}

	// @Test
	public void test() {
		String query = "title,like_ic,%dE%; id,goe,2 ; id,lt,3";
		try {
			// criterias = QueryDslUtils.parseWhere(QJournal.class, evaluater, query);
			Predicate predicate = generator.get(criterias);
			assertNotNull(predicate);
			System.out.println(predicate);
			Iterable<Journal> journals = repository.findAll(predicate);

			for (Journal journal : journals) {
				System.out.println(journal);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
