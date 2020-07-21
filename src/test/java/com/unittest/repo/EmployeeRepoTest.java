package com.unittest.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.unittest.entities.Employee;

@DataJpaTest
public class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Test
	public void findAll_Test(){
		List<Employee> employees = employeeRepo.findAll();
		
		assertEquals(3, employees.size());
	}
}
