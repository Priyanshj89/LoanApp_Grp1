package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empServ;
	
	
	@GetMapping("/allEmployees")
	public List<Employee> allEmployees() throws NoDataFoundException {
		return empServ.getAllEmp();
	}
	
	@GetMapping("/{id}")
	public Employee getOneEmp(@PathVariable String id) throws NoDataFoundException {
		return empServ.getOneEmp(id);
	}

	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id)  throws ResourceNotFoundException {
		return empServ.deleteEmp(id);
	}
	
	@PutMapping("/edit")
	public String updateEmp(@RequestBody Employee emp) {
		return empServ.updateEmployee(emp);
		
	 
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody Employee emp) {
		return empServ.login(emp);

	}
	
	@PutMapping("/updatePass")
	public String forgotPassword(@RequestBody Employee emp)
	{
		return empServ.forgotPass(emp);
	}

}
