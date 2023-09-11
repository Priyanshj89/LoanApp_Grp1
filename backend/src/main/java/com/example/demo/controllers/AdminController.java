package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.EmployeeRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
    private AdminRepository adminRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/add")
	public String addHello() {
		return "Hello";
	}
	
	@PostMapping("/adduser")
	public Admin addAddmin(@RequestBody Admin admin) {
		boolean ifExists =adminRepo.existsById(admin.getAdmin_id());
		// User already exists check
		if (!ifExists)
			return adminRepo.save(admin);
		else
		{
			Admin tempAdmin=adminRepo.findById(admin.getAdmin_id()).get();
			return tempAdmin;
		}
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody Admin admin) {
		Admin tempAdmin=adminRepo.getReferenceById(admin.getAdmin_id());
		if(tempAdmin.getPassword().equals(admin.getPassword()))
			return "success";
		else
			return "failure";
	}
	
	@PutMapping("/updatePass")
	public String forgotPassword(@RequestBody Admin admin)
	{
		Admin tempAdmin=adminRepo.getReferenceById(admin.getAdmin_id());
		if(tempAdmin.getName().equals(admin.getName()))
		{
		tempAdmin.setPassword(admin.getPassword());
		adminRepo.save(tempAdmin);
		return "Updated";
		}
		else {
		return "Validation failed";
		}
	}
	
	@PostMapping("/addCustomer")
	public Employee addCustomer(@RequestBody Employee employee) {
		boolean ifExists=empRepo.existsById(employee.getEmployee_id());
		if(ifExists)
		{
			Employee tempEmp=empRepo.getReferenceById(employee.getEmployee_id());
			return tempEmp;
		}
		else {
			return empRepo.save(employee);
		}
	}
}
