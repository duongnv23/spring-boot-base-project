package com.duongnv.spring.service.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SMSService implements MessagingService {

	public enum SMSTemplate implements MessageTemplate {
		OTP
	};

	final Logger LOGGER = LogManager.getFormatterLogger(SMSService.class);

	@Override
	public String loadTemplate(MessageTemplate template) {
		LOGGER.info("load template for %s" + template);
		return "template for: " + template;
	}

	@Override
	public void send(Object message) {
		LOGGER.info("sending message: " + message);
	}

}
