package com.unittest.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unittest.entities.Employee;
import com.unittest.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empSvc;

	@GetMapping("/")
	public Employee getEmployee() {
		return new Employee("Ketan", "Gote");
	}

	@GetMapping("/hc")
	public Employee getHardecodedEmployeeFromService() {
		return empSvc.getEmployee();
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		List<Employee> employees = empSvc.getAllEmployees();
		return employees;
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee emp) {
		empSvc.save(emp);
		return new ResponseEntity<>("Record saved",HttpStatus.OK);
	}
}
