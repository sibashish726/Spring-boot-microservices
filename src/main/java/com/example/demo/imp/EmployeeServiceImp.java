package com.example.demo.imp;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	
	List<Employee> empList= new ArrayList<>();
	
	@Override
	public Employee saveEmployee(Employee emp) {
		if(emp.getEmployeeId() == null || emp.getEmployeeId().isEmpty()) {
			emp.setEmployeeId(UUID.randomUUID().toString());
		}
		empList.add(emp);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empList;
	}

	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return (Employee) empList
				          .stream()
				          .filter(employee -> 
				                  employee
				                   .getEmployeeId()
				                   .equals(id))
				                   .findFirst()
				                   .orElseThrow(() -> new RuntimeException(
				                		   ""+"Employee not found with "+ id));
	}

	@Override
	public String deleteEmployeeById(String id) {
		empList.remove(empList.stream().filter(e -> e.getEmployeeId().equalsIgnoreCase(id)).findFirst().get());
		return "Employee deteled with id "+id;
	}

	

}
