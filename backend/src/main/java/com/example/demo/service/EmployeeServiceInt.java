package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeServiceInt {
	List<Employee> getAllEmp();
	Employee getOneEmp(String id);
	 String deleteEmp(String id);
	 String updateEmployee(Employee emp);
	 String login(Employee emp);
	 String forgotPass(Employee emp);

}
