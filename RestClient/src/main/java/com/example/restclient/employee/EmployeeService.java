package com.example.restclient.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EmployeeService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public List<Employee> getEmployees() {
		
		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
				
				"http://localhost:8080/employee", HttpMethod.GET,null,new ParameterizedTypeReference<List<Employee>>() {});
		
		List<Employee> employeeList = responseEntity.getBody();
		 return employeeList;
	}

	public Employee getEmployeeById(String id) {
		return restTemplate.getForObject("http://localhost:8080/employee/" + id, Employee.class);
	}

	public void addEmployee(Employee e) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(e,headers);
		
		restTemplate.exchange("http://localhost:8080/employee", HttpMethod.POST, entity, Employee.class);
		
	}

	public void deleteEmployee(String id) {
		
		restTemplate.delete("http://localhost:8080/employee/"+id);
	}

	public void updateEmployee(Employee e, String id) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(e,headers);
		
		restTemplate.exchange("http://localhost:8080/employee/"+ id, HttpMethod.PUT, entity, Employee.class);
		

	}

}
