package com.duongnv.spring.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSecurityConfigurationTest {

	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void test() {
		System.out.println(encoder.encode("123456a@"));
		System.out.println(encoder.encode("123456a@123456a@123456a@123456a@123456a@").length());
		System.out.println(encoder.encode("123123123123123123"));
		System.out.println(encoder.encode("abcdasef@123sadw23@#$"));
	}

}
