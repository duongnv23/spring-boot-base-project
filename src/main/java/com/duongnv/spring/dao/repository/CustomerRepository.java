package com.duongnv.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.duongnv.spring.dao.entity.Customer;
import com.duongnv.spring.service.customer.Cust;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Procedure(procedureName = "plus1")
	public Long plus1(Long arg);

	@Query(name = "custQuery")
	public Cust findSomeThing(@Param("id") Long id);
}
