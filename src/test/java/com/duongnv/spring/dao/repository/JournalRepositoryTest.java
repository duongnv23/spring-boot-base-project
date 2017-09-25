package com.duongnv.spring.dao.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.duongnv.path.query.QueryParser;
import com.duongnv.path.query.filter.PropertyEvaluater;
import com.duongnv.path.query.filter.WhereCriteria;
import com.duongnv.path.query.filter.WherePredicateGenerator;
import com.duongnv.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.path.query.filter.generator.JournalWhereExpressionGenerator;
import com.duongnv.path.query.order.OrderCriteria;
import com.duongnv.path.query.order.OrderSpecifierGenerator;
import com.duongnv.path.query.order.generator.JournalOderSpecifierGenerator;
import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.entity.QJournal;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JournalRepositoryTest {

	@Autowired
	private JournalRepository repository;

	WherePredicateGenerator<QJournal> generator;
	PropertyEvaluater<QJournal> evaluater;
	List<WhereCriteria> criterias;

	OrderSpecifierGenerator<QJournal> orderSpecifierGenerator;
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
			criterias = QueryParser.parseWhere(QJournal.class, evaluater, query);
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

	@Test
	public void testOrder() {
		String sort = "title, desc; id,asc";
		try {
			orderCriterias = QueryParser.parseOrder(sort);
			for (OrderCriteria criteria : orderCriterias) {
				System.out.println(criteria);
			}
			assertNotNull(orderCriterias);

			List<OrderSpecifier<?>> specifiers = orderSpecifierGenerator.get(orderCriterias);
			assertTrue(specifiers.size() > 0);

			Iterable<Journal> journals = repository.findAll(specifiers.toArray(new OrderSpecifier<?>[0]));
			for (Journal journal : journals) {
				System.out.println(journal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
