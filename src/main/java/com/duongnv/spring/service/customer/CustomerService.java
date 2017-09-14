package com.duongnv.spring.service.customer;

import java.util.List;

import com.duongnv.spring.dao.entity.Customer;

public interface CustomerService {
	Long callPlus1Procedure(Long arg);

	List<Customer> callSearchCustomerProcedure(String name, String email);
	
	Cust findById(Long id);
}
