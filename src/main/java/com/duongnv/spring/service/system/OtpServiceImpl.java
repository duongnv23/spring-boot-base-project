package com.duongnv.spring.service.system;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class OtpServiceImpl implements OtpService {

	@Override
	public String generateOtp() {
		return "" + RandomUtils.nextInt(100000, 1000000);
	}

	@Override
	public boolean validateOtp(Long Id, String otp) {
		return RandomUtils.nextInt(0, 2) == 1;
	}

}
