package com.unittest.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unittest.entities.Employee;
import com.unittest.repo.EmployeeData;
import com.unittest.repo.EmployeeRepo;

@Component
public class EmployeeService {

	private EmployeeData employeeData;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	
	public void setEmployeeRepo(EmployeeData empRepo){
		this.employeeData = empRepo;
	}
	
	public Integer countOfEmployees(){
		return this.employeeData.findAll_HardCoded().size();
	}
	
	public Employee getEmployee(){
		return new Employee("Ketan","Gote");
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = empRepo.findAll();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			employee.setFullName(employee.getFirstName() +" "+employee.getLastName());
		}
		return employees;
	}
	
	public void save(Employee employee){
		empRepo.save(employee);
	}
}
