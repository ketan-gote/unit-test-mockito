package com.unittest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.unittest.entities.Employee;
import com.unittest.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService empSvc;
	
	@Test
	public void getEmployee_Test() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/emp/")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"firstName\": \"Ketan\",\"lastName\":\"Gote\"}")).andReturn();
		
	}
	
	@Test
	public void getEmployee_JsonAssert_Strict_Test() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/emp/")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String exceptedJson = "{\"firstName\": \"Ketan\"}";
		
		JSONAssert.assertEquals(exceptedJson, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void getHardCodedEmployee_From_Service_Test() throws Exception {

		when(empSvc.getEmployee()).thenReturn(new Employee("Ketan","Gote"));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/emp/hc")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{firstName: Ketan,lastName:Gote}")).andReturn();
		
	}
	
	@Test
	public void getAllEmployee_From_Service_Test() throws Exception {

		when(empSvc.getAllEmployees()).thenReturn(Arrays.asList(new Employee("Ketan","Gote"),new Employee("Chetan","Gote")));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/emp/all")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{firstName: Ketan,lastName:Gote},{firstName: Chetan,lastName:Gote}]")).andReturn();
		
	}
	
	
	public void save_Employee_Test() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/emp/save")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.content("{\"id\":10006,  \"firstName\": \"Ketan\",\"lastName\":\"Gote\"}")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().contentType("application/json"))
							.andReturn(); 

		
	}
}
