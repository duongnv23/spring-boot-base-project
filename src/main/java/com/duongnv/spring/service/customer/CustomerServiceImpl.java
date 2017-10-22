package com.duongnv.spring.service.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duongnv.spring.dao.entity.Customer;
import com.duongnv.spring.dao.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public Long callPlus1Procedure(Long arg) {
		return repository.plus1(arg);
	}

	@Override
	public List<Customer> callSearchCustomerProcedure(String name, String email) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("Customer.searchCustomer");
		query.setParameter("name", name);
		query.setParameter("email", email);
		query.execute();

		return query.getResultList();
	}

	@Override
	public Cust findById(Long id) {
		return repository.findSomeThing(id);
	}

	@Override
	public boolean isPhoneAvaliableForRegister(String phoneNumber) {
		LOGGER.info("check phonenumber %s can be register", phoneNumber);
		return true;
	}

	@Override
	public int createCustomer(String customerName) {
		LOGGER.info("create customer: %s", customerName);
		return 0;
	}

}
