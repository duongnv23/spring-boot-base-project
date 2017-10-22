package com.duongnv.spring.service.system;

public interface MessagingService {

	String loadTemplate(MessageTemplate template);

	void send(Object message);


}
