package com.duongnv.spring.web.rest.journal;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.entity.QJournal;
import com.duongnv.spring.path.query.QueryPredicateBuilder;
import com.duongnv.spring.path.query.filter.PropertyEvaluater;
import com.duongnv.spring.path.query.filter.WherePredicateGenerator;
import com.duongnv.spring.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.spring.path.query.filter.generator.JournalWhereExpressionGenerator;
import com.duongnv.spring.service.journal.JournalDAOService;
import com.duongnv.spring.support.QueryDslSupport;
import com.duongnv.spring.web.rest.PageRequestParam;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(path = "/rest/journals")
public class JournalRestController {
	private static final Logger LOGGER = LogManager.getFormatterLogger(JournalRestController.class);

	@Autowired
	private JournalDAOService service;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private QueryPredicateBuilder builder;

	@RequestMapping(method = RequestMethod.GET)
	
	public Page<Journal> get(@RequestParam String param) throws JsonParseException, JsonMappingException, IOException {

		LOGGER.info("params=%s", param);

		PageRequestParam requestParam = mapper.readValue(param, PageRequestParam.class);

		LOGGER.info(requestParam);

		WherePredicateGenerator generator = new JournalWhereExpressionGenerator();
		PropertyEvaluater evaluater = new JournalPropertiesEvaluate();

		Predicate predicate = builder.buildWhere(QJournal.class, generator,
				QueryDslSupport.convert(QJournal.class, evaluater, requestParam.getFilters()));

		return service.findAll(predicate, new QPageRequest(requestParam.getPage(), requestParam.getSize()));
	}

	@RequestMapping(method = RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Journal create(@Valid @RequestBody JournalRestPostRequest journalRestPostRequest) throws Exception {
		LOGGER.info(journalRestPostRequest);
		
		Journal journal = journalRestPostRequest.toJournal();
		service.save(journal);
		return journal;
	}

}
