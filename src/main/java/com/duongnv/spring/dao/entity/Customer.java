package com.duongnv.spring.dao.entity;

import java.util.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;

import com.duongnv.spring.service.customer.Cust;

@Entity
@NamedStoredProcedureQuery(name = "Customer.searchCustomer", procedureName = "search_customer", resultClasses = Customer.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "customers", type = void.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class) })

@SqlResultSetMapping(name = "Customer.toCustResultMapping", classes = {
		@ConstructorResult(targetClass = Cust.class, columns = { @ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "name", type = String.class),
				@ColumnResult(name = "email", type = String.class) }) })
@NamedNativeQuery(name = "custQuery", resultSetMapping = "Customer.toCustResultMapping", query = "select c.id, c.name, c.email from customer c where c.id =:id")

public class Customer {

	@Id
	private Long id;
	private Date createdDate;
	private String email;
	private String name;

	public Customer() {
	}

	public Customer(Long id, Date createdDate, String email, String name) {
		this.id = id;
		this.createdDate = createdDate;
		this.email = email;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", createdDate=" + createdDate + ", email=" + email + ", name=" + name + "]";
	}

}
