package vn.vimo.core.web.rest.journal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.duongnv.spring.web.rest.journal.JournalRestPostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
// @RestClientTest
// @WebMvcTest(value = {JournalRestController.class,
// VimoRestControllerAdvice.class}, secure = false)
@TestPropertySource(locations = "classpath:/test.properties")
public class JournalRestControllerTest {

	// @Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// @MockBean
	// private JournalDAOService journalDAOService;

	// @Test
	public void testGet() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/rest/journals").accept(MediaType.APPLICATION_JSON_UTF8)
						.param("page", "1").param("size", "10"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();

		System.out.println(result.getResponse().getStatus());
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	// @Rollback
	public void testCreate() throws Exception {
		JournalRestPostRequest request = new JournalRestPostRequest();
		request.setId(1L);
		request.setTitle("title12312312312 123 123 123 123 123 123");
		request.setSummary("summary");
		request.setPhone("12312312a312");
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/rest/journals").contentType(MediaType.APPLICATION_JSON_UTF8)
						.accept(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(request)))
				// .andExpect(MockMvcResultMatchers.status().isR4xxClientError())
				.andReturn();
		System.out.println(result.getResponse().getStatus());
		System.out.println(result.getResponse().getContentAsString());
	}

}
