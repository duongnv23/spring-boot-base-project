package com.duongnv.spring.web.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duongnv.spring.dao.entity.Customer;
import com.duongnv.spring.dao.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/rest/customers")
public class CustomerRestController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> customers() {
		return repository.findAll();
	}

}
