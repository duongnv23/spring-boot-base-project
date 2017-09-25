package com.duongnv.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

public interface BaseDAOService<T> {

	Page<T> findAll(Pageable pageable);
	
	Page<T> findAll(Predicate predicate, Pageable pageable);
	
	T save(T entity);

}
