package com.example.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String empId;
	private String empName;
	private String title;
	private Double salary;
	
	public Employee() {
		
	}
	public Employee(String empId,String empName,String title,Double salary) {
		this.empId = empId;
		this.empName = empName;
		this.title = title;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}


}
