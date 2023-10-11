package com.Employee.Employee.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Employee.application.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
