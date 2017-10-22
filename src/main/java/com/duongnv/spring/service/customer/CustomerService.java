package com.duongnv.spring.service.customer;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.duongnv.spring.dao.entity.Customer;


public interface CustomerService {

	final Logger LOGGER = LogManager.getFormatterLogger(CustomerService.class);

	Long callPlus1Procedure(Long arg);

	List<Customer> callSearchCustomerProcedure(String name, String email);

	Cust findById(Long id);

	boolean isPhoneAvaliableForRegister(String phoneNumber);
	
	int createCustomer(String customerName);
}
