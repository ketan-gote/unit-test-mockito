package com.unittest.repo;

import java.util.ArrayList;
import java.util.List;

import com.unittest.entities.Employee;

public class EmployeeData {

	public List<Employee> findAll_HardCoded() {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Ketan","Gote"));
		employees.add(new Employee("Naitik","Gote"));
		employees.add(new Employee("Rekha","Gote"));
		return employees;
	}
}
