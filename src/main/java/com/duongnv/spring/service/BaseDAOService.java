package com.duongnv.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseDAOService<T> {

	Page<T> findAll(Pageable pageable);

	T save(T entity);

}
