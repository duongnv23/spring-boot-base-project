package vn.vimo.core.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.duongnv.spring.dao.entity.Customer;
import com.duongnv.spring.service.customer.Cust;
import com.duongnv.spring.service.customer.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService service;

	// @Test
	public void testCallPlus1Procedure() {
		Long arg = 100L;
		Long value = 100L;

		for (int i = 0; i < 3; i++) {
			arg = value;
			value = service.callPlus1Procedure(arg);
			assertTrue(value.equals(arg + 1L));
		}
	}

	// @Test
	public void testCallSearchCustomerProcedure() {
		List<Customer> list = service.callSearchCustomerProcedure("est", "");
		System.out.println(list != null ? list.size() : "damn it");
		assertTrue(!list.isEmpty());
	}

//	@Test
	public void testFindById() {
		Cust customer = service.findById(1L);
		System.out.println(customer);
		assertNotNull(customer);
	}

}
