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
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
    private AdminService adminServ;	
	
	@PostMapping("/adduser")
	public Admin addAddmin(@RequestBody Admin admin) {
		return adminServ.addAdmin(admin);
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody Admin admin) {
		return adminServ.login(admin);
	}
	
	@PutMapping("/updatePass")
	public String forgotPassword(@RequestBody Admin admin)
	{
		return adminServ.forgotPass(admin);
	}
	
	@PostMapping("/addCustomer")
	public Employee addCustomer(@RequestBody Employee employee) {
		return adminServ.addCustomer(employee);
	}
}
