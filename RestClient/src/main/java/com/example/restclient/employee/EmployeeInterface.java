package com.example.restclient.employee;

import java.util.List;

public interface EmployeeInterface {

	List<Employee> getEmployees();

	Employee getEmployeeById(String id);

	void addEmployee(Employee e);

	void deleteEmployee(String id);

	void updateEmployee(Employee e, String id);
}