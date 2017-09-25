package com.duongnv.path.query.filter.evaluate;

import com.duongnv.path.query.QueryException;
import com.duongnv.path.query.filter.PropertyEvaluater;
import com.duongnv.spring.dao.entity.QJournal;

public class JournalPropertiesEvaluate implements PropertyEvaluater<QJournal> {

	@Override
	public Object getValue(String property, String value) {
		QJournal qEntiry = QJournal.journal;
		Object result = null;
		try {
			if (qEntiry.id.getMetadata().getName().equalsIgnoreCase(property)) {
				result = qEntiry.id.getType().getMethod(valueOf, String.class).invoke(qEntiry.id.getType(), value);
			} else if (qEntiry.title.getMetadata().getName().equalsIgnoreCase(property)) {
				result = value;
			} else if (qEntiry.summary.getMetadata().getName().equalsIgnoreCase(property)) {
				result = value;
			} else if (qEntiry.created.getMetadata().getName().equalsIgnoreCase(property)) {
				result = qEntiry.created.getType().getMethod(valueOf, String.class).invoke(qEntiry.created.getType(),
						value);
			}

		} catch (Exception e) {
			throw new QueryException(String.format("invoke %s.%s.%s(%s) has error: %s ", qEntiry.getClass().getName(),
					property, valueOf, value, e.getMessage()), e);
		}

		if (result == null) {
			throw new QueryException(String.format("Field '%s' does not support for filtering", property));
		}
		return result;
	}

	@Override
	public boolean isSupport(Class<?> clazz) {
		return QJournal.class.isAssignableFrom(clazz);
	}

}
