package com.duongnv.spring.service.customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface PersonalRegisterTempService {

	final Logger LOGGER = LogManager.getFormatterLogger(PersonalRegisterTempService.class);

	void saveRegisterTemp();

}
