package vn.vimo.core.web.rest;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.duongnv.spring.dao.entity.QJournal;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class QueryDslParserTest {

	@Test
	public void testparserQuery() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String query = "id eq 123";

		String valueString = "123";
		Long value = (Long) QJournal.journal.id.getType().getMethod("valueOf", String.class)
				.invoke(QJournal.journal.id.getType(), valueString);
		assertTrue(valueString.equals(value.toString()));
	}

}
