package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {
	
	@Qualifier("employeeV2ServiceImp")
	@Autowired	
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public Employee save(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}
