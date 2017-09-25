package com.duongnv.path.query.filter;


public interface PropertyEvaluater<T> {

	final String valueOf = "valueOf";

	boolean isSupport(Class<?> clazz);

	Object getValue(String property, String value) ;
}
