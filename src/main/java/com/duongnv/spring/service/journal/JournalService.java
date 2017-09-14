package com.duongnv.spring.service.journal;

import java.text.ParseException;

import com.duongnv.spring.dao.entity.Journal;

public interface JournalService {
	public void insertDatas() throws ParseException;

	public Iterable<Journal> findAll();
}
