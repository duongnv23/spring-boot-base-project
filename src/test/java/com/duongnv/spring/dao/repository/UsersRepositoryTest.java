package com.duongnv.spring.dao.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.duongnv.spring.dao.entity.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository repository;

	@Test
	public void test() {
		Users user = repository.findActiveUser("user");
		System.out.println(user);
	}

}
