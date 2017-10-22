package com.duongnv.spring.service.customer;

import org.springframework.stereotype.Service;

@Service
public class PersonalRegisterTempServiceImpl implements PersonalRegisterTempService {

	@Override
	public void saveRegisterTemp() {

		LOGGER.info("save personal register Temp");
	}

}
