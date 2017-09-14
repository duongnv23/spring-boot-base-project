package com.duongnv.spring.service.journal;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.repository.JournalRepository;

@Service
public class JournalServiceImpl implements JournalService{

	private static final Logger log = LogManager.getFormatterLogger(JournalServiceImpl.class);

	@Autowired
	JournalRepository repo;

	public void insertDatas() throws ParseException {
		log.info("> Inserting data...");
		repo.save(new Journal(1L,"Get to know Spring Boot", "Today I will learn Spring Boot", "01/01/2016"));
		repo.save(new Journal(2L,"Simple Spring Boot Project", "I will do my first Spring Boot Project", "01/02/2016"));
		repo.save(new Journal(3L,"Spring Boot Reading", "Read more about Spring Boot", "02/01/2016"));
		repo.save(new Journal(4L,"Spring Boot in the Cloud", "Spring Boot using Cloud Foundry", "03/01/2016"));
		log.info("> Done.");
	}

	public Iterable<Journal> findAll() {
		return repo.findAll();
	}
}
