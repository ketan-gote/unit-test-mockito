package com.unittest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittest.controller.HelloWorldController;


@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_Test() throws Exception{
		
		RequestBuilder request = MockMvcRequestBuilders
								.get("/api/v1/hello/")
								.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().string("Hello World"))
									.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}
}
