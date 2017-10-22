package com.duongnv.spring.service.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public interface OtpService {
	final Logger logger = LogManager.getFormatterLogger(OtpService.class);

	String generateOtp();

	boolean validateOtp(Long Id, String otp);

}
