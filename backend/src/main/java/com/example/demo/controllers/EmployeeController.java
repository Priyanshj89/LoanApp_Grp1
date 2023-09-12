package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{id}")
	public Optional<Employee> getOneEmp(@PathVariable String id) {
		Optional<Employee> tempEmp= empRepo.findById(id);
		return tempEmp;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id) {
		boolean ifExists=empRepo.existsById(id);
		if(ifExists) {
			empRepo.deleteById(id);
			return "Deleted from db";
		}
		
		return "error";
	}
	
	@PutMapping("/edit")
	public Employee updateEmp(@RequestBody Employee emp) {
		boolean ifExists=empRepo.existsById(emp.getEmployee_id());
			return empRepo.save(emp);
		
	 
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody Employee emp) {
		Employee tempEmp=empRepo.getReferenceById(emp.getEmployee_id());
		if(tempEmp.getPassword().equals(emp.getPassword()))
			return "success";
		else
			return "failure";
	}
	
	@PutMapping("/updatePass")
	public String forgotPassword(@RequestBody Employee emp)
	{
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

}
