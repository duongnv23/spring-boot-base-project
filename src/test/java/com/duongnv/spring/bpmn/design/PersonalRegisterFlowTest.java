package com.duongnv.spring.bpmn.design;

import static org.junit.Assert.*;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalRegisterFlowTest {


	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Test
	@Deployment(resources= {"classpath:processes/Register-Personal.bpmn"})
	public void testSuccessFlow() {

	}
}
