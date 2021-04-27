package com.example.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
		@Autowired
		EmployeeReposity repo;
//	List<Employee> employeeList = new ArrayList<Employee>(Arrays.asList(new Employee("1", "Tom", "Manager", 150000.00),
//			new Employee("2", "John", "Developer", 90000.00), new Employee("3", "David", "Specialist", 100000.00),
//			new Employee("4", "Henry", "Developer", 90000.00)));

	public List<Employee> getEmployees() {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		 repo.findAll().forEach(employeeList::add);
		 return employeeList;
	}

	public Optional<Employee> getEmployeeById(String id) {
		return repo.findById(id);	
	}

	public void addEmployee(Employee e) {
		repo.save(e);
	}

	public void deleteEmployee(String id) {
		repo.deleteById(id);
	}

	public void updateEmployee(Employee e, String id) {
		
		repo.save(e);

	}
}
