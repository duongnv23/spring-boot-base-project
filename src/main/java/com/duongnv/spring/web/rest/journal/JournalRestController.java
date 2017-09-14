package com.duongnv.spring.web.rest.journal;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.service.journal.JournalDAOService;

@RestController
@RequestMapping(path = "/rest/journals")
public class JournalRestController {
	private static final Logger LOGGER = LogManager.getFormatterLogger(JournalRestController.class);

	@Autowired
	private JournalDAOService service;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Journal> get(@RequestParam("page") int page, @RequestParam("size") int size) {

		LOGGER.info("page=%s&size=%s", page, size);
		return service.findAll(new PageRequest(page, size));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Journal create(@Valid @RequestBody JournalRestPostRequest journalRestPostRequest) throws Exception {
		LOGGER.info(journalRestPostRequest);
//		LOGGER.info(bindingResult);
//		if (bindingResult.hasErrors()) {
//		}
		Journal journal = journalRestPostRequest.toJournal();
		service.save(journal);
		return journal;
	}

}
