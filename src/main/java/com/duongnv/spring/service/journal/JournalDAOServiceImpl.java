package com.duongnv.spring.service.journal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.repository.JournalRepository;
import com.querydsl.core.types.Predicate;

@Service
public class JournalDAOServiceImpl implements JournalDAOService {

	@Autowired
	private JournalRepository repository;

	@Override
	@Transactional
	public Journal save(Journal entity) {
		return repository.save(entity);
	}

	@Override
	public Page<Journal> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<Journal> findAll(Predicate predicate, Pageable pageable) {
		return repository.findAll(predicate, pageable);
	}

}
