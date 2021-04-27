package com.example.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployees();
	}
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id){
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee e) {
		employeeService.addEmployee(e);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/employee/{id}")
	public void updateEmployee(@RequestBody Employee e,@PathVariable String id) {
		employeeService.updateEmployee(e, id);
	}
}
