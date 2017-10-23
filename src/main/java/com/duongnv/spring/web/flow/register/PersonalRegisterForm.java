package com.duongnv.spring.web.flow.register;

public class PersonalRegisterForm {

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

}
