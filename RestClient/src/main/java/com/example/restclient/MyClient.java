package com.example.restclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.restclient.employee.Employee;
import com.example.restclient.employee.EmployeeService;

public class MyClient {
	
	public static void main(String[] args) {
		
		EmployeeService employeeService = new EmployeeService();
		
		
		
		//Get all Employees Service
		List<Employee> list  = employeeService.getEmployees();
		System.out.println("All Employee Details");
		System.out.println("*********************");
		list.forEach(emp -> {
			System.out.println("Employee Name:"+emp.getEmpName());
			System.out.println("Employee ID:"+ emp.getEmpId());
			System.out.println("Employee Title:"+emp.getTitle());
			System.out.println("Employee Salary:"+emp.getSalary());
			System.out.println("********************************");
		});
		
		
		//Get Employee with id = 1
		Employee e = employeeService.getEmployeeById("1");
		System.out.println("Employee Details");
		System.out.println("*****************");
		
		System.out.println("Employee Name:"+ e.getEmpName());
		System.out.println("Employee ID:"+ e.getEmpId());
		System.out.println("Employee Title:"+ e.getTitle());
		System.out.println("Employee Salary:"+ e.getSalary());
		
		//Add Employee
		Employee emp = new Employee("5","Jones","Architect",74000.00);
		employeeService.addEmployee(emp);
		
		//Get Employee with id = 5
		Employee e1 = employeeService.getEmployeeById("5");
		System.out.println("Employee Details");
		System.out.println("*****************");
				
		System.out.println("Employee Name:"+ e1.getEmpName());
		System.out.println("Employee ID:"+ e1.getEmpId());
		System.out.println("Employee Title:"+ e1.getTitle());
		System.out.println("Employee Salary:"+ e1.getSalary());	
				
				
		//Update Employee with id =5
		Employee emp1 = new Employee("5","Ben Jones","Sr Architect",74000.00);
		employeeService.updateEmployee(emp1, "5");
		//Get Employee with id = 5
		Employee e2 = employeeService.getEmployeeById("5");
		System.out.println("Employee Details");
		System.out.println("*****************");
		
		System.out.println("Employee Name:"+ e2.getEmpName());
		System.out.println("Employee ID:"+ e2.getEmpId());
		System.out.println("Employee Title:"+ e2.getTitle());
		System.out.println("Employee Salary:"+ e2.getSalary());	
		
		
		//Delete Employee wiht id = 5
		employeeService.deleteEmployee("5");
		//Get all Employees Service
		List<Employee> list1  = employeeService.getEmployees();
		System.out.println("All Employee Details");
		System.out.println("*********************");
		list1.forEach(emp2 -> {
		System.out.println("Employee Name:"+emp2.getEmpName());
		System.out.println("Employee ID:"+ emp2.getEmpId());
		System.out.println("Employee Title:"+emp2.getTitle());
		System.out.println("Employee Salary:"+emp2.getSalary());
		System.out.println("********************************");
		});
		
	}

}
