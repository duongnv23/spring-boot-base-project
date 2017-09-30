package com.duongnv.spring.path.query.filter;


public interface PropertyEvaluater {

	final String valueOf = "valueOf";

	boolean isSupport(Class<?> clazz);

	Object getValue(String property, String value) ;
}
