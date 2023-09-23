package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface EmployeeServiceInt {
	List<Employee> getAllEmp()  throws NoDataFoundException ;
	Employee getOneEmp(String id) throws NoDataFoundException ;
	 String deleteEmp(String id)  throws ResourceNotFoundException ;
	 String updateEmployee(Employee emp);
	 String login(Employee emp);
	 String forgotPass(Employee emp);

}
