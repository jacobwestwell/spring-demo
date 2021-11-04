package com.concept.concept;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ConceptApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getDate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/date")).andReturn();
	}

}
