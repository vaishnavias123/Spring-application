package com.Employee.Employee.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.application.entity.Employee;
import com.Employee.Employee.application.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository repo;
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		List<Employee> employees=repo.findAll();
		return employees;
	}
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
    	Employee employee=repo.findById(id).get();
    	return employee;
    }
    @PostMapping("/employees/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee employee)
    {
    	repo.save(employee);
    }
    @PutMapping("/employees/update/{id}")
    public Employee updateEmployee(@PathVariable int id)
    {
    	Employee employee=repo.findById(id).get();
    	employee.setName("raj");
    	employee.setPhoneno(3847392);
    	employee.setEmail("raj@gmail.com");
    	repo.save(employee);
    	return employee;
    }
    @DeleteMapping("/employees/delete/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
    	Employee employee=repo.findById(id).get();
    	repo.delete(employee);
    	
    }
}
