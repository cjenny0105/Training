package com.example.employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeReposity extends CrudRepository<Employee, String> {

}
