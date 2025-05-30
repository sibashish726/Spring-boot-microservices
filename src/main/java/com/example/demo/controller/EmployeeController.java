package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
   
   @Qualifier("employeeServiceImp")
   @Autowired	
   private EmployeeService employeeService;
   
   @PostMapping
   public Employee saveEmployee(@RequestBody Employee employee) {
	   return employeeService.saveEmployee(employee);
   }
   
   @GetMapping("/getAllEmp") 
   public List<Employee> getAllEmployee(){
	   return employeeService.getAllEmployees();
	   
   }
   
   @GetMapping("/getEmpById/{id}")
   public Employee getEmployeeById(@PathVariable String id) {
	   return employeeService.getEmployeeById(id);
   }
   
   @DeleteMapping("/deleteEmpById/{id}")
   public String deleteEmployeeById(@PathVariable String id) {
	return employeeService.deleteEmployeeById(id);
	   
   }
}
