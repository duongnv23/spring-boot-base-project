package com.duongnv.spring.web.rest.journal;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duongnv.path.query.QueryParser;
import com.duongnv.path.query.filter.PropertyEvaluater;
import com.duongnv.path.query.filter.WhereCriteria;
import com.duongnv.path.query.filter.WherePredicateGenerator;
import com.duongnv.path.query.filter.evaluate.JournalPropertiesEvaluate;
import com.duongnv.path.query.filter.generator.JournalWhereExpressionGenerator;
import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.dao.entity.QJournal;
import com.duongnv.spring.service.journal.JournalDAOService;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(path = "/rest/journals")
public class JournalRestController {
	private static final Logger LOGGER = LogManager.getFormatterLogger(JournalRestController.class);

	@Autowired
	private JournalDAOService service;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Journal> get(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "20") int size,
			@RequestParam(name = "filter", required = false) String filter,
			@RequestParam(name = "sort", required = false) String sort) {

		LOGGER.info("page=%s&size=%s", page, size);
		LOGGER.info("sort=%s", sort);
		LOGGER.info("filter=%s", filter);

		WherePredicateGenerator<QJournal> generator = new JournalWhereExpressionGenerator();
		PropertyEvaluater<QJournal> evaluater = new JournalPropertiesEvaluate();

		List<WhereCriteria> criterias = QueryParser.parseWhere(QJournal.class, evaluater, filter);
		Predicate predicate = generator.get(criterias);

		// Long.valueOf(s)
		return service.findAll(predicate, new QPageRequest(page, size));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Journal create(@Valid @RequestBody JournalRestPostRequest journalRestPostRequest) throws Exception {
		LOGGER.info(journalRestPostRequest);
		// LOGGER.info(bindingResult);
		// if (bindingResult.hasErrors()) {
		// }
		Journal journal = journalRestPostRequest.toJournal();
		service.save(journal);
		return journal;
	}

}
