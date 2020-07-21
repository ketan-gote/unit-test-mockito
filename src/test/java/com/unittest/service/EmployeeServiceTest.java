package com.unittest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unittest.entities.Employee;
import com.unittest.repo.EmployeeData;
import com.unittest.repo.EmployeeRepo;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService empSvc;
	
	@Mock
	EmployeeData empData;
 
	@Mock
	private EmployeeRepo employeeRepo;
	
	@Test
	public void countOfEmployees_Test() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Ketan", "Gote"));

		when(empData.findAll_HardCoded()).thenReturn(employees);
		assertEquals(1, empSvc.countOfEmployees());
	}
	
	@Test
	public void findall_Test() {

		when(employeeRepo.findAll()).thenReturn(Arrays.asList(new Employee("Ketan","Gote"),new Employee("Chetan","Gote")));

		List<Employee> employees = empSvc.getAllEmployees();
		System.out.println("employees.get(0).getFullName()-----"+employees.get(0).getFullName());
		assertEquals("Ketan Gote", employees.get(0).getFullName());
	}
}
