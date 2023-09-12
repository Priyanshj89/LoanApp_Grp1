package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@GetMapping("/allEmployees")
	public List<Employee> allEmployees(){
		return empRepo.findAll();
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody Employee emp) {
		try {
			Employee tempEmp=empRepo.getReferenceById(emp.getEmployee_id());
			if(tempEmp.getPassword().equals(emp.getPassword()))
				return "success";
			else
				return "failure";
		}
		catch (jakarta.persistence.EntityNotFoundException e) 
		{
			return "User Does not Exist";
		}

	}
	
	@PutMapping("/updatePass")
	public String forgotPassword(@RequestBody Employee emp)
	{
		try {
		Employee tempEmp=empRepo.getReferenceById(emp.getEmployee_id());
		if(tempEmp.getName().equals(emp.getName()))
		{
		tempEmp.setPassword(emp.getPassword());
		empRepo.save(tempEmp);
		return "Updated";
		}
		else {
		return "Validation failed";
		}
		}
		catch (jakarta.persistence.EntityNotFoundException e) 
		{
			return "User Does not Exist";
		}
	}

}
