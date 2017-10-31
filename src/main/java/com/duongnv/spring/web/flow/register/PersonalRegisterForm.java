package com.duongnv.spring.web.flow.register;

import java.io.Serializable;

public class PersonalRegisterForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -219347059053368161L;

	private String customerName;
	private String phoneNumber;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String fullname) {
		this.customerName = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PersonalRegisterForm [customerName=" + customerName + ", phoneNumber=" + phoneNumber + "]";
	}

}
